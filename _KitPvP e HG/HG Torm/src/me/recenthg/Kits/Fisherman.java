package me.recenthg.Kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import me.recenthg.Main;
import me.recenthg.Manager.Habilidade;
import me.recenthg.Utils.Estado;

public class Fisherman implements Listener {
	
  @EventHandler
  public void onPlayerHitFishingrodscorpion(PlayerFishEvent event) {
    Player player = event.getPlayer();
    if ((event.getCaught() instanceof Player)) {
    	
      Player caught = (Player)event.getCaught();
      if (Main.estados == Estado.ANDAMENTO)
 	if((Habilidade.getAbility(player).equalsIgnoreCase("fisherman")))
  	if ((player.getItemInHand().getType() == Material.FISHING_ROD)) {
        caught.teleport(player.getLocation());
        player.sendMessage("§8\u276e§4§l!§8\u276f §7Voce puxou o jogador §4" + caught.getName());
        caught.sendMessage("§8\u276e§4§l!§8\u276f §7Voce foi puxado por §4" + player.getName());
      }
    	  
    }
  }
}
