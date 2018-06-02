package nobody.comandos;

import nobody.main.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Mutechat
  implements CommandExecutor, Listener
{
  public Main plugin;
  public static boolean globalmute = false;
  
  public Mutechat(Main instance)
  {
    this.plugin = instance;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage(ChatColor.RED + "Apenas jogadores podem dar este comando!");
      return true;
    }
    Player p = (Player)sender;
    if (label.equalsIgnoreCase("pluginInsanityUtils")) {
      p.sendMessage(ChatColor.GRAY + "Feito Por -->" + ChatColor.AQUA + " InsanityPlugins! :D");
    }
    if ((cmd.getName().equalsIgnoreCase("mutechat")) && 
      (p.hasPermission("tk.mutarchat"))) {
      if (!globalmute)
      {
        Bukkit.broadcastMessage("§eExtreme§fKits » §cO Chat Foi Desabilitado Por: §6" + p.getName());
        globalmute = true;
      }
      else if (globalmute)
      {
        Bukkit.broadcastMessage("§eExtreme§fKits » §aO Chat Foi Habilitado Por: §6" + p.getName());
        globalmute = false;
      }
    }
    return false;
  }
  
  @EventHandler
  public void OnChat(AsyncPlayerChatEvent event)
  {
    Player player = event.getPlayer();
    if ((!player.hasPermission("tk.falarchatmute")) && (globalmute))
    {
      event.setCancelled(true);
      player.sendMessage("§a§oO Chat Está Temporariamente Desabilitado !");
    }
  }
}
