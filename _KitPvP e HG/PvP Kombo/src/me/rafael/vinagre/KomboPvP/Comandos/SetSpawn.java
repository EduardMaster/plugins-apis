package me.rafael.vinagre.KomboPvP.Comandos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
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
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;
import me.rafael.vinagre.KomboPvP.Listeners.Strings;

public class SetSpawn
implements Listener, CommandExecutor{
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(!(sender instanceof Player)){
			return true;
		}
		final Player p = (Player)sender;
	      if (cmd.getName().equalsIgnoreCase("setspawn")){
	        if (!p.hasPermission("set.spawn")){
	          return true;
	        }
	        Main.getInstance().warps.set("Spawn.World", p.getLocation().getWorld().getName());
	        Main.getInstance().warps.set("Spawn.X", Double.valueOf(p.getLocation().getX()));
	        Main.getInstance().warps.set("Spawn.Y", Double.valueOf(p.getLocation().getY()));
	        Main.getInstance().warps.set("Spawn.Z", Double.valueOf(p.getLocation().getZ()));
	        Main.getInstance().warps.set("Spawn.Pitch", Float.valueOf(p.getLocation().getPitch()));
	        Main.getInstance().warps.set("Spawn.Yaw", Float.valueOf(p.getLocation().getYaw()));
	        Main.getInstance().save();
	        World world = p.getWorld();
	        Location loc = p.getLocation();
	        world.setSpawnLocation(loc.getBlockX(), loc.getBlockY() + 1, loc.getBlockZ());
	        p.sendMessage("§7» §aSpawn setado!");
	        return true;
	      }
	      if (cmd.getName().equalsIgnoreCase("spawn")){
	          p.getInventory().clear();
	          p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
	          p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
	          p.sendMessage("§7» §aTeletransportando em §73 §asegundos ! ");
	          Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	          {
	            @SuppressWarnings("deprecation")
				public void run()
	            {
	              World w = Bukkit.getServer().getWorld(Main.getInstace().warps.getString("Spawn.World"));
	              double x =  Main.getInstance().warps.getDouble("Spawn.X");
	              double y = Main.getInstance().warps.getDouble("Spawn.Y");
	              double z = Main.getInstance().warps.getDouble("Spawn.Z");
	              Location lobby = new Location(w, x, y, z);
	              lobby.setPitch((float)Main.getInstance().warps.getDouble("Warps.Spawn.Pitch"));
	              lobby.setYaw((float)Main.getInstance().warps.getDouble("Warps.Spawn.Yaw"));
	              p.getInventory().clear();
	              p.teleport(lobby);
	              p.setExp(0.0F);
	              p.setExhaustion(20.0F);
	              p.setFireTicks(0);
	              p.setFoodLevel(20000);
	              p.getInventory().setArmorContents(null);
	              Main.TirarEfeitos(p);
	              Array.kit.put(p, "Nenhum");
	              Scoreboard.ScoreDoBasic.iscoriboard(p);		
	              String d = p.getName();
	              ItemStack kits = new ItemStack(Material.CHEST);
	      		ItemMeta kits2 = kits.getItemMeta();
	      		kits2.setDisplayName("§a» Kits «");
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
	      		
	            }
	          }, 60L);	  
	      }
		return true;
	  }
}