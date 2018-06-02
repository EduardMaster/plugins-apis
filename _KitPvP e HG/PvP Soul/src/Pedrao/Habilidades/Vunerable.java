package Pedrao.Habilidades;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Pedrao.KitAPI;
import Pedrao.Main;

public class Vunerable implements Listener {

	public Vunerable(Main main) {
	}
	  @SuppressWarnings({ "unchecked", "rawtypes" })
	public static HashMap<String, Long> cooldown = new HashMap();
	  @EventHandler
	  public void interact(PlayerInteractEvent e)
	  {
	    Player p = e.getPlayer();
	    if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
	      (KitAPI.Vunerable.contains(p.getName())) && 
	      (p.getItemInHand().getType() == Material.BEACON))
	    {
	      if ((!cooldown.containsKey(p.getName())) || (((Long)cooldown.get(p.getName())).longValue() <= System.currentTimeMillis()))
	      {
	        e.setCancelled(true);
	        p.updateInventory();
	        
	        p.sendMessage(Main.prefix + "§aVc ficou invuneravel");
	        p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 15*15, 200));
	        p.playSound(p.getLocation(), Sound.IRONGOLEM_DEATH, 1.0F, 1.0F);
	        cooldown.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(40L)));
	        return;
	      }
	      p.sendMessage(Main.cl);
	    }
	  }
	}
