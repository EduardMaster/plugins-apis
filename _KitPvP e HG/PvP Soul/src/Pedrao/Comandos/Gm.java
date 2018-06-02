package Pedrao.Comandos;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Pedrao.Main;

public class Gm
  implements CommandExecutor, Listener
{
  public Gm(Main main) {
	}

public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if ((cmd.getName().equalsIgnoreCase("gm")) || 
      (cmd.getName().equalsIgnoreCase("gamemode")))
    {
      if ((sender instanceof ConsoleCommandSender))
      {
        System.out.println("Console nao pode usar esse comando");
        return true;
      }
      Player p = (Player)sender;
      if (args.length == 0) {
        p.sendMessage(Main.prefix + 
          "O seu modo de gamemode atual §c" + p.getGameMode() + 
          "§7.");
      } else if (args.length == 1) {
        if ((p.hasPermission("kitpvp.gm")) || (p.isOp()))
        {
          if ((args[0].equalsIgnoreCase("1")) || 
            (args[0].equalsIgnoreCase("criativo")))
          {
            p.setGameMode(GameMode.CREATIVE);
            p.sendMessage(Main.prefix + 
              "Seu gamemode agora esta em §ccriativo§7.");
          }
          else if ((args[0].equalsIgnoreCase("0")) || 
            (args[0].equalsIgnoreCase("sobrevivencia")))
          {
            p.setGameMode(GameMode.SURVIVAL);
            p.sendMessage(Main.prefix + 
              "Seu gamemode agora esta em §csobrevivencia§7.");
          }
          else
          {
            p.sendMessage(Main.prefix + 
              "Nao encontrado este gamemode.");
          }
        }
        else {
          p.sendMessage(Main.semperm);
        }
      }
    }
    return false;
  }
}
