package me.recenthg.Manager;

import org.bukkit.entity.Player;

import me.recenthg.Main;

public class Manager {
	
	public static void addWin(Player p) {
		int v = Main.instance.stats.getInt(p.getUniqueId() + ".Wins");
		Main.instance.stats.set(p.getUniqueId() + ".Wins", v + 1);
	}
	
	public static int getWin(Player p) {
		return Main.instance.stats.getInt(p.getUniqueId() + ".Wins");
	}
	
	public static void addMatou(Player p) {
		int v = Main.instance.stats.getInt(p.getUniqueId() + ".Matou");
		Main.instance.stats.set(p.getUniqueId() + ".Matou", v + 1);
	}
	
	public static int getMatou(Player p) {
		return Main.instance.stats.getInt(p.getUniqueId() + ".Matou");
	}
	
	public static void addMorreu(Player p) {
		int v = Main.instance.stats.getInt(p.getUniqueId() + ".Morreu");
		Main.instance.stats.set(p.getUniqueId() + ".Morreu", v + 1);
	}
	
	public static int getMorreu(Player p) {
		return Main.instance.stats.getInt(p.getUniqueId() + ".Morreu");
	}

}
