package nobody.comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Fake implements Listener ,CommandExecutor
{

public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
{
  Player p = (Player)sender;
  if (commandLabel.equalsIgnoreCase("fake")) {
    if (p.hasPermission("tk.fake"))
    {
      if (args.length == 0)
      {
        p.sendMessage("§bDigite /fake [nick]");
        return true;
      }
      String nicks = args[0];
      nicks = nicks.replaceAll("&", "§");
      p.setPlayerListName(nicks);
      p.setDisplayName(nicks);
      p.sendMessage(ChatColor.BLUE + "Nick alterado com sucesso para " + ChatColor.RESET + ChatColor.BOLD + nicks);
      p.chat("/disguise player " + nicks);
    }
    else
    {
      p.sendMessage("§4Voce nao pode usar este comando.");
    }
  }
  if (cmd.getName().equalsIgnoreCase("tfake")) {
    if (p.hasPermission("tk.fake"))
    {
      p.setPlayerListName(p.getName());
      p.setDisplayName(p.getName());
      p.sendMessage(ChatColor.RED + "Seu nick voltou ao normal!");
      p.chat("/undisguise");
    }
    else
    {
      p.sendMessage("§cVoce não tem Permiss§o.");
    }
  }
  return false;
}
{

}
}
