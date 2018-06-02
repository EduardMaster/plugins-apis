package Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class ajuda
  implements Listener, CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("ajuda")) {};
    p.sendMessage(" ");
    p.sendMessage("§aInformacoes do Servidor : §c§lFly§7§lTrue");
    p.sendMessage(" ");
    p.sendMessage("§9§l§m---------------");
    p.sendMessage("§bYT: §c1k Inscritos e um Video ou mais video");
    p.sendMessage("§ePRO: §c500 Inscritos e um Video ou mais video");
    p.sendMessage("§9§l§m---------------");
    p.sendMessage(" ");
    p.sendMessage("§9§l§m---------------");
    p.sendMessage("§bFormulario para §dTrialMod");
    p.sendMessage("§7http://§c§lFly§7§lTrue§7.com.br");
    p.sendMessage("§9§l§m---------------");
    return false;
  }
}
