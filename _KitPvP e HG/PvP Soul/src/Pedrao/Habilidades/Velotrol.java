package Pedrao.Habilidades;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import Pedrao.KitAPI;
import Pedrao.Main;

public class Velotrol implements Listener {

	public Velotrol(Main main) {
	}
	  public int boost = Integer.valueOf(6).intValue();
	  @SuppressWarnings({ "unchecked", "rawtypes" })
	public static ArrayList<String> velotrol = new ArrayList();
	  @SuppressWarnings({ "unchecked", "rawtypes" })
	  public static List<Player> cooldownm = new ArrayList();
	  
	  @EventHandler
	  public void VelotrolClick(PlayerInteractEvent event)
	  {
	    final Player p = event.getPlayer();
	    if ((event.getPlayer().getItemInHand().getType() == Material.MINECART) && 
	      (KitAPI.Velotrol.contains(event.getPlayer().getName())))
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
	      p.setVelocity(p.getEyeLocation().getDirection().multiply(this.boost).add(new Vector(0, 0, 0)));
	      p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 10, 0);
	      final Location loc = p.getLocation();
	      velotrol.add(p.getName());
	      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	          p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 10, 0);
	        }
	      }, 15L);
	      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	          p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 10, 0);
	        }
	      }, 14L);
	      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	          p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 10, 0);
	        }
	      }, 13L);
	      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	          p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 10, 0);
	        }
	      }, 12L);
	      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	          p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 10, 0);
	        }
	      }, 11L);
	      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	          p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 10, 0);
	        }
	      }, 10L);
	      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	          p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 10, 0);
	        }
	      }, 9L);
	      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	          p.getWorld().createExplosion(loc, 3.0F);
	        }
	      }, 30L);
	      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	          velotrol.remove(p.getName());
	        }
	      }, 50L);
	      p.getWorld().playSound(loc, Sound.ENDERMAN_TELEPORT, 5.0F, -5.0F);
	      cooldownm.add(p);
	      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	          cooldownm.remove(p);
	          p.sendMessage(Main.prefix + "§aVoce pode usar novamente!");
	          p.getWorld().playSound(p.getLocation(), Sound.BURP, 5.0F, 5.0F);
	        }
	      }, 700L);
	    }
	  }
	}