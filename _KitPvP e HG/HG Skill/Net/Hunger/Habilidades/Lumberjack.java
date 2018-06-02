package Net.Hunger.Habilidades;

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

import Net.Hunger.Comandos.CMDKit;
import Net.Hunger.Manager.Habilidade;

public class Lumberjack implements Listener {

	  @EventHandler(priority=EventPriority.NORMAL)
	  public void onBlockBreak1(BlockBreakEvent event) {
		Player p = event.getPlayer();
	    Block b = event.getBlock();
	    if((Habilidade.getAbility(p).equalsIgnoreCase("lumberjack")) && (b.getType() == Material.LOG) && (p.getItemInHand().getType() == Material.WOOD_AXE)) {
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