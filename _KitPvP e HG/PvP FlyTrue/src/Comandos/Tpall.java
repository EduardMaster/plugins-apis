package Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Tpall
  implements CommandExecutor
{
  
  @SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    Player p = (Player)sender;
    if ((commandLabel.equalsIgnoreCase("tpall")) && 
      (p.hasPermission("fly.tp")))
    {
      for (Player s : Bukkit.getOnlinePlayers()) {
        s.sendMessage("§c§lFly§7§lTrue §a: §7Todos os jogadores forao puxados ate §a" + p.getName());
      }
      Player[] arrayOfPlayer;
      int j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length;
      for (int i = 0; i < j; i++)
      {
        Player all = arrayOfPlayer[i];
        
        all.teleport(p);
      }
    }
    return false;
  }
}
