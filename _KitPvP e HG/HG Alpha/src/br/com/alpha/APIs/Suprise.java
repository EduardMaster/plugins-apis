package br.com.alpha.APIs;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import br.com.alpha.MCAlpha;



public class Suprise implements Listener {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ArrayList<String> kits = new ArrayList();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ArrayList<String> lista = new ArrayList();

	public static void setSurprise(Player player) {
		String kitname = getViableKit();
		char[] stringArray = kitname.toCharArray();
		stringArray[0] = Character.toUpperCase(stringArray[0]);
		kitname = new String(stringArray);
		player.sendMessage(MCAlpha.Logo + " §7Seu kit surpresa foi " + kitname);
		LoadKits.loadKits(player);

	}

	public Suprise() {
		kits.add("anchor");
		kits.add("backpacker");
		kits.add("cacto");
		kits.add("copycat");
		kits.add("crafter");
		kits.add("cultivator");
		kits.add("demoman");
		kits.add("durability");
		kits.add("dwarf");
		kits.add("enderman");
		kits.add("endermage");
		kits.add("fireman");
		kits.add("firer");
		kits.add("fisherman");
		kits.add("forger");
		kits.add("gladiator");
		kits.add("grappler");
		kits.add("hulk");
		kits.add("jellyfish");
		kits.add("kangaroo");
		kits.add("lumberjack");
		kits.add("miner");
		kits.add("monk");
		kits.add("ninja");
		kits.add("poseidon");
		kits.add("reaper");
		kits.add("snail");
		kits.add("specialist");
		kits.add("stomper");
		kits.add("switcher");
		kits.add("tank");
		kits.add("thor");
		kits.add("timelord");
		kits.add("tower");
		kits.add("turtle");
		kits.add("viking");
		kits.add("viper");
		kits.add("wolff");
		kits.add("worm");
	}

	public static String getViableKit() {
		if (kits.size() > 0) {
			return (String) kits.get(new Random().nextInt(kits.size()));
		}
		return null;
	}
	
}
