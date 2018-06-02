package br.com.alpha.Habilidades;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import br.com.alpha.MCAlpha;
import br.com.alpha.ENUMs.KitsEnum;
import br.com.alpha.InGame.Listeners.Kits.Managers.KitManager;
import br.com.alpha.gamemanagement.GameTime;



public class Anchor implements Listener  {

	@EventHandler
	public void anchor(EntityDamageByEntityEvent e) {
		Player p = (Player)e.getEntity();
		Player d = (Player)e.getDamager();
	
		if (e.getEntity() != p) {
			return;
		}
		if (e.getDamager() != d) {
			return;
		}
		if (KitsEnum.getKit(p) ==KitsEnum.ANCHOR) {
			if (MCAlpha.Status == GameTime.INGAME) {
			p.setVelocity(new Vector());
			
			new BukkitRunnable() {

				public void run() {
					p.setVelocity(new Vector());
					p.playSound(d.getLocation(), Sound.ANVIL_BREAK, 1.0F, 1.0F);
				}
			}.runTaskLater(MCAlpha.mcAlpha, 1);
			d.setVelocity(new Vector());
			new BukkitRunnable() {

				public void run() {
					d.setVelocity(new Vector());
					d.playSound(d.getLocation(), Sound.ANVIL_BREAK, 1.0F, 1.0F);
				}
			}.runTaskLater(MCAlpha.mcAlpha, 1);
			if (KitManager.getPlayerKit(d) == "Anchor") {
				d.setVelocity(new Vector());
				
				new BukkitRunnable() {

					public void run() {
						d.setVelocity(new Vector());
						d.playSound(d.getLocation(), Sound.ANVIL_BREAK, 1.0F, 1.0F);
					}
				}.runTaskLater(MCAlpha.mcAlpha, 1);
				p.setVelocity(new Vector());
				new BukkitRunnable() {

					public void run() {
						p.setVelocity(new Vector());
						p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 1.0F, 1.0F);
					}
				}.runTaskLater(MCAlpha.mcAlpha, 1);
		}
			} else {
				e.setCancelled(true);
			}
		
	}
	
}
}
