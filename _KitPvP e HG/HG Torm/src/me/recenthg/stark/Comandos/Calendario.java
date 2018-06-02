package me.recenthg.stark.Comandos;

import java.util.Calendar;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.recenthg.stark.Manager.Title;

public class Calendario implements CommandExecutor {

 @Override
 public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
  if (!(sender instanceof Player)) {
   sender.sendMessage("§cApenas jogadores!");
   return true;
  }

  if (cmd.getName().equalsIgnoreCase("horas")) {

   Calendar calendar1 = Calendar.getInstance();

   int horas = calendar1.get(Calendar.HOUR_OF_DAY);
   int minutos = calendar1.get(Calendar.MINUTE);
   int segundos = calendar1.get(Calendar.SECOND);

   Player p = (Player) sender;

   p.sendMessage("§8\u276e§4§l!§8\u276f §7Informa a hora certa! ");
   p.sendMessage(" ");
   p.sendMessage(" ");
   p.sendMessage(" ");
   p.sendMessage("§7Horas §e» " + horas + "§7h §e" + minutos + "§7m §e" + segundos + "§7s");
   p.sendMessage(" ");
   p.sendMessage(" ");
   p.sendMessage(" ");
   p.sendMessage("§8\u276e§4§l!§8\u276f §7Essa é a hora certa! ");
   
   Title.sendTitle(p, "§7Horas §e» " + horas + "§7h §e" + minutos + "§7m §e" + segundos + "§7s");

  }

  return false;
 }

}