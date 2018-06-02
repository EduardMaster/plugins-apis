package me.rafael.vinagre.KomboPvP.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class NoBug
  implements Listener
{
  @EventHandler
  public void onPlugin(PlayerCommandPreprocessEvent event)
  {
    Player p = event.getPlayer();
    if ((!p.hasPermission("quero.vinagrete")) && (
      (event.getMessage().toLowerCase().startsWith("/shop")) || 
      (event.getMessage().toLowerCase().startsWith("/shopkits")) || 
      (event.getMessage().toLowerCase().startsWith("/ultrakombo:shop"))))
    {
      event.setCancelled(true);
      
      p.sendMessage("§6aa ");
      p.sendMessage("§2aa ");
    }
  }
}
