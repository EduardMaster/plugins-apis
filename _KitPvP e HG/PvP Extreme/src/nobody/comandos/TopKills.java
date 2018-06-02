package nobody.comandos;

import java.util.HashMap;

import nobody.main.Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TopKills implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("topkills")) {
			
		     HashMap<String, Integer> players = new HashMap<String, Integer>();
		        for(String playerName: Main.getPlugin().getConfig().getConfigurationSection("status").getKeys(false)){
		        	players.put(playerName, Main.getPlugin().getConfig().getInt("status." + playerName + ".kills"));
		        	}
		        
		        sender.sendMessage("§b§l          TOP!");


		        String nextTop = "";
		        Integer nextTopKills = 0;

		        for(int i = 1; i < 11; i++){
		        for(String playerName: players.keySet()){
		        if(players.get(playerName) > nextTopKills){
		        nextTop = playerName;
		        nextTopKills = players.get(playerName);
		        }
		        }
		        sender.sendMessage(i + " §aº§7 " + nextTop + " :§f " + nextTopKills);
		        players.remove(nextTop);
		        nextTop = "";
		        nextTopKills = 0;
		        }
		        sender.sendMessage("§e§l          TOP!");
		}
		return false;
	}



}
