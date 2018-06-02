package nobody.eventos;

import nobody.main.Main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Stats
  implements Listener
{
  @EventHandler
  void aoLogar(PlayerJoinEvent evento)
  {
    Player j = evento.getPlayer();
    if (Main.getInstance().getConfig().get("status." + j.getName().toLowerCase() + ".kills") == null)
    {
      Main.getInstance().getConfig().set("status." + j.getName().toLowerCase() + ".kills", Integer.valueOf(0));
      Main.getInstance().saveConfig();
    }
    if (Main.getInstance().getConfig().get("status." + j.getName().toLowerCase() + ".mortes") == null)
    {
      Main.getInstance().getConfig().set("status." + j.getName().toLowerCase() + ".mortes", Integer.valueOf(0));
      Main.getInstance().saveConfig();
    }
  }
  
  @EventHandler
  void aoMatar(PlayerDeathEvent evento)
  {
    if ((evento.getEntity().getKiller() instanceof Player))
    {
      Player j = evento.getEntity().getKiller();
      
      int kills = Main.getInstance().getConfig().getInt("status." + j.getName().toLowerCase() + ".kills");
      Main.getInstance().getConfig().set("status." + j.getName().toLowerCase() + ".kills", Integer.valueOf(kills + 1));
      Main.getInstance().saveConfig();
    }
  }
  
  @EventHandler
  void aoMorrer(PlayerDeathEvent evento)
  {
    if ((evento.getEntity() instanceof Player))
    {
      Player j = evento.getEntity();
      
      int mortes = Main.getInstance().getConfig().getInt("status." + j.getName().toLowerCase() + ".mortes");
      Main.getInstance().getConfig().set("status." + j.getName().toLowerCase() + ".mortes", Integer.valueOf(mortes + 1));
      Main.getInstance().saveConfig();
    }
  }
  
  public static boolean playerExists(String jogador)
  {
    return Main.getInstance().getConfig().get("Ks." + jogador) != null;
  }
  
  public static int getKillStreak(String jogador)
  {
    if (!playerExists(jogador)) {
      return 0;
    }
    return Main.getInstance().getConfig().getInt("Ks." + jogador + ".killstreak");
  }
  
  public void resetKillStreak(String jogador)
  {
    if (!playerExists(jogador)) {
      return;
    }
    Main.getInstance().getConfig().set("Ks." + jogador + ".killstreak", Integer.valueOf(0));
    Main.getInstance().saveConfig();
  }
  
  public void addKill(String jogador)
  {
    Main.getInstance().getConfig().set("Ks." + jogador + ".killstreak", 
      Integer.valueOf(getKillStreak(jogador) + Integer.valueOf(1).intValue()));
    Main.getInstance().saveConfig();
  }
  
  
  
  @EventHandler
  public void onJoin(PlayerJoinEvent e)
  {
    Player victima = e.getPlayer();
    resetKillStreak(victima.getName());
  }
  
  public int prize(String jogador)
  {
    int streak = getKillStreak(jogador);
    if (streak % 5 == 0) {
      return streak * 3 * (streak / 5);
    }
    return 0;
  }
  
  @EventHandler
  public void onKill(PlayerDeathEvent evento)
  {
    Player victim = evento.getEntity();
    Player killer = evento.getEntity().getKiller();
    if (getKillStreak(victim.getName()) >= 10) {
      Bukkit.broadcastMessage("§7[§6§l!§7] §b" + killer.getName() + " §7Acabou com o KillStreak §b" + 
        getKillStreak(victim.getName()) + " §bde§6 " + victim.getName() + "§7!");
    }
    resetKillStreak(victim.getName());
    if ((killer instanceof Player))
    {
      addKill(killer.getName());
    }
  }
}
