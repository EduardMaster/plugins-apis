package Pedrao.Habilidades;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import Pedrao.KitAPI;
import Pedrao.Main;

public class Sasuke implements Listener {
	private Main plugin;

	public Sasuke(Main instance) {
		this.plugin = instance;
	}

	public int cooldown = 15;


	  @EventHandler
	  public void onPlayerInteract(PlayerInteractEvent e)
	  {
	    final Player p = e.getPlayer();
	    if ((KitAPI.Sasuke.contains(p.getName())) && 
	      ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_AIR)) && 
	      (p.getItemInHand().getType() == Material.FIREWORK_CHARGE)) 
	    {
	      if (KitAPI.reload.contains(p.getName()))
	      {
	    	e.setCancelled(true);
	        p.sendMessage(Main.cl);
	        return;
	      }
	        e.setCancelled(true);
	        p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
	        p.getEyeLocation().getWorld().playEffect(p.getLocation(), Effect.SMOKE, 5);
	        p.getLocation().getWorld().playEffect(p.getLocation(), Effect.GHAST_SHOOT, 1);
	        p.getLocation().getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 1);
	        
	        Fireball f = (Fireball)e.getPlayer().launchProjectile(Fireball.class);
	        f.setIsIncendiary(false);
	        f.setYield(0.0F);
	        KitAPI.reload.add(p.getName());
	        p.setExp(0.0F);
	        p.setLevel(0);
	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
	        {
	          public void run()
	          {
	            if (KitAPI.Sasuke.contains(p.getName()))
	            {
	                p.setFireTicks(5);
	                p.sendMessage(Main.prefix + "Vc ficou muito ecitado");
	            }
	          }
	        }, 20L);
	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
	        {
	          public void run()
	          {
	            if (KitAPI.Sasuke.contains(p.getName()))
	            {
	                p.setFireTicks(5);
	                p.sendMessage(Main.prefix + "Vc ficou muito ecitado");
	            }
	          }
	        }, 40L);
	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
	        {
	          public void run()
	          {
	            if (KitAPI.Sasuke.contains(p.getName()))
	            {
	                p.setFireTicks(5);
	                p.sendMessage(Main.prefix + "Vc ficou muito ecitado");
	            }
	          }
	        }, 60L);
	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
	        {
	          public void run()
	          {
	            if (KitAPI.Sasuke.contains(p.getName()))
	            {
	                p.setFireTicks(5);
	                p.sendMessage(Main.prefix + "Vc ficou muito ecitado");
	            }
	          }
	        }, 80L);
	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
	        {
	          public void run()
	          {
	            if (KitAPI.Sasuke.contains(p.getName()))
	            {
	                p.setFireTicks(5);
	                p.sendMessage(Main.prefix + "Vc ficou muito ecitado");
	            }
	          }
	        }, 100L);
	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
	        {
	          public void run()
	          {
	            if (KitAPI.Sasuke.contains(p.getName()))
	            {
	                p.setFireTicks(5);
	                p.sendMessage(Main.prefix + "Vc ficou muito ecitado");
	            }
	          }
	        }, 120L);
	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
	        {
	          public void run()
	          {
	            if (KitAPI.Sasuke.contains(p.getName()))
	            {
	                p.setFireTicks(5);
	                p.sendMessage(Main.prefix + "Vc ficou muito ecitado");
	            }
	          }
	        }, 140L);
	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
	        {
	          public void run()
	          {
	            if (KitAPI.Sasuke.contains(p.getName()))
	            {
	              p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
	              KitAPI.reload.remove(p.getName());
	                p.sendMessage(Main.prefix + "§aCooldown acabou ! ");
	            }
	          }
	        }, 160L);
	      }
	    }
	  }