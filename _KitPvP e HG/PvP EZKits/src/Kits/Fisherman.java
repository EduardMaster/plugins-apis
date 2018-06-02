package Kits;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import Utils.KitAPI;

public class Fisherman implements Listener{
	@EventHandler
	public void Pescar(PlayerFishEvent e) {
		Player p = e.getPlayer();
		if (e.getCaught() instanceof Player && KitAPI.getKit(p) == "Fisherman") {
			Player t = (Player)e.getCaught();
			t.teleport(p);
			e.setCancelled(true);
			p.sendMessage("§aVoce Pescou §b" + t.getDisplayName());
			t.sendMessage("§b " + p.getDisplayName() + " §aPescou voce");
		}
	}

}
