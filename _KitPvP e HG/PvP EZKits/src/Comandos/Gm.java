package Comandos;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gm
  implements CommandExecutor
{
  Gm main;
  
  @SuppressWarnings("unused")
public Gm()
  {
    Gm plugin = this.main;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    Player player = (Player)sender;
    if ((cmd.getName().equalsIgnoreCase("gm")) && (sender.hasPermission("ezkits.admin")))
    {
      if (args.length != 1)
      {
        player.sendMessage(" §6§lEZKits  §f §7Use /Gm (0)(1)(2)");
        return true;
      }
      if (args.length == 1)
      {
        if (args[0].equalsIgnoreCase("0"))
        {
          player.setGameMode(GameMode.SURVIVAL);
          player.sendMessage(" §6§lEZKits  §f §aGamemode Atualizado!!");
        }
        if (args[0].equalsIgnoreCase("1"))
        {
          player.setGameMode(GameMode.CREATIVE);
          player.sendMessage(" §6§lEZKits  §f §aGamemode Atualizado!");
        }
        if (args[0].equalsIgnoreCase("2"))
        {
          player.setGameMode(GameMode.ADVENTURE);
          player.sendMessage("§6§lEZKits §aGamemode Atualizado!");
        }
        return true;
      }
    }
    return false;
  }
}
 