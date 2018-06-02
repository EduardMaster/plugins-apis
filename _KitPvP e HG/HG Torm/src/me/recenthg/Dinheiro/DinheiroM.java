package me.recenthg.Dinheiro;

import org.bukkit.entity.Player;

import me.recenthg.Utils.MyConfig;
import me.recenthg.Utils.MyConfigManager;

public class DinheiroM {
	
	public static MyConfig money;
	public static int defaultmoney = 0;
	public static MyConfigManager manager;
	public static MyConfig elo;
	public static MyConfigManager elom;
	public static String MostrarDinheiroPlayer;

	
	public static void CarregarDinheiro() {
		money = manager.getNewConfig("xp.yml");
		elo = elom.getNewConfig("Elo.yml");
	}
	
	public static int MostrarDinheiroPlayer(Player p) {
		return money.getInt(p.getUniqueId().toString());
	}
	
	public static int MostrarEloPlayer(Player p) {
		return elo.getInt(p.getUniqueId().toString());
	}
	
	public static void darDinheiro(Player p, int quantia) {
		money.set(p.getUniqueId().toString(), Integer.valueOf(MostrarDinheiroPlayer(p) + quantia));
		money.saveConfig();
	}
	
	public static void darElo(Player p, int quantia) {
		elo.set(p.getUniqueId().toString(), Integer.valueOf(MostrarEloPlayer(p) + quantia));
		elo.saveConfig();
	}
	
	public static void TirarElo(Player p, int quantia) {
		elo.set(p.getUniqueId().toString(), Integer.valueOf(MostrarEloPlayer(p) - quantia));
		elo.saveConfig();
	}
	
	public static void TirarDinheiro(Player p, int quantia) {
		money.set(p.getUniqueId().toString(), Integer.valueOf(MostrarDinheiroPlayer(p) - quantia));
		money.saveConfig();
	}
	
	public static boolean contains(String name) {
		return false;
	}
	
	
}
