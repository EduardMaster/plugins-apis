package me.rafael.vinagre.KomboPvP.Kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;

public class Golen 
implements Listener, CommandExecutor
{
	public Main plugin;
	public Golen(Main instance){
		plugin = instance;
	}
	
	public static ArrayList<Player> cooldown = new ArrayList<>();
	public static ArrayList<Player> noGolen = new ArrayList<>();
	
	public static void GolenOP(Player p){
		Location local = p.getLocation();
		List<Entity> Inimigos = local.getWorld().getEntities();
		for(Entity e : Inimigos ){
			if((e.getLocation().distance(local) < 6.0D ) && ((e instanceof Player))){
					
				Player d = (Player)e;
				if(d != p){
			        d.setVelocity(new Vector(0, 2, 0).setY(2)); 
					d.sendMessage("§cVoce foi jogado pra cima por um Golen !");
				}
			}
		}
	}
	
	@EventHandler
	public void Interact(PlayerInteractEvent e){
		final Player p = e.getPlayer();
		
		if(((Array.kit.get(p) == "Golen") && (e.getAction() == Action.RIGHT_CLICK_AIR) && (p.getItemInHand().getType() == Material.RED_ROSE))){
			if(cooldown.contains(p)){
				p.sendMessage("§cEspere o cooldown acabar.");
				return;
			}
			
			cooldown.add(p);
			noGolen.add(p);
			p.sendMessage("§cGolen Ativado.");
			
			Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
				public void run() {				
					if(noGolen.contains(p)){
						GolenOP(p);
					}
				}
			}, 1L, 1L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				
				public void run() {
					noGolen.remove(p);
				}
			}, 1L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				
				public void run() {
					cooldown.remove(p);
					p.sendMessage("§bVocê ja pode usar o Golen.");
					p.getWorld().playSound(p.getLocation(), Sound.BURP, 5.0F, 5.0F);
				}
			}, 600L);
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
	    ItemStack especial = new ItemStack(Material.RED_ROSE);
	    ItemMeta especial2 = especial.getItemMeta();
	    especial2.setDisplayName("§cGolen");
	    especial.setItemMeta(especial2);
	    
	    ItemStack capacete0 = new ItemStack(Material.AIR);
	    
	    ItemStack peitoral0 = new ItemStack(Material.AIR);
	    
	    ItemStack calca0 = new ItemStack(Material.AIR);
	    
	    ItemStack Bota0 = new ItemStack(Material.AIR);
	    
	    p.getInventory().setHelmet(capacete0);
	    p.getInventory().setChestplate(peitoral0);
	    p.getInventory().setLeggings(calca0);
	    p.getInventory().setBoots(Bota0);
	    
	    if (cmd.equalsIgnoreCase("golen")) {
	      if (Array.used.contains(p.getName())) {
	    	  p.sendMessage("§7» §cVoce ja esta usando um kit!");
	        return true;
	      }
	      if (!p.hasPermission("kitpvp.kit.golen")) {
		      p.sendMessage("§cVoce nao tem permissao para usar este kit !");
	        return true;
	      }
	      Array.used.add(p.getName());
	      p.sendMessage("§7» Voce escolheu o kit §cGolen §7!");
	      p.setGameMode(GameMode.ADVENTURE);
	      p.getInventory().clear();
	      Array.kit.put(p, "Golen");
	      p.getInventory().addItem(new ItemStack[] { dima });
	      Main.give(p);
	      Main.Dj.remove(p.getName());
	      Main.stomper.remove(p.getName());
	   
	      Scoreboard.ScoreDoBasic.iscoriboard(p);
	      p.getInventory().addItem(especial);
	      for (int i = 0; i <= 34; i++) {
	        p.getInventory().addItem(new ItemStack[] { sopa });
	        
	      }
	    }
	    me.rafael.vinagre.KomboPvP.Comandos.SetArena.TeleportArenaRandom(p);
	    return false;
	  }
}

