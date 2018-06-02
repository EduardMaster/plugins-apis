package br.com.alpha.pregame.listeners.Join;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.server.MapInitializeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;
import org.bukkit.map.MinecraftFont;
import org.bukkit.potion.PotionEffectType;
import br.com.alpha.MCAlpha;
import br.com.alpha.APIs.APIClass;
import br.com.alpha.APIs.LoadKits;
import br.com.alpha.APIs.MySQL;
import br.com.alpha.Comandos.Staff;
import br.com.alpha.ENUMs.KitsEnum;
import br.com.alpha.ScoreBoard.Scores;
import br.com.alpha.gamemanagement.GameTime;
import net.md_5.bungee.api.ChatColor;

public class PlayerJoin implements Listener {

	public static String getItemHand(Player jogador) {
		if (jogador.getItemInHand().getType().equals(Material.WOOD_SWORD)) {
			return "uma Espada de Madeira";
		}
		if (jogador.getItemInHand().getType().equals(Material.STONE_SWORD)) {
			return "uma Espada de Pedra";
		}
		if (jogador.getItemInHand().getType().equals(Material.GOLD_SWORD)) {
			return "uma Espada de Ouro";
		}
		if (jogador.getItemInHand().getType().equals(Material.IRON_SWORD)) {
			return "uma Espada de Ferro";
		}
		if (jogador.getItemInHand().getType().equals(Material.DIAMOND_SWORD)) {
			return "uma Espada de Diamante";
		}
		if (jogador.getItemInHand().getType().equals(Material.WOOD_PICKAXE)) {
			return "uma Picareta de Madeira";
		}
		if (jogador.getItemInHand().getType().equals(Material.STONE_PICKAXE)) {
			return "uma Picareta de Pedra";
		}
		if (jogador.getItemInHand().getType().equals(Material.GOLD_PICKAXE)) {
			return "uma Picareta de Ouro";
		}
		if (jogador.getItemInHand().getType().equals(Material.IRON_PICKAXE)) {
			return "uma Picareta de Ferro";
		}
		if (jogador.getItemInHand().getType().equals(Material.DIAMOND_PICKAXE)) {
			return "uma Picareta de Diamante";
		}
		if (jogador.getItemInHand().getType().equals(Material.WOOD_AXE)) {
			return "um Machado de Madeira";
		}
		if (jogador.getItemInHand().getType().equals(Material.STONE_AXE)) {
			return "um Machado de Pedra";
		}
		if (jogador.getItemInHand().getType().equals(Material.GOLD_AXE)) {
			return "um Machado de Ouro";
		}
		if (jogador.getItemInHand().getType().equals(Material.IRON_AXE)) {
			return "um Machado de Ferro";
		}
		if (jogador.getItemInHand().getType().equals(Material.DIAMOND_AXE)) {
			return "um Machado de Diamante";
		}
		if (jogador.getItemInHand().getType().equals(Material.COMPASS)) {
			return "uma Bússola";
		}
		if (jogador.getItemInHand().getType().equals(Material.MUSHROOM_SOUP)) {
			return "uma Sopa";
		}
		if (jogador.getItemInHand().getType().equals(Material.STICK)) {
			return "um Graveto";
		}
		if (jogador.getItemInHand().getType().equals(Material.AIR)) {
			return "o Punho";
		}
		return "o Punho";
	}

