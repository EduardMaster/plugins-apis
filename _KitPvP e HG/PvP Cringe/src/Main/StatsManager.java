package Main;

import java.io.File;
import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class StatsManager {

	public static HashMap<String, Integer> Xp = new HashMap<>();

	public static File file;
	public static FileConfiguration cfile;

	public StatsManager() {
		Plugin plugin = Main.getPlugin();

		if (plugin.getDataFolder().exists() == false) {
			plugin.getDataFolder().mkdir();
		}
		file = new File(plugin.getDataFolder(), "StatsManager.yml");
		if (file.exists() == false) {
			try {
				file.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		cfile = YamlConfiguration.loadConfiguration(file);
	}

	public static void FirstJoin(Player jogador) {
		cfile.set(jogador.getName() + ".Kills", 0);
		cfile.set(jogador.getName() + ".Deaths", 0);
		cfile.set(jogador.getName() + ".Coins", 0);
		cfile.set(jogador.getName() + ".Caixas", 0);
		cfile.set(jogador.getName() + ".Wins", 0);
		Save();

		System.out.println("[Config] Arquivos de " + jogador.getName() + " foram Salvos.");
	}

	public static void setKills(Player p) {
		cfile.set(p.getName() + ".Kills", getKills(p) + 1);
		Save();
	}

	public static void setWins(Player p) {
		cfile.set(p.getName() + ".Wins", getWins(p) + 1);
		Save();
	}

	public static void setCaixas(Player p, int quantos) {
		cfile.set(p.getUniqueId() + ".Caixas", Integer.valueOf(quantos));
		Save();
	}

	public static void addKills(Player p, Integer integer) {
		cfile.set(p.getName() + ".Kills", getKills(p) + integer);
		Save();
	}

	public static void addWins(Player p, Integer integer) {
		cfile.set(p.getName() + ".Wins", getWins(p) + integer);
		Save();
	}

	public static int getKills(Player p) {
		return cfile.getInt(p.getName() + ".Kills");
	}

	public static int getWins(Player p) {
		return cfile.getInt(p.getName() + ".Wins");
	}

	public static void setDeaths(Player p) {
		cfile.set(p.getName() + ".Deaths", getDeaths(p) + 1);
		Save();
	}

	public static void removeKills(Player p, Integer interger) {
		if (getKills(p) <= 0) {
			return;
		}
		cfile.set(p.getName() + ".Kills", getKills(p) - interger);
		Save();
	}

	public static void removeDeaths(Player p, Integer interger) {
		if (getDeaths(p) <= 0) {
			return;
		}
		cfile.set(p.getName() + ".Deaths", getDeaths(p) - interger);
		Save();
	}

	public static int getDeaths(Player p) {
		return cfile.getInt(p.getName() + ".Deaths");
	}

	public static void setMoney(Player p, int Money) {
		cfile.set(p.getName() + "Coins", getMoney(p) + Money);
		Save();
	}

	public static void RemoveMoney(Player p, int Money) {
		if (getMoney(p) <= 0) {
			return;
		}
		cfile.set(p.getName() + "Coins", getMoney(p) - Money);
		Save();
	}

	public static int getMoney(Player p) {
		return cfile.getInt(p.getName() + "Coins");
	}

	public static int getCaixas(Player p) {
		return cfile.getInt(p.getUniqueId() + ".Caixas");
	}

	public static void Save() {
		try {
			cfile.save(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
