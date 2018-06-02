package me.recenthg.Eventss;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.recenthg.Main;

public class LojaDiaria {

	private static File file;
	private static FileConfiguration files;

	public static void Setup1(Player s) {
		file = new File(Main.instance.getDataFolder() + File.separator + "/coinsdiarias/" + s.getName() + ".yml");
		files = YamlConfiguration.loadConfiguration(file);
		SaveConfig1();
	}

	public static void SaveConfig1() {
		try {
			files.save(file);
		} catch (Exception e) {
		}
	}

	public static String getString1(String str) {
		return files.getString(str);
	}

	public static String getProxKIT(Player s) {
		Setup1(s);
		int dia = files.getInt("Dia");
		int horas = files.getInt("Horas");
		int minutos = files.getInt("Minutos");
		int segundos = files.getInt("Segundos");
		String tempo = "§7Dia §4" + dia + " §7as §4" + horas + " §7Horas §4" + minutos + " §7Minutos §7e §4" + segundos + " §7Segundos";

		return tempo;

	}

	public static Integer getInt1(String str) {
		return files.getInt(str);
	}

	public static void SetConfig1(String set, String result) {
		files.set(set, result);
		SaveConfig1();
	}

	public static void SetConfig1(String set, int result) {
		files.set(set, result);
		SaveConfig1();
	}

}
