package Net.Hunger.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Net.Hunger.Main;
import Net.Hunger.Feast.FeastManager;

public class CMDFeast implements Listener, CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
	if(!(sender instanceof Player)) {
	sender.sendMessage("§7[§a!§7] §bComandos apenas no servidor!");
	return true;
	}
	Player p = (Player)sender;
	if(cmd.getName().equalsIgnoreCase("feast") && (Main.Andamento >= 15)) {
    p.setCompassTarget(FeastManager.getMainBlock().getLocation());
	p.sendMessage("§7[§a!§7] Bussola apontando para o §aFeast!");
	} else {
	p.sendMessage("§7[§a?§7] O Feast ainda não foi anunciado!");
	}
	return true;
	}
}
