package me.rafael.vinagre.KomboPvP.Listeners;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;

import org.bukkit.event.player.PlayerChatEvent;

import Scoreboard.ScoreDoBasic;

@SuppressWarnings("deprecation")
public class Cores implements Listener  {

	  
	@EventHandler(priority=EventPriority.NORMAL)
	  public void onColorandChangeChat(PlayerChatEvent e)
	  {
	    Player p = e.getPlayer();
	    if (!p.hasPermission("chat.color")) {
	      e.setFormat("§7(" + ScoreDoBasic.Rank(p) + "§7)" + p.getDisplayName() + " §6»" + "§7 " + e.getMessage());
	    } else {
	    	e.setFormat("§7(" + ScoreDoBasic.Rank(p) + "§7)" + p.getDisplayName() + " §6»" + "§7 " + e.getMessage().replaceAll("&", "§"));
	    }
	  }
	}
