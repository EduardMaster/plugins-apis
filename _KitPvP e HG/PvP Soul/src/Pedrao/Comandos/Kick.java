package Pedrao.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Pedrao.Main;

public class Kick
  implements CommandExecutor, Listener
{
  public static Main plugin;
  
  public Kick(Main main)
  {
    plugin = main;
  }
  
  public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args)
  {
    if (Cmd.getName().equalsIgnoreCase("Kick"))
    {
      Player p = (Player)Sender;
      if (!p.hasPermission("kitpvp.Kick"))
      {
        p.sendMessage(Main.semperm);
        return true;
      }
      if (Args.length == 0)
      {
        p.sendMessage(Main.prefix + "§c Use: /Kick <Jogador> <Motivo> ");
      }
      else if (Args.length == 1)
      {
        Player targetPlayer = p.getServer().getPlayer(Args[0]);
        if (targetPlayer == null) {
          p.sendMessage(Main.prefix + "§c " + Args[0] + " Não Esta Online! ");
        } else {
          p.sendMessage(Main.prefix + "§c Use: /Kick <Jogador> <Motivo>");
        }
      }
      else if (Args.length > 1)
      {
        Player targetPlayer = p.getServer().getPlayer(Args[0]);
        if (targetPlayer == null)
        {
          p.sendMessage(Main.prefix + "§c " + Args[0] + " Não Esta Online!");
        }
        else
        {
          String message = "";
          for (int i = 1; i < Args.length; i++) {
            message = message + Args[i] + " ";
          }
          targetPlayer.kickPlayer(Main.prefix + "§7 Você foi kickado pelo Jogador: §c" + p.getName() + "\n §7Motivo: §c" + message + " ");
          Bukkit.broadcastMessage(Main.prefix + "§c " + targetPlayer.getName() + " §7Foi kickado pelo Jogador: §c" + 
            p.getName() + " §7Motivo: §c" + message + "");
        }
      }
    }
    return false;
  }
}
