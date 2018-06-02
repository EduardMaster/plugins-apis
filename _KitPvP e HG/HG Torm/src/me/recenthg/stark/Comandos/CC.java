package me.recenthg.stark.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.recent.stark.Strings;
import me.recenthg.stark.Manager.Title;

public class CC implements CommandExecutor, Listener{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("cc")) {
			Player p = (Player)sender;
			if(p.hasPermission("HungerGames.cc")) {
				p.sendMessage(Strings.semperm);
				for (int x = 0; x < 200; x ++) {
					Bukkit.broadcastMessage("");
				}
				Bukkit.broadcastMessage("§7O Chat Foi Limpo por §6§n" + p.getName());
				  Title.sendTitle(p, "§a! §fChat Foi Limpo §a!");
			}
		}
		return false;
	}
}
