package Zey.PvP.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Zey.PvP.Config.Status;
import Zey.PvP.Main.Main;


public class LigaCommand implements CommandExecutor {
	
    public static String Rank(final Player p) {
        final double a = Status.getKills(p);
        if (a <= 100.0) {
            return "§7(§f-§7)";
        }
        if (a <= 200.0) {
            return "§7(§a\u268c§7)";
        }
        if (a <= 300.0) {
            return "§7(§e\u2630§7)";
        }
        if (a <= 400.0) {
            return "§7(§1\u2725§7)";
        }
        if (a <= 500.0) {
            return "§7(§7\u272f§7)";
        }
        if (a <= 600.0) {
            return "§7(§6\u272a§7)";
        }
        if (a <= 700.0) {
            return "§7(§b\u2748§7)";
        }
        if (a <= 800.0) {
            return "§7(§2\u2738§7)";
        }
        if (a <= 900.0) {
            return "§7(§c\u2739§7)";
        }
        if (a <= 1000.0) {
            return "§7(§3\u2737§7)";
        }
        if (a <= 1500.0) {
            return "§7(§4✪§7)";
        }
        return "§7(§4✪§7)";
    }
    
    public static String getRankConfig(final Player p) {
        final double a = Status.getKills(p);
        if (a <= 100.0) {
            return "§7Unranked";
        }
        if (a <= 200.0) {
            return "§aINICIANTE";
        }
        if (a <= 300.0) {
            return "§eAPRENDIZ";
        }
        if (a <= 400.0) {
            return "§1EXPERT";
        }
        if (a <= 500.0) {
            return "§7SILVER";
        }
        if (a <= 600.0) {
            return "§6GOLD";
        }
        if (a <= 700.0) {
            return "§bDIAMOND";
        }
        if (a <= 800.0) {
            return "§2EMERALD";
        }
        if (a <= 900.0) {
            return "§cRUBY";
        }
        if (a <= 1000.0) {
            return "§3SAFIRA";
        }
        if (a <= 1500.0) {
            return "§4LENDARIO";
        }
        return "§4LENDARIO";
    }
    
    public static String getNomeRank(final Player p) {
        final double a = Status.getKills(p);
        if (a <= 100.0) {
            return "§7Unranked";
        }
        if (a <= 200.0) {
            return "§aINICIANTE";
        }
        if (a <= 300.0) {
            return "§eAPRENDIZ";
        }
        if (a <= 400.0) {
            return "§1EXPERT";
        }
        if (a <= 500.0) {
            return "§7SILVER";
        }
        if (a <= 600.0) {
            return "§6GOLD";
        }
        if (a <= 700.0) {
            return "§bDIAMOND";
        }
        if (a <= 800.0) {
            return "§2EMERALD";
        }
        if (a <= 900.0) {
            return "§CRUBY";
        }
        if (a <= 1000.0) {
            return "§3SAFIRA";
        }
        if (a <= 1500.0) {
            return "§4LENDARIO";
        }
        return "§4LENDARIO";
    }
    
    public static String Liga(final Player p) {
        final double a = Status.getKills(p);
        if (a <= 100.0) {
            return "§7Unranked";
        }
        if (a <= 200.0) {
            return "§aINICIANTE";
        }
        if (a <= 300.0) {
            return "§eAPRENDIZ";
        }
        if (a <= 400.0) {
            return "§1EXPERT";
        }
        if (a <= 500.0) {
            return "§7SILVER";
        }
        if (a <= 600.0) {
            return "§6GOLD";
        }
        if (a <= 700.0) {
            return "§bDIAMOND";
        }
        if (a <= 800.0) {
            return "§2EMERALD";
        }
        if (a <= 900.0) {
            return "§cRUBY";
        }
        if (a <= 1000.0) {
            return "§3SAFIRA";
        }
        if (a <= 1500.0) {
            return "§4LENDARIO";
        }
        return "§4LENDARIO";
    }
		 
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("liga")) {
			if(args.length == 0) {
				p.sendMessage(" ");
				p.sendMessage(String.valueOf(Main.prefix) + " §7» §fAqui estão há lista de todas as Ligas/Ranks, do servidor:");
				p.sendMessage("                              ");
				p.sendMessage("§7(§4✪§7) §4LENDARIO");
				p.sendMessage("§7(§3\u2737§7) §3SAFIRA");
				p.sendMessage("§7(§c\u2739§7) §cRUBY");
				p.sendMessage("§7(§2\u2738§7) §2EMERALD");
				p.sendMessage("§7(§b\u2748§7) §bDIAMOND");
				p.sendMessage("§7(§6\u272a§7) §6GOLD");
				p.sendMessage("§7(§7\u272f§7) §7SILVER");
				p.sendMessage("§7(§1\u2725§7) §1EXPERT");
				p.sendMessage("§7(§e\u2630§7) §eAPRENDIZ");
				p.sendMessage("§7(§a\u268c§7) §aINICIANTE");
				p.sendMessage("§7(§f-§7) §7Unranked");
				p.sendMessage("                              ");
				p.sendMessage(String.valueOf(Main.prefix) + " §7» §fVocê pode adquirir estas Ligas/Ranks, matando jogadores. Apos matar os jogadores você ganhara kills, e com essas kills você ira upar! Boa sorte.");
				p.sendMessage(" ");
			}
		}
		return false;
	}
}
