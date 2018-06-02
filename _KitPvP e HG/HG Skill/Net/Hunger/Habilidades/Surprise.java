package Net.Hunger.Habilidades;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import Net.Hunger.Eventos.LoadKits;
import Net.Hunger.Manager.Habilidade;

public class Surprise implements Listener {
	
  public static ArrayList<String> kits = new ArrayList<String>();
  public static ArrayList<String> lista = new ArrayList<String>();
  
  public static void setSurprise(Player player) {
    String kitname = Surprise.getViableKit();
    Habilidade.setAbility(player, kitname);
    char[] stringArray = kitname.toCharArray();
    stringArray[0] = Character.toUpperCase(stringArray[0]);
    kitname = new String(stringArray);
    player.sendMessage("§7[§a!§7] Surprise escolheu §a" + kitname);
    LoadKits.CheckKits(player);
    Habilidade.setAbility(player, kitname);
  }
  
  ArrayList<String> SnifPvP = new ArrayList<String>();
  
  @EventHandler
  public void onSnif(PlayerToggleSneakEvent e) {
	  Player p = e.getPlayer();
	  
  }
		  
  public Surprise() {
    kits.add("anchor");
    kits.add("backpacker");
    kits.add("bigjump");
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
      return (String)kits.get(new Random().nextInt(kits.size()));
    }
    return null;
  }
}