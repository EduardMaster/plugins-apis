package Pedrao.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Pedrao.Main;

public class cc
  implements CommandExecutor, Listener
{
  public cc(Main main) {
	}

@SuppressWarnings({ })
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage(ChatColor.RED + "Voce nao e um jogador!");
      return false;
    }
    Player p = (Player)sender;
    if (commandLabel.equalsIgnoreCase("cc"))
    {
      if (p.hasPermission("kitpvp.cc"))
      {
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage("");
        Bukkit.getServer().broadcastMessage(Main.prefix + "§a§lChat Limpo");
      }
      return false;
    }
    return false;
  }
}
