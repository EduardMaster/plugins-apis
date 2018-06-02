package me.recenthg.Kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.recenthg.Main;
import me.recenthg.Manager.Habilidade;
import me.recenthg.Utils.Estado;


public class Crafter implements Listener {
	
	  @EventHandler
	  public void onBlo2kClick22(PlayerInteractEvent event) {
	  Player player = event.getPlayer();
		if (Main.estados == Estado.INVENCIBILIDADE ||Main.estados == Estado.ANDAMENTO)
			if ((Habilidade.getAbility(player).equalsIgnoreCase("crafter")))
				if (player.getItemInHand().getType() == Material.NETHER_STAR)
					if ((event.getAction() == Action.RIGHT_CLICK_AIR)
							|| (event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
						player.openWorkbench(null, true);
	}
 }
}
