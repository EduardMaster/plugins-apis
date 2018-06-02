package me.recenthg.stark.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.recenthg.stark.Manager.Title;

public class Report
  implements CommandExecutor, Listener
{
  public String[] aliases = { "report" };
  public String description = "Reportar";
  
  @SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    Player p = (Player)sender;
    if (args.length < 2)
    {
      p.sendMessage(ChatColor.RED + "Sintaxe correta: /report <jogador> <motivo>");
    }
    else if (args.length >= 2)
    {
      Player target = Bukkit.getPlayer(args[0]);
      if (target == null)
      {
        p.sendMessage(ChatColor.RED + "Esse jogador não existe!");
      }
      else
      {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < args.length; i++) {
          sb.append(args[i]).append(" ");
        }
        String allArgs = sb.toString().trim();
        
        sender.sendMessage(ChatColor.GREEN + "Seu report foi enviado com sucesso!");
        for (Player staff : Bukkit.getServer().getOnlinePlayers()) {
          if (staff.hasPermission("HungerGames.Report"))
          {
        	  Title.sendTitle(p, "§a! §fREPORT! §a!");
            staff.sendMessage("§a§m--()-----------------------()§a§m--");
            staff.sendMessage("                            » §f§lReport  §6«                             ");
            staff.sendMessage("");
            staff.sendMessage("");
            staff.sendMessage("§4" + sender.getName() + " §7Reportou " + "§5"  + target.getName());
            staff.sendMessage("");
            staff.sendMessage("");
            staff.sendMessage("§7Motivo : §4" + allArgs);
            staff.sendMessage("");
            staff.sendMessage("");
            staff.sendMessage("                            » §f§lReport  §6«                              ");
            staff.sendMessage("§a§m--()-----------------------()§a§m--");
          }
        }
      }
    }
    return true;
  }
}
