package me.rafael.vinagre.KomboPvP.Listeners;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Array {
	
	  public static String monkCooldownMessage = "§cVoce pode monkar denovo em %s segundos!";
	  public String monkedMessage = "§cVoce usou o poder monk !";
	  public static int cooldownmonk = 15;
	  @SuppressWarnings("deprecation")
	public static int monkItemId = Material.BLAZE_ROD.getId();
	  public static boolean sendThroughInventory = true;
	  public static transient HashMap<ItemStack, Long> monkStaff = new HashMap<ItemStack, Long>();
	
	public static ArrayList<String> admin = new ArrayList<String>();
	public static ArrayList<String> report = new ArrayList<String>();
	
	public static ArrayList<String> used = new ArrayList<String>();
	public static ArrayList<String> warp = new ArrayList<String>();
	
	public static ArrayList<String> Velotrol2 = new ArrayList<String>();
	public static ArrayList<String> freeze = new ArrayList<String>();
	public static ArrayList<String> freezing = new ArrayList<String>();
	
	public static HashMap<Player, String> kit = new HashMap<Player, String>();
	
	public static int getPing(Player p)
	  {
	    return ((CraftPlayer)p).getHandle().ping;
	  }
	  
	  public static int Ping(Player p)
	  {
	    return ((CraftPlayer)p).getHandle().ping;
	  }
	  
	  public static String getShortStr(String name)
	  {
	    if (name.length() >= 16) {
	      String shorts = name.substring(0, 13);
	      return shorts;
	    }
	    if (name.length() >= 15) {
	      String shorts = name.substring(0, 13);
	      return shorts;
	    }
	    return name;
	  }

	  public static String getShortTagMod(String name)
	  {
	    if (name.length() >= 16) {
	      String shorts = name.substring(0, 12);
	      return shorts;
	    }
	    if (name.length() >= 15) {
	      String shorts = name.substring(0, 12);
	      return shorts;
	    }
	    if (name.length() >= 14) {
	      String shorts = name.substring(0, 12);
	      return shorts;
	    }
	    if (name.length() >= 13) {
	      String shorts = name.substring(0, 12);
	      return shorts;
	    }
	    return name;
	  }
}