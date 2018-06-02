package Utils;

import java.util.ArrayList;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class AntiMoveAPI
  implements Listener
{
  public static ArrayList<String> AntiMove1 = new ArrayList<>();
  public static ArrayList<String> AntiMove2 = new ArrayList<>();
  
  @EventHandler
  public void Andar(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    if (AntiMove1.contains(p.getName())) {
      e.setCancelled(true);
    }
    if (AntiMove2.contains(p.getName())) {
      p.setVelocity(new Vector(0.0D, -2.0D, 0.0D));
    }
  }
}
