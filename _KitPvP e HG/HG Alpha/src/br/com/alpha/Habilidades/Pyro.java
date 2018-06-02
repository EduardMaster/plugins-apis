package br.com.alpha.Habilidades;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import br.com.alpha.ENUMs.KitsEnum;

public class Pyro implements Listener {

	/* 20: */ @EventHandler
	/* 21: */ public void onPlayerDropItemKit1(BlockPlaceEvent event) {
		/* 23:21 */ Player p = event.getPlayer();
		/* 24:22 */ Block block = event.getBlockPlaced();
		/* 25:23 */ if ((KitsEnum.getKit(p)==KitsEnum.PYRO) &&
		/* 26:24 */ (block.getType().equals(Material.FIREBALL))) {
			/* 27:25 */ event.setCancelled(true);
			/* 28: */ }
		/* 29: */ }

	/* 30: */
	/* 31: */ @EventHandler
	/* 32: */ public void onPlayerDropItemKit1pyro(PlayerDropItemEvent event) {
		/* 34:32 */ Player p = event.getPlayer();
		/* 35:33 */ Material item = event.getItemDrop().getItemStack().getType();
		/* 36:34 */ if ((KitsEnum.getKit(p)==KitsEnum.PYRO) &&
		/* 37:35 */ (item == Material.FIREBALL)) {
			/* 38:36 */ event.setCancelled(true);
			/* 39: */ }
		/* 40: */ }

	/* 41: */
	/* 42: */ @EventHandler
	/* 43: */ public void onInteractpyro(PlayerInteractEvent event) {
		/* 45:43 */ Player player = event.getPlayer();
		/* 46:44 */ ItemStack item = event.getItem();
		/* 47:45 */ if ((event.getAction() == Action.RIGHT_CLICK_AIR) && (item != null) &&
		/* 48:46 */ (item.getType() == Material.FIREBALL) &&
		/* 49:47 */ (KitsEnum.getKit(player)==KitsEnum.PYRO)) {
			/* 51:49 */ item.setAmount(item.getAmount() - 1);
			/* 52:50 */ if (item.getAmount() == 0) {
				/* 53:51 */ event.getPlayer().setItemInHand(new ItemStack(Material.AIR));
				/* 54: */ }
			/* 55:53 */ Fireball ball = (Fireball) event.getPlayer().launchProjectile(Fireball.class);
			/* 56:54 */ ball.setIsIncendiary(true);
			/* 57:55 */ ball.setYield(ball.getYield() * 1.5F);
			/* 58: */ }
		/* 59: */ }
	/* 60: */ }