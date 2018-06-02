package me.recenthg.Kits;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import me.recenthg.Main;
import me.recenthg.Manager.Habilidade;
import me.recenthg.Utils.Estado;

@SuppressWarnings("unused")
public class LumberJack implements Listener {

	  @SuppressWarnings("deprecation")
	@EventHandler(priority=EventPriority.NORMAL)
	  public void onBlockBreak1(BlockBreakEvent event) {
		Player p = event.getPlayer();
	    Block b = event.getBlock();
	    if (Main.estados == Estado.INVENCIBILIDADE || Main.estados == Estado.ANDAMENTO)
	    if((Habilidade.getAbility(p).equalsIgnoreCase("lumberjack"))) 
	    		if ((b.getType() == Material.LOG) && (p.getItemInHand().getType() == Material.WOOD_AXE)) {
	      World w = (World)Bukkit.getServer().getWorlds().get(0);
	      Double y = Double.valueOf(b.getLocation().getY() + 1.0D);
	      Location l = new Location(w, b.getLocation().getX(), y.doubleValue(), b.getLocation().getZ());
	      while (l.getBlock().getType() == Material.LOG) {
	        l.getBlock().breakNaturally();
	        Double localDouble1 = y; Double localDouble2 = y = Double.valueOf(y.doubleValue() + 1.0D);
	        l.setY(y.doubleValue());
	      }
	      while (l.getBlock().getType() == Material.getMaterial(162)) {
		  l.getBlock().breakNaturally();
		  Double localDouble1 = y; Double localDouble2 = y = Double.valueOf(y.doubleValue() + 1.0D);
		  l.setY(y.doubleValue());
		 }
	   } 
	  }
}