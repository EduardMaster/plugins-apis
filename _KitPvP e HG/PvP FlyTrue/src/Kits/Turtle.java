package Kits;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import Utils.KitAPI;

public class Turtle implements Listener {
	
	public void levouDano(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player ) {
			Player p = (Player)e.getEntity();
			if (KitAPI.getKit(p) == "Turtle" && p.isSneaking()) {
				e.setDamage(2.5D);
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void DeuDano(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			Player p = (Player)e.getDamager();
			if (KitAPI.getKit(p) == "Turtle" && p.isSneaking()) {
				e.setDamage(2);
			}
			
		}
	}

}
