package Zey.PvP.Commands;

import org.bukkit.entity.*;

import Zey.PvP.Main.Main;

import java.util.*;
import org.bukkit.command.*;
import org.bukkit.*;

public class TellCommand implements CommandExecutor
{
    public static HashMap<Player, Player> gettell;
    static ArrayList<Player> telloff;
    
    static {
        TellCommand.gettell = new HashMap<Player, Player>();
        TellCommand.telloff = new ArrayList<Player>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("tell")) {
            if (args.length == 0) {
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §cErrado, utilize a sintaxe correta: /tell [Jogador(a)] (msg)");
                return true;
            }
            final Player target = Bukkit.getPlayer(args[0]);
            if (args[0].toLowerCase().equalsIgnoreCase("on")) {
                TellCommand.telloff.remove(p);
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você §a§lHABILITOU §7seu tell");
            }
            else if (args[0].toLowerCase().equalsIgnoreCase("off")) {
                TellCommand.telloff.add(p);
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você §c§lDESABILITOU §7seu tell");
            }
            if (args.length > 1) {
                if (target == null) {
                    p.sendMessage(String.valueOf(Main.prefix) + " §7» §cEste jogador(a) está offline ou não existe.");
                    return true;
                }
                if (TellCommand.telloff.contains(target)) {
                    p.sendMessage(String.valueOf(Main.prefix) + " §7» §cO tell desse player esta desabilitado.");
                    return true;
                }
                final StringBuilder sb = new StringBuilder();
                for (int i = 1; i < args.length; ++i) {
                    sb.append(args[i]).append(" ");
                }
                final String allArgs = sb.toString().trim();
                p.sendMessage("§eEu §7» §r" + target.getDisplayName() + "§7:§e " + allArgs);
                target.sendMessage("§e" + p.getDisplayName() + " §7» §7Eu §7:§e " + allArgs);
                TellCommand.gettell.put(p, target);
                TellCommand.gettell.put(target, p);
            }
        }
        else if (label.equalsIgnoreCase("off")) {
            if (args.length == 0) {
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §cO tell desse player esta desabilitado.");
                return true;
            }
            if (!TellCommand.gettell.containsKey(p)) {
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você não tem ninguem para responder.");
                return true;
            }
            final Player deslogo = TellCommand.gettell.get(p);
            if (deslogo == null) {
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §cEste jogador(a) está offline ou não existe.");
                return true;
            }
            if (TellCommand.telloff.contains(deslogo)) {
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §cO tell desse player esta desabilitado.");
                return true;
            }
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < args.length; ++i) {
                sb.append(args[i]).append(" ");
            }
            final String allArgs = sb.toString().trim();
            p.sendMessage("§eEu §7» §r" + deslogo.getDisplayName() + "§7:§e " + allArgs);
            deslogo.sendMessage("§e" + p.getDisplayName() + " §7» §7Eu §7:§e: " + allArgs);
        }
        return false;
    }
}
