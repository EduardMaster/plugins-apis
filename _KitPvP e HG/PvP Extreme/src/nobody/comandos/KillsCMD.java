package nobody.comandos;

import nobody.eventos.MoneyRank;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class KillsCMD implements CommandExecutor {
	
	public static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("darkills")) {
			if (!p.hasPermission("tk.darkills")) {
				p.sendMessage("§6{§a§lKILLS§6} Você não tem permissão apra isso!!");
			} else {
				if (args.length == 0) {
					sender.sendMessage("§6{§a§lKILLS§6} /darkills [player] [quantia]");
					return true;
				}
				Player target = Bukkit.getPlayerExact(args[0]);
				if ((target == null) || (!(target instanceof Player))) {
					sender.sendMessage("§6{§a§lKILLS§6} Jogador não encontrado!");
					return true;
				}
				if (isNumeric(args[1])) {
					int KILLSs = Integer.parseInt(args[1]);
					MoneyRank.addKills(KILLSs, target);
					p.sendMessage("§6{§a§lKILLS§6} §eVocê deu ao player §c" + target.getName() + "§c " + KILLSs + "" + "§7KILLS");
					target.sendMessage("§6{§a§lKILLS§6} §eVocê recebeu do player §c" + p.getName() + "§c " + KILLSs + "" + "§7KILLS");

				}
			}
		}
		return false;
	}
}

	