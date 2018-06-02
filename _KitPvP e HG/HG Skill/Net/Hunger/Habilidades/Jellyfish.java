package Net.Hunger.Habilidades;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

import Net.Hunger.Main;
import Net.Hunger.Manager.Habilidade;

public class Jellyfish implements Listener {

  ArrayList<Block> naoescorrer = new ArrayList();
  
  @EventHandler
  public void colocaragua(PlayerInteractEvent event) {
    Player p = event.getPlayer();
    if((Main.Partida) && (Habilidade.getAbility(p).equalsIgnoreCase("jellyfish"))) {
    if ((p.getItemInHand().getType() == Material.CLAY_BALL) && 
      (event.getAction() == Action.RIGHT_CLICK_BLOCK))
    {
      Block b = event.getClickedBlock();
      
      BlockFace lado = event.getBlockFace();
      int x = b.getLocation().getBlockX();
      int y = b.getLocation().getBlockY();
      int z = b.getLocation().getBlockZ();
      if (lado == BlockFace.DOWN)
      {
        final Block b2 = b.getWorld().getBlockAt(x, y - 1, z);
        if (b2.getType() == Material.AIR)
        {
          b2.setType(Material.STATIONARY_WATER);
          this.naoescorrer.add(b2);
          Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
          {
            public void run()
            {
              b2.setType(Material.AIR);
              Jellyfish.this.naoescorrer.remove(b2);
            }
          }, 60L);
        }
        else
        {
          p.sendMessage("§7[§a!§7] Você não pode colocar agua aqui!");
        }
      }
      else if (lado == BlockFace.UP)
      {
        final Block b2 = b.getWorld().getBlockAt(x, y + 1, z);
        if (b2.getType() == Material.AIR)
        {
          b2.setType(Material.STATIONARY_WATER);
          this.naoescorrer.add(b2);
          Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
          {
            public void run()
            {
              b2.setType(Material.AIR);
              Jellyfish.this.naoescorrer.remove(b2);
            }
          }, 60L);
        }
        else
        {
          p.sendMessage("§7[§a!§7] Você não pode colocar agua aqui!");
        }
      }
      else if (lado == BlockFace.NORTH)
      {
        final Block b2 = b.getWorld().getBlockAt(x, y, z - 1);
        if (b2.getType() == Material.AIR)
        {
          b2.setType(Material.STATIONARY_WATER);
          this.naoescorrer.add(b2);
          Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
          {
            public void run()
            {
              b2.setType(Material.AIR);
              Jellyfish.this.naoescorrer.remove(b2);
            }
          }, 60L);
        }
        else
        {
          p.sendMessage("§7[§a!§7] Você não pode colocar agua aqui!");
        }
      }
      else if (lado == BlockFace.SOUTH)
      {
        final Block b2 = b.getWorld().getBlockAt(x, y, z + 1);
        if (b2.getType() == Material.AIR)
        {
          b2.setType(Material.STATIONARY_WATER);
          this.naoescorrer.add(b2);
          Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
          {
            public void run()
            {
              b2.setType(Material.AIR);
              Jellyfish.this.naoescorrer.remove(b2);
            }
          }, 60L);
        }
        else
        {
          p.sendMessage("§7[§a!§7] Você não pode colocar agua aqui!");
        }
      }
      else if (lado == BlockFace.WEST)
      {
        final Block b2 = b.getWorld().getBlockAt(x - 1, y, z);
        if (b2.getType() == Material.AIR)
        {
          b2.setType(Material.STATIONARY_WATER);
          this.naoescorrer.add(b2);
          Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
          {
            public void run()
            {
              b2.setType(Material.AIR);
              Jellyfish.this.naoescorrer.remove(b2);
            }
          }, 60L);
        }
        else
        {
          p.sendMessage("§7[§a!§7] Você não pode colocar agua aqui!");
        }
      }
      else if (lado == BlockFace.EAST)
      {
        final Block b2 = b.getWorld().getBlockAt(x + 1, y, z);
        if (b2.getType() == Material.AIR)
        {
          b2.setType(Material.STATIONARY_WATER);
          this.naoescorrer.add(b2);
          Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
          {
            public void run()
            {
              b2.setType(Material.AIR);
              Jellyfish.this.naoescorrer.remove(b2);
            }
          }, 60L);
        }
        else
        {
          p.sendMessage("§7[§a!§7] Você não pode colocar agua aqui!");
        }
      }
    }
   }
  }
  
  @EventHandler
  public void naoescorrer(BlockPhysicsEvent event)
  {
    Block b = event.getBlock();
    if ((b.getType() == Material.STATIONARY_WATER) && (this.naoescorrer.contains(b))) {
      event.setCancelled(true);
    }
  }
  
  @EventHandler
  public void veneno(PlayerMoveEvent event)
  {
    Player p = event.getPlayer();
    Block b = p.getLocation().getBlock();
    if ((b.getType() == Material.STATIONARY_WATER) && (!p.getInventory().contains(Material.CLAY_BALL)) && (this.naoescorrer.contains(b))) {
      p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 50, 0));
    }
  }
}
