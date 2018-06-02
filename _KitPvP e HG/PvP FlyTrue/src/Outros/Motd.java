package Outros;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class Motd
  implements Listener
{
  @EventHandler
  public void NomedoServer(ServerListPingEvent e)
  {
	e.setMotd("§c§lFly§7§lTrue §a> §6Treine e melhore seu PvP");
    e.setMaxPlayers(62);
  }
}
