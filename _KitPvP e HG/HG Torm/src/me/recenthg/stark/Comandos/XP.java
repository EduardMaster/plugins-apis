package me.recenthg.stark.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.recenthg.stark.Dinheiro.DinheiroM;

@SuppressWarnings("unused")
public class XP implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("verxp")) {
			if (args.length == 0) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Sua quantia é de: §a" + DinheiroM.MostrarDinheiroPlayer(p));
			}
		}
		return false;
	}
}
