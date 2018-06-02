package Zey.PvP.Eventos;

import Zey.PvP.Main.*;
import org.bukkit.event.player.*;
import org.bukkit.craftbukkit.v1_7_R4.entity.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.spigotmc.*;
import net.minecraft.server.v1_7_R4.*;
import org.bukkit.event.*;

public class TabPersonalizado implements Listener
{
    private static int VERSION;
    
    static {
        TabPersonalizado.VERSION = 47;
    }
    
    public TabPersonalizado(final Main main) {
    }
    
    @SuppressWarnings("unused")
	@EventHandler
    void TabDoServidor(final PlayerJoinEvent e) {
        final Player jogador = e.getPlayer();
        final int ping = ((CraftPlayer)jogador).getHandle().playerConnection.player.ping;
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                final PlayerConnection connect = ((CraftPlayer)jogador).getHandle().playerConnection;
                final IChatBaseComponent top = ChatSerializer.a("{'extra': [{text: '', color: 'aqua'}],'color': gold, 'text': '        " + Main.prefix + "       '}");
                final IChatBaseComponent bottom = ChatSerializer.a("{'extra': [{'color': 'aqua', 'text': ' §7» §eLoja: §b" + "Zeynetwork.tk" + "\n  §7» §eDiscord: §b" + "Discord.me/ZeyNetwork  " + "', 'underline': 'true'}], 'color': 'gold', 'text': ''}");
                if (((CraftPlayer)jogador).getHandle().playerConnection.networkManager.getVersion() < TabPersonalizado.VERSION) {
                    return;
                }
                connect.sendPacket((Packet)new ProtocolInjector.PacketTabHeader(top, bottom));
            }
        }, 1L, 20L);
    }
}
