package br.com.alpha.Borda;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import br.com.alpha.APIs.Title;

public class BorderMove implements Listener {

	@EventHandler
	public void ForcefieldDamagePositive(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		Location loc = p.getLocation();
		World w = p.getWorld();
		if (w.getSpawnLocation().getWorld().setSpawnLocation(0, 120, 0)) {
			if ((Math.abs(loc.getBlockX() + w.getSpawnLocation().getBlockX()) >= 500)
					|| (Math.abs(loc.getBlockZ() + w.getSpawnLocation().getBlockZ()) >= 500)) {
				p.setFireTicks(500);
				p.damage(8.5D);
				Title.sendXPBarMessage(p, "§c§lVocê está no ForceField!");
			}
		}
	}
}
