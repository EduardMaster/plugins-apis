package Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChat implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		for (Player s : Bukkit.getOnlinePlayers()) {
			if (!(sender.hasPermission("fly.cc"))) {
				sender.sendMessage("§c§lVoce nao tem permissao!");
				return true;
			}
		for (int i= 0; i != 100; i++) {
				s.sendMessage("  ");
		}
		  s.sendMessage("§c§lFly§7§lTrue: §ao Chat foi limpo");
		}
		return false;
	}
	

}
