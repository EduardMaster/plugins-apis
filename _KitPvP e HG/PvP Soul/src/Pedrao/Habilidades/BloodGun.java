package Pedrao.Habilidades;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

import Pedrao.KitAPI;
import Pedrao.Main;

public class BloodGun implements Listener {

	public BloodGun(Main main) {
	}
	  @SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<Player> cooldownm = new ArrayList();
	  
	  @EventHandler
	  public void BloodClick(PlayerInteractEvent event)
	  {
	    final Player p = event.getPlayer();
	    if ((event.getPlayer().getItemInHand().getType() == Material.WOOD_HOE) && 
	      (KitAPI.BloodGun.contains(event.getPlayer().getName())))
	    {
	      if ((event.getAction() == Action.RIGHT_CLICK_BLOCK) || 
	        (event.getAction() == Action.RIGHT_CLICK_AIR) || 
	        (event.getAction() == Action.LEFT_CLICK_AIR) || 
	        (event.getAction() == Action.LEFT_CLICK_BLOCK)) {
	        event.setCancelled(true);
	      }
	      if (cooldownm.contains(p))
	      {
	        p.sendMessage(Main.cl);
	      }
	      else
	      {
	        Vector velo1 = p.getLocation().getDirection().normalize().multiply(10);
	        Fireball boladenve = (Fireball)p.launchProjectile(Fireball.class);
	        boladenve.setIsIncendiary(false);
	        boladenve.setYield(0.0F);
	        boladenve.setVelocity(velo1);
	        Location location = p.getEyeLocation();
	        BlockIterator blocksToAdd = new BlockIterator(location, 0.0D, 30);
	        while (blocksToAdd.hasNext())
	        {
	          Location blockToAdd = blocksToAdd.next().getLocation();
	          Effect a = Effect.STEP_SOUND;
	          p.getWorld().playEffect(blockToAdd, a, 152);
	          cooldownm.add(p);
	          
	          Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	          {
	            public void run()
	            {
	              cooldownm.remove(p);
	            }
	          }, 200L);
	        }
	        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	        {
	          public void run()
	          {
	            p.sendMessage(Main.prefix + "§a§oVoce pode usar novamente!");
	          }
	        }, 200L);
	      }
	    }
	  }
	}
