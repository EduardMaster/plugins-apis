package nobody.comandos;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class TP
  implements CommandExecutor, Listener
{
  public boolean onCommand(CommandSender sender, Command cmd, String tag, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage("§eExtreme§fKits » §cVocê não é um jogador");
      return true;
    }
    if (cmd.getName().equalsIgnoreCase("tp"))
    {
      Player p = (Player)sender;
      if (args.length == 0) {
        p.sendMessage(ChatColor.GRAY + "§eExtreme§fKits » §6Use e/tp §e<Player>");
      } else if (args.length == 1)
      {
        if ((p.hasPermission("tk.tp")) || (p.isOp()))
        {
          Player targetPlayer = p.getServer().getPlayer(args[0]);
          Location tpLoc = targetPlayer.getLocation();
          p.teleport(tpLoc);
          p.sendMessage(ChatColor.GRAY + "§6Teleportado para: " + targetPlayer.getDisplayName() + ChatColor.GRAY + ".");
        }
        else
        {
          p.sendMessage("§eExtreme§fKits » §cComando Incorreto");
        }
      }
      else if (args.length == 2) {
        if ((p.hasPermission("TK.tp")) || (p.isOp()))
        {
          Player targetPlayer = p.getServer().getPlayer(args[0]);
          Player targetPlayer2 = p.getServer().getPlayer(args[1]);
          if ((targetPlayer == null) || (targetPlayer2 == null))
          {
            p.sendMessage("§eExtreme§fKits » §cJogador Offline!");
          }
          else
          {
            Location tpLoc = targetPlayer2.getLocation();
            targetPlayer.teleport(tpLoc);
            p.sendMessage(ChatColor.GRAY + "§eExtreme§fKits » §6Teleportado para: " + targetPlayer.getDisplayName() + ChatColor.GRAY + ".");
          }
        }
        else
        {
          p.sendMessage("§eExtreme§fKits » §cComando Incorreto");
        }
      }
    }
    return false;
  }
}
