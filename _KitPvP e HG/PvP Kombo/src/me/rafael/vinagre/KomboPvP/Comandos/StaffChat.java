package me.rafael.vinagre.KomboPvP.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class StaffChat 
implements Listener, CommandExecutor
{

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	  {
		 if (!(sender instanceof Player))
	      {
	        sender.sendMessage("§cComando para players!");
	        return true;
	      }
	    if (cmd.getName().equalsIgnoreCase("s"))
	    {
	      if (args.length == 0) {
	        sender.sendMessage("§7» §cUse: §7/s <mensagem>");
	      }
	      if (args.length > 0)
	      {
	        StringBuilder string = new StringBuilder();
	        for (int i = 0; i < args.length; i++) {
	          string.append(args[i] + " ");
	        }
	        String mensagem = string.toString();
	        Player[] arrayOfPlayer;
	        @SuppressWarnings("deprecation")
			int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
	        for (int i = 0; i < j; i++)
	        {
	          Player staff = arrayOfPlayer[i];
	          if (!sender.hasPermission("kitpvp.sc")){
	        	  sender.sendMessage("§4§lErro: §c§lAcesso negado");
	        	  return true;
	          }
	          if (staff.hasPermission("kitpvp.sc")){
	            staff.sendMessage("§5§LSTAFFCHAT §7» §6" + sender.getName() + ": §f" + mensagem);
	        }
	        }
	      }
	    }
	    return false;
	  }
	}
