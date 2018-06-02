package me.recenthg.Manager;
 
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class Habilidade {
 
public static final String cooldown = null;
public static Map<String, String> powerMap = new HashMap<String, String>(); 
 
    public static String NomeDoKit(String original){
    if(original.length() == 0)
    return original;
    return original.substring(0, 1).toUpperCase() + original.substring(1);
    }
   
    public static String getAbility(Player player) {
    if(!powerMap.containsKey(player.getName()))
    powerMap.put(player.getName(),"Nenhum");
    return powerMap.get(player.getName());  
    }
   
    public static void setAbility(Player player, String ability) {
    powerMap.put(player.getName(), ability);
    }
    
    public static void removeAbility(Player p) {
	powerMap.remove(p.getName()); 
    }
    
    public static void strikeLightning(Entity p){
    Location coords = p.getLocation();
    coords.getWorld().strikeLightningEffect(coords);
    Block block = coords.getBlock();
    block.setType(Material.AIR);
    }
}