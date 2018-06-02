package me.rafael.vinagre.KomboPvP.Listeners;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.rafael.vinagre.KomboPvP.Main;

public class SerXingado
implements CommandExecutor, Listener
{
public boolean onCommand(CommandSender Sender, Command cmd, String string, String[] args)
{
  Player p = (Player)Sender;
  if (cmd.getName().equalsIgnoreCase("youtuber"))
  {
    p.playSound(p.getLocation(), Sound.LEVEL_UP, 20.0F, 1.0F);
    p.sendMessage(((Main.getPlugin().getConfig().getString("ytmsg1").replace("&", "§"))));
    p.sendMessage(((Main.getPlugin().getConfig().getString("ytmsg2").replace("&", "§"))));
    p.sendMessage(((Main.getPlugin().getConfig().getString("ytmsg3").replace("&", "§"))));
    p.sendMessage(((Main.getPlugin().getConfig().getString("ytmsg4").replace("&", "§"))));
    p.sendMessage(((Main.getPlugin().getConfig().getString("ytmsg5").replace("&", "§"))));
    p.sendMessage(((Main.getPlugin().getConfig().getString("ytmsg6").replace("&", "§"))));		
    p.sendMessage(((Main.getPlugin().getConfig().getString("ytmsg7").replace("&", "§"))));
    p.sendMessage(((Main.getPlugin().getConfig().getString("ytmsg8").replace("&", "§"))));
    p.sendMessage(((Main.getPlugin().getConfig().getString("ytmsg9").replace("&", "§"))));
    p.sendMessage(((Main.getPlugin().getConfig().getString("ytmsg10").replace("&", "§"))));
   
  }
  return false;
}
}
   
