package me.recenthg.stark.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.recent.stark.Main;
import me.recenthg.stark.Feast.Feaste;

public class Feast implements Listener, CommandExecutor {

	public static final String Material = null;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
	if(!(sender instanceof Player)) {
	sender.sendMessage("§bComandos apenas no servidor!");
	return true;
	}
	Player p = (Player)sender;
	if(cmd.getName().equalsIgnoreCase("feast") && (Main.Andamento >= 15)) {
    p.setCompassTarget(Feaste.getMainBlock().getLocation());
	p.sendMessage("§8\u276e§2§l!§8\u276f §7Bussola Apontando Para O §aFeast!");
	} else {
	p.sendMessage("§8\u276e§2§l!§8\u276f §7O Feast ainda não foi Anunciado!");
	}
	return true;
	}
}
