package me.recenthg.Kits;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import me.recenthg.Main;
import me.recenthg.Manager.Habilidade;
import me.recenthg.Utils.Estado;

@SuppressWarnings("unused")
public class Kangaroo implements Listener
{
  ArrayList<Player> kangaroo = new ArrayList<Player>();
  ArrayList<Player> cos = new ArrayList<Player>();
  private HashMap<Player, Integer> jumped = new HashMap<Player, Integer>();
  
  @EventHandler
  public void interact(PlayerInteractEvent event)
  {
    Player Player = event.getPlayer();
    Entity Entity = Player;
    if (Main.estados == Estado.INVENCIBILIDADE || Main.estados == Estado.ANDAMENTO)
     if ((Habilidade.getAbility(Player).equalsIgnoreCase("kangaroo")))
      if (Player.getItemInHand().getType() == Material.FIREWORK)
    {
      event.setCancelled(true);
      if ((!cos.contains(Player)) && 
        (!jumped.containsKey(Player))) {
        if (!Player.isSneaking())
        {
          if (!((CraftPlayer)Player).getHandle().onGround)
          {
            jumped.put(Player, Integer.valueOf(1));
            Player.setVelocity(new Vector(Player.getVelocity().getX(), 1.0D, Player.getVelocity().getZ()));
          }
          else
          {
            Player.setVelocity(new Vector(Player.getVelocity().getX(), 1.0D, Player.getVelocity().getZ()));
          }
        }
        else if (!((CraftPlayer)Player).getHandle().onGround)
        {
          Player.setVelocity(Player.getLocation().getDirection().multiply(1.5D));
          Player.setVelocity(new Vector(Player.getVelocity().getX(), 0.5D, Player.getVelocity().getZ()));
          jumped.put(Player, Integer.valueOf(1));
        }
        else
        {
          Player.setVelocity(Player.getLocation().getDirection().multiply(1.5D));
          Player.setVelocity(new Vector(Player.getVelocity().getX(), 0.5D, Player.getVelocity().getZ()));
        }
      }
      if (cos.contains(Player.getName())) {
    	  Player.sendMessage("§cVoce esta em combate !");
      }
    }
  
  }
  
  @EventHandler
  public void landed(PlayerMoveEvent e)
  {
    if ((e.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR) && 
      (this.jumped.containsKey(e.getPlayer()))) {
      this.jumped.remove(e.getPlayer());
    }
  }
  
  @EventHandler
  public void onDamag123e(EntityDamageEvent event)
  {
    Entity e = event.getEntity();
    if ((e instanceof Player))
    {
      Player player = (Player)e;
      if (((event.getEntity() instanceof Player)) && 
        (event.getCause() == EntityDamageEvent.DamageCause.FALL) && 
        (Habilidade.getAbility(player).equalsIgnoreCase("kangaroo")) && 
        (event.getDamage() >= 7.0D)) {
        event.setDamage(7.0D);
      }
    }
  }
  
  @SuppressWarnings("deprecation")
public boolean isOnGround(Player p)
  {
    Location l = p.getLocation();
    l = l.add(0.0D, -1.0D, 0.0D);
    return l.getBlock().getState().getTypeId() != 0;
  }
  
  @EventHandler
  public void Cooldown(EntityDamageByEntityEvent e)
  {
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      final Player player = (Player)e.getEntity();
      if (Habilidade.getAbility(player).equalsIgnoreCase("kangaroo"))
      {
        cos.add(player);
        
        Bukkit.getServer().getScheduler().runTaskLater(Main.instance, new Runnable()
        {
          public void run()
          {
            cos.remove(player);
          }
        }, 150L);
      }
    }
  }
}
