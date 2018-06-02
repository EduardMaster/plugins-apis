package nobody.comandos;

import nobody.main.Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Status
  implements CommandExecutor
{
  public Main a;
  
  public Status(Main plugin)
  {
    this.a = plugin;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (args.length == 0)
    {
      Player p = (Player)sender;
      p.sendMessage("§a§m------------------------------------");
      p.sendMessage("§bSeus status:");
      p.sendMessage("§bKills: " + this.a.getConfig().getInt(new StringBuilder("jogador.").append(p.getName().toLowerCase()).append(".kills").toString()));
      p.sendMessage("§bMortes: " + this.a.getConfig().getInt(new StringBuilder("jogador.").append(p.getName().toLowerCase()).append(".mortes").toString()));
      p.sendMessage("§bKillStreak: " + this.a.getConfig().getInt(new StringBuilder("jogador.").append(p.getName().toLowerCase()).append(".kill-streak").toString()));
      p.sendMessage("§bKillStreak Máxima: " + this.a.getConfig().getInt(new StringBuilder("jogador.").append(p.getName().toLowerCase()).append(".max-kill-streak").toString()));
      p.sendMessage("§a§m-------------------------------------");
      return false;
    }
    if (args.length == 1)
    {
      Player p = (Player)sender;
      Player target = p.getServer().getPlayer(args[0]);
      if (target != null)
      {
        p.sendMessage("§a§m-------------------------------------");
        p.sendMessage("§bStatus de " + args[0] + ":");
        p.sendMessage("§bKills: " + this.a.getConfig().getInt(new StringBuilder("jogador.").append(target.getName().toLowerCase()).append(".kills").toString()));
        p.sendMessage("§bMortes: " + this.a.getConfig().getInt(new StringBuilder("jogador.").append(target.getName().toLowerCase()).append(".mortes").toString()));
        p.sendMessage("§bKillStreak: " + this.a.getConfig().getInt(new StringBuilder("jogador.").append(target.getName().toLowerCase()).append(".kill-streak").toString()));
        p.sendMessage("§bKillStreak Máxima: " + this.a.getConfig().getInt(new StringBuilder("jogador.").append(target.getName().toLowerCase()).append(".max-kill-streak").toString()));
        p.sendMessage("§a§m-------------------------------------");
        return false;
      }
      p.sendMessage("§cPlayer não encontrado!");
    }
    return false;
  }
}
