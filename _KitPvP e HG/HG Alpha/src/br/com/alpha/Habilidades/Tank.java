package br.com.alpha.Habilidades;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import br.com.alpha.ENUMs.KitsEnum;
import br.com.alpha.InGame.Listeners.Kits.Managers.KitManager;

public class Tank implements Listener {

	@EventHandler
	public void tankHab(PlayerDeathEvent e) {
		if ((e.getEntity() instanceof Player)) {

			Player p = (Player) e.getEntity().getKiller();

			if (KitsEnum.getKit(p) == KitsEnum.TANK) {
				p.getWorld().createExplosion(p.getLocation(), 2.0F);
			}
		}
	}

	@EventHandler
	public void semDanoExplosaoTank(EntityDamageEvent e) {
		if ((e.getEntity() instanceof Player)) {
			Player p = (Player) e.getEntity();

			if (KitManager.getPlayerKit(p) == "Tank") {
				if ((e.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION)
						|| (e.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION)) {
					e.setCancelled(true);
				}
			}
		}
	}

}
