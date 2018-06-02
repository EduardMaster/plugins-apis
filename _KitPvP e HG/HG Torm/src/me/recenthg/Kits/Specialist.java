package me.recenthg.Kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import me.recenthg.Main;
import me.recenthg.Manager.Habilidade;
import me.recenthg.Utils.Estado;

public class Specialist implements Listener {

	@EventHandler
	public void abrirenchant(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		if (Main.estados == Estado.ANDAMENTO)
			if ((Habilidade.getAbility(p).equalsIgnoreCase("specialist")))
				if (p.getItemInHand().getType() == Material.BOOK)
					if ((event.getAction() == Action.RIGHT_CLICK_AIR)
							|| (event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
						p.openEnchanting(p.getLocation(), true);
					}
	}

	@EventHandler
	public void receberexp(PlayerDeathEvent event) {
		if ((event.getEntity() instanceof Player)) {
			Player p = event.getEntity();
			if ((p.getKiller() instanceof Player)) {
				Player specialist = p.getKiller();
				if (Habilidade.getAbility(specialist).equalsIgnoreCase("specialist")) {
					specialist.setLevel(specialist.getLevel() + 1);
				}
			}
		}
	}
}
