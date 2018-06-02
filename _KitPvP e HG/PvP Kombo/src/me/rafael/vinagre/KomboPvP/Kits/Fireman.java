package me.rafael.vinagre.KomboPvP.Kits;

import java.util.Random;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;

public class Fireman 
implements Listener, CommandExecutor
{

	  @EventHandler
	  public void damage(EntityDamageEvent e) {
	    if ((e.getEntity() instanceof Player))
	    {
	      Player p = (Player)e.getEntity();
	      if ((Array.kit.get(p) == "FireMan") && (
	        (e.getCause() == EntityDamageEvent.DamageCause.LAVA) || 
	        (e.getCause() == EntityDamageEvent.DamageCause.FIRE) || 
	        (e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK)))
	        e.setCancelled(true);
	    }
	  }
	  
	  @EventHandler
	  public void fire(PlayerMoveEvent e)
	  {
	    Player p = e.getPlayer();
	    if (!e.getFrom().getBlock().getLocation().equals(e.getTo().getBlock().getLocation())) {
	      return;
	    }
	    Block block = p.getLocation().getBlock().getRelative(BlockFace.DOWN);
	    if ((block.getType() == Material.STATIONARY_WATER) && 
	    		(Array.kit.get(p) == "FireMan"))
	    {
	      p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 1));
	    }
	  }
	  

	  @EventHandler
	  public void Fogo(EntityDamageByEntityEvent e)
	  {
	    if ((e.getDamager() instanceof Player))
	    {
	      Player p = (Player)e.getDamager();
	      if ((Array.kit.get(p) == "FireMan") && 
	        (p.getInventory().getItemInHand() != null) && 
	        (p.getInventory().getItemInHand().getType() == Material.STONE_SWORD) && 
	        ((e.getEntity() instanceof Player)))
	      {
	        Player en = (Player)e.getEntity();
	        Random r = new Random();
	        int chance = r.nextInt(100);
	        if(chance <= 15){
	        en.setFireTicks(100);
	        }
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
	    
	    ItemStack capacete0 = new ItemStack(Material.AIR);
	    
	    ItemStack peitoral0 = new ItemStack(Material.AIR);
	    
	    ItemStack calca0 = new ItemStack(Material.AIR);
	    
	    ItemStack Bota0 = new ItemStack(Material.AIR);
	    
	    p.getInventory().setHelmet(capacete0);
	    p.getInventory().setChestplate(peitoral0);
	    p.getInventory().setLeggings(calca0);
	    p.getInventory().setBoots(Bota0);
	    
	    if (cmd.equalsIgnoreCase("fireman")) {
	      if (Array.used.contains(p.getName())) {
	    	  p.sendMessage("§7» §cVoce ja esta usando um kit!");
	        return true;
	      }
	      if (!p.hasPermission("kitpvp.kit.fireman")) {
		      p.sendMessage("§cVoce nao tem permissao para usar este kit !");
	        return true;
	      }
	      Array.used.add(p.getName());
	      p.sendMessage("§7» Voce escolheu o kit §cFireMan §7!");
	      p.setGameMode(GameMode.ADVENTURE);
	      p.getInventory().clear();
	      Array.kit.put(p, "FireMan");
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