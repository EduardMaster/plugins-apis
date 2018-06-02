package Kits;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Utils.KitAPI;

public class Reaper implements Listener {
	
	@EventHandler
	public void bater(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			Player p = (Player)e.getEntity();
			Player t = (Player)e.getDamager();
			
			if ((KitAPI.getKit(t) == "Reaper") && (t.getItemInHand().getType() == Material.WOOD_HOE)) {
				if (new Random().nextInt(100) <= 40) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 10*20, 1));
				}
 			}
		}
	}

}
