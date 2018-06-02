package nobody.comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class StaffChat
  implements Listener, CommandExecutor
{
  @SuppressWarnings({ "unchecked", "rawtypes" })
public static ArrayList<String> staff = new ArrayList();
  
  @SuppressWarnings("deprecation")
@EventHandler
  public void onChat(AsyncPlayerChatEvent e)
  {
    Player p = e.getPlayer();
    Player[] arrayOfPlayer;
    int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
    for (int i = 0; i < j; i++)
    {
      Player online = arrayOfPlayer[i];
      if ((isStaffChatting(p)) && (
        (online.hasPermission("tk.staffchat")) || (isStaffChatting(online))))
      {
        online.sendMessage(ChatColor.AQUA + "§7[§6SC§7] " + ChatColor.GRAY + p.getName() + " " + ChatColor.AQUA + ": §f" + e.getMessage());
        e.setCancelled(true);
      }
    }
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (!(sender instanceof Player)) {
      return true;
    }
    Player p = (Player)sender;
    if ((cmd.getName().equalsIgnoreCase("sc")) && (p.hasPermission("tk.staffchat"))) {
      if (isStaffChatting(p))
      {
        staff.remove(p.getName());
        p.sendMessage("");
        p.sendMessage(ChatColor.RED + "Você saiu do Staff-Chat");
        p.sendMessage("");
      }
      else
      {
        staff.add(p.getName());
        p.sendMessage("");
        p.sendMessage(ChatColor.GREEN + "Você entrou no Staff-Chat");
        p.sendMessage("");
      }
    }
    return false;
  }
  
  public boolean isStaffChatting(Player player)
  {
    if (staff.contains(player.getName())) {
      return true;
    }
    return false;
  }
}
