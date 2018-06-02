package me.rafael.vinagre.KomboPvP.Comandos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

import XP.XpM;
import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;




public class Join

implements CommandExecutor, Listener

{
	 HashMap<String, Location> maps = new HashMap();	 
	 ArrayList<String> game = new ArrayList();
	 List<String> commands = Arrays.asList(new String[] { "admin", "list", "create", "delete", "setspawn", "join", "leave", "reset", "coins", "setchallenge", "kit", "kitunlocker", "resetkit", "stats", "reload", "info" });
	 
	  ItemStack KitSelector = setName(new ItemStack(Material.CHEST), ChatColor.GRAY + "Kits (" + ChatColor.GREEN + "Click com o direito!" + ChatColor.GRAY + ")");
	  ItemStack ShopOpener = setName(new ItemStack(Material.EMERALD), ChatColor.GRAY + "	Loja (" + ChatColor.GREEN + "Click com o direito!" + ChatColor.GRAY + ")");
	  ItemStack Challenger = setName(new ItemStack(Material.PAPER),ChatColor.GRAY + "Warps (" + ChatColor.GREEN + "Click com o direito!");
	  ItemStack Challenger1 = setName(new ItemStack(Material.GHAST_TEAR),ChatColor.GRAY + "Coins Diario (" + ChatColor.GREEN + "Click com o direito!");
	  ItemStack Challenger2 = setName(new ItemStack(Material.IRON_INGOT),ChatColor.GRAY + "Extra (" + ChatColor.GREEN + "Click com o direito!");
	  ItemStack Challenger3 = setName(new ItemStack(Material.CLAY_BRICK),ChatColor.GRAY + "Informaçoes (" + ChatColor.GREEN + "Click com o direito!");
 
	 public boolean onCommand(final CommandSender sender, Command cmd, String commandLabel, final String[] args)
	  {
	    if ((commandLabel.equalsIgnoreCase("kitpvp")))
	    {
	      if (args.length == 0)
	      {
	        sender.sendMessage(ChatColor.DARK_AQUA + " ----------" + ChatColor.AQUA + " KitBattle " + ChatColor.DARK_AQUA + ChatColor.STRIKETHROUGH + "----------");
	        sender.sendMessage(ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/kitpvp" + ChatColor.DARK_AQUA + " - " + ChatColor.GRAY + "Main command");
	        sender.sendMessage(ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/kb " + ChatColor.GREEN + "List" + ChatColor.DARK_AQUA + " - " + ChatColor.GRAY + "Shows a list of maps");
	        sender.sendMessage(ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/kb " + ChatColor.GREEN + "Stats" + ChatColor.DARK_AQUA + " - " + ChatColor.GRAY + "View your stats");
	        
	        {
	          sender.sendMessage(ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/kb " + ChatColor.GREEN + "Join" + ChatColor.DARK_AQUA + " - " + ChatColor.GRAY + "Join the selected map");
	          sender.sendMessage(ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/kb " + ChatColor.GREEN + "Leave" + ChatColor.DARK_AQUA + " - " + ChatColor.GRAY + "Leave your current map");
	        }
	        sender.sendMessage(ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/kb " + ChatColor.GREEN + "Resetkit" + ChatColor.DARK_AQUA + " - " + ChatColor.GRAY + "Reset your current kit!");
	        sender.sendMessage(ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/kb " + ChatColor.GREEN + "Info" + ChatColor.DARK_AQUA + " - " + ChatColor.GRAY + "Shows some information");
	        sender.sendMessage(ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/kb " + ChatColor.RED + "Admin" + ChatColor.DARK_AQUA + " - " + ChatColor.GRAY + "Shows the admin commands");
	        sender.sendMessage(ChatColor.DARK_AQUA + " --------------------------");
	        return true;
	      }
	      if (!this.commands.contains(args[0].toLowerCase()))
	      {
	        sender.sendMessage(ChatColor.DARK_AQUA + "Comando desconhecido");
	        return true;
	      }
	      if (args[0].equalsIgnoreCase("join"))
	      {
	        if ((sender instanceof Player))
	        {
	          Player p = (Player)sender;
	        
	          {
	          
	          if (args.length == 1)
	          {
	            p.sendMessage("§eVoce entrou no kitpvp");
	            p.sendMessage("§6Caso queira ir na 1v1");
	            p.sendMessage("§aDe /1v1");
	            XpM.removeMoney(p, 1);
	            Scoreboard.ScoreDoBasic.iscoriboard(p);
	            me.rafael.vinagre.KomboPvP.Main.game.add(p.getName());
	            World w = Bukkit.getServer().getWorld(Main.getInstace().warps.getString("Spawn.World"));
	            double x =  Main.getInstance().warps.getDouble("Spawn.X");
	              double y = Main.getInstance().warps.getDouble("Spawn.Y");
	              double z = Main.getInstance().warps.getDouble("Spawn.Z");
	              Location lobby = new Location(w, x, y, z);
	              lobby.setPitch((float)Main.getInstance().warps.getDouble("Warps.Spawn.Pitch"));
	              lobby.setYaw((float)Main.getInstance().warps.getDouble("Warps.Spawn.Yaw"));
	              p.getInventory().clear();
	              p.teleport(lobby);
		        p.teleport(lobby);
		        
		        p.getInventory().clear();
	              
	              p.setExp(0.0F);
	              p.setExhaustion(20.0F);
	              p.setFireTicks(0);
	              p.setFoodLevel(20000);
	              p.getInventory().setArmorContents(null);
	              Main.TirarEfeitos(p);
	              Array.kit.put(p, "Nenhum");
	             		
	              String d = p.getName();
	              ItemStack kits = new ItemStack(Material.CHEST);
	      		ItemMeta kits2 = kits.getItemMeta();
	      		kits2.setDisplayName("§6» Kits «");
	      		kits.setItemMeta(kits2);
	      		
	      		
	      		
	      		ItemStack warps = new ItemStack(Material.PAPER);
	      		ItemMeta warps2 = warps.getItemMeta();
	      		warps2.setDisplayName("§7» Warps «");
	      		warps.setItemMeta(warps2);
	      		
	      		ItemStack d1 = new ItemStack(Material.GHAST_TEAR);
	      		ItemMeta d2 = d1.getItemMeta();
	      		d2.setDisplayName("§1» CoinsDiario «");
	      		d1.setItemMeta(d2);
	      		
	      		ItemStack i1 = new ItemStack(Material.CLAY_BRICK);
	      		ItemMeta i2 = i1.getItemMeta();
	      		i2.setDisplayName("§c» Informaçoes «");
	      		i1.setItemMeta(i2);
	      		
	      		ItemStack a1 = new ItemStack(Material.IRON_INGOT);
	      		ItemMeta a2 = a1.getItemMeta();
	      		a2.setDisplayName("§6» Extra «");
	      		a1.setItemMeta(a2);
	      		
	      		ItemStack c1 = new ItemStack(Material.NAME_TAG);
	      		ItemMeta c2 = c1.getItemMeta();
	      		c2.setDisplayName("§2» Click-Test «");
	      		c1.setItemMeta(c2);
	      		
	      		ItemStack loja = new ItemStack(Material.EMERALD);
	      		ItemMeta loja2 = loja.getItemMeta();
	      		loja2.setDisplayName("§a» Loja «");
	      		loja.setItemMeta(loja2);
	      		
	      		ItemStack kb = new ItemStack(Material.NETHER_STAR);
	      		ItemMeta kb2 = kb.getItemMeta();
	      		kb2.setDisplayName("§9Voxel§lPvP");
	      		kb.setItemMeta(kb2);
	      		
	      		
	      		
	      		p.getInventory().clear();
	      		p.getInventory().setArmorContents(null);
	      		p.teleport(p.getWorld().getSpawnLocation());
	      		p.setGameMode(GameMode.ADVENTURE);
	      		
	      		
	      		p.getInventory().setItem(4, kits);
	    		p.getInventory().setItem(3, warps);
	    		p.getInventory().setItem(1, i1);
	    		p.getInventory().setItem(5, loja);
	    		p.getInventory().setItem(2, a1);
	    		p.getInventory().setItem(6, c1);
	    		p.getInventory().setItem(7, d1);
	      		
	      		 if (args[0].equalsIgnoreCase("leave"))
	   	      {
	      			 if ((sender instanceof Player))
	     	        {
	     	          Player p1 = (Player)sender;
	     	        
	     	          {
	   	        
	   	          {
	   	          
	   	          if (args.length == 1)
	   	          {
	   	        	p1.getInventory().clear();
	   	        	p1.sendMessage("§cVoce saiu do kitpvp");
	   	        Main.game.remove(p1.getName());
	   	        p1.chat("lobby");
	               
	   	          {    
	   	          }
	   	          }
	   	        }
	   	      }
	   	  }
	            return true;
	          }
	          
	          
	            
	          }
	        }
		return false;
	      } {
		
	    } {
	    }
		return false;
	    }
		
	  
	    }
		return false;
	  }
	    
	

	 
	 
public void clearData(Player p)
{
  p.getInventory().clear();
  p.getInventory().setArmorContents(null);
  p.setHealth(20.0D);
  p.setFoodLevel(20);
  p.setLevel(0);
  p.setExp(0.0F);
  for (PotionEffect effect : p.getActivePotionEffects()) {
    p.removePotionEffect(effect.getType());
  }
  p.setGameMode(GameMode.SURVIVAL);
  p.setAllowFlight(false);
  p.setFlying(false);
  p.setFireTicks(0);
}
 ItemStack setName(ItemStack stack, String name)
{
  ItemMeta meta = stack.getItemMeta();
  meta.setDisplayName(name);
  stack.setItemMeta(meta);
  return stack;
}

}
 
