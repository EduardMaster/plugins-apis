package nobody.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Danoglobal
  implements CommandExecutor, Listener
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage(ChatColor.RED + "Somente jogadores podem executar este comando!");
      return true;
    }
    Player p = (Player)sender;
    if ((cmd.getName().equalsIgnoreCase("danoglobal")) && (
      (p.hasPermission("tk.danoglobal")) || (p.isOp())))
    {
      if (p.getWorld().getPVP())
      {
        p.getWorld().setPVP(false);
        Bukkit.getServer().broadcastMessage("§7[§6§l!§7] §cO PvP Foi Desativado Por: §e" + p.getName());
        return true;
      }
      p.getWorld().setPVP(true);
      Bukkit.getServer().broadcastMessage("§7[§6§l!§7] §aO PvP Foi Ativado Por: §e" + p.getName());
      return true;
    }
    return true;
  }
}
