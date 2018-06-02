package me.recenthg.stark.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.recent.stark.Strings;

public class VisInvis implements Listener, CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3) {
    if(!(sender instanceof Player)) {
      sender.sendMessage("§8\u276e§2§l!§8\u276f §7Comandos apenas no servidor!");
      return true;
    }
    Player p = (Player)sender;
    if(cmd.getName().equalsIgnoreCase("vis") && (p.hasPermission("HungerGames.c.admin"))) {
     p.sendMessage("§8\u276e§2§l!§8\u276f §7Você ficou §6Visivel");
      for(Player pl : Bukkit.getOnlinePlayers()) {
      pl.showPlayer(p);
     }
    } else {
    	p.sendMessage(Strings.semperm);
     return true;
    }
	return true;
 }
}