package br.com.alpha.Habilidades;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import br.com.alpha.MCAlpha;
import br.com.alpha.ENUMs.KitsEnum;
import br.com.alpha.gamemanagement.GameTime;

public class Fireman implements Listener{
	
	@EventHandler
	public void firemanHab(EntityDamageEvent e) {
		if ((e.getEntity() instanceof Player)){
			Player p = (Player)e.getEntity();
			if (KitsEnum.getKit(p) == KitsEnum.FIREMAN) {
				if (MCAlpha.Status != GameTime.PREGAME||MCAlpha.Status != GameTime.INVENCIBILIDADE) {
					if (e.getCause() == EntityDamageEvent.DamageCause.LAVA
							||e.getCause() == EntityDamageEvent.DamageCause.FIRE||e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK) {
							e.setCancelled(true);
					}
				}
			}
		}
	}

}
