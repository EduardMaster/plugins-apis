package me.recenthg.stark.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

import me.recent.stark.Main;
import me.recent.stark.Strings;

public class Bc
  implements CommandExecutor, Listener
{
  Main main;
public Bc()
  {
  }


public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args)
  {
    if ((cmd.getName().equalsIgnoreCase("bc")) || (cmd.getName().equalsIgnoreCase("broadcast")))
    {
      if (!sender.hasPermission("HungerGames.c.bc"))
      {
    		sender.sendMessage(Strings.semperm);
        return true;
      }
      if (args.length == 0)
      {
        sender.sendMessage(ChatColor.GOLD + "§8\u276e§2§l!§8\u276f §7Use: /bc [mensagem]");
      }
      else
      {
        String message = "";
        for (String part : args)
        {
          if (message != "") {
            message = message + " ";
          }
          message = message + part;
        }
        Bukkit.getServer().broadcastMessage(ChatColor.BLUE + "§4§LAVISO " + ChatColor.DARK_GREEN + "§o§l" + message);
      }
    }
    return false;
  }
}