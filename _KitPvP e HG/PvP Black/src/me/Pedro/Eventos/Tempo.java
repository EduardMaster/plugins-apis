 package me.Pedro.Eventos;

import java.util.HashMap;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;

import me.Pedro.Main;

public class Tempo
{
	  public static HashMap<Player, Long> run = new HashMap();
	  
	  public static ItemStack run(Material m, int qnt, String nome, List<String> lore)
	  {
	    ItemStack item = new ItemStack(m, qnt);
	    ItemMeta meta = item.getItemMeta();
	    meta.setDisplayName(nome);
	    meta.setLore(lore);
	    item.setItemMeta(meta);
	    return item;
	  }
	  
	  public static void add(final Player p, int seconds)
	  {
	    long cooldownLength = System.currentTimeMillis() + seconds * 1000;
	    
	    run.remove(p);
	    run.put(p, Long.valueOf(cooldownLength));
	    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin,   new Runnable()
	      {
	        public void run()
	        {
	          run.remove(p);
	        }
	      }, seconds * 20);
	  }
	  
	  public static long tempo(Player p)
	  {
	    long cooldownLength = ((Long)run.get(p)).longValue();
	    long left = (cooldownLength - System.currentTimeMillis()) / 1000L;
	    return left;
	  }
	  
	  public static boolean add(Player p)
	  {
	    return run.containsKey(p);
	  }
	  
	  public static void viado(Player p)
	  {
	    run.remove(p);
	  }
}