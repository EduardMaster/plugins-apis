package Kits;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import Utils.KitAPI;

public class Fisherman implements Listener {
	
	@EventHandler
	public void Pescar(PlayerFishEvent e) {
		Player p = e.getPlayer();
		if (e.getCaught() instanceof Player && KitAPI.getKit(p) == "Fisherman") {
			Player t = (Player)e.getCaught();
			t.teleport(p);
			p.sendMessage("§a§lVoce pescou §b" + t.getDisplayName());
			t.sendMessage("§aVoce foi pescado por §b" + p.getDisplayName());
		}
		
	}

}
