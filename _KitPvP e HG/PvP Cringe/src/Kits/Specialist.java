package Kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import Utils.KitAPI;


public class Specialist implements Listener {
	  
	@EventHandler
	  public void onIasnteract(PlayerInteractEvent event)
	  {
	    Player p = event.getPlayer();
	    if ((KitAPI.getKit(p) == "Specialist") && ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK) || (event.getAction() == Action.LEFT_CLICK_AIR) || (event.getAction() == Action.LEFT_CLICK_BLOCK)) && (p.getItemInHand().getType() == Material.ENCHANTED_BOOK)) {
	      p.openEnchanting(null, true);
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
	        if (KitAPI.getKit(player) == "Specialist") {
	          player.setLevel(1);
	        }
	      }
	    }
	  }
}
