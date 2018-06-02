package Zey.PvP.Kits;

import Zey.PvP.Essencial.*;
import Zey.PvP.Main.*;

import org.bukkit.event.player.*;
import org.bukkit.entity.*;
import org.bukkit.block.*;
import org.bukkit.event.*;

public class Fisherman implements Listener
{
    public Fisherman(final Main main) {
    }
    
    @EventHandler
    public void onPlayerFish(final PlayerFishEvent event) {
        final Entity caught = event.getCaught();
        final Block block = event.getHook().getLocation().getBlock();
        if (caught != null && caught != block && KitAPI.Fisherman.contains(event.getPlayer().getName())) {
            caught.teleport(event.getPlayer().getLocation());
        }
    }
}
