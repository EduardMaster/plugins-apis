package me.wiljafor1.rpg.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.security.CodeSource;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.bukkit.util.Vector;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.Maps;

import me.wiljafor1.rpg.Main;

public class SimpleAPI {

	public static class SimpleItem implements Listener {
		public static HashMap<ItemStack, ItemAction> actions = Maps.newHashMap();
		public static HashMap<ItemStack, Runnable> guiitem = Maps.newHashMap();

		@EventHandler
		public void onClick(PlayerInteractEvent e) {

			Player p = e.getPlayer();
			if (p.getItemInHand() == null)
				return;
			else if (!p.getItemInHand().hasItemMeta())
				return;
			else if (!actions.containsKey(p.getItemInHand()))
				return;
			else {
				ItemStack i = p.getItemInHand();
				if (e.getAction().name().contains(actions.get(i).getAction())) {
					if (actions.get(i).getRunnable() != null) {
						actions.get(i).getRunnable().run();
					}
				}
			}
		}

		@EventHandler
		public void onClickInventory(InventoryClickEvent e) {
			Player p = (Player) e.getWhoClicked();
			ItemStack i = e.getCurrentItem();
			if (guiitem.containsKey(i)) {
				e.setCancelled(true);
				guiitem.get(i).run();
			}
		}

		public static ItemStack createInteractItem(ItemStack item, String clickAction, Runnable onClick) {
			actions.put(item, new ItemAction(clickAction, onClick));
			return item;
		}

		public static ItemStack createInteractItem(Material material, String displayName, int data, int amount,
				String[] lore, String clickAction, Runnable onClick) {
			ItemStack item = ItemAPI.newItem(material, displayName, amount, data, lore);

			actions.put(item, new ItemAction(clickAction, onClick));
			return item;
		}

		public static ItemStack createInventoryItem(Material material, String displayName, int data, int amount,
				String[] lore, Runnable onClick) {
			ItemStack item = ItemAPI.newItem(material, displayName, amount, data, lore);
			guiitem.put(item, onClick);
			return item;
		}

		public static ItemStack createInventoryItem(ItemStack item, Runnable onClick) {
			guiitem.put(item, onClick);
			return item;
		}

		public static ItemStack getNamedSkull(String nick, String nome, String[] lore) {
			@SuppressWarnings("deprecation")
			ItemStack skull = new ItemStack(397, 1, (short) 3);
			SkullMeta meta = (SkullMeta) skull.getItemMeta();
			meta.setDisplayName(nome);
			meta.setLore(Arrays.asList(lore));
			meta.setOwner(nick);
			skull.setItemMeta(meta);

			return skull;
		}

		public static ItemStack createItem(Material material, int data, int amount, String display, String... lore) {
			return ItemAPI.newItem(material, display, amount, data, lore);
		}

		public static class ItemAction {
			private String action;
			private Runnable runnable;

			public ItemAction(String action, Runnable runnable) {
				this.action = action;
				this.runnable = runnable;
			}

			public String getAction() {
				return action;
			}

			public void setAction(String action) {
				this.action = action;
			}

			public Runnable getRunnable() {
				return runnable;
			}

			public void setRunnable(Runnable runnable) {
				this.runnable = runnable;
			}
		}
	}

	public static class SimpleRunnable {
		public static HashMap<String, BukkitTask> RUNDATA = Maps.newHashMap();

		public static enum TaskType {
			ASYNC, SYNC
		}

		public static SimpleRunnable getInstance() {
			return new SimpleRunnable();
		}

		public static Plugin plugin = Main.GetInstance();

		public BukkitTask getTask(String name) {
			return RUNDATA.get(name);
		}

		public void cancel(String name) {
			if (getTask(name) != null) {
				getTask(name).cancel();
			}
		}

		public void cancelAll() {
			for (Entry<String, BukkitTask> set : RUNDATA.entrySet()) {
				String s = set.getKey();
				if (getTask(s) != null) {
					getTask(s).cancel();
				}
			}
		}

