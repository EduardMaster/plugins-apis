package me.rafael.vinagre.KomboPvP.Kits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;

public class Velotrol 
implements Listener, CommandExecutor
{
	public Main plugin;
	public Velotrol(Main instance){
		plugin = instance;
	}
	  
	  public static ArrayList<String> Tempo = new ArrayList();
	  public int boost = Integer.valueOf(6).intValue();  
	
	  @EventHandler
	  public void VelotrolClick(PlayerInteractEvent e)
	  {
	    final Player p = e.getPlayer();
	    if (((e.getPlayer().getItemInHand().getType() == Material.MINECART) && (Array.kit.get(p) == "Velotrol")))
	    {
	      if ((e.getAction() == Action.LEFT_CLICK_AIR) || 
	        (e.getAction() == Action.LEFT_CLICK_BLOCK) || 
	        (e.getAction() == Action.RIGHT_CLICK_BLOCK) || 
	        (e.getAction() == Action.RIGHT_CLICK_AIR)) {
	        e.setCancelled(true);
	      }
	      if (Tempo.contains(p.getName()))
	      {
	        p.sendMessage("§cAguarde o cooldown acabar.");
	        return;
	      }
	    	
	      p.setVelocity(p.getEyeLocation().getDirection().multiply(this.boost).add(new Vector(0, 0, 0)));
	      p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 10, 0);
	      Location loc = p.getLocation();
	      Array.Velotrol2.add(p.getName());
	      Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
	      {
	        public void run()
	        {
	        	p.playEffect(p.getLocation(), Effect.SMOKE, 10);
	        }
	      }, 15L);
	      Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
	      {
	        public void run()
	        {
	        	p.playEffect(p.getLocation(), Effect.SMOKE, 10);
	        }
	      }, 14L);
	      Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
	      {
	        public void run()
	        {
	        	p.playEffect(p.getLocation(), Effect.SMOKE, 10);
	        }
	      }, 13L);
	      Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
	      {
	        public void run()
	        {
	        	p.playEffect(p.getLocation(), Effect.SMOKE, 10);
	        }
	      }, 12L);
	      Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
	      {
	        public void run()
	        {
	        	p.playEffect(p.getLocation(), Effect.SMOKE, 10);
	        }
	      }, 11L);
	      Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
	      {
	        public void run()
	        {
	          p.playEffect(p.getLocation(), Effect.SMOKE, 10);
	        }
	      }, 10L);
	      Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
	      {
	        public void run()
	        {
	        	p.playEffect(p.getLocation(), Effect.SMOKE, 10);
	        }
	      }, 9L);
	      Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
	      {
	        public void run()
	        {
	          p.getWorld().createExplosion(p.getLocation(), 3.0F);
	        }
	      }, 30L);
	      Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
	      {
	        public void run()
	        {
	        	Array.Velotrol2.remove(p.getName());
	        }
	      }, 50L);
	      p.playSound(loc, Sound.ENDERMAN_TELEPORT, 5.0F, -5.0F);
	      Tempo.add(p.getName());
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
	      {
	        public void run()
	        {
	          Tempo.remove(p.getName());
	          p.sendMessage("§bVoce ja pode usar o Velotrol.");
	          p.playSound(p.getLocation(), Sound.BURP, 5.0F, 5.0F);
	        }
	      }, 1100L);
	    }
	  }
	  
	  @EventHandler
	  public void dano(EntityDamageEvent e)
	  {
	    if ((e.getEntity() instanceof Player))
	    {
	      Player p = (Player)e.getEntity();
	      if (e.getCause() != EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {
	        return;
	      }
	      if (Array.kit.get(p) == "Velotrol") {
	        e.setCancelled(true);
	      }else{
	        e.setDamage(e.getDamage() * 2.0D);
	      }
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
		    ItemStack especial = new ItemStack(Material.MINECART);
		    ItemMeta especial1 = especial.getItemMeta();
		    especial1.setDisplayName("§cVelotrol");
		    especial.setItemMeta(especial1);
	  
		    ItemStack capacete0 = new ItemStack(Material.AIR);
		    
		    ItemStack peitoral0 = new ItemStack(Material.AIR);
		    
		    ItemStack calca0 = new ItemStack(Material.AIR);
		    
		    ItemStack Bota0 = new ItemStack(Material.AIR);
	  
			p.getInventory().setHelmet(capacete0);
			p.getInventory().setChestplate(peitoral0);
			p.getInventory().setLeggings(calca0);
			p.getInventory().setBoots(Bota0);
		    
		    if (cmd.equalsIgnoreCase("velotrol")) {
		      if (Array.used.contains(p.getName())) {
		    	  p.sendMessage("§7» §cVoce ja esta usando um kit!");
		        return true;
		      }
		      if (!p.hasPermission("kitpvp.kit.velotrol")) {
			      p.sendMessage("§cVoce nao tem permissao para usar este kit !");
		        return true;
		      }
		      Array.used.add(p.getName());
		      p.sendMessage("§7» Voce escolheu o kit §cVelotrol §7!");
		      p.setGameMode(GameMode.ADVENTURE);
		      p.getInventory().clear();
		      Array.kit.put(p, "Velotrol");
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