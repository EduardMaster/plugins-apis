package Net.Hunger.Habilidades;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.util.Vector;

import Net.Hunger.Main;
import Net.Hunger.Comandos.CMDKit;
import Net.Hunger.Manager.Habilidade;

public class Dwarf implements Listener {
	
	  public int cooldown1 = 30;  
	  private HashMap<Player, Long> cooldownExpires = new HashMap<Player, Long>();
	  private HashMap<Player, Long> startedSneaking = new HashMap<Player, Long>();
	
	  @EventHandler
	  public void onSneak(PlayerToggleSneakEvent event) {
	    Player p = event.getPlayer();	
	    if(Main.Partida) {
	     if((Habilidade.getAbility(p).equalsIgnoreCase("dwarf"))) {
	      if ((this.cooldownExpires.containsKey(p)) && (((Long)this.cooldownExpires.get(p)).longValue() < System.currentTimeMillis()))
	        this.cooldownExpires.remove(p);
	      if (event.isSneaking()) {
	        this.startedSneaking.put(p, Long.valueOf(System.currentTimeMillis()));
	      } else if (this.startedSneaking.containsKey(p)) {
	        this.cooldownExpires.put(p, Long.valueOf(System.currentTimeMillis() + this.cooldown1 * 1500));
	        long sneakingTime = System.currentTimeMillis() - ((Long)this.startedSneaking.remove(p)).longValue();
	        double knockBack = 0.5D * (sneakingTime / 2000L);
	        for (Entity entity : p.getNearbyEntities(knockBack, knockBack, knockBack))
	        if ((!(entity instanceof Player)) || (!((Player)entity).isSneaking())) {
	        Vector vector = entity.getLocation().toVector().subtract(p.getLocation().toVector()).normalize();
	        entity.setVelocity(vector.multiply(knockBack));
		    p.sendMessage("§7[§a!§7] Você com a força de §a" + knockBack);
	        }
	      }
	    }
	  }
	}
}