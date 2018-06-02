package me.recenthg.stark.Comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.recent.stark.Main;

public class Tell implements Listener, CommandExecutor {
	
   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
    if(!(sender instanceof Player)) {
    sender.sendMessage("§7Comandos apenas no servidor!");
    return true;
    }
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("tell")) {
      if(Main.Watch.contains(p.getName())) {
      p.sendMessage("§8\u276e§2§l!§8\u276f §7Você não pode falar!");
      return true;
      } else if (args.length == 0) {
          p.sendMessage("§8\u276e§2§l!§8\u276f §7Use:/tell <jogador> <mensagem>");
        } else if (args.length == 1) {
          p.sendMessage("§8\u276e§2§l!§8\u276f §7Use:/tell <jogador> <mensagem>");
        } else if (args.length > 1) {
          String message = "";
          for (int i = 1; i < args.length; i++) {
          message = message + args[i] + " ";
          }
          Player targetPlayer = p.getServer().getPlayer(args[0]);
          if (targetPlayer == null) {
            p.sendMessage("§8\u276e§2§l!§8\u276f §7Este jogador esta offline!");
          } else {
            targetPlayer.sendMessage("" + ChatColor.WHITE + "(De " + p.getDisplayName() + "§f: " + message);
            p.sendMessage(ChatColor.WHITE+ "(Para " + targetPlayer.getDisplayName() + "§f: " + message);
          }
        }
    return true;
   }
 return true;
 }
}