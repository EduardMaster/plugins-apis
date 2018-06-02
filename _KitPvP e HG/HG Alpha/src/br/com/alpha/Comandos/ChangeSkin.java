package br.com.alpha.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.alpha.APIs.CommandBase;
import br.com.alpha.APIs.FakePlayerUtils;

public class ChangeSkin extends CommandBase {

	@SuppressWarnings({ "deprecation", "unused" })
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("changeskin")) {

			if (!(sender instanceof Player))
				return true;

			Player p = (Player) sender;
			
			if (args.length == 0) {
				p.sendMessage("§cSintaxe incorreta. Use: /changeskin <Nick>");
				return true;
			}

			if (p.hasPermission("cmd.changeskin")) {
				
				String skin = args[0];
				FakePlayerUtils.changePlayerSkin(p, args[0], Bukkit.getOfflinePlayer(args[0]).getUniqueId());
				p.sendMessage("§aVoce mudou sua skin para a skin do jogador §e" + args[0]);
				return true;
			}
			p.sendMessage("§cVocê não tem permissão para usar o CHANGESKIN");
		}

		return false;
	}

}
