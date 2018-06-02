package me.rafael.vinagre.KomboPvP.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Tpall 
implements Listener, CommandExecutor
{
	
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    Player p = (Player)sender;
	    if (sender.hasPermission("kitpvp.tpall")) {
	      for (Player p2 : Bukkit.getOnlinePlayers()) {
	        if (p2 != p) {
	          p2.teleport(p);
            p2.sendMessage(" §7» §c" + p.getName() + " puxou todos ate ele !");
          }
        }
          p.sendMessage(" §7» §aTodos os jogadores agora estao na sua localizaçao !");
      }
    return true;
  }
}