package Zey.PvP.Kits;

import org.bukkit.event.player.*;

import Zey.PvP.Essencial.*;
import Zey.PvP.Eventos.*;
import Zey.PvP.Main.*;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class Rain implements Listener
{
    @SuppressWarnings("deprecation")
    @EventHandler
    public void onCage(final PlayerInteractEntityEvent e) {
        if (!(e.getRightClicked() instanceof Player)) {
            return;
        }
        final Player p = e.getPlayer();
        final Player t = (Player)e.getRightClicked();
        if (Habilidade.getAbility(p).equalsIgnoreCase("Rain") && p.getItemInHand().getType() == Material.ARROW) {
            if (Cooldown.add(p)) {
                KitUtil.MensagemCooldown(p);
                return;
            }
            Cooldown.add(p, 25);
            final Location loc = t.getLocation();
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
				@Override
                public void run() {
                    p.shootArrow();
                    loc.setY(loc.getY() + 1.0);
                    final Entity r = t.getWorld().spawnEntity(loc, EntityType.ARROW);
                    r.setVelocity(r.getVelocity().multiply(8));
                }
            }, 0L);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.shootArrow();
                    loc.setY(loc.getY() + 1.0);
                    final Entity r = t.getWorld().spawnEntity(loc, EntityType.ARROW);
                    r.setVelocity(r.getVelocity().multiply(8));
                }
            }, 10L);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.shootArrow();
                    loc.setY(loc.getY() + 1.0);
                    final Entity r = t.getWorld().spawnEntity(loc, EntityType.ARROW);
                    r.setVelocity(r.getVelocity().multiply(8));
                }
            }, 15L);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.shootArrow();
                    loc.setY(loc.getY() + 1.0);
                    final Entity r = t.getWorld().spawnEntity(loc, EntityType.ARROW);
                    r.setVelocity(r.getVelocity().multiply(8));
                }
            }, 20L);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.shootArrow();
                    loc.setY(loc.getY() + 1.0);
                    final Entity r = t.getWorld().spawnEntity(loc, EntityType.ARROW);
                    r.setVelocity(r.getVelocity().multiply(8));
                }
            }, 25L);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.shootArrow();
                    loc.setY(loc.getY() + 1.0);
                    final Entity r = t.getWorld().spawnEntity(loc, EntityType.ARROW);
                    r.setVelocity(r.getVelocity().multiply(8));
                }
            }, 30L);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.shootArrow();
                    loc.setY(loc.getY() + 1.0);
                    final Entity r = t.getWorld().spawnEntity(loc, EntityType.ARROW);
                    r.setVelocity(r.getVelocity().multiply(8));
                }
            }, 35L);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    KitUtil.ccooldown(p);
                }
            }, 500L);
        }
    }
}
