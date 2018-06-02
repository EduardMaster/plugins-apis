package me.recenthg.Manager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Difficulty;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;

import me.recenthg.Main;
import me.recenthg.CMDS.Admin;
import me.recenthg.CMDS.SC;
import me.recenthg.Kits.Surprise;
import me.recenthg.Tempo.Iniciando;
import me.recenthg.Tempo.Invencibilidade;
import me.recenthg.Tempo.StringTimer;
import me.recenthg.Utils.Estado;

@SuppressWarnings("deprecation")
public class Listeners implements Listener {

	public static ArrayList<Block> BlocosForcefield = new ArrayList<Block>();

	public static ArrayList<Block> Jogadores = new ArrayList<Block>();
	public static Boolean Venceu = Boolean.valueOf(false);

	public static ArrayList<Player> chat = new ArrayList<Player>();
	public static String getMod;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Map<String, Long> timeout = new HashMap();

	public static HashMap<String, Integer> kills = new HashMap<String, Integer>();
	public static HashMap<String, Integer> ks = new HashMap<String, Integer>();

	private boolean First = false;

	ArrayList<String> NoKit = new ArrayList<String>();
	ArrayList<String> NoKit2 = new ArrayList<String>();

	public static String getMod(String name) {
		if (name.length() == 16) {
			String shorts = name.substring(0, name.length() - 4);
			return shorts;
		}
		if (name.length() == 15) {
			String shorts = name.substring(0, name.length() - 3);
			return shorts;
		}
		if (name.length() == 14) {
			String shorts = name.substring(0, name.length() - 2);
			return shorts;
		}
		if (name.length() == 13) {
			String shorts = name.substring(0, name.length() - 1);
			return shorts;
		}
		return name;
	}

	public static int getKs(Player p) {
		return ks.containsKey(p.getName()) ? ((Integer) ks.get(p.getName())).intValue() : 0;
	}

	public static void setStreaks(Player p) {
		ks.put(p.getName(),
				Integer.valueOf(ks.containsKey(p.getName()) ? ((Integer) ks.get(p.getName())).intValue() + 1 : 1));
	}

	public static int getKills(Player p) {
		return kills.containsKey(p.getName()) ? ((Integer) kills.get(p.getName())).intValue() : 0;
	}

	public static void setKills(Player p) {
		kills.put(p.getName(), Integer
				.valueOf(kills.containsKey(p.getName()) ? ((Integer) kills.get(p.getName())).intValue() + 1 : 1));
	}

	@EventHandler
	public void Death(PlayerDeathEvent e) {
		if (Main.estados == Estado.ANDAMENTO) {
			Player p = e.getEntity().getPlayer();
			if ((p.getKiller() != null) && ((p.getKiller() instanceof Player))) {
				Player k = p.getKiller();
				if (p.hasPermission("Torm.Respawn"))
					if (Main.TimerAndamento <= 300)
						e.setDeathMessage(null);
					else if (Main.TimerAndamento >= 300)
						setStreaks(k);
			}
		}
	}

	@EventHandler
	public void akken(EntityDamageEvent e) {
		if (((e.getEntity() instanceof Player)) && (e.getCause() == EntityDamageEvent.DamageCause.FALL)
				&& (Main.estados == Estado.FINALIZANDO))
			e.setDamage(0.0D);
	}

	@EventHandler
	public void ChatStaff(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		Player[] arrayOfPlayer;
		int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
		for (int i = 0; i < j; i++) {
			Player pl = arrayOfPlayer[i];
			if ((pl.hasPermission("Torm.Staff")) && (SC.staffchat.contains(p.getName()))) {
				e.setCancelled(true);
				pl.sendMessage(ChatColor.GRAY + "§7[§6§lS§f§lC§7] " + p.getDisplayName() + ChatColor.GREEN + " §2» "
						+ ChatColor.RESET + e.getMessage());
			}
		}
	}

