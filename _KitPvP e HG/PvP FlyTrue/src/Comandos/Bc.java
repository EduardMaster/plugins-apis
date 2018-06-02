package Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Bc
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args)
  {
    if ((commandLabel.equalsIgnoreCase("bc")) && (sender.hasPermission("fly.bc")))
    {
      if (args.length >= 1)
      {
        String bcast = "";
        for (int x = 0; x < args.length; x++) {
          bcast = bcast + args[x] + " ";
        }
        bcast = ChatColor.translateAlternateColorCodes('&', bcast);
        Bukkit.broadcastMessage("§c§lFly§7§lTrue §b: " + ChatColor.GREEN + ChatColor.ITALIC + bcast);
      }
      else
      {
        sender.sendMessage("§aUse: /bc sua mensagem");
      }
    }
    else {
      sender.sendMessage("§cVoce nao tem permissao!!");
    }
    return false;
  }
}
