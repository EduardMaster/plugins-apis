package Net.Hunger.Habilidades;

import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.server.v1_7_R4.EntityPlayer;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

import Net.Hunger.Main;
import Net.Hunger.Manager.Habilidade;

public class Kangaroo implements Listener
{
  ArrayList<Player> kangaroo = new ArrayList();
  ArrayList<Player> cos = new ArrayList();
  private HashMap<Player, Integer> jumped = new HashMap();
  
  @EventHandler
  public void interact(PlayerInteractEvent event)
  {
    Player Player = event.getPlayer();
    Entity Entity = Player;
    if ((Habilidade.getAbility(Player).equalsIgnoreCase("kangaroo")) && 
      (Player.getItemInHand().getType() == Material.FIREWORK))
    {
      event.setCancelled(true);
      if ((!this.cos.contains(Player)) && 
        (!this.jumped.containsKey(Player))) {
        if (!Player.isSneaking())
        {
          if (!((CraftPlayer)Player).getHandle().onGround)
          {
            this.jumped.put(Player, Integer.valueOf(1));
            Player.setVelocity(new Vector(Player.getVelocity().getX(), 1.0D, Player.getVelocity().getZ()));
          }
          else
          {
            Player.setVelocity(new Vector(Player.getVelocity().getX(), 1.0D, Player.getVelocity().getZ()));
          }
        }
        else if (!((CraftPlayer)Player).getHandle().onGround)
        {
          Player.setVelocity(Player.getLocation().getDirection().multiply(1.2D));
          Player.setVelocity(new Vector(Player.getVelocity().getX(), 0.5D, Player.getVelocity().getZ()));
          this.jumped.put(Player, Integer.valueOf(1));
        }
        else
        {
          Player.setVelocity(Player.getLocation().getDirection().multiply(1.2D));
          Player.setVelocity(new Vector(Player.getVelocity().getX(), 0.5D, Player.getVelocity().getZ()));
        }
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
        this.cos.add(player);
        
        Bukkit.getServer().getScheduler().runTaskLater(Main.instance, new Runnable()
        {
          public void run()
          {
            Kangaroo.this.cos.remove(player);
          }
        }, 150L);
      }
    }
  } 
}
