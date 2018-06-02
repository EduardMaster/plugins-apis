package Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Youtuber
  implements Listener, CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("youtuber")) {}
    p.sendMessage("§a§lREQUISITOS §fSolicitacao em processo...");
    p.sendMessage("                                                        ");
    p.sendMessage("§a§lREQUISITOS §fSolicitacao em processo... (100%)");
    p.sendMessage("                                                        ");
    p.sendMessage("§a§lREQUISITOS §fSolicitacao §a§lCOMPLETA!");
    p.sendMessage("                                                        ");
    p.sendMessage("§a§lREQUISITOS §fTag §b§lYOUTUBER:");
    p.sendMessage("                                                        ");
    p.sendMessage("§a§lREQUISITOS §f1000 Inscritos ");
    p.sendMessage("§a§lREQUISITOS §fFeedBack Bom");
    p.sendMessage("§a§lREQUISITOS §fVideo no servidor");
    p.sendMessage("                                                        ");
    p.sendMessage("§a§lREQUISITOS §fTag §6§lPRO:");
    p.sendMessage("                                                        ");
    p.sendMessage("§a§lREQUISITOS §f500 Inscritos");
    p.sendMessage("§a§lREQUISITOS §fVideo no servidor");
    p.sendMessage("§a§lREQUISITOS §fFeedBack Bom");
    return false;
  }
}
