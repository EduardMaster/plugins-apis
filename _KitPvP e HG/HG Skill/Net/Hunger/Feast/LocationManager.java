package Net.Hunger.Feast;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import Net.Hunger.Main;

public class LocationManager {
	
	public static Location getAtualLoc(Player p) {
		return p.getLocation();
	}
	
	public static int getPlayerBlockX(Player p) {
		return p.getLocation().getBlockX();
	}
	
	public static int getPlayerBlockY(Player p) {
		return p.getLocation().getBlockY();
	}
	
	public static int getPlayerBlockZ(Player p) {
		return p.getLocation().getBlockZ();
	}
	
	public static Double getPlayerX(Player p) {
		return p.getLocation().getX();
	}
	public static Double getPlayerY(Player p) {
		return p.getLocation().getY();
	}
	
	public static Location getBlockLoc(Block b) {
	  return b.getLocation();
	}
	public static int getBlockX(Block b) {
		return b.getX();
	}
	
	public static int getBlockY(Block b) {
		return b.getY();
	}
	
	public static int getBlockZ(Block b) {
		return b.getZ();
	}
	
	public static Double getPlayerZ(Player p) {
		return p.getLocation().getZ();
	}
	
	public static Location getFeastLocation() {
		return Main.getFeastLocation();
	}
}