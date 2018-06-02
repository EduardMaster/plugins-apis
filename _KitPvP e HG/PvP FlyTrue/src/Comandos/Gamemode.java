package Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode
  implements CommandExecutor
{
  @SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§bPrecisa ser um Player para usar esse comando");
			return true;
		}
    Player player = (Player)sender;
    if ((cmd.getName().equalsIgnoreCase("gm")) || (cmd.getName().equalsIgnoreCase("gamemode"))) {
      if (player.hasPermission("fly.admin"))
      {
        if (args.length != 1)
        {
          player.sendMessage("§c§lFly§7§lTrue §a: §cUse /gm 0/1 ou /gamemode 0/1");
          return true;
        }
        if (args.length == 1)
        {
          if (args[0].equalsIgnoreCase("0"))
          {
            player.setGameMode(GameMode.SURVIVAL);
            player.sendMessage("§c§lFly§7§lTrue §a: §6Voce alterou seu modo de jogo para §aSurvival §6!");
          }
          if (args[0].equalsIgnoreCase("1"))
          {
            player.setGameMode(GameMode.CREATIVE);
            player.sendMessage("§c§lFly§7§lTrue §a: §6Voce alterou seu modo de jogo para §cCreative §6!");
            Player[] arrayOfPlayer;
            int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
            for (int i = 0; i < j; i++)
            {
              Player p2 = arrayOfPlayer[i];
              if (p2.hasPermission("sp.admin")) {
                p2.sendMessage(player.getName() + " §7mudou seu gamemode para §bCriativo");
              }
            }
          }
        }
      }
      else
      {
        player.sendMessage(ChatColor.RED + "§c§lFly§7§lTrue §a: Voce n§o tem permissao !!");
      }
    }
    return false;
  }
}
