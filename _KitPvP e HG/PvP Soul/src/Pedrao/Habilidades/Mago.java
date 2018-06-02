package Pedrao.Habilidades;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import Pedrao.KitAPI;
import Pedrao.Main;

public class Mago implements Listener {

	public Mago(Main main) {
	}

	  public ArrayList<Player> cooldownm = new ArrayList<Player>();
	  
	  @EventHandler
	  public void AirMageHAB(PlayerInteractEvent event)
	  {
	    final Player player = event.getPlayer();
	    if ((player.getItemInHand().getType().equals(Material.BONE)) && (event.getAction().name().contains("RIGHT")))
	    {
	      if (this.cooldownm.contains(player))
	      {
	        player.sendMessage(Main.cl);
	        return;
	      }
	      if (KitAPI.Mago.contains(event.getPlayer().getName())) {
	        for (Entity target : event.getPlayer().getNearbyEntities(8.0D, 5.0D, 8.0D)) {
	          if ((target instanceof Player))
	          {
	            final Player t = (Player)target;
	            
	            Vector sponge = t.getLocation().getDirection().multiply(0).setY(0.8D);
	            @SuppressWarnings("unused")
				Vector sponge2 = t.getLocation().getDirection().multiply(0).setY(1);
	            @SuppressWarnings("unused")
				Vector sponge22 = t.getLocation().getDirection().multiply(0).setY(1.2D);
	            final Vector sponge222 = t.getLocation().getDirection().multiply(0).setY(1.2D);
	            t.setVelocity(sponge);
	            
	            player.sendMessage(Main.prefix + "Voce esta levitando os jogadores a 8 blocos ao seu redor!");
	            this.cooldownm.add(player);
	            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	            {
	              public void run()
	              {
	                t.setVelocity(sponge222);
	              }
	            }, 15L);
	            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	            {
	              public void run()
	              {
	                t.setVelocity(sponge222);
	              }
	            }, 15L);
	            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	            {
	              public void run()
	              {
	                t.setVelocity(sponge222);
	              }
	            }, 20L);
	            
	            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	            {
	              public void run()
	              {
	                player.sendMessage(Main.prefix + "Cooldown Acabou");
	                cooldownm.remove(player);
	              }
	            }, 600L);
	          }
	        }
	      }
	    }
	  }
	}
