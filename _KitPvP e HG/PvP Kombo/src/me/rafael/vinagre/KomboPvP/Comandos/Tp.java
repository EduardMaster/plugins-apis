package me.rafael.vinagre.KomboPvP.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Tp
  implements CommandExecutor, Listener
{
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
    if (!(sender instanceof Player)){
      return true;
    }
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("tpc")){
        int n;
        if(!p.hasPermission("kitpvp.admin")){
        	return true;
        }
        if (args.length != 3){
        	p.sendMessage("§cUse /tpc <x> <y> <z>");
        	return true;
        }
        if (args.length == 3)
        {
          double x2 = args[0].startsWith("~") ? p.getLocation().getX() + Integer.parseInt(args[0].substring(1)) : Integer.parseInt(args[0]);
          double y2 = args[1].startsWith("~") ? p.getLocation().getY() + Integer.parseInt(args[1].substring(1)) : Integer.parseInt(args[1]);
          double z2 = args[2].startsWith("~") ? p.getLocation().getZ() + Integer.parseInt(args[2].substring(1)) : Integer.parseInt(args[2]);
          if ((x2 > 3.0E7D) || (y2 > 3.0E7D) || (z2 > 3.0E7D) || (x2 < -3.0E7D) || (y2 < -3.0E7D) || (z2 < -3.0E7D)) {
            return true;
          }
          Location locpos = new Location(p.getWorld(), x2, y2, z2, p.getLocation().getYaw(), p.getLocation().getPitch());
          p.teleport(locpos);
          Player[] arrayOfPlayer3;
          n = (arrayOfPlayer3 = Bukkit.getOnlinePlayers()).length;
          for (int m = 0; m < n; m++)
          {
            Player p1 = arrayOfPlayer3[m];
            if ((p1.hasPermission("kitpvp.admin")) || (p1.isOp())) {
              p1.sendMessage("§7" + p.getName() + " foi teleportado para X:" + locpos.getBlockX() + " Y:" + locpos.getBlockY() + " Z:" + locpos.getBlockZ() + " .");
            }
          }
        }
    }
    return true;
  }
}