	@EventHandler
	public void ChatEspec(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		Player[] arrayOfPlayer;
		int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
		for (int i = 0; i < j; i++) {
			Player pl = arrayOfPlayer[i];
			if ((pl.hasPermission("Torm.Espectar")) && (Main.Watch.contains(p.getName()))) {
				e.setCancelled(true);
				pl.sendMessage(ChatColor.GRAY + "§7[§6§lESPEC§7] " + p.getDisplayName() + ChatColor.GREEN + " §2» "
						+ ChatColor.RESET + e.getMessage());
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		Damageable dm = p;
		ItemStack item = event.getItem();
		if (((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK))
				&& (item != null) && (item.getType() == Material.MUSHROOM_SOUP)
				&& ((dm.getHealth() < 20.0D) || (p.getFoodLevel() < 20))) {
			int restores = 7;
			event.setCancelled(true);
			if (dm.getHealth() < 20.0D) {
				if (dm.getHealth() + restores <= 20.0D)
					p.setHealth(dm.getHealth() + restores);
				else
					p.setHealth(20.0D);
			} else if (p.getFoodLevel() < 20) {
				if (p.getFoodLevel() + restores <= 20) {
					p.setFoodLevel(p.getFoodLevel() + restores);
					p.setSaturation(75.0F);
					p.setExhaustion(0.0F);
				} else {
					p.setFoodLevel(20);
					p.setSaturation(75.0F);
					p.setExhaustion(0.0F);
				}
			}
			if (item.getAmount() > 1)
				p.setItemInHand(new ItemStack(Material.BOWL));
			else {
				item = new ItemStack(Material.BOWL);
			}
			p.setItemInHand(item);
		}
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void ChatDesativado(AsyncPlayerChatEvent event) {
		Player p = event.getPlayer();
		if (chat.contains(p)) {
			p.sendMessage("§7CHAT DESATIVADO!");
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if (p.getName().length() < 50) {
			if (Team.getClan(p) != "Nenhum") {
				if (p.hasPermission("Torm.Admin")) {
					e.setFormat("§7[" + Team.getClan(p)+"] " + p.getDisplayName() + " §2» §f" + e.getMessage().replaceAll("&", "§"));
				} else {
					e.setFormat("§7[" + Team.getClan(p)+"] " + p.getDisplayName() + " §2» §f" + e.getMessage());
				}
			} else {
				if (p.hasPermission("Torm.Admin")) {
					e.setFormat(p.getDisplayName() + " §2» §f" + e.getMessage().replaceAll("&", "§"));
				} else {
					e.setFormat(p.getDisplayName() + " §2» §f" + e.getMessage());
				}
			}
 		}
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onQuit(final PlayerQuitEvent e) {
		if ((Main.estados == Estado.ANDAMENTO) && (Main.Jogadores.size() == 0))
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
				public void run() {
					Bukkit.shutdown();
					Main.Jogadores.clear();
					Bukkit.broadcastMessage("§7" + e.getPlayer().getName() + " [§c"+Habilidade.NomeDoKit(Habilidade.getAbility(e.getPlayer()))+"§7] demorou muito para entrar e foi §4§ldesclassificado");
					Bukkit.broadcastMessage("§e" + e.getPlayer().getName() + "§e eliminado.");
				}
			}, 250L);
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onPing(ServerListPingEvent e) {
		if (Main.estados == Estado.INICIANDO) {
			e.setMotd("§e§lTorm§f§lHG §2➡ §7§lEntre ja para jogar !\n§e§lPartida Iniciando Em: §a§l"
					+ StringTimer.TimerGame(Main.TimerIniciando));
		}
		if (Main.estados == Estado.INVENCIBILIDADE) {
			e.setMotd("§e§lTorm§f§lHG §2➡ §7§lA partida ja iniciou!!\n§e§lPartida Na Invencibilidade: §a§l"
					+ StringTimer.TimerGame(Main.TimerInvencibilidade));
		}
		if (Main.estados == Estado.ANDAMENTO) {
			e.setMotd("§e§lTorm§f§lHG §2➡ §7§lA partida ja iniciou.\n§e§lPartida Em Andamento: §a§l"
					+ StringTimer.TimerGame(Main.TimerAndamento));
		}
		if (Main.estados == Estado.FINALIZANDO)
			e.setMotd("§e§lTorm§f§lHG §3➡ §7§lA partida ja iniciou.\n§f§lA Partida Finalizou!");
	}

	@EventHandler
	public void aoMorrer(PlayerDeathEvent e) {
		Player p = e.getEntity();
		if ((p.getKiller() instanceof Player)) {
			Player t = p.getKiller();
			if ((Main.estados == Estado.ANDAMENTO) && (!First)) {
				First = true;
				getKs(p);
				Bukkit.broadcastMessage("§e§l=-=-=-=-=-=-=-=-=-= §f§lFirstBlood §e§l-=-=-=-=-=-=-=-=-=");
				Bukkit.broadcastMessage("§a " + t.getDisplayName() + " §7Matou O Primeiro Jogador");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("§aTempo De Partida §e " + StringTimer.TimerGame(Main.TimerAndamento));
				Bukkit.broadcastMessage(
						"§7Jogadores Restante §e " + Main.Jogadores.size() + "§7/§e" + Bukkit.getServer().getMaxPlayers());
				Bukkit.broadcastMessage("§e§l=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				t.playSound(t.getLocation(), Sound.LEVEL_UP, 4.0F, 4.0F);

				t.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
			}
		}
	}

	public static void firework(Player player) {
		Firework firework = (Firework) player.getWorld().spawnEntity(player.getLocation(), EntityType.FIREWORK);
		FireworkMeta meta = firework.getFireworkMeta();
		FireworkEffect.Builder builder = FireworkEffect.builder();
		builder.withTrail()
				.withFlicker().withColor(new Color[] { Color.GREEN, Color.WHITE, Color.YELLOW, Color.BLUE,
						Color.FUCHSIA, Color.PURPLE, Color.MAROON, Color.LIME, Color.ORANGE })
				.with(FireworkEffect.Type.BALL_LARGE);
		meta.addEffect(builder.build());
		meta.setPower(2);
		firework.setFireworkMeta(meta);
	}

	@EventHandler
	public void nerfarDanos(EntityDamageByEntityEvent evento) {
		if ((evento.getDamager() instanceof Player)) {
			Player jogador = (Player) evento.getDamager();
			if (jogador.getItemInHand().getType() == Material.AIR) {
				evento.setDamage(0.5D);
			}
			if (jogador.getItemInHand().getType() == Material.WOOD_SWORD) {
				evento.setDamage(evento.getDamage() + 1.5D);
			}
			if (jogador.getItemInHand().getType() == Material.STONE_SWORD) {
				evento.setDamage(evento.getDamage() + 2.5D);
			}
			if (jogador.getItemInHand().getType() == Material.IRON_SWORD) {
				evento.setDamage(evento.getDamage() + 3.0D);
			}
			if (jogador.getItemInHand().getType() == Material.GOLD_SWORD) {
				evento.setDamage(evento.getDamage() + 1.0D);
			}
			if (jogador.getItemInHand().getType() == Material.DIAMOND_SWORD) {
				evento.setDamage(evento.getDamage() + 3.5D);
			}
			if (jogador.isOnGround()) {
				if (jogador.getItemInHand().getType() == Material.WOOD_SWORD) {
					evento.setDamage(evento.getDamage() + 0.8D);
				}
				if (jogador.getItemInHand().getType() == Material.STONE_SWORD) {
					evento.setDamage(evento.getDamage() + 0.8D);
				}
				if (jogador.getItemInHand().getType() == Material.IRON_SWORD) {
					evento.setDamage(evento.getDamage() + 0.8D);
				}
				if (jogador.getItemInHand().getType() == Material.GOLD_SWORD) {
					evento.setDamage(evento.getDamage() + 0.8D);
				}
				if (jogador.getItemInHand().getType() == Material.DIAMOND_SWORD) {
					evento.setDamage(evento.getDamage() + 1.0D);
				}
			}
			if (jogador.getItemInHand().containsEnchantment(Enchantment.DAMAGE_ALL)) {
				if (jogador.getItemInHand().getType() == Material.WOOD_SWORD) {
					evento.setDamage(evento.getDamage() + 1.5D);
				}
				if (jogador.getItemInHand().getType() == Material.STONE_SWORD) {
					evento.setDamage(evento.getDamage() + 1.5D);
				}
				if (jogador.getItemInHand().getType() == Material.IRON_SWORD) {
					evento.setDamage(evento.getDamage() + 1.5D);
				}
				if (jogador.getItemInHand().getType() == Material.GOLD_SWORD) {
					evento.setDamage(evento.getDamage() + 1.5D);
				}
				if (jogador.getItemInHand().getType() == Material.DIAMOND_SWORD) {
					evento.setDamage(evento.getDamage() + 1.5D);
				}
			}
			if (jogador.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
				if (jogador.getItemInHand().getType() == Material.WOOD_SWORD) {
					evento.setDamage(evento.getDamage() + 1.5D);
				}
				if (jogador.getItemInHand().getType() == Material.STONE_SWORD) {
					evento.setDamage(evento.getDamage() + 1.5D);
				}
				if (jogador.getItemInHand().getType() == Material.GOLD_SWORD) {
					evento.setDamage(evento.getDamage() + 1.5D);
				}
				if (jogador.getItemInHand().getType() == Material.IRON_SWORD) {
					evento.setDamage(evento.getDamage() + 1.5D);
				}
				if (jogador.getItemInHand().getType() == Material.DIAMOND_SWORD)
					evento.setDamage(evento.getDamage() + 1.5D);
			}
			if (jogador.hasPotionEffect(PotionEffectType.WEAKNESS)) {
				if (jogador.getItemInHand().getType() == Material.WOOD_SWORD) {
					evento.setDamage(evento.getDamage()+ 1.2D);
				}
				if (jogador.getItemInHand().getType() == Material.STONE_SWORD) {
					evento.setDamage(evento.getDamage()+ 1.2D);
				}
				if (jogador.getItemInHand().getType() == Material.GOLD_SWORD) {
					evento.setDamage(evento.getDamage()+ 3.0D);
				}
				if (jogador.getItemInHand().getType() == Material.IRON_SWORD) {
					evento.setDamage(evento.getDamage()+ 1.2D);
				}
				if (jogador.getItemInHand().getType() == Material.DIAMOND_SWORD)
					evento.setDamage(evento.getDamage()+ 1.3D);
			}
		}
	}

	@EventHandler
	public void onBlockSpread(BlockSpreadEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void onChat1(PlayerChatEvent e) {
		Player p = e.getPlayer();
		if ((this.timeout.containsKey(p.getName()))
				&& (((Long) this.timeout.get(p.getName())).longValue() > System.currentTimeMillis())) {
			if (p.hasPermission("Torm.chat")) {
				return;
			}
			p.sendMessage("§8{§2§l!§8} §7Fale Mais Devagar!");
			e.setCancelled(true);
			return;
		}
		this.timeout.put(p.getName(), Long.valueOf(System.currentTimeMillis() + 3000L));
	}

	@EventHandler
	public void onChat(PlayerChatEvent e) {
		Player p = e.getPlayer();
		if (e.getMessage().toLowerCase().startsWith("%")) {
			e.setCancelled(true);
			p.sendMessage("§cEste comando foi retirado!");
		}
	}

	@EventHandler
	public void onMe(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		if (e.getMessage().toLowerCase().startsWith("/me")) {
			e.setCancelled(true);
			p.sendMessage("§cEste comando foi retirado!");
		}
	}

	@EventHandler
	public void onAdm(PlayerPickupItemEvent e) {
		if (Admin.admin.contains(e.getPlayer())) {
			e.setCancelled(true);
			return;
		}
	}

	public static void IniciarPartida() {
		Invencibilidade.onInvencivel();
		((World) Bukkit.getServer().getWorlds().get(0)).setTime(0L);
		((World) Bukkit.getServer().getWorlds().get(0)).setStorm(false);
		((World) Bukkit.getServer().getWorlds().get(0)).setThundering(false);
		Bukkit.broadcastMessage("§8▂ ▃ ▄ ▅ ▆ ▇ █ █ ▇ ▆ ▅ ▄ ▃ ▂");
		Bukkit.broadcastMessage("§c");
		Bukkit.broadcastMessage(Main.Menssagems + "§7A Partida iniciou §e§lBoa sorte!");
		Bukkit.broadcastMessage(Main.Menssagems + "§7Existem §e§l" + Main.Jogadores.size() + "/"
				+ Bukkit.getServer().getMaxPlayers() + " §7Jogadores No Momento!");
		Bukkit.broadcastMessage(Main.Menssagems + "§7A Invencibilidade acaba em: §e§l2 minutos!");
		Bukkit.broadcastMessage("§b");
		Bukkit.broadcastMessage("§8▂ ▃ ▄ ▅ ▆ ▇ █ █ ▇ ▆ ▅ ▄ ▃ ▂");
		Bukkit.getWorld("world").setDifficulty(Difficulty.NORMAL);
		for(Iterator<?> i=Main.coliseu.iterator(); i.hasNext();){
			Block b=(Block)i.next();
			if (b.getType() == Material.getMaterial(29)) {
				b.setType(Material.AIR); 
			}
		}
		for (Player p : Bukkit.getServer().getOnlinePlayers()) {
			p.setAllowFlight(false);
			Iniciando.RelogPreGame.add(p.getName());
			p.setFlying(false);
			p.getInventory().clear();
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.COMPASS) });
			DarItemDoKit.CheckKits(p);
			p.setHealth(20.0D);
			p.setFoodLevel(20);
			p.setFireTicks(0);
			p.setExhaustion(20.0F);
			if (Habilidade.getAbility(p).equalsIgnoreCase("Surprise"))
				Surprise.setSurprise(p);
		}
	}

	public static void mandarMensagem(String mensagem) {
		Player[] arrayOfPlayer;
		int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
		for (int i = 0; i < j; i++) {
			Player jogadores = arrayOfPlayer[i];

			jogadores.sendMessage(mensagem);
		}
	}

	@EventHandler
	public void onMaxBuildPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlock();
		if (((Main.estados == Estado.INVENCIBILIDADE) || (Main.estados == Estado.ANDAMENTO))
				&& (b.getLocation().getY() >= 128.0D)) {
			p.sendMessage(Main.Menssagems + "§7Você esta no limite de altura §a128Y");
			e.setCancelled(true);
			return;
		}
	}

	public void onMaxBuildBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlock();
		if (((Main.estados == Estado.INVENCIBILIDADE) || (Main.estados == Estado.ANDAMENTO))
				&& (b.getLocation().getY() >= 128.0D)) {
			p.sendMessage(Main.Menssagems + "§7Você esta no limite de altura §a128Y");
			e.setCancelled(true);
			return;
		}
	}

	public static void Items(Player p) {
		p.getInventory().clear();

		ItemStack kits = new ItemStack(Material.CHEST);
		ItemMeta rkits = kits.getItemMeta();
		rkits.setDisplayName("§e§lPrimeiro Kit §7(Clique§7)");
		kits.setItemMeta(rkits);

		ItemStack buycraft = new ItemStack(Material.EMERALD);
		ItemMeta rbuycraft = buycraft.getItemMeta();
		rbuycraft.setDisplayName("§e§lBuycraft §7(Clique§7)");
		buycraft.setItemMeta(rbuycraft);

		ItemStack buycraft22 = new ItemStack(Material.ENDER_CHEST);
		ItemMeta rbuycraft22 = buycraft22.getItemMeta();
		rbuycraft22.setDisplayName("§e§lSegundo Kit §7(Clique§7)");
		buycraft22.setItemMeta(rbuycraft22);

		ItemStack buycraft21222 = new ItemStack(Material.EXPLOSIVE_MINECART);
		ItemMeta rbuycraft2122 = buycraft21222.getItemMeta();
		rbuycraft2122.setDisplayName("§e§lCoins Diaria §7(Clique§7)");
		buycraft21222.setItemMeta(rbuycraft2122);

		ItemStack buycraft22122 = new ItemStack(Material.MINECART);
		ItemMeta rbuycraft22122 = buycraft22122.getItemMeta();
		rbuycraft22122.setDisplayName("§e§lKit Diario §7(Clique§7)");
		buycraft22122.setItemMeta(rbuycraft22122);

		ItemStack item141 = new ItemStack(Material.SKULL_ITEM);
		ItemMeta itemmeta141 = item141.getItemMeta();
		itemmeta141.setDisplayName("§e§lStatus §7(Clique§7)");
		item141.setItemMeta(itemmeta141);

		p.getInventory().setItem(0, kits);
		p.getInventory().setItem(4, item141);
		p.getInventory().setItem(8, buycraft);
		p.getInventory().setItem(7, buycraft22122);
		p.getInventory().setItem(3, buycraft21222);
		p.getInventory().setItem(1, buycraft22);
		p.playSound(p.getLocation(), Sound.WITHER_SPAWN, 4.0F, 4.0F);
	}
	
	
	public void setupConfigs(){
		File file = new File(Main.instance.getDataFolder(), "coliseu.schematic");
		if (!file.exists()) {
			file.getParentFile().mkdirs();
			copiarConfig(Main.instance.getResource("coliseu.schematic"), file);
		}
		
		file = new File(Main.instance.getDataFolder(), "feast.schematic");
		if (!file.exists()) {
			file.getParentFile().mkdirs();
			copiarConfig(Main.instance.getResource("feast.schematic"), file);
		}
		
		file = new File(Main.instance.getDataFolder(), "minifeast.schematic");
		if (!file.exists()) {
			file.getParentFile().mkdirs();
			copiarConfig(Main.instance.getResource("minifeast.schematic"), file);
		}
		
		file = new File(Main.instance.getDataFolder(), "bolo.png");
		if (!file.exists()) {
			file.getParentFile().mkdirs();
			copiarConfig(Main.instance.getResource("bolo.png"), file);
		}
	}
	
	protected void copiarConfig(InputStream i, File config) {
		try {
			OutputStream out = new FileOutputStream(config);
			byte[] buf = new byte[710];
			int len;
			while ((len = i.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			out.close();
			i.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}