package br.com.alpha.Habilidades;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import br.com.alpha.MCAlpha;
import br.com.alpha.ENUMs.KitsEnum;
import br.com.alpha.gamemanagement.GameTime;

public class Fisherman implements Listener {
	
	@EventHandler
	private void onPlayerFisherman(PlayerFishEvent e) {
		Player player = e.getPlayer();
		
		if (KitsEnum.getKit(player)==KitsEnum.FISHERMAN) {
			if (MCAlpha.Status !=GameTime.INGAME) return;
			
			if (e.getCaught() instanceof Player) {
				Player player_teleported = (Player)e.getCaught();
				
				player_teleported.teleport(player);
			}
		}
	}
}
