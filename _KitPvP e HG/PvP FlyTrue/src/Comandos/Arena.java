package Comandos;

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

@SuppressWarnings("unused")
public class Arena
  implements CommandExecutor, Listener
{
  @SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args)
  {
    Player p = (Player)sender;
    if ((p.hasPermission("fly.admin")) && (cmd.getName().equalsIgnoreCase("arena")))
    {
      if (args.length == 0) {
        p.sendMessage("§c!! §aUse: /arena <Jogador>");
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
          p.sendMessage("§c§lFly§7§lTrue §a: §7Prisao criada");
          Player[] arrayOfPlayer;
          int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
          for (int i = 0; i < j; i++)
          {
            Player p2 = arrayOfPlayer[i];
            if (p2.hasPermission("fly.admin")) {
              p2.sendMessage(ChatColor.GRAY + sender.getName() + " Prendeu o " + o.getDisplayName());
            }
          }
        }
        else
        {
          p.sendMessage("§c§lFly§7§lTrue §a: §cJogador offline");
        }
      }
    }
    else
    {
      p.sendMessage("§c§lFly§7§lTrue §a: §cSem permissao");
    }
    return false;
  }
}
