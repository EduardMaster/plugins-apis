package Net.Hunger.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class CMDVisInvis implements Listener, CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3) {
    if(!(sender instanceof Player)) {
      sender.sendMessage("§7[§a!§7] §aComandos apenas no servidor!");
      return true;
    }
    Player p = (Player)sender;
    if(cmd.getName().equalsIgnoreCase("vis") && (p.hasPermission("HungerGames.c.admin"))) {
     p.sendMessage("§7[§a!§7] Você ficou §a" + "Visivel");
      for(Player pl : Bukkit.getOnlinePlayers()) {
      pl.showPlayer(p);
     }
    } else {
     p.sendMessage("§7[§a?§7] Você não possue permissão para isso!");
     return true;
    }
	return true;
 }
}