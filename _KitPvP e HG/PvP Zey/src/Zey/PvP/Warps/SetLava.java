package Zey.PvP.Warps;

import org.bukkit.event.*;

import Zey.PvP.Main.*;

import org.bukkit.command.*;
import org.bukkit.entity.*;

public class SetLava implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public SetLava(final Main main) {
        SetLava.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("challengeset") && sender instanceof Player) {
            if (!sender.hasPermission("zey.pvp.set")) {
                final Player p = (Player)sender;
                p.sendMessage("§cVocê não tem permissão para isso.");
            }
            if (sender.hasPermission("zey.pvp.set")) {
                final Player p = (Player)sender;
                SetLava.plugin.getConfig().set("lava.x", (Object)p.getLocation().getX());
                SetLava.plugin.getConfig().set("lava.y", (Object)p.getLocation().getY());
                SetLava.plugin.getConfig().set("lava.z", (Object)p.getLocation().getZ());
                SetLava.plugin.getConfig().set("lava.pitch", (Object)p.getLocation().getPitch());
                SetLava.plugin.getConfig().set("lava.yaw", (Object)p.getLocation().getYaw());
                SetLava.plugin.getConfig().set("lava.world", (Object)p.getLocation().getWorld().getName());
                SetLava.plugin.saveConfig();
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §aWarp Challenge foi setada com sucesso");
            }
            return true;
        }
        return false;
    }
}
