package Pedrao.Habilidades;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;

import Pedrao.KitAPI;
import Pedrao.Main;

public class Anchor implements Listener {

	public Anchor(Main main) {
	}

	  @SuppressWarnings("deprecation")
	@EventHandler
	  public void AnchorEvent(EntityDamageByEntityEvent e)
	  {
	    if (((e.getEntity() instanceof Player)) && 
	      ((e.getDamager() instanceof Player)))
	    {
	      final Player p = (Player)e.getEntity();
	      Player d = (Player)e.getDamager();
	      if (KitAPI.Anchor.contains(d.getName()))
	      {
	        p.setVelocity(new Vector());
	        Bukkit.getServer().getScheduler()
	          .scheduleAsyncDelayedTask(Main.plugin, new Runnable()
	          {
	            public void run()
	            {
	              p.setVelocity(new Vector());
	            }
	          }, 1L);
	      }
	    }
	  }
	  
	  @SuppressWarnings("deprecation")
	@EventHandler
	  public void AnchorKiller(EntityDamageByEntityEvent e)
	  {
	    if (((e.getEntity() instanceof Player)) && 
	      ((e.getDamager() instanceof Player)))
	    {
	      final Player p = (Player)e.getEntity();
	      if (KitAPI.Anchor.contains(p.getName()))
	      {
	        p.setVelocity(new Vector());
	        Bukkit.getServer().getScheduler()
	          .scheduleAsyncDelayedTask(Main.plugin, new Runnable()
	          {
	            public void run()
	            {
	              p.setVelocity(new Vector());
	            }
	          }, 1L);
	      }
	    }
	  }
}
	  