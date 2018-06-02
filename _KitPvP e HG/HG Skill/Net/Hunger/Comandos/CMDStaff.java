package Net.Hunger.Comandos;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class CMDStaff implements CommandExecutor, Listener {
	
  public static ArrayList<String> staffchat = new ArrayList<String>();

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {   
  if(!(sender instanceof Player)) {
  sender.sendMessage("§7[§a!§7] §aComandos apenas no servidor!");
  return true;
  }
  Player p = (Player)sender;
  if ((cmd.getName().equalsIgnoreCase("sc"))) {
  if((p.hasPermission("HungerGames.c.admin"))) {
  if (args.length == 0) {
  p.sendMessage("§7[§a!§7] Para entrar no chat use /sc entrar");
  p.sendMessage("§7[§a!§7] Para sair do chat use /sc sair");
  return true;
  }
  } else {
  p.sendMessage("§7[§a?§7] Você não possue permissão para isso!");
  return true;
  }
  if (args[0].equalsIgnoreCase("entrar")) {
  staffchat.add(p.getName());
  p.sendMessage("§7[§a!§7] Você entrou no StaffChat!");
  } else if ((args[0].equalsIgnoreCase("sair")) && (staffchat.contains(p.getName()))) {
  p.sendMessage("§7[§a!§7] Você saiu do StaffChat!");
  staffchat.remove(p.getName());
  }
  }
  return false;
  }
}