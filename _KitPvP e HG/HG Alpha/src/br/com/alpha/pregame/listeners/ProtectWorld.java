package br.com.alpha.pregame.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.painting.PaintingBreakByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

import br.com.alpha.MCAlpha;
import br.com.alpha.gamemanagement.GameTime;

@SuppressWarnings("deprecation")
public class ProtectWorld implements Listener {

	@EventHandler
	public void onBreakA(HangingBreakByEntityEvent e) {
		if (MCAlpha.Status == GameTime.PREGAME) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onBreakB(PaintingBreakByEntityEvent e) {
		if (MCAlpha.Status == GameTime.PREGAME) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void destroyPlant(PlayerInteractEvent event) {
		if (MCAlpha.Status == GameTime.PREGAME) {
			if (event.getAction() == Action.PHYSICAL && event.getClickedBlock().getType() == Material.SOIL)
				event.setCancelled(true);
		}
	}

	@EventHandler
	public void onRain(WeatherChangeEvent e) {
		if (MCAlpha.Status == GameTime.PREGAME) {
			e.setCancelled(true);
		}
	}
}
