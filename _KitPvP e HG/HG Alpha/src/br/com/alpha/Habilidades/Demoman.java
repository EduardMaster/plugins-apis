package br.com.alpha.Habilidades;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import br.com.alpha.ENUMs.KitsEnum;;

public class Demoman implements Listener {

	@EventHandler
	public void onDamage112(EntityDamageEvent event) {
		if ((event.getEntity() instanceof Player)) {
			Player p = (Player) event.getEntity();
			if ((KitsEnum.getKit(p) == KitsEnum.DEMOMAN)
					&& (event.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION)) {
				event.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onInteract123(PlayerInteractEvent event) {
		if (event.isCancelled()) {
			return;
		}
		Block b = event.getClickedBlock();
		if ((event.getAction() == Action.PHYSICAL) && (b != null) && (b.getType() == Material.STONE_PLATE)
				&& (b.getRelative(BlockFace.DOWN).getType() == Material.GRAVEL)
				&& (!(KitsEnum.getKit(event.getPlayer()) == KitsEnum.DEMOMAN))) {
			b.setType(Material.AIR);
			b.getWorld().createExplosion(b.getLocation().clone().add(0.5D, 0.5D, 0.5D), 4.0F);
		}
	}
}