package me.recenthg.stark.Comandos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Difficulty;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import me.recent.stark.Main;
import me.recenthg.stark.Eventos.Caixa;

@SuppressWarnings({ "unused", "deprecation" })
public class CMDListener implements Listener {
	public static final String danoaltura = null;
	public static final String killss = null;
	public static ArrayList<Player> killss2 = new ArrayList<Player>();
	public static String Vencedor = "";
	public static ArrayList<Player> pvpgame = new ArrayList<Player>();
	private static Object pvptemp;
	private static ArrayList<String> blabla = new ArrayList<>();

	public static ArrayList<Player> chat = new ArrayList<Player>();
	ArrayList<String> DoubleJumpCooldown = new ArrayList<String>();

	public static String getShortStr(String name) {
		if (name.length() == 16) {
			String shorts = name.substring(0, name.length() - 5);
			return shorts;
		}
		if (name.length() == 15) {
			String shorts = name.substring(0, name.length() - 4);
			return shorts;
		}
		return name;
	}

	@EventHandler
	public void ChatStaff(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		Player[] arrayOfPlayer;
		int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
		for (int i = 0; i < j; i++) {
			Player pl = arrayOfPlayer[i];
			if ((pl.hasPermission("HungerGames.c.staff")) && (Staff.staffchat.contains(p.getName()))) {
				e.setCancelled(true);
				pl.sendMessage(ChatColor.GRAY + "§7[§6§lS§f§lC§7] " + p.getDisplayName() + ChatColor.GREEN + " §2» "
						+ ChatColor.RESET + e.getMessage());
			}
		}
	}

	

	@EventHandler
	public void morrer(PlayerDeathEvent e) {
		Player matou = e.getEntity().getKiller();
		Player morreu = e.getEntity().getPlayer();
		if (!(e.getEntity() instanceof Player))
			return;
		if (!(e.getEntity().getKiller() instanceof Player))
			return;

		try {
			ResultSet rs = Main.getMysql().conectar().createStatement()
					.executeQuery("SELECT * FROM `statushg` WHERE `uuid`='" + matou.getUniqueId().toString() + "';");
			if (rs.next()) {
				Main.getMysql().conectar().createStatement()
						.executeUpdate("UPDATE `statushg` SET `kill`='" + String.valueOf((rs.getInt("kill") + 1))
								+ "' WHERE `uuid`='" + matou.getUniqueId().toString() + "';");
			}
			rs.getStatement().getConnection().close();

			ResultSet rs1 = Main.getMysql().conectar().createStatement()
					.executeQuery("SELECT * FROM `statushg` WHERE `uuid`='" + morreu.getUniqueId().toString() + "';");
			if (rs1.next()) {
				Main.getMysql().conectar().createStatement()
						.executeUpdate("UPDATE `statushg` SET `death`='" + String.valueOf((rs1.getInt("death") + 1))
								+ "' WHERE `uuid`='" + morreu.getUniqueId().toString() + "';");
			}
			rs1.getStatement().getConnection().close();

		} catch (SQLException e1) {
			System.out.println("ERRO:" + e1.getMessage());
		}
	}

	@EventHandler
	public void login(final PlayerLoginEvent e) {
		new BukkitRunnable() {

			@Override
			public void run() {
				String uuid = e.getPlayer().getUniqueId().toString();
				ResultSet rs;
				try {
					rs = Main.getMysql().conectar().createStatement()
							.executeQuery("SELECT * FROM `statushg` WHERE `uuid`='" + uuid + "';");
					if (!rs.next()) {
						Main.getMysql().conectar().createStatement()
								.executeUpdate("INSERT INTO `statushg` (`uuid` , `kill` , `death`) VALUES ('" + uuid
										+ "', '0', '0');");
					}
					rs.getStatement().getConnection().close();
				} catch (SQLException e1) {
					System.out.println("ERRO: " + e1.getMessage());
				}

			}
		}.runTaskAsynchronously(Main.instance);
	}

