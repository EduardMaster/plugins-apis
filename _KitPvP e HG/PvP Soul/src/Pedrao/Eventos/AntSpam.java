package Pedrao.Eventos;

import java.util.HashMap;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import Pedrao.Main;

public class AntSpam
  implements Listener
{
  @SuppressWarnings({ "unchecked", "rawtypes" })
public static HashMap<Player, Long> chat = new HashMap();
  
  public AntSpam(Main main) {
}

@EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=false)
  public void aAntiSpam(AsyncPlayerChatEvent e)
  {
    Player p = e.getPlayer();
    if (!chat.containsKey(p))
    {
      int zeitconfig = 2000;
      long time = System.currentTimeMillis() + zeitconfig;
      if (p.hasPermission("kitpvp.spam")) {
        return;
      }
      chat.put(p, Long.valueOf(time));
    }
    else if (((Long)chat.get(p)).longValue() <= System.currentTimeMillis())
    {
      if (p.hasPermission("kitpvp.spam")) {
        return;
      }
      int zeitconfig = 2000;
      long time = System.currentTimeMillis() + zeitconfig;
      chat.put(p, Long.valueOf(time));
    }
    else
    {
      if ((((Long)chat.get(p)).longValue() < System.currentTimeMillis()) || 
        (p.hasPermission("kitpvp.spam"))) {
        return;
      }
      p.sendMessage(Main.prefix + "Amigo sem Flood");
      e.setCancelled(true);
    }
  }
}
