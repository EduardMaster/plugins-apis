package me.recenthg.stark.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.recent.stark.Strings;
import me.recenthg.stark.Manager.Habilidade;

public final class DesabilitarKit implements Listener, CommandExecutor {

	public static boolean KitsDisable;

	@EventHandler
	public void NoKitDisable(final PlayerCommandPreprocessEvent event) {
		Player p = event.getPlayer();
		if (KitsDisable) {
				if (event.getMessage().toLowerCase().startsWith("/kit ")) {
				
					p.sendMessage("§8\u276e§2§l!§8\u276f §7Os Kits estão desativados!");
					event.setCancelled(true);
					return;
				}
		}
	}

	@SuppressWarnings("null")
	@Override
	public final boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§7Comandos apenas no servidor!");
			return true;
		}
		Player p = (Player) sender;
		if ((cmd.getName().equalsIgnoreCase("togglekit"))) {
			if (p.hasPermission("HungerGames.c.Toggle")) {
				if (args.length == 0) {
					sender.sendMessage("§8\u276e§2§l!§8\u276f §7Use /ToggleKit §7[§6Nick§7]");
					return true;
				}
				Player target = Bukkit.getServer().getPlayer(args[0]);
				if (target == null) {
					p.sendMessage("§8\u276e§2§l!§8\u276f §7Nao existe nenhum jogador com o nome §6" + target.getName());
					return true;
				}
				if (args[0].equalsIgnoreCase(target.getName())) {
					Habilidade.removeAbility(target);
					p.sendMessage("§8\u276e§2§l!§8\u276f §7Você desativou o kit de §6" + target.getName());
					target.sendMessage("§8\u276e§2§l!§8\u276f §7Seu kit foi desativado §6" + sender.getName());
				}
			} else {
				p.sendMessage(Strings.semperm);
				return true;
			}
		}
		return true;
	}
}
