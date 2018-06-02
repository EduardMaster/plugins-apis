package br.com.alpha.InGame.Listeners.Feast;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntitySpawnEvent;

public class FeastProtect implements Listener {

	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		if (Feast.tempo > 0 && Feast.feastBlocks.contains(e.getBlock())) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(Feast.logoFeast + " §cVocê não pode quebrar blocos do Feast!");
		}
	}

	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		if (Feast.tempo > 0) {
			for (Block l : Feast.feastBlocks) {
				if (l.getLocation().getBlockX() == e.getBlock().getLocation().getBlockX()
						&& l.getLocation().getBlockZ() == e.getBlock().getLocation().getBlockZ()) {
					e.setCancelled(true);
					e.getPlayer().sendMessage(Feast.logoFeast + " §cVocê não pode colocar blocos no Feast!");
					break;
				}
			}
		}
	}

	@EventHandler
	public void onExplode(EntityExplodeEvent e) {
		if (Feast.tempo > 0) {
			for (Block l : Feast.feastBlocks) {
				if (l.getLocation().getBlockX() == e.getEntity().getLocation().getBlockX()
						&& l.getLocation().getBlockZ() == e.getEntity().getLocation().getBlockZ()) {
					e.setCancelled(true);
					e.setYield(0.0F);
					break;
				}
				if (e.blockList().contains(l)) {
					e.setCancelled(true);
					e.setYield(0.0F);
				}
			}
		}
	}

	@EventHandler
	public void onSpawn(EntitySpawnEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			if (Feast.tempo > 0) {
				for (Block l : Feast.feastBlocks) {
					if (l.getLocation().getBlockX() == e.getEntity().getLocation().getBlockX()
							&& l.getLocation().getBlockZ() == e.getEntity().getLocation().getBlockZ()) {
						e.setCancelled(true);
					}
				}
			}
		}
	}
}
