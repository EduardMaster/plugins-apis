package Eventos;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.potion.PotionEffectType;

public class Geral implements Listener{
	@EventHandler
	public void Drop(ItemSpawnEvent e) {
		e.getEntity().remove();
	}
	@EventHandler
	public void Fome(FoodLevelChangeEvent e) {
		e.setCancelled(true);
		e.setFoodLevel(20);
	}
	
	@EventHandler
	public void BaterEntity(EntityDamageByEntityEvent e){
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			int porcetagem = (70);
			e.setDamage(e.getDamage() * porcetagem / 100);
		}
	}
	

	
	@EventHandler
	public void Chuva(WeatherChangeEvent e) {
		if (e.toWeatherState()) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void CancelarDrops(PlayerDropItemEvent e) {
		Material t = e.getItemDrop().getItemStack().getType();
		if ((t.equals(Material.EMERALD)) || (t.equals(Material.CHEST)) ||
	       (t.equals(Material.COMPASS)) || t.equals(Material.STONE_SWORD) ||
		   (t.equals(Material.STAINED_GLASS_PANE)) || (t.equals(Material.FIREWORK))||
		   (t.equals(Material.SLIME_BALL))){
		        	e.setCancelled(true);
		        }else {
		        	e.getItemDrop().remove();
		        }
	}

	public class NerfarAsEspadas
	  implements Listener
	{
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
	  
	  @EventHandler
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
	          event.setDamage(2.5D);
	        }
	        if (player.getItemInHand().getType() == Material.STONE_SWORD) {
	          event.setDamage(3.5D);
	        }
	        if (player.getItemInHand().getType() == Material.IRON_SWORD) {
	          event.setDamage(4.5D);
	        }
	        if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
	          event.setDamage(5.5D);
	        }
	        if (player.getItemInHand().containsEnchantment(Enchantment.DAMAGE_ALL)) {
	          event.setDamage(event.getDamage() + 1.0D);
	        }
	        if ((player.getFallDistance() > 0.0F) && (!player.isOnGround()) && (!player.hasPotionEffect(PotionEffectType.BLINDNESS)))
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
	          if ((player.getFallDistance() > 0.0F) && (player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)))
	          {
	            if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
	              event.setDamage(event.getDamage() + 1.5D);
	            }
	            if (player.getItemInHand().getType() == Material.STONE_SWORD) {
	              event.setDamage(event.getDamage() + 1.5D);
	            }
	            if (player.getItemInHand().getType() == Material.IRON_SWORD) {
	              event.setDamage(event.getDamage() + 1.5D);
	            }
	            if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
	              event.setDamage(event.getDamage() + 1.5D);
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

	
}
