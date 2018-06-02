package Eventos;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class Sopa implements Listener{
	
	@EventHandler
	public void SopaBeber(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (e.getMaterial() == Material.MUSHROOM_SOUP) {
			Damageable d = p;
			if (d.getHealth() != d.getMaxHealth()) {
				if (d.getHealth() > d.getMaxHealth() - 7.0D) {
					d.setHealth(d.getMaxHealth());
				}else{
					d.setHealth(d.getHealth() + 7.0D);
				}
				p.getItemInHand().setType(Material.BOWL);
				p.getItemInHand().setAmount(1);
				p.playSound(p.getLocation(), Sound.EAT, 1,0F);
			}
		}
	}

}


	
