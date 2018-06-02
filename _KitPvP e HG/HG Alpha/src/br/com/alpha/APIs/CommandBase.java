package br.com.alpha.APIs;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

public abstract class CommandBase implements CommandExecutor, Listener {

	public abstract boolean onCommand(CommandSender sender, Command cmd, String label, String[] args);

}
