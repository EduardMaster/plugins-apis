package Pedrao.Habilidades;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
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
import me.confuser.barapi.BarAPI;

public class Tornado implements Listener {

	public Tornado(Main main) {
	}

	  @SuppressWarnings({ "unchecked", "rawtypes" })
	public static ArrayList<Player> cooldownm = new ArrayList();
	  
	  @EventHandler
	  public void stomperApple(PlayerInteractEvent event)
	  {
	    final Player p = event.getPlayer();
	    if ((event.getPlayer().getItemInHand().getType() == Material.HOPPER) && 
	      (KitAPI.Tornado.contains(event.getPlayer().getName())))
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
	      p.getWorld().playSound(loc, Sound.AMBIENCE_RAIN, 5.0F, -5.0F);
	      cooldownm.add(p);
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	        	KitAPI.Tornado1.add(p.getName());
	          p.sendMessage(Main.prefix + "§aVocê utilizou o Tornado.");
	        }
	      }, 0L);
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	        	KitAPI.Tornado1.remove(p.getName());
	        }
	      }, 100L);
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	          Tornado.cooldownm.remove(p);
	          p.sendMessage(Main.prefix + "§aVoce Já pode usar seu Kit!");
	          p.getWorld().playSound(p.getLocation(), Sound.BURP, 5.0F, 5.0F);
	        }
	      }, 1000L);
	    }
	  }
	  
	  @EventHandler
	  public void fraqueza(PlayerMoveEvent event)
	  {
	    Player p = event.getPlayer();
	    if (KitAPI.Tornado1.contains(p.getName())) {
	      for (Entity pertos : p.getNearbyEntities(8.0D, 8.0D, 8.0D)) {
	        if ((pertos instanceof Player))
	        {
	          p.getWorld().playEffect(p.getLocation(), Effect.SMOKE, 100, 1);
	          p.getWorld().playEffect(p.getLocation(), Effect.PARTICLE_SMOKE, 100, 1);
	          p.getWorld().playEffect(p.getLocation(), Effect.EXPLOSION, 100, 1);
	          final Player perto = (Player)pertos;
	          
	          pertos.setVelocity(new Vector(2.0D, 0.3D, 2.0D));
	          Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	          {
	            public void run()
	            {
	              BarAPI.removeBar(perto);
	            }
	          }, 10L);
	        }
	      }
	    }
	  }
	}
