package nobody.comandos;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Gamemode
  implements CommandExecutor, Listener
{
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    Player player = (Player)sender;
    if ((cmd.getName().equalsIgnoreCase("gm")) && (sender.hasPermission("tk.gamemode")))
    {
      if (args.length != 1)
      {
        sender.sendMessage(ChatColor.WHITE + "§oModos:" + ChatColor.AQUA + " Gm 1/0");
        return true;
      }
      if (args.length == 1)
      {
        if (args[0].equalsIgnoreCase("0"))
        {
          player.setGameMode(GameMode.SURVIVAL);
          player.sendMessage(ChatColor.GOLD + "§a§oModo de jogo alterado para:" + ChatColor.AQUA + " §a§lSobrevivencia");
        }
        if (args[0].equalsIgnoreCase("1"))
        {
          player.setGameMode(GameMode.CREATIVE);
          player.sendMessage(ChatColor.GOLD + "§a§oModo de jogo alterado para:" + ChatColor.AQUA + " §lCriativo");
        }
        return true;
      }
    }
    return false;
  }
}
