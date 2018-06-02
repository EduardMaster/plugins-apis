package Net.Hunger.Comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Net.Hunger.Main;

public class CMDTell implements Listener, CommandExecutor {
	
   @SuppressWarnings("deprecation")
   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
    if(!(sender instanceof Player)) {
    sender.sendMessage("§7[§a!§7] §bComandos apenas no servidor!");
    return true;
    }
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("tell")) {
      if(Main.Watch.contains(p.getName())) {
      p.sendMessage("§7[§a?§7] Você não pode falar!");
      return true;
      } else if (args.length == 0) {
          p.sendMessage("§7[§a?§7] Use:/tell <jogador> <mensagem>");
        } else if (args.length == 1) {
          p.sendMessage("§7[§a?§7] Use:/tell <jogador> <mensagem>");
        } else if (args.length > 1) {
          String message = "";
          for (int i = 1; i < args.length; i++) {
          message = message + args[i] + " ";
          }
          Player targetPlayer = p.getServer().getPlayer(args[0]);
          if (targetPlayer == null) {
            p.sendMessage("§7[§a?§7] Este jogador esta offline!");
          } else {
            targetPlayer.sendMessage("§7[§a?§7] " + ChatColor.YELLOW + "(De " + p.getDisplayName() + "§e)§f: " + message);
            p.sendMessage(ChatColor.YELLOW + "(Para " + targetPlayer.getDisplayName() + "§e)§f: " + message);
          }
        }
    return true;
   }
 return true;
 }
}