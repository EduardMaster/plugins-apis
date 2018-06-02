package me.recenthg.stark.Comandos;

import java.util.ArrayList;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.recent.stark.Strings;

public class Staff implements CommandExecutor, Listener {

	public static ArrayList<String> staffchat = new ArrayList<String>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§8\u276e§2§l!§8\u276f §7Comandos apenas no servidor!");
			return true;
		}
		Player p = (Player) sender;
		if ((cmd.getName().equalsIgnoreCase("sc"))) {
			if ((p.hasPermission("HungerGames.c.staff"))) {
				if (args.length == 0) {
					p.sendMessage("§8\u276e§2§l!§8\u276f §7Para entrar no chat use /sc entrar");
					p.sendMessage("§8\u276e§2§l!§8\u276f §7Para sair do chat use /sc sair");
					return true;
				}
			} else {
				p.sendMessage(Strings.semperm);
				return true;
			}
			if (args[0].equalsIgnoreCase("entrar")) {
				staffchat.add(p.getName());
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você entrou no StaffChat!");
			} else if ((args[0].equalsIgnoreCase("sair")) && (staffchat.contains(p.getName()))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você saiu do StaffChat!");
				staffchat.remove(p.getName());
			}
		}
		return false;
	}
}