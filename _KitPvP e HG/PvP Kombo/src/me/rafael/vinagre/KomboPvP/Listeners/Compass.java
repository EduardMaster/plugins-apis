package me.rafael.vinagre.KomboPvP.Listeners;

import org.bukkit.event.player.*;

import Vinagre.*;

import org.bukkit.*;
import org.bukkit.event.block.*;
import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.event.*;

public class Compass implements Listener
{
    @EventHandler
    public void onCompass(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (Array.kit.get(p) != "Nenhum" && p.getItemInHand().getType() == Material.COMPASS && (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR)) {
            Boolean pesquisado = false;
            for (int i = 0; i < 1000; ++i) {
                final List<Entity> pertos = (List<Entity>)p.getNearbyEntities((double)i, 128.0, (double)i);
                for (final Object e : pertos) {
                    if (((Entity)e).getType().equals((Object)EntityType.PLAYER) && p.getLocation().distance(((Entity)e).getLocation()) > 0.0) {
                        p.setCompassTarget(((Entity)e).getLocation());
                        p.sendMessage(String.valueOf( "§fBussola apontando para: §5" + ((Player)e).getName()));
                        pesquisado = true;
                        break;
                    }
                }
                if (pesquisado) {
                    break;
                }
            }
            if (!pesquisado) {
                p.sendMessage(String.valueOf("§cNenhum jogador encontrado bussola apontando para o spawn!"));
                p.setCompassTarget(p.getWorld().getSpawnLocation());
            }
        }
    }
}

