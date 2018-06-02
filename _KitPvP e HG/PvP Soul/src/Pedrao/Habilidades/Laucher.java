package Pedrao.Habilidades;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import Pedrao.KitAPI;
import Pedrao.Main;

public class Laucher implements Listener {

	public Laucher(Main main) {
	}
	  public static final Player voador = null;
	  
	  @EventHandler
	  public void onSpongePlace(BlockPlaceEvent e)
	  {
	    Player p = e.getPlayer();
	    if (!KitAPI.Laucher.contains(p)) {
	      return;
	    }
	    if (p.getItemInHand().getType() != Material.SPONGE) {
	      return;
	    }
	    int spongesleft = p.getItemInHand().getAmount();
	    e.setCancelled(true);
	    Location placed = e.getBlock().getLocation();
	    World w = placed.getWorld();
	    double x = placed.getX();
	    double y = placed.getY();
	    double z = placed.getZ();
	    final Location sponge = new Location(w, x, y, z);
	    final Material block = e.getBlockReplacedState().getType();
	    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	    {
	      public void run()
	      {
	        sponge.getBlock().setType(Material.SPONGE);
	      }
	    }, 1L);
	    if (p.getItemInHand().getAmount() == 1) {
	      p.setItemInHand(new ItemStack(Material.AIR));
	    }
	    p.getItemInHand().setAmount(spongesleft - 1);
	    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	    {
	      public void run()
	      {
	        sponge.getBlock().setType(block);
	      }
	    }, 140L);
	  }
	}
