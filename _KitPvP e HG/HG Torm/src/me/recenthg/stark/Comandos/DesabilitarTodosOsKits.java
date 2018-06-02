package me.recenthg.stark.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.recent.stark.Strings;
import me.recenthg.stark.Manager.Habilidade;
import me.recenthg.stark.Manager.Title;

public class DesabilitarTodosOsKits implements Listener, CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public final boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§8\u276e§2§l!§8\u276f §7Comandos apenas no servidor!");
			return true;
		}
		Player p = (Player) sender;
		if ((cmd.getName().equalsIgnoreCase("toggle"))) {
			if (p.hasPermission("HungerGames.c.Toggle")) {
				if (args.length == 0) {
					sender.sendMessage("§8\u276e§2§l!§8\u276f §7Use /Toggle §7[§6On|Off§7]");
					return true;
				} else if (args[0].equalsIgnoreCase("on")) {
					sender.sendMessage("Você ativou os kits!");
					Bukkit.broadcastMessage("§aOS KITS FORAM ATIVOS!");
					Bukkit.broadcast(p.getName() + " §6ATIVOU OS KITS!", "hg.admin");
					  Title.sendTitle(p, "§a! §fKits Ativado §a!");
					DesabilitarKit.KitsDisable = false;
				} else if (args[0].equalsIgnoreCase("off")) {
					sender.sendMessage("§8\u276e§2§l!§8\u276f §7Você desativou os kits!");
					Bukkit.broadcastMessage("§aOS KITS FORAM DESATIVADOS!");
					Bukkit.broadcast(p.getName() + " §6DESATIVOU OS KITS!", "hg.admin");
					  Title.sendTitle(p, "§a! §fKits Desativad §a!");
					DesabilitarKit.KitsDisable = true;
					for (Player Jogadores : Bukkit.getOnlinePlayers()) {
						Habilidade.removeAbility(Jogadores);
					}
				} else {
					sender.sendMessage("§8\u276e§2§l!§8\u276f §7Use /Toggle §7[§6On|Off§7]");
				}
			} else {
				p.sendMessage(Strings.semperm);
				return true;
			}
		}
		return true;
	}
}
