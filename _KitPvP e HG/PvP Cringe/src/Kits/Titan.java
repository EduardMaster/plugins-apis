package Kits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Utils.KitAPI;

public class Titan implements Listener {
	
	  public HashMap<String, Long> cooldown = new HashMap<>();
	  public static ArrayList<Player> titan = new ArrayList<>();
	  
	  @EventHandler
	  public void Armadura(PlayerInteractEvent e)
	  {
	    Player p = e.getPlayer();
	    if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
	      (KitAPI.getKit(p) == "Titan") && 
	      (p.getItemInHand().getType() == Material.BEDROCK)) {
	      if ((!this.cooldown.containsKey(p.getName())) || (((Long)this.cooldown.get(p.getName())).longValue() <= System.currentTimeMillis()))
	      {
	        p.sendMessage("§6Agora sua Armadura esta 100%");
	        e.setCancelled(true);
	        p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 500, 3));
	        p.playSound(p.getLocation(), Sound.IRONGOLEM_DEATH, 1.0F, 1.0F);
	        this.cooldown.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(60L)));
	      }
	      else
	      {
	        p.sendMessage("§cFaltam §a" + TimeUnit.MILLISECONDS.toSeconds(((Long)this.cooldown.get(p.getName())).longValue() - System.currentTimeMillis()) + "§c segundos para usar novamente!");
	        e.setCancelled(true);
	        return;
	      }
	    }
	  }
	  
	  @EventHandler
	  public void DanoQueda(EntityDamageEvent e)
	  {
	    if (((e.getEntity() instanceof Player)) && 
	      (e.getCause() == EntityDamageEvent.DamageCause.FALL))
	    {
	      Player p = (Player)e.getEntity();
	      if (KitAPI.getKit(p) == "Titan") {
	        e.setDamage(e.getDamage());
	      }
	    }
	  }
	}
