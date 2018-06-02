package Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Main.Main;

public class SetChallenge
  implements CommandExecutor
{
  public static Main plugin;
  
  public SetChallenge(Main main)
  {
    plugin = main;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if ((cmd.getName().equalsIgnoreCase("setchallenge")) && 
      ((sender instanceof Player)))
    {
      if (!sender.hasPermission("ezkits.admin"))
      {
        Player p1 = (Player)sender;
        p1.sendMessage("§cVocê não pode setar esta warp");
      }
      if (sender.hasPermission("ezkits.admin"))
      {
        Player p1 = (Player)sender;
        plugin.getConfig().set("challenge.x", Double.valueOf(p1.getLocation().getX()));
        plugin.getConfig().set("challenge.y", Double.valueOf(p1.getLocation().getY()));
        plugin.getConfig().set("challenge.z", Double.valueOf(p1.getLocation().getZ()));
        plugin.getConfig().set("challenge.pitch", Float.valueOf(p1.getLocation().getPitch()));
        plugin.getConfig().set("challenge.yaw", Float.valueOf(p1.getLocation().getYaw()));
        plugin.getConfig().set("challenge.world", p1.getLocation().getWorld().getName());
        plugin.saveConfig();
        p1.sendMessage("§aWarp Setada Com Sucesso");
      }
    }
    return false;
  }
}
