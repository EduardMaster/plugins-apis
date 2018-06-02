package Zey.PvP.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Zey.PvP.Main.Main;


public class TpCommand implements CommandExecutor{
	
	private boolean CheckarNumero(String Numero){
		try {
			Integer.parseInt(Numero);
			return true;
		} catch(NumberFormatException e){
			return false;
		}
		
	}
	
	@Override
	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		
		Player p = (Player)Sender;
		
		if(Cmd.getName().equalsIgnoreCase("tp")){
			
            if (!p.hasPermission("zey.pvp.tp")) {
			p.sendMessage("§cVocê não tem permissão para isso.");
				return true;
			}
			
			if(Args.length == 0){
				p.sendMessage(String.valueOf(Main.prefix) + " §7» §cErrado, utilize a sintaxe correta: /tp [Jogador(a)] [Alvo] ou (x) (y) (z)");
				return true;
			}
			if(Args.length > 2 || Args.length == 3){
				if (!CheckarNumero(Args[0])) {
					p.sendMessage("§cÉ necessário utilizar apenas números para teleportar para uma §c§lcoordenada.");
					return true;
				}
				Integer X = Integer.parseInt(Args[0]);
				if(Args.length == 1){
					p.sendMessage(String.valueOf(Main.prefix) + " §7» §cErrado, utilize a sintaxe correta: /tp [Jogador(a)] [Alvo] ou (x) (y) (z)");
					return true;
				}
				if (!CheckarNumero(Args[1])) {
					p.sendMessage(String.valueOf(Main.prefix) + " §7» §cÉ necessário utilizar apenas números para teleportar para uma coordenada.");
					return true;
				}
				Integer Y = Integer.parseInt(Args[1]);
				if(Args.length == 2){
					p.sendMessage(String.valueOf(Main.prefix) + " §7» §cÉ necessário utilizar apenas números para teleportar para uma coordenada.");
					return true;
				}
				if (!CheckarNumero(Args[2])) {
					p.sendMessage(String.valueOf(Main.prefix) + " §7» §cÉ necessário utilizar apenas números para teleportar para uma coordenada.");
					return true;
				}
				Integer Z = Integer.parseInt(Args[2]);
				p.teleport(new Location(p.getWorld(), X, Y, Z));
				p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você foi §a§lTELEPORTADO §7até as coordenadas " + X + " " + Y + " " + Z);
				return true;
			}
			Player t = Bukkit.getPlayerExact(Args[0]);
			if((t == null || (!(t instanceof Player)))){
				return true;
			}
			if (Args.length > 1) {
				if (Args.length == 1) {
					return true;
				}
				Player t2 = Bukkit.getPlayer(Args[1]);
				t.teleport(t2.getLocation());
				p.sendMessage(String.valueOf(Main.prefix) + " §7» §cVocê teleportou o jogador(a): §e" + t.getName() + " §caté você!");
				return true;
			}
			p.teleport(t.getLocation());
			p.sendMessage(String.valueOf(Main.prefix) + " §7» §cVocê foi teleportado até o jogador(a): §e" + t.getName());
		
		}
		return false;	
	}
}
