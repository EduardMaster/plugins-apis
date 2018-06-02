package Zey.PvP.Warps;

import org.bukkit.event.*;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import Zey.PvP.APIs.TheTitle;
import Zey.PvP.APIs.WarpAPI;
import Zey.PvP.Commands.BuildCommand;
import Zey.PvP.Essencial.*;
import Zey.PvP.Eventos.*;
import Zey.PvP.Main.*;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.potion.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import java.util.*;
import org.bukkit.plugin.*;
import org.bukkit.*;
import Zey.PvP.Utils.Proteção;

@SuppressWarnings("unused")
public class Parkour implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Parkour(final Main main) {
        Parkour.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("parkour")) {
            final Player p = (Player)sender;
            
            final World w = Bukkit.getServer().getWorld(Parkour.plugin.getConfig().getString("parkour.world"));
            final double x = Parkour.plugin.getConfig().getDouble("parkour.x");
            final double y = Parkour.plugin.getConfig().getDouble("parkour.y");
            final double z = Parkour.plugin.getConfig().getDouble("parkour.z");
            final Location lobby = new Location(w, x, y, z);
            lobby.setPitch((float)Parkour.plugin.getConfig().getDouble("parkour.pitch"));
            lobby.setYaw((float)Parkour.plugin.getConfig().getDouble("parkour.yaw"));
            
            p.getInventory().clear();
            p.setHealthScale(1.0);
            p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você está sendo teleportando para Warp §a§lPARKOUR");
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Parkour.plugin, (Runnable)new Runnable() {
                @SuppressWarnings("deprecation")
				@Override
                public void run() {
                    p.teleport(lobby);
                    p.getInventory().clear();
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage(String.valueOf(Main.prefix) + " §7» §aTeleportado com sucesso");
                    
                    TheTitle.sendTitle(p, "§e§lPARKOUR");
                    
                	if (p.hasPermission("zey.pvp.admin") &&  	
        					Zey.PvP.APIs.WarpAPI.getWarp(p) == "Nenhuma") {
    					Main.admins.remove(p.getName());
    					p.sendMessage(String.valueOf(Main.prefix) + " §7» Você saiu do modo §c§lADMIN");
    					
    					for (Player players : Bukkit.getOnlinePlayers()) {
    						players.showPlayer(p);
    					}
                	}
                    
                    p.setAllowFlight(false);
                    p.setFlying(false);
                    
                    KitAPI.remove(p);
                    Habilidade.removeAbility(p);
                    KitAPI.removeAbility(p);
                    BuildCommand.embuild.remove(p);
                    p.setGameMode(GameMode.SURVIVAL);
                    
                    WarpAPI.setWarp(p, "Parkour");
                    
                    p.getInventory().setBoots((ItemStack)null);
                    p.getInventory().setChestplate((ItemStack)null);
                    p.getInventory().setLeggings((ItemStack)null);
                    p.getInventory().setHelmet((ItemStack)null);
                    p.setHealthScale(20.0);
            		
            		Proteção.setImortal(p, true);
            		Proteção.isImortal(p);
            		
                    final ItemStack KitPadrao2 = new ItemStack(Material.REDSTONE, 1, (short)0);
                    final ItemMeta kKitPadrao2 = KitPadrao2.getItemMeta();
                    kKitPadrao2.setDisplayName("§c§lVOLTAR");
                    KitPadrao2.setItemMeta(kKitPadrao2);
                    p.getInventory().setItem(4, KitPadrao2);
                    p.setFireTicks(0);
                    for (final PotionEffect effect : p.getActivePotionEffects()) {
                        p.removePotionEffect(effect.getType());
                    }
                }
                
            }, 90L);
            return false;
        }
        return false;
    }
}
