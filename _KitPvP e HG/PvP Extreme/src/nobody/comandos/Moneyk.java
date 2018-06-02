package nobody.comandos;

import nobody.eventos.Money;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Moneyk
  implements CommandExecutor
{
  public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args)
  {
    Player p = (Player)Sender;
    if ((Label.equalsIgnoreCase("money")) && 
      ((Sender instanceof Player)))
    {
      if (!p.hasPermission("kit.pvp"))
      {
        p.sendMessage("§aSem Permissões");
        return true;
      }
      if (Args.length == 0)
      {
        p.sendMessage("§cUse: /money [Player]");
        return true;
      }
      Player p2 = Bukkit.getServer().getPlayer(Args[0]);
      if (p2 == null)
      {
        p.sendMessage("§cEsse Player n§o está Online!");
        return true;
      }
      p.sendMessage("§6§m-----------------------------------");
      p.sendMessage("         §aPlayer: " + p2.getName());
      p.sendMessage("§cMoney: " + Money.getMoney(p2));
      p.sendMessage("§6§m-----------------------------------");
    }
    return false;
  }
}
