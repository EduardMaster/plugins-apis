package br.com.alpha.pregame.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntitySpawnEvent;

import br.com.alpha.MCAlpha;
import br.com.alpha.gamemanagement.GameTime;

public class EntityInteracting implements Listener {

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		if (MCAlpha.Status == GameTime.PREGAME) {
			e.setCancelled(true);
			e.setDamage(0.0D);
		}
	}

	@EventHandler
	public void onEntityExplode(EntityExplodeEvent e) {
		if (MCAlpha.Status == GameTime.PREGAME) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onEntitySpawn(EntitySpawnEvent e) {
		if (MCAlpha.Status == GameTime.PREGAME && !(e.getEntity() instanceof Player)) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if (MCAlpha.Status == GameTime.PREGAME) {
			e.setCancelled(true);
		}
	}

}
