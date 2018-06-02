package me.rafael.vinagre.KomboPvP.Kits;

import Scoreboard.ScoreDoBasic;
import Vinagre.Habilidade;
import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Comandos.SetArena;
import me.rafael.vinagre.KomboPvP.Listeners.Array;
import me.rafael.vinagre.KomboPvP.Listeners.Cooldown;

import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.server.v1_7_R4.EntityPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

public class Stomper
  implements Listener, CommandExecutor
{
	  @EventHandler(priority=EventPriority.HIGH)
	  public void onPlayerStomp(EntityDamageEvent e)
	  {
	    if (!(e.getEntity() instanceof Player)) {
	      return;
	    }
	    Player p = (Player)e.getEntity();
	    if (e.getCause() == EntityDamageEvent.DamageCause.FALL)
	    {
	      if (Main.stomper.contains(p.getName()))
	      {
	        for (Entity ent : p.getNearbyEntities(2.0D, 2.0D, 2.0D)) {
	          if ((ent instanceof Player))
	          {
	            Player plr = (Player)ent;
	            if (e.getDamage() <= 4.0D)
	            {
	              e.setCancelled(true);
	              return;
	            }
	            if (plr.isSneaking())
	            {
	              plr.damage(6.0D, p);
	              plr.sendMessage(ChatColor.GRAY + "Voce Foi pisoteado Por: " + ChatColor.AQUA + p.getName());
	            }
	            else
	            {
	              plr.damage(e.getDamage(), p);
	              plr.sendMessage(ChatColor.GRAY + "Voce Foi Pisoteado Por: " + ChatColor.AQUA + p.getName());
	              plr.damage(p.getFallDistance());
	            }
	          }
	        }
	        e.getEntity().getLocation().getWorld().playSound(e.getEntity().getLocation(), Sound.ANVIL_LAND, 1.0F, 1.0F);
	        e.setDamage(4.0D);
	        return;
	      }
	      return;
	    }
	  }
	
  @EventHandler
  public void BotaStomper(PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    if ((e.getPlayer().getItemInHand().getType() == Material.DIAMOND) && (Habilidade.getAbility(p).equalsIgnoreCase("Stomper")) && ((e.getAction() == Action.RIGHT_CLICK_BLOCK) || (e.getAction() == Action.RIGHT_CLICK_AIR)))
    {
      e.setCancelled(true);
      p.updateInventory();
      if (Cooldown.add(p))
      {
        p.sendMessage("§cCooldown");
        return;
      }
      Vector vector = p.getEyeLocation().getDirection();
      vector.multiply(0.0F);
      vector.setY(10.0F);
      p.setVelocity(vector);
      Location loc = p.getLocation();
      p.getWorld().playSound(loc, Sound.FIREWORK_BLAST2, 2.0F, 2.0F);
      Cooldown.add(p, 30);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          p.sendMessage("§2Cooldown acabou");
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
    ItemStack especial = new ItemStack(Material.DIAMOND);
    ItemMeta especial2 = especial.getItemMeta();
    especial2.setDisplayName("§9Boost");
    especial.setItemMeta(especial2);
    
    ItemStack capacete0 = new ItemStack(Material.AIR);
    
    ItemStack peitoral0 = new ItemStack(Material.AIR);
    
    ItemStack calca0 = new ItemStack(Material.AIR);
    
    ItemStack Bota0 = new ItemStack(Material.AIR);
    
    p.getInventory().setHelmet(capacete0);
    p.getInventory().setChestplate(peitoral0);
    p.getInventory().setLeggings(calca0);
    p.getInventory().setBoots(Bota0);
    if (cmd.equalsIgnoreCase("stomper"))
    {
      if (Array.used.contains(p.getName()))
      {
        p.sendMessage("§7>> §cVoce ja esta usando um kit!");
        return true;
      }
      if (!p.hasPermission("kitpvp.kit.stomper"))
      {
        p.sendMessage("§cVoce nao tem permissao para usar este kit !");
        return true;
      }
      Array.used.add(p.getName());
      p.sendMessage("§7>> Voce escolheu o kit §cStomper §7!");
      p.sendMessage("§7>> Nao stompe com a espada se n buga");
      p.setGameMode(GameMode.ADVENTURE);
      p.getInventory().clear();
      Array.kit.put(p, "Stomper");
      Habilidade.setAbility(p, "Stomper");
      p.getInventory().addItem(new ItemStack[] { dima });
      p.getInventory().addItem(new ItemStack[] { especial });
      Main.give(p);
      Main.stomper.add(p.getName());
      Main.Dj.remove(p.getName());
      
      ScoreDoBasic.iscoriboard(p);
      for (int i = 0; i <= 34; i++) {
        p.getInventory().addItem(new ItemStack[] { sopa });
        
      }
      
    }
    me.rafael.vinagre.KomboPvP.Comandos.SetArena.TeleportArenaRandom(p);
    return false;
  }
}
