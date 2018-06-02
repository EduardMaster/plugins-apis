package Pedrao.Eventos;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffectType;

import Pedrao.Main;

public class Sword
  implements Listener
{
  public Sword(Main main) {
	}

@EventHandler
  public void onEntityDamage(EntityDamageEvent e)
  {
    if ((e.getEntity() instanceof Player))
    {
      Player p = (Player)e.getEntity();
      if (p.getInventory().getChestplate() != null) {
        p.getInventory().getChestplate().setDurability((short)0);
      }
      if (p.getInventory().getBoots() != null) {
        p.getInventory().getBoots().setDurability((short)0);
      }
      if (p.getInventory().getLeggings() != null) {
        p.getInventory().getLeggings().setDurability((short)0);
      }
      if (p.getInventory().getHelmet() != null) {
        p.getInventory().getHelmet().setDurability((short)0);
      }
    }
  }
  
  @EventHandler(priority=EventPriority.NORMAL)
  public void onEntityDamageByEntity1(EntityDamageByEntityEvent e)
  {
    if ((e.getDamager() instanceof Player))
    {
      Player d = (Player)e.getDamager();
      if ((d.getItemInHand().getType() == Material.DIAMOND_SWORD) || 
        (d.getItemInHand().getType() == Material.WOOD_SWORD) || 
        (d.getItemInHand().getType() == Material.STONE_SWORD) || 
        (d.getItemInHand().getType() == Material.FISHING_ROD) || 
        (d.getItemInHand().getType() == Material.STONE_AXE) || 
        (d.getItemInHand().getType() == Material.BOW) || 
        (d.getItemInHand().getType() == Material.IRON_SWORD) || 
        (d.getItemInHand().getType() == Material.DIAMOND_AXE)) {
        d.getItemInHand().setDurability((short)0);
      }
    }
  }
  
  @SuppressWarnings("deprecation")
@EventHandler
  public void NerfsDanos(EntityDamageByEntityEvent event)
  {
    if ((event.getDamager() instanceof Player))
    {
      Player player = (Player)event.getDamager();
      if (event.getDamage() > 1.0D) {
        event.setDamage(event.getDamage() - 1.0D);
      }
      if ((event.getDamager() instanceof Player))
      {
        if ((player.getFallDistance() > 0.0F) && (!player.isOnGround()) && (!player.hasPotionEffect(PotionEffectType.BLINDNESS)))
        {
          int NewDamage = (int)(event.getDamage() * 1.5D) - 
            (int)event.getDamage();
          if (event.getDamage() > 1.0D) {
            event.setDamage(event.getDamage() - NewDamage);
          }
        }
        if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
          event.setDamage(1.5D);
        }
        if (player.getItemInHand().getType() == Material.STONE_SWORD) {
          event.setDamage(2.5D);
        }
        if (player.getItemInHand().getType() == Material.IRON_SWORD) {
          event.setDamage(4.0D);
        }
        if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
          event.setDamage(5.0D);
        }
        if (player.getItemInHand().containsEnchantment(Enchantment.DAMAGE_ALL)) {
          event.setDamage(event.getDamage() + 1.0D);
        }
        if ((player.getFallDistance() > 0.0F) && (!player.isOnGround()) && (!player.hasPotionEffect(PotionEffectType.BLINDNESS)))
        {
          if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
            event.setDamage(event.getDamage() + 0.0D);
          }
          if (player.getItemInHand().getType() == Material.STONE_SWORD) {
            event.setDamage(event.getDamage() + 0.0D);
          }
          if (player.getItemInHand().getType() == Material.IRON_SWORD) {
            event.setDamage(event.getDamage() + 0.0D);
          }
          if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
            event.setDamage(event.getDamage() + 0.0D);
          }
          if ((player.getFallDistance() > 0.0F) && (player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)))
          {
            if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
              event.setDamage(event.getDamage() + 1.0D);
            }
            if (player.getItemInHand().getType() == Material.STONE_SWORD) {
              event.setDamage(event.getDamage() + 1.0D);
            }
            if (player.getItemInHand().getType() == Material.IRON_SWORD) {
              event.setDamage(event.getDamage() + 1.0D);
            }
            if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
              event.setDamage(event.getDamage() + 1.0D);
            }
          }
          if ((player.getFallDistance() > 0.0F) && (player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) && (!player.isOnGround()))
          {
            if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
              event.setDamage(event.getDamage() + 0.5D);
            }
            if (player.getItemInHand().getType() == Material.STONE_SWORD) {
              event.setDamage(event.getDamage() + 0.5D);
            }
            if (player.getItemInHand().getType() == Material.IRON_SWORD) {
              event.setDamage(event.getDamage() + 0.5D);
            }
            if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
              event.setDamage(event.getDamage() + 0.5D);
            }
          }
        }
      }
    }
  }
}