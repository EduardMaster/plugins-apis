package Zey.PvP.Kits;

import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

import Zey.PvP.Eventos.*;

public class Switcher implements Listener
{
    @SuppressWarnings("deprecation")
	@EventHandler
    public void snowball(final EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Snowball && e.getEntity() instanceof Player) {
            final Snowball s = (Snowball)e.getDamager();
            if (s.getShooter() instanceof Player) {
                final Player shooter = (Player)s.getShooter();
                if (Habilidade.getAbility(shooter).equalsIgnoreCase("Switcher")) {
                    final Location shooterLoc = shooter.getLocation();
                    shooter.teleport(e.getEntity().getLocation());
                    e.getEntity().teleport(shooterLoc);
                    shooter.getPlayer().getWorld().playEffect(shooterLoc, Effect.ENDER_SIGNAL, 10);
                    shooter.getPlayer().getWorld().playEffect(shooterLoc, Effect.EXTINGUISH, 10);
                    shooter.getWorld().playSound(shooter.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.2f);
                }
            }
        }
    }
    
    @EventHandler
    public void aomatar(final PlayerDeathEvent e) {
        final Player matou = e.getEntity().getKiller();
        if (e.getEntity().getKiller() instanceof Player && Habilidade.getAbility(matou).equalsIgnoreCase("Switcher")) {
            final ItemStack item = new ItemStack(Material.SNOW_BALL);
            final ItemMeta itemm = item.getItemMeta();
            itemm.setDisplayName("§e§lSWITCHER");
            item.setItemMeta(itemm);
            matou.getInventory().addItem(new ItemStack[] { item });
            matou.updateInventory();
        }
    }
}
