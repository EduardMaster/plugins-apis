package me.rafael.vinagre.KomboPvP.Kits;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;

public class Bust implements CommandExecutor, Listener {


	  public static HashMap<String, Long> cooldown = new HashMap();
	  
	  @EventHandler
	  public void interact(PlayerInteractEvent e)
	  {
	    final Player p = e.getPlayer();
	    if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
	      (p.getItemInHand().getType() == Material.GOLD_HOE) && (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§bBurstMaster!")))
	    {
	      if ((!cooldown.containsKey(p.getName())) || (((Long)cooldown.get(p.getName())).longValue() <= System.currentTimeMillis()))
	      {
	        e.setCancelled(true);
	        p.updateInventory();
	        Vector velo1 = p.getLocation().getDirection().normalize().multiply(2);
	        final Snowball boladenve = (Snowball)p.launchProjectile(Snowball.class);
	        boladenve.setVelocity(velo1);
	        boladenve.setFireTicks(0);
	        
	        Location location = p.getEyeLocation();
	        BlockIterator blocksToAdd = new BlockIterator(location, 0.0D, 30);
	        
	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	        {
	          public void run()
	          {
	            boladenve.remove();
	          }
	        }, 10L);
	        
	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	        {
	          public void run()
	          {
	            p.getWorld().createExplosion(boladenve.getLocation().add(0.0D, 1.0D, 0.0D), 3.1F);
	          }
	        }, 15L);
	        while (blocksToAdd.hasNext())
	        {
	          Location blockToAdd = blocksToAdd.next().getLocation();
	          Effect a = Effect.STEP_SOUND;
	          
	          p.getWorld().playEffect(blockToAdd, a, 46);
	        }
	        cooldown.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(25L)));
	        return;
	      }
	      p.sendMessage("§cAguarde mais:" + TimeUnit.MILLISECONDS.toSeconds(((Long)cooldown.get(p.getName())).longValue() - System.currentTimeMillis()));
	    }
	  }
	  @EventHandler
	  public void onDrop(PlayerDropItemEvent event)
	  {
	    if (event.getItemDrop().getItemStack().getType() == Material.GOLD_HOE)
	      event.setCancelled(true);
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
  ItemStack especial = new ItemStack(Material.GOLD_HOE);
  ItemMeta especial1 = sopa.getItemMeta();
  especial1.setDisplayName("§bBurstMaster!");
  especial.setItemMeta(especial1);
  
  ItemStack capacete0 = new ItemStack(Material.AIR);
  
  ItemStack peitoral0 = new ItemStack(Material.AIR);
  
  ItemStack calca0 = new ItemStack(Material.AIR);
  
  ItemStack Bota0 = new ItemStack(Material.AIR);
  
  p.getInventory().setHelmet(capacete0);
  p.getInventory().setChestplate(peitoral0);
  p.getInventory().setLeggings(calca0);
  p.getInventory().setBoots(Bota0);
  
  if (cmd.equalsIgnoreCase("burstmaster")) {
    if (Array.used.contains(p.getName())) {
  	  p.sendMessage(" §7» §cVoce ja esta usando um kit!");
      return true;
    }
    if (!p.hasPermission("kitpvp.kit.burstmaster")) {
	      p.sendMessage("§cVoce nao tem permissao para usar este kit !");
      return true;
    }
    Array.used.add(p.getName());
    p.sendMessage(" §7» Voce escolheu o kit §cBurstMaster §7!");
    p.setGameMode(GameMode.ADVENTURE);
    p.getInventory().clear();
    Array.kit.put(p, "BurstMaster");
    p.getInventory().addItem(new ItemStack[] { dima });
    Main.give(p);
    Main.Dj.remove(p.getName());
    Main.stomper.remove(p.getName());

    p.getInventory().addItem(new ItemStack[] { especial });
    Scoreboard.ScoreDoBasic.iscoriboard(p);
    for (int i = 0; i <= 34; i++) {
      p.getInventory().addItem(new ItemStack[] { sopa });
     
    }
  }
  me.rafael.vinagre.KomboPvP.Comandos.SetArena.TeleportArenaRandom(p);
  return false;
}
}



