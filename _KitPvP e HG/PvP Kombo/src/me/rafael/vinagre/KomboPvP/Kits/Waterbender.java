package me.rafael.vinagre.KomboPvP.Kits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;

public class Waterbender 
implements Listener, CommandExecutor
{
ArrayList<Block> naoescorrer;	
	
	
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
	    
	    if (cmd.equalsIgnoreCase("jellyfish")) {
	      if (Array.used.contains(p.getName())) {
	    	  p.sendMessage("§7» §cVoce ja esta usando um kit!");
	        return true;
	      }
	      if (!p.hasPermission("kitpvp.kit.jellyfish")) {
		      p.sendMessage("§cVoce nao tem permissao para usar este kit !");
	        return true;
	      }
	      Array.used.add(p.getName());
	      p.sendMessage("§7» Voce escolheu o kit §cJellyfish §7!");
	      p.setGameMode(GameMode.ADVENTURE);
	      p.getInventory().clear();
	      Array.kit.put(p, "Jellyfish");
	      Main.Dj.remove(p.getName());
	      Main.stomper.remove(p.getName());
	      Scoreboard.ScoreDoBasic.iscoriboard(p);
	      
	     
	      p.getInventory().addItem(new ItemStack[] { dima });
	      
	      
	      
	      Main.give(p);
	      for (int i = 0; i <= 34; i++) {
	        p.getInventory().addItem(new ItemStack[] { sopa });
	        
	      }
	  }
	    me.rafael.vinagre.KomboPvP.Comandos.SetArena.TeleportArenaRandom(p);
	    return false;
	  }


	  public static String naocolocaragua = String.valueOf("§cVoce nao pode colocar agua aqui");
	  
	  public Waterbender()
	  {
	    this.naoescorrer = new ArrayList();
	  }
	  
	  @EventHandler
	  public void colocaragua(PlayerInteractEvent event)
	  {
	    Player p = event.getPlayer();
	    if ((Array.kit.get(p) == "Jellyfish") && (p.getItemInHand().getType() == Material.AIR) && (event.getAction() == Action.RIGHT_CLICK_BLOCK))
	    {
	      Block b = event.getClickedBlock();
	      BlockFace lado = event.getBlockFace();
	      int x = b.getLocation().getBlockX();
	      int y = b.getLocation().getBlockY();
	      int z = b.getLocation().getBlockZ();
	      if (lado == BlockFace.DOWN)
	      {
	        final Block b2 = b.getWorld().getBlockAt(x, y - 1, z);
	        if (b2.getType() == Material.AIR)
	        {
	          b2.setType(Material.STATIONARY_WATER);
	          this.naoescorrer.add(b2);
	          Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
	          {
	            public void run()
	            {
	              b2.setType(Material.AIR);
	              Waterbender.this.naoescorrer.remove(b2);
	            }
	          }, 60L);
	        }
	        else
	        {
	          p.sendMessage(naocolocaragua);
	        }
	      }
	      else if (lado == BlockFace.UP)
	      {
	        final Block b2 = b.getWorld().getBlockAt(x, y + 1, z);
	        if (b2.getType() == Material.AIR)
	        {
	          b2.setType(Material.STATIONARY_WATER);
	          this.naoescorrer.add(b2);
	          Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
	          {
	            public void run()
	            {
	              b2.setType(Material.AIR);
	              Waterbender.this.naoescorrer.remove(b2);
	            }
	          }, 60L);
	        }
	        else
	        {
	          p.sendMessage(naocolocaragua);
	        }
	      }
	      else if (lado == BlockFace.NORTH)
	      {
	        final Block b2 = b.getWorld().getBlockAt(x, y, z - 1);
	        if (b2.getType() == Material.AIR)
	        {
	          b2.setType(Material.STATIONARY_WATER);
	          this.naoescorrer.add(b2);
	          Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
	          {
	            public void run()
	            {
	              b2.setType(Material.AIR);
	              Waterbender.this.naoescorrer.remove(b2);
	            }
	          }, 60L);
	        }
	        else
	        {
	          p.sendMessage(naocolocaragua);
	        }
	      }
	      else if (lado == BlockFace.SOUTH)
	      {
	        final Block b2 = b.getWorld().getBlockAt(x, y, z + 1);
	        if (b2.getType() == Material.AIR)
	        {
	          b2.setType(Material.STATIONARY_WATER);
	          this.naoescorrer.add(b2);
	          Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
	          {
	            public void run()
	            {
	              b2.setType(Material.AIR);
	              Waterbender.this.naoescorrer.remove(b2);
	            }
	          }, 60L);
	        }
	        else
	        {
	          p.sendMessage(naocolocaragua);
	        }
	      }
	      else if (lado == BlockFace.WEST)
	      {
	        final Block b2 = b.getWorld().getBlockAt(x - 1, y, z);
	        if (b2.getType() == Material.AIR)
	        {
	          b2.setType(Material.STATIONARY_WATER);
	          this.naoescorrer.add(b2);
	          Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
	          {
	            public void run()
	            {
	              b2.setType(Material.AIR);
	              Waterbender.this.naoescorrer.remove(b2);
	            }
	          }, 60L);
	        }
	        else
	        {
	          p.sendMessage(naocolocaragua);
	        }
	      }
	      else if (lado == BlockFace.EAST)
	      {
	        final Block b2 = b.getWorld().getBlockAt(x + 1, y, z);
	        if (b2.getType() == Material.AIR)
	        {
	          b2.setType(Material.STATIONARY_WATER);
	          this.naoescorrer.add(b2);
	          Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
	          {
	            public void run()
	            {
	              b2.setType(Material.AIR);
	              Waterbender.this.naoescorrer.remove(b2);
	            }
	          }, 60L);
	        }
	        else
	        {
	          p.sendMessage(naocolocaragua);
	        }
	      }
	    }
	  }
	  
	  @EventHandler
	  public void naoescorrer(BlockPhysicsEvent event)
	  {
	    Block b = event.getBlock();
	    if ((b.getType() == Material.STATIONARY_WATER) && (this.naoescorrer.contains(b))) {
	      event.setCancelled(true);
	    }
	  }
	  
	  @EventHandler
	  public void veneno(PlayerMoveEvent event)
	  {
	    Player p = event.getPlayer();
	    Block b = p.getLocation().getBlock();
	    if ((b.getType() == Material.STATIONARY_WATER) && (!p.getInventory().contains(Material.CLAY_BALL)) && (this.naoescorrer.contains(b))) {
	      p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 0));
	    }
	  }
	}

