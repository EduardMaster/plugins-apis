package me.recenthg.stark.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.recent.stark.Strings;
import me.recenthg.stark.Manager.Title;

@SuppressWarnings("unused")
public class Prender
  implements CommandExecutor, Listener
{
  public Prender(me.recent.stark.Main main)
  {
  }

  public Prender()
  {
  }

  @SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args)
  {
    Player p = (Player)sender;
    if ((p.hasPermission("admin.arena")) && (cmd.getName().equalsIgnoreCase("arena")))
    {
      if (args.length == 0) {
        p.sendMessage("§8\u276e§2§l!§8\u276f §7Use: /arena §7<§6Jogador§7>");
      }
      if (args.length == 1)
      {
        Player o = Bukkit.getPlayer(args[0]);
        if (o != null)
        {
          o.getLocation().add(0.0D, 13.0D, 0.0D).getBlock().setType(Material.BEDROCK);
          o.getLocation().add(0.0D, 11.0D, 1.0D).getBlock().setType(Material.BEDROCK);
          o.getLocation().add(1.0D, 11.0D, 0.0D).getBlock().setType(Material.BEDROCK);
          o.getLocation().add(0.0D, 11.0D, -1.0D).getBlock().setType(Material.BEDROCK);
          o.getLocation().add(-1.0D, 11.0D, 0.0D).getBlock().setType(Material.BEDROCK);
          o.getLocation().add(0.0D, 10.0D, 0.0D).getBlock().setType(Material.BEDROCK);
          o.teleport(o.getLocation().add(0.0D, 11.0D, -0.05D));
          p.sendMessage("§8\u276e§2§l!§8\u276f §7Arena criada");
    	  Title.sendTitle(p, "§a! §fArena Criada §a!");
          Player[] arrayOfPlayer;
          int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
          for (int i = 0; i < j; i++)
          {
            Player p2 = arrayOfPlayer[i];
            if (p2.hasPermission("admin.chat")) {
              p2.sendMessage(ChatColor.GRAY + sender.getName() + " Criou Uma Arena Com " + o.getDisplayName());
            }
          }
        }
        else
        {
          p.sendMessage("§8\u276e§2§l!§8\u276f §7Jogador offline");
        }
      }
    }
    else
    {
    	p.sendMessage(Strings.semperm);
    }
    return false;
  }
}