package Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Tp
  implements CommandExecutor
{
  public String[] aliases = { "tp" };
  
  @SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage(ChatColor.RED + "Voce nao e um jogador!");
      return false;
    }
    Player p = (Player)sender;
    if (p.hasPermission("fly.tp")) {
      if (args.length == 0)
      {
        p.sendMessage("§c§lFly§7§lTrue §a: §cUse: /tp <Jogador> <Alvo>");
      }
      else
      {
        int j;
        if (args.length == 1)
        {
          Player target = p.getServer().getPlayer(args[0]);
          if (target != null)
          {
            p.teleport(target.getLocation());
            Player[] arrayOfPlayer1;
            j = (arrayOfPlayer1 = Bukkit.getOnlinePlayers()).length;
            for (int i = 0; i < j; i++)
            {
              Player p1 = arrayOfPlayer1[i];
              if ((p1.hasPermission("fly.tp")) || (p1.isOp())) {
                p1.sendMessage(ChatColor.GRAY + p.getName() + " foi teleportado para " + target.getName());
              }
            }
          }
          else
          {
            p.sendMessage("§c§lFly§7§lTrue §a: §cO jogador " + args[0] + " §cnao esta online.");
          }
        }
        else if (args.length == 2)
        {
          Player target = p.getServer().getPlayer(args[0]);
          Player starget = p.getServer().getPlayer(args[1]);
          if (target != null)
          {
            if (starget != null)
            {
              target.teleport(starget.getLocation());
              Player[] arrayOfPlayer2;
              int k = (arrayOfPlayer2 = Bukkit.getOnlinePlayers()).length;
              for (j = 0; j < k; j++)
              {
                Player p1 = arrayOfPlayer2[j];
                if ((p1.hasPermission("fly.tp")) || (p1.isOp())) {
                  p1.sendMessage(ChatColor.GRAY + target.getName() + " foi teleportado para " + starget.getName());
                }
              }
            }
            else
            {
              p.sendMessage("§cO jogador " + args[1] + " §cnao esta online.");
            }
          }
          else {
            p.sendMessage("§cO jogador " + args[0] + " §cnao esta online.");
          }
        }
        else
        {
          int n;
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
              if ((p1.hasPermission("fly.tp")) || (p1.isOp())) {
                p1.sendMessage(ChatColor.GRAY + p.getName() + " foi teleportado para X:" + locpos.getBlockX() + " Y:" + locpos.getBlockY() + " Z:" + locpos.getBlockZ() + " .");
              }
            }
          }
          else if (args.length == 4)
          {
            Player target = p.getServer().getPlayer(args[0]);
            double x2 = args[1].startsWith("~") ? target.getLocation().getX() + Integer.parseInt(args[0].substring(1)) : Integer.parseInt(args[1]);
            double y2 = args[2].startsWith("~") ? target.getLocation().getY() + Integer.parseInt(args[1].substring(1)) : Integer.parseInt(args[2]);
            double z2 = args[3].startsWith("~") ? target.getLocation().getZ() + Integer.parseInt(args[2].substring(1)) : Integer.parseInt(args[3]);
            if ((x2 > 3.0E7D) || (y2 > 3.0E7D) || (z2 > 3.0E7D) || (x2 < -3.0E7D) || (y2 < -3.0E7D) || (z2 < -3.0E7D) || (target == null)) {
              return true;
            }
            Location locpos = new Location(p.getWorld(), x2, y2, z2, target.getLocation().getYaw(), target.getLocation().getPitch());
            target.teleport(locpos);
            Player[] arrayOfPlayer4;
            int i1 = (arrayOfPlayer4 = Bukkit.getOnlinePlayers()).length;
            for (n = 0; n < i1; n++)
            {
              Player p1 = arrayOfPlayer4[n];
              if ((p1.hasPermission("fly.tp")) || (p1.isOp())) {
                p1.sendMessage(ChatColor.GRAY + target.getName() + " foi teleportado para X:" + locpos.getBlockX() + " Y:" + locpos.getBlockY() + " Z:" + locpos.getBlockZ() + " .");
              }
            }
          }
        }
      }
    }
    return false;
  }
}
