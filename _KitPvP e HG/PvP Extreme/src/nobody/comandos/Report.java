package nobody.comandos;

import java.util.ArrayList;
import java.util.Arrays;

import nobody.main.Main;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Report
  implements CommandExecutor, Listener
{
  @SuppressWarnings({ "unchecked", "rawtypes" })
public static ArrayList<String> reported = new ArrayList();
  private Main plugin;
  
  public Report(Main plugin)
  {
    this.plugin = plugin;
  }
  @SuppressWarnings ("deprecation")
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  
  {
    final Player p = (Player)sender;
    if (!(sender instanceof Player))
    {
      sender.sendMessage("Voce nao e um jogador!");
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
        	  p.sendMessage("§eExtreme§fKits » §6Este jogador já foi reportado. Aguarde!");
            return true;
          }
          String reportMsg = StringUtils.join(
            Arrays.copyOfRange(args, 1, args.length), " ");
          reported.add(p.getName());
          p.sendMessage("§8Voce reportou o §b" + target.getName() + "§8 por §b" + reportMsg);
          Player[] arrayOfPlayer;
          int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
          for (int i = 0; i < j; i++)
          {
            Player s = arrayOfPlayer[i];
            if (s.hasPermission("tk.report"))
            {
            	
              s.playSound(s.getLocation(), Sound.NOTE_PLING, 15.0F, 1.0F);
              s.sendMessage("§m----------------------------");
              s.sendMessage("§2§lPlayer Reportado §6§l§o» §f§l" + target.getName() +
              " \n§c§lMotivo §6§l§o» §f§l " + reportMsg + "\n§6§lReporter §6§l§o» §f§l " + p.getName());
              s.sendMessage("§m----------------------------");
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
          p.sendMessage("§eExtreme§fKits » Jogador " + args[0] + " nao esta online.");
        }
      }
      else
      {
        p.sendMessage("§eExtreme§fKits » §cArgumentos insuficientes. Use: /" + commandLabel + " <jogador> <motivo>");
      }
    }
    return false;
  }
}
