package me.recenthg.Manager;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropsItemKits implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onDrop(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		if (Habilidade.getAbility(p).equalsIgnoreCase("kangaroo") 
				&& (e.getItemDrop().getItemStack().getType() == Material.FIREWORK)) {
			e.setCancelled(true);

		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("aladdin")
				&& (e.getItemDrop().getItemStack().getType() == Material.CARPET)) {
			e.setCancelled(true);

		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("thor")
				&& (e.getItemDrop().getItemStack().getType() == Material.WOOD_AXE)) {
			e.setCancelled(true);

		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("fisherman")
				&& (e.getItemDrop().getItemStack().getType() == Material.FISHING_ROD)) {
			e.setCancelled(true);
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("specialist")
				&& (e.getItemDrop().getItemStack().getType() == Material.BOOK)) {
			e.setCancelled(true);
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("grappler")
				&& (e.getItemDrop().getItemStack().getType() == Material.LEASH)) {
			e.setCancelled(true);
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("endermage")
				&& (e.getItemDrop().getItemStack().getType() == Material.ENDER_PORTAL_FRAME)) {
			e.setCancelled(true);
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("BurstMaster") && (e.getItemDrop().getItemStack().getType() == Material.GOLD_HOE)) {
			e.setCancelled(true);
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("Vulcanos") && (e.getItemDrop().getItemStack().getType() == Material.FIREWORK_CHARGE)) {
			e.setCancelled(true);
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("gladiator") && (e.getItemDrop().getItemStack().getType() == Material.IRON_FENCE)) {
			e.setCancelled(true);
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("velotrol") && (e.getItemDrop().getItemStack().getType() == Material.MINECART)) {
			e.setCancelled(true);
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("reaper") && (e.getItemDrop().getItemStack().getType() == Material.WOOD_HOE)) {
			e.setCancelled(true);
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("well") && (e.getItemDrop().getItemStack().getType() == Material.GOLD_NUGGET)) {
			e.setCancelled(true);
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("monk") && (e.getItemDrop().getItemStack().getType() == Material.BLAZE_ROD)) {
			e.setCancelled(true);
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("wither") && (e.getItemDrop().getItemStack().getType() == Material.SKULL_ITEM)) {
			e.setCancelled(true);
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("phantom") && (e.getItemDrop().getItemStack().getType() == Material.FEATHER)) {
			e.setCancelled(true);
		}
	}
}
