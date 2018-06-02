package br.com.alpha.Invencibilidade.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import br.com.alpha.MCAlpha;
import br.com.alpha.gamemanagement.GameTime;

public class FoodChange implements Listener {

	@EventHandler
	public void onFood(FoodLevelChangeEvent e) {
		if (MCAlpha.Status == GameTime.INVENCIBILIDADE) {
			e.setCancelled(true);
		}
	}

}
