package me.recenthg.stark.Comandos;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

import me.recent.stark.Main;


public class Morrer implements CommandExecutor, Listener {
	
	 public static ArrayList<Player> Spawn1 = new ArrayList<Player>();
	  
	 
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3)
	  {
	    if (!(sender instanceof Player))
	    {
	      sender.sendMessage(" ");
	      return true;
	    }
	    Player p = (Player)sender;
	    if (cmd.getName().equalsIgnoreCase("morrer")) {
	      if (Main.PreGame)
	      {
	        org.bukkit.Bukkit.getServer().getWorld("world");
	        p.getLocation();
	        Location teleportLocation = null;
	          double x = 0.5D;
		      double y = 184.0D;
		      double z = 26.5D;
		      p.spigot().respawn();
	        p.getInventory().setArmorContents(null);
	        p.getInventory().clear();

			ItemStack kits = new ItemStack(Material.CHEST);
			ItemMeta rkits = kits.getItemMeta();
			rkits.setDisplayName("§e§lSeus Kits §7(Clique§7)");
			kits.setItemMeta(rkits);

			ItemStack buycraft = new ItemStack(Material.EMERALD);
			ItemMeta rbuycraft = buycraft.getItemMeta();
			rbuycraft.setDisplayName("§e§lBuyCraft §7(Clique§7)");
			buycraft.setItemMeta(rbuycraft);

			ItemStack buycraft22 = new ItemStack(Material.ENDER_CHEST);
			ItemMeta rbuycraft22 = buycraft22.getItemMeta();
			rbuycraft22.setDisplayName("§e§lCaixas §7(Clique§7)");
			buycraft22.setItemMeta(rbuycraft22);

			
			ItemStack item141 = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
			ItemMeta itemmeta141 = item141.getItemMeta();
			itemmeta141.setDisplayName("§e§lStatus §7(Clique§7)");
			item141.setItemMeta(itemmeta141);

			ItemStack bookItem = new ItemStack(Material.WRITTEN_BOOK, 1);
			BookMeta metaData = (BookMeta) bookItem.getItemMeta();
			metaData.setTitle("§e§lLivro de ajuda! §7(Clique§7)");
			metaData.setAuthor("§czStarkDev");
			metaData.addPage(new String[] { "§6§l       Recent§fHG" });
			metaData.addPage(new String[] { "§f§oComo jogar :\n\n§fO HardCore Games e um\n§fmodo de jogo onde o\n§0ultimo sobrevivente é o\n§0vencedor" });
			metaData.addPage(new String[] { "§f§oSopas :\n\n§fSopas possuem um\nefeito especial dentro\ndo jogo\njogo\nAo clicar nelas voce\nbebe instantaneamente\ne regeneram 3,5\ncoracoes\najudando assim na\nduracao do pvp" });
			bookItem.setItemMeta(metaData);

			p.getInventory().setItem(0, kits);
			p.getInventory().setItem(7, bookItem);
			p.getInventory().setItem(1, item141);
			p.getInventory().setItem(8, buycraft);
			p.getInventory().setItem(4, buycraft22);	
			
	    	
	        boolean isOnLand = false;
	        while (!isOnLand)
	        {
	          teleportLocation = new Location(p.getWorld(), x, y, z);
	          if (teleportLocation.getBlock().getType() != Material.AIR) {
	            isOnLand = true;
	          } else {
	            y -= 1.0D;
	          }
	        }
	        p.teleport(new Location(p.getWorld(), teleportLocation.getX(), teleportLocation.getY() + 1.0D, teleportLocation.getZ()));
	      }
	      else
	      {
	        sender.sendMessage(" ");
	        return true;
	      }
	    }
	    
	    return false;
	  }
	}