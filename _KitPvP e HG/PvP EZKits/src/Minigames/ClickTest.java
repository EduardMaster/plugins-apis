package Minigames;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Main.Main;
import Utils.KitAPI;


public class ClickTest
  implements CommandExecutor, Listener
{
  public static ArrayList<Player> sela = new ArrayList<>();
  public static ClickTest m;
  
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
              p.sendMessage("        §6§lEZKits       ");
              p.sendMessage("  ");
              p.sendMessage("§6§lEZKits§b» §cClick-Test terminado!");
              p.sendMessage("§6§lEZKits§b» §aVocê fez " + p.getLevel() + " clicks em 10 segundos");
              p.sendMessage("§6§lEZKits§b» §aVocê fez em media " + p.getLevel() / 10 + "  clicks por segundo!");
              p.sendMessage("  ");
              p.sendMessage("        §6§lEZKits       ");
              
              p.getInventory().clear();
              KitAPI.inicial(p);
              
              if (p.getLevel() >= 200)
              {
                Player[] arrayOfPlayer;
                int j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length;
                for (int i = 0; i < j; i++)
                {
                  Player on = arrayOfPlayer[i];
                  if (on.isOp()) {
                	  on.sendMessage("§6§lEZKits§b»§7 Talvez " + p.getName() + " Esteja Usando Macro");
                	  on.sendMessage("§6§lEZKits§b»§7Ele Fez §c" + p.getLevel() / 10 + "§7 Por Segundo");
                  }
                }
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
        ItemStack vidro1 = new ItemStack(Material.WOOD_SWORD);
        ItemMeta metav1 = vidro1.getItemMeta();
        metav1.setDisplayName("§6ClickTest");
        vidro1.setItemMeta(metav1);
        
        p.getInventory().setItem(4, vidro1);
        
        p.sendMessage("§6§lEZKits§b» §aO ClickTeste irá começar em 5 segundos");
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
        {
          public void run()
          {
            p.sendMessage("§6§lEZKits§b» §aO ClickTeste irá começar em 4 segundos");
          }
        }, 20L);
        
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
        {
          public void run()
          {
            p.sendMessage("§6§lEZKits§b» §aO ClickTeste irá começar em 3 segundos");
          }
        }, 40L);
        
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
        {
          public void run()
          {
            p.sendMessage("§6§lEZKits§b» §aO ClickTeste irá começar em 2 segundos");
          }
        }, 60L);
        
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
        {
          public void run()
          {
            p.sendMessage("§6§lEZKits§b» §aO ClickTeste irá começar em 1 segundo");
          }
        }, 80L);
        
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
        {
          public void run()
          {
        	  p.sendMessage("  ");
        	  p.sendMessage("  ");
            p.sendMessage("§6§lEZKits§b» §aO ClickTeste Começou");
            p.sendMessage("§6§lEZKits§b» §7Apenas os Clicks no Ar Serão Contados");
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
