package me.recenthg.stark.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.recent.stark.Strings;

public class Inv implements Listener, CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
	if(!(sender instanceof Player)) {
	sender.sendMessage("§8\u276e§2§l!§8\u276f §7Comandos apenas no servidor!");
	return true;
	}
	Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("inv")) { 
    if (sender.hasPermission("HungerGames.c.inv")) {
    sender.sendMessage("§8\u276e§2§l!§8\u276f §7Escolha o nome do jogador!");
    if (args.length > 0) {
    Player player = Bukkit.getPlayer(args[0]);
    if (player == null) {
    sender.sendMessage("§8\u276e§2§l!§8\u276f §7O jogador esta offline");
    return true;
    }
    sender.sendMessage("§8\u276e§2§l!§8\u276f §7Voce abriu o inventario do jogador §6" + player.getName());
    p.openInventory(player.getInventory());
    }
    } else {
    	p.sendMessage(Strings.semperm);
    }
    return true;
   }
	return true;
  }
 }