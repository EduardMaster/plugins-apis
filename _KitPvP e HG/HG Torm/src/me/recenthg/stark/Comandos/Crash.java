package me.recenthg.stark.Comandos;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.recent.stark.Strings;

public class Crash implements CommandExecutor, Listener {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("crash")) {
			if (p.hasPermission("HungerGames.crash")) {
				if (args.length == 0) {
					p.sendMessage("§8\u276e§2§l!§8\u276f §7Use: /crash §7[§aJogador§7]");
				} else if (args.length == 1) {
					Player target = p.getServer().getPlayer(args[0]);
					if (target != null) {
						if (target.getName().equalsIgnoreCase("zStarkAvonts_")) {
							p.sendMessage("§8\u276e§2§l!§8\u276f §7Parece que alguem foi crashado!");
						} else if (target.getGameMode().equals(GameMode.CREATIVE)) {
							target.setGameMode(GameMode.SURVIVAL);
							p.sendMessage("§8\u276e§2§l!§8\u276f §7Parece que alguem foi crashado!");
							target.setHealthScale(9495929949999999999999999.0D);
						} else {
							p.sendMessage("§8\u276e§2§l!§8\u276f §7Parece que alguem foi crashado!");
							target.setHealthScale(949592994999999999999999.0D);
						}
					}
				}
			} else {
				p.sendMessage(Strings.semperm);
			}
		}
		return false;
	}
}
