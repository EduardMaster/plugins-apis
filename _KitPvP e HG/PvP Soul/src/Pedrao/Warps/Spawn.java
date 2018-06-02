package Pedrao.Warps;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Pedrao.KitAPI;
import Pedrao.Main;
import Pedrao.Eventos.Habilidade;

public class Spawn
implements Listener,
CommandExecutor {
    public static Main plugin;

    public Spawn(Main main) {
        plugin = main;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("spawn")) {
            final Player p = (Player)sender;
            p.getInventory().clear();
            p.getInventory().setBoots(null);
            p.getInventory().setChestplate(null);
            p.getInventory().setLeggings(null);
            p.getInventory().setHelmet(null);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
            p.sendMessage(Main.prefix + "Teleportando em 5 segundos! ");
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)plugin, new Runnable(){

                @Override
                public void run() {
                    World w = Bukkit.getServer().getWorld(Spawn.plugin.getConfig().getString("spawn.world"));
                    double x = Spawn.plugin.getConfig().getDouble("spawn.x");
                    double y = Spawn.plugin.getConfig().getDouble("spawn.y");
                    double z = Spawn.plugin.getConfig().getDouble("spawn.z");
                    Location lobby = new Location(w, x, y, z);
                    lobby.setPitch((float)Spawn.plugin.getConfig().getDouble("spawn.pitch"));
                    lobby.setYaw((float)Spawn.plugin.getConfig().getDouble("spawn.yaw"));
                    KitAPI.remove(p);
                    Habilidade.removeAbility(p);
                    p.getInventory().setBoots(null);
                    p.getInventory().setChestplate(null);
                    p.getInventory().setLeggings(null);
                    p.getInventory().setHelmet(null);
                    p.getInventory().clear();
                    p.teleport(lobby);
                    p.setExp(0.0f);
                    p.setExhaustion(20.0f);
                    p.setFireTicks(0);
                    p.setFoodLevel(20000);
                    p.setHealth(20.0);
            		KitAPI.setitem(p, Material.CHEST, "§4§lKits §7(CLICK)", 0, Enchantment.DAMAGE_ALL, 0, false);
            		KitAPI.setitem(p, Material.STORAGE_MINECART, "§4§lKitDiario §7(CLICK)", 1, Enchantment.DAMAGE_ALL, 0, false);
            		KitAPI.setitem(p, Material.EMERALD, "§4§lLoja §7(CLICK)", 7, Enchantment.DAMAGE_ALL, 0, false);
            		KitAPI.setitem(p, Material.COMPASS, "§4§lWarps §7(CLICK)", 8, Enchantment.DAMAGE_ALL, 0, false);
            		KitAPI.setitem(p, Material.SKULL_ITEM, "§4§lStatus §7(CLICK)", 4, Enchantment.DAMAGE_ALL, 0, false);
                    for (PotionEffect effect : p.getActivePotionEffects()) {
                        p.removePotionEffect(effect.getType());
                    }
                }
            }, 90);
        }
        return false;
    }

}

