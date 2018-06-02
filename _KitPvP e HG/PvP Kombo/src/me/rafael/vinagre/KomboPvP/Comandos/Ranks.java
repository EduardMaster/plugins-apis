package me.rafael.vinagre.KomboPvP.Comandos;

import org.bukkit.command.*;
import org.bukkit.entity.*;

import Scoreboard.ScoreDoBasic;
import me.rafael.vinagre.KomboPvP.Main;

import org.bukkit.*;

public class Ranks implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("rank")) {
            if (args.length == 0) {
                p.sendMessage(String.valueOf((Main.getPlugin().getConfig().getString("NomeServer").replace("&", "§"))) + "§c§l>> §7Seu rank \u00e9: " + ScoreDoBasic.getRank(p));
                return true;
            }
            if (args.length > 0 && args.length < 2) {
                final Player t = Bukkit.getServer().getPlayer(args[0]);
                if (t != null) {
                    p.sendMessage(String.valueOf((Main.getPlugin().getConfig().getString("NomeServer").replace("&", "§"))) + "§c§l>> §7O rank de: §5" + t.getDisplayName() + " §7\u00e9: " + ScoreDoBasic.getRank(t));
                    return true;
                }
            }
          
            }
        
        return false;
    }
}

