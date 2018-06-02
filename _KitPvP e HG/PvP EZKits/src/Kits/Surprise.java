package Kits;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import Main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Surprise
  implements CommandExecutor, Listener
{
  public static Main plugin;
  
  public Surprise(Main main)
  {
    plugin = main;
  }
  
  @SuppressWarnings("rawtypes")
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (label.equalsIgnoreCase("surprise"))
    {
      if (!p.hasPermission("kit.Surprise"))
      {
        p.sendMessage("§7[§c!§7]§c Você não tem permissão para este kit! §7[§c!§7]");
        return true;
      }
      Random Random = new Random();
      List RandomCommands = Arrays.asList(new String[] { "kit pvp", "kit kangaroo" });
      int Index = Random.nextInt(RandomCommands.size());
      String Command = (String)RandomCommands.get(Index);
      
      p.performCommand(Command);
    }
    return false;
  }
}