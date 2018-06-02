package me.rafael.vinagre.KomboPvP.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.rafael.vinagre.KomboPvP.*;

import org.bukkit.entity.*;



import java.util.*;
import org.bukkit.command.*;
import org.bukkit.*;

public class Tell implements CommandExecutor
{
    public static HashMap<Player, Player> gettell;
    static ArrayList<Player> telloff;
    
    static {
        Tell.gettell = new HashMap<Player, Player>();
        Tell.telloff = new ArrayList<Player>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("tell")) {
            if (args.length == 0) {
                p.sendMessage(String.valueOf( "§cSintaxe correta /tell (nome) (msg)"));
                return true;
            }
            final Player target = Bukkit.getPlayer(args[0]);
            if (args[0].toLowerCase().equalsIgnoreCase("on")) {
                Tell.telloff.remove(p);
                p.sendMessage(String.valueOf( "§7Voc\u00ea §bativou §7seu tell"));
            }
            else if (args[0].toLowerCase().equalsIgnoreCase("off")) {
                Tell.telloff.add(p);
                p.sendMessage(String.valueOf( "§7Voc\u00ea §bdesativou §7seu tell"));
            }
            if (args.length > 1) {
                if (target == null) {
                    p.sendMessage("§cEsse jogador esta offline");
                    return true;
                }
                if (Tell.telloff.contains(target)) {
                    p.sendMessage(String.valueOf( "§cO tell desse player esta off"));
                    return true;
                }
                final StringBuilder sb = new StringBuilder();
                for (int i = 1; i < args.length; ++i) {
                    sb.append(args[i]).append(" ");
                }
                final String allArgs = sb.toString().trim();
                p.sendMessage("§7[§aEu§r --> §a" + target.getDisplayName() + "§7]§f: " + allArgs);
                target.sendMessage("§7[§a" + p.getDisplayName() + " §f--> §aEu§7]§f: " + allArgs);
                Tell.gettell.put(p, target);
                Tell.gettell.put(target, p);
            }
        }
        else if (label.equalsIgnoreCase("off")) {
            if (args.length == 0) {
                p.sendMessage(String.valueOf( "§7fale com o player no chat normal"));
                return true;
            }
            if (!Tell.gettell.containsKey(p)) {
                p.sendMessage(String.valueOf("§7Voc\u00ea n\u00e3o tem ninguem para responder"));
                return true;
            }
            final Player deslogo = Tell.gettell.get(p);
            if (deslogo == null) {
                p.sendMessage("§cEsse jogador não esta online");
                return true;
            }
            if (Tell.telloff.contains(deslogo)) {
                p.sendMessage(String.valueOf("§cO tell desse player esta off"));
                return true;
            }
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < args.length; ++i) {
                sb.append(args[i]).append(" ");
            }
            final String allArgs = sb.toString().trim();
            p.sendMessage("§7[§aEu§r --> §a" + deslogo.getDisplayName() + "§7]§f: " + allArgs);
            deslogo.sendMessage("§7[§a" + p.getDisplayName() + " §f--> §aEu§7]§f: " + allArgs);
        }
        return false;
    }
}


