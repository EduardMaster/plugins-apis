package Zey.PvP.Kits;

import org.bukkit.entity.*;
import org.bukkit.event.entity.*;

import Zey.PvP.Eventos.*;
import Zey.PvP.Main.*;

import org.bukkit.event.*;

public class Turtle implements Listener
{
    @EventHandler
    public void onEntityDamage(final EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        final Player p = (Player)e.getEntity();
        if (Habilidade.getAbility(p).equalsIgnoreCase("Turtle") && p.isSneaking() && (e.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION 
        		|| e.getCause() == EntityDamageEvent.DamageCause.CONTACT || e.getCause() == EntityDamageEvent.DamageCause.CUSTOM 
        		|| e.getCause() == EntityDamageEvent.DamageCause.DROWNING || e.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK || e.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION || e.getCause() == EntityDamageEvent.DamageCause.FALL || e.getCause() == EntityDamageEvent.DamageCause.FALLING_BLOCK || e.getCause() == EntityDamageEvent.DamageCause.FIRE || e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK || e.getCause() == EntityDamageEvent.DamageCause.LAVA || e.getCause() == EntityDamageEvent.DamageCause.LIGHTNING || e.getCause() == EntityDamageEvent.DamageCause.MAGIC || e.getCause() == EntityDamageEvent.DamageCause.MELTING || e.getCause() == EntityDamageEvent.DamageCause.POISON || e.getCause() == EntityDamageEvent.DamageCause.PROJECTILE || e.getCause() == EntityDamageEvent.DamageCause.STARVATION || e.getCause() == EntityDamageEvent.DamageCause.SUFFOCATION || e.getCause() == EntityDamageEvent.DamageCause.THORNS || e.getCause() == EntityDamageEvent.DamageCause.VOID || e.getCause() == EntityDamageEvent.DamageCause.WITHER)) {
            e.setDamage(1.0);
        }
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerTurleDamage(final EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        if (!(e.getDamager() instanceof Player)) {
            return;
        }
        final Player p = (Player)e.getDamager();
        if (!p.isSneaking()) {
            return;
        }
        if (Habilidade.getAbility(p).equalsIgnoreCase("Turtle")) {
            e.setCancelled(true);
            p.sendMessage(String.valueOf(Main.prefix) + " §7» §cVocê não pode `hitar' em quanto estiver de SHIFT.");
        }
    }
}
