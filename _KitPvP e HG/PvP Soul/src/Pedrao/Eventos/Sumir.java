package Pedrao.Eventos;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;

import Pedrao.Main;


public class Sumir
  implements Listener
{
  public static Main plugin;
  
  public Sumir(Main main)
  {
    plugin = main;
  }
  
  @EventHandler
  public void onItemDrop(final ItemSpawnEvent e)
  {
    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
    {
      public void run()
      {
        e.getEntity().remove();
      }
    }, 5L);
  }
}
