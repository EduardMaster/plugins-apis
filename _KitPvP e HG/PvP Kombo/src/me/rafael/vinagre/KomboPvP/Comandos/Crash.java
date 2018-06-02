package me.rafael.vinagre.KomboPvP.Comandos;




import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import me.rafael.vinagre.KomboPvP.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Crash
  implements CommandExecutor, Listener
{
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
  {
    if ((label.equalsIgnoreCase("crash")) && (sender.hasPermission("kitpvp.crash")))
    {
      if (args.length < 1)
      {
        sender.sendMessage(ChatColor.RED + "Sintaxe: /crash <jogador>");
        return true;
      }
      Player other = Bukkit.getPlayer(args[0]);
      if (other == null)
      {
        sender.sendMessage(ChatColor.RED + "O jogador especificado nao foi encontrado!");
        return true;
      }
      Inventory inv = Bukkit.createInventory(other, 756, "§cCrash");
      other.openInventory(inv);
      other.setHealthScale(9.49592994E8D);
      other.setGameMode(GameMode.SURVIVAL);
      sender.sendMessage("§cJogador crashado! Voce e du mal");
      Player[] arrayOfPlayer;
      int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
      for (int i = 0; i < j; i++)
      {
        Player p = arrayOfPlayer[i];
        if (p.hasPermission("kitpvp.admin")) {
          p.sendMessage("§f[§b§lServidor§f]§r §b" + sender.getName() + " §acrashou o jogo do §c" + other.getName());
        }
      }
    }
    return true;
  }
}