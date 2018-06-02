package me.recenthg.stark.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.recent.stark.Main;

public class Youtuber
  implements Listener, CommandExecutor
{
  public Youtuber(Main main)
  {
  }

  public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args)
  {
    Player p = (Player)Sender;
    if (Label.equalsIgnoreCase("youtuber"))
    {
      p.sendMessage("§b§l==========[YOUTUBER]==========");
      p.sendMessage("§b§lInscritos: §b§l600");
      p.sendMessage("§b§lVideo: §b§lUm Video No Server.");
      p.sendMessage("§b§lLikes: §b§l500.");
      p.sendMessage("§b§lVisualizações: §b§l700");
      p.sendMessage("§b§l==========[YOUTUBER]==========");
    }

    p.sendMessage("§6§l============[PRO]============");
    p.sendMessage("§6§lInscritos: §6§l300.");
    p.sendMessage("§6§lVideo: §e§lUm Video No Server.");
    p.sendMessage("§6§lLikes: §e§l100 Likes.");
    p.sendMessage("§6§lVisualizações: §e§l100");
    p.sendMessage("§6§l============[PRO]============");

    p.sendMessage("§3§l============[YOUTUBER+]============");
    p.sendMessage("§3§lInscritos: §3§l1000");
    p.sendMessage("§3§lVideo: §3§lUm Video No Server");
    p.sendMessage("§3§lLikes: §3§l300 Likes");
    p.sendMessage("§3§lVisualizações: §3§l1k");
    p.sendMessage("§3§l============[YOUTUBER+]============");

    return false;
  }
}