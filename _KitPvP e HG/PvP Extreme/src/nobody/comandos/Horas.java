package nobody.comandos;

import java.util.Calendar;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Horas implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
	  if (!(sender instanceof Player)) {
		sender.sendMessage("§cApenas jogadores!");
		  return true;		  
	  }
	  
	   if (cmd.getName().equalsIgnoreCase("horas")) {
		   
		   Calendar calendar1 = Calendar.getInstance();
		   
		   int horas = calendar1.get(Calendar.HOUR_OF_DAY);
		   int minutos = calendar1.get(Calendar.MINUTE);
		   int segundos = calendar1.get(Calendar.SECOND);
		   
		   Player p = (Player)sender;
		   
		   p.sendMessage(" ");
		   p.sendMessage("§7Horas §e» " + horas + "§7h §e" + minutos + "§7m §e"+ segundos + "§7s");
		   p.sendMessage(" ");
		   
	   }
	  
		return false;
	}

}
