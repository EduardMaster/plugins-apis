package Zey.PvP.Utils;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class Proteção implements Listener{

	  @SuppressWarnings({ "unchecked", "rawtypes" })
	private static HashMap<Player, ImortalEnum> imortal = new HashMap();
	  @EventHandler
	  public void dano(EntityDamageEvent e){
	    if ((e.getEntity() instanceof Player && e.getCause() != DamageCause.LAVA)){
	      Player p = (Player)e.getEntity();
	      if (isImortal(p))
	        e.setCancelled(true);
	      
	     
	      }
	    }

	  @EventHandler
	  public void entityDamage(EntityDamageByEntityEvent e)  {
		  Player d = (Player) e.getEntity();
		  if(e.getCause() == DamageCause.FALL) {
		      if (isImortal(d))
			        e.setCancelled(true);
		  }
	    if ((e.getDamager() instanceof Player))   {
	      Player p = (Player)e.getDamager();
	      if (isImortal(p))
	        e.setCancelled(true);
	
	    }
	  }

	  public static ImortalEnum getImortal(Player p)
	  {
	    return (ImortalEnum)imortal.get(p);
	  }

	  public static boolean isImortal(Player p)
	  {
	    if (getImortal(p) == ImortalEnum.ON) {
	      return true;
	    }
	    return false;
	  }

	  public static void setImortal(Player p, boolean i)
	  {
	    if (i)
	      imortal.put(p, ImortalEnum.ON);
	    else
	      imortal.put(p, ImortalEnum.OFF);
	  }

}
