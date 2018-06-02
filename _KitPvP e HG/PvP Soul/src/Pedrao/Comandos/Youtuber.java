package Pedrao.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Youtuber
  implements CommandExecutor
{
  public boolean onCommand(CommandSender Sender, Command cmd, String string, String[] args)
  {
    Player p = (Player)Sender;
    if (cmd.getName().equalsIgnoreCase("youtuber"))
    {
      p.sendMessage("§8-=-=-=-=-=-=-=-=-=-=-=-");
      p.sendMessage("-§6     Tag Pro ");
      p.sendMessage("-§6     100 Inscritos");
      p.sendMessage("-§6     +1 Video!");
      p.sendMessage("§8-=-=-=-=-=-=-==-=-=-=-=-");
      p.sendMessage("-§b     Tag Youtuber ");
      p.sendMessage("-§b     300 Inscritos");
      p.sendMessage("-§b     +1 Video!");
      p.sendMessage("§8-=-=-=-=-=-=-=-=-=-=-=-");
    }
    return false;
  }
}
