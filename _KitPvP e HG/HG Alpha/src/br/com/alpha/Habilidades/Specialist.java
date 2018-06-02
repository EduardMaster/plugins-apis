package br.com.alpha.Habilidades;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import br.com.alpha.ENUMs.KitsEnum;

public class Specialist implements Listener {
	
	@EventHandler
	public void abrirenchant(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		if ((KitsEnum.getKit(p)==KitsEnum.SPECIALIST) && (p.getItemInHand().getType() == Material.BOOK)
				&& ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK))) {
			p.openEnchanting(p.getLocation(), true);
		}
	}

	@EventHandler
	public void receberexp(PlayerDeathEvent event) {
		if ((event.getEntity() instanceof Player)) {
			Player p = event.getEntity();
			if ((p.getKiller() instanceof Player)) {
				Player specialist = p.getKiller();
				if (KitsEnum.getKit(p)==KitsEnum.SPECIALIST) {
					specialist.getInventory().addItem(new ItemStack[] { new ItemStack(Material.EXP_BOTTLE, 1) });
				}
			}
		}
	}
}