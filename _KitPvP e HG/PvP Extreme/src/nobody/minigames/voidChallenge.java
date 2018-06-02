package nobody.minigames;


import nobody.eventos.KitAPI;
import nobody.main.Main;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class voidChallenge
{
  public voidChallenge(final Player p)
  {
    new BukkitRunnable()
    {
      int seconds = 5;
      
      public void run()
      {
        if (this.seconds > 0)
        {
          p.sendMessage("§eExtreme§fKits »  §aMinigame Iniciando em " + this.seconds + " segundos!");
          this.seconds -= 1;
          return;
        }
        if (this.seconds == 0)
        {
          this.seconds = -1;
          p.getInventory().clear();
          p.teleport(new Location(p.getWorld(), 0.0D, -5.0D, 0.0D));
          p.sendMessage("§eExtreme§fKits »  §aO Desafio começou!!!");
          KitAPI.voidChallenge.add(p.getName());
        }
        KitAPI.voidChallengeTime.put(p.getName(), Integer.valueOf(voidChallenge.getTime(p) + 1));
        p.setLevel(voidChallenge.getTime(p));
        if ((!KitAPI.voidChallenge.contains(p.getName())) && (this.seconds < 0)) {
          cancel();
        }
      }
    }.runTaskTimer(Main.instance, 0L, 20L);
  }
  
  public static int getTime(Player p)
  {
    if (!KitAPI.voidChallengeTime.containsKey(p.getName())) {
      return 0;
    }
    return ((Integer)KitAPI.voidChallengeTime.get(p.getName())).intValue();
  }
}
