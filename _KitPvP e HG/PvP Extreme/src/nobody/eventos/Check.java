package nobody.eventos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Check
  implements CommandExecutor
{
  public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args)
  {
    Player p = (Player)Sender;
    if ((Label.equalsIgnoreCase("check")) && 
      ((Sender instanceof Player)))
    {
      if (!p.hasPermission("tk.check"))
      {
        p.sendMessage("§cPermissões");
        return true;
      }
      if (Args.length == 0)
      {
        p.sendMessage("§cUse: /Check [Player]");
        return true;
      }
      Player p2 = Bukkit.getServer().getPlayer(Args[0]);
      if (p2 == null)
      {
        p.sendMessage("§cEsse Player n§o est§ Online!");
        return true;
      }
      p.sendMessage("§6§m-----------------------------------");
      p.sendMessage("              §aPlayer: " + p2.getName());
      p.sendMessage("");
      p.sendMessage("                  §f§lHost");
      p.sendMessage("");
      p.sendMessage("   §eIP: §b" + p2.getAddress().getHostString());
      p.sendMessage("   §eGeoIP: §bhttp://www.geoiptool.com/pt/?ip=" + p2.getAddress().getHostString());
      p.sendMessage("");
      p.sendMessage("");
      p.sendMessage("   §eGamemode: §b" + p2.getGameMode());
      p.sendMessage("   §eModo De Voo: §b" + p2.getAllowFlight());
      p.sendMessage("   §eVida: §b" + p2.getHealthScale());
      p.sendMessage("   §eFome: §b" + p2.getFoodLevel());
      p.sendMessage("");
      p.sendMessage("§6§m------------------------------------");
    }
    return false;
  }
}
