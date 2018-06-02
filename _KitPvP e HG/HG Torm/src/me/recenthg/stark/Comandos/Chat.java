package me.recenthg.stark.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.recent.stark.Strings;
import me.recenthg.stark.Manager.Title;

public class Chat implements CommandExecutor {

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§aComandos apenas no servidor!");
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("chat")) {
			if (sender.hasPermission("HungerGames.c.chat")) {
				if (args.length > 0) {
					if (args.length == 1) {
						if (args[0].equalsIgnoreCase("false")) {
							Bukkit.broadcastMessage("§8\u276e§2§l!§8\u276f §7CHAT DESATIVADO!");
							  Title.sendTitle(p, "§a! §fChat Desativado §a!");
							for (Player p1 : Bukkit.getOnlinePlayers()) {
								if (!p1.hasPermission("hg.c.chat")) {
									CMDListener.chat.add(p1);
								}
							}
						} else if (args[0].equalsIgnoreCase("true")) {
							Bukkit.broadcastMessage("§8\u276e§2§l!§8\u276f §7CHAT ATIVADO!");
							  Title.sendTitle(p, "§a! §fChat Ativado §a!");
							for (Player p1 : Bukkit.getOnlinePlayers()) {
								if (CMDListener.chat.contains(p1)) {
									CMDListener.chat.remove(p1);
								}
							}
						}
					} else {
						p.sendMessage("§8\u276e§2§l!§8\u276f §7Use: /chat §7(§atrue | false§7)");
					}
				} else {
					p.sendMessage("§8\u276e§2§l!§8\u276f §7Use: /chat §7(§atrue | false§7)");
				}
			} else {
				p.sendMessage(Strings.semperm);
				return true;
			}
			return true;
		}
		return false;

	}
}