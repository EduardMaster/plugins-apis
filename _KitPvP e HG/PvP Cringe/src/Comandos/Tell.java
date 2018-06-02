package Comandos;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Tell implements CommandExecutor {
	
	public static HashMap<Player, Player> gettell = new HashMap<>();
	static ArrayList<Player> telloff = new ArrayList<>();

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (label.equalsIgnoreCase("tell")) {
			if (args.length == 0) {
				p.sendMessage("§9§lTELL§f Use /Tell (Jogador) (Mensagem)");
				return true;
			}
			Player target = Bukkit.getPlayer(args[0]);
			if (args[0].toLowerCase().equalsIgnoreCase("on")) {
				telloff.remove(p);
				p.sendMessage("§9§lTELL§f Voce ativou suas Mensagens §a§lPRIVADAS");
			} else if (args[0].toLowerCase().equalsIgnoreCase("off")) {
				telloff.add(p);
				p.sendMessage("§9§lTELL§f Voce desativou suas Mensagens §c§lPRIVADAS");
			}
			if (args.length > 1) {
				if (target == null) {
					p.sendMessage("§9§lTELL§f Jogador §cOffline");
					return true;
				}
				if (telloff.contains(target)) {
					p.sendMessage("§9§lTELL§f Este jogador nao está com as mensagens §c§lPRIVADAS§f ativada.");
					return true;
				}
				StringBuilder sb = new StringBuilder();
				for (int i = 1; i < args.length; i++) {
					sb.append(args[i]).append(" ");
				}
				String allArgs = sb.toString().trim();
				p.sendMessage("§7De Você Para §7» §f" + target.getName() + " §7➛ §e" + allArgs);
				target.sendMessage("§7De §7» §f" + p.getName() + " §7Para Você §7➛ §e" + allArgs);
				gettell.put(p, target);
				gettell.put(target, p);
			}
		} else if (label.equalsIgnoreCase("r")) {
			if (args.length == 0) {
				p.sendMessage("§9§lTELL§f Use /r (Mensagem)");
				return true;
			}
			if (!gettell.containsKey(p)) {
				p.sendMessage("§9§lTELL§f Nao foi achado um player recente.");
				return true;
			}
			Player deslogo = (Player) gettell.get(p);
			if (deslogo == null) {
				p.sendMessage("§9§lTELL§f Jogador Offline");
				return true;
			}
			if (telloff.contains(deslogo)) {
				p.sendMessage("§9§lTELL§f Este player esta com o tell desativado.");
				return true;
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < args.length; i++) {
				sb.append(args[i]).append(" ");
			}
			String allArgs = sb.toString().trim();
			p.sendMessage("§7De Você Para §7» §f" + deslogo.getName() + " §7➛ §e" + allArgs);
			deslogo.sendMessage("§7De §7» §f" + p.getName() + " §7Para Você §7➛ §e" + allArgs);
		}
		return false;
	}

}