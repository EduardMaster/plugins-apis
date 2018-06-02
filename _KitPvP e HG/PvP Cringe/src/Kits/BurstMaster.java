package Kits;

import Main.Main;
import Utils.KitAPI;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

public class BurstMaster
  implements Listener
{
  @EventHandler
  public void EntitadeDaExplosao(EntityExplodeEvent e)
  {
    for (Block b : e.blockList())
    {
      final BlockState state = b.getState();
      b.setType(Material.AIR);
      int delay = 5;
      if ((b.getType() == Material.SAND) || (b.getType() == Material.GRAVEL) || b.getType() == Material.CACTUS) {
        delay++;
      }
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
      {
        public void run()
        {
          state.update(true, false);
        }
      }, delay);
    }
  }
  
  @EventHandler
  public void Interagir(PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && (p.getItemInHand().getType() == Material.STONE_HOE) && (KitAPI.getKit(p) == "BurstMaster")) {
      if (!KitAPI.KitDelay.containsKey(p.getName()))
      {
        e.setCancelled(true);
        p.updateInventory();
        Vector velo1 = p.getLocation().getDirection().normalize().multiply(2);
        final Snowball boladenve = (Snowball)p.launchProjectile(Snowball.class);
        boladenve.setVelocity(velo1);
        boladenve.setFireTicks(0);
        
        Location l = p.getEyeLocation();
        BlockIterator blockadd = new BlockIterator(l, 0.0D, 30);
        
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
        {
          public void run()
          {
            boladenve.remove();
          }
        }, 10L);
        
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
        {
          public void run()
          {
            p.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 5, 5);
          }
        }, 15L);
        
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
        {
          public void run()
          {
            p.getWorld().createExplosion(boladenve.getLocation().add(0.0D, 1.0D, 0.0D), 5.0F);
            p.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 15, 15);
          }
        }, 20L);
        while (blockadd.hasNext())
        {
          Location blockToAdd = blockadd.next().getLocation();
          Effect a = Effect.STEP_SOUND;
          p.getWorld().playEffect(blockToAdd, a, 46);
        }
        KitAPI.KitDelay.put(p.getName(), Integer.valueOf(55));
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
        {
          public void run()
          {
            if ((KitAPI.KitDelay.containsKey(p.getName())) && (KitAPI.getKit(p) == "BurstMaster") && (((Integer)KitAPI.KitDelay.get(p.getName())).intValue() <= 0))
            {
              KitAPI.KitDelay.remove(p.getName());
              p.sendMessage("§3Seu §6§lBurstMaster §3esta pronto !");
              p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
            }
          }
        }, 1100L);
      }
      else
      {
        p.sendMessage("§cSua eschada esta recarregando. Espere §a" + KitAPI.KitDelay.get(p.getName()) + " segundos");
      }
    }
  }
}