	@EventHandler
	public void login1(final PlayerLoginEvent e) {
		new BukkitRunnable() {

			@Override
			public void run() {
				String uuid = e.getPlayer().getName();
				ResultSet rs;
				try {
					rs = Main.getMysql().conectar().createStatement()
							.executeQuery("SELECT * FROM `sorte` WHERE `nick`='" + uuid + "';");
					if (!rs.next()) {
						Main.getMysql().conectar().createStatement()
								.executeUpdate("INSERT INTO `sorte` (`nick` , `chaves`) VALUES ('" + uuid + "', '0');");
					}
					rs.getStatement().getConnection().close();
				} catch (SQLException e1) {
					System.out.println("ERRO: " + e1.getMessage());
				}

			}
		}.runTaskAsynchronously(Main.instance);
	}

	@EventHandler
	public void clicar(PlayerInteractEvent e) {
		Player p = e.getPlayer();

		if (p.getItemInHand().getType() == Material.SKULL_ITEM) {
			if (Main.PreGame) {
				me.recenthg.stark.Inv.Status.menu(p);
			}
		}

	}

	@EventHandler
	public void onPlayerCLickInventry(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if ((e.getInventory().getTitle().equalsIgnoreCase("§6Status")) && (e.getCurrentItem() != null)) {
			e.setCancelled(true);
		}
	}

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

	private static HashMap<String, Integer> kills = new HashMap<String, Integer>();
	private static HashMap<String, Integer> ks = new HashMap<String, Integer>();
	public static String getMod;

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
		if ((Main.Partida)) {
			Player p = e.getEntity().getPlayer();
			if ((p.getKiller() != null) && ((p.getKiller() instanceof Player)))
				if ((Main.Partida)) {

					Player k = p.getKiller();
					if (p.hasPermission("HungerGames.Respawn")) {
						if (Main.Andamento <= 300)
							e.setDeathMessage(null);
						else if (Main.Andamento >= 300)
							setStreaks(k);
					}
				}

		}

	}



	@EventHandler
	public void naoAbre(PlayerInteractEvent e) {
		Block b = e.getClickedBlock();
		if ((e.getAction() == Action.PHYSICAL) && (b != null) && (b.getType() == Material.STONE_PLATE)) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void Spawn1(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (Main.PreGame)
			if (p.getLocation().getY() <= 183.0D) {
				if (Main.TimerIniciando.intValue() <= 30) {
					double x = 0.5D;
					double y = 184.0D;
					double z = 26.5D;
					Location loc = new Location(p.getWorld(), x, y, z);
					p.teleport(loc);
					p.chat("/morrer");
					p.sendMessage("§8\u276e§2§l!§8\u276f §7Voce Nao Pode Ir Na ArenaPvP!");
				}
			}
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void ChatDesativado(AsyncPlayerChatEvent event) {
		Player p = event.getPlayer();
		if (chat.contains(p)) {
			p.sendMessage("§8\u276e§2§l!§8\u276f §7CHAT DESATIVADO!");
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onPlayerCamel(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if ((e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SOUL_SAND)
				|| (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SOUL_SAND)) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 120, 1));
			return;
		}
	}

	private boolean First = false;

	@EventHandler
	public void aoMorrer(PlayerDeathEvent e) {
		Player p = e.getEntity().getKiller();

		if (Main.Partida) {
			if (First == false) {
				First = true;
				CMDListener.getKs(p);
				Bukkit.broadcastMessage("§7=-=-=-=-=-=-=-=-=-=§aFirstBlood-=-=-=-=-=-=-=-=-=");
				Bukkit.broadcastMessage("§a " + p.getName() + " §7Matou O Primeiro Jogador");
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage("§7Tempo De Partida §a " + Main.Andamento);
				Bukkit.broadcastMessage("§7Jogadores Restante §a " + Bukkit.getServer().getOnlinePlayers().length + "/" + Bukkit.getServer().getMaxPlayers());
				Bukkit.broadcastMessage("§7=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 4.0F, 4.0F);
				Caixa.ADdchaves(p, 1);
				p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));

		}
	
			}
	}

}
