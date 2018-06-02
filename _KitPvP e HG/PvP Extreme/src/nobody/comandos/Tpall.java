package nobody.comandos;

import nobody.main.Main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Tpall
  implements CommandExecutor
{
  public Main plugin;
  
  public Tpall(Main main)
  {
    this.plugin = main;
  }
  
  @SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage("Console dando tpall?");
      return true;
    }
    Player jogador = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("tpall"))
    {
      jogador.sendMessage("§7[§6§l!§7] §bVoce puxou todos os players!");
      Bukkit.broadcastMessage("§7[§6§l!§7] §bO Staff§a " + jogador.getName() + " §bPuxou Todos!");
      if (jogador.hasPermission("tk.tpall"))
      {
        Player[] arrayOfPlayer;
        int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
        for (int i = 0; i < j; i++)
        {
          Player todos = arrayOfPlayer[i];
          
          todos.teleport(jogador.getLocation());
        }
      }
    }
    return false;
  }
}
