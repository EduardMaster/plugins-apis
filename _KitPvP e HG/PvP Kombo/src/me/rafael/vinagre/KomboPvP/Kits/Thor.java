package me.rafael.vinagre.KomboPvP.Kits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;

public class Thor 
implements Listener, CommandExecutor
{

	public Main plugin;
	  
	  public Thor(me.rafael.vinagre.KomboPvP.Main main)
	  {
	    plugin = main;
	  }
	  
	  public static ArrayList<String> cooldown = new ArrayList();
	
	  @EventHandler
	  public void onPlayerThor(PlayerInteractEvent e)
	  {
	    final Player p = e.getPlayer();
	    if (e.getAction() != Action.RIGHT_CLICK_BLOCK) {
	      return;
	    }
	    if ((p.getItemInHand().getType() == Material.GOLD_AXE) && 
	    		(Array.kit.get(p) == "Thor"))
	    {
	      if (cooldown.contains(p.getName()))
	      {
	        e.setCancelled(true);
	        p.sendMessage("§cSeus poderes so poderao ser usados daqui 5 segundos!");
	        return;
	      }
	      
	      e.setCancelled(true);
	      Block b = e.getClickedBlock();
	      
	      World w = p.getWorld();
	      w.spawnEntity(w.getHighestBlockAt(b.getLocation()).getLocation(), EntityType.LIGHTNING);
	      cooldown.add(p.getName());
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
	      {
	        public void run()
	        {
	          cooldown.remove(p.getName());
	          p.sendMessage("§bVocê já pode usar o poder do thor denovo.");
	        }
	      }, 100L);
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
	    ItemStack especial = new ItemStack(Material.GOLD_AXE);
	    ItemMeta especial1 = especial.getItemMeta();
	    especial1.setDisplayName("§cThor");
	    especial.setItemMeta(especial1);
	    
	    ItemStack capacete0 = new ItemStack(Material.AIR);
	    
	    ItemStack peitoral0 = new ItemStack(Material.AIR);
	    
	    ItemStack calca0 = new ItemStack(Material.AIR);
	    
	    ItemStack Bota0 = new ItemStack(Material.AIR);
	    
	    p.getInventory().setHelmet(capacete0);
	    p.getInventory().setChestplate(peitoral0);
	    p.getInventory().setLeggings(calca0);
	    p.getInventory().setBoots(Bota0);
	    
	    if (cmd.equalsIgnoreCase("thor")) {
	      if (Array.used.contains(p.getName())) {
	    	  p.sendMessage("§7» §cVoce ja esta usando um kit!");
	        return true;
	      }
	      if (!p.hasPermission("kitpvp.kit.thor")) {
		      p.sendMessage("§cVoce nao tem permissao para usar este kit !");
	        return true;
	      }
	      Array.used.add(p.getName());
	      p.sendMessage("§7» Voce escolheu o kit §cThor §7!");
	      p.setGameMode(GameMode.ADVENTURE);
	      p.getInventory().clear();
	      Array.kit.put(p, "Thor");
	      Main.Dj.remove(p.getName());
	      Main.stomper.remove(p.getName());
	      Scoreboard.ScoreDoBasic.iscoriboard(p);
	      
	      p.getInventory().addItem(new ItemStack[] { dima });
	      p.getInventory().addItem(new ItemStack [] { especial });
	      Main.give(p);
	      for (int i = 0; i <= 34; i++) {
	        p.getInventory().addItem(new ItemStack[] { sopa });
	        
	      }
	    }
	    me.rafael.vinagre.KomboPvP.Comandos.SetArena.TeleportArenaRandom(p);
	    return false;
	  }
	}