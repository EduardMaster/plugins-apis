package Kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import Utils.KitAPI;

public class Boxer implements Listener {

	@EventHandler
	public void Bater(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && (e.getDamager() instanceof Player)) {
			Player t = (Player)e.getDamager();
			if (KitAPI.getKit(t) == "Boxer" && (t.getItemInHand().getType() == Material.QUARTZ)) {
				e.setDamage(e.getDamage() + 4.0D);
			}
			
		}
	}

}
