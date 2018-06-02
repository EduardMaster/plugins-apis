package neero.demon.utils;

import java.util.ArrayList;

import neero.demon.Main;
import neero.demon.eventos.JoinManager;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
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

public class Clicktest
  implements CommandExecutor, Listener
{
  public static ArrayList<Player> sela = new ArrayList();
  public static Clicktest m;
  
  
  public static Clicktest getMain()
  {
    return m;
  }
  
  @EventHandler
  public void bater(PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    if ((sela.contains(p)) && 
      (e.getAction() == Action.LEFT_CLICK_AIR))
    {
      p.setLevel(p.getLevel() + 1);
      
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          if (Clicktest.sela.contains(p))
          {
            Clicktest.sela.remove(p);
            p.sendMessage("§7Você fez " + p.getLevel() + " clicks em 10 segundos");
            p.sendMessage("§7Você fez em media " + p.getLevel() / 10 + "  clicks por segundo!");
            
            JoinManager.semkit(p);
            p.teleport(p.getWorld().getSpawnLocation());
            if (p.getLevel() >= 300) {
              p.setBanned(true);
            }
          }
        }
      }
      , 200L);
      
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          p.setLevel(0);
          Clicktest.sela.remove(p.getName());
        }
      }, 260L);
    }
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (((sender instanceof Player)) && 
      (cmd.getName().equalsIgnoreCase("clicktest")))
    {
      final Player p = (Player)sender;
      p.setLevel(0);
      p.setGameMode(GameMode.SURVIVAL);
      
      p.getInventory().clear();
      
      p.sendMessage("§7O ClickTeste ira começar em 5 segundos");
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          p.sendMessage("§7O ClickTeste ira começar em 4 segundos");
        }
      }, 20L);
      
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          p.sendMessage("§7O ClickTeste ira começar em 3 segundos");
        }
      }, 40L);
      
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          p.sendMessage("§7O ClickTeste ira começar em 2 segundos");
        }
      }, 60L);
      
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          p.sendMessage("§7O ClickTeste ira começar em 1 segundo");
        }
      }, 80L);
      
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          p.sendMessage("  ");
          p.sendMessage("  ");
          p.sendMessage("§7O ClickTeste Começou");
          p.sendMessage("§7§7Apenas os Clicks no Ar Serão Contados");
          p.sendMessage("  ");
          p.sendMessage("  ");
          Clicktest.sela.add(p);
        }
      }, 100L);
    }
    return false;
  }
}