		public BukkitTask createTaskTimer(TaskType type, String name, Runnable r, long time, long delay) {
			BukkitTask t = null;
			if (type == TaskType.ASYNC) {
				t = Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, r, time, delay);
			} else {
				t = Bukkit.getScheduler().runTaskTimer(plugin, r, time, delay);
			}
			RUNDATA.put(name, t);
			return t;
		}

		public BukkitTask createTaskLater(TaskType type, String name, Runnable r, long delay) {
			BukkitTask t = null;
			if (type == TaskType.ASYNC) {
				t = Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, r, delay);
			} else {
				t = Bukkit.getScheduler().runTaskLater(plugin, r, delay);
			}
			RUNDATA.put(name, t);
			return t;
		}
	}

	public class SimpleScore {
		private Scoreboard sb;
		private String title;
		private Map<String, Integer> scores;
		private HashMap<Integer, Team> teams;

		public SimpleScore(String title) {
			this.sb = Bukkit.getScoreboardManager().getNewScoreboard();
			this.title = title;
			this.scores = Maps.newLinkedHashMap();
			this.teams = Maps.newLinkedHashMap();
		}

		public void blankLine() {
			add("  ");
		}

		public HashMap<Integer, Team> getTeams() {
			return this.teams;
		}

		public void add(String text) {
			add(text, null);
		}

		public void add(String text, Integer score) {
			Preconditions.checkArgument(text.length() < 48, "text cannot be over 48 characters in length");
			text = fixDuplicates(text);
			this.scores.put(text, score);
		}

		private String fixDuplicates(String text) {
			while (this.scores.containsKey(text)) {
				text = text + "";
			}
			if (text.length() > 48) {
				text = text.substring(0, 47);
			}
			return text;
		}

		int number = 50;

		private Map.Entry<Team, String> createTeam(String text) {
			String result = "";

			Team team = this.sb.registerNewTeam("" + this.number--);
			if (text.length() <= 16) {
				return new AbstractMap.SimpleEntry(team, text);
			}
			Iterator<String> iterator = Splitter.fixedLength(16).split(text).iterator();

			team.setPrefix((String) iterator.next());
			result = (String) iterator.next();

			return new AbstractMap.SimpleEntry(team, result);
		}

		public void build() {
			Objective obj = this.sb
					.registerNewObjective(this.title.length() > 16 ? this.title.substring(0, 15) : this.title, "dummy");

			obj.setDisplayName(this.title);
			obj.setDisplaySlot(DisplaySlot.SIDEBAR);

			int next = this.scores.size() - 2;
			int index = next + 1;
			int par = 0;

			String s = "";
			for (Map.Entry<String, Integer> text : this.scores.entrySet()) {
				par += 5;
				s = s + ChatColor.getLastColors((String) text.getKey());

				Map.Entry<Team, String> team = createTeam((String) text.getKey());

				Integer score = Integer
						.valueOf(text.getValue() != null ? ((Integer) text.getValue()).intValue() : index);

				UtilitiesScoreOfflinePlayer player = new UtilitiesScoreOfflinePlayer(s);
				((Team) team.getKey()).setSuffix((String) team.getValue());
				((Team) team.getKey()).addPlayer(player);

				obj.getScore(player).setScore(score.intValue());

				this.teams.put(Integer.valueOf(index), (Team) team.getKey());

				index--;
			}
		}

		public void reset() {
			this.title = null;
			this.scores.clear();
			for (Team t : this.teams.values()) {
				t.unregister();
			}
			this.teams.clear();
		}

		public Scoreboard getScoreBoard() {
			return this.sb;
		}

		public void send(Player... players) {
			Player[] arrayOfPlayer;
			int j = (arrayOfPlayer = players).length;
			for (int i = 0; i < j; i++) {
				Player p = arrayOfPlayer[i];
				p.setScoreboard(this.sb);
			}
		}

		public void update(String text, Integer score) {
			if (this.teams.containsKey(score)) {
				Team team = (Team) this.teams.get(score);
				if (text.length() <= 16) {
					team.setSuffix(text);
					team.setPrefix("");
					return;
				}
				Iterator<String> iterator = Splitter.fixedLength(16).split(text).iterator();
				team.setPrefix((String) iterator.next());
				team.setSuffix(ChatColor.getLastColors(team.getPrefix()) + (String) iterator.next());
			}
		}

		private class UtilitiesScoreOfflinePlayer implements OfflinePlayer {
			private final String playerName;

			public UtilitiesScoreOfflinePlayer(String playerName) {
				this.playerName = playerName;
			}

			public boolean isOnline() {
				return false;
			}

			public String getName() {
				return this.playerName;
			}

			public UUID getUniqueId() {
				return UUID.nameUUIDFromBytes(this.playerName.getBytes(Charsets.UTF_8));
			}

			public boolean isBanned() {
				return false;
			}

			public void setBanned(boolean banned) {
				throw new UnsupportedOperationException();
			}

			public boolean isWhitelisted() {
				return false;
			}

			public void setWhitelisted(boolean value) {
				throw new UnsupportedOperationException();
			}

			public Player getPlayer() {
				throw new UnsupportedOperationException();
			}

			public long getFirstPlayed() {
				return System.currentTimeMillis();
			}

			public long getLastPlayed() {
				return System.currentTimeMillis();
			}

			public boolean hasPlayedBefore() {
				return false;
			}

			public Location getBedSpawnLocation() {
				throw new UnsupportedOperationException();
			}

			public boolean isOp() {
				return false;
			}

			public void setOp(boolean value) {
				throw new UnsupportedOperationException();
			}

			public Map<String, Object> serialize() {
				throw new UnsupportedOperationException();
			}
		}
	}

	public class SimpleCuboId implements Cloneable, ConfigurationSerializable, Iterable<Block> {

		protected String worldName;
		protected final Vector minimumPoint, maximumPoint;

		public SimpleCuboId(SimpleCuboId cuboid) {
			this(cuboid.worldName, cuboid.minimumPoint.getX(), cuboid.minimumPoint.getY(), cuboid.minimumPoint.getZ(),
					cuboid.maximumPoint.getX(), cuboid.maximumPoint.getY(), cuboid.maximumPoint.getZ());
		}

		public SimpleCuboId(Location loc) {
			this(loc, loc);
		}

		public SimpleCuboId(Location loc1, Location loc2) {
			if (loc1 != null && loc2 != null) {
				if (loc1.getWorld() != null && loc2.getWorld() != null) {
					if (!loc1.getWorld().getUID().equals(loc2.getWorld().getUID()))
						throw new IllegalStateException("The 2 locations of the cuboid must be in the same world!");
				} else {
					throw new NullPointerException("One/both of the worlds is/are null!");
				}
				this.worldName = loc1.getWorld().getName();

				double xPos1 = Math.min(loc1.getX(), loc2.getX());
				double yPos1 = Math.min(loc1.getY(), loc2.getY());
				double zPos1 = Math.min(loc1.getZ(), loc2.getZ());
				double xPos2 = Math.max(loc1.getX(), loc2.getX());
				double yPos2 = Math.max(loc1.getY(), loc2.getY());
				double zPos2 = Math.max(loc1.getZ(), loc2.getZ());
				this.minimumPoint = new Vector(xPos1, yPos1, zPos1);
				this.maximumPoint = new Vector(xPos2, yPos2, zPos2);
			} else {
				throw new NullPointerException("One/both of the locations is/are null!");
			}
		}

		public SimpleCuboId(String worldName, double x1, double y1, double z1, double x2, double y2, double z2) {
			if (worldName == null || Bukkit.getServer().getWorld(worldName) == null)
				throw new NullPointerException("One/both of the worlds is/are null!");
			this.worldName = worldName;

			double xPos1 = Math.min(x1, x2);
			double xPos2 = Math.max(x1, x2);
			double yPos1 = Math.min(y1, y2);
			double yPos2 = Math.max(y1, y2);
			double zPos1 = Math.min(z1, z2);
			double zPos2 = Math.max(z1, z2);
			this.minimumPoint = new Vector(xPos1, yPos1, zPos1);
			this.maximumPoint = new Vector(xPos2, yPos2, zPos2);
		}

		public boolean containsLocation(Location location) {
			return location != null && location.getWorld().getName().equals(this.worldName)
					&& location.toVector().isInAABB(this.minimumPoint, this.maximumPoint);
		}

		public boolean containsVector(Vector vector) {
			return vector != null && vector.isInAABB(this.minimumPoint, this.maximumPoint);
		}

		public List<Block> getBlocks() {
			List<Block> blockList = new ArrayList<>();
			World world = this.getWorld();
			if (world != null) {
				for (int x = this.minimumPoint.getBlockX(); x <= this.maximumPoint.getBlockX(); x++) {
					for (int y = this.minimumPoint.getBlockY(); y <= this.maximumPoint.getBlockY()
							&& y <= world.getMaxHeight(); y++) {
						for (int z = this.minimumPoint.getBlockZ(); z <= this.maximumPoint.getBlockZ(); z++) {
							blockList.add(world.getBlockAt(x, y, z));
						}
					}
				}
			}
			return blockList;
		}

		public Location getAllLocation() {
			Location p1 = getUpperLocation();
			Location p2 = getLowerLocation();
			Location result = p1.add(p1.subtract(p2).multiply(0.5));

			return result;

		}

		public Location getLowerLocation() {
			return this.minimumPoint.toLocation(this.getWorld());
		}

		public double getLowerX() {
			return this.minimumPoint.getX();
		}

		public double getLowerY() {
			return this.minimumPoint.getY();
		}

		public double getLowerZ() {
			return this.minimumPoint.getZ();
		}

		public Location getUpperLocation() {
			return this.maximumPoint.toLocation(this.getWorld());
		}

		public double getUpperX() {
			return this.maximumPoint.getX();
		}

		public double getUpperY() {
			return this.maximumPoint.getY();
		}

		public double getUpperZ() {
			return this.maximumPoint.getZ();
		}

		public double getVolume() {
			return (this.getUpperX() - this.getLowerX() + 1) * (this.getUpperY() - this.getLowerY() + 1)
					* (this.getUpperZ() - this.getLowerZ() + 1);
		}

		public World getWorld() {
			World world = Bukkit.getServer().getWorld(this.worldName);
			if (world == null)
				throw new NullPointerException("World '" + this.worldName + "' is not loaded.");
			return world;
		}

		public void setWorld(World world) {
			if (world != null)
				this.worldName = world.getName();
			else
				throw new NullPointerException("The world cannot be null.");
		}

		@Override
		public SimpleCuboId clone() {
			return new SimpleCuboId(this);
		}

		@Override
		public ListIterator<Block> iterator() {
			return this.getBlocks().listIterator();
		}

		@Override
		public Map<String, Object> serialize() {
			Map<String, Object> serializedCuboid = new HashMap<>();
			serializedCuboid.put("worldName", this.worldName);
			serializedCuboid.put("x1", this.minimumPoint.getX());
			serializedCuboid.put("x2", this.maximumPoint.getX());
			serializedCuboid.put("y1", this.minimumPoint.getY());
			serializedCuboid.put("y2", this.maximumPoint.getY());
			serializedCuboid.put("z1", this.minimumPoint.getZ());
			serializedCuboid.put("z2", this.maximumPoint.getZ());
			return serializedCuboid;
		}

		public SimpleCuboId deserialize(Map<String, Object> serializedCuboid) {
			try {
				String worldName = (String) serializedCuboid.get("worldName");

				double xPos1 = (Double) serializedCuboid.get("x1");
				double xPos2 = (Double) serializedCuboid.get("x2");
				double yPos1 = (Double) serializedCuboid.get("y1");
				double yPos2 = (Double) serializedCuboid.get("y2");
				double zPos1 = (Double) serializedCuboid.get("z1");
				double zPos2 = (Double) serializedCuboid.get("z2");

				return new SimpleCuboId(worldName, xPos1, yPos1, zPos1, xPos2, yPos2, zPos2);
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			}
		}

	}

	public static class SimpleRegister {
		public static List<Class<?>> getListeners(File file, String packagee) {

			return getPackages(file, packagee).stream().filter(classe -> classe != null)
					.filter(classe -> Listener.class.isAssignableFrom(classe)).collect(Collectors.toList());
		}

		public static Set<Class<?>> getPackages(File file, String name) {
			Set<Class<?>> classes = new HashSet<Class<?>>();
			try {
				JarFile jar = new JarFile(file);
				for (Enumeration<JarEntry> entry = jar.entries(); entry.hasMoreElements();) {
					JarEntry jarEntry = (JarEntry) entry.nextElement();
					String named = jarEntry.getName().replace("/", ".");
					if ((named.startsWith(name)) && (named.endsWith(".class")) && (!named.contains("$"))) {
						classes.add(Class.forName(named.substring(0, named.length() - 6)));
					}
				}
				jar.close();
			} catch (Exception localException) {
			}
			return classes;
		}

		public static void createCommand(Command... cmds) {
			try {
				if ((Bukkit.getServer() instanceof CraftServer)) {
					Field f = CraftServer.class.getDeclaredField("commandMap");
					f.setAccessible(true);

					CommandMap map = (CommandMap) f.get(Bukkit.getServer());
					Command[] arrayOfCommand = cmds;
					int j = cmds.length;
					for (int i = 0; i < j; i++) {
						Command cmd = arrayOfCommand[i];
						map.register("comandos", cmd);
					}
				}
			} catch (Exception localException) {
			}
		}
	}

	public static class Cooldown {

		private static Map<String, Cooldown> cooldowns = new HashMap<String, Cooldown>();
		private long start;
		private final int timeInSeconds;
		private final UUID id;
		private final String cooldownName;

		public Cooldown(UUID id, String cooldownName, int timeInSeconds) {
			this.id = id;
			this.cooldownName = cooldownName;
			this.timeInSeconds = timeInSeconds;
		}

		public boolean isInCooldown(String cooldownName) {
			if (getTimeLeft(cooldownName) >= 1) {
				return true;
			} else {
				stop(id, cooldownName);
				return false;
			}
		}

		private static void stop(UUID id, String cooldownName) {
			Cooldown.cooldowns.remove(id + cooldownName);
		}

		private static Cooldown getCooldown(UUID id, String cooldownName) {
			return cooldowns.get(id.toString() + cooldownName);
		}

		public int getTimeLeft(String cooldownName) {
			Cooldown cooldown = getCooldown(id, cooldownName);
			int f = -1;
			if (cooldown != null) {
				long now = System.currentTimeMillis();
				long cooldownTime = cooldown.start;
				int totalTime = cooldown.timeInSeconds;
				int r = (int) (now - cooldownTime) / 1000;
				f = (r - totalTime) * (-1);
			}
			return f;
		}

		public double getTimeLeftDouble(String cooldownName) {
			Cooldown cooldown = getCooldown(id, cooldownName);
			double f = -1;
			if (cooldown != null) {
				long now = System.currentTimeMillis();
				long cooldownTime = cooldown.start;
				int totalTime = cooldown.timeInSeconds;
				double r = (double) (now - cooldownTime) / 1000;
				f = (r - totalTime) * (-1);
			}
			return f;
		}

		public void start() {
			this.start = System.currentTimeMillis();
			cooldowns.put(this.id.toString() + this.cooldownName, this);
		}

	}

	public static class SimpleRegisterV2 {

		public static ArrayList<Class<?>> getClassesForPackage(JavaPlugin plugin, String pkgname) {
			ArrayList<Class<?>> classes = new ArrayList<Class<?>>();

			CodeSource src = plugin.getClass().getProtectionDomain().getCodeSource();
			if (src != null) {
				URL resource = src.getLocation();
				resource.getPath();
				processJarfile(resource, pkgname, classes);
			}
			ArrayList<String> names = new ArrayList<String>();
			ArrayList<Class<?>> classi = new ArrayList<Class<?>>();
			for (Class<?> classy : classes) {
				names.add(classy.getSimpleName());
				classi.add(classy);
			}
			classes.clear();
			Collections.sort(names, String.CASE_INSENSITIVE_ORDER);
			for (String s : names)
				for (Class<?> classy : classi) {
					if (classy.getSimpleName().equals(s)) {
						classes.add(classy);
						break;
					}
				}
			return classes;
		}

		private static Class<?> loadClass(String className) {
			try {
				return Class.forName(className);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("ERRO AO CARREGAR  '" + className + "'");
			}
		}

		private static void processJarfile(URL resource, String pkgname, ArrayList<Class<?>> classes) {
			String relPath = pkgname.replace('.', '/');
			String resPath = resource.getPath().replace("%20", " ");
			String jarPath = resPath.replaceFirst("[.]jar[!].*", ".jar").replaceFirst("file:", "");
			JarFile jarFile;
			try {
				jarFile = new JarFile(jarPath);
			} catch (IOException e) {
				throw new RuntimeException("nao foi encontrado o jar  '" + jarPath + "'", e);
			}
			Enumeration<JarEntry> entries = jarFile.entries();
			while (entries.hasMoreElements()) {
				JarEntry entry = entries.nextElement();
				String entryName = entry.getName();
				String className = null;
				if (entryName.endsWith(".class") && entryName.startsWith(relPath)
						&& entryName.length() > (relPath.length() + "/".length())) {
					className = entryName.replace('/', '.').replace('\\', '.').replace(".class", "");
				}
				if (className != null) {
					classes.add(loadClass(className));
				}
			}
		}

		public static void createCommand(Command... cmds) {
			try {
				if ((Bukkit.getServer() instanceof CraftServer)) {
					Field f = CraftServer.class.getDeclaredField("commandMap");
					f.setAccessible(true);

					CommandMap map = (CommandMap) f.get(Bukkit.getServer());
					Command[] arrayOfCommand = cmds;
					int j = cmds.length;
					for (int i = 0; i < j; i++) {
						Command cmd = arrayOfCommand[i];
						map.register("comandos", cmd);
					}
				}
			} catch (Exception localException) {
			}
		}
	}

	public static class SimpleItemC {
		private ItemStack a;
		private boolean c;

		public SimpleItemC(Material material) {
			this.a = new ItemStack(material, 1);
			this.c = false;
		}

		public SimpleItemC(int materialId) {
			this.a = new ItemStack(Material.getMaterial(materialId), 1);
			this.c = false;
		}

		public SimpleItemC(ItemStack itemStack) {
			this.a = itemStack.clone();
			this.c = false;
		}

		public SimpleItemC setName(String name) {
			ItemMeta meta = this.a.getItemMeta();
			meta.setDisplayName(name);
			this.a.setItemMeta(meta);
			return this;
		}

		public SimpleItemC setAmount(int amount) {
			this.a.setAmount(amount);
			return this;
		}

		public int getAmount() {
			return this.a.getAmount();
		}

		public SimpleItemC setDurability(int durability) {
			this.a.setDurability((short) durability);
			return this;
		}

		public int getDurability() {
			return this.a.getDurability();
		}

		public SimpleItemC setData(int data) {
			this.a.setData(new MaterialData(this.a.getType(), (byte) data));
			return this;
		}

		public int getData() {
			return this.a.getData().getData();
		}

		public SimpleItemC setLore(String[] lore) {
			if ((lore == null) || (lore.length == 0)) {
				clearLore();
			}
			ArrayList lr = new ArrayList();
			for (int i = 0; i < lore.length; i++) {
				if (lore[i].contains("\n")) {
					for (String s : lore[i].split("\n"))
						lr.add(s.replaceAll("&", "§"));
				} else {
					lr.add(lore[i].replaceAll("&", "§"));
				}
			}
			ItemMeta meta = a.getItemMeta();
			meta.setLore(lr);
			a.setItemMeta(meta);
			return this;
		}

		public SimpleItemC SimpleItemCaddLore(String[] lore) {
			ItemMeta meta = this.a.getItemMeta();
			List original_lore = meta.getLore();
			if (original_lore == null)
				meta.setLore(new ArrayList());
			for (String s : lore)
				original_lore.add(s);
			meta.setLore(original_lore);
			this.a.setItemMeta(meta);
			return this;
		}

		public List<String> getLore() {
			return this.a.getItemMeta().getLore();
		}

		public SimpleItemC clearLore() {
			ItemMeta meta = this.a.getItemMeta();
			meta.setLore(new ArrayList());
			this.a.setItemMeta(meta);
			return this;
		}

		public SimpleItemC addEnchantment(Enchantment enchantment) {
			this.a.addUnsafeEnchantment(enchantment, 0);
			return this;
		}

		public SimpleItemC addEnchantment(Enchantment enchantment, int level) {
			this.a.addUnsafeEnchantment(enchantment, level);
			return this;
		}

		public SimpleItemC addEnchantments(Enchantment[] enchantments, int[] levels) {
			for (int i = 0; i < enchantments.length; i++)
				this.a.addUnsafeEnchantment(enchantments[i], levels[i]);
			return this;
		}

		public SimpleItemC removeEnchantments() {
			Enchantment[] enchantments = getEnchantments();
			for (int i = 0; i < enchantments.length; i++)
				this.a.removeEnchantment(enchantments[i]);
			return this;
		}

		public Enchantment[] getEnchantments() {
			return (Enchantment[]) this.a.getEnchantments().keySet()
					.toArray(new Enchantment[this.a.getEnchantments().keySet().size()]);
		}

		public Map<Enchantment, Integer> getDetailedEnchantments() {
			return this.a.getEnchantments();
		}

		public SimpleItemC setType(Material material) {
			this.a.setType(material);
			return this;
		}

		public Material getType() {
			return this.a.getType();
		}

		public SimpleItemC setType(int materialId) {
			this.a.setTypeId(materialId);
			return this;
		}

		public SimpleItemC setArmorColor(Color color) {
			if ((this.a.getType().equals(Material.LEATHER_HELMET))
					|| (this.a.getType().equals(Material.LEATHER_CHESTPLATE))
					|| (this.a.getType().equals(Material.LEATHER_LEGGINGS))
					|| (this.a.getType().equals(Material.LEATHER_BOOTS))) {
				LeatherArmorMeta meta = (LeatherArmorMeta) this.a.getItemMeta();
				meta.setColor(color);
				this.a.setItemMeta(meta);
			}
			return this;
		}

		public SimpleItemC setSkullOwner(String playerName) {
			if (this.a.getType().equals(Material.SKULL_ITEM)) {
				setData(3);
				SkullMeta meta = (SkullMeta) this.a.getItemMeta();
				meta.setOwner(playerName);
				this.a.setItemMeta(meta);
			}
			return this;
		}

		public SimpleItemC clone() {
			return new SimpleItemC(this.a);
		}

		public String toString() {
			return this.a.toString();
		}

		public ItemStack build() {
			return this.a;
		}

		public Item spawn(Location l) {
			return l.getWorld().dropItem(l, this.a);
		}

		public static boolean equals(ItemStack item1, ItemStack item2) {
			return item1.isSimilar(item2);
		}

		public static ItemStack addLore(ItemStack itemStack, String[] toAdd) {
			ItemMeta meta = itemStack.getItemMeta();
			List lore = meta.hasLore() ? meta.getLore() : new ArrayList();
			for (String s : toAdd)
				lore.add(s.replaceAll("&", "§"));
			meta.setLore(lore);
			itemStack.setItemMeta(meta);
			return itemStack;
		}

		public static String getValueFromLore(ItemStack itemStack, String key) {
			return getValueFromLore(itemStack, key, ":", true);
		}

		public static String getValueFromLore(ItemStack itemStack, String key, String separator, boolean trim) {
			if (!itemStack.hasItemMeta())
				return null;
			if (!itemStack.getItemMeta().hasLore())
				return null;
			String s = null;
			List lore = new ArrayList(itemStack.getItemMeta().getLore());
			for (int i = 0; i < lore.size(); i++)
				if (((String) lore.get(i)).contains(key))
					s = (String) lore.get(i);
			if (s == null)
				return null;
			String[] args = s.split(separator);
			return trim ? args[1].trim() : args[1];
		}
	}

}
