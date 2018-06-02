package Zey.PvP.Kits;

import java.util.*;

import Zey.PvP.Essencial.*;
import Zey.PvP.Main.*;

import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.util.Vector;

import java.util.concurrent.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.potion.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class Thresh implements Listener
{
    public static HashMap<String, Long> cooldown;
    public static HashMap<String, Snowball> tiros;
    
    static {
        Thresh.cooldown = new HashMap<String, Long>();
        Thresh.tiros = new HashMap<String, Snowball>();
    }
    
    public Thresh(final Main main) {
    }
    
    @EventHandler
    public void disparar(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.LEVER && KitAPI.Thresh.contains(p.getName())) {
            if (!Thresh.cooldown.containsKey(p.getName()) || Thresh.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
                e.setCancelled(true);
                p.updateInventory();
				final Snowball tiro = (Snowball)p.launchProjectile((Class<? extends Projectile>)Snowball.class);
                final Vector vec = p.getLocation().getDirection();
                tiro.setVelocity(new Vector(vec.getX() * 1.0 * 3.5, vec.getY() * 1.0 * 4.0, vec.getZ() * 1.0 * 3.5));
                Thresh.tiros.put(p.getName(), tiro);
                Thresh.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(15L));
                p.playSound(p.getLocation(), Sound.GLASS, 1.0f, 1.0f);
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §aVocê usou seu Thresh.");
                return;
            }
            p.sendMessage(String.valueOf(Main.prefix) + " §7» §cAguarde o cooldown terminar.");
        }
    }
    
    @SuppressWarnings("deprecation")
	@EventHandler
    public void onEntityDamagerByEntity(final EntityDamageByEntityEvent e) {
        final Entity ent = e.getEntity();
        final Entity damager = e.getDamager();
        if (ent instanceof Player) {
            final Player hit = (Player)ent;
            if (damager instanceof Snowball) {
                final Snowball snowball = (Snowball)damager;
                if (snowball.getShooter() instanceof Player) {
                    final Player shooter = (Player)snowball.getShooter();
                    if (!KitAPI.Thresh.contains(shooter.getName())) {
                        return;
                    }
                    final Location ploc = shooter.getLocation();
                    hit.teleport(ploc);
                    hit.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 1));
                    hit.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 1));
                    hit.sendMessage(String.valueOf(Main.prefix) + " §7» §cVocê foi pego por um Thresh.");
                }
            }
        }
    }
}
