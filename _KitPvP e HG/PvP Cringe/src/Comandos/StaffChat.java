package Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class StaffChat implements Listener, CommandExecutor {
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cVoce precisa ser um player!");
			return true;
		}
		Player p = (Player)sender;
		if (!(p.hasPermission("cmd.admin"))) {
			p.sendMessage("§c§lSTAFFCHAT §fVoce §4§lNAO &fTem permissao para isso.");
			return true;
	}
		if (args.length == 0) {
		p.sendMessage("§c§lSTAFFCHAT §fMande uma mensagem! §e§l/SC <MENSAGEM>");
		return true;
	} else {
		String message = "";
		for (int i = 0; i < args.length; i++) {
			if (i == args.length - 1) {
				message = message + args[i];
		} else {
			message = message + args[i] + " ";
		}
	}
		for (Player s : Bukkit.getOnlinePlayers()) {
			if (s.hasPermission("cmd.admin")) {
				s.sendMessage("§c§lSTAFFCHAT§f: " + p.getName() + "§f» " + message.replace("&", "§"));
			}
		}
		return true;
	}
  }
}
