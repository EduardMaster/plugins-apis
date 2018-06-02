package Net.Hunger.Manager;

import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.EntityPlayer;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.NetworkManager;
import net.minecraft.server.v1_7_R4.PlayerConnection;

import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.spigotmc.ProtocolInjector;
import org.spigotmc.ProtocolInjector.PacketTabHeader;

public class TabColor implements Listener
{
  private static int VERSION = 47;
  
  @EventHandler
  public void onPlayerConnect(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();
    PlayerConnection connect = ((CraftPlayer)p).getHandle().playerConnection;
    IChatBaseComponent top = ChatSerializer.a(
      "{'extra': [{text: ' §7- §6Network de §bServidores §61.8§b!', color: 'aqua'}],'color': gold, 'text': 'Skill§bNetwork'}");
    IChatBaseComponent bottom = ChatSerializer.a(
      "{'extra': [{'color': 'aqua', 'text': 'http://SkillNetwork.buycraft.net', 'underline': 'true'}], 'color': 'gold', 'text': 'Visite nossa Loja: '}");
    if (((CraftPlayer)p).getHandle().playerConnection.networkManager.getVersion() < VERSION) {
      return;
    }
    connect.sendPacket(new ProtocolInjector.PacketTabHeader(top, bottom));
  }
}
