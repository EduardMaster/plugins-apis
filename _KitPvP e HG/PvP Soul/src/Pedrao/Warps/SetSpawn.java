package Pedrao.Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Pedrao.Main;

public class SetSpawn
implements CommandExecutor {
    public static Main plugin;

    public SetSpawn(Main main) {
        plugin = main;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("setspawn") && sender instanceof Player) {
            Player p1;
            if (!sender.hasPermission("kitpvp.setwarp")) {
                p1 = (Player)sender;
                p1.sendMessage(Main.semperm);
            }
            if (sender.hasPermission("kitpvp.setwarp")) {
                p1 = (Player)sender;
                plugin.getConfig().set("spawn.x", (Object)p1.getLocation().getX());
                plugin.getConfig().set("spawn.y", (Object)p1.getLocation().getY());
                plugin.getConfig().set("spawn.z", (Object)p1.getLocation().getZ());
                plugin.getConfig().set("spawn.pitch", (Object)Float.valueOf(p1.getLocation().getPitch()));
                plugin.getConfig().set("spawn.yaw", (Object)Float.valueOf(p1.getLocation().getYaw()));
                plugin.getConfig().set("spawn.world", (Object)p1.getLocation().getWorld().getName());
                plugin.saveConfig();
                p1.sendMessage(Main.prefix + "Spawn setada com sucesso");
                p1.getWorld().setSpawnLocation(p1.getLocation().getBlockX(), p1.getLocation().getBlockY(), p1.getLocation().getBlockZ());
            }
            return false;
        }
        return false;
    }
}

