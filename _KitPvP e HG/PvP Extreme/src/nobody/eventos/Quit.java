package nobody.eventos;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Quit implements Listener {
	@EventHandler
	public void sair(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		e.setQuitMessage(null);
		p.setExp(0);
	}
	@EventHandler
	public void morrer(PlayerDeathEvent e) {
		Player p = e.getEntity();
		e.setDeathMessage(null);
	    KitAPI.RemoveKit(p);
	}

}
