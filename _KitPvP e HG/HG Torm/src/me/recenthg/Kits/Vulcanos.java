package me.recenthg.Kits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.recenthg.Main;
import me.recenthg.Utils.Estado;

public class Vulcanos
  implements Listener
{
  public ArrayList<Player> erupcao = new ArrayList<Player>();
  public static HashMap<String, Long> cooldown = new HashMap<String, Long>();
  
  public Vulcanos() {}
  
 
  
  @EventHandler
  public void vulcanos(PlayerInteractEvent e) {
    if (e.getItem() == null)
    {
      return;
    }
    final Player p = e.getPlayer();
    if (Main.estados == Estado.ANDAMENTO)
    if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
    {

      if (p.getItemInHand().getType() == Material.FIREWORK_CHARGE)
      {
        if (!p.getItemInHand().hasItemMeta())
          return;
        if (p.getItemInHand().getItemMeta().getDisplayName().contains("Vulcanos"))
        {
          if ((!cooldown.containsKey(p.getName())) || (((Long)cooldown.get(p.getName())).longValue() <= System.currentTimeMillis()))
          {
            p.sendMessage("§8\u276e§4§l!§8\u276f §7Voce entrou em erupecao!");
            cooldown.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(20L)));
            erupcao.add(p);
            List<Entity> x = p.getNearbyEntities(2.0D, 2.0D, 2.0D);
            for (Entity inimigos : x)
            {
              if ((inimigos instanceof Player))
              {
                inimigos.setFireTicks(100);
              }
            }
            Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.instance, new Runnable()
            {
              public void run()
              {
                if (erupcao.contains(p))
                {
                  List<Entity> x = p.getNearbyEntities(2.0D, 2.0D, 2.0D);
                  for (Entity inimigos : x)
                  {
                    if ((inimigos instanceof Player))
                    {
                      inimigos.setFireTicks(100);
                    }
                  }
                  p.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 2);
                }
                
              }
            }, 3L, 12L);
            
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
            {
              public void run()
              {
                if (erupcao.contains(p))
                {
                  erupcao.remove(p);
                  p.sendMessage("§8\u276e§4§l!§8\u276f §7Voce nao esta mais em erupeçao!");
                }
                
              }
            }, 200L);
            return; }
          p.sendMessage("§8\u276e§4§l!§8\u276f §7Aguarde Mais §4" + TimeUnit.MILLISECONDS.toSeconds(((Long)cooldown.get(p.getName())).longValue() - System.currentTimeMillis()) + " §7Segundos para Usar o Seu Kit!");
          return;
        }
        
        return;
      }
    }
  }
  


  @EventHandler
  public void dropar(PlayerDropItemEvent e)
  {
    if (e.getItemDrop().getItemStack().getType() == Material.FIREWORK_CHARGE)
    {
      if (e.getPlayer().getItemInHand().hasItemMeta())
      {
        if (e.getItemDrop().getItemStack().getItemMeta().getDisplayName().contains("Vulcanos"))
        {
          e.setCancelled(true);
        }
      }
    }
  }
  
  @EventHandler
  public void naoDroparKit(PlayerDeathEvent e)
  {
    for (ItemStack drops : e.getDrops())
    {
      Material m = drops.getType();
      if (m == Material.FIREWORK_CHARGE)
      {
        if (e.getEntity().getItemInHand().hasItemMeta())
        {
          if (drops.getItemMeta().getDisplayName().contains("Vulcanos"))
          {
            drops.setAmount(1);
            drops.setType(Material.AIR);
          }
        }
      }
    }
  }
}
