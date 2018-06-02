package me.rafael.vinagre.KomboPvP.Listeners;

import java.util.HashMap;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.rafael.vinagre.KomboPvP.Main;


  
  

  public class SpamCheck
    implements Listener
  {
    public static HashMap<Player, Long> chat = new HashMap();
    
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
        p.sendMessage(((Main.getPlugin().getConfig().getString("MsgSpam").replace("&", "§"))));
        e.setCancelled(true);
      }
    }
  }