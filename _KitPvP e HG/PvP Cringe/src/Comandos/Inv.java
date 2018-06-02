package Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Inv
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage("§cComando apenas para players");
      return true;
    }
    Player p = (Player)sender;
    if (!p.hasPermission("cmd.admin"))
    {
      p.sendMessage("§6§lINVENTARIO §fVoce nao tem permissao a este comando");
      return true;
    }
    if (args.length == 0)
    {
      p.sendMessage("§6§lINVENTARIO §fPara abrir um inventario use: /inv <nick>");
    }
    else
    {
      Player t = Bukkit.getPlayer(args[0]);
      if (t == null)
      {
        p.sendMessage("§cEste jogador nao existe ou esta offline !");
        return true;
      }
      p.openInventory(t.getInventory());
      p.sendMessage("§6§lINVENTARIO §fVendo o inventario de: §3§l" + t.getDisplayName());
    }
    return false;
  }
}
