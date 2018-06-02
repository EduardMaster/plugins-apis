package br.com.alpha.Habilidades;

import java.util.List;

import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import br.com.alpha.MCAlpha;
import br.com.alpha.ENUMs.KitsEnum;
import br.com.alpha.gamemanagement.GameTime;


public class Stomper implements Listener {

	@EventHandler
	public void StomperFall(EntityDamageEvent event) {
		if ((event.getEntity() instanceof Player)) {
			Player p = (Player) event.getEntity();
			if ((event.getCause() == EntityDamageEvent.DamageCause.FALL) && (MCAlpha.Status == GameTime.INGAME)
					&& (KitsEnum.getKit(p) == KitsEnum.STOMPER)) {
				List<Entity> entity = p.getNearbyEntities(8.0D, 5.0D, 8.0D);
				for (Entity en : entity) {
					if ((en instanceof Player)) {
						Player stompados = (Player) en;
						if (stompados.isSneaking()) {
							stompados.damage(4.0D);
							stompados.playSound(p.getLocation(), Sound.ANVIL_BREAK, 4.0F, 4.0F);
							p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 4.0F, 4.0F);
						} else {
							stompados.damage(p.getFallDistance() - 8.0F);
							stompados.playSound(p.getLocation(), Sound.ANVIL_BREAK, 4.0F, 4.0F);
							p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 4.0F, 4.0F);
						}
					}
				}
				if (event.getDamage() > 4.0D) {
					event.setDamage(4.0D);
				}
			}
		}
	}
}