package me.rafael.vinagre.KomboPvP.Comandos;




import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.rafael.vinagre.KomboPvP.Listeners.KillsDeathsMoney;








public class Kills implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("kills")){
			if(!(sender instanceof CommandSender)){
				sender.sendMessage("§cPara Segurança do Servidor Esse Comando Só Pode Ser Executado Pelo CONSOLE!");
				return true;
			}
			
			
			if(args.length < 3){
				sender.sendMessage("§cUse /kills dar <jogador> <quantia>");
				return true;
			}
			
			int tanto = Integer.valueOf(args[2]);
			Player t = Bukkit.getPlayer(args[1]);
			
			if(args[0].equalsIgnoreCase("dar")){
				
				try{
					KillsDeathsMoney.addKill(t, tanto);
					sender.sendMessage("§aVocê Deu " + tanto + " De Kills Para O Jogador " + t.getName());
					t.sendMessage(tanto + " §aKills Fora Adicionadas A Sua Conta!");
					Scoreboard.ScoreDoBasic.iscoriboard(t);
				}catch(Exception e){
					sender.sendMessage("§cUse Somente Numeros!");
				}
				
			}else{
				sender.sendMessage("§cUse /kills dar <jogador> <quantia>");
			}
			
			
		}
	
		
		
		
		return false;
	}

}

