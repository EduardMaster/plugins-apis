package br.com.alpha.pregame.listeners;

import org.bukkit.entity.Horse;
import org.bukkit.entity.Villager;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import br.com.alpha.MCAlpha;
import br.com.alpha.gamemanagement.GameTime;

public class PlayerInteracting implements Listener {

	@EventHandler
	public void onPickup(PlayerPickupItemEvent e) {
		if (MCAlpha.Status == GameTime.PREGAME) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		if (MCAlpha.Status == GameTime.PREGAME) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onInteractEntity(PlayerInteractEntityEvent e) {
		if (MCAlpha.Status == GameTime.PREGAME) {
			if (e.getRightClicked() instanceof Villager || e.getRightClicked() instanceof Horse) {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if (MCAlpha.Status == GameTime.PREGAME && e.getPlayer().getItemInHand() != null
				&& e.getPlayer().getItemInHand().getType().name().toLowerCase().contains("bucket")) {
			e.setCancelled(true);
			e.setUseItemInHand(Result.DENY);
		}
	}

}
