package Pedrao.Feast;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import Pedrao.Main;

public class SFeast implements Listener
{
  public SFeast(Main main) {
	}
public static void start()
  {
    Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable()
    {
      public void run()
      {
        Bukkit.broadcastMessage("§7{§4§lFeast§7} §c§lFeast Removido !");
        Ffeast.miniFeast1();
      }
    }, 0L, 900L);
    Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable()
    {
      public void run()
        {
          Bukkit.broadcastMessage("§7{§4§lFeast§7} §a§lFeast vai ser spawnado em §b3 Segundos");
        }
      }, 0L, 2450L);
      Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable()
      {
      public void run()
      {
        Bukkit.broadcastMessage("§7{§4§lFeast§7} §a§lFeast vai ser spawnado em §b2 Segundos");
      }
    }, 0L, 2450L);
    Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable()
    {
      public void run()
      {
        Bukkit.broadcastMessage("§7{§4§lFeast§7} §a§lFeast vai ser spawnado em §b1 Segundos");
      }
    }, 0L, 2490L);
    
    Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable()
    {
      public void run()
      {
        Bukkit.broadcastMessage("§7{§4§lFeast§7} §2§lFeast foi Spawnado");
        Ffeast.miniFeast();
      }
    }, 0L, 2500L);
  }
  
  public static void start1()
  {
    Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable()
    {
      public void run() {}
    }, 0L, 2300L);
  }
}
