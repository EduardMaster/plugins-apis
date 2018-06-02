package nobody.eventos;

import java.util.ArrayList;

import nobody.main.Main;

import org.bukkit.Location;
import org.bukkit.Material;
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

public class Jumps
  implements Listener
{
  @SuppressWarnings({ "unchecked", "rawtypes" })
public static ArrayList<String> jump = new ArrayList();
  @SuppressWarnings({ "unchecked", "rawtypes" })
ArrayList<String> nofalldamage = new ArrayList();
  @SuppressWarnings({ "unchecked", "rawtypes" })
ArrayList<String> nofalldamagewait = new ArrayList();
  
  public Jumps(Main main) {}
  
  @EventHandler(priority=EventPriority.MONITOR)
  public void onPlayerJump1(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SPONGE)
    {
      jump.remove(p.getName());
      Vector sponge = p.getLocation().getDirection().multiply(0).setY(2.0);
      p.setVelocity(sponge);
      jump.add(p.getName());
      jump.remove(p.getName());
      jump.add(p.getName());
      return;
    }
  }
  @EventHandler(priority=EventPriority.MONITOR)
  public void asdasdasd(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.EMERALD_BLOCK)
    {
      jump.remove(p.getName());
      Vector sponge = p.getLocation().getDirection().multiply(0).setY(7.0);
      p.setVelocity(sponge);
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
  public void onPlayerFrente(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.REDSTONE_BLOCK)
    {

      Vector sponge = p.getLocation().getDirection().multiply(3.5D).setY(1.35D);
      p.setVelocity(sponge);
      jump.add(p.getName());
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
    if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.BEACON)
    {
      Vector sponge = p.getLocation().getDirection().multiply(0).setY(1.5);
      p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 999));
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
