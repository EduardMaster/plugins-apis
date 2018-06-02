package me.recenthg.Borda;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.recenthg.Main;

public class BorderMove implements Listener {
	
	@EventHandler
	public void ForcefieldDamagePositive(PlayerMoveEvent e) {
	 final Player p = e.getPlayer();
	 Location loc = p.getLocation();
	 World w = p.getWorld();
	
	 if(w.getSpawnLocation().getWorld().setSpawnLocation(0, 120, 0)) {
	 if ((Math.abs(loc.getBlockX() + w.getSpawnLocation().getBlockX()) >= 500) || 
	 (Math.abs(loc.getBlockZ() + w.getSpawnLocation().getBlockZ()) >= 500)) {
	 if(Main.Jogadores.contains(p.getName())) {
     p.setFireTicks(500);
	 p.damage(8.5D);

     Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
     public void run() {
 
     }
     },80L);
     } else {
     return;
     }
   }
  } 
 }	
}