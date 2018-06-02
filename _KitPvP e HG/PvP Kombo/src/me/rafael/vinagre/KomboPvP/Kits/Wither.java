package me.rafael.vinagre.KomboPvP.Kits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;

public class Wither 
implements Listener, CommandExecutor
{
	public Main plugin;
	private Object e;
	public Wither(Main instance){
		plugin = instance;
	}
	public static ArrayList<String> Tempo = new ArrayList();
	
	
	@EventHandler
	
	  
	  public void clicar(PlayerInteractEvent e)
	  {
	    ItemStack especial = new ItemStack(Material.SKULL_ITEM);
	    ItemMeta especial1 = especial.getItemMeta();
	    especial1.setDisplayName("§8Wither Item");
	    especial.setItemMeta(especial1);
	    final Player p = e.getPlayer();
	    if ((e.getPlayer().getItemInHand().isSimilar(especial)) && (Array.kit.get(p) == "Wither")){
	    	if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) || 
	    	        (e.getAction() == Action.RIGHT_CLICK_AIR)) {
	    	        e.setCancelled(true);
	    	      }
	    	      if (Tempo.contains(p.getName()))
	    	      {
	    	        p.sendMessage("§cAguarde para usar novamente.");
	    	        return;
	    	      }
	    	      Location loc = p.getLocation();
	    	      loc.setY(loc.getY() + 2.5D);
	    	      Entity witherhead = Bukkit.getServer().getWorld(p.getLocation().getWorld().getName()).spawnEntity(loc, EntityType.WITHER_SKULL);
	    	      Entity witherhead2 = Bukkit.getServer().getWorld(p.getLocation().getWorld().getName()).spawnEntity(loc, EntityType.WITHER_SKULL);
	    	      Entity witherhead3 = Bukkit.getServer().getWorld(p.getLocation().getWorld().getName()).spawnEntity(loc, EntityType.WITHER_SKULL);
	    	      Entity witherhead4 = Bukkit.getServer().getWorld(p.getLocation().getWorld().getName()).spawnEntity(loc, EntityType.WITHER_SKULL);
	    	      witherhead.setVelocity(p.getEyeLocation().getDirection().multiply(2.0D));
	    	      witherhead2.setVelocity(p.getEyeLocation().getDirection().multiply(2.0D));
	    	      witherhead3.setVelocity(p.getEyeLocation().getDirection().multiply(2.0D));
	    	      witherhead4.setVelocity(p.getEyeLocation().getDirection().multiply(2.0D));
	    	      Tempo.add(p.getName());
	    	      
				
	    	      Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
	    	    	  
	    	    	  
	    	      
					@Override
					public void run() {
						if(Tempo.contains(p.getName())){
							Tempo.remove(p.getName());
							p.sendMessage("§bVoce ja pode usar o Wither !");
						}
					}
				}, 10 * 20L);
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
	    ItemStack especial = new ItemStack(Material.SKULL_ITEM);
	    ItemMeta especial1 = especial.getItemMeta();
	    especial1.setDisplayName("§8Wither Item");
	    especial.setItemMeta(especial1);
	    
	    ItemStack capacete0 = new ItemStack(Material.AIR);
	    
	    ItemStack peitoral0 = new ItemStack(Material.AIR);
	    
	    ItemStack calca0 = new ItemStack(Material.AIR);
	    
	    ItemStack Bota0 = new ItemStack(Material.AIR);
	    
	    p.getInventory().setHelmet(capacete0);
	    p.getInventory().setChestplate(peitoral0);
	    p.getInventory().setLeggings(calca0);
	    p.getInventory().setBoots(Bota0);
		    
		  if(cmd.equalsIgnoreCase("wither")){
		      if (Array.used.contains(p.getName())) {
		    	  p.sendMessage("§7» §cVoce ja esta usando um kit!");
		          return true;
		        }
			  
		      if (!p.hasPermission("kitpvp.kit.wither")) {
			      p.sendMessage("§cVoce nao tem permissao para usar este kit !");
		        return true;
		      }
		      Array.used.add(p.getName());
		      p.sendMessage("§7» Voce escolheu o kit §cWither §7!");
		      p.setGameMode(GameMode.ADVENTURE);
		      p.getInventory().clear();
		      Array.kit.put(p, "Wither");
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
		return true;
	  }
	}