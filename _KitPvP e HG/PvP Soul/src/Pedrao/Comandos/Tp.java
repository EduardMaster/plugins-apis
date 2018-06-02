package Pedrao.Comandos;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Pedrao.Main;

public class Tp
  implements CommandExecutor, Listener
{
  public Tp(Main main) {
	}

public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("tp"))
    {
      if ((sender instanceof ConsoleCommandSender))
      {
        System.out.println("Console nao pode usar esse comando");
        return true;
      }
      Player p = (Player)sender;
      if (args.length == 0) {
        p.sendMessage(Main.prefix + "Use /tp <player> ou /tp <player> <player2>");
      } else if (args.length == 1)
      {
        if ((p.hasPermission("kitpvp.tp")) || (p.isOp()))
        {
          Player targetPlayer = p.getServer().getPlayer(args[0]);
          Location tpLoc = targetPlayer.getLocation();
          p.teleport(tpLoc);
          p.sendMessage(Main.prefix + "Teleportado para " + targetPlayer.getDisplayName() + ChatColor.GRAY + ".");
        }
        else
        {
          p.sendMessage(Main.semperm);
        }
      }
      else if (args.length == 2) {
        if ((p.hasPermission("kitpvp.tp")) || (p.isOp()))
        {
          Player targetPlayer = p.getServer().getPlayer(args[0]);
          Player targetPlayer2 = p.getServer().getPlayer(args[1]);
          if ((targetPlayer == null) || (targetPlayer2 == null))
          {
            p.sendMessage(Main.prefix + "§4oJogador Offline!");
          }
          else
          {
            Location tpLoc = targetPlayer2.getLocation();
            targetPlayer.teleport(tpLoc);
            p.sendMessage(Main.prefix + "Voce foi teleportado " + targetPlayer.getDisplayName() + ChatColor.GRAY + " para " + targetPlayer2.getDisplayName() + ChatColor.RED + ".");
          }
        }
        else
        {
            p.sendMessage(Main.semperm);
        }
      }
    }
    return false;
  }
}
