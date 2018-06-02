package Zey.PvP.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import Zey.PvP.Main.Main;

public class AplicarCommand implements CommandExecutor {

	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		
		Player player = (Player)Sender;
		
		if(Cmd.getName().equalsIgnoreCase("aplicar")) {
			player.sendMessage("§7 ");
			player.sendMessage("§7 ");
			player.sendMessage("§7 ");
			player.sendMessage("§7 ");
			player.sendMessage(String.valueOf(Main.prefix) + " §7» §aAqui está os links dos cargos, disponiveis.");
            player.sendMessage("§7 ");
            player.sendMessage(String.valueOf(Main.prefix) + " §7» §7Link §d[HELPER]§7: http://lxdv.gq/formhelper ");
            player.sendMessage("§7 ");
            player.sendMessage(String.valueOf(Main.prefix) + " §7» §7Link §d[TRIAL]§7: http://lxdv.gq/formtrial ");
            player.sendMessage("§7 ");
            player.sendMessage(String.valueOf(Main.prefix) + " §7» §7Link §2[BUILDER]§7: http://lxdv.gq/formbuilder ");
            player.sendMessage("§7 ");
		}
		return false;
	}
}
