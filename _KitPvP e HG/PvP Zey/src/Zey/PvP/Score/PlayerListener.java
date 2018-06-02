package Zey.PvP.Score;

import org.bukkit.event.*;
import org.bukkit.*;
import org.bukkit.event.player.*;

public class PlayerListener implements Listener
{
    @EventHandler(priority = EventPriority.HIGH)
    public void onJoin(final PlayerJoinEvent e) {
        SManager.getPlayers().put(e.getPlayer().getUniqueId(), new SPlayer(e.getPlayer().getName()));
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerChangeWorld(final PlayerChangedWorldEvent e) {
        e.getPlayer().setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onKick(final PlayerKickEvent e) {
        SManager.getPlayers().remove(e.getPlayer().getUniqueId());
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onQuit(final PlayerQuitEvent e) {
        SManager.getPlayers().remove(e.getPlayer().getUniqueId());
    }
}
