package br.com.alpha.InGame.Listeners;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class SoupEating implements Listener {

	@EventHandler
	private void sopa(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Damageable d = p;
		if (e.getMaterial() == Material.MUSHROOM_SOUP) {
			if (e.getAction() == Action.RIGHT_CLICK_AIR||e.getAction() ==Action.RIGHT_CLICK_BLOCK) {
		if (d.getHealth() != d.getMaxHealth()) {
			if (d.getHealth() > d.getMaxHealth() - 7.0D) {
				d.setHealth(d.getMaxHealth());
			}else {
				d.setHealth(d.getHealth() + 7.0D);
			}
			p.getItemInHand().setType(Material.BOWL);
			p.getItemInHand().setAmount(1);
			p.playSound(p.getLocation(), Sound.DRINK, 1.0F, 1.0F);
		}
			}
		}
	}

}
