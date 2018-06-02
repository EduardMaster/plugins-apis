package me.rafael.vinagre.KomboPvP.Kits;



	import java.util.HashMap;
	import java.util.Random;

import org.bukkit.Color;
	import org.bukkit.GameMode;
	import org.bukkit.Material;
	import org.bukkit.command.Command;
	import org.bukkit.command.CommandExecutor;
	import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
	import org.bukkit.entity.Player;
	import org.bukkit.event.EventHandler;
	import org.bukkit.event.Listener;
	import org.bukkit.event.entity.EntityDamageByEntityEvent;
	import org.bukkit.inventory.ItemStack;
	import org.bukkit.inventory.meta.ItemMeta;
	import org.bukkit.inventory.meta.LeatherArmorMeta;
	import org.bukkit.potion.PotionEffect;
	import org.bukkit.potion.PotionEffectType;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;

	public class Grandpa 
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
		    ItemStack especial = new ItemStack(Material.STICK,1,(short)1);
		    ItemMeta especial1 = especial.getItemMeta();
		    especial1.setDisplayName("§cSai fora!");
		    especial.setItemMeta(especial1);
		    especial.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
	          
	          
	          
		    ItemStack capacete0 = new ItemStack(Material.AIR);
		    
		    ItemStack peitoral0 = new ItemStack(Material.AIR);
		    
		    ItemStack calca0 = new ItemStack(Material.AIR);
		    
		    ItemStack Bota0 = new ItemStack(Material.AIR);
		    
		    p.getInventory().setHelmet(capacete0);
		    p.getInventory().setChestplate(peitoral0);
		    p.getInventory().setLeggings(calca0);
		    p.getInventory().setBoots(Bota0);
		    
		    if (cmd.equalsIgnoreCase("Grandpa")) {
		      if (Array.used.contains(p.getName())) {
		    	  p.sendMessage("§7» §cVoce ja esta usando um kit!");
		        return true;
		      }
		      if (!p.hasPermission("kitpvp.kit.Grandpa")) {
			      p.sendMessage("§cVoce nao tem permissao para usar este kit !");
		        return true;
		      }
		      Array.used.add(p.getName());
		      p.sendMessage("§7» Voce escolheu o kit §cGrandpa =) §7!");
		      p.setGameMode(GameMode.ADVENTURE);
		      p.getInventory().clear();
		      Array.kit.put(p, "Grandpa");
		      p.getInventory().addItem(new ItemStack[] { dima });
		      
		      
		      p.getInventory().addItem(new ItemStack[] { especial });
		      Main.give(p);
		      Main.Dj.remove(p.getName());
		      Main.stomper.remove(p.getName());
		      
		      Scoreboard.ScoreDoBasic.iscoriboard(p);
		      for (int i = 0; i <= 34; i++) {
		        p.getInventory().addItem(new ItemStack[] { sopa });
		        
		      }
		  }
		    me.rafael.vinagre.KomboPvP.Comandos.SetArena.TeleportArenaRandom(p);
		    return false;
		  }
		}
