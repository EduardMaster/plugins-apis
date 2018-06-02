package Pedrao.Habilidades;

import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import Pedrao.KitAPI;
import Pedrao.Main;

public class Stomper implements Listener {

	public Stomper(Main main) {
	}

	  @EventHandler(priority=EventPriority.HIGH)
	  public void onPlayerStomp(EntityDamageEvent e)
	  {
	    if (!(e.getEntity() instanceof Player)) {
	      return;
	    }
	    Player p = (Player)e.getEntity();
	    if (e.getCause() == EntityDamageEvent.DamageCause.FALL)
	    {
	      if (KitAPI.Stomper.contains(p.getName()))
	      {
	        for (Entity ent : p.getNearbyEntities(4.0D, 1.5D, 4.0D)) {
	          if ((ent instanceof Player))
	          {
	            Player plr = (Player)ent;
	            if (e.getDamage() <= 4.0D)
	            {
	              e.setCancelled(true);
	              return;
	            }
	            if (plr.isSneaking())
	            {
	              plr.damage(6.0D, p);
	              plr.sendMessage(Main.prefix + "§a§oVocê foi stompado por:§c§o " + p.getName());
	            }
	            else
	            {
	              plr.damage(e.getDamage(), p);
	              plr.sendMessage(Main.prefix + "§a§oVocê foi stompado por:§c§o " + p.getName());
	            }
	          }
	        }
	        e.setDamage(4.0D);
	        return;
	      }
	      return;
	    }
	  }
	  

}