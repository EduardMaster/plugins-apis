package Pedrao.Comandos;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import Pedrao.Main;

public class Sc
  implements Listener, CommandExecutor
{
  ArrayList<String> staff = Main.staff;
  
  @SuppressWarnings("deprecation")
@EventHandler
  public void onChat(AsyncPlayerChatEvent e)
  {
    Player p = e.getPlayer();
    Player[] arrayOfPlayer;
    int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
    for (int i = 0; i < j; i++)
    {
      Player online = arrayOfPlayer[i];
      if (isStaffChatting(p))
      {
        e.setCancelled(true);
        if ((online.hasPermission("kitpvp.sc")) || (isStaffChatting(online))) {
          online.sendMessage(Main.prefix + "§6§oStaffChat: " + ChatColor.AQUA + ChatColor.ITALIC.toString() + p.getName() + "§a§l>> " + "§6§o" + e.getMessage());
        }
      }
    }
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (!(sender instanceof Player)) {
      return true;
    }
    Player p = (Player)sender;
    if ((cmd.getName().equalsIgnoreCase("sc")) && (p.hasPermission("kitpvp.sc"))) {
      if (isStaffChatting(p))
      {
        this.staff.remove(p.getName());
        p.sendMessage(Main.prefix + "Voce saiu do chat da staff.");
      }
      else
      {
        this.staff.add(p.getName());
        p.sendMessage(Main.prefix + "Voce entrou no chat da staff.");
      }
    }
    return false;
  }
  
  public boolean isStaffChatting(Player player)
  {
    if (this.staff.contains(player.getName())) {
      return true;
    }
    return false;
  }
}
