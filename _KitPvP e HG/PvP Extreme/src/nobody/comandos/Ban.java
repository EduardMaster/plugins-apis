package nobody.comandos;

import nobody.main.Main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;


public class Ban
  implements CommandExecutor, Listener
{
  public static Main plugin;

  public Ban(Main main)
  {
    plugin = main;
  }

  public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args)
  {
    if (Cmd.getName().equalsIgnoreCase("kick"))
    {
      Player p = (Player)Sender;
      if (!p.hasPermission("tk.kick")) {
        p.sendMessage("§c• §7Você não possue este comando!");
        return true;
      }

      if (Args.length == 0)
      {
        p.sendMessage("§a• §7Use: /kick <Jogador> <Motivo>");
      }
      else if (Args.length == 1)
      {
        Player targetPlayer = p.getServer().getPlayer(Args[0]);
        if (targetPlayer == null)
          p.sendMessage("§c• §7O jogador §f" + Args[0] + " §7Não Esta Online!");
        else {
          p.sendMessage("§c• §7Use: /kick <Jogador> <Motivo>");
        }
      }
      else if (Args.length > 1)
      {
        Player targetPlayer = p.getServer().getPlayer(Args[0]);
        if (targetPlayer == null)
        {
          p.sendMessage("§c• §7O jogador §f " + Args[0] + " §7Não Esta Online!");
        }
        else
        {
          String message = "";
          for (int i = 1; i < Args.length; i++) {
            message = message + Args[i] + " ";
          }
          targetPlayer.kickPlayer("§c§lSERVIDOR \n §cVoce foi expulso por  §c" + p.getName());
          Bukkit.broadcastMessage("§c§l(!) §cO jogador " + targetPlayer.getName() + " §cfoi expulso por §c" + p.getName() + " \n§c§l(!) §cMotivo: §c" + message);
        }
      }
    }

    return false;
  }
}