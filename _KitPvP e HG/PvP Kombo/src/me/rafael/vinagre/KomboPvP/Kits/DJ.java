package me.rafael.vinagre.KomboPvP.Kits;
import java.util.Random;
import java.util.HashMap;

import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;
import me.rafael.vinagre.KomboPvP.Listeners.Habilidades;

public class DJ
implements Listener, CommandExecutor
{
	
	
	
	  private static final HashMap<Player, String> Armadura = null;
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
	    
	    if (cmd.equalsIgnoreCase("dj")) {
	      if (Array.used.contains(p.getName())) {
	    	  p.sendMessage("§7» §cVoce ja esta usando um kit!");
	        return true;
	      }
	      if (!p.hasPermission("kitpvp.kit.dj")) {
		      p.sendMessage("§cVoce nao tem permissao para usar este kit !");
	        return true;
	      }
	      Array.used.add(p.getName());
	      p.sendMessage("§7» Voce escolheu o kit §cDj §7!");
	      p.setGameMode(GameMode.ADVENTURE);
	      p.getInventory().clear();
	      Array.kit.put(p, "DJ");
	      
	      p.getInventory().addItem(new ItemStack[] { dima });
	      Scoreboard.ScoreDoBasic.iscoriboard(p);
	      Main.Dj.add(sender.getName());
	      Main.stomper.remove(p.getName());
	      
	      
	      Main.give(p);
	      for (int i = 0; i <= 34; i++) {
	        p.getInventory().addItem(new ItemStack[] { sopa });
	        
	      }
	  }
	    me.rafael.vinagre.KomboPvP.Comandos.SetArena.TeleportArenaRandom(p);
	    return false;
	  }
	
	 @EventHandler
	  public void SwordKit(PlayerInteractEvent e)
	  {
	    Player player = e.getPlayer();
	    Player p = e.getPlayer();
	    PlayerInventory inv = player.getInventory();
	    
	    if ((Main.Dj.contains(player.getName())) && (
	      (player.getItemInHand().getType() == Material.WOOD_SWORD) || 
	      (player.getItemInHand().getType() == Material.STONE_SWORD) || 
	      (player.getItemInHand().getType() == Material.GOLD_SWORD) || 
	      (player.getItemInHand().getType() == Material.STONE_SWORD) || 
	      (player.getItemInHand().getType() == Material.DIAMOND_SWORD)))
	    {
	      player.updateInventory();
	      
	      Random dice = new Random();
	      
	      int number = dice.nextInt(10);
	      switch (number)
	      {
	      case 0: 
	        player.getItemInHand().setType(Material.GOLD_SWORD);
	        player.updateInventory();
	        
	        break;
	      case 1: 
	        ItemStack he = null;
	        ItemStack le = null;
	        
	        inv.setArmorContents(new ItemStack[] {
	          new ItemStack(Material.AIR) });
	        
	        player.getItemInHand().setType(Material.WOOD_SWORD);
	        player.updateInventory();
	        
	        break;
	      case 2: 
	        inv.setArmorContents(new ItemStack[] {
	          new ItemStack(Material.AIR) });
	        
	        player.getItemInHand().setType(Material.STONE_SWORD);
	        player.updateInventory();
	        
	        break;
	      case 3: 
	        player.getItemInHand().setType(Material.DIAMOND_SWORD);
	        player.updateInventory();
	        
	        break;
	      case 4: 
	        ItemStack hc = null;
	        ItemStack lc = null;
	        
	        inv.setArmorContents(new ItemStack[] {
	          new ItemStack(Material.AIR) });
	        
	        player.getItemInHand().setType(Material.STONE_SWORD);
	        player.updateInventory();
	      }
	    }
	  }


	}






