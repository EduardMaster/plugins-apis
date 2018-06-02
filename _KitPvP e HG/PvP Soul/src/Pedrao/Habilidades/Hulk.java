package Pedrao.Habilidades;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import Pedrao.KitAPI;
import Pedrao.Main;

public class Hulk implements Listener {

	public Hulk(Main main) {
	}

	  public static HashMap<String, Long> cooldown = new HashMap<String, Long>();
	  
	  @EventHandler
	  public void pegar(PlayerInteractEntityEvent e)
	  {
	    Player p = e.getPlayer();
	    if ((e.getRightClicked() instanceof Player))
	    {
	      Player r = (Player)e.getRightClicked();
	      if (KitAPI.Hulk.contains(p.getName())) {
	        if ((!cooldown.containsKey(p.getName())) || (((Long)cooldown.get(p.getName())).longValue() <= System.currentTimeMillis()))
	        {
	          if (p.getItemInHand().getType() == Material.SADDLE)
	          {
	            e.setCancelled(true);
	            p.updateInventory();
	            p.setPassenger(r);
	            cooldown.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(15L)));
	            p.sendMessage(Main.prefix + "Voce pegou o player: " + ChatColor.WHITE + r.getName());
	            r.sendMessage(Main.prefix + "Voce foi pego pelo Hulk: " + ChatColor.WHITE + p.getName());
	          }
	        }
	        else {
	          p.sendMessage(Main.cl);
	        }
	      }
	    }
	  }
	  
	  @EventHandler
	  public static void playerInteract(PlayerInteractEvent event)
	  {
	    if (!event.getAction().equals(Action.LEFT_CLICK_AIR)) {
	      return;
	    }
	    Player player = event.getPlayer();
	    if ((player.getPassenger() == null) || (!(player.getPassenger() instanceof Player))) {
	      return;
	    }
	    Player pass = (Player)player.getPassenger();
	    player.eject();
	    pass.damage(0.0D, player);
	    pass.setVelocity(new Vector(pass.getVelocity().getX(), 1.0D, pass.getVelocity().getZ()));
	    pass.sendMessage(Main.prefix + "Você foi jogado por " + ChatColor.DARK_RED + player.getName());
	  }
}