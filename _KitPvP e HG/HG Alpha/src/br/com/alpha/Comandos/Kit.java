package br.com.alpha.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.alpha.MCAlpha;
import br.com.alpha.APIs.LoadKits;
import br.com.alpha.ENUMs.KitsEnum;
import br.com.alpha.gamemanagement.GameTime;


public class Kit implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cComando somente para jogadores.");
			return true;
		}
		Player jogador = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("kit")) {
			if (args.length == 0) {
				jogador.sendMessage("§cUse /kit [nome do kit].");
				jogador.sendMessage("§cUse /kits para ver todos os kits.");
				return true;
			}

				if (isInEnum(args[0].toUpperCase())) {
					KitsEnum kit = KitsEnum.valueOf(args[0].toUpperCase());
					String perm = "kit." + kit.getName();
					if (jogador.hasPermission(perm)) {
						
						if (MCAlpha.Status == GameTime.INVENCIBILIDADE) {
							if (KitsEnum.getKit(jogador) != KitsEnum.NONE) {
								jogador.sendMessage("§cVocê já escolheu um kit!");
								return true;
							}
							if (jogador.hasPermission("alpha.kit")) {
								KitsEnum.setKit(jogador, kit);
								jogador.sendMessage("§aVocê escolheu o kit " + kit.getName());
								LoadKits.loadKits(jogador);
							}
								return true;
							
						}
						KitsEnum.setKit(jogador, kit);
						jogador.sendMessage("§aVocê escolheu o kit " + kit.getName() + "§a.");
					} else {
						jogador.sendMessage("§cSem permissao para o kit.");
					}
				} else {
					jogador.sendMessage("§cEste kit não existe.");
					return true;
				}
			}
		
		return false;
	}

	public <E extends Enum<E>> boolean isInEnum(String value) {
		for (KitsEnum e : KitsEnum.class.getEnumConstants()) {
			if (e.name().equals(value)) {
				return true;
			}
		}
		return false;
	}

}
