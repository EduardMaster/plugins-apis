package Pedrao.Habilidades;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import Pedrao.KitAPI;
import Pedrao.Main;

public class ForceField implements Listener {

	public ForceField(Main main) {
	}
	  @SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<Player> cooldownm = new ArrayList();
	  
	  @EventHandler
	  public void stomperApple(PlayerInteractEvent event)
	  {
	    final Player p = event.getPlayer();
	    if ((event.getPlayer().getItemInHand().getType() == Material.NETHER_FENCE) && 
	      (KitAPI.ForceField.contains(event.getPlayer().getName())))
	    {
	      if ((event.getAction() == Action.LEFT_CLICK_AIR) || 
	        (event.getAction() == Action.LEFT_CLICK_BLOCK) || 
	        (event.getAction() == Action.RIGHT_CLICK_BLOCK) || 
	        (event.getAction() == Action.RIGHT_CLICK_AIR)) {
	        event.setCancelled(true);
	      }
	      if (cooldownm.contains(p))
	      {
	        p.sendMessage(Main.cl);
	        return;
	      }
	      Location loc = p.getLocation();
	      p.getWorld().playSound(loc, Sound.MAGMACUBE_WALK2, 0.5F, 0.5F);
	      cooldownm.add(p);
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	        	KitAPI.ForceField1.add(p.getName());
	          p.sendMessage(Main.prefix + "§aVocê Ativou O FF");
	        }
	      }, 0L);
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	        	KitAPI.ForceField1.remove(p.getName());
	        }
	      }, 50L);
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	          cooldownm.remove(p);
	          p.sendMessage(Main.prefix + "§aVocê pode usar novamente seu ff!");
	          p.getWorld().playSound(p.getLocation(), Sound.BURP, 0.5F, 0.5F);
	        }
	      }, 500L);
	    }
	  }
	  
	  @EventHandler
	  public void fraqueza(PlayerMoveEvent event)
	  {
	    Player p = event.getPlayer();
	    if (KitAPI.ForceField1.contains(p.getName())) {
	      for (Entity pertos : p.getNearbyEntities(8.0D, 8.0D, 8.0D)) {
	        if ((pertos instanceof Player))
	        {
	          @SuppressWarnings("unused")
			Player perto = (Player)pertos;
	          if (KitAPI.ForceField.contains(p.getName())) {
	            ((Player)pertos).damage(3.0D);
	          }
	          pertos.setVelocity(new Vector(0.1D, 0.0D, 0.1D));
	          Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	          {
	            public void run() {}
	          }, 10L);
	        }
	      }
	    }
	  }
}