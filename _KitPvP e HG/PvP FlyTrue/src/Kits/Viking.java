package Kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import Utils.KitAPI;

public class Viking implements Listener {

	@EventHandler
	public void Bater(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && (e.getDamager() instanceof Player)) {
			Player t = (Player)e.getDamager();
			if (KitAPI.getKit(t) == "Viking" && (t.getItemInHand().getType() == Material.STONE_AXE)) {
				e.setDamage(e.getDamage() + 3.0D);
			}
			
		}
	}

}
