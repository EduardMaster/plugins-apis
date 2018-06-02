package Net.Hunger.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Net.Hunger.Manager.Habilidade;

public class CMDKitDisableAll implements Listener, CommandExecutor {

	@Override
	  public final boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
	      sender.sendMessage("§7[§a!§7] §aComandos apenas no servidor!");
		  return true;
		  }
		Player p = (Player)sender;
	    if ((cmd.getName().equalsIgnoreCase("toggle"))) {
	        if(p.hasPermission("HungerGames.c.Toggle")) {
	         if (args.length == 0) {
	           sender.sendMessage("§7[§a!§7] Você deve usar:");
	           sender.sendMessage("§7[§a!§7] /Toggle [§aOn§7|§aOff§7]");
	           return true;
	         } else if (args[0].equalsIgnoreCase("on")) {
	           sender.sendMessage("§7[§a!§7] Você ativou os kits!");
	           Bukkit.broadcastMessage("§7[§a§7] §a§lOS KITS FORAM ATIVOS!");
	           Bukkit.broadcast(p.getName() + ChatColor.GRAY + " Ativou os kits!", "hg.admin");
	           CMDKitDisable.KitsDisable = false;
	         } else if (args[0].equalsIgnoreCase("off")) {
	            sender.sendMessage("§7[§a!§7] Você desativou os kits!");
	            Bukkit.broadcastMessage("§7[§a§7] §a§lOS KITS FORAM DESATIVADOS!");
	            Bukkit.broadcast(p.getName() + ChatColor.GRAY + " Desativou os kits!", "hg.admin");
	          CMDKitDisable.KitsDisable = true;
	          for(Player Jogadores : Bukkit.getOnlinePlayers()) {
	       	Habilidade.removeAbility(Jogadores);
	          }
	         } else {
	          sender.sendMessage("§7[§a!§7] Você deve usar:");
	          sender.sendMessage("§7[§a!§7] /Toggle [§aOn§7|§aOff§7]");
	        }
	       } else {
	       p.sendMessage("§7[§a?§7] " + "Você não possue permissão para isso!");
	       return true;
	       }
	    }
		return true;
	}
}
