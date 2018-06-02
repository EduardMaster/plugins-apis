package me.rafael.vinagre.KomboPvP.Listeners;

import org.bukkit.entity.Player;

import me.rafael.vinagre.KomboPvP.Main;

public class KillsDeathsMoney {
	
	public static void addKill(final Player p, final int i) {
        final int Value = Main.getInstance().status.getInt(String.valueOf(p.getUniqueId()) + ".Kills");
        Main.getInstance().status.set(String.valueOf(p.getUniqueId()) + ".Kills", (Object)(Value + i));
        Main.getInstance().save();
    }
	public static void addDeaths(Player p, int i) {
		int Value = Main.getInstace().status.getInt(p.getUniqueId() + ".Deaths");
		Main.getInstace().status.set(p.getUniqueId() + ".Deaths", Integer.valueOf(Value + 1));
		Main.getInstace().save();
	}
	
	
	
	
	public static int getKills(Player p) {
		return Main.getInstace().status.getInt(p.getUniqueId() + ".Kills");
	}
	
	public static int getDeaths(Player p) {
		return Main.getInstace().status.getInt(p.getUniqueId() + ".Deaths");
	}
	
}