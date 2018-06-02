package nobody.eventos;



import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Broadcast
  implements CommandExecutor
{
  @SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args)
  {
    Player player = (Player)sender;
    if (((commandLabel.equalsIgnoreCase("bc")) || (commandLabel.equalsIgnoreCase("broadcast"))) && (player.hasPermission("fire.bc"))) {
      if (args.length >= 1)
      {
        String bcast = "";
        for (int x = 0; x < args.length; x++) {
          bcast = bcast + args[x] + " ";
        }
        for (Player players : Bukkit.getOnlinePlayers())
        players.playSound(players.getLocation(), Sound.ANVIL_LAND, 1.0F, 1.0F);
        bcast = ChatColor.translateAlternateColorCodes('&', bcast);
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("                " );
        Bukkit.broadcastMessage("§7[§6§l!§7] " + bcast);
      }
      else
      {
        sender.sendMessage(ChatColor.AQUA + "§7[§6§l!§7] Use: /broadcast [mensagem]");
      }
    }
    return false;
  }
}
