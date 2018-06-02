package Pedrao.XP;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class GanharXP
  implements Listener
{
  @EventHandler
  public void a(PlayerDeathEvent e)
  {
    if (((e.getEntity() instanceof Player)) && ((e.getEntity().getKiller() instanceof Player)))
    {
      Player killer = e.getEntity().getKiller();
      Player killed = e.getEntity();
      killer.playSound(killer.getLocation(), Sound.ANVIL_LAND, 5.0F, 1.0F);
      killed.teleport(killed.getWorld().getSpawnLocation());
      killed.playSound(killed.getLocation(), Sound.FIREWORK_BLAST, 10.0F, 10.0F);
      e.setDeathMessage(null);
      XpM.addMoney(killer, 100);
      XpM.removeMoney(killed, 5);
    }
  }
}
