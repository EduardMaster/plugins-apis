package br.com.alpha.Invencibilidade.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import br.com.alpha.MCAlpha;
import br.com.alpha.gamemanagement.GameTime;

public class EntityInteracting implements Listener {

	@EventHandler
	public void onEntity(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player && MCAlpha.Status == GameTime.INVENCIBILIDADE) {
			e.setCancelled(true);
		}
	}

}
