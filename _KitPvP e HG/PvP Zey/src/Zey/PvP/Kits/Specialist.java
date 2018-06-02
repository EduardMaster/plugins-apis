package Zey.PvP.Kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import Zey.PvP.Eventos.Habilidade;


public class Specialist implements Listener {
	  
	@EventHandler
	  public void onIasnteract(PlayerInteractEvent event) {
	    Player p = event.getPlayer();
	    if (p.getItemInHand().getType().equals((Object)Material.ENCHANTED_BOOK) 
        		&& p.getItemInHand().getItemMeta().hasDisplayName() 
        		&& p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lSPECIALIST") &&  	
				Habilidade.getAbility(p) == "Specialist") {
	    	if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
	    		event.setCancelled(true);
	      p.openEnchanting(null, true);
	    	}
	    }
}
	  
	  @EventHandler
	  public void onVampire(EntityDeathEvent event)
	  {
	    if ((event.getEntity() instanceof Player))
	    {
	      Player killed = (Player)event.getEntity();
	      if ((killed.getKiller() instanceof Player))
	      {
	        Player player = event.getEntity().getKiller();
	        if (Habilidade.getAbility(player) == "Specialist") {
	          player.setLevel(1);
	        }
	      }
	    }
	  }
}
