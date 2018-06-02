package Pedrao.Habilidades;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Pedrao.KitAPI;
import Pedrao.Main;

public class Kronos implements Listener {

	public Kronos(Main main) {
	}

	  public static HashMap<String, Long> cooldown = new HashMap<String, Long>();
	  @EventHandler
	  public void voar(PlayerInteractEvent e)
	  {
	    final Player p = e.getPlayer();
	    if ((e.getAction().name().contains("RIGHT")) && 
	      (p.getItemInHand().getType() == Material.GLOWSTONE_DUST))
	    {
	      e.setCancelled(true);
	      p.updateInventory();
	      if (KitAPI.Kronos.contains(p.getName())) {
	        if ((!cooldown.containsKey(p.getName())) || (((Long)cooldown.get(p.getName())).longValue() <= System.currentTimeMillis()))
	        {
	          p.setAllowFlight(true);
	          p.setFlying(true);
	          p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10*10, 1));
	          p.sendMessage(Main.prefix + "Nenhun staff gg Fly ON");
	          Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	          {
	            public void run()
	            {
	              p.setFlying(false);
	              p.setAllowFlight(false);
	              p.sendMessage(Main.prefix + "Tem um staff olhando Fly OFF");
	            }
	          }, 150L);
	          cooldown.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(60L)));
	        }
	        else
	        {
	          p.sendMessage(Main.cl);
	        }
	      }
	    }
	  }
	  
	  @EventHandler
	  public void onTomarDano(EntityDamageEvent event)
	  {
	    Entity e = event.getEntity();
	    if ((e instanceof Player))
	    {
	      Player player = (Player)e;
	      if (((event.getEntity() instanceof Player)) && 
	        (event.getCause() == EntityDamageEvent.DamageCause.FALL) && 
	        (player.getInventory().contains(Material.GLOWSTONE_DUST)) && 
	        (event.getDamage() >= 0.0D)) {
	        event.setDamage(0.0D);
	      }
	    }
	  }
}
	  
