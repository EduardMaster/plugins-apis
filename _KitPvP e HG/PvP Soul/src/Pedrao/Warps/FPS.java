/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.World
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandExecutor
 *  org.bukkit.command.CommandSender
 *  org.bukkit.configuration.file.FileConfiguration
 *  org.bukkit.entity.Player
 *  org.bukkit.event.Listener
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.PlayerInventory
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.potion.PotionEffect
 *  org.bukkit.potion.PotionEffectType
 */
package Pedrao.Warps;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Pedrao.KitAPI;
import Pedrao.Main;
import Pedrao.Eventos.Habilidade;

public class FPS
implements Listener,
CommandExecutor {
    public static Main plugin;

    public FPS(Main main) {
        plugin = main;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("fps")) {
            final Player p = (Player)sender;
            World w = Bukkit.getServer().getWorld(plugin.getConfig().getString("fps.world"));
            double x = plugin.getConfig().getDouble("fps.x");
            double y = plugin.getConfig().getDouble("fps.y");
            double z = plugin.getConfig().getDouble("fps.z");
            final Location lobby = new Location(w, x, y, z);
            lobby.setPitch((float)plugin.getConfig().getDouble("fps.pitch"));
            lobby.setYaw((float)plugin.getConfig().getDouble("fps.yaw"));
            p.getInventory().clear();
            p.setHealthScale(1.0);
            p.sendMessage("\u00a77Teleportando em 5 segundos! ");
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)plugin, new Runnable(){

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
                    p.sendMessage(Pedrao.Main.prefix + "Teleportado!");
                    KitAPI.remove(p);
                    Habilidade.setAbility(p, "fps");
                    p.getInventory().setBoots(null);
                    p.getInventory().setChestplate(null);
                    p.getInventory().setLeggings(null);
                    p.getInventory().setHelmet(null);
                    p.setHealthScale(20.0);
                    ItemStack espada = new ItemStack(Material.STONE_SWORD);
                    p.getInventory().setItem(0, espada);
                    p.setFireTicks(0);
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
                    for (PotionEffect effect : p.getActivePotionEffects()) {
                        p.removePotionEffect(effect.getType());
                    }
                }
            }, 90);
            return false;
        }
        return false;
    }

}

