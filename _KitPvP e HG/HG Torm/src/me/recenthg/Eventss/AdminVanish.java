package me.recenthg.Eventss;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class AdminVanish
  implements Listener
{
  public static ArrayList<Player> vanished = new ArrayList<Player>();
  
  @SuppressWarnings("deprecation")
public static void makeVanished(Player p)
  {
    Player[] arrayOfPlayer;
    int j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length;
    for (int i = 0; i < j; i++)
    {
      Player player = arrayOfPlayer[i];
      if (!player.getName().equals(p.getName())) {
        if (!player.hasPermission("Effects.Admin")) {
        	player.hidePlayer(p);
        }
      }
    }
    if (!vanished.contains(p)) {
      vanished.add(p);
    }
  }
  
  public static boolean isVanished(Player p)
  {
    return vanished.contains(p);
  }
  
  @SuppressWarnings("deprecation")
public static void updateVanished()
  {
    Player[] arrayOfPlayer;
    int j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length;
    for (int i = 0; i < j; i++)
    {
      Player p = arrayOfPlayer[i];
      if (isVanished(p)) {
        makeVanished(p);
      } else {
        makeVisible(p);
      }
    }
  }
  
  @SuppressWarnings("deprecation")
public static void makeVisible(Player p)
  {
    Player[] arrayOfPlayer;
    int j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length;
    for (int i = 0; i < j; i++)
    {
      Player player = arrayOfPlayer[i];
      player.showPlayer(p);
    }
    if (vanished.contains(p)) {
      vanished.remove(p);
    }
  }
}