package Pedrao.Eventos;

import java.util.ArrayList;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import Pedrao.Main;

public class Jump
  implements Listener
{
  public static ArrayList<String> jump = new ArrayList<String>();
  ArrayList<String> nofalldamage = new ArrayList<String>();
  ArrayList<String> nofalldamagewait = new ArrayList<String>();
  
  public Jump(Main main) {}
  
  @EventHandler(priority=EventPriority.MONITOR)
  public void onPlayerJump1(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SPONGE)
    {
      jump.remove(p.getName());
      
      @SuppressWarnings("unused")
	Location loc = e.getTo().getBlock().getLocation();
      Vector sponge = p.getLocation().getDirection().multiply(0).setY(10);
      p.setVelocity(sponge);
      p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0F, 2.0F);
      p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0F, 2.0F);
      p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0F, 2.0F);
      p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0F, 2.0F);
      p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0F, 2.0F);
      p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 2.0F, 2.0F);
      jump.add(p.getName());
      jump.remove(p.getName());
      jump.add(p.getName());
      return;
    }
  }
  
  @EventHandler
  public void onPlayerDamageCoisaBugada(EntityDamageEvent e)
  {
    if (!(e.getEntity() instanceof Player)) {
      return;
    }
    Player p = (Player)e.getEntity();
    if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
      return;
    }
    if (jump.contains(p.getName()))
    {
      jump.remove(p.getName());
      return;
    }
  }
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onEntityDamageSponge(EntityDamageEvent event)
  {
    if ((event.getEntity() instanceof Player))
    {
      Player player = (Player)event.getEntity();
      Location loc = player.getLocation();
      Location below = loc.subtract(0.0D, 3.0D, 0.0D);
      Block blockBelow = below.getBlock();
      if (event.getCause() == EntityDamageEvent.DamageCause.FALL)
      {
        if (blockBelow.getType() == Material.SPONGE)
        {
          jump.add(player.getName());
          event.setDamage(0.0D);
          return;
        }
        return;
      }
      return;
    }
  }
  
  @EventHandler(priority=EventPriority.MONITOR)
  public void onPlayerSpongeDamage(EntityDamageEvent e)
  {
    if (!(e.getEntity() instanceof Player)) {
      return;
    }
    Player p = (Player)e.getEntity();
    if (e.getCause() == EntityDamageEvent.DamageCause.FALL)
    {
      if (jump.contains(p.getName()))
      {
        jump.remove(p.getName());
        e.setDamage(0.0D);
        return;
      }
      return;
    }
  }
  @EventHandler
  public void onPlayerDamageSponge1(EntityDamageEvent e)
  {
    if (!(e.getEntity() instanceof Player)) {
      return;
    }
    Player p = (Player)e.getEntity();
    if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
      return;
    }
    if (jump.contains(p.getName()))
    {
      jump.remove(p.getName());
      return;
    }
  }
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onEntityDamageSponge1(EntityDamageEvent event)
  {
    if ((event.getEntity() instanceof Player))
    {
      Player player = (Player)event.getEntity();
      Location loc = player.getLocation();
      Location below = loc.subtract(0.0D, 1.0D, 0.0D);
      Block blockBelow = below.getBlock();
      if (event.getCause() == EntityDamageEvent.DamageCause.FALL)
      {
        if (blockBelow.getType() == Material.SPONGE)
        {
          jump.add(player.getName());
          event.setDamage(0.0D);
          return;
        }
        return;
      }
      return;
    }
  }
  
  @EventHandler
  public void onPlayerJumpBaixo(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.PISTON_BASE)
    {
      Vector sponge = p.getLocation().getDirection().multiply(0).setY(1);
      p.getWorld().playEffect(p.getLocation(), Effect.SMOKE, 1);
      p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 999));
      p.getWorld().playSound(p.getLocation(), Sound.SLIME_WALK, 1.0F, 1.0F);
      p.getWorld().playSound(p.getLocation(), Sound.SLIME_WALK, 1.0F, 1.0F);
      p.getWorld().playSound(p.getLocation(), Sound.SLIME_WALK, 1.0F, 1.0F);
      p.getWorld().playSound(p.getLocation(), Sound.SLIME_WALK, 1.0F, 1.0F);
      p.getWorld().playSound(p.getLocation(), Sound.SLIME_WALK, 1.0F, 1.0F);
      p.getWorld().playSound(p.getLocation(), Sound.SLIME_WALK, 1.0F, 1.0F);
      p.setVelocity(sponge);
      if (!this.nofalldamage.contains(p.getName())) {
        this.nofalldamage.add(p.getName());
      }
      return;
    }
  }
  
  @EventHandler
  public void onEntityDamage(EntityDamageEvent event)
  {
    if ((event.getEntity() instanceof Player))
    {
      Player player = (Player)event.getEntity();
      if ((this.nofalldamage.contains(player.getName())) && 
        (event.getCause().equals(EntityDamageEvent.DamageCause.FALL)))
      {
        event.setCancelled(true);
        this.nofalldamage.remove(player.getName());
      }
    }
  }
}
