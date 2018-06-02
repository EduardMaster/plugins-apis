package Zey.PvP.Eventos;

import org.bukkit.event.entity.*;

import Zey.PvP.Config.ZeyCoins;

import org.bukkit.entity.*;
import org.bukkit.event.*;

public class GanharXP implements Listener
{
    @EventHandler
    public void a(final PlayerDeathEvent e) {
        if (e.getEntity() instanceof Player && e.getEntity().getKiller() instanceof Player) {
            final Player killer = e.getEntity().getKiller();
            final Player killed = e.getEntity();
            killed.teleport(killed.getWorld().getSpawnLocation());
            
            e.setDeathMessage((String)null);
            
            ZeyCoins.addMoney(killer, 50);
            ZeyCoins.removeMoney(killed, 50);
            
        }
    }
}
