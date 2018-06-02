package nobody.eventos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import nobody.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class ClickTest
  implements Listener, CommandExecutor
{
  public static ArrayList<String> Macro = new ArrayList<String>();
  public static Map<Player, Integer> macro = new HashMap<Player, Integer>();
  
  @EventHandler
  public void attk2(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if (Macro.contains(p.getName()))
    {
      if (!(e.getPlayer() instanceof Player)) {
        return;
      }
      if ((!e.getAction().name().contains("LEFT")) && (macro.containsKey(p.getName()))) {
        return;
      }
      if (macro.containsKey(p)) {
        macro.put(p, Integer.valueOf(Integer.valueOf(((Integer)macro.get(p)).intValue()).intValue() + 1));
      } else {
        macro.put(p, Integer.valueOf(1));
      }
      p.setLevel(Integer.valueOf(Integer.valueOf(((Integer)macro.get(p)).intValue()).intValue() + 1).intValue());
      Main.getPlugin().getConfig().set("status." + p.getName().toLowerCase() + ".ClickTests", Integer.valueOf(Integer.valueOf(Integer.valueOf(((Integer)macro.get(p)).intValue()).intValue() + 1).intValue()));
    }
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    final Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("ClickTest"))
    {
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
      {
        public void run()
        {
          Main.getPlugin().getConfig().set("status." + p.getName().toLowerCase() + ".ClickTests", Integer.valueOf(0));
          p.sendMessage(" ");
          p.sendMessage(" ");
          p.sendMessage(" ");
          p.sendMessage(" ");
          p.sendMessage("§eExtreme§fKits » §eIniciando em 1... ");
        }
      }, 10L);
      
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
      {
        public void run()
        {
          p.sendMessage(" ");
          p.sendMessage(" ");
          p.sendMessage(" ");
          p.sendMessage(" ");
          p.sendMessage("§eExtreme§fKits » §aIniciando em 2... ");
        }
      }, 20L);
      
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
      {
        public void run()
        {
          p.sendMessage(" ");
          p.sendMessage(" ");
          p.sendMessage(" ");
          p.sendMessage(" ");
          p.sendMessage("§eExtreme§fKits » §aIniciando em 3... ");
        }
      }, 30L);
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
      {
        public void run()
        {
          p.sendMessage(" ");
          p.sendMessage(" ");
          p.sendMessage(" ");
          p.sendMessage(" ");
          p.sendMessage("§eExtreme§fKits » §bIniciado Comece.");
          ClickTest.macro.put(p, Integer.valueOf(0));
          ClickTest.macro.put(p, Integer.valueOf(0));
          ClickTest.macro.put(p, Integer.valueOf(0));
          ClickTest.macro.put(p, Integer.valueOf(0));
          
          p.getInventory().clear();
          
          p.sendMessage(" ");
          p.sendMessage(" ");
          p.sendMessage(" ");
          p.sendMessage(" ");
          
          ClickTest.Macro.add(p.getName());
        }
      }, 40L);
      
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
      {
        public void run()
        {
          p.sendMessage("                                                          ");
          p.sendMessage("                                                          ");
          p.sendMessage("=-=-=-=-=-==-=-==-=-=");
          p.sendMessage("§eExtreme§fKits » §fVocê fez em 10 segundos §a§o " + p.getLevel() + " §fClicks!");
          p.sendMessage("§eExtreme§fKits » §fVocê fez em Media §a§o" + p.getLevel() / 10 + " §fCliks por segundo.");
          p.sendMessage("=-=-=-=-=-==-=-==-=-=");
          
          p.getInventory().clear();
          
          p.setLevel(0);
          p.setExhaustion(20.0F);
          p.setMaxHealth(20.0D);
          p.setFoodLevel(20);
          p.setGameMode(GameMode.SURVIVAL);
          Join.entrar(p);
          
          
          ClickTest.Macro.remove(p.getName());
          ClickTest.macro.put(p, Integer.valueOf(0));
          ClickTest.macro.put(p, Integer.valueOf(0));
          ClickTest.macro.put(p, Integer.valueOf(0));
          ClickTest.macro.put(p, Integer.valueOf(0));
        }
      }, 250L);
    }
    return false;
  }
}
