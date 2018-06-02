package Zey.PvP.Commands;

import org.bukkit.event.*;

import Zey.PvP.Main.*;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class PvPCommand implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (!cmd.getName().equalsIgnoreCase("pvp") || (!sender.hasPermission("zey.pvp.pvp") && !sender.isOp())) {
            return false;
        }
        if (p.getWorld().getPVP()) {
            p.getWorld().setPVP(false);
            Bukkit.getServer().broadcastMessage(String.valueOf(Main.prefix) + " §7» §7O PvP do servidor foi §c§lDESATIVADO§7.");
            return true;
        }
        p.getWorld().setPVP(true);
        Bukkit.getServer().broadcastMessage(String.valueOf(Main.prefix) + " §7» §7O PvP do servidor foi §a§lATIVADO§7.");
        return true;
    }
}
