package me.rafael.vinagre.KomboPvP.Comandos;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Strings;

public class Broadcast
  implements CommandExecutor, Listener
{
  public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args)
  {
    Player player = (Player)sender;
    if (((commandLabel.equalsIgnoreCase("bc")) || (commandLabel.equalsIgnoreCase("broadcast"))) && (player.hasPermission("kitpvp.bc"))) {
      if (args.length >= 1)
      {
        String bcast = "";
        for (int x = 0; x < args.length; x++) {
          bcast = bcast + args[x] + " ";
        }
        bcast = ChatColor.translateAlternateColorCodes('&', bcast);
        Bukkit.broadcastMessage(((Main.getPlugin().getConfig().getString("NomeServer").replace("&", "§"))) + "§4»"  + ChatColor.RESET + bcast);
      }
      else
      {
        sender.sendMessage(ChatColor.AQUA + "Use: /broadcast [mensagem]");
      }
    }
    return false;
  }
}