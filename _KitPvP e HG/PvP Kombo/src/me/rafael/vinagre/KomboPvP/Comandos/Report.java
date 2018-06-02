package me.rafael.vinagre.KomboPvP.Comandos;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.rafael.vinagre.KomboPvP.Main;

public class Report
  implements CommandExecutor, Listener
{
  public Main plugin;
  
  public Report(Main main)
  {
    this.plugin = main;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("report"))
    {
      if (args.length == 0) {
        sender.sendMessage(ChatColor.RED + "[!] Use: " + ChatColor.AQUA + "/report (Nick ) (Denuncia)");
      }
      if (args.length > 0)
      {
        sender.sendMessage(ChatColor.GREEN + "Report Enviado!");
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
          string.append(args[i] + " ");
        }
        String mensagem = string.toString();
        Player[] arrayOfPlayer;
        int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
        for (int i = 0; i < j; i++)
        {
          Player staff = arrayOfPlayer[i];
          if (staff.hasPermission("kitpvp.report"))
          {
        	staff.playSound(staff.getLocation(), Sound.ANVIL_USE, 15.0F, 1.0F);
            staff.sendMessage("                 §b§l[§4Hack Report§b§l]");
            staff.sendMessage(ChatColor.GRAY + "§l=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            staff.sendMessage(ChatColor.LIGHT_PURPLE + "REPORTER: " + ChatColor.AQUA + sender.getName());
            staff.sendMessage(ChatColor.LIGHT_PURPLE + "MOTIVO: " + ChatColor.AQUA + mensagem);
            staff.sendMessage(ChatColor.GRAY + "§l=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
          }
        }
      }
    }
    return false;
  }
}
