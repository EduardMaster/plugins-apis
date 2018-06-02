package br.com.alpha.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChat implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(!(sender instanceof Player)){
			sender.sendMessage("§cComando somente para jogadores.");
			return true;
		}
		Player jogador = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("cc")){
			if(!(jogador.hasPermission("alpha.cc"))){
				jogador.sendMessage("§cSem permissao.");
				return true;
			} else {
				for(int i = 0; i < 100; i++){
					Bukkit.broadcastMessage(" ");
				}
				Bukkit.broadcastMessage("§cO chat foi limpo.");
				jogador.sendMessage("§aVocê limpou o chat do servidor.");
			}
		}
		return false;
	}
}