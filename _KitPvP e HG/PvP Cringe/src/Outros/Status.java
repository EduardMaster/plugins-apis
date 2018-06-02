package Outros;

import Main.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

@SuppressWarnings("unused")
public class Status
  implements Listener
{
  @EventHandler
  void aoLogar(PlayerJoinEvent evento)
  {
    Player p = evento.getPlayer();
    if (Main.plugin.getConfig().get("status." + p.getName().toLowerCase() + ".kills") == null)
    {
      Main.plugin.getConfig().set("status." + p.getName().toLowerCase() + ".kills", Integer.valueOf(0));
      Main.plugin.saveConfig();
    }
    if (Main.plugin.getConfig().get("status." + p.getName().toLowerCase() + ".deaths") == null)
    {
      Main.plugin.getConfig().set("status." + p.getName().toLowerCase() + ".deaths", Integer.valueOf(0));
      Main.plugin.saveConfig();
    }
    if (Main.plugin.getConfig().get("status." + p.getName().toLowerCase() + ".xp") == null)
    {
      Main.plugin.getConfig().set("status." + p.getName().toLowerCase() + ".xp", Integer.valueOf(0));
      Main.plugin.saveConfig();
    }
  }
  
  @EventHandler
  void aoMatar(PlayerDeathEvent evento)
  {
    if ((evento.getEntity().getKiller() instanceof Player))
    {
      Player p = evento.getEntity().getKiller();
      
      int kills = Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".kills");
      Main.plugin.getConfig().set("status." + p.getName().toLowerCase() + ".kills", Integer.valueOf(kills + 1));
      Main.plugin.saveConfig();
      
      int elo = Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".xp");
      Main.plugin.getConfig().set("status." + p.getName().toLowerCase() + ".xp", Integer.valueOf(elo + 10));
      Main.plugin.saveConfig();
    }
  }
  
  @EventHandler
  void aoMorrer(PlayerDeathEvent evento)
  {
    if ((evento.getEntity() instanceof Player))
    {
      Player p = evento.getEntity();
      
      int deaths = Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".deaths");
      Main.plugin.getConfig().set("status." + p.getName().toLowerCase() + ".deaths", Integer.valueOf(deaths + 1));
      Main.plugin.saveConfig();
    }
  }
}
