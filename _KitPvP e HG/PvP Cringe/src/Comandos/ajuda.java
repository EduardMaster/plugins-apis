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
    p.sendMessage("§a§6Cringed§7Kits ➜ §eInformaçoes");
    p.sendMessage(" ");
    p.sendMessage("§9§l§m---------------");
    p.sendMessage("§b§lYOUTUBER: §c1k Inscritos e um Video ou mais video");
    p.sendMessage("§6§lPRO: §c500 Inscritos e um Video ou mais video");
    p.sendMessage("§9§l§m---------------");
    p.sendMessage(" ");
    p.sendMessage("§9§l§m---------------");
    p.sendMessage("§bFormulario para §dTrialMod");
    p.sendMessage("§cFormulario Desativado temporariamente.");
    p.sendMessage("§9§l§m---------------");
    return false;
  }
}
