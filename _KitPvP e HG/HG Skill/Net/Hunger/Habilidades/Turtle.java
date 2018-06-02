package Net.Hunger.Habilidades;

import java.util.ArrayList;

import org.bukkit.Effect;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import Net.Hunger.Main;
import Net.Hunger.Comandos.CMDKit;
import Net.Hunger.Manager.Habilidade;

public class Turtle implements Listener {
		
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e) {
	if (!(e.getEntity() instanceof Player)) {
	return;
	}
	if(Main.Partida) {
	Player p = (Player) e.getEntity();
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