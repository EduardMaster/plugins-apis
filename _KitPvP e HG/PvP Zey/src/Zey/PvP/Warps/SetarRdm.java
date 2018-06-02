package Zey.PvP.Warps;

import org.bukkit.event.*;

import Zey.PvP.Main.*;

import org.bukkit.command.*;
import org.bukkit.entity.*;

public class SetarRdm implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public SetarRdm(final Main main) {
        SetarRdm.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("rdmset") && sender instanceof Player) {
            if (!sender.hasPermission("zey.pvp.set")) {
                final Player p = (Player)sender;
                p.sendMessage("§cVocê não tem permissão para isso.");
            }
            if (sender.hasPermission("zey.pvp.set")) {
                final Player p = (Player)sender;
                SetarRdm.plugin.getConfig().set("rdm.x", (Object)p.getLocation().getX());
                SetarRdm.plugin.getConfig().set("rdm.y", (Object)p.getLocation().getY());
                SetarRdm.plugin.getConfig().set("rdm.z", (Object)p.getLocation().getZ());
                SetarRdm.plugin.getConfig().set("rdm.pitch", (Object)p.getLocation().getPitch());
                SetarRdm.plugin.getConfig().set("rdm.yaw", (Object)p.getLocation().getYaw());
                SetarRdm.plugin.getConfig().set("rdm.world", (Object)p.getLocation().getWorld().getName());
                SetarRdm.plugin.saveConfig();
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §aWar Rdm foi setada com sucesso");
            }
            return true;
        }
        return false;
    }
}
