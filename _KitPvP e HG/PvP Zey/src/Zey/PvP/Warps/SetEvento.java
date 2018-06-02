package Zey.PvP.Warps;

import org.bukkit.event.*;

import Zey.PvP.Main.*;

import org.bukkit.command.*;
import org.bukkit.entity.*;

public class SetEvento implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public SetEvento(final Main main) {
        SetEvento.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("eventoset") && sender instanceof Player) {
            if (!sender.hasPermission("zey.pvp.set")) {
                final Player p = (Player)sender;
                p.sendMessage("§cVocê não tem permissão para isso.");
            }
            if (sender.hasPermission("zey.pvp.set")) {
                final Player p = (Player)sender;
                SetEvento.plugin.getConfig().set("evento.x", (Object)p.getLocation().getX());
                SetEvento.plugin.getConfig().set("evento.y", (Object)p.getLocation().getY());
                SetEvento.plugin.getConfig().set("evento.z", (Object)p.getLocation().getZ());
                SetEvento.plugin.getConfig().set("evento.pitch", (Object)p.getLocation().getPitch());
                SetEvento.plugin.getConfig().set("evento.yaw", (Object)p.getLocation().getYaw());
                SetEvento.plugin.getConfig().set("evento.world", (Object)p.getLocation().getWorld().getName());
                SetEvento.plugin.saveConfig();
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §aWarp Evento foi setada com sucesso");
            }
            return true;
        }
        return false;
    }
}
