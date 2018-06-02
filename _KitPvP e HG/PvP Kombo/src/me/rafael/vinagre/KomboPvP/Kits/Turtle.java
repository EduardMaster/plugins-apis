package me.rafael.vinagre.KomboPvP.Kits;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;

public class Turtle 
implements Listener, CommandExecutor
{

	@EventHandler
	  public void onEntityDamage(EntityDamageEvent e)
	  {
	    if (!(e.getEntity() instanceof Player)) {
	      return;
	    }
	    Player p = (Player)e.getEntity();
	    if ((Array.kit.get(p) == "Turtle") && 
	      (p.isSneaking()) && (
	      (e.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) || 
	      (e.getCause() == EntityDamageEvent.DamageCause.CONTACT) || 
	      (e.getCause() == EntityDamageEvent.DamageCause.CUSTOM) || 
	      (e.getCause() == EntityDamageEvent.DamageCause.DROWNING) || 
	      (e.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK) || 
	      (e.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) || 
	      (e.getCause() == EntityDamageEvent.DamageCause.FALL) || 
	      (e.getCause() == EntityDamageEvent.DamageCause.FALLING_BLOCK) || 
	      (e.getCause() == EntityDamageEvent.DamageCause.FIRE) || 
	      (e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK) || 
	      (e.getCause() == EntityDamageEvent.DamageCause.LAVA) || 
	      (e.getCause() == EntityDamageEvent.DamageCause.LIGHTNING) || 
	      (e.getCause() == EntityDamageEvent.DamageCause.MAGIC) || 
	      (e.getCause() == EntityDamageEvent.DamageCause.MELTING) || 
	      (e.getCause() == EntityDamageEvent.DamageCause.POISON) || 
	      (e.getCause() == EntityDamageEvent.DamageCause.PROJECTILE) || 
	      (e.getCause() == EntityDamageEvent.DamageCause.STARVATION) || 
	      (e.getCause() == EntityDamageEvent.DamageCause.SUFFOCATION) || 
	      (e.getCause() == EntityDamageEvent.DamageCause.THORNS) || 
	      (e.getCause() == EntityDamageEvent.DamageCause.VOID) || 
	      (e.getCause() == EntityDamageEvent.DamageCause.WITHER)))
	    {
	      e.setDamage(1.0D);
	      return;
	    }
	  }
	  
	  @EventHandler(priority=EventPriority.HIGH)
	  public void onPlayerTurleDamage(EntityDamageByEntityEvent e)
	  {
	    if (!(e.getEntity() instanceof Player)) {
	      return;
	    }
	    if (!(e.getDamager() instanceof Player)) {
	      return;
	    }
	    Player p = (Player)e.getDamager();
	    if (p.isSneaking())
	    {
	      if (Array.kit.get(p) == "Turtle")
	      {
	        e.setCancelled(true);
	        p.sendMessage("§cVoce nao pode bater enquanto estiver segurando o shift");
	        return;
	      }
	      return;
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
	    
	    ItemStack capacete0 = new ItemStack(Material.AIR);
	    
	    ItemStack peitoral0 = new ItemStack(Material.AIR);
	    
	    ItemStack calca0 = new ItemStack(Material.AIR);
	    
	    ItemStack Bota0 = new ItemStack(Material.AIR);
	    
	    p.getInventory().setHelmet(capacete0);
	    p.getInventory().setChestplate(peitoral0);
	    p.getInventory().setLeggings(calca0);
	    p.getInventory().setBoots(Bota0);
	    
	    if (cmd.equalsIgnoreCase("turtle")) {
	      if (Array.used.contains(p.getName())) {
	    	  p.sendMessage("§7» §cVoce ja esta usando um kit!");
	        return true;
	      }
	      if (!p.hasPermission("kitpvp.kit.turtle")) {
		      p.sendMessage("§cVoce nao tem permissao para usar este kit !");
	        return true;
	      }
	      Array.used.add(p.getName());
	      p.sendMessage("§7» Voce escolheu o kit §cTurtle §7!");
	      p.setGameMode(GameMode.ADVENTURE);
	      p.getInventory().clear();
	      Array.kit.put(p, "Turtle");
	     
	      p.getInventory().addItem(new ItemStack[] { dima });
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