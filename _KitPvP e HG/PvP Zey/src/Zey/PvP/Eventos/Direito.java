package Zey.PvP.Eventos;

import org.bukkit.event.player.*;
import org.bukkit.event.block.*;

import Zey.PvP.Menus.*;
import Zey.PvP.Warps.*;

import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.*;

public class Direito implements Listener
{
    @EventHandler
    public void AbrirMenuGeral(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (p.getItemInHand().getType().equals((Object)Material.BOOK) 
        		&& p.getItemInHand().getItemMeta().hasDisplayName() 
        		&& p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lMENU GERAL") &&  	
				Zey.PvP.APIs.WarpAPI.getWarp(p) == "Spawn") {
        	
            e.setCancelled(true);
            if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {e.setCancelled(true);
            p.playSound(p.getLocation(), Sound.DOOR_OPEN, 5.0f, 5.0f);
            MenuGeral1.guiKits(p);
            }
        }
    }
    
    @EventHandler
    public void AbrirMenuKits(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (p.getItemInHand().getType().equals((Object)Material.ENDER_CHEST) 
        		&& p.getItemInHand().getItemMeta().hasDisplayName() 
        		&& p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lKITS") &&  	
				Zey.PvP.APIs.WarpAPI.getWarp(p) == "Spawn") {
        	
            e.setCancelled(true);
            if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {e.setCancelled(true);
            p.playSound(p.getLocation(), Sound.DOOR_OPEN, 5.0f, 5.0f);
            MenuKits.GuiKit(p);
            }
        }
    }
    
    @EventHandler
    public void AbrirMenuWarps(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (p.getItemInHand().getType().equals((Object)Material.PAPER) 
        		&& p.getItemInHand().getItemMeta().hasDisplayName() 
        		&& p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lWARPS") &&  	
				Zey.PvP.APIs.WarpAPI.getWarp(p) == "Spawn") {
        	
            e.setCancelled(true);
            if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {e.setCancelled(true);
            p.playSound(p.getLocation(), Sound.DOOR_OPEN, 5.0f, 5.0f);
            MenuWarps.guiKits(p);
            }
        }
    }
    
    @EventHandler
    public void ReiniciarParkour(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (p.getItemInHand().getType().equals((Object)Material.REDSTONE) 
        		&& p.getItemInHand().getItemMeta().hasDisplayName() 
        		&& p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lVOLTAR") &&  	
				Zey.PvP.APIs.WarpAPI.getWarp(p) == "Parkour") {
        	
            e.setCancelled(true);
            if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {e.setCancelled(true);
            p.playSound(p.getLocation(), Sound.DOOR_OPEN, 5.0f, 5.0f);
            final World w = Bukkit.getServer().getWorld(Parkour.plugin.getConfig().getString("parkour.world"));
            final double x = Parkour.plugin.getConfig().getDouble("parkour.x");
            final double y = Parkour.plugin.getConfig().getDouble("parkour.y");
            final double z = Parkour.plugin.getConfig().getDouble("parkour.z");
            final Location lobby = new Location(w, x, y, z);
            lobby.setPitch((float)Parkour.plugin.getConfig().getDouble("parkour.pitch"));
            lobby.setYaw((float)Parkour.plugin.getConfig().getDouble("parkour.yaw"));
            p.teleport(lobby);
            p.setHealthScale(20.0);
        }
    }
  }
}
