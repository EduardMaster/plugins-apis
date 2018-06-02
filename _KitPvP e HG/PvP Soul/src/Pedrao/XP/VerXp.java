package Pedrao.XP;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Pedrao.Main;
import Pedrao.XP.XpM;

public class VerXp
  implements Listener, CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String comando, String[] args)
  {
    Player p = (Player)sender;
    if (comando.equalsIgnoreCase("xp")) {
      p.sendMessage(Main.prefix + " §F§LO Seu Xp E De §b§l" + XpM.getPlayerMoney(p));
    }
    return false;
  }
}
