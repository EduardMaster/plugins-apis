package nobody.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gratis
  implements CommandExecutor
{
  public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args)
  {
    Player p = (Player)Sender;
    if ((Label.equalsIgnoreCase("aplicar")) && 
      ((Sender instanceof Player)))
    {
      {
        p.sendMessage("§cFormulário no Link §f: \n§f> §7pagebin.com/http://pagebin.com/h3PukV2y");
        return true;
      }
    
    }
	return false;
  }
}
