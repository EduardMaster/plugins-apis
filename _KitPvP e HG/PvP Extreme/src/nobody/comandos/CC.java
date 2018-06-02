package nobody.comandos;

import nobody.main.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CC
  implements CommandExecutor
{
  @SuppressWarnings("unused")
private CC plugin;
  
  public CC(CC plugin)
  {
    this.plugin = plugin;
  }

public CC(Main main) {
	// TODO Auto-generated constructor stub
}

public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage(ChatColor.RED + "Voce nao e um jogador!");
      return false;
    }
    Player p = (Player)sender;
    if ((commandLabel.equalsIgnoreCase("cc")) && 
      (p.hasPermission("tk.limparchat")))
    {
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(" ");
      Bukkit.broadcastMessage(ChatColor.WHITE + "§7§lCHAT LIMPO POR: " +  "§6§o" + p.getName());
    }
    return false;
  }
}
