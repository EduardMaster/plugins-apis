package me.recenthg.Kits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerLeashEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import me.recenthg.Main;
import me.recenthg.CMDS.Admin;
import me.recenthg.Manager.CopyOfFishingHook;
import me.recenthg.Manager.Habilidade;

public class Grappler implements Listener {
	
	  Map<Player, CopyOfFishingHook> hooks = new HashMap<Player, CopyOfFishingHook>();
		  
	@EventHandler
	  public void onSlot(PlayerItemHeldEvent e)
	  {
	    if (this.hooks.containsKey(e.getPlayer())) {
	      ((CopyOfFishingHook)this.hooks.get(e.getPlayer())).remove();
	      this.hooks.remove(e.getPlayer());
	    }
	  }

	  @EventHandler
	  public void onMove23(PlayerMoveEvent e) { 
	   if ((this.hooks.containsKey(e.getPlayer())) && (!e.getPlayer().getItemInHand().getType().equals(Material.LEASH))) {
	    ((CopyOfFishingHook)this.hooks.get(e.getPlayer())).remove();
	      this.hooks.remove(e.getPlayer());
	    }
	  }
  	  
	  @EventHandler
	  public void onLeash(PlayerLeashEntityEvent e) {
	    Player p = e.getPlayer();
	    if ((e.getPlayer().getItemInHand().getType().equals(Material.LEASH)) && (Habilidade.getAbility(p).equalsIgnoreCase("grappler")) && (!Admin.admin.contains(p))) { {
	      e.setCancelled(true);
	      e.getPlayer().updateInventory();
	      e.setCancelled(true);
	      if (!this.hooks.containsKey(p)) {
	        return;
	      }
	      if (!((CopyOfFishingHook)this.hooks.get(p)).isHooked()) {
	        return;
	      }
	      double d = ((CopyOfFishingHook)this.hooks.get(p)).getBukkitEntity().getLocation().distance(p.getLocation());
	      double t = d;
	      double v_x = (1.0D + 0.07000000000000001D * t) * (((CopyOfFishingHook)this.hooks.get(p)).getBukkitEntity().getLocation().getX() - p.getLocation().getX()) / t;
	      double v_y = (1.0D + 0.03D * t) * (((CopyOfFishingHook)this.hooks.get(p)).getBukkitEntity().getLocation().getY() - p.getLocation().getY()) / t;
	      double v_z = (1.0D + 0.07000000000000001D * t) * (((CopyOfFishingHook)this.hooks.get(p)).getBukkitEntity().getLocation().getZ() - p.getLocation().getZ()) / t;
	      
	      Vector v = p.getVelocity();
	      v.setX(v_x);
	      v.setY(v_y);
	      v.setZ(v_z);
	      p.setVelocity(v);
	      p.getWorld().playSound(p.getLocation(), Sound.SHOOT_ARROW, 1.0F, 1.0F);
	     }
	    }
	   }
	  
	   ArrayList<String> NerfGrappler = new ArrayList<String>();
	  
	  @EventHandler
	  public void onDamageGrappler(EntityDamageByEntityEvent e) {
	  if(!(e.getEntity() instanceof Player)) {
	  return;
	  }
	  if(!(e.getDamager() instanceof Player)) {
	  return;
	  }
	  final Player p = (Player)e.getEntity();
	  if(Habilidade.getAbility(p).equalsIgnoreCase("grappler")) {
	  NerfGrappler.add(p.getName());
	  }
	  if(NerfGrappler.contains(p.getName())) {
	  Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
	  public void run() {
	  NerfGrappler.remove(p.getName());
	  }
	  },150L);
	  }
	  }
	  	  
	  @EventHandler
	  public void onClick(PlayerInteractEvent e) {
	    Player p = e.getPlayer();
	    if ((e.getPlayer().getItemInHand().getType().equals(Material.LEASH) && (NerfGrappler.contains(p.getName())))) {
	    e.setCancelled(true);
	    p.sendMessage("§a● §7Você não pode usar seu kit em pvp!");
	    return;
	  
	    } else if ((e.getPlayer().getItemInHand().getType().equals(Material.LEASH)) && (!Admin.admin.contains(p))) {
	
	    	e.setCancelled(true);
	      if(p.getLocation().getY() <= 128) {
	    	    if ((Habilidade.getAbility(p).equalsIgnoreCase("grappler"))) {

	    		if (p.getItemInHand().getType() == Material.LEASH)
	    			   if ((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK))
	      {
	        if (this.hooks.containsKey(p)) {
	          ((CopyOfFishingHook)this.hooks.get(p)).remove();
	        }
	        CopyOfFishingHook nmsHook = new CopyOfFishingHook(p.getWorld(), ((CraftPlayer)p).getHandle());
	        nmsHook.spawn(p.getEyeLocation().add(p.getLocation().getDirection().getX(), p.getLocation().getDirection().getY(), p.getLocation().getDirection().getZ()));
	        nmsHook.move(p.getLocation().getDirection().getX() * 5.0D, p.getLocation().getDirection().getY() * 5.0D, p.getLocation().getDirection().getZ() * 5.0D);
	        this.hooks.put(p, nmsHook);
	      }
	      else
	      {
	        if (!this.hooks.containsKey(p)) {
	          return;
	        }
	        if (!((CopyOfFishingHook)this.hooks.get(p)).isHooked())
	        {
	          p.sendMessage("§a● §7Você esta preso!");
	          return;
	        }
	        double d = ((CopyOfFishingHook)this.hooks.get(p)).getBukkitEntity().getLocation().distance(p.getLocation());
	        double t = d;
	        double v_x = (0.5D + 0.06000000000000001D * t) * (((CopyOfFishingHook)this.hooks.get(p)).getBukkitEntity().getLocation().getX() - p.getLocation().getX()) / t;
	        double v_y = (0.5D + 0.04D * t) * (((CopyOfFishingHook)this.hooks.get(p)).getBukkitEntity().getLocation().getY() - p.getLocation().getY()) / t;
	        double v_z = (0.5D + 0.06000000000000001D * t) * (((CopyOfFishingHook)this.hooks.get(p)).getBukkitEntity().getLocation().getZ() - p.getLocation().getZ()) / t;
	        p.setFallDistance(-5.0F);
	        Vector v = p.getVelocity();
	        v.setX(v_x);
	        v.setY(v_y);
	        v.setZ(v_z);
	        p.setVelocity(v);
	        p.getWorld().playSound(p.getLocation(), Sound.STEP_GRAVEL, 4.0F, 4.0F);
	      }
	    } else {
	    p.sendMessage("§a● §7Você não pode passar de §a128Y!");
        Vector v = p.getLocation().getDirection().multiply(0).setY(-3.0D);
        p.setVelocity(v);
        if (this.hooks.containsKey(e.getPlayer())) {
  	    ((CopyOfFishingHook)this.hooks.get(e.getPlayer())).remove();
  	    this.hooks.remove(e.getPlayer());
	    return;
	    }
	   }
	      }
	    }
  }
}