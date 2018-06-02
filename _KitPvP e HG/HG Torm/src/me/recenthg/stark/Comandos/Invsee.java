package me.recenthg.stark.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.recenthg.stark.Manager.Title;

public class Invsee implements CommandExecutor, Listener {

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§8\u276e§2§l!§8\u276f §7Comandos apenas no servidor!");
			return true;
		}
		Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("invis") && (player.hasPermission("HungerGames.c.invis"))) {
			player.sendMessage("§8\u276e§2§l!§8\u276f §7Você ficou §6Invisivel");
			  Title.sendTitle(player, "§a! §fVoce Ficou Invisivel §a!");
			for (Player ps : Bukkit.getOnlinePlayers()) {
				ps.hidePlayer(player);
			}
		}
		return false;
	}
}