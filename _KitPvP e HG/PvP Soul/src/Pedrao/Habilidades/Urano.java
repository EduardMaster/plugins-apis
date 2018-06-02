package Pedrao.Habilidades;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Pedrao.KitAPI;
import Pedrao.Main;
import me.confuser.barapi.BarAPI;

public class Urano implements Listener {

	public Urano(Main main) {
	}

	  @SuppressWarnings({ "unchecked", "rawtypes" })
	public static ArrayList<Player> cooldownm = new ArrayList();
	  
	  @EventHandler
	  public void stomperApple(PlayerInteractEvent event)
	  {
	    final Player p = event.getPlayer();
	    if ((event.getPlayer().getItemInHand().getType() == Material.SLIME_BALL) && 
	      (KitAPI.Urano.contains(event.getPlayer().getName())))
	    {
	      if ((event.getAction() == Action.LEFT_CLICK_AIR) || 
	        (event.getAction() == Action.LEFT_CLICK_BLOCK) || 
	        (event.getAction() == Action.RIGHT_CLICK_BLOCK) || 
	        (event.getAction() == Action.RIGHT_CLICK_AIR)) {
	        event.setCancelled(true);
	      }
	      if (cooldownm.contains(p))
	      {
	        p.sendMessage(Main.cl);
	        return;
	      }
	      Location loc = p.getLocation();
	      p.getWorld().playSound(loc, Sound.BAT_HURT, 5.0F, -5.0F);
	      cooldownm.add(p);
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	        	KitAPI.Urano1.add(p.getName());
	        }
	      }, 0L);
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	        	KitAPI.Urano1.remove(p.getName());
	        }
	      }, 100L);
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	          Urano.cooldownm.remove(p);
	          p.sendMessage(Main.prefix + "§aVoce Já pode usar seu Kit!");
	          p.getWorld().playSound(p.getLocation(), Sound.BURP, 5.0F, 5.0F);
	        }
	      }, 1000L);
	    }
	  }
	  
	  @EventHandler
	  public void fraqueza(PlayerMoveEvent event)
	  {
	    Player p = event.getPlayer();
	    if (KitAPI.Urano1.contains(p.getName())) {
	      for (Entity pertos : p.getNearbyEntities(5.0D, 5.0D, 5.0D)) {
	        if ((pertos instanceof Player))
	        {
	          p.getWorld().playEffect(p.getLocation(), Effect.POTION_BREAK, 100, 1);
	          
	          final Player perto = (Player)pertos;
	          Location loc = pertos.getLocation();
	          loc.setY(loc.getY() + 3.0D);
	          
	          final Entity arrow2 = Bukkit.getServer().getWorld(pertos.getLocation().getWorld().getName()).spawnEntity(loc, EntityType.BAT);
	          
	          ((LivingEntity)pertos).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 150, 1));
	          Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	          {
	            public void run()
	            {
	              BarAPI.removeBar(perto);
	              arrow2.remove();
	            }
	          }, 10L);
	        }
	      }
	    }
	  }
	}
