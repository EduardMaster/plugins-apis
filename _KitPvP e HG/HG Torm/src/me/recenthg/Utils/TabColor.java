package me.recenthg.Utils;
import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.PlayerConnection;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.spigotmc.ProtocolInjector;

import me.recenthg.Main;
import me.recenthg.Manager.Habilidade;

public class TabColor implements Listener
{
  private static int VERSION = 47;
  
  @EventHandler
  public void onPlayerConnect(final PlayerJoinEvent e)
  {
	  new BukkitRunnable() {
		
		@Override
		public void run() {
		    Player p = e.getPlayer();
		    PlayerConnection connect = ((CraftPlayer)p).getHandle().playerConnection;
		    IChatBaseComponent top = ChatSerializer.a(
		      "{'extra': [{text: ' §7- §6Servidor 1.7 e 1.8! \n§7Jogue Livremente sem Hackers !', color: 'aqua'}],'color': gold, 'text': '§e§lEffects§f§lHG'}");
		    IChatBaseComponent bottom = ChatSerializer.a(
		      "{'extra': [{'color': 'aqua', 'text': ' §7Seu Kit: §e"+Habilidade.getAbility(p)+"', 'underline': 'true'}], 'color': 'gold', 'text': '§7Players§f: §e"+Main.Jogadores.size()+"§7/§e"+Bukkit.getMaxPlayers()+"'}");
		    if (((CraftPlayer)p).getHandle().playerConnection.networkManager.getVersion() < VERSION) {
		      return;
		    }
		    connect.sendPacket(new ProtocolInjector.PacketTabHeader(top, bottom));
			
		}
	}.runTaskTimer(Main.instance, 0L, 20L);
  }
}
