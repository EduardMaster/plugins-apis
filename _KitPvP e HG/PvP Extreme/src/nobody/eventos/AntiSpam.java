package nobody.eventos;

import java.util.HashMap;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AntiSpam
  implements Listener
{
  public static HashMap<Player, Long> chat = new HashMap<>();
  
  @EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=false)
  public void aAntiSpam(AsyncPlayerChatEvent e)
  {
    Player p = e.getPlayer();
    if (!chat.containsKey(p))
    {
      int zeitconfig = 3000;
      long time = System.currentTimeMillis() + zeitconfig;
      if (p.hasPermission("tk.spam")) {
        return;
      }
      chat.put(p, Long.valueOf(time));
    }
    else if (((Long)chat.get(p)).longValue() <= System.currentTimeMillis())
    {
      if (p.hasPermission("tk.spam")) {
        return;
      }
      int zeitconfig = 3000;
      long time = System.currentTimeMillis() + zeitconfig;
      chat.put(p, Long.valueOf(time));
    }
    else
    {
      if ((((Long)chat.get(p)).longValue() < System.currentTimeMillis()) || 
        (p.hasPermission("tk.spam"))) {
        return;
      }
      p.sendMessage("§eExtreme§fKits » §cAguarde para enviar outra mensagem!");
      e.setCancelled(true);
    }
  }
}
