package br.com.alpha.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.alpha.MCAlpha;
import br.com.alpha.APIs.APIClass;

public class Help implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("help") && sender instanceof Player) {
			Player p = (Player) sender;

			p.sendMessage("§7§lINFORMAÇOES:");
			p.sendMessage("§eEstágio: §f" + APIClass.returnFormatted(MCAlpha.Status.toString()));

			p.sendMessage("§eTempo: §f" + APIClass.formatDifferenceStr(MCAlpha.Time * 1000));
			p.sendMessage("§eJogadores participando do game: §f" + APIClass.JogadoresInGame.size());
			return false;
		}
		return false;

	}
}