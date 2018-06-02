package Pedrao.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import Pedrao.Main;

public class Ban
  implements CommandExecutor, Listener
{
  public static Main plugin;
  
  public Ban(Main main)
  {
    plugin = main;
  }
  
  @SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("ban"))
    {
      if ((sender instanceof ConsoleCommandSender))
      {
        System.out.println("Console nao pode usar esse comando");
        return true;
      }
      Player p = (Player)sender;
      if (p.hasPermission("kitpvp.ban"))
      {
        if (args.length == 0)
        {
          p.sendMessage("§cUse: /ban <Jogador> <Motivo>");
        }
        else if (args.length == 1)
        {
          Player targetPlayer = p.getServer().getPlayer(args[0]);
          if (targetPlayer == null) {
            p.sendMessage("§cEste jogador esta offline!");
          } else {
            p.sendMessage("§cUse: /ban <Jogador> <Motivo>");
          }
        }
        else if (args.length > 1)
        {
          Player targetPlayer = p.getServer().getPlayer(args[0]);
          if (targetPlayer == null)
          {
            p.sendMessage("§cEste jogador esta offline!");
          }
          else
          {
            String message = "";
            for (int i = 1; i < args.length; i++) {
              message = message + args[i] + " ";
            }
            targetPlayer.setBanned(true);
            targetPlayer.kickPlayer("§7Você foi banido pelo Jogador: §c" + p.getName() + "\n §7Motivo: §c" + message);
            Bukkit.broadcastMessage("§c" + targetPlayer.getName() + " §7Foi banido pelo Jogador: §c" + 
              p.getName() + " §7Motivo: §c" + message);
          }
        }
      }
      else {
        p.sendMessage(Main.semperm);
      }
    }
    return false;
  }
  
  @EventHandler
  public void aoEntrar(PlayerLoginEvent e)
  {
    Player p = e.getPlayer();
    if (p.isBanned()) {
      e.setKickMessage("§4§lVoce foi banido");
    }
  }
}
