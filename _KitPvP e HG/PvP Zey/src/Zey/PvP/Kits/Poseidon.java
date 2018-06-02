package Zey.PvP.Kits;

import org.bukkit.event.player.*;

import Zey.PvP.Essencial.*;
import Zey.PvP.Eventos.*;

import org.bukkit.*;
import org.bukkit.potion.*;
import org.bukkit.entity.*;
import org.bukkit.block.*;
import org.bukkit.event.*;

public class Poseidon implements Listener
{
    @EventHandler
    public void aoPoseidon(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        final Block b = p.getLocation().getBlock();
        if (Habilidade.getAbility(p).equalsIgnoreCase("Poseidon") && (b.getType() == Material.WATER || b.getType() == Material.STATIONARY_WATER)) {
            KitUtil.darEfeito(p, PotionEffectType.INCREASE_DAMAGE, 10, 1);
            KitUtil.darEfeito(p, PotionEffectType.DAMAGE_RESISTANCE, 10, 1);
            KitUtil.darEfeito(p, PotionEffectType.SPEED, 8, 0);
        }
    }
}
