package Pedrao.Habilidades;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.inventory.ItemStack;

import Pedrao.KitAPI;
import Pedrao.Main;

public class ChestPlate implements Listener {

	public ChestPlate(Main main) {
	}

	  @EventHandler
	  public void onKillLevel(PlayerDeathEvent event)
	  {
	    if (!(event.getEntity().getKiller() instanceof Player)) {
	      return;
	    }
	    if (event.getEntity().getKiller() == null) {
	      return;
	    }
	    Player p = event.getEntity();
	    Player k = p.getKiller();
	    
	    k.setLevel(k.getLevel() + 1);
	    p.setLevel(0);
	  }
	  
	  @EventHandler
	  public void onLevel(PlayerLevelChangeEvent e)
	  {
	    Player p = e.getPlayer();
	    if (KitAPI.ChestPlate.contains(p.getName()))
	    {
	      if (e.getNewLevel() == 2)
	      {
	        p.sendMessage(Main.prefix + "§aVocê Evoluiu!");
	        


	        p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
	      }
	      if (e.getNewLevel() == 4)
	      {
	        p.sendMessage(Main.prefix + "§aVocê Evoluiu!");
	        p.getInventory().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE));
	      }
	      if (e.getNewLevel() == 6)
	      {
	        p.sendMessage(Main.prefix + "§aVocê Evoluiu!");
	        p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
	      }
	      if (e.getNewLevel() == 8)
	      {
	        p.sendMessage(Main.prefix + "§aVocê Evoluiu!");
	        p.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
	      }
	    }
	  }
	}
