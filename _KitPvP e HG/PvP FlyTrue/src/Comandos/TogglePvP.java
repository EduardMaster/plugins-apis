package Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class TogglePvP
  implements CommandExecutor, Listener
{
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if ((cmd.getName().equalsIgnoreCase("togglepvp")) && (
      (sender.hasPermission("fly.admin")) || (sender.isOp())))
    {
      if (p.getWorld().getPVP())
      {
        p.getWorld().setPVP(false);
        Bukkit.getServer().broadcastMessage("§cO PvP foi desativado");
        return true;
      }
      p.getWorld().setPVP(true);
      Bukkit.getServer().broadcastMessage("§aO PvP foi ativado");
      return true;
    }
    return false;
  }
}
