package br.com.alpha.Comandos;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.alpha.MCAlpha;
import br.com.alpha.APIs.BukkitNameFetcher;
import br.com.alpha.APIs.CommandBase;
import br.com.alpha.APIs.FakePlayerUtils;
import br.com.alpha.APIs.PlayerAPI;

public class TFake extends CommandBase {

	@SuppressWarnings("unused")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		File configuracao = new File(MCAlpha.mcAlpha.getDataFolder(), "config.yml");

		if (cmd.getName().equalsIgnoreCase("tfake")) {
			Player p = (Player) sender;
			BukkitNameFetcher fetcher = new BukkitNameFetcher();

			if (p.hasPermission("cmd.tfake")) {
				p.sendMessage("§aVocê resetou seu nick");
				FakePlayerUtils.changePlayerName(p, PlayerAPI.getInstance().getOriginalName(p));
				FakePlayerUtils.changePlayerSkin(p, PlayerAPI.getInstance().getOriginalName(p),
						Bukkit.getPlayer(PlayerAPI.getInstance().getOriginalName(p)).getUniqueId());
				p.setDisplayName(PlayerAPI.getInstance().getOriginalName(p));
				p.setPlayerListName(PlayerAPI.getInstance().getOriginalName(p));
			} else {
				p.sendMessage("§cVocê não tem permissão para usar o TFAKE");
			}
		}
		return false;
	}
}