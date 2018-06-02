package Zey.PvP.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Zey.PvP.Main.Main;


public class TpAllCommand implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("tpall")) {
            if (!p.hasPermission("zey.pvp.tp.all")) {
			p.sendMessage("§cVocê não tem permissão para isso.");
				return true;
			}
			if(args.length == 0) {
				p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você puxou §a§lTODOS §7os jogadores até você.");
				Bukkit.broadcastMessage(String.valueOf(Main.prefix) + " §7» §7O jogador(a): §e" + p.getName() + "§7 puxou todos os jogadores até ele.");
				for(Player todos : Bukkit.getOnlinePlayers()) {
					if(todos != p) {
						todos.teleport(p);
					}
				}
			}
		}
		return false;
	}
}
