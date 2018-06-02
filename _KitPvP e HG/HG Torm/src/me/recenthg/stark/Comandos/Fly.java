package me.recenthg.stark.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.recent.stark.Main;
import me.recent.stark.Strings;
import me.recenthg.stark.Manager.Title;

public class Fly implements CommandExecutor, Listener {

	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§8\u276e§2§l!§8\u276f §7Comandos apenas no servidor!");
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("fly")) {
			Player player = (Player) sender;
			if (args.length == 0) {
				if (sender.hasPermission("HungerGames.c.fly")) {
					if (Main.PreGame) {
						if (!player.getAllowFlight()) {
							player.sendMessage("§8\u276e§2§l!§8\u276f §7Você ativou o §aFly!");
							  Title.sendTitle(player, "§a! §fFly Ativado §a!");
							player.setAllowFlight(true);
						} else {
							sender.sendMessage("§8\u276e§2§l!§8\u276f §7Você desativou o §aFly!");
							  Title.sendTitle(player, "§a! §fFly Desativado §a!");
							player.setAllowFlight(false);
						}
					} else {
						player.sendMessage("§8\u276e§2§l!§8\u276f §7Você so pode usar isso no §aPreGame!");
						return true;
					}
				} else {
					player.sendMessage(Strings.semperm);
					return true;
				}
			}
		}
		return true;
	}
}