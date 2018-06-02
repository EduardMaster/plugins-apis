package me.recenthg.stark.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.recent.stark.Strings;
import me.recenthg.stark.Dinheiro.DinheiroM;

public class VerXp
  implements CommandExecutor, Listener
{
  public static boolean isNumeric(String str)
  {
    try
    {
      Integer.parseInt(str);
    }
    catch (NumberFormatException nfe)
    {
      return false;
    }
    return true;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("darxp")) {
			if (!p.hasPermission("HungerGames.xp")) {
				p.sendMessage(Strings.semperm);
			} else {
				if (args.length == 0) {
					sender.sendMessage("§8\u276e§2§l!§8\u276f §7/darxp [§aplayer] [quantia§7]");
					return true;
				}
				Player target = Bukkit.getPlayerExact(args[0]);
				if ((target == null) || (!(target instanceof Player))) {
					sender.sendMessage("§cJogador nao encontrado!");
					return true;
				}


      if (isNumeric(args[1]))
      {
        int coins = Integer.parseInt(args[1]);
        
        DinheiroM.darDinheiro(target, coins);  
        
        p.sendMessage("§8\u276e§2§l!§8\u276f §7Voce deu §6" + coins + " §7Coins para o jogador: §a" + target.getName());
        target.sendMessage("§8\u276e§2§l!§8\u276f §7Voce recebeu: §a" + coins + " §7De XP");
		}
		}
	}
	return false;
}
}