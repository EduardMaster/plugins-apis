package nobody.eventos;


import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffectType;

public class Nerfs
  implements Listener
{
  @EventHandler
  public void onDamageByEntity(EntityDamageByEntityEvent event)
  {
    if ((event.getDamager() instanceof Player))
    {
      Player player = (Player)event.getDamager();
      if (event.getDamage() > 1.0D) {
        event.setDamage(event.getDamage() - 1.0D);
      }
      if ((event.getDamager() instanceof Player))
      {
        if (player.getFallDistance() > 0.0F)
        {
          int NewDamage = (int)(event.getDamage() * 1.5D) - 
            (int)event.getDamage();
          if (event.getDamage() > 1.0D) {
            event.setDamage(event.getDamage() - NewDamage);
          }
        }
        if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
          event.setDamage(2.5D);
        }
        if (player.getItemInHand().getType() == Material.STONE_SWORD) {
          event.setDamage(3.0D);
        }
        if (player.getItemInHand().getType() == Material.IRON_SWORD) {
            event.setDamage(3.2D);
          }
        if (player.getItemInHand().getType() == Material.STONE_AXE) {
            event.setDamage(3.2D);
          }
        
        if (player.getItemInHand().getType() == Material.BREAD) {
          event.setDamage(4.5D);
        }
          if (player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
              event.setDamage(3.5D);
            }
        }
        if (player.getItemInHand().containsEnchantment(Enchantment.DAMAGE_ALL)) {
          event.setDamage(event.getDamage() + 0.7D);
        }
      }
    }
  
  
  @EventHandler
  public void onBreakSwords(EntityDamageByEntityEvent e)
  {
    if (!(e.getDamager() instanceof Player)) {
      return;
    }
    if (!(e.getEntity() instanceof Player)) {
      return;
    }
    Player p = (Player)e.getDamager();
    if ((p.getItemInHand().getType() == Material.WOOD_SWORD) || 
      (p.getItemInHand().getType() == Material.STONE_AXE) || 
      (p.getItemInHand().getType() == Material.STONE_SWORD) ||
        (p.getItemInHand().getType() == Material.GOLD_SWORD)) {
      p.getItemInHand().setDurability((short)0);
    }
  }
  
  @EventHandler
  public void move(EntityDamageEvent event)
  {
    if (event.getCause() == EntityDamageEvent.DamageCause.VOID) {
      event.setDamage(30.0D);
    }
  }

  
  @EventHandler
  public void ddd(EntityDamageEvent event)
  {
    if (event.getCause() == EntityDamageEvent.DamageCause.DROWNING) {
      event.setCancelled(true);
    
  }
}
}
  
 