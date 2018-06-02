package Net.Hunger.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Net.Hunger.Main;

public class CMDWho implements Listener,CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3) {
	if(!(sender instanceof Player)) {
    sender.sendMessage("§7[§a!§7] §aComandos apenas no servidor!");
    return true;
	}
	if(cmd.getName().equalsIgnoreCase("who")) {
	sender.sendMessage("§7[§a!§7] Lista de jogadores: §f" + Main.Jogadores);
	}
    return true;
	}

}
