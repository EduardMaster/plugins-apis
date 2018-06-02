package nobody.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Tphere
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args)
  {
    Player player = (Player)sender;
    if ((command.getName().equalsIgnoreCase("tphere")) && (sender.hasPermission("e.tphere")))
    {
      if (args.length == 0)
      {
        player.sendMessage(ChatColor.RED + "Especifique um Jogador.");
        return true;
      }
      Player target = Bukkit.getServer().getPlayer(args[0]);
      if (target == null)
      {
        player.sendMessage(ChatColor.RED + "Player nao encontrado!");
        return true;
      }
      target.teleport(player.getLocation());
      player.sendMessage(ChatColor.GREEN + "Voce teleportou o player " + "§7" + target.getName() + " §aAte voce!");
      return true;
    }
    return false;
  }
}
