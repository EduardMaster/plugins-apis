package br.com.alpha.Comandos;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.alpha.MCAlpha;
import br.com.alpha.APIs.CommandBase;
import br.com.alpha.APIs.FakePlayerUtils;
import br.com.alpha.APIs.RandomFakes;

public class Fake extends CommandBase {

	@SuppressWarnings({ "unused", "static-access" })
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		File configuracao = new File(MCAlpha.mcAlpha.getDataFolder(), "config.yml");

		if (cmd.getName().equalsIgnoreCase("fake")) {
			Player p = (Player) sender;

			if (args.length == 0) {
				if (p.hasPermission("cmd.fake")) {
					RandomFakes rndm = new RandomFakes();

					String nick = rndm.getFake();
					p.setDisplayName(nick);
					p.setPlayerListName(nick);
					p.sendMessage("§aVocê alterou seu nick para: §e" + nick);
					FakePlayerUtils.changePlayerName(p, nick);
					FakePlayerUtils.changePlayerSkin(p, nick, Bukkit.getPlayer(nick).getUniqueId());
				} else {
					p.sendMessage("§cVocê não tem permissão para usar o FAKE");
				}
			} else {
				
				if (args[0].length() > 15) {
					p.sendMessage("§cVocê não pode utilizar um nick com mais de 16 caracteres");
					return true;
				}

				if (p.hasPermission("cmd.fake")) {
					String nick = args[0].replace("&", "§");
					p.setDisplayName(nick);
					p.setPlayerListName(nick);
					p.sendMessage("§aVocê alterou seu nick para: §e" + nick);
					FakePlayerUtils.changePlayerName(p, nick);
					FakePlayerUtils.changePlayerSkin(p, nick, Bukkit.getPlayer(nick).getUniqueId());
				} else {
					p.sendMessage("§cVocê não tem permissão para usar o FAKE");
				}
			}
		}
		return false;
	}

}
