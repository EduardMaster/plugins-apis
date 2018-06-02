package XP;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.sk89q.minecraft.util.commands.Command;

import XP.XpM;

public class VerXp
  implements Listener, CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String comando, String[] args)
  {
    Player p = (Player)sender;
    if (comando.equalsIgnoreCase("coins")) {
      p.sendMessage("§F§LO Seu Coins E De §b§l" + XpM.getPlayerMoney(p));
    }
    return false;
  }

@Override
public boolean onCommand(CommandSender arg0, org.bukkit.command.Command arg1, String arg2, String[] arg3) {
	// TODO Auto-generated method stub
	return false;
}
}
