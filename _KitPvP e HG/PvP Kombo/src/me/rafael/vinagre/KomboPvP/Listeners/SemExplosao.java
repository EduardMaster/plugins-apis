package me.rafael.vinagre.KomboPvP.Listeners;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class SemExplosao
  implements Listener
{
  @EventHandler
  public void semExplosao(EntityExplodeEvent e)
  {
    e.setCancelled(true);
  }
}
