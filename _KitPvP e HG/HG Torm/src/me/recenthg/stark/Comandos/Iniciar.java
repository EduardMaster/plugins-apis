package me.recenthg.stark.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.recent.stark.Main;

public class Iniciar implements Listener,CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	if(!(sender instanceof Player)) {
	sender.sendMessage("§8\u276e§2§l!§8\u276f §7Comandos apenas no servidor!");
	return true;
	}
	Player p = (Player)sender;
	if(cmd.getName().equalsIgnoreCase("iniciar") && (p.hasPermission("HungerGames.c.Iniciar"))) {
	if(Main.PreGame) {
	Main.IniciarPartida();
	} else {
	p.sendMessage("§8\u276e§2§l!§8\u276f §7Você so pode usar Isso No §aPreGame!");
	}
	}
	return false;
  }
}