package me.recenthg.stark.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.recent.stark.Strings;
import me.recenthg.stark.Manager.Title;

public class PvP implements Listener, CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§8\u276e§2§l!§8\u276f §7Comandos apenas no servidor!");
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("pvp")) {
			if (p.hasPermission("HungerGames.c.pvp")) {
				if (args.length == 0) {
					p.sendMessage("§8\u276e§2§l!§8\u276f §7Use /pvp: §7(§6On | Off§7");
					return true;
				}
				if ((args[0].equalsIgnoreCase("on"))) {
					Bukkit.getServer().getWorld("world").setPVP(true);
					Bukkit.broadcastMessage("§8\u276e§2§l!§8\u276f §7PVP GLOBAL ATIVADO!");
					Bukkit.getLogger().info(p.getName() + " Ativou o pvp global!");
					Title.sendTitle(p, "§a! §fPvP Ativado §a!");
				}
				if ((args[0].equalsIgnoreCase("off"))) {
					Bukkit.getServer().getWorld("world").setPVP(false);
					Bukkit.broadcastMessage("§8\u276e§2§l!§8\u276f §7PVP GLOBAL DESATIVADO!");
					Bukkit.getLogger().info(p.getName() + " Desativou dano global!");
					Title.sendTitle(p, "§a! §fPvP Desativado §a!");
				}
			} else {
				p.sendMessage(Strings.semperm);
				return true;
			}
		}
		return true;
	}
}