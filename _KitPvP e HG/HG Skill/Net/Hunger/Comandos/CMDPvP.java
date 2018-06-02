package Net.Hunger.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class CMDPvP implements Listener, CommandExecutor {

	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
	     sender.sendMessage("§7[§a!§7] §aComandos apenas no servidor!");
	     return true;
	    }
	    Player p = (Player)sender;
	    if (cmd.getName().equalsIgnoreCase("pvp")) {
	    if(p.hasPermission("HungerGames.c.pvp")) {
	    if (args.length == 0) {
	    p.sendMessage("§7[§a?§7] " + "Use /pvp: (True | False)");
	    return true;
	    }
        if((args[0].equalsIgnoreCase("true"))) {
        Bukkit.getServer().getWorld("world").setPVP(true);
        Bukkit.broadcastMessage("§7[§a!§7] §a§lPvP GLOBAL ATIVADO!");
        Bukkit.getLogger().info(p.getName() + " Ativou o pvp global!");
       }
       if ((args[0].equalsIgnoreCase("false"))) {
       Bukkit.getServer().getWorld("world").setPVP(false);
       Bukkit.broadcastMessage("§7[§a!§7] §a§lPvP GLOBAL DESATIVADO!");
       Bukkit.getLogger().info(p.getName() + " Desativou pvp global!");
      }
	  } else {
	   p.sendMessage("§7[§a?§7] §7Você não possue permissão para isso!");
	    return true;
	  }
     }
		return true;
	}
   }