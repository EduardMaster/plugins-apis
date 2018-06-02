package me.rafael.vinagre.KomboPvP.Kits;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;


public class Anchor 
implements Listener, CommandExecutor
{
	  public static Main plugin;
	  
	  public Anchor(Main main)
	  {
	    plugin = main;
	  }
	  
	  @EventHandler(priority=EventPriority.MONITOR)
	  public void onPlayerHitAnchor(EntityDamageByEntityEvent e) {
		 if (!(e.getEntity() instanceof Player)) {
	      return;
	    }
	    if (!(e.getDamager() instanceof Player)) {
	      return;
	    }
	    final Player p = (Player)e.getEntity();
	    Player a = (Player)e.getDamager();
	    if (Array.kit.get(p) == "Anchor")
	    {
	      p.setVelocity(new Vector());
	      p.playSound(p.getLocation(), Sound.ANVIL_LAND, 7.0F, 4.0F);
	      Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
	      {
	        public void run()
	        {
	          p.setVelocity(new Vector());
	        }
	      }, 1L);
	    }
	    if (Array.kit.get(a) == "Anchor")
	    {
	      a.playSound(a.getLocation(), Sound.ANVIL_LAND, 7.0F, 4.0F);
	      p.setVelocity(new Vector());
	      Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
	      {
	        public void run()
	        {
	          p.setVelocity(new Vector());
	        }
	      }, 1L);
	    }
	  }
	  public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args)
	  {
	    Player p = (Player)sender;
	    ItemStack dima = new ItemStack(Material.STONE_SWORD);
	    ItemMeta souperaa = dima.getItemMeta();
	    souperaa.setDisplayName("§cEspada");
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
	    
	    if (cmd.equalsIgnoreCase("anchor")) {
	      if (Array.used.contains(p.getName())) {
	    	  p.sendMessage(" §7» §cVoce ja esta usando um kit !");
	        return true;
	      }
	      if (!p.hasPermission("kitpvp.kit.anchor")) {
		      p.sendMessage("§cVoce nao tem permissao para usar este kit !");
	        return true;
	      }
	      Array.used.add(p.getName());
	      p.sendMessage(" §7» Voce escolheu o kit §cAnchor §7!");
	      p.setGameMode(GameMode.ADVENTURE);
	      p.getInventory().clear();
	      Array.kit.put(p, "Anchor");
	      Main.Dj.remove(p.getName());
	      Main.stomper.remove(p.getName());
	      
	      Scoreboard.ScoreDoBasic.iscoriboard(p);
	      p.getInventory().addItem(new ItemStack[] { dima });
	      Main.give(p);
	      for (int i = 0; i <= 34; i++) {
	        p.getInventory().addItem(new ItemStack[] { sopa });
	       
	        
	      }
	    }
	    me.rafael.vinagre.KomboPvP.Comandos.SetArena.TeleportArenaRandom(p);
	    return false;
	  }
}