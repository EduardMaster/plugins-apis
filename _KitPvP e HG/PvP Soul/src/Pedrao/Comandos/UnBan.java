package Pedrao.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

import Pedrao.Main;

public class UnBan
  implements CommandExecutor, Listener
{
  public UnBan(Main main) {
	}

@SuppressWarnings("deprecation")
public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args)
  {
    if (Cmd.getName().equalsIgnoreCase("unban"))
    {
      if (!Sender.hasPermission("kitpvp.unban"))
      {
        Sender.sendMessage(" §e>> §cSem Permissão!");
        return true;
      }
      if (Args.length == 0)
      {
        Sender.sendMessage("§cUse: /unban <Jogador>");
        return true;
      }
      OfflinePlayer t = Bukkit.getOfflinePlayer(Args[0]);
      if (!t.isBanned())
      {
        Sender.sendMessage("§7O Jogador: §c" + t.getName() + " §7Não esta banido!");
        return true;
      }
      if (t.isBanned())
      {
        t.setBanned(false);
        Bukkit.broadcastMessage("§7O Jogador: §c" + t.getName() + " §7Foi desbanido");
      }
    }
    return false;
  }
}
