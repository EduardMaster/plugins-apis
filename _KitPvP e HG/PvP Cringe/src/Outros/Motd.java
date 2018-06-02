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
	e.setMotd("   §e§lCringed§7§lKits §f| §dConfira nossas Atualizaçoes                §eCada segundo é tempo pra mudar tudo...");
    e.setMaxPlayers(62);
  }
}
