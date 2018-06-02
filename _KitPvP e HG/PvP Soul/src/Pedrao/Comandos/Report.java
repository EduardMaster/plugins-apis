package Pedrao.Comandos;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Pedrao.Main;

public class Report
  implements CommandExecutor, Listener
{
  public static ArrayList<String> reported = new ArrayList<String>();
  private Main plugin;
  
  public Report(Main plugin)
  {
    this.plugin = plugin;
  }
  
  @SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    final Player p = (Player)sender;
    if (!(sender instanceof Player))
    {
      sender.sendMessage("§cVoce nao e um jogador!");
      return false;
    }
    if (commandLabel.equalsIgnoreCase("report")) {
      if (args.length >= 2)
      {
        Player target = p.getServer().getPlayer(args[0]);
        if (target != null)
        {
          if (reported.contains(p.getName()))
          {
            p.sendMessage(Main.prefix + "§cCalma extressado , ja tem um staff olhando");
            return true;
          }
          String reportMsg = StringUtils.join(
            Arrays.copyOfRange(args, 1, args.length), " ");
          reported.add(p.getName());
          p.sendMessage("§aVocê reportou o §7" + target.getName() + "§a por§7: " + reportMsg);
          p.sendMessage("§3Report Enviado !");
          for (Player s : Bukkit.getOnlinePlayers()) {
            if (s.hasPermission("kitpvp.report"))
            {
              s.sendMessage("§c[=-=-=-=-=-=-=-=-=-=-=-=]");
              s.sendMessage("§6      - HACK REPORT -");
              s.sendMessage("      §cREPORTADO: §7" + target.getName());
              s.sendMessage("      §cMOTIVO: §7" + reportMsg);
              s.sendMessage("      §cREPORTER: §7 " + p.getName());
              s.sendMessage("§c[=-=-=-=-=-=-=-=-=-=-=-=]");
              
              Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
              {
                public void run()
                {
                  Report.reported.remove(p.getName());
                }
              }, 250L);
            }
          }
        }
        else
        {
          p.sendMessage("§cJogador " + args[0] + " não está online.");
        }
      }
      else
      {
        p.sendMessage("§cUse: /" + commandLabel + " <Jogador> <Motivo>");
      }
    }
    return false;
  }
}
