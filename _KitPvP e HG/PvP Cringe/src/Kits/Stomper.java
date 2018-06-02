package Kits;

import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import Utils.KitAPI;

public class Stomper implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void Pulou(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {			
			Player p = (Player)e.getEntity();
			if (KitAPI.getKit(p) == "Stomper" && e.getCause() == DamageCause.FALL) {
				if (e.getDamage() > 6 ) {
					for (Entity s : p.getNearbyEntities(3.5, 1, 3.5)) {
						if (s instanceof Player);
						Player t = (Player)s;
						e.setDamage(4.0D);
						t.sendMessage("§c§lVoce foi pisoteado por §b§l" + p.getDisplayName());
						p.sendMessage("§a§lVoce pisoteou §b" + t.getDisplayName());
						p.getWorld().playSound(p.getLocation(), Sound.ANVIL_LAND, 2.0F, 1.0F);
						if (!t.isSneaking()) {
							t.damage(999999999, p);
						} else {
							t.damage(4, p);
						}
						
					}
				}
				e.setDamage(4.0D);
				return;
			}
			return;
		}
	}

}
