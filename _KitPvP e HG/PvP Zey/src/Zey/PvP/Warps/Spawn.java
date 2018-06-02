package Zey.PvP.Warps;

import org.bukkit.event.*;

import Zey.PvP.APIs.TheTitle;
import Zey.PvP.Commands.AdminCommand;
import Zey.PvP.Commands.BuildCommand;
import Zey.PvP.Essencial.*;
import Zey.PvP.Eventos.*;
import Zey.PvP.Main.*;
import Zey.PvP.Utils.Proteção;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.potion.*;
import org.bukkit.enchantments.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;
import java.util.*;
import org.bukkit.plugin.*;

@SuppressWarnings("unused")
public class Spawn implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Spawn(final Main main) {
        Spawn.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("spawn")) {
        	
            final Player p = (Player)sender;
            p.getInventory().clear();
            p.getInventory().setBoots((ItemStack)null);
            p.getInventory().setChestplate((ItemStack)null);
            p.getInventory().setLeggings((ItemStack)null);
            p.getInventory().setHelmet((ItemStack)null);
            p.setHealthScale(1.0);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
            p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você está sendo teleportando para Warp §a§lSPAWN");
            
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Spawn.plugin, (Runnable)new Runnable() {
            	
				@SuppressWarnings("deprecation")
				@Override
                public void run() {
                	
                    final World w = Bukkit.getServer().getWorld(Spawn.plugin.getConfig().getString("spawn.world"));
                    final double x = Spawn.plugin.getConfig().getDouble("spawn.x");
                    final double y = Spawn.plugin.getConfig().getDouble("spawn.y");
                    final double z = Spawn.plugin.getConfig().getDouble("spawn.z");
                    final Location lobby = new Location(w, x, y, z);
                    lobby.setPitch((float)Spawn.plugin.getConfig().getDouble("spawn.pitch"));
                    lobby.setYaw((float)Spawn.plugin.getConfig().getDouble("spawn.yaw"));
                    
                    
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
                    
                    Zey.PvP.APIs.WarpAPI.setWarp(p, "Spawn");
                    
                    p.getInventory().setBoots((ItemStack)null);
                    p.getInventory().setChestplate((ItemStack)null);
                    p.getInventory().setLeggings((ItemStack)null);
                    p.getInventory().setHelmet((ItemStack)null);
                    p.getInventory().clear();
                    p.teleport(lobby);
                    
                    p.setExp(0.0f);
                    p.setHealthScale(20.0);
                    p.setExhaustion(20.0f);
                    p.setFireTicks(0);
                    p.setFoodLevel(20000);
                    p.setHealth(20.0);
                    
                    TheTitle.sendTitle(p, "§e§lSPAWN");
                    
            		Proteção.setImortal(p, true);
            		Proteção.isImortal(p);
            		
                	final ItemStack vidrohot = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)0);
                    final ItemMeta vidrohotx = vidrohot.getItemMeta();
                    vidrohotx.setDisplayName("§6§lZey§f§lPvP");
                    vidrohot.setItemMeta(vidrohotx);
                    
                    p.getInventory().setItem(0, vidrohot);
                    p.getInventory().setItem(1, vidrohot);
                    KitAPI.setitem(p, Material.PAPER, "§e§lWARPS", 2, Enchantment.DAMAGE_ALL, 0, false);
                    p.getInventory().setItem(3, vidrohot);
                    KitAPI.setitem(p, Material.ENDER_CHEST, "§e§lKITS", 4, Enchantment.DAMAGE_ALL, 0, false);
                    p.getInventory().setItem(5, vidrohot);
                    KitAPI.setitem(p, Material.BOOK, "§e§lMENU GERAL", 6, Enchantment.DAMAGE_ALL, 0, false);
                    p.getInventory().setItem(7, vidrohot);
                    p.getInventory().setItem(8, vidrohot);

                    
                    for (final PotionEffect effect : p.getActivePotionEffects()) {
                        p.removePotionEffect(effect.getType());
                    }
                }
            }, 90L);
        }
        return false;
    }
}
