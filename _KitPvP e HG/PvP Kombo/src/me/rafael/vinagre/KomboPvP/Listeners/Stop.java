package me.rafael.vinagre.KomboPvP.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.rafael.vinagre.KomboPvP.*;







public class Stop
  implements CommandExecutor, Listener
{
  public Main plugin;
  
  public Stop(Main main)
  {
    this.plugin = main;
  }
  
  @SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage("Para parar de /restart");
      return true;
    }
    Player jogador = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("tpa"))
    {
    	 {
    	      jogador.sendMessage("§7[§6§l!§7] §bVoce puxou todos os players!");
    	      Bukkit.broadcastMessage("§7[§6§l!§7] §bO Staff§a " + jogador.getName() + " §bPuxou Todos!");
    	      if (jogador.hasPermission("naaaa.laaa"))
    	      {
    	        Player[] arrayOfPlayer;
    	        int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
    	        for (int i = 0; i < j; i++)
    	        {
    	          Player todos = arrayOfPlayer[i];
    	          
    	          todos.teleport(jogador.getLocation());
    	        }
    	      }
    	    }
    	    return false;
    	  }
	return false;
    	}
  {
  }
}
    	     
