package me.rafael.vinagre.KomboPvP.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class LimparChat 
implements Listener, CommandExecutor
{

public boolean onCommand(CommandSender sender, Command cmd, String commandLabel , String[] args){
	 if (!(sender instanceof Player)){
       return true;
     }
		Player p = (Player)sender;
		
		if (cmd.getName().equalsIgnoreCase("cc")){
		 if (!p.hasPermission("kitpvp.cc")){
			 return true;
		 }
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" ");
		 Bukkit.broadcastMessage(" §7» §a" + p.getName() + " limpou o chat !");
		}
		return true;
	}
}