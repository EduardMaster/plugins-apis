package Net.Hunger.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDChat implements CommandExecutor {

public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	  if(!(sender instanceof Player )) {
	  sender.sendMessage("§7[§b!§7] §bComandos apenas no servidor!");
	  return true;
	  }	  
	 Player p = (Player)sender;
	 if (cmd.getName().equalsIgnoreCase("chat")) {
	      if (sender.hasPermission("hg.c.chat")) {
	        if (args.length > 0) {
	          if (args.length == 1) {
	            if (args[0].equalsIgnoreCase("false")) {
	              Bukkit.broadcastMessage("§7[§a!§7] " + p.getName() + ChatColor.GRAY + "" + ChatColor.BOLD + " DESATIVOU O CHAT!");
	              Bukkit.getLogger().info("Desativou o chat");
	              for(Player p1 : Bukkit.getOnlinePlayers()) {
	              if(!p1.hasPermission("hg.c.chat")) {
	              CMDListener.chat.add(p1);
	              }
	              }
	            } else if (args[0].equalsIgnoreCase("true")) {
		          Bukkit.broadcastMessage("§7[§a!§7] " + p.getName() + ChatColor.GRAY + "" + ChatColor.BOLD + " ATIVOU O CHAT!");
	              Bukkit.getLogger().info(p.getName() + " Ativou o chat");
	              for(Player p1 : Bukkit.getOnlinePlayers()) {
	              if(CMDListener.chat.contains(p1)) {
	              CMDListener.chat.remove(p1);
	              }
	              }
	            }
	          } else {
	            p.sendMessage("§7[§a?§7] Use: /chat (true | false)");
	          }
	        } else {
	          p.sendMessage("§7[§a?§7] Use: /chat (true | false)");
	        }
	      } else {
	      p.sendMessage("§7[§a?§7] " + "Você não possue permissão para isso!");
	      return true;
	      }
	      return true;
	    }
	return false;

 }
}