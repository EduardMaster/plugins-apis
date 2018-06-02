package Pedrao.Habilidades;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerLeashEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import Pedrao.KitAPI;
import Pedrao.Main;

public class Grappler
  implements Listener
{
  Map<Player, Cordinha> hooks = new HashMap<Player, Cordinha>();
  
  public Grappler(Main main) {
}

@EventHandler
  public void onSlot(PlayerItemHeldEvent e)
  {
    if (this.hooks.containsKey(e.getPlayer()))
    {
      ((Cordinha)this.hooks.get(e.getPlayer())).remove();
      this.hooks.remove(e.getPlayer());
    }
  }
  
  @EventHandler
  public void GrapplerDamageNoLeash(EntityDamageEvent event)
  {
    if (!(event.getEntity() instanceof Player)) {
      return;
    }
    Player player = (Player)event.getEntity();
    if (event.getCause() != EntityDamageEvent.DamageCause.FALL) {
      return;
    }
    if ((this.hooks.containsKey(player)) && (((Cordinha)this.hooks.get(player)).isHooked()) && (event.getDamage() > 3.0D)) {
      event.setDamage(3.0D);
    }
  }
  
  @EventHandler
  public void onMove(PlayerMoveEvent e)
  {
    if ((this.hooks.containsKey(e.getPlayer())) && 
      (!e.getPlayer().getItemInHand().getType().equals(Material.LEASH)))
    {
      ((Cordinha)this.hooks.get(e.getPlayer())).remove();
      this.hooks.remove(e.getPlayer());
    }
  }
  
  @EventHandler
  public void onLeash(PlayerLeashEntityEvent e)
  {
    Player p = e.getPlayer();
    if ((KitAPI.Grappler.contains(p.getName())) && (e.getPlayer().getItemInHand().getType().equals(Material.LEASH)))
    {
      e.setCancelled(true);
      e.getPlayer().updateInventory();
      e.setCancelled(true);
      if (!this.hooks.containsKey(p)) {
        return;
      }
      if (!((Cordinha)this.hooks.get(p)).isHooked()) {
        return;
      }
      double d = ((Cordinha)this.hooks.get(p)).getBukkitEntity()
        .getLocation().distance(p.getLocation());
      double t = d;
      double v_x = (1.0D + 0.07000000000000001D * t) * (
        ((Cordinha)this.hooks.get(p)).getBukkitEntity()
        .getLocation().getX() - p.getLocation().getX()) / t;
      double v_y = (1.0D + 0.03D * t) * (
        ((Cordinha)this.hooks.get(p)).getBukkitEntity()
        .getLocation().getY() - p.getLocation().getY()) / t;
      double v_z = (1.0D + 0.07000000000000001D * t) * (
        ((Cordinha)this.hooks.get(p)).getBukkitEntity()
        .getLocation().getZ() - p.getLocation().getZ()) / t;
      
      Vector v = p.getVelocity();
      v.setX(v_x);
      v.setY(v_y);
      v.setZ(v_z);
      p.setVelocity(v);
    }
  }
  
  @EventHandler
  public void onClick(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if ((KitAPI.Grappler.contains(p.getName())) && (e.getPlayer().getItemInHand().getType().equals(Material.LEASH)))
    {
      e.setCancelled(true);
      if ((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK))
      {
        if (this.hooks.containsKey(p)) {
          ((Cordinha)this.hooks.get(p)).remove();
        }
        Cordinha nmsHook = new Cordinha(p.getWorld(), ((CraftPlayer)p).getHandle());
        nmsHook.spawn(p.getEyeLocation().add(p.getLocation().getDirection().getX(), p.getLocation().getDirection().getY(), 
          p.getLocation().getDirection().getZ()));
        nmsHook.move(p.getLocation().getDirection().getX() * 5.0D, p.getLocation().getDirection().getY() * 5.0D, p.getLocation().getDirection().getZ() * 5.0D);
        this.hooks.put(p, nmsHook);
      }
      else
      {
        if (!this.hooks.containsKey(p)) {
          return;
        }
        if (!((Cordinha)this.hooks.get(p)).isHooked()) {
          return;
        }
        double d = ((Cordinha)this.hooks.get(p)).getBukkitEntity().getLocation().distance(p.getLocation());
        double t = d;
        double v_x = (1.0D + 0.2D * t) * (((Cordinha)this.hooks.get(p)).getBukkitEntity().getLocation().getX() - p.getLocation().getX()) / t;
        double v_y = (1.0D + 0.03D * t) * (
          ((Cordinha)this.hooks.get(p))
          .getBukkitEntity().getLocation().getY() - p
          .getLocation().getY()) / t;
        double v_z = (1.0D + 0.2D * t) * (
          ((Cordinha)this.hooks.get(p))
          .getBukkitEntity().getLocation().getZ() - p
          .getLocation().getZ()) / t;
        
        Vector v = p.getVelocity();
        v.setX(v_x);
        v.setY(v_y);
        v.setZ(v_z);
        p.setVelocity(v);
      }
    }
  }
}
