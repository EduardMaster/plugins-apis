package Utils;

import org.bukkit.entity.Player;

import Main.Main;

public class KillDeathsMoney {
	
	public static void addKill(Player p) {
		int Value = Main.getInstance().stats.getInt(p.getUniqueId() + ".Kills");
		Main.getInstance().stats.set(p.getUniqueId() + ".Kills", Integer.valueOf(Value + 1));
		Main.getInstance().save();
	}
	
	public static void addDeath(Player p) {
		int Value = Main.getInstance().stats.getInt(p.getUniqueId() + ".Deaths");
		Main.getInstance().stats.set(p.getUniqueId() + ".Deaths", Integer.valueOf(Value + 1));
		Main.getInstance().save();
	}
	
	public static void addMoney(Player p) {
		int Value = Main.getInstance().stats.getInt(p.getUniqueId() + ".Money");
		Main.getInstance().stats.set(p.getUniqueId() + ".Money", Integer.valueOf(Value + 100));
		Main.getInstance().save();
	}
	
	public static void removeMoney(Player p) {
		int Value = Main.getInstance().stats.getInt(p.getUniqueId() + ".Money");
		if ((Value - 60) > 0) {
			Main.getInstance().stats.set(p.getUniqueId() + ".Money", Integer.valueOf(Value - 60));
		} else {
			Main.getInstance().stats.set(p.getUniqueId() + ".Money", Integer.valueOf(0));
		}
		Main.getInstance().save();
	}
	
	public static int  getKills(Player p) {
		return Main.getInstance().stats.getInt(p.getUniqueId() + ".Kills");
	}
	
	public static int  getDeath(Player p) {
		return Main.getInstance().stats.getInt(p.getUniqueId() + ".Deaths");
	}
	
	public static int  getMoney(Player p) {
		return Main.getInstance().stats.getInt(p.getUniqueId() + ".Money");
	}
}
