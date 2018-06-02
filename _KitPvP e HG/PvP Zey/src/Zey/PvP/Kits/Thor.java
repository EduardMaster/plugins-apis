package Zey.PvP.Kits;

import org.bukkit.event.player.*;
import org.bukkit.event.block.*;

import java.util.*;

import Zey.PvP.Essencial.*;
import Zey.PvP.Eventos.*;
import Zey.PvP.Main.*;

import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.event.*;

public class Thor implements Listener
{
    @EventHandler
    public void ThorKit(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (Habilidade.getAbility(p).equalsIgnoreCase("Thor") && (e.getAction() == Action.RIGHT_CLICK_AIR 
        		|| e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.GOLD_AXE) {
            if (Cooldown.add(p)) {
                KitUtil.MensagemCooldown(p);
                return;
            }
            Cooldown.add(p, 5);
            @SuppressWarnings("deprecation")
			final Location loc = p.getTargetBlock((HashSet<Byte>)null, 30).getLocation();
            p.getWorld().strikeLightning(loc);
            e.setCancelled(true);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    KitUtil.ccooldown(p);
                }
            }, 100L);
        }
    }
}
