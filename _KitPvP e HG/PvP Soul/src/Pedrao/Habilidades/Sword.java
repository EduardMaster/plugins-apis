package Pedrao.Habilidades;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import Pedrao.KitAPI;
import Pedrao.Main;

public class Sword implements Listener {

	public Sword(Main main) {
	}

	  @EventHandler
	  public void SwordKit(PlayerInteractEvent e)
	  {
	    Player player = e.getPlayer();
	    PlayerInventory inv = player.getInventory();
	    if ((KitAPI.SwordKit.contains(player.getName())) && (
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
