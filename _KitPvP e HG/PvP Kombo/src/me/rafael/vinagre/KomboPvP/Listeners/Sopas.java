package me.rafael.vinagre.KomboPvP.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Vinagre.Habilidade;
import me.rafael.vinagre.KomboPvP.*;


public class Sopas
  implements Listener
{
  public Sopas(Main main) {}
  
 
  
 
 

 
@EventHandler
public void onSopa(final PlayerInteractEvent e) {
    final ItemStack pote = new ItemStack(Material.BOWL, 1);
    final ItemMeta kpote = pote.getItemMeta();
    kpote.setDisplayName("§3Potinho");
    pote.setItemMeta(kpote);
    final Damageable hp;
    final Player p = (Player)(hp = (Damageable)e.getPlayer());
    if (hp.getHealth() != 20.0) {
        final int sopa = 7;
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getTypeId() == 282) {
            p.setHealth((hp.getHealth() + sopa > hp.getMaxHealth()) ? hp.getMaxHealth() : (hp.getHealth() + sopa));
            if (!Habilidade.getAbility(p).equalsIgnoreCase("QuickDropper")) {
                p.getItemInHand().setItemMeta(kpote);
                p.getItemInHand().setType(Material.BOWL);
            }
            else {
                p.getItemInHand().setType(Material.BOWL);
                p.getPlayer().getInventory().remove(p.getItemInHand());
                p.getInventory().remove(new ItemStack(Material.BOWL, 1));
                p.getLocation().getWorld().dropItem(p.getEyeLocation(), new ItemStack(Material.BOWL));
                p.updateInventory();
            }
        }
    }
}

@EventHandler
public void onPickup(PlayerPickupItemEvent e)
{
  e.setCancelled(true);
}

@EventHandler
public void onDamage(EntityDamageEvent e)
{
  if (e.getCause() == EntityDamageEvent.DamageCause.VOID)
  {
    Player p = (Player)e.getEntity();
    p.setHealth(0.0D);
  }
}
}
