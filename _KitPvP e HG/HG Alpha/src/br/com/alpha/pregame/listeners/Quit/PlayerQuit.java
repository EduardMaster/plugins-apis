package br.com.alpha.pregame.listeners.Quit;



import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import br.com.alpha.MCAlpha;
import br.com.alpha.APIs.APIClass;
import br.com.alpha.gamemanagement.GameTime;

public class PlayerQuit implements Listener {

	public static boolean terminou = false;
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		e.setQuitMessage(null);

		
		if (MCAlpha.Status != GameTime.PREGAME) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(MCAlpha.mcAlpha, new BukkitRunnable() {

				@Override
				public void run() {
					e.setQuitMessage(null);
					QuitAPI.removeMatch(p);
					terminou = true;
					APIClass.JogadoresInGame.remove(p.getUniqueId());
					APIClass.espectadores.remove(p.getUniqueId());
					APIClass.checkWinner();
				}
			}, 20L * 10);
		}

		if (MCAlpha.Status == GameTime.PREGAME) {
		

				QuitAPI.removeMatch(p);
				e.setQuitMessage(null);
			}
		
	}
}
