package Pedrao.Habilidades;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import Pedrao.KitAPI;
import Pedrao.Main;

public class Rain implements Listener {

	public Rain(Main main) {
	}

	  @SuppressWarnings({ })
	public static List<Player> hab = new ArrayList<Player>();
	  public static List<Player> cooldownm = new ArrayList<Player>();
	  
	  @EventHandler
	  public void a(PlayerInteractEntityEvent event)
	  {
	    if (!(event.getRightClicked() instanceof Player)) {
	      return;
	    }
	    final Player p1 = event.getPlayer();
	    final Player r = (Player)event.getRightClicked();
	    if (p1.getItemInHand().getType() == Material.ARROW)
	    {
	      if ((KitAPI.Rain.contains(p1.getName())) && 
	        (cooldownm.contains(p1)))
	      {
	        p1.sendMessage(Main.cl);
	        return;
	      }
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
	      {
	        public void run()
	        {
	          Location loc = r.getLocation();
	          loc.setY(loc.getY() + 3.0D);
	          
	          Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc, EntityType.ARROW);
	        }
	      }, 40L);
	      
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
	      {
	        public void run()
	        {
	          Location loc2 = r.getLocation();
	          loc2.setY(loc2.getY() + 3.0D);
	          
	          Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc2, EntityType.ARROW);
	        }
	      }, 35L);
	      
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
	      {
	        public void run()
	        {
	          Location loc3 = r.getLocation();
	          loc3.setY(loc3.getY() + 3.0D);
	          
	          Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc3, EntityType.ARROW);
	        }
	      }, 30L);
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
	      {
	        public void run()
	        {
	          Location loc3 = r.getLocation();
	          loc3.setY(loc3.getY() + 3.0D);
	          
	          Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc3, EntityType.ARROW);
	        }
	      }, 25L);
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
	      {
	        public void run()
	        {
	          Location loc3 = r.getLocation();
	          loc3.setY(loc3.getY() + 3.0D);
	          
	          Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc3, EntityType.ARROW);
	        }
	      }, 20L);
	      
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
	      {
	        public void run()
	        {
	          Location loc4 = r.getLocation();
	          loc4.setY(loc4.getY() + 3.0D);
	          
	          Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc4, EntityType.ARROW);
	        }
	      }, 5L);
	      
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
	      {
	        public void run()
	        {
	          Location loc6 = r.getLocation();
	          loc6.setY(loc6.getY() + 3.0D);
	          
	          Bukkit.getServer().getWorld(r.getLocation().getWorld().getName()).spawnEntity(loc6, EntityType.ARROW);
	        }
	      }, 3L);
	      
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
	      {
	        public void run()
	        {
	          Location loc5 = r.getLocation();
	          loc5.setY(loc5.getY() + 3.0D);
	        }
	      }, 2L);
	      
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
	      {
	        public void run()
	        {
	          Rain.hab.remove(p1.getName());
	        }
	      }, 50L);
	      cooldownm.add(p1);
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
	      {
	        public void run()
	        {
	          cooldownm.remove(p1);
	          p1.sendMessage(Main.prefix + "§aSuas flechas estao prontas!");
	          p1.getWorld().playSound(p1.getLocation(), Sound.BURP, 5.0F, 5.0F);
	        }
	      }, 700L);
	    }
	  }
	}
