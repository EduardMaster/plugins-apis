package Zey.PvP.Commands;

import org.bukkit.event.*;
import Zey.PvP.Main.Main;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class CcCommand implements CommandExecutor, Listener
{
    public CcCommand(final Main main) {
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(String.valueOf(Main.prefix) + " §7» §cApenas jogadores podem usar isso.");
            return false;
        }
        final Player p = (Player)sender;
        if (commandLabel.equalsIgnoreCase("cc")) {
            if (p.hasPermission("zey.pvp.cc")) {
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("");
                Bukkit.getServer().broadcastMessage("§e§lO CHAT FOI LIMPO.");
            }
            else {
                sender.sendMessage("§cVocê não tem permissão para isso.");
            }
        }
        return false;
    }
}
