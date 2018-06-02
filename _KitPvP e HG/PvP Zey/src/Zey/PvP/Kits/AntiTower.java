package Zey.PvP.Kits;

import org.bukkit.event.entity.*;

import Zey.PvP.Eventos.Habilidade;

import org.bukkit.entity.*;
import org.bukkit.event.*;

public class AntiTower implements Listener
{
    @EventHandler
    public void aogalinha(final EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
            final Player p = (Player)e.getEntity();
            if (Habilidade.getAbility(p) == "AntiTower"){
                e.setDamage(6.0D);
            }
        }
    }
}