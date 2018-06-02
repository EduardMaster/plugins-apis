package br.com.alpha.pregame.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import br.com.alpha.MCAlpha;
import br.com.alpha.gamemanagement.GameTime;

public class onInteractBlocks implements Listener {

	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		if (MCAlpha.Status == GameTime.PREGAME) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		if (MCAlpha.Status == GameTime.PREGAME) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onTryOpenChest(PlayerInteractEvent e) {
		if (MCAlpha.Status == GameTime.PREGAME && e.getAction().equals(Action.RIGHT_CLICK_BLOCK)
				&& e.getClickedBlock().getType() != Material.AIR
				&& e.getClickedBlock().getType().equals(Material.CHEST)) {
			e.setCancelled(true);
		}
	}

}
