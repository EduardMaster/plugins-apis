package me.recenthg.Kits;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import me.recenthg.Manager.DarItemDoKit;
import me.recenthg.Manager.Habilidade;

public class Surprise implements Listener {
	
  public static ArrayList<String> kits = new ArrayList<String>();
  public static ArrayList<String> lista = new ArrayList<String>();
  
  public static void setSurprise(Player player) {
    String kitname = Surprise.getViableKit();
    Habilidade.setAbility(player, kitname);
    char[] stringArray = kitname.toCharArray();
    stringArray[0] = Character.toUpperCase(stringArray[0]);
    kitname = new String(stringArray);
    player.sendMessage("§8\u276e§4§l!§8\u276f §7Surprise escolheu §4" + kitname);
    DarItemDoKit.CheckKits(player);
    Habilidade.setAbility(player, kitname);
  }
  
  @EventHandler
  public void onSnif(PlayerToggleSneakEvent e) {
	  @SuppressWarnings("unused")
	Player p = e.getPlayer();
  }
		  
  public Surprise() {
    kits.add("anchor");
    kits.add("poseidon");
    kits.add("aladdin");
    kits.add("fireman");
    kits.add("kangaroo");
    kits.add("fisherman");
    kits.add("lumberjack");
    kits.add("thor");
    kits.add("viper");
    kits.add("snail");
   
  }
  
  public static String getViableKit() {
    if (kits.size() > 0) {
      return (String)kits.get(new Random().nextInt(kits.size()));
    }
    return null;
  }
}