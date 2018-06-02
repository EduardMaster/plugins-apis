package me.recenthg.stark.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.recent.stark.Main;

public class Who implements Listener,CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3) {
	if(!(sender instanceof Player)) {
    sender.sendMessage("§aComandos apenas no servidor!");
    return true;
	}
	if(cmd.getName().equalsIgnoreCase("jogadores")) {
	sender.sendMessage("§8\u276e§2§l!§8\u276f §7Lista de jogadores: §6" + Main.Jogadores);
	}
    return true;
	}

}
