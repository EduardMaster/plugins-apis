package me.recenthg.Kits;

import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import me.recenthg.Main;
import me.recenthg.Manager.Habilidade;
import me.recenthg.Utils.Estado;


public class Turtle implements Listener {
		
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e) {
	if (!(e.getEntity() instanceof Player)) {
	return;
	}
	if(Main.estados == Estado.ANDAMENTO) {
	Player p = (Player) e.getEntity();
	 if (Main.estados == Estado.INVENCIBILIDADE || Main.estados == Estado.ANDAMENTO)
	if (Habilidade.getAbility(p).equalsIgnoreCase("turtle")) {
	if (p.isSneaking()) {
	if ((e.getCause() == DamageCause.BLOCK_EXPLOSION)
	|| (e.getCause() == DamageCause.CONTACT)
	|| (e.getCause() == DamageCause.CUSTOM)
	|| (e.getCause() == DamageCause.DROWNING)
	|| (e.getCause() == DamageCause.ENTITY_ATTACK)
	|| (e.getCause() == DamageCause.ENTITY_EXPLOSION)
	|| (e.getCause() == DamageCause.FALL)
	|| (e.getCause() == DamageCause.FALLING_BLOCK)
	|| (e.getCause() == DamageCause.FIRE)
	|| (e.getCause() == DamageCause.FIRE_TICK)
	|| (e.getCause() == DamageCause.LAVA)
	|| (e.getCause() == DamageCause.LIGHTNING)
	|| (e.getCause() == DamageCause.MAGIC)
	|| (e.getCause() == DamageCause.MELTING)
	|| (e.getCause() == DamageCause.POISON)
	|| (e.getCause() == DamageCause.PROJECTILE)
	|| (e.getCause() == DamageCause.STARVATION)
	|| (e.getCause() == DamageCause.SUFFOCATION)
	|| (e.getCause() == DamageCause.THORNS)
	|| (e.getCause() == DamageCause.VOID)
	|| (e.getCause() == DamageCause.WITHER)) {
	e.setDamage(1.5D);
    p.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 3);
	return;
	}
	}
	}
  }
 }
}