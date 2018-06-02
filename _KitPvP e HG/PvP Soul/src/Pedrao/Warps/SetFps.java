package Pedrao.Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Pedrao.Main;

public class SetFps
implements Listener,
CommandExecutor {
    public static Main plugin;

    public SetFps(Main main) {
        plugin = main;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("setfps") && sender instanceof Player) {
            Player p;
            if (!sender.hasPermission("kitpvp.setwarp")) {
                p = (Player)sender;
                p.sendMessage(Main.semperm);
            }
            if (sender.hasPermission("kitpvp.setwarp")) {
                p = (Player)sender;
                plugin.getConfig().set("fps.x", (Object)p.getLocation().getX());
                plugin.getConfig().set("fps.y", (Object)p.getLocation().getY());
                plugin.getConfig().set("fps.z", (Object)p.getLocation().getZ());
                plugin.getConfig().set("fps.pitch", (Object)Float.valueOf(p.getLocation().getPitch()));
                plugin.getConfig().set("fps.yaw", (Object)Float.valueOf(p.getLocation().getYaw()));
                plugin.getConfig().set("fps.world", (Object)p.getLocation().getWorld().getName());
                plugin.saveConfig();
                p.sendMessage(Main.prefix + "Warp setada");
            }
            return true;
        }
        return false;
    }
}

