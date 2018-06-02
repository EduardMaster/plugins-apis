package me.rafael.vinagre.KomboPvP.Comandos;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Fly
  implements CommandExecutor, Listener
{
  public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args)
  {
    if ((sender instanceof Player))
    {
      if (cmd.getName().equalsIgnoreCase("fly"))
      {
        Player player = (Player)sender;
        if ((args.length == 0) && 
          (sender.hasPermission("kitpvp.fly"))) {
          if (!player.getAllowFlight())
          {
            player.sendMessage(ChatColor.GREEN + "[ §3! §a]  §3Fly Ativado");
            player.setAllowFlight(true);
          }
          else
          {
            player.sendMessage(ChatColor.GREEN + "[ §3!§a] §3Fly Desativado");
            player.setAllowFlight(false);
          }
        }
        if ((args.length == 1) && 
          (sender.hasPermission("kitpvp.darfly")))
        {
          Player player2 = Bukkit.getPlayer(args[0]);
          if (player2 == null)
          {
            sender.sendMessage(ChatColor.RED + "Jogador Offline");
            return true;
          }
          if (!player2.getAllowFlight())
          {
            sender.sendMessage(ChatColor.GREEN + "Voo Habilitado para " + player2.getName());
            player2.setAllowFlight(true);
            player2.sendMessage(ChatColor.GREEN + "Voo Habilitado por " + player.getName());
          }
          else
          {
            sender.sendMessage(ChatColor.GREEN + "Voo Desabilitado para " + player2.getName());
            player2.setAllowFlight(false);
            player2.sendMessage(ChatColor.GREEN + "Voo Desabilitado por " + player.getName());
          }
        }
      }
    }
    else {
      sender.sendMessage(ChatColor.RED + "Voce deve ser um usuario!");
    }
    return false;
  }
}
