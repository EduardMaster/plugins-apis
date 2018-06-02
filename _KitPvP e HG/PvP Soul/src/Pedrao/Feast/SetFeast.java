package Pedrao.Feast;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Pedrao.Main;
import Pedrao.Feast.Ffeast;

public class SetFeast
  implements CommandExecutor, Listener
{
  public SetFeast(Main main) {
	}

public boolean onCommand(CommandSender sender, Command cmd, String tag, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage("§cVocê não é um jogador");
      return true;
    }
    Player p = (Player)sender;
    if (tag.equalsIgnoreCase("setfeast"))
    {
      if (!p.hasPermission("KitPvP.feast"))
      {
        p.sendMessage(Main.semperm);
        return true;
      }
      p.sendMessage("§7{§4§lFeast§7} Feast Setado");
      Ffeast.setSimulatorCords1(p);
      
      return true;
    }
    if ((cmd.getName().equalsIgnoreCase("feast")) && (p.hasPermission("kitpvp.feast")))
    {
      Ffeast.miniFeast();
      p.sendMessage("§7{§4§lFeast§7} §a§lFeast foi Spawnado ");
    }
    if ((cmd.getName().equalsIgnoreCase("rfeast")) && (p.hasPermission("kitpvp.feast")))
    {
      Ffeast.miniFeast1();
      p.sendMessage("§7{§4§lFeast§7} §a§lFeast foi removido ");
      Ffeast.setSimulatorCords1(p);
    }
    return false;
  }
}
