package Net.Hunger.Habilidades;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import Net.Hunger.Comandos.CMDKit;
import Net.Hunger.Manager.Habilidade;

public class Crafter implements Listener {
	
	  @EventHandler
	  public void onBlo2kClick22(PlayerInteractEvent event) {
	  Player player = event.getPlayer();
	  if((Habilidade.getAbility(player).equalsIgnoreCase("crafter")) && 
	  ((event.getAction() == Action.RIGHT_CLICK_BLOCK) || (event.getAction() == Action.RIGHT_CLICK_AIR)) && 
	  (player.getItemInHand().getType() == Material.NETHER_STAR)) {
	  player.openWorkbench(null, true);
	}
 }
}