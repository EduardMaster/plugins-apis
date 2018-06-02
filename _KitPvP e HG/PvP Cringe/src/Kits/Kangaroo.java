package Kits;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import Utils.KitAPI;

public class Kangaroo implements Listener {
	public static HashMap<String, Integer> KangarroStats = new HashMap<>();
	public static ArrayList<String> F = new ArrayList<>();
	
	@EventHandler(priority=EventPriority.HIGH)
	public void Clicar(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((KitAPI.getKit(p) == "Kangaroo") && (e.getMaterial() == Material.FIREWORK)) {
			e.setCancelled(true);
			if (p.isSneaking()) {
			if (!F.contains(p.getName())) {
				p.setVelocity(p.getLocation().getDirection().multiply(1.2D));
				p.setVelocity(new Vector(p.getVelocity().getX(), 0.5D, p.getVelocity().getZ()));
				KangarroStats.put(p.getName(), Integer.valueOf(1));
			} else {
				if (KangarroStats.get(p.getName()) != 2) {
					p.setVelocity(p.getLocation().getDirection().multiply(1.2D));
					p.setVelocity(new Vector(p.getVelocity().getX(), 0.5D, p.getVelocity().getZ()));
					KangarroStats.put(p.getName(), Integer.valueOf(2));
				   }
			}
			} else {
				if (!F.contains(p.getName())) {
					p.setVelocity(new Vector(p.getVelocity().getX(), 1.0D, p.getVelocity().getZ()));
					KangarroStats.put(p.getName(), Integer.valueOf(1));
			} else {
				if (KangarroStats.get(p.getName()) != 2) {
				p.setVelocity(new Vector(p.getVelocity().getX(), 1.0D, p.getVelocity().getZ()));
				KangarroStats.put(p.getName(), Integer.valueOf(2));
	   	}
	   }
	  }
	}
  }
	@EventHandler
	public void andar(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		Block b = p.getLocation().getBlock();
		if (KitAPI.getKit(p) == "Kangaroo") {
			if (b.getRelative(BlockFace.DOWN).getType() == Material.AIR) {
				F.add(p.getName());
		} else {
			if (b.getType() == Material.AIR) {
				KangarroStats.put(p.getName(), Integer.valueOf(0));
				F.remove(p.getName());
			}
			if ((b.getRelative(BlockFace.DOWN).getType() != Material.AIR) || (b.getType() != Material.AIR)) {
				KangarroStats.put(p.getName(), Integer.valueOf(0));
				F.remove(p.getName());
			}
	  }
	}
  }
}








