package Pedrao.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Pedrao.Main;

public class Tell
  implements CommandExecutor, Listener
{
  public Tell(Main main) {
	}

public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (args.length == 0)
    {
      sender.sendMessage(Main.prefix + "§7Use /tell [§aplayer§7] [mensagem]");
      return true;
    }
    if (args.length == 1)
    {
      sender.sendMessage(Main.prefix + "§cfalta uma mensagem!");
      sender.sendMessage(Main.prefix + "§7Use /tell [§aplayer§7] [mensagem]");
      return true;
    }
    if (args.length > 1)
    {
      Player target = Bukkit.getPlayerExact(args[0]);
      if ((target == null) || (!(target instanceof Player)))
      {
        sender.sendMessage(Main.prefix + "§cJogador nao encontrado!");
        return true;
      }
      StringBuilder sb = new StringBuilder();
      for (int i = 1; i < args.length; i++) {
        sb.append(args[i] + " ");
      }
      String msg = sb.toString();
      target.sendMessage(String.format("§a%s §7para §7Você§3>>§e %s", new Object[] { sender.getName(), msg }));
      sender.sendMessage(String.format("§7Você §7para §a%s§3>>§e %s", new Object[] { target.getName(), msg }));
    }
    return false;
  }
}