	@EventHandler
	void dsa(EntityDamageEvent e) {

		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (APIClass.moderadores.contains(p.getUniqueId())) {
				e.setCancelled(true);
			}
			if (APIClass.espectadores.contains(p.getUniqueId())) {
				e.setCancelled(true);
			}
			if (APIClass.ganhou == true) {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	void sda(PlayerDropItemEvent e) {
		if (APIClass.moderadores.contains(e.getPlayer())) {
			e.setCancelled(true);
		}
		if (APIClass.espectadores.contains(e.getPlayer())) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	void fd(PlayerPickupItemEvent e) {
		Player p = e.getPlayer();
		if (APIClass.moderadores.contains(p.getUniqueId())) {
			e.setCancelled(true);
		}
		if (APIClass.espectadores.contains(p.getUniqueId())) {
			e.setCancelled(true);
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	void respawn(PlayerRespawnEvent e) {

		if (e.getPlayer().hasPermission("alpha.renascer") && MCAlpha.Time <= 361
				|| e.getPlayer().hasPermission("alpha.entrar")) {
			int x = new Random().nextInt(450), z = new Random().nextInt(450);
			int y = e.getPlayer().getWorld().getHighestBlockYAt(x, z) - 20;
			e.setRespawnLocation(new Location(e.getPlayer().getWorld(), x, y, z));

			if (e.getPlayer().hasPermission("alpha.kit")) {
				LoadKits.loadKits(e.getPlayer());
			}
			e.getPlayer().getInventory().addItem(new ItemStack(Material.COMPASS));
			e.getPlayer().sendMessage("§cVocê morreu e renasceu!");
		} else {
			if ((e.getPlayer().hasPermission("alpha.espectar") && MCAlpha.Time >= 299)) {
				APIClass.espectadores.add(e.getPlayer().getUniqueId());
				for (Player all : Bukkit.getOnlinePlayers()) {
					all.hidePlayer(e.getPlayer());
					all.hidePlayer(e.getPlayer());
				}
				e.getPlayer().setAllowFlight(true);
				e.getPlayer().getInventory().clear();
				e.getPlayer().getInventory().setItem(4, new ItemStack(Material.BOOK));
				APIClass.checkWinner();

			}
		}

	}

	@EventHandler
	void blocks(BlockPlaceEvent e) {
		if (APIClass.espectadores.contains(e.getPlayer().getUniqueId())) {
			e.setCancelled(true);
		}
		if (APIClass.moderadores.contains(e.getPlayer().getUniqueId())) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	void block(BlockBreakEvent e) {
		if (APIClass.espectadores.contains(e.getPlayer().getUniqueId())) {
			e.setCancelled(true);
		}
		if (APIClass.moderadores.contains(e.getPlayer().getUniqueId())) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	private void aoMapa(MapInitializeEvent e) {
		e.getMap().addRenderer(new MapRenderer() {
			public void render(MapView mapa, MapCanvas canvas, Player jogador) {
				canvas.drawText(30, 10, MinecraftFont.Font, "HardcoreGames");
				canvas.drawText(10, 20, MinecraftFont.Font, "Parabens " + jogador.getName() + ", Você ganhou.");
				canvas.drawImage(15, 42,
						new ImageIcon(getClass().getResource("/br/com/alpha/resources/bolo.png")).getImage());
			}
		});
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	/*      */ public void nerfarDanos(EntityDamageByEntityEvent evento)
	/*      */ {
		/* 1298 */ if ((evento.getDamager() instanceof Player))
		/*      */ {
			/* 1300 */ Player jogador = (Player) evento.getDamager();
			/*      */
			/* 1302 */ if (jogador.getItemInHand().getType() == Material.AIR)
			/*      */ {
				/* 1304 */ evento.setDamage(1.0D);
				/*      */ }
			/* 1306 */ if (jogador.getItemInHand().getType() == Material.WOOD_SWORD)
			/*      */ {
				/* 1308 */ evento.setDamage(1.5D);
				/*      */ }
			/* 1310 */ if (jogador.getItemInHand().getType() == Material.STONE_SWORD)
			/*      */ {
				/* 1312 */ evento.setDamage(2.0D);
				/*      */ }
			/* 1314 */ if (jogador.getItemInHand().getType() == Material.IRON_SWORD)
			/*      */ {
				/* 1316 */ evento.setDamage(4.0D);
				/*      */ }
			/* 1318 */ if (jogador.getItemInHand().getType() == Material.DIAMOND_SWORD)
			/*      */ {
				/* 1320 */ evento.setDamage(5.0D);
				/*      */ }
			/* 1322 */ if (jogador.isOnGround())
			/*      */ {
				/* 1324 */ if (jogador.getItemInHand().getType() == Material.WOOD_SWORD)
				/*      */ {
					/* 1326 */ evento.setDamage(evento.getDamage() + 0.5D);
					/*      */ }
				/* 1328 */ if (jogador.getItemInHand().getType() == Material.STONE_SWORD)
				/*      */ {
					/* 1330 */ evento.setDamage(evento.getDamage() - 0.5D);
					/*      */ }
				/* 1332 */ if (jogador.getItemInHand().getType() == Material.IRON_SWORD)
				/*      */ {
					/* 1334 */ evento.setDamage(evento.getDamage() + 0.5D);
					/*      */ }
				/* 1336 */ if (jogador.getItemInHand().getType() == Material.DIAMOND_SWORD)
				/*      */ {
					/* 1338 */ evento.setDamage(evento.getDamage() + 0.5D);
					/*      */ }
				/*      */ }
			/* 1341 */ if (jogador.getItemInHand().containsEnchantment(Enchantment.DAMAGE_ALL))
			/*      */ {
				/* 1343 */ if (jogador.getItemInHand().getType() == Material.WOOD_SWORD)
				/*      */ {
					/* 1345 */ evento.setDamage(evento.getDamage() + 0.5D);
					/*      */ }
				/* 1347 */ if (jogador.getItemInHand().getType() == Material.STONE_SWORD)
				/*      */ {
					/* 1349 */ evento.setDamage(evento.getDamage() + 0.5D);
					/*      */ }
				/* 1351 */ if (jogador.getItemInHand().getType() == Material.IRON_SWORD)
				/*      */ {
					/* 1353 */ evento.setDamage(evento.getDamage() + 0.5D);
					/*      */ }
				/* 1355 */ if (jogador.getItemInHand().getType() == Material.DIAMOND_SWORD)
				/*      */ {
					/* 1357 */ evento.setDamage(evento.getDamage() + 0.5D);
					/*      */ }
				/*      */ }
			/* 1360 */ if (jogador.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE))
			/*      */ {
				/* 1362 */ if (jogador.getItemInHand().getType() == Material.WOOD_SWORD)
				/*      */ {
					/* 1364 */ evento.setDamage(evento.getDamage() + 0.5D);
					/*      */ }
				/* 1366 */ if (jogador.getItemInHand().getType() == Material.STONE_SWORD)
				/*      */ {
					/* 1368 */ evento.setDamage(evento.getDamage() + 0.5D);
					/*      */ }
				/* 1370 */ if (jogador.getItemInHand().getType() == Material.IRON_SWORD)
				/*      */ {
					/* 1372 */ evento.setDamage(evento.getDamage() + 0.5D);
					/*      */ }
				/* 1374 */ if (jogador.getItemInHand().getType() == Material.DIAMOND_SWORD)
				/*      */ {
					/* 1376 */ evento.setDamage(evento.getDamage() + 0.5D);
					/*      */ }
				/*      */ }
			/*      */ }
		/*      */ }
	/*      */

	@SuppressWarnings({ "rawtypes", "deprecation" })
	@EventHandler
	void ig(PlayerDeathEvent e) {
		Player jogador = e.getEntity();
		e.setDeathMessage(null);
		String morte = null;
		Enum kit = KitsEnum.getKit(jogador);
		if ((jogador.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION)
				|| (jogador.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION)) {
			morte = "§8⦗§e§l!§8⦘ §6" + jogador.getName() + "§8(§b" + kit + "§8) §7Morreu explodido em pedaços.";

		}
		if (jogador.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.DROWNING) {
			morte = "§8⦗§e§l!§8⦘ §6" + jogador.getName() + "§8(§b" + kit + "§8) §7Morreu afogado.";

		}
		if (jogador.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.FALL) {
			morte = "§8⦗§e§l!§8⦘ §6" + jogador.getName() + "§8(§b" + kit + "§8) §7Morreu de altura.";

		}
		if ((jogador.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.FIRE)
				|| (jogador.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.FIRE_TICK)
				|| (jogador.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.LAVA)) {
			morte = "§8⦗§e§l!§8⦘ §6" + jogador.getName() + "§8(§b" + kit + "§8) §7Morreu queimado.";

		}
		if (jogador.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.THORNS) {
			morte = "§8⦗§e§l!§8⦘ §6" + jogador.getName() + "§8(§b" + kit + "§8) §7Morreu para um Cacto.";

		}
		if (jogador.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.VOID) {
			morte = "§8⦗§e§l!§8⦘ §6" + jogador.getName() + "§8(§b" + kit + "§8) §7Caiu no Void.";

		}
		if (jogador.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.SUICIDE) {
			morte = "§8⦗§e§l!§8⦘ §6" + jogador.getName() + "§8(§b" + kit + "§8) §7Se suicidou.";

		}
		if ((jogador.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK)
				&& ((jogador.getLastDamageCause().getEntity() instanceof Player)) && (jogador.getKiller() != null)) {
			morte = "§8⦗§e§l!§8⦘ §6" + jogador.getName() + "§8(§b" + kit + "§8) §7Morreu para §6"
					+ jogador.getKiller().getName() + "§8(§b" + KitsEnum.getKit(jogador.getKiller()) + "§8)"
					+ " §7usando " + getItemHand(jogador);
			MySQL.addKill(jogador.getKiller().getUniqueId(), 1);
			MySQL.addDeath(jogador.getUniqueId(), 1);
			MySQL.removeMoney(jogador.getUniqueId(), 2);
			MySQL.addMoney(jogador.getKiller().getUniqueId(), 20);
			jogador.getKiller().sendMessage(" §aVocê ganhou +20 coins por ter matado " + jogador.getName());
			APIClass.checkWinner();
		}

		if ((jogador.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.CONTACT)
				|| (jogador.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.CUSTOM)
				|| (jogador.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.FALLING_BLOCK)
				|| (jogador.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.LIGHTNING)
				|| (jogador.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.MAGIC)
				|| (jogador.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.MELTING)
				|| (jogador.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.POISON)
				|| (jogador.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.PROJECTILE)
				|| (jogador.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.STARVATION)
				|| (jogador.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.WITHER)
				|| (jogador.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.FALL)
				|| (jogador.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.SUFFOCATION)
				|| (jogador.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.MAGIC)) {
			morte = "§8⦗§3§l!§8⦘ §6" + jogador.getName() + "§8(§b" + kit + "§8) §7Morreu inexplicavelmente.";

		}
		if (jogador.hasPermission("alpha.renascer") || jogador.hasPermission("alpha.espectar")) {
			if (MCAlpha.Time >= 300) {
				if (jogador.hasPermission("alpha.trial") || jogador.hasPermission("alpha.mod")
						|| jogador.hasPermission("alpha.modplus") || jogador.hasPermission("alpha.admin")) {
					jogador.chat("/admin");
					
				}
				APIClass.JogadoresInGame.remove(jogador.getUniqueId());
				APIClass.espectadores.add(jogador.getUniqueId());
				jogador.getInventory().clear();
				KitsEnum.setKit(jogador, KitsEnum.NONE);
				jogador.setAllowFlight(true);
				for (Player all : Bukkit.getOnlinePlayers()) {
					all.hidePlayer(jogador);
				}
			} else {
				jogador.sendMessage("§cVocê renasceu!");
			}
		} else if (APIClass.JogadoresInGame.contains(jogador.getUniqueId())) {
			APIClass.JogadoresInGame.remove(jogador.getUniqueId());
			jogador.kickPlayer("§cVocê morreu.");
		}



		e.setDeathMessage(morte);
	}

	@EventHandler
	void bussola(PlayerInteractEvent evento) {
		if (evento.getPlayer().getItemInHand().getType() == Material.COMPASS) {
			boolean parar = false;
			for (Entity entidades : evento.getPlayer().getNearbyEntities(500.0D, 500.0D, 500.0D)) {
				if (((entidades instanceof Player))
						&& (evento.getPlayer().getLocation().distance(entidades.getLocation()) >= 30.0D)) {
					parar = true;
					evento.getPlayer().setCompassTarget(entidades.getLocation());
					evento.getPlayer().sendMessage(
							MCAlpha.Logo + " Bussola apontando para: " + ((Player) entidades).getName() + ".");
					break;
				}
			}
			if (!parar) {
				evento.getPlayer().sendMessage("§cNenhum player localizado, apontando para o spawn.");
				evento.getPlayer().setCompassTarget(new Location(Bukkit.getWorld("world"), 0.0D,
						Bukkit.getWorld("world").getHighestBlockYAt(0, 0), 0.0D));
				return;
			}
		}
	}

	@EventHandler
	void command(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		if (e.getMessage().contains("/kit")) {
			if (MCAlpha.Status == GameTime.INVENCIBILIDADE) {
				if (p.hasPermission("alpha.kit")) {
					if (MCAlpha.Time != 1) {
						e.setCancelled(false);
					} else {
						e.setCancelled(true);
					}
				}

			}
		}
		if (e.getMessage().contains("/kit")) {
			if (MCAlpha.Status == GameTime.INGAME) {
				e.setCancelled(true);
				p.sendMessage("§cA Partida iniciou!");
				return;
			}
		}
	}

	@EventHandler
	void onLogin(PlayerLoginEvent e) {
		Player p = e.getPlayer();

		if (MCAlpha.Status == GameTime.INVENCIBILIDADE) {
			if (p.hasPermission("alpha.entrar") || APIClass.JogadoresInGame.contains(p)) {
				e.allow();
			} else {
				e.disallow(Result.KICK_OTHER, "§cO Jogo já iniciou!\nCompre vip para entrar na invencibilidade.");
			}
			if (p.hasPermission("alpha.entrar") || APIClass.JogadoresInGame.contains(p.getUniqueId())) {
				e.allow();
				if (!APIClass.JogadoresInGame.contains(p.getUniqueId())) {
					if (MCAlpha.Time >= 300) {
						APIClass.espectadores.add(p.getUniqueId());
					}

				}
			} else if ((MCAlpha.Status == GameTime.INGAME) && !APIClass.JogadoresInGame.contains(p.getUniqueId())){
				e.disallow(Result.KICK_OTHER, "§cO Jogo já iniciou!\nCompre vip para espectar.");
			}

		}

	}

	@SuppressWarnings("deprecation")
	@EventHandler
	void chat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String message = e.getMessage().replace("%", "");

		for (Player all : Bukkit.getOnlinePlayers()) {

			if (Staff.staffchat.contains(p)) {
				if (message.length() > 1) {
					all.sendMessage("§4§l[STAFF] §r" + p.getDisplayName() + " §6> §f "
							+ message.substring(0, 1).toUpperCase() + message.substring(1).toLowerCase());
				} else {
					all.sendMessage("§4§l[STAFF] §r" + p.getDisplayName() + " §6> §f " + message);

				}
				e.setCancelled(true);
				return;
			}
		}
		e.setFormat(p.getDisplayName() + " §f§l: §f" + message);
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	void interact(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (p.getItemInHand().getType() == Material.BOOK) {
			Inventory inv = Bukkit.createInventory(p, 54, "§aJogadores");
			for (Player jogadores : Bukkit.getOnlinePlayers()) {
				if (APIClass.JogadoresInGame.contains(jogadores.getUniqueId())) {
					ItemStack stack = new ItemStack(Material.STICK);
					ItemMeta meta = stack.getItemMeta();
					meta.setDisplayName("§a" + jogadores.getName());
					ArrayList<String> lore = new ArrayList<>();
					lore.add("§aKit: " + KitsEnum.getKit(jogadores));
					meta.setLore(lore);
					stack.setItemMeta(meta);
					inv.addItem(stack);
				}
			}
			p.openInventory(inv);
		}
	}

	@EventHandler
	void comandoEspec(PlayerCommandPreprocessEvent e) {
		if (APIClass.espectadores.contains(e.getPlayer())) {
			e.setCancelled(true);
		} else {
			e.setCancelled(false);
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage(null);

		p.chat("/tag default");
		if (MCAlpha.Status == GameTime.PREGAME) {
			for (Player all : Bukkit.getOnlinePlayers()) {
				Scores.scorePreGame(all);
	
			}
			p.chat("/tag default");

			p.setDisplayName("§7" + p.getName());
			p.setPlayerListName("§7" + p.getName());
			p.setDisplayName(ChatColor.GRAY + p.getName());
			p.setPlayerListName(ChatColor.GRAY + p.getName());
			;
			MySQL.addPlayerToTable(p.getUniqueId(), "status",
					new String[] { "0", "0", "200", "Unranked", "I", "0", p.getName(), "0" }, false, true);
			JoinAPI.loadItensToaPlayer(p);
			JoinAPI.sendJoinMessageToaPlayer(p);
			e.setJoinMessage(null);
			JoinAPI.addInMatch(p);
			JoinAPI.teleportToSpawn(p);
			e.setJoinMessage(null);
			KitsEnum.setKit(p, KitsEnum.NONE);

			p.chat("/tag default");
		} else if (MCAlpha.Status == GameTime.INVENCIBILIDADE) {
			p.chat("/tag default");
			if (!APIClass.JogadoresInGame.contains(p)) {
				for (Player all : Bukkit.getOnlinePlayers()) {
					Scores.scoreInvencibility(all);
				

				}
				p.chat("/tag default");
				KitsEnum.setKit(p, KitsEnum.NONE);
				APIClass.JogadoresInGame.add(p.getUniqueId());
				int x = new Random().nextInt(450);
				int z = new Random().nextInt(450);
				int y = e.getPlayer().getWorld().getHighestBlockYAt(x, z) + 5;
				e.getPlayer().teleport(new Location(e.getPlayer().getWorld(), x, y, z));
				p.getInventory().addItem(new ItemStack(Material.COMPASS));

			} else if ((MCAlpha.Status == GameTime.INGAME) && (!APIClass.JogadoresInGame.contains(p))) {
				for (Player all : Bukkit.getOnlinePlayers()) {
					Scores.scoreGame(all);
					

				}
				p.chat("/tag default");
				e.getPlayer().getInventory().clear();

				if (MCAlpha.Time <= 300) {
					APIClass.espectadores.add(p.getUniqueId());
					e.setJoinMessage(null);
					p.setAllowFlight(true);
					p.getInventory().addItem(new ItemStack(Material.BOOK));
					for (Player all : Bukkit.getOnlinePlayers()) {
						all.hidePlayer(p);
					}

				} else {
					System.out.print("");
				}
			}

		}
	}
}
