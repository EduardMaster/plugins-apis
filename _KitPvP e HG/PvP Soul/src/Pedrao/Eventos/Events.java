package Pedrao.Eventos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.help.HelpTopic;

import Pedrao.Main;

@SuppressWarnings("deprecation")
public class Events implements Listener {
	public Events(Main main) {
	}

	@EventHandler
	public void Fome(FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void fullJoin(PlayerLoginEvent event) {
		Player p = event.getPlayer();
		if (event.getResult() == PlayerLoginEvent.Result.KICK_FULL) {
			if (p.hasPermission("kitpvp.vip")) {
				event.setResult(PlayerLoginEvent.Result.ALLOWED);
			} else {
				event.setKickMessage("§cServidor Cheio! §aCompre vip > BREVE SITE");
			}
		} else if (event.getResult() == PlayerLoginEvent.Result.KICK_WHITELIST) {
			event.setKickMessage(ChatColor.GRAY + "Servidor com WhiteList voce nao esta listado!!");
		}
	}

	@EventHandler
	public void aoColocarBlocos(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		if (p.getGameMode() != GameMode.CREATIVE) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void aoQuebrarBlocos(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if (p.getGameMode() != GameMode.CREATIVE) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onReload(PlayerCommandPreprocessEvent event) {
		Player p = event.getPlayer();

		String msg = event.getMessage();
		if (((msg.equalsIgnoreCase("/rl")) || (msg.equalsIgnoreCase("/reload"))) && (p.isOp())
				&& (p.hasPermission("kitpvp.reload"))) {
			event.setCancelled(true);

			Bukkit.reload();
			Bukkit.broadcastMessage(Main.prefix + "§5§lServidor Reloading");
		}
	}

	@EventHandler
	public void DisableFireSpread(BlockSpreadEvent e) {
		if (e.getNewState().getType() == Material.FIRE) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void aoPing(ServerListPingEvent e) {
		e.setMotd("         " + Main.prefix + "\n" + "       §aVenha treinar seu pvp");
		e.setMaxPlayers(120);
		if (Bukkit.hasWhitelist()) {
			e.setMotd("         " + Main.prefix + "\n" + "    §cServidor em manutençao voltamos em breve !");
		}
	}

	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		{
			e.setCancelled(true);
		}
		if ((e.getItemDrop().getItemStack().getType() == Material.BOWL)) {
			e.setCancelled(false);
		}
		if ((e.getItemDrop().getItemStack().getType() == Material.MUSHROOM_SOUP)) {
			e.setCancelled(false);
		}
		if ((e.getItemDrop().getItemStack().getType() == Material.RED_MUSHROOM)) {
			e.setCancelled(false);
		}
		if ((e.getItemDrop().getItemStack().getType() == Material.BROWN_MUSHROOM)) {
			e.setCancelled(false);
		}
		if ((e.getItemDrop().getItemStack().getType() == Material.COMPASS)) {
			e.setCancelled(false);

		}

	}

	@EventHandler
	public void onMe(PlayerCommandPreprocessEvent event) {
		Player p = event.getPlayer();
		if (event.getMessage().toLowerCase().startsWith("/me")) {
			event.setCancelled(true);
			p.sendMessage(Main.prefix + "§cEste comando foi retirado!");
		}
	}

	@EventHandler
	public void onUnknown(PlayerCommandPreprocessEvent event) {
		if (event.isCancelled()) {
			return;
		}
		Player p = event.getPlayer();

		String msg = event.getMessage().split(" ")[0];

		HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(msg);
		if (topic == null) {
			event.setCancelled(true);

			p.sendMessage(Main.prefix + "§cComando nao esta na lista !!");
		}
	}

	@EventHandler
	public void onChat(PlayerChatEvent e) {
		Player p = e.getPlayer();
		e.setFormat(p.getDisplayName() + " §7) §f " + e.getMessage());
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		e.getPlayer();
		e.setQuitMessage(null);
	}

	@EventHandler
	public void onQuit(PlayerJoinEvent e) {
		e.getPlayer();
		e.setJoinMessage(null);
	}

	@EventHandler
	public void nohunger(FoodLevelChangeEvent event) {
		event.setCancelled(true);
		event.setFoodLevel(20);
	}

	@EventHandler
	public void noRain(WeatherChangeEvent event) {
		event.setCancelled(true);
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onCreeperExplosion(EntityExplodeEvent event) {
		event.setCancelled(true);
	}
}
