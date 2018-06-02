package me.Pedro.Minigames;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.Pedro.Main;
import me.Pedro.Eventos.API;
import me.Pedro.Eventos.KitAPI;


public class ClickTest
  implements CommandExecutor, Listener
{
  public static ArrayList<Player> sela = new ArrayList<>();
  public static ClickTest m;
  
  public ClickTest(Main main) {
}

public static ClickTest getMain()
  {
    return m;
  }
  
  @EventHandler
  public void bater(PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    if (sela.contains(p)) {
      if (e.getAction() == Action.LEFT_CLICK_AIR)
      {
        p.setLevel(p.getLevel() + 1);
        
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
        {
          @SuppressWarnings("deprecation")
		public void run()
          {
            if (ClickTest.sela.contains(p))
            {
              ClickTest.sela.remove(p);
              p.sendMessage(API.sev + "§7Você fez " + p.getLevel() + " clicks em 10 segundos");
              p.sendMessage(API.sev + "§7Você fez em media " + p.getLevel() / 10 + "  clicks por segundo!");
              
              p.getInventory().clear();
      		API.GiveSpawn(p);
    		p.teleport(p.getWorld().getSpawnLocation());
              
              if (p.getLevel() >= 200)
              {
                p.setBanned(true);
              }
            }
          }
        }, 200L);
        
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
        {
          public void run()
          {
            p.setLevel(0);
            ClickTest.sela.remove(p.getName());
          }
        }, 260L);
      }
    }
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if ((sender instanceof Player)) {
      if (cmd.getName().equalsIgnoreCase("clicktest"))
      {
        final Player p = (Player)sender;
        p.setLevel(0);
        p.setGameMode(GameMode.SURVIVAL);
        
        p.getInventory().clear();
        
        p.sendMessage(API.sev + "§7O ClickTeste irá começar em 5 segundos");
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
        {
          public void run()
          {
            p.sendMessage(API.sev + "§7O ClickTeste irá começar em 4 segundos");
          }
        }, 20L);
        
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
        {
          public void run()
          {
            p.sendMessage(API.sev + "§7O ClickTeste irá começar em 3 segundos");
          }
        }, 40L);
        
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
        {
          public void run()
          {
            p.sendMessage(API.sev + "§7O ClickTeste irá começar em 2 segundos");
          }
        }, 60L);
        
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
        {
          public void run()
          {
            p.sendMessage(API.sev + "§7O ClickTeste irá começar em 1 segundo");
          }
        }, 80L);
        
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
        {
          public void run()
          {
        	  p.sendMessage("  ");
        	  p.sendMessage("  ");
            p.sendMessage(API.sev + "§7O ClickTeste Começou");
            p.sendMessage(API.sev + "§7§7Apenas os Clicks no Ar Serão Contados");
            p.sendMessage("  ");
            p.sendMessage("  ");
            ClickTest.sela.add(p);
          }
        }, 100L);
      }
    }
    return false;
  }
}
