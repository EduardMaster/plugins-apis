package Pedrao.Habilidades;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import Pedrao.KitAPI;
import Pedrao.Main;

public class Gravity implements Listener {

	public Gravity(Main main) {
	}

	  @SuppressWarnings({ "unchecked", "rawtypes" })
	private ArrayList<Player> cooldown = new ArrayList();
	  
	  @EventHandler
	  public void meteoro(final PlayerInteractEvent e)
	  {
	    final Player p = e.getPlayer();
	    if ((p.getItemInHand().getType() != null) && 
	      (p.getItemInHand().getItemMeta() != null) && 
	      (p.getItemInHand().getItemMeta().getDisplayName() != null) && 
	      (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§B§LGravity")) && 
	      (e.getAction() == Action.RIGHT_CLICK_BLOCK) && 
	      (p.hasPermission("kit.Gravity")) && 
	      (e.getClickedBlock().getLocation().add(0.0D, 16.0D, 0.0D).getBlock().getType() == Material.AIR) && 
	      (e.getClickedBlock().getLocation().add(0.0D, 1.0D, 0.0D).getBlock().getType() == Material.AIR) && 
	      (e.getClickedBlock().getLocation().add(0.0D, 2.0D, 0.0D).getBlock().getType() == Material.AIR) && 
	      (e.getClickedBlock().getLocation().add(0.0D, 3.0D, 0.0D).getBlock().getType() == Material.AIR) && 
	      (e.getClickedBlock().getLocation().add(0.0D, 4.0D, 0.0D).getBlock().getType() == Material.AIR) && 
	      (e.getClickedBlock().getLocation().add(0.0D, 5.0D, 0.0D).getBlock().getType() == Material.AIR) && 
	      (e.getClickedBlock().getLocation().add(0.0D, 6.0D, 0.0D).getBlock().getType() == Material.AIR) && 
	      (e.getClickedBlock().getLocation().add(0.0D, 7.0D, 0.0D).getBlock().getType() == Material.AIR) && 
	      (e.getClickedBlock().getLocation().add(0.0D, 8.0D, 0.0D).getBlock().getType() == Material.AIR) && 
	      (e.getClickedBlock().getLocation().add(0.0D, 9.0D, 0.0D).getBlock().getType() == Material.AIR) && 
	      (e.getClickedBlock().getLocation().add(0.0D, 10.0D, 0.0D).getBlock().getType() == Material.AIR) && 
	      (e.getClickedBlock().getLocation().add(0.0D, 11.0D, 0.0D).getBlock().getType() == Material.AIR) && 
	      (e.getClickedBlock().getLocation().add(0.0D, 12.0D, 0.0D).getBlock().getType() == Material.AIR) && 
	      (e.getClickedBlock().getLocation().add(0.0D, 13.0D, 0.0D).getBlock().getType() == Material.AIR) && 
	      (e.getClickedBlock().getLocation().add(0.0D, 14.0D, 0.0D).getBlock().getType() == Material.AIR) && 
	      (e.getClickedBlock().getLocation().add(0.0D, 15.0D, 0.0D).getBlock().getType() == Material.AIR) && 
	      (!this.cooldown.contains(p)))
	    {
	      e.setCancelled(true);
	      this.cooldown.add(p);
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        @SuppressWarnings("deprecation")
			public void run()
	        {
	          FallingBlock fb = Bukkit.getServer().getWorld("world").spawnFallingBlock(e.getClickedBlock().getLocation().add(0.0D, 15.0D, 0.0D), Material.TNT, (byte)0);
	          fb.setDropItem(false);
	          
	          p.sendMessage(Main.prefix + "Alaha Bom");
	        }
	      }, 100L);
	      
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	          e.getClickedBlock().getLocation().getWorld().createExplosion(e.getClickedBlock().getLocation().add(0.0D, 1.0D, 0.0D), 4.5F);
	        }
	      }, 130L);
	      
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	          cooldown.remove(p);
	          p.sendMessage(Main.prefix + "§aVoce nao esta mais em cooldown!");
	        }
	      }, 800L);
	    }
	  }
	  
	  @SuppressWarnings("deprecation")
	@EventHandler
	  public void bldk(EntityChangeBlockEvent e)
	  {
	    if ((e.getEntity() instanceof FallingBlock))
	    {
	      e.setCancelled(true);
	      FallingBlock fb = Bukkit.getWorld("world").spawnFallingBlock(e.getEntity().getLocation(), Material.AIR, (byte)0);
	      fb.setVelocity(new Vector(0, 1, 0));
	    }
	  }
	  
	  @EventHandler
	  public void damage(EntityDamageEvent e)
	  {
	    if ((e.getEntity() instanceof Player))
	    {
	      Player p = (Player)e.getEntity();
	      if ((KitAPI.Gravity.contains(p.getName())) && (
	        e.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION)) {
	        e.setCancelled(true);
	      }
	    }
	  }
	  
	  @EventHandler
	  public void damag2e(EntityDamageEvent e)
	  {
	    if ((e.getEntity() instanceof Player))
	    {
	      Player p = (Player)e.getEntity();
	      if ((KitAPI.Gravity.contains(p.getName())) && (
	        e.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION)) {
	        e.setCancelled(true);
	      }
	    }
	  }
	}
