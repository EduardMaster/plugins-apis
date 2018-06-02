package Comandos;

import java.util.ArrayList;
import java.util.Arrays;
import Main.Main;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Report
  implements CommandExecutor
{
	
	  @SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<String> reported = new ArrayList();
	  
	  
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
          if (this.reported.contains(p.getName()))
          {
            p.sendMessage("§7{§c§lREPORT§7} §cStaffers olhando o player que voce reportou aguarde!!");
            return true;
          }
          String reportMsg = StringUtils.join(
            Arrays.copyOfRange(args, 1, args.length), " ");
          this.reported.add(p.getName());
          p.sendMessage("§6Voce reportou o §b" + target.getName() + "§6 por §b" + reportMsg);
          Player[] arrayOfPlayer;
          int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
          for (int i = 0; i < j; i++)
          {
            Player s = arrayOfPlayer[i];
            if (s.hasPermission("cmd.admin"))
            {
              s.playSound(s.getLocation(), Sound.ANVIL_USE, 15.0F, 1.0F);
              s.sendMessage(ChatColor.RED + "§7§m-----------------------------------");
              s.sendMessage(ChatColor.RED + "                        ");
              s.sendMessage("§6§lPlayer reportado > §b§l" + target.getName() + " \n§6§lMotivo >> §c§l " + reportMsg + 
                "\n§6§lReporter >§a§l " + p.getName());
              s.sendMessage(ChatColor.RED + "                        ");
              s.sendMessage(ChatColor.RED + "§7§m-----------------------------------");
              Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
              {
                public void run()
                {
                  Report.this.reported.remove(p.getName());
                }
              }, 300L);
            }
          }
        }
        else
        {
          p.sendMessage("Jogador " + args[0] + " nao esta online.");
        }
      }
      else
      {
        p.sendMessage("§7{§c§lREPORT§7} §7Use: /" + commandLabel + " <jogador> <motivo>");
      }
    }
    return false;
  }
}
