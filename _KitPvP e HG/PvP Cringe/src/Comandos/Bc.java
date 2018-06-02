package Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Bc
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args)
  {
    if ((commandLabel.equalsIgnoreCase("bc")) && (sender.hasPermission("cmd.admin")))
    {
      if (args.length >= 1)
      {
        String bcast = "";
        for (int x = 0; x < args.length; x++) {
          bcast = bcast + args[x] + " ";
        }
        bcast = ChatColor.translateAlternateColorCodes('&', bcast);
        Bukkit.broadcastMessage("");
        Bukkit.broadcastMessage("§4§lBROADCAST §f"+ bcast);
        Bukkit.broadcastMessage("");
      }
      else
      {
        sender.sendMessage("§3§lBROADCAST §fUse: /bc <mensagem>");
      }
    }
    else {
      sender.sendMessage("§3§lBROADCAST §fVoce Nao tem §c§lPERMISSAO §fPara isso.");
    }
    return false;
  }
}