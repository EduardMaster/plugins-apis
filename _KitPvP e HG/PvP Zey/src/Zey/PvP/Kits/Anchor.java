package Zey.PvP.Kits;

import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import org.bukkit.util.*;
import org.bukkit.*;

import Zey.PvP.Eventos.*;
import Zey.PvP.Main.*;

import org.bukkit.plugin.*;
import org.bukkit.event.*;

public class Anchor implements Listener
{
    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerHitAnchor(final EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        if (!(e.getDamager() instanceof Player)) {
            return;
        }
        final Player p = (Player)e.getEntity();
        final Player a = (Player)e.getDamager();
        if (Habilidade.getAbility(p).equalsIgnoreCase("Anchor")) {
            p.setVelocity(new Vector());
            p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 4.0f, 4.0f);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.setVelocity(new Vector());
                }
            }, 1L);
        }
        if (Habilidade.getAbility(a).equalsIgnoreCase("Anchor")) {
            a.playSound(a.getLocation(), Sound.ANVIL_BREAK, 4.0f, 4.0f);
            p.setVelocity(new Vector());
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.setVelocity(new Vector());
                }
            }, 1L);
        }
    }
}
