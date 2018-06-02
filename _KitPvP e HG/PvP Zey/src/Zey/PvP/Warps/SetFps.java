package Zey.PvP.Warps;

import org.bukkit.event.*;

import Zey.PvP.Main.*;

import org.bukkit.command.*;
import org.bukkit.entity.*;

public class SetFps implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public SetFps(final Main main) {
        SetFps.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("fpsset") && sender instanceof Player) {
            if (!sender.hasPermission("zey.pvp.set")) {
                final Player p = (Player)sender;
                p.sendMessage("§cVocê não tem permissão para isso.");
            }
            if (sender.hasPermission("zey.pvp.set")) {
                final Player p = (Player)sender;
                SetFps.plugin.getConfig().set("fps.x", (Object)p.getLocation().getX());
                SetFps.plugin.getConfig().set("fps.y", (Object)p.getLocation().getY());
                SetFps.plugin.getConfig().set("fps.z", (Object)p.getLocation().getZ());
                SetFps.plugin.getConfig().set("fps.pitch", (Object)p.getLocation().getPitch());
                SetFps.plugin.getConfig().set("fps.yaw", (Object)p.getLocation().getYaw());
                SetFps.plugin.getConfig().set("fps.world", (Object)p.getLocation().getWorld().getName());
                SetFps.plugin.saveConfig();
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §aWarp Fps foi setada com sucesso");
            }
            return true;
        }
        return false;
    }
}
