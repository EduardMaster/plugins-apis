package Zey.PvP.Kits;

import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.potion.*;
import org.bukkit.*;

import Zey.PvP.Essencial.*;
import Zey.PvP.Eventos.*;
import Zey.PvP.Main.*;

import org.bukkit.entity.*;
import org.bukkit.event.*;

public class Confuser implements Listener
{
    @EventHandler
    public void onConfusao(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (Habilidade.getAbility(p).equalsIgnoreCase("Confuser") && (e.getAction() == Action.RIGHT_CLICK_AIR 
        		|| e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.COAL) {
            e.setCancelled(true);
            if (Cooldown.add(p)) {
                KitUtil.MensagemCooldown(p);
                return;
            }
            Cooldown.add(p, 40);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 1));
            for (final Entity pertos : p.getNearbyEntities(5.0, 5.0, 5.0)) {
                ((LivingEntity)pertos).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 1));
                ((LivingEntity)pertos).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 2));
            }
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    KitUtil.ccooldown(p);
                }
            }, 800L);
        }
    }
}
