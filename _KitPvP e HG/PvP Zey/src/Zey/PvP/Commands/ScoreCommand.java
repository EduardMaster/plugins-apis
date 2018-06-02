package Zey.PvP.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Zey.PvP.Main.Main;

public class ScoreCommand implements CommandExecutor{

	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		
		Player p = (Player)Sender;
		
		if(Cmd.getName().equalsIgnoreCase("score")) {
			p.sendMessage(String.valueOf(Main.prefix) + " §7» §cEsse comando foi desativado, temporariamente.");
			return true;
			}
			//if(SPlayer.Score.contains(p)){
				// desativa
				p.sendMessage("");
		//	}
			//else if(!SPlayer.Score.contains(p)){
				// ativa
			//	p.sendMessage("");
		//	}
		return false;
	}
}
