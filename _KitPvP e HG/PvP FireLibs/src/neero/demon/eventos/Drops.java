package neero.demon.eventos;

import neero.demon.Main;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.util.Vector;


public class Drops
  implements Listener
{
  @EventHandler
  public void onItemDrop(final ItemSpawnEvent e)
  {
    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
    {
      public void run()
      {
        Vector vector = e.getLocation().getDirection();
        vector.multiply(0.0F);
        vector.setY(0.6F);
        e.getEntity().setVelocity(vector);
      }
    }, 20L);
    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
    {
      public void run()
      {
        e.getEntity().remove();
      }
    }, 60L);
    
    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
    {
      public void run()
      {
        e.getEntity().remove();
      }
    }, 65L);
  }
}
