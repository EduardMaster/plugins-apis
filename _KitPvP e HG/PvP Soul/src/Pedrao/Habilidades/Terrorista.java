package Pedrao.Habilidades;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import Pedrao.KitAPI;
import Pedrao.Main;

public class Terrorista implements Listener {

	public Terrorista(Main main) {
	}

	  @SuppressWarnings({ "unchecked", "rawtypes" })
	public static ArrayList<Player> cooldownm = new ArrayList();
	  
	  @EventHandler
	  public void stomperApple(PlayerInteractEvent event)
	  {
	    final Player p = event.getPlayer();
	    if ((event.getPlayer().getItemInHand().getType() == Material.MAGMA_CREAM) && 
	      (KitAPI.Terrorista.contains(event.getPlayer().getName())))
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
	      Vector vector = p.getEyeLocation().getDirection();
	      vector.multiply(0.0F);
	      vector.setY(6.0F);
	      p.setVelocity(vector);
	      Location loc = p.getLocation();
	      p.getWorld().playSound(loc, Sound.ENDERMAN_TELEPORT, 5.0F, -5.0F);
	      cooldownm.add(p);
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
	      {
	        public void run()
	        {
	          Terrorista.cooldownm.remove(p);
	          
	          p.sendMessage(Main.prefix + "§aVoce pode usar novamente!");
	          p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
	          p.getWorld().playSound(p.getLocation(), Sound.BURP, 5.0F, 5.0F);
	        }
	      }, 800L);
	    }
	  }
	  
	  @EventHandler
	  public void idknow(EntityDamageEvent e)
	  {
	    if ((e.getEntity() instanceof Player))
	    {
	      Player p = (Player)e.getEntity();
	      if (e.getCause() != EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {
	        return;
	      }
	      if (KitAPI.Terrorista.contains(p.getName())) {
	        e.setCancelled(true);
	      } else {
	        e.setDamage(e.getDamage() * 2.0D);
	      }
	    }
	  }
	  
	  @EventHandler
	  public void stomper(EntityDamageEvent event)
	  {
	    if (!(event.getEntity() instanceof Player)) {
	      return;
	    }
	    if (event.getCause() != EntityDamageEvent.DamageCause.FALL) {
	      return;
	    }
	    Player p = (Player)event.getEntity();
	    if ((KitAPI.Terrorista.contains(p.getName())) && (event.getDamage() >= 8.0D))
	    {
	      event.setDamage(8.0D);
	      for (Entity e : p.getNearbyEntities(3.0D, 3.0D, 3.0D)) {
	        if (((e instanceof Player)) && (!((Player)e).isSneaking())) {
	          p.getWorld().createExplosion(p.getLocation(), 3.0F);
	        }
	      }
	    }
	  }
	}
