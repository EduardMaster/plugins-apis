package Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.confuser.barapi.BarAPI;

public class Morrer
  implements Listener, CommandExecutor
{
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("morrer"))
    {
      p.setHealth(0.0D);
      p.sendMessage("§7§lKILL §fVoce se matou!");
      BarAPI.setMessage(p, "§7§lKILL §fVoce se matou!", 5);
    }
    return false;
  }
}