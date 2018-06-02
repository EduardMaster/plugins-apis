package Net.Hunger.Habilidades;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import Net.Hunger.Comandos.CMDKit;
import Net.Hunger.Manager.Habilidade;

public class Switcher implements Listener {
	
	  @EventHandler
	  public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
	      Entity ent = e.getEntity();
	      Entity damager = e.getDamager();
	      if(ent instanceof Player) {
	          Player hit = (Player) ent;
	          if(damager instanceof Snowball) {
	              Snowball snowball = (Snowball) damager;
	              if(snowball.getShooter() instanceof Player) {
	                  Player shooter = (Player) snowball.getShooter();
	                  if((Habilidade.getAbility(shooter).equalsIgnoreCase("switcher"))) {
	                  Location ploc = shooter.getLocation();
	                  Location hitloc = hit.getLocation();
	                  shooter.teleport(hitloc);
	                  hit.teleport(ploc);
	              }
	          }
	      }
	  }
	  }
}