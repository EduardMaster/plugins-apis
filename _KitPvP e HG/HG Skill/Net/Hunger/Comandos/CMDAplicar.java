package Net.Hunger.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Net.Hunger.Main;

public class CMDAplicar implements Listener, CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3) {
		if(!(sender instanceof Player)) {
		    sender.sendMessage("§7[§a!§7] §aComandos apenas no servidor!");
		    return true;
		}
		Player p = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("aplicar")) {
		p.sendMessage("§7[§a!§7] Você deve aplicar no site: §a" + Main.instance.getConfig().getString("aplicar"));
		}
		return false;
	}

}
