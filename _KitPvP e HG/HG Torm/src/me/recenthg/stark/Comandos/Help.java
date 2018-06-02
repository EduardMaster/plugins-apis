package me.recenthg.stark.Comandos;

import java.text.SimpleDateFormat;

import me.recent.stark.Main;
import me.recenthg.stark.Tempo.StringTimer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Help implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§8\u276e§2§l!§8\u276f §7Comandos apenas no servidor!");
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("ip")) {
			p.sendMessage("§8\u276e§2§l!§8\u276f §7Endereço do servidor: §6" + Main.instance.getConfig().getString("ip"));
		}
		if ((cmd.getName().equalsIgnoreCase("help"))) {
			if (Main.PreGame) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Informaçoes");
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Estagio - §6PreGame");
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Inicia em - §6" + StringTimer.TimerGame(Main.TimerIniciando));
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Jogadores participando - §6 " + Main.Jogadores.size());
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Endereços do servidor: §6" + Main.instance.getConfig().getString("ip"));
			}
			if (Main.PreInvencibilidade) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Informaçoes");
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Estagio - §6Invencibilidade");
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Invencibilidade - §6" + StringTimer.TimerGame(Main.TimerInvencibilidade));
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Jogadores participando §6" + Main.Jogadores.size());
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Endereço do servidor: §6" + Main.instance.getConfig().getString("ip"));
			}
			if (Main.Partida)  {
				int millis = Main.Andamento * 1000;
				SimpleDateFormat df = new SimpleDateFormat("mm:ss");
				String time = df.format(Integer.valueOf(millis));
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Informaçoes");
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Estagio - §6Andamento");
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Tempo - §6" + time);
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Jogadores participando §6" + Main.Jogadores.size());
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Endereço do servidor: §6" + Main.instance.getConfig().getString("ip"));
			}
		}
		return true;
	}
}