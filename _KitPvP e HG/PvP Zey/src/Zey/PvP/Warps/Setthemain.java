package Zey.PvP.Warps;

import org.bukkit.event.*;

import Zey.PvP.Main.*;

import org.bukkit.command.*;
import org.bukkit.entity.*;

public class Setthemain implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Setthemain(final Main main) {
        Setthemain.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("mainset") && sender instanceof Player) {
            if (!sender.hasPermission("zey.pvp.set")) {
                final Player p = (Player)sender;
                p.sendMessage("§cVocê não tem permissão para isso.");
            }
            if (sender.hasPermission("zey.pvp.set")) {
                final Player p = (Player)sender;
                Setthemain.plugin.getConfig().set("themain.x", (Object)p.getLocation().getX());
                Setthemain.plugin.getConfig().set("themain.y", (Object)p.getLocation().getY());
                Setthemain.plugin.getConfig().set("themain.z", (Object)p.getLocation().getZ());
                Setthemain.plugin.getConfig().set("themain.pitch", (Object)p.getLocation().getPitch());
                Setthemain.plugin.getConfig().set("themain.yaw", (Object)p.getLocation().getYaw());
                Setthemain.plugin.getConfig().set("themain.world", (Object)p.getLocation().getWorld().getName());
                Setthemain.plugin.saveConfig();
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §aWarp Main foi setado com sucesso");
            }
            return true;
        }
        return false;
    }
}
