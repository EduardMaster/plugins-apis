package Zey.PvP.Commands;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Zey.PvP.APIs.TheTitle;
import Zey.PvP.Eventos.Habilidade;
import Zey.PvP.Main.Main;

public class ReportCommand implements CommandExecutor {
	
	public ArrayList<String> reported = new ArrayList<String>();
	  
	  
  private Main plugin;
  
  public ReportCommand(Main plugin)
  {
    this.plugin = plugin;
  }
  
  @SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    final Player p = (Player)sender;
    if (!(sender instanceof Player))
    {
    	   sender.sendMessage(String.valueOf(Main.prefix) + " §7» §cApenas jogadores podem usar isso.");
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
            p.sendMessage(String.valueOf(Main.prefix) + " §7» §cAguarde, para reportar novamente.");
            return true;
          }
          String reportMsg = StringUtils.join(
            Arrays.copyOfRange(args, 1, args.length), " ");
          this.reported.add(p.getName());
          p.sendMessage(String.valueOf(Main.prefix) + " §7» §7O Report do jogador §e" + target.getName() + " §7pelo motivo §c" + reportMsg + "§7 foi enviado a nossa equipe!");
          Player[] arrayOfPlayer;
          int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
          for (int i = 0; i < j; i++)
          {
            Player s = arrayOfPlayer[i];
            if (s.hasPermission("zey.pvp.receberreport"))
            {
              s.playSound(s.getLocation(), Sound.LEVEL_UP, 15.0F, 1.0F);
              TheTitle.sendTitle(s, "§e§lREPORT");
              s.sendMessage("§c");
              s.sendMessage("§c             §c§lNOVO REPORT!§c               ");
              s.sendMessage("§c");
              s.sendMessage("   §7Jogador Reportado: §c" + target.getName());
              s.sendMessage("   §7Kit do Suspeito: §c" + Habilidade.getAbility(p));
              s.sendMessage("   §7Servidor: §c" + Bukkit.getServerName());
              s.sendMessage("§c");
              s.sendMessage("   §7Jogador que Reportou: §a" + p.getName());
              s.sendMessage("   §7Motivo do Reporte: §e" + reportMsg);
              s.sendMessage("§c");
              Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
              {
                public void run()
                {
                  ReportCommand.this.reported.remove(p.getName());
                }
              }, 300L);
            }
          }
        }
        else
        {
          p.sendMessage(String.valueOf(Main.prefix) + " §7» §cEste jogador(a) está offline ou não existe.");
        }
      }
      else
      {
        p.sendMessage(String.valueOf(Main.prefix) + " §7» §cErrado, utilize a sintaxe correta: /report [Jogador(a)] (motivo)");
      }
    }
    return false;
  }
}
