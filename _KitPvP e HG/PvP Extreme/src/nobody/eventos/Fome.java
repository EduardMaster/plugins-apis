package nobody.eventos;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Fome
  implements Listener,CommandExecutor
  
{
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static HashMap<String, BuildStats> Build = new HashMap();
    
    public static enum BuildStats
    {
      ON,  OFF;
    }
    
  
  
  @EventHandler
  public void nuncaTerFome(FoodLevelChangeEvent e)
  {
    e.setCancelled(true);
  }
  
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
      if (!(sender instanceof Player))
      {
        sender.sendMessage("§7[§6§l!§7] §cApenas jogadores podem usar isso");
        return true;
      }
      if (!sender.hasPermission("ng.build"))
      {
        sender.sendMessage("§cPermiss~");
        return true;
      }
      Player p = (Player)sender;
      if (args.length == 0) {
        p.sendMessage("§cUse: /build on ou off");
      }
      if (args[0].equalsIgnoreCase("on"))
      {
        if (Build.get(p.getName()) == BuildStats.ON)
        {
          p.sendMessage("§7[§6§l!§7] §cSeu Build já está ativado");
          return true;
        }
        p.sendMessage("§7[§6§l!§7] §6Modo construir: §aAtivo");
        Build.put(p.getName(), BuildStats.ON);
        return true;
      }
      if (args[0].equalsIgnoreCase("off"))
      {
        if (Build.get(p.getName()) == BuildStats.OFF)
        {
          p.sendMessage("§7[§6§l!§7] §cSeu Build já está desativado");
        }
        else
        {
          p.sendMessage("§7[§6§l!§7] §6Modo construir: §aDesativado");
          Build.put(p.getName(), BuildStats.OFF);
          return true;
        }
      }
      else {
        p.sendMessage("§7[§6§l!§7] §cUse: /build on ou off");
      }
      return false;
    }
    
    @EventHandler
    public void Entrou(PlayerJoinEvent e)
    {
      Build.put(e.getPlayer().getName(), BuildStats.OFF);
    }
    
    @EventHandler
    public void Quebrar(BlockBreakEvent e)
    {
      Player p = e.getPlayer();
      if (Build.get(p.getName()) == BuildStats.OFF) {
        e.setCancelled(true);
      }
    }
    
    @EventHandler
    public void Quebrar(BlockPlaceEvent e)
    {
      Player p = e.getPlayer();
      if (Build.get(p.getName()) == BuildStats.OFF) {
        e.setCancelled(true);
      }
    }
  }
