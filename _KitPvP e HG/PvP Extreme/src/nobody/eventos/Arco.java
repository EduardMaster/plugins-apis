package nobody.eventos;

import java.util.ArrayList;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Arco
  implements Listener
{
  public static ArrayList<String> Arco = new ArrayList<String>();
  
  @SuppressWarnings("deprecation")
@EventHandler(priority=EventPriority.NORMAL)
  public void onEntityDamage(EntityDamageByEntityEvent e)
  {
    if ((e.getDamager() instanceof Arrow))
    {
      Arrow s = (Arrow)e.getDamager();
      if ((s.getShooter() instanceof Player))
      {
        Player p = (Player)s.getShooter();
        if (Arco.contains(p.getName()))
        {
          Player damaged = (Player)e.getEntity();
          
          e.setDamage(999.0D);
          p.getPlayer().playSound(p.getPlayer().getLocation(), Sound.ANVIL_LAND, 1.0F, 1.0F);
          damaged.getLocation().getWorld().playEffect(damaged.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_WIRE);
        }
      }
    }
  }
}
