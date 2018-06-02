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
    p.sendMessage("§8§l=-=-=-=-=-=§4§lREQUISITOS§8§l=-=-=-=-=-=");
    p.sendMessage("§bRequisitos para a tag §b§lYoutuber §bsao 1K de subs + video");
    p.sendMessage("§6Requisitos para a tag §6§lPRO §6sao 500 de subs + video!");
    return false;
  }
}
