package Utils;

import Main.Main;
import Utils.KillsDeathsMoney;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class KillStreak
  implements Listener
{
  public static HashMap<String, Integer> Kill = new HashMap<>();
  
  public static void addKill(Player p)
  {
    int value = ((Integer)Kill.get(p.getName())).intValue();
    Kill.put(p.getName(), Integer.valueOf(value + 1));
  }
  
  public static void RemoverKill(Player p)
  {
    Kill.put(p.getName(), Integer.valueOf(0));
  }
  
  @EventHandler
  public void Matar(PlayerDeathEvent e)
  {
    if ((e.getEntity().getKiller() instanceof Player))
    {
      final Player p = e.getEntity().getKiller();
      addKill(p);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
      {
        public void run()
        {
          switch (((Integer)KillStreak.Kill.get(p.getName())).intValue())
          {
          case 5: 
        	  Bukkit.broadcastMessage("§7{§c§lKILLSTREAK§7}  §aO Jogador " + p.getDisplayName() + " §aesta com  KillStreak de §b: " + KillStreak.Kill.get(p.getName()));
            KillsDeathsMoney.addMoney(p, 250);p.sendMessage("§aVoce ganhou §6+ 200"); break;
          case 10: 
        	  Bukkit.broadcastMessage("§7{§c§lKILLSTREAK§7}  §aO Jogador " + p.getDisplayName() + " §aesta com  KillStreak de §b: " + KillStreak.Kill.get(p.getName()));
            KillsDeathsMoney.addMoney(p, 300);p.sendMessage("§aVoce ganhou §6+ 300"); break;
          case 15: 
        	  Bukkit.broadcastMessage("§7{§c§lKILLSTREAK§7}  §aO Jogador " + p.getDisplayName() + " §aesta com  KillStreak de §b: " + KillStreak.Kill.get(p.getName()));
            KillsDeathsMoney.addMoney(p, 350);p.sendMessage("§aVoce ganhou §6+ 350"); break;
          case 20: 
        	  Bukkit.broadcastMessage("§7{§c§lKILLSTREAK§7}  §aO Jogador " + p.getDisplayName() + " §aesta com  KillStreak de §b: " + KillStreak.Kill.get(p.getName()));
            KillsDeathsMoney.addMoney(p, 400);p.sendMessage("§aVoce ganhou §6+ 400"); break;
          case 25: 
        	  Bukkit.broadcastMessage("§7{§c§lKILLSTREAK§7}  §aO Jogador " + p.getDisplayName() + " §aesta com  KillStreak de §b: " + KillStreak.Kill.get(p.getName()));
            KillsDeathsMoney.addMoney(p, 450);p.sendMessage("§aVoce ganhou §6+ 450"); break;
          case 30: 
        	  Bukkit.broadcastMessage("§7{§c§lKILLSTREAK§7}  §aO Jogador " + p.getDisplayName() + " §aesta com  KillStreak de §b: " + KillStreak.Kill.get(p.getName()));
            KillsDeathsMoney.addMoney(p, 500);p.sendMessage("§aVoce ganhou §6+ 500"); break;
          case 35: 
        	  Bukkit.broadcastMessage("§7{§c§lKILLSTREAK§7}  §aO Jogador " + p.getDisplayName() + " §aesta com  KillStreak de §b: " + KillStreak.Kill.get(p.getName()));
            KillsDeathsMoney.addMoney(p, 550);p.sendMessage("§aVoce ganhou §6+ 550"); break;
          case 40: 
        	  Bukkit.broadcastMessage("§7{§c§lKILLSTREAK§7}  §aO Jogador " + p.getDisplayName() + " §aesta com  KillStreak de §b: " + KillStreak.Kill.get(p.getName()));
            KillsDeathsMoney.addMoney(p, 600);p.sendMessage("§aVoce ganhou §6+ 600"); break;
          case 45: 
        	  Bukkit.broadcastMessage("§7{§c§lKILLSTREAK§7}  §aO Jogador " + p.getDisplayName() + " §aesta com  KillStreak de §b: " + KillStreak.Kill.get(p.getName()));
            KillsDeathsMoney.addMoney(p, 650);p.sendMessage("§aVoce ganhou §6+ 650"); break;
          case 50: 
        	  Bukkit.broadcastMessage("§7{§c§lKILLSTREAK§7}  §aO Jogador " + p.getDisplayName() + " §aesta com  KillStreak de §b: " + KillStreak.Kill.get(p.getName()));
            KillsDeathsMoney.addMoney(p, 700);p.sendMessage("§aVoce ganhou §6+ 700"); break;
          case 55: 
        	  Bukkit.broadcastMessage("§7{§c§lKILLSTREAK§7}  §aO Jogador " + p.getDisplayName() + " §aesta com  KillStreak de §b: " + KillStreak.Kill.get(p.getName()));
            KillsDeathsMoney.addMoney(p, 750);p.sendMessage("§aVoce ganhou §6+ 750"); break;
          case 60: Bukkit.broadcastMessage("§7{§c§lKILLSTREAK§7}  §aO Jogador " + p.getDisplayName() + " §aesta com  KillStreak de §b: " + KillStreak.Kill.get(p.getName()));
            KillsDeathsMoney.addMoney(p, 800);p.sendMessage("§aVoce ganhou §6+ 800"); break;
          case 65: 
        	  Bukkit.broadcastMessage("§7{§c§lKILLSTREAK§7}  §aO Jogador " + p.getDisplayName() + " §aesta com  KillStreak de §b: " + KillStreak.Kill.get(p.getName()));
            KillsDeathsMoney.addMoney(p, 850);p.sendMessage("§aVoce ganhou §6+ 850"); break;
          case 70: 
        	  Bukkit.broadcastMessage("§7{§c§lKILLSTREAK§7}  §aO Jogador " + p.getDisplayName() + " §aesta com  KillStreak de §b: " + KillStreak.Kill.get(p.getName()));
            KillsDeathsMoney.addMoney(p, 900);p.sendMessage("§aVoce ganhou §6+ 900"); break;
          case 75: 
        	  Bukkit.broadcastMessage("§7{§c§lKILLSTREAK§7}  §aO Jogador " + p.getDisplayName() + " §aesta com  KillStreak de §b: " + KillStreak.Kill.get(p.getName()));
            KillsDeathsMoney.addMoney(p, 950);p.sendMessage("§aVoce ganhou §6+ 950"); break;
          case 80: 
        	  Bukkit.broadcastMessage("§7{§c§lKILLSTREAK§7}  §aO Jogador " + p.getDisplayName() + " §aesta com  KillStreak de §b: " + KillStreak.Kill.get(p.getName()));
            KillsDeathsMoney.addMoney(p, 1000);p.sendMessage("§aVoce ganhou §6+ 1000"); break;
          case 85: 
        	  Bukkit.broadcastMessage("§7{§c§lKILLSTREAK§7}  §aO Jogador " + p.getDisplayName() + " §aesta com  KillStreak de §b: " + KillStreak.Kill.get(p.getName()));
            KillsDeathsMoney.addMoney(p, 1500);p.sendMessage("§aVoce ganhou §6+ 1500"); break;
          case 90: 
        	  Bukkit.broadcastMessage("§7{§c§lKILLSTREAK§7}  §aO Jogador " + p.getDisplayName() + " §aesta com  KillStreak de §b: " + KillStreak.Kill.get(p.getName()));
            KillsDeathsMoney.addMoney(p, 2000);p.sendMessage("§aVoce ganhou §6+ 2000"); break;
          case 95: 
        	  Bukkit.broadcastMessage("§7{§c§lKILLSTREAK§7}  §aO Jogador " + p.getDisplayName() + " §aesta com  KillStreak de §b: " + KillStreak.Kill.get(p.getName()));
            KillsDeathsMoney.addMoney(p, 2500);p.sendMessage("§aVoce ganhou §6+ 2500"); break;
          case 100: 
            KillsDeathsMoney.addMoney(p, 30000);p.sendMessage("§aVoce ganhou §6+ 30000");
            Bukkit.broadcastMessage("§7{§c§lKILLSTREAK§7}  §aO Jogador " + p.getDisplayName() + " §aesta com  KillStreak de §b: " + KillStreak.Kill.get(p.getName()));
          }
        }
      }, 1L);
    }
  }
}
