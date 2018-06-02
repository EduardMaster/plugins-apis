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
		if (!(p.hasPermission("fly.admin"))) {
			p.sendMessage("§c§lFly§7§lTrue §a: §c§lVoce nao tem permissao!");
			return true;
	}
		if (args.length == 0) {
		p.sendMessage("§c§lFly§7§lTrue §a: §bUse /sc <Mensagem>!");
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
			if (s.hasPermission("fly.admin")) {
				s.sendMessage("§c§lSTAFF §d: §b§l" + p.getName() + " §7 " + message.replace("&", "§"));
			}
		}
		return true;
	}
  }
}
