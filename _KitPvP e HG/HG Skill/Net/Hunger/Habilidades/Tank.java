package Net.Hunger.Habilidades;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import Net.Hunger.Comandos.CMDKit;
import Net.Hunger.Manager.Habilidade;

public class Tank implements Listener {
	
	  @EventHandler
	  public void onDamage1(EntityDamageEvent event) {
	    if ((event.getEntity() instanceof Player)) {
	      Player p = (Player)event.getEntity();
	      if((Habilidade.getAbility(p).equalsIgnoreCase("tank")) && (
	        (event.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) || (event.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION)))
	        event.setCancelled(true);
	    }
	  }
	  @EventHandler
	  public void onDamage2(EntityDamageEvent event) {
	    if ((event.getEntity() instanceof Player)) {
	      Player p = (Player)event.getEntity();
	      if((Habilidade.getAbility(p).equalsIgnoreCase("tank")) && (
	        (event.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) || (event.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION)))
	        event.setCancelled(true);
	    }
	  }
	  @EventHandler
	  public void onEntityDeath1(EntityDeathEvent event) { if ((event.getEntity() instanceof Player)) {
	      Player killed = (Player)event.getEntity();
	      if ((killed.getKiller() instanceof Player)) {
	        Player player = event.getEntity().getKiller();
		      if((Habilidade.getAbility(player).equalsIgnoreCase("tank"))) {
	          World world = killed.getWorld();
	          world.createExplosion(killed.getLocation(), 2.0F);
	        }
	      }
	    } 
	  }
}