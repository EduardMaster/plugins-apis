package Net.Hunger.Habilidades;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import Net.Hunger.Comandos.CMDKit;
import Net.Hunger.Manager.Habilidade;

public class Fireman implements Listener {
	
  @EventHandler
  public void damage(EntityDamageEvent e) {
  if (!(e.getEntity() instanceof Player)) {
  return;
  }
  Player p = (Player)e.getEntity();
  if((Habilidade.getAbility(p).equalsIgnoreCase("fireman")) && (
  (e.getCause() == EntityDamageEvent.DamageCause.LAVA) || 
  (e.getCause() == EntityDamageEvent.DamageCause.FIRE) || 
  (e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK))) {
  e.setCancelled(true);
  }
  }
  
  @EventHandler
  public void Fogo(EntityDamageByEntityEvent e) {
  if(!(e.getEntity() instanceof Player)) { 
  return;
  }
  if (!(e.getDamager() instanceof Player)) {
  return;
  }
  Player p = (Player)e.getEntity();
  Player s = (Player)e.getDamager();
  if((Habilidade.getAbility(p).equalsIgnoreCase("fireman")) && (p.getInventory().getItemInHand() != null) && 
  (p.getInventory().getItemInHand().getType() == Material.WOOD_SWORD) && 
  ((e.getEntity() instanceof LivingEntity))) {
  s.setFireTicks(50);
  }
  }
}