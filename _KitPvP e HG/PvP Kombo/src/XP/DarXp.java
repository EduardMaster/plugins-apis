package XP;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import XP.XpM;
import me.rafael.vinagre.KomboPvP.Main;

@SuppressWarnings("unused")
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
			if (!p.hasPermission("kitpvp.darxp")) {
				p.sendMessage("Sem permissao");
			} else {
				if (args.length == 0) {
					sender.sendMessage( " §F§L/darxp [player] [quantia]");
					return true;
				}
				Player target = Bukkit.getPlayerExact(args[0]);
				if ((target == null) || (!(target instanceof Player))) {
					sender.sendMessage( " §c§LJogador OFF");
					return true;
				}
				if (isNumeric(args[1])) {
					int coins = Integer.parseInt(args[1]);
					XpM.addMoney(target, coins);
					p.sendMessage( " §c§LVoce deu ao player " + target.getName() + "§e§l " + coins
							+ "§4Coins");
					target.sendMessage(
							" §F§LVoce recebeu do player " + p.getName() + "§e§l " + coins + "§7De XP");
					Scoreboard.ScoreDoBasic.iscoriboard(target);
				}
			}
		}
		return false;
	}
}
