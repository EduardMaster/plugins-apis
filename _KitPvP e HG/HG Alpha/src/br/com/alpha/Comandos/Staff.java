package br.com.alpha.Comandos;

import java.util.HashSet;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Staff implements CommandExecutor {

	public static HashSet<Player> staffchat = new HashSet<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String a, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cSomente players!");
			return true;
		}
		Player p =(Player)sender;
		if (a.equalsIgnoreCase("sc")) {
			if (!p.hasPermission("alpha.trial")||!p.hasPermission("alpha.mod")||!p.hasPermission("alpha.modplus")||!p.hasPermission("alpha.admin")) {
				return true;
			}
			if (!staffchat.contains(p)) {
				staffchat.add(p);
				p.sendMessage("§aVocê entrou no staffchat");
				return true;
			}
			if (staffchat.contains(p)) {
				staffchat.remove(p);
				p.sendMessage("§cVocê saiu do staffchat");
				return true;
			}
		}
		return false;
	}

}
