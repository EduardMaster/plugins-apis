package br.com.alpha.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.alpha.MCAlpha;
import br.com.alpha.gamemanagement.GameTime;

public class Fly implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(!(sender instanceof Player)){
			sender.sendMessage("§cComando somente para jogadores.");
			return true;
		}
		Player jogador = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("fly")){
			if (MCAlpha.Status == GameTime.INGAME||MCAlpha.Status == GameTime.INVENCIBILIDADE) {
				jogador.sendMessage("§cA Partida Iniciou!");
				return true;
			}
			if(!(jogador.hasPermission("alpha.fly"))){
				jogador.sendMessage("§cSem permissao.");
				return true;
			} else if(jogador.isFlying()){
				jogador.setAllowFlight(false);
				jogador.sendMessage("§cModo de voo desabilitado.");
				return true;
			} else if(!(jogador.isFlying())){
				jogador.setAllowFlight(true);
				jogador.sendMessage("§aModo de voo habilitado.");
				return true;
			}
		}
		return false;
	}

}
