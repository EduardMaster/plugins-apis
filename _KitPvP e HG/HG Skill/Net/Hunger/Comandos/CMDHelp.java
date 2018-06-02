package Net.Hunger.Comandos;

import java.text.SimpleDateFormat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Net.Hunger.Main;
import Net.Hunger.Timer.StringTimer;

public class CMDHelp implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if(!(sender instanceof Player)) {
    sender.sendMessage("§7[§a!§7] §aComandos apenas no servidor!");
    return true;
    }
    Player p = (Player)sender;
    if(cmd.getName().equalsIgnoreCase("ip")) {
     p.sendMessage("§7[§a!§7] §7Endereço do servidor: §a" + Main.instance.getConfig().getString("ip"));
    }
	 if ((cmd.getName().equalsIgnoreCase("help"))) {
	  if(Main.PreGame) {
	    p.sendMessage("§7[§a!§7] " + "§7Informaçoes");
	    p.sendMessage("§7[§a!§7] " + "§7Estagio - §aPreGame");
	    p.sendMessage("§7[§a!§7] " + "§7Inicia em - §a" + StringTimer.TimerGame(Main.TimerIniciando));
        p.sendMessage("§7[§a!§7] " + "§7Jogadores participando - §a " + Main.Jogadores.size());
        p.sendMessage("§7[§a!§7] " + "§7Endereço do servidor: §a" + Main.instance.getConfig().getString("ip"));
	    }
	    if(Main.PreInvencibilidade) {
		p.sendMessage("§7[§a!§7] " + "§7Informaçoes");
	    p.sendMessage("§7[§a!§7] " + "§7Estagio - §aInvencibilidade");
	    p.sendMessage("§7[§a!§7] " + "§7Invencibilidade - §a" + StringTimer.TimerGame(Main.TimerInvencibilidade));
        p.sendMessage("§7[§a!§7] " + "§7Jogadores participando §a" + Main.Jogadores.size());
        p.sendMessage("§7[§a!§7] " + "§7Endereço do servidor: §a" + Main.instance.getConfig().getString("ip"));
	    }
	    if(Main.Partida) {
	    int millis = Main.Andamento * 1000;
	    SimpleDateFormat df = new SimpleDateFormat("mm:ss");
	    String time = df.format(Integer.valueOf(millis)); 
	    p.sendMessage("§7[§a!§7] " + "§7Informaçoes");
	    p.sendMessage("§7[§a!§7] " + "§7Estagio - §aAndamento");
	    p.sendMessage("§7[§a!§7] " + "§7Tempo - §a" + time);
        p.sendMessage("§7[§a!§7] " + "§7Jogadores participando §a" + Main.Jogadores.size());
        p.sendMessage("§7[§a!§7] " + "§7Endereço do servidor: §a" + Main.instance.getConfig().getString("ip"));
	    }
	   }
	 return true;
    }
   }