package Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffChat implements CommandExecutor{
	
	@SuppressWarnings("deprecation")
	@Override
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (!(sender instanceof Player)) {
			sender.sendMessage("Para usar isso tem que ser um player");
			return true;
		}
		Player p = (Player)sender;
		if (!(p.hasPermission("ezkits.admin"))) {
			p.sendMessage("§cSem Permissão");
			return true;
		}
		if (args.length == 0) {
			p.sendMessage("§c Use /staffchat ou /sc ");
			return true;
		}else {
			String message = "";
			for (int i = 0; i < args.length; i++) {
				if (i == args.length - 1) {
					message = message + args[i];
				}else {
					message = message + args[i] + " ";
				}
			}
			for (Player s : Bukkit.getOnlinePlayers()) {
				if (s.hasPermission("ezkits.admin")) {
					s.sendMessage("§3§l[Staff] §c" + p.getName() + "§b: §6 " + message.replace("&", "§"));
				}
			}
			return true;
		}
	}

}
