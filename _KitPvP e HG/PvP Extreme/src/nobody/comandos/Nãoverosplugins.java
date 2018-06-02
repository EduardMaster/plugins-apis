package nobody.comandos;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Nãoverosplugins
  implements Listener
{
  @EventHandler(priority=EventPriority.LOWEST)
  public void replaceChat(AsyncPlayerChatEvent e)
  {
    String msg = e.getMessage();
    msg = msg.replace("%", "§lⴻ§f");
    
    e.setMessage(msg);
  }

    @EventHandler
    public void naoVerOsPlugins(PlayerCommandPreprocessEvent event)
    {
      Player p = event.getPlayer();
      if ((!p.hasPermission("tk.Plugins")) && (
        (event.getMessage().toLowerCase().startsWith("/pl")) || 
        (event.getMessage().toLowerCase().startsWith("/plugins")) || 
        (event.getMessage().toLowerCase().startsWith("/ver")) || 
        (event.getMessage().toLowerCase().startsWith("/?")) || 
        (event.getMessage().toLowerCase().startsWith("?")) || 
        (event.getMessage().toLowerCase().startsWith("/help")) || 
        (event.getMessage().toLowerCase().startsWith("/version")) || 
        (event.getMessage().toLowerCase().startsWith("/icanhasbukkit")) || 
        (event.getMessage().toLowerCase().startsWith("/about")) || 
        (event.getMessage().toLowerCase().startsWith("/bukkit:plugins"))))
    	  
      {
        event.setCancelled(true);
        
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
        p.sendMessage("§a •          §e§lPlugin Feito Por: §aNeero §ee §bDarkkk!        §a•");
        p.sendMessage("                                      ");
        p.sendMessage("§a •            §eQuer um igual ?         §a•");
        p.sendMessage("                                      ");
        p.sendMessage("§a •          §c§lAdicione Skype §e: Neero.TK!         §a•");
        p.sendMessage("                                      ");
        p.sendMessage("§a •          §e§lOBS:   §aNão é Grátis.         §a•");
        p.sendMessage("                                      ");
        
      }
    }
  }

