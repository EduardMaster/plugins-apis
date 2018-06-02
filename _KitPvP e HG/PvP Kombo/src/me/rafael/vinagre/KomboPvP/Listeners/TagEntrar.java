package me.rafael.vinagre.KomboPvP.Listeners;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class TagEntrar
  implements Listener
{
  @EventHandler
  public void aoEntrarTag(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();
    p.chat("/tag normal");
  }
}
     

