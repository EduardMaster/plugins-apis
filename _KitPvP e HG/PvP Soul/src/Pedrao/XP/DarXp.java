package Pedrao.XP;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Pedrao.Main;
import Pedrao.XP.XpM;

public class DarXp implements CommandExecutor {
	public static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("darxp")) {
			if (!p.hasPermission("kitpvp.xp")) {
				p.sendMessage(Main.semperm);
			} else {
				if (args.length == 0) {
					sender.sendMessage(Main.prefix + " §F§L/darxp [player] [quantia]");
					return true;
				}
				Player target = Bukkit.getPlayerExact(args[0]);
				if ((target == null) || (!(target instanceof Player))) {
					sender.sendMessage(Main.prefix + " §c§LJogador OFF");
					return true;
				}
				if (isNumeric(args[1])) {
					int coins = Integer.parseInt(args[1]);
					XpM.addMoney(target, coins);
					p.sendMessage(Main.prefix + " §F§LVocê deu ao player " + target.getName() + "§e§l " + coins
							+ "§e§lXP");
					target.sendMessage(
							Main.prefix + " §F§LVocê recebeu do player " + p.getName() + "§e§l " + coins + "§e§lXP");
				}
			}
		}
		return false;
	}
}
