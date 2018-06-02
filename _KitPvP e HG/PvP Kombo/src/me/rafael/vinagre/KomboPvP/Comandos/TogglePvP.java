package me.rafael.vinagre.KomboPvP.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.World;
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
    if (!(sender instanceof Player))
    {
      sender.sendMessage(ChatColor.RED + "Somente jogadores podem executar este comando!");
      return true;
    }
    Player p = (Player)sender;
    if ((cmd.getName().equalsIgnoreCase("togglepvp")) && (
      (p.hasPermission("kitpvp.togglepvp")) || (p.isOp())))
    {
      if (p.getWorld().getPVP())
      {
        p.getWorld().setPVP(false);
        Bukkit.getServer().broadcastMessage("§cPvP Desativado");
        return true;
      }
      p.getWorld().setPVP(true);
      Bukkit.getServer().broadcastMessage("§2PvP Ativado");
      return true;
    }
    return true;
  }
}
