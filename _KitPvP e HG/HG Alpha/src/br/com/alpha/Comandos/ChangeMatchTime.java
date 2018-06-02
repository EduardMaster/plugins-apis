package br.com.alpha.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import br.com.alpha.MCAlpha;
import br.com.alpha.APIs.APIClass;
import br.com.alpha.gamemanagement.GameTime;

public class ChangeMatchTime implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("tempo")) {
			if (sender.hasPermission("alpha.tempo") || sender.hasPermission("alpha.*")) {
				if (args.length == 0) {
					sender.sendMessage(MCAlpha.Logo + " §cTempo não especificado.");
					return true;
				}
				if (toTime(args[0]) == 0 || args[0].length() > 6) {
					sender.sendMessage(MCAlpha.Logo + " §cEste tempo não pode ser utilizado.");
					return true;
				} else {
					MCAlpha.Time = toTime(args[0]);
					Bukkit.broadcastMessage(MCAlpha.Logo + " " + returnByGameTime(MCAlpha.Status) + "§c"
							+ APIClass.formatDifferenceStr(toTime(args[0]) * 1000) + ".");
					APIClass.sendSoundToAllPlayers(Sound.SUCCESSFUL_HIT, 1F, 1F);
				}
			}
		}
		return false;

	}

	public Integer toTime(String seg) {
		try {
			return Integer.parseInt(seg);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	private String returnByGameTime(GameTime Status) {
		if (Status == GameTime.PREGAME) {
			return "§7Tempo do PreGame alterado para ";
		} else if (Status == GameTime.INVENCIBILIDADE) {
			return "§7Tempo da invencibilidade alterado para ";
		} else if (Status == GameTime.INGAME) {
			return "§7Tempo do jogo alterado para ";
		}
		return null;
	}

}
