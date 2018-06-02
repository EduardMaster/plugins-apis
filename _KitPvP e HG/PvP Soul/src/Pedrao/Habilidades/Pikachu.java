package Pedrao.Habilidades;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import Pedrao.KitAPI;
import Pedrao.Main;

public class Pikachu implements Listener {

	  public Main plugin;
	  
	  public Pikachu(Main plugin)
	  {
	    this.plugin = plugin;
	  }
	  
	  @SuppressWarnings({ "unchecked", "rawtypes" })
	public static ArrayList<Player> cooldown = new ArrayList();
	  @SuppressWarnings({ "unchecked", "rawtypes" })
	  public static ArrayList<Player> nofall = new ArrayList();
	  
	  @EventHandler
	  public void onPikachu(PlayerInteractEvent e)
	  {
	    final Player p = e.getPlayer();
	    if (!KitAPI.Pikachu.contains(p.getName())) {
	      return;
	    }
	    if (p.getItemInHand().getType() != Material.FLINT) {
	      return;
	    }
	    e.setCancelled(true);
	    if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
	    {
	      if (cooldown.contains(p))
	      {
	        p.sendMessage(Main.cl);
	        return;
	      }
	      p.setVelocity(new Vector(0.0D, 3.0D, 0.0D));
	      cooldown.add(p);
	      nofall.add(p);
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
	      {
	        @SuppressWarnings("deprecation")
			public void run()
	        {
	          if (p.getTargetBlock(null, 50).getType() == Material.GLASS)
	          {
	            p.sendMessage(Main.prefix + "Aki nao outro lugar.");
	            return;
	          }
	          World w = p.getTargetBlock(null, 50).getLocation().getWorld();
	          double x = p.getTargetBlock(null, 50).getLocation().getX();
	          double y = p.getTargetBlock(null, 50).getLocation().getY();
	          double z = p.getTargetBlock(null, 50).getLocation().getZ();
	          Location loc = new Location(w, x, y + 1.0D, z);
	          p.teleport(loc);
	          p.getWorld().strikeLightningEffect(loc);
	        }
	      }, 30L);
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
	      {
	        public void run()
	        {
	          Pikachu.nofall.remove(p);
	          p.sendMessage(Main.prefix + "Agora pode tomar dano de queda");
	        }
	      }, 100L);
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
	      {
	        public void run()
	        {
	          Pikachu.cooldown.remove(p);
	          p.sendMessage(Main.prefix + "§aCooldown acabou !");
	        }
	      }, 600L);
	    }
	  }
	  
	  @EventHandler
	  public void nofall(EntityDamageEvent e)
	  {
	    if ((e.getEntity() instanceof Player))
	    {
	      Player p = (Player)e.getEntity();
	      if (!nofall.contains(p)) {
	        return;
	      }
	      if (e.getCause() != EntityDamageEvent.DamageCause.FALL) {
	        return;
	      }
	      e.setCancelled(true);
	    }
	  }
	}
