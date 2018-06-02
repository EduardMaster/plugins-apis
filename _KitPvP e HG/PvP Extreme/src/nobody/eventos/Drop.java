package nobody.eventos;


import nobody.main.Main;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class Drop implements Listener
{
	
	  @EventHandler
	  @SuppressWarnings ("deprecation")
	  public void aoDropar(PlayerDropItemEvent e)
	  {
	    if (e.getItemDrop().getItemStack().getTypeId() == 267) {
	      e.setCancelled(true);
	    }
	    if (e.getItemDrop().getItemStack().getTypeId() == 268) {
	      e.setCancelled(true);
	    }
	    if (e.getItemDrop().getItemStack().getTypeId() == 19) {
	      e.setCancelled(true);
	    }
	    if (e.getItemDrop().getItemStack().getTypeId() == 352) {
	      e.setCancelled(true);
	    }
	    if (e.getItemDrop().getItemStack().getTypeId() == 347) {
	      e.setCancelled(true);
	    }
	    if (e.getItemDrop().getItemStack().getTypeId() == 370) {
	      e.setCancelled(true);
	    }
	    if (e.getItemDrop().getItemStack().getTypeId() == 272) {
	      e.setCancelled(true);
	    }
	    if (e.getItemDrop().getItemStack().getTypeId() == 276) {
	      e.setCancelled(true);
	    }
	    if (e.getItemDrop().getItemStack().getTypeId() == 145) {
		      e.setCancelled(true);
		 }
	    if (e.getItemDrop().getItemStack().getTypeId() == 384) {
		      e.setCancelled(true);
		    }
	    if (e.getItemDrop().getItemStack().getTypeId() == 339) {
		      e.setCancelled(true);
		    }
	    if (e.getItemDrop().getItemStack().getTypeId() == 342) {
		      e.setCancelled(true);
		    }
	    if (e.getItemDrop().getItemStack().getTypeId() == 421) {
		      e.setCancelled(true);
		    }
	    if (e.getItemDrop().getItemStack().getTypeId() == 33) {
		      e.setCancelled(true);
		    }
	    if (e.getItemDrop().getItemStack().getTypeId() == 283) {
	      e.setCancelled(true);
	    }
	    if (e.getItemDrop().getItemStack().getTypeId() == 261) {
	      e.setCancelled(true);
	    }
	    if (e.getItemDrop().getItemStack().getTypeId() == 280) {
	      e.setCancelled(true);
	    }
	    if (e.getItemDrop().getItemStack().getTypeId() == 334) {
	      e.setCancelled(true);
	    }
	    if (e.getItemDrop().getItemStack().getTypeId() == 401) {
	      e.setCancelled(true);
	    }
	    if (e.getItemDrop().getItemStack().getTypeId() == 399) {
	      e.setCancelled(true);
	    }
	    if (e.getItemDrop().getItemStack().getTypeId() == 369) {
	      e.setCancelled(true);
	    }
	    if (e.getItemDrop().getItemStack().getTypeId() == 340) {
	      e.setCancelled(true);
	    }
	    if (e.getItemDrop().getItemStack().getTypeId() == 288) {
	      e.setCancelled(true);
	    }
	    if (e.getItemDrop().getItemStack().getTypeId() == 332) {
	      e.setCancelled(true);
	    }
	    if (e.getItemDrop().getItemStack().getTypeId() == 346) {
	      e.setCancelled(true);
	    }
	    if (e.getItemDrop().getItemStack().getTypeId() == 76) {
	      e.setCancelled(true);
	    }
	    if (e.getItemDrop().getItemStack().getTypeId() == 171 ) {
	      e.setCancelled(true);
	    }
	    if (e.getItemDrop().getItemStack().getTypeId() == 345) {
	      e.setCancelled(true);
	    if (e.getItemDrop().getItemStack().getTypeId() == 275) {
	      e.setCancelled(true);
	    }
	    if (e.getItemDrop().getItemStack().getTypeId() == 90) {
	      e.setCancelled(true);
	    }
	    if (e.getItemDrop().getItemStack().getTypeId() == 420) {
	      e.setCancelled(true);
	    }
	    if (e.getItemDrop().getItemStack().getTypeId() == 101) {
	      e.setCancelled(true);
	    }
	    }
	  }
	  
	  @EventHandler
	  public void onItemDrop(final ItemSpawnEvent e)
	  {
	    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
	    {
	      public void run()
	      {
	        e.getEntity().remove();
	      }
	    }, 90L);
	  }
}
