package me.rafael.vinagre.KomboPvP.Kits;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import me.rafael.vinagre.KomboPvP.*;
import me.rafael.vinagre.KomboPvP.Listeners.Array;
public class Exploder implements Listener, CommandExecutor {
	 public static Main plugin;
	  public static HashMap<String, Long> cooldown = new HashMap();
	  public static HashMap<String, Egg> teias = new HashMap();
	  

	  public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args)
	  {
	    Player p = (Player)sender;
	    ItemStack dima = new ItemStack(Material.STONE_SWORD);
	    ItemMeta souperaa = dima.getItemMeta();
	    souperaa.setDisplayName("§bEspada");
	    dima.setItemMeta(souperaa);
	    ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
	    ItemMeta sopas = sopa.getItemMeta();
	    sopas.setDisplayName("§6Sopa");
	    sopa.setItemMeta(sopas);
	  	
	    
	    ItemStack capacete0 = new ItemStack(Material.AIR);
	    
	    ItemStack peitoral0 = new ItemStack(Material.AIR);
	    
	    ItemStack calca0 = new ItemStack(Material.AIR);
	    
	    ItemStack Bota0 = new ItemStack(Material.AIR);
	    
	    p.getInventory().setHelmet(capacete0);
	    p.getInventory().setChestplate(peitoral0);
	    p.getInventory().setLeggings(calca0);
	    p.getInventory().setBoots(Bota0);

	  if (cmd.equalsIgnoreCase("nofall")) {
	    if (Array.used.contains(p.getName())) {
	    	p.sendMessage("§7» §cVoce ja esta usando um kit!");
	      return true;
	    }
	    if (!p.hasPermission("kitpvp.kit.nofall")) {
	  	      p.sendMessage("§cVoce nao tem permissao para usar este kit !");
	      return true;
	    }
	    Array.used.add(p.getName());
	    p.sendMessage("§7» Voce escolheu o kit §cNoFall §7!");
	    p.setGameMode(GameMode.ADVENTURE);
	    p.getInventory().clear();
	    Array.kit.put(p, "NoFall");
	    Vinagre.Habilidade.setAbility(p, "nofall");
	    p.getInventory().addItem(new ItemStack[] { dima });
	    Main.stomper.remove(p.getName());
	    Main.give(p);
	    Main.Deshfire.remove(p.getName());
	    Main.Dj.remove(p.getName());
	    Main.antistomper.add(p.getName());
	    
	    Scoreboard.ScoreDoBasic.iscoriboard(p);
	    for (int i = 0; i <= 34; i++) {
	      p.getInventory().addItem(new ItemStack[] { sopa });
	     
	    }
	  }
	  me.rafael.vinagre.KomboPvP.Comandos.SetArena.TeleportArenaRandom(p);
	return false;
	  }
	  
	  @EventHandler(priority=EventPriority.HIGH)
	  public void onPlayerStomp(EntityDamageEvent e)
	  {
	    if (!(e.getEntity() instanceof Player)) {
	      return;
	    }
	    Player p = (Player)e.getEntity();
	    if (e.getCause() == EntityDamageEvent.DamageCause.FALL)
	    {
	      if (Main.antistomper.contains(p.getName()))
	      {
	        e.setCancelled(true);
	        return;
	      }
	      return;
	    }
	  }
}
	  
