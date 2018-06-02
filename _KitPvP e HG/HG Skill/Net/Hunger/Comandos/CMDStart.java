package Net.Hunger.Comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Net.Hunger.Main;

public class CMDStart implements Listener,CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	if(!(sender instanceof Player)) {
	sender.sendMessage("§7[§a!§7] §aComandos apenas no servidor!");
	return true;
	}
	Player p = (Player)sender;
	if(cmd.getName().equalsIgnoreCase("iniciar") && (p.hasPermission("HungerGames.c.Iniciar"))) {
	if(Main.PreGame) {
	Main.IniciarPartida();
	} else {
	p.sendMessage("§7[§a!§7] Você so pode usar esse comando no PreGame ou não possue permissão!");
	}
	}
	return false;
  }
}