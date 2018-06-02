package me.rafael.vinagre.KomboPvP.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;

public class SetWarp 
implements Listener, CommandExecutor
{

	public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args) {
		if(!(sender instanceof Player)){
			return true;
		}
		final Player p = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("setwarp")){
			if(!p.hasPermission("set.warp")){
				return true;
			}
			if(args.length == 0){
				p.sendMessage(" §7» §cUse /setwarp <warp> ");
				return true;
			}
			if(args[0].equalsIgnoreCase("fps")){
				Main.getInstace().warps.set("Warps.fps.World", p.getLocation().getWorld().getName());
				Main.getInstace().warps.set("Warps.fps.X", p.getLocation().getX());
				Main.getInstace().warps.set("Warps.fps.Y", p.getLocation().getY());
				Main.getInstace().warps.set("Warps.fps.Z", p.getLocation().getZ());
				Main.getInstace().warps.set("Warps.fps.Yaw", p.getLocation().getYaw());
				Main.getInstace().warps.set("Warps.fps.Pitch", p.getLocation().getPitch());
				Main.getInstace().save();
				p.sendMessage(" §7» §aFPS setada !");
			}
			if(args[0].equalsIgnoreCase("sobrevivente")){
				Main.getInstace().warps.set("Warps.sobrevivente.World", p.getLocation().getWorld().getName());
				Main.getInstace().warps.set("Warps.sobrevivente.X", p.getLocation().getX());
				Main.getInstace().warps.set("Warps.sobrevivente.Y", p.getLocation().getY());
				Main.getInstace().warps.set("Warps.sobrevivente.Z", p.getLocation().getZ());
				Main.getInstace().warps.set("Warps.sobrevivente.Yaw", p.getLocation().getYaw());
				Main.getInstace().warps.set("Warps.sobrevivente.Pitch", p.getLocation().getPitch());
				Main.getInstace().save();
				p.sendMessage(" §7» §aSobrevivente setada !");
			}
			if(args[0].equalsIgnoreCase("mdr")){
				Main.getInstace().warps.set("Warps.mdr.World", p.getLocation().getWorld().getName());
				Main.getInstace().warps.set("Warps.mdr.X", p.getLocation().getX());
				Main.getInstace().warps.set("Warps.mdr.Y", p.getLocation().getY());
				Main.getInstace().warps.set("Warps.mdr.Z", p.getLocation().getZ());
				Main.getInstace().warps.set("Warps.mdr.Yaw", p.getLocation().getYaw());
				Main.getInstace().warps.set("Warps.mdr.Pitch", p.getLocation().getPitch());
				Main.getInstace().save();
				p.sendMessage(" §7» §aMDR setada !");
			}
			if(args[0].equalsIgnoreCase("rdm")){
				Main.getInstace().warps.set("Warps.rdm.World", p.getLocation().getWorld().getName());
				Main.getInstace().warps.set("Warps.rdm.X", p.getLocation().getX());
				Main.getInstace().warps.set("Warps.rdm.Y", p.getLocation().getY());
				Main.getInstace().warps.set("Warps.rdm.Z", p.getLocation().getZ());
				Main.getInstace().warps.set("Warps.rdm.Yaw", p.getLocation().getYaw());
				Main.getInstace().warps.set("Warps.rdm.Pitch", p.getLocation().getPitch());
				Main.getInstace().save();
				p.sendMessage(" §7» §aRDM setada !");
			}
			if(args[0].equalsIgnoreCase("knock")){
				Main.getInstace().warps.set("Warps.knock.World", p.getLocation().getWorld().getName());
				Main.getInstace().warps.set("Warps.knock.X", p.getLocation().getX());
				Main.getInstace().warps.set("Warps.knock.Y", p.getLocation().getY());
				Main.getInstace().warps.set("Warps.knock.Z", p.getLocation().getZ());
				Main.getInstace().warps.set("Warps.knock.Yaw", p.getLocation().getYaw());
				Main.getInstace().warps.set("Warps.knock.Pitch", p.getLocation().getPitch());
				Main.getInstace().save();
				p.sendMessage(" §7» §aKnock setada !");
			}
			if(args[0].equalsIgnoreCase("main")){
				Main.getInstace().warps.set("Warps.main.World", p.getLocation().getWorld().getName());
				Main.getInstace().warps.set("Warps.main.X", p.getLocation().getX());
				Main.getInstace().warps.set("Warps.main.Y", p.getLocation().getY());
				Main.getInstace().warps.set("Warps.main.Z", p.getLocation().getZ());
				Main.getInstace().warps.set("Warps.main.Yaw", p.getLocation().getYaw());
				Main.getInstace().warps.set("Warps.main.Pitch", p.getLocation().getPitch());
				Main.getInstace().save();
				p.sendMessage(" §7» §aMain setada !");
			}
			if(args[0].equalsIgnoreCase("challenge")){
				Main.getInstace().warps.set("Warps.challenge.World", p.getLocation().getWorld().getName());
				Main.getInstace().warps.set("Warps.challenge.X", p.getLocation().getX());
				Main.getInstace().warps.set("Warps.challenge.Y", p.getLocation().getY());
				Main.getInstace().warps.set("Warps.challenge.Z", p.getLocation().getZ());
				Main.getInstace().warps.set("Warps.challenge.Yaw", p.getLocation().getYaw());
				Main.getInstace().warps.set("Warps.challenge.Pitch", p.getLocation().getPitch());
				Main.getInstace().save();
				p.sendMessage(" §7» §aCHALLENGE setada !");
			}
		}
		if(cmd.getName().equalsIgnoreCase("warp")){
			if(args.length == 0){
				return true;
			}
			if(args[0].equalsIgnoreCase("fps")){
				if(Array.used.contains(p.getName())){
 					p.sendMessage("§7» §cVocê já escolheu um kit !");
 					return true;
 				}
 				if(Array.warp.contains(p.getName())){
 					p.sendMessage(" §7» §cVocê já está em uma warp !");
 					return true;
 				}
	          p.getInventory().clear();
	          p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
	          p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
	          p.sendMessage("§7» Aguarde §c3 §7segundos !");
	          Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	          {
	            public void run()
	            {
	              World w = Bukkit.getServer().getWorld(Main.getInstace().warps.getString("Warps.fps.World"));
	              double x = Main.getInstace().warps.getDouble("Warps.fps.X");
	              double y = Main.getInstace().warps.getDouble("Warps.fps.Y");
	              double z = Main.getInstace().warps.getDouble("Warps.fps.Z");
	              Location lobby = new Location(w, x, y, z);
	              lobby.setPitch((float)Main.plugin.getConfig().getDouble("Warps.fps.Pitch"));
	              lobby.setYaw((float)Main.plugin.getConfig().getDouble("Warps.fps.Yaw"));
	              p.getInventory().clear();
	              p.teleport(lobby);
	              p.setExp(0.0F);
	              p.setExhaustion(20.0F);
	              p.setFireTicks(0);
	              p.setFoodLevel(20000);
	              p.setHealth(20.0D);
	              Main.TirarEfeitos(p);
	              Main.Deshfire.remove(p.getName());
	              Main.Dj.remove(p.getName());
	              Main.stomper.remove(p.getName());
	              Array.warp.add(p.getName());
	              
	      	    ItemStack capacete0 = new ItemStack(Material.IRON_HELMET);
	    	    
	    	    ItemStack peitoral0 = new ItemStack(Material.IRON_CHESTPLATE);
	    	    
	    	    ItemStack calca0 = new ItemStack(Material.IRON_LEGGINGS);
	    	    
	    	    ItemStack Bota0 = new ItemStack(Material.IRON_BOOTS);
	     	      ItemStack dima = new ItemStack(Material.DIAMOND_SWORD);
	   	          dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
	   	          ItemMeta souperaa = dima.getItemMeta();
	              souperaa.setDisplayName("§cEspada");
	              dima.setItemMeta(souperaa);
	              ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
	              ItemMeta sopas = sopa.getItemMeta();
	              sopas.setDisplayName("§bSopa");
	              sopa.setItemMeta(sopas);
	    		    p.getInventory().clear();
	    		    p.getInventory().setArmorContents(null);
	    		    
	    		    p.getInventory().addItem(dima);
	    		    p.getInventory().setHelmet(capacete0);
	    		    p.getInventory().setChestplate(peitoral0);
	    		    p.getInventory().setLeggings(calca0);
	    		    p.getInventory().setBoots(Bota0);
	    		      for (int i = 0; i <= 34; i++) {
	    			        p.getInventory().addItem(new ItemStack[] { sopa });
	    			      }
	    		    p.sendMessage("§7» §aBem vindo a warp §7FPS §a!");
	            }
	          }, 60L);
			}
			if(args[0].equalsIgnoreCase("main")){
				if(Array.used.contains(p.getName())){
 					p.sendMessage("§7» §cVocê já escolheu um kit !");
 					return true;
 				}
 				if(Array.warp.contains(p.getName())){
 					p.sendMessage(" §7» §cVocê já está em uma warp !");
 					return true;
 				}
	          p.getInventory().clear();
	          p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
	          p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
	          p.sendMessage("§7» Aguarde §c3 §7segundos !");
	          Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	          {
	            public void run()
	            {
	              World w = Bukkit.getServer().getWorld(Main.getInstace().warps.getString("Warps.main.World"));
	              double x = Main.getInstace().warps.getDouble("Warps.main.X");
	              double y = Main.getInstace().warps.getDouble("Warps.main.Y");
	              double z = Main.getInstace().warps.getDouble("Warps.main.Z");
	              Location lobby = new Location(w, x, y, z);
	              lobby.setPitch((float)Main.plugin.getConfig().getDouble("Warps.fps.Pitch"));
	              lobby.setYaw((float)Main.plugin.getConfig().getDouble("Warps.fps.Yaw"));
	              p.getInventory().clear();
	              p.teleport(lobby);
	              p.setExp(0.0F);
	              p.setExhaustion(20.0F);
	              p.setFireTicks(0);
	              p.setFoodLevel(20000);
	              p.setHealth(20.0D);
	              Main.TirarEfeitos(p);
	              Main.darEfeito(p, PotionEffectType.SPEED, 9999999, 2);
	              Main.darEfeito(p, PotionEffectType.INCREASE_DAMAGE, 9999999, 1);
	              Main.Deshfire.remove(p.getName());
	              Main.Dj.remove(p.getName());
	              Main.stomper.remove(p.getName());
	              Array.warp.add(p.getName());
	              
	      	    ItemStack capacete0 = new ItemStack(Material.IRON_HELMET);
	    	    
	    	    ItemStack peitoral0 = new ItemStack(Material.IRON_CHESTPLATE);
	    	    
	    	    ItemStack calca0 = new ItemStack(Material.IRON_LEGGINGS);
	    	    
	    	    ItemStack Bota0 = new ItemStack(Material.IRON_BOOTS);
	     	      ItemStack dima = new ItemStack(Material.DIAMOND_SWORD);
	   	          dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
	   	          ItemMeta souperaa = dima.getItemMeta();
	              souperaa.setDisplayName("§cEspada");
	              dima.setItemMeta(souperaa);
	              ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
	              ItemMeta sopas = sopa.getItemMeta();
	              sopas.setDisplayName("§bSopa");
	              sopa.setItemMeta(sopas);
	    		    p.getInventory().clear();
	    		    p.getInventory().setArmorContents(null);
	    		    
	    		    p.getInventory().addItem(dima);
	    		    p.getInventory().setHelmet(capacete0);
	    		    p.getInventory().setChestplate(peitoral0);
	    		    p.getInventory().setLeggings(calca0);
	    		    p.getInventory().setBoots(Bota0);
	    		      for (int i = 0; i <= 34; i++) {
	    			        p.getInventory().addItem(new ItemStack[] { sopa });
	    			      }
	    		    p.sendMessage("§7» §aBem vindo a warp §7Main §a!");
	            }
	          }, 60L);
			}
			if(args[0].equalsIgnoreCase("mdr")){
				if(Array.used.contains(p.getName())){
 					p.sendMessage("§7» §cVocê já escolheu um kit !");
 					return true;
 				}
 				if(Array.warp.contains(p.getName())){
 					p.sendMessage("§7» §cVocê já está em uma warp !");
 					return true;
 				}
	          p.getInventory().clear();
	          p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
	          p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
	          p.sendMessage("§7» Aguarde §c3 §7segundos !");
	          Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	          {
	            public void run()
	            {
	              World w = Bukkit.getServer().getWorld((Main.getInstace().warps.getString(("Warps.mdr.World"))));
	              double x = Main.getInstace().warps.getDouble("Warps.mdr.X");
	              double y = Main.getInstace().warps.getDouble("Warps.mdr.Y");
	              double z = Main.getInstace().warps.getDouble("Warps.mdr.Z");
	              Location lobby = new Location(w, x, y, z);
	              lobby.setPitch((float)Main.plugin.getConfig().getDouble("Warps.mdr.Pitch"));
	              lobby.setYaw((float)Main.plugin.getConfig().getDouble("Warps.mdr.Yaw"));
	              p.getInventory().clear();
	              p.teleport(lobby);
	              p.setExp(0.0F);
	              p.setExhaustion(20.0F);
	              p.setFireTicks(0);
	              p.setFoodLevel(20000);
	              Main.Dj.remove(p.getName());
	              Main.stomper.remove(p.getName());
	              p.setHealth(20.0D);
	              Main.TirarEfeitos(p);
	              Array.warp.add(p.getName());
	              
	    		    p.getInventory().clear();
	    		    p.getInventory().setArmorContents(null);
	    		    p.sendMessage(" §7» §aBem vindo a warp §7MDR §a!");
	            }
	          }, 60L);
			}
			if(args[0].equalsIgnoreCase("knock")){
				if(Array.used.contains(p.getName())){
 					p.sendMessage("§7» §cVocê já escolheu um kit !");
 					return true;
 				}
 				if(Array.warp.contains(p.getName())){
 					p.sendMessage("§7» §cVocê já está em uma warp !");
 					return true;
 				}
	          p.getInventory().clear();
	          p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
	          p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
	          p.sendMessage("§7» Aguarde §c3 §7segundos !");
	          Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	          {
	            public void run()
	            {
	              World w = Bukkit.getServer().getWorld((Main.getInstace().warps.getString(("Warps.knock.World"))));
	              double x = Main.getInstace().warps.getDouble("Warps.knock.X");
	              double y = Main.getInstace().warps.getDouble("Warps.knock.Y");
	              double z = Main.getInstace().warps.getDouble("Warps.knock.Z");
	              Location lobby = new Location(w, x, y, z);
	              lobby.setPitch((float)Main.plugin.getConfig().getDouble("Warps.knock.Pitch"));
	              lobby.setYaw((float)Main.plugin.getConfig().getDouble("Warps.knock.Yaw"));
	              p.getInventory().clear();
	              p.teleport(lobby);
	              p.setExp(0.0F);
	              p.setExhaustion(20.0F);
	              p.setFireTicks(0);
	              p.setFoodLevel(20000);
	              Main.Dj.remove(p.getName());
	              p.setHealth(20.0D);
	              Main.TirarEfeitos(p);
	              Array.warp.add(p.getName());
	              ItemStack kb = new ItemStack(Material.STICK);
		          ItemMeta kb1 = kb.getItemMeta();
		          kb.addUnsafeEnchantment(Enchantment.KNOCKBACK, 4);
		          ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
	              ItemMeta sopas = sopa.getItemMeta();
	              sopas.setDisplayName("§9Sopa");
	              kb1.setDisplayName("§5Meu gravetinho ;-;");
	              sopa.setItemMeta(sopas);
	    		    p.getInventory().clear();
	    		    p.getInventory().setArmorContents(null);
	    		    p.sendMessage(" §7» §aBem vindo a warp §7Knock §a!");
	    		    p.getInventory().addItem(kb);
	    		    for (int i = 0; i <= 34; i++) {
    			        p.getInventory().addItem(new ItemStack[] { sopa });
    			      }
	            }
	          }, 60L);
			}
			
			if(args[0].equalsIgnoreCase("rdm")){
				if(Array.used.contains(p.getName())){
 					p.sendMessage(" §7» §cVocê já escolheu um kit !");
 					return true;
 				}
 				if(Array.warp.contains(p.getName())){
 					p.sendMessage(" §7» §cVocê já está em uma warp !");
 					return true;
 				}
	          p.getInventory().clear();
	          p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
	          p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
	          p.sendMessage(" §7» Aguarde §c3 §7segundos !");
	          Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	          {
	            public void run()
	            {
	              World w = Bukkit.getServer().getWorld(Main.getInstace().warps.getString("Warps.rdm.World"));
	              double x = Main.getInstace().warps.getDouble("Warps.rdm.X");
	              double y = Main.getInstace().warps.getDouble("Warps.rdm.Y");
	              double z = Main.getInstace().warps.getDouble("Warps.rdm.Z");
	              Location lobby = new Location(w, x, y, z);
	              lobby.setPitch((float)Main.plugin.getConfig().getDouble("Warps.rdm.Pitch"));
	              lobby.setYaw((float)Main.plugin.getConfig().getDouble("Warps.rdm.Yaw"));
	              p.getInventory().clear();
	              p.teleport(lobby);
	              p.setExp(0.0F);
	              p.setExhaustion(20.0F);
	              p.setFireTicks(0);
	              p.setFoodLevel(20000);
	              p.setHealth(20.0D);
	              Main.Deshfire.remove(p.getName());
	              Main.Dj.remove(p.getName());
	              Main.stomper.remove(p.getName());
	              Main.TirarEfeitos(p);
	              Array.warp.add(p.getName());
	              
	    		    p.getInventory().clear();
	    		    p.getInventory().setArmorContents(null);
	    		    p.sendMessage(" §7» §aBem vindo a warp §7RDM §a!");
	            }
	          }, 60L);
			}
			if(args[0].equalsIgnoreCase("challenge")){
				if(Array.used.contains(p.getName())){
 					p.sendMessage(" §7» §cVocê já escolheu um kit !");
 					return true;
 				}
 				if(Array.warp.contains(p.getName())){
 					p.sendMessage(" §7» §cVocê já está em uma warp !");
 					return true;
 				}
	          p.getInventory().clear();
	          p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
	          p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
	          p.sendMessage(" §7» Aguarde §c3 §7segundos !");
	          Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	          {
	            public void run()
	            {
	              World w = Bukkit.getServer().getWorld(Main.getInstace().warps.getString("Warps.challenge.World"));
	              double x = Main.getInstace().warps.getDouble("Warps.challenge.X");
	              double y = Main.getInstace().warps.getDouble("Warps.challenge.Y");
	              double z = Main.getInstace().warps.getDouble("Warps.challenge.Z");
	              Location lobby = new Location(w, x, y, z);
	              lobby.setPitch((float)Main.plugin.getConfig().getDouble("Warps.challenge.Pitch"));
	              lobby.setYaw((float)Main.plugin.getConfig().getDouble("Warps.challenge.Yaw"));
	              p.getInventory().clear();
	              p.teleport(lobby);
	              p.setExp(0.0F);
	              p.setExhaustion(20.0F);
	              p.setFireTicks(0);
	              p.setFoodLevel(20000);
	              p.setHealth(20.0D);
	              Main.TirarEfeitos(p);
	              Main.Dj.remove(p.getName());
	              Main.give(p);
	              Main.Deshfire.remove(p.getName());
	              Array.warp.add(p.getName());
	              Main.stomper.remove(p.getName());
	    		  p.getInventory().clear();
	    		  p.getInventory().setArmorContents(null);
		          ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		          ItemMeta sopas = sopa.getItemMeta();
		          sopas.setDisplayName("§bSopa");
		          sopa.setItemMeta(sopas);
	    		  p.sendMessage(" §7» §aBem vindo a warp §7CHALLENGE §a!");
	    		  for (int i = 0; i <= 35; i++) {
	    		   p.getInventory().addItem(new ItemStack[] { sopa });
	    		  }
	            }
	          }, 60L);
			}
		}
		return true;
	}
}