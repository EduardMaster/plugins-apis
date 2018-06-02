package me.recenthg.stark.Comandos;


import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.recent.stark.Strings;
import me.recenthg.stark.Manager.Title;

public class Gamemode implements CommandExecutor, Listener {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("gm")) {
			if ((sender instanceof ConsoleCommandSender)) {
				System.out.println("§8\u276e§2§l!§8\u276f §7Console nao pode usar esse comando");
				return true;
			}
			Player p = (Player) sender;
			if (args.length == 0) {
				p.sendMessage("§8\u276e§e§l!§8\u276f §7Use: /gm 0 | 1 ");
			} else if (args.length == 1) {
				if ((p.hasPermission("HungerGames.c.gm")) || (p.isOp())) {
					if ((args[0].equalsIgnoreCase("1")) || (args[0].equalsIgnoreCase("criativo"))) {
						p.setGameMode(GameMode.CREATIVE);
						p.sendMessage("§8\u276e§2§l!§8\u276f §7Voce Entrou No Modo Criativo");
						  Title.sendTitle(p, "§a! §fModo Criativo §a!");
					} else if ((args[0].equalsIgnoreCase("0")) || (args[0].equalsIgnoreCase("sobrevivencia"))) {
						p.setGameMode(GameMode.SURVIVAL);
						p.sendMessage("§8\u276e§2§l!§8\u276f §7Voce Entrou No Modo Sobrevivencia");
						  Title.sendTitle(p, "§a! §fModo Sobrevivencia §a!");
					} else {
						p.sendMessage("§8\u276e§2§l!§8\u276f §7Modo de jogo nao encontrado!");
					}
				} else {
					p.sendMessage(Strings.semperm);
				}
			}
		}
		return false;
	}
}
