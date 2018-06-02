package Zey.PvP.Kits;

import org.bukkit.inventory.*;

import Zey.PvP.Essencial.*;
import Zey.PvP.Main.*;

import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.util.Vector;
import org.bukkit.entity.*;
import org.bukkit.potion.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.*;
import java.util.*;
import org.bukkit.event.*;

public class Sonic implements Listener
{
    public int boost;
    public static ArrayList<String> Sonic;
    public static HashMap<String, ItemStack[]> Armadura;
    public static Main plugin;
    public static HashMap<String, ItemStack[]> saveinv;
    public static HashMap<String, ItemStack[]> armadura;
    public static HashMap<String, ItemStack[]> Armadura2;
    public static List<Player> cooldownm;
    
    static {
        Zey.PvP.Kits.Sonic.Sonic = new ArrayList<String>();
        Zey.PvP.Kits.Sonic.Armadura = new HashMap<String, ItemStack[]>();
        Zey.PvP.Kits.Sonic.saveinv = new HashMap<String, ItemStack[]>();
        Zey.PvP.Kits.Sonic.armadura = new HashMap<String, ItemStack[]>();
        Zey.PvP.Kits.Sonic.Armadura2 = new HashMap<String, ItemStack[]>();
        Zey.PvP.Kits.Sonic.cooldownm = new ArrayList<Player>();
    }
    
    public Sonic(final Main main) {
        this.boost = Integer.valueOf(6);
    }
    
    @EventHandler
    public void SonicLick(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (event.getPlayer().getItemInHand().getType() == Material.LAPIS_BLOCK && KitAPI.Sonic.contains(event.getPlayer().getName())) {
            if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK 
            		|| event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
                event.setCancelled(true);
            }
            if (Zey.PvP.Kits.Sonic.cooldownm.contains(p)) {
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §cAguarde o cooldown terminar.");
                return;
            }
            Zey.PvP.Kits.Sonic.cooldownm.add(p);
            p.setVelocity(p.getEyeLocation().getDirection().multiply(this.boost).add(new Vector(0, 0, 0)));
            p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 10, 0);
            p.getLocation();
            for (final Entity pertos : p.getNearbyEntities(8.0, 8.0, 8.0)) {
                if (pertos instanceof Player) {
                    ((Player)pertos).damage(10.0);
                    pertos.setVelocity(new Vector(0.1, 0.0, 0.1));
                    ((Player)pertos).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 105, 105));
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 105, 105));
                }
            }
            final ItemStack Capacete = new ItemStack(Material.LEATHER_HELMET);
            final LeatherArmorMeta kCapacete = (LeatherArmorMeta)Capacete.getItemMeta();
            kCapacete.setColor(Color.BLUE);
            Capacete.setItemMeta((ItemMeta)kCapacete);
            final ItemStack Peitoral = new ItemStack(Material.LEATHER_CHESTPLATE);
            final LeatherArmorMeta kPeitoral = (LeatherArmorMeta)Peitoral.getItemMeta();
            kPeitoral.setColor(Color.BLUE);
            Peitoral.setItemMeta((ItemMeta)kPeitoral);
            final ItemStack Calss = new ItemStack(Material.LEATHER_LEGGINGS);
            final LeatherArmorMeta kCalss = (LeatherArmorMeta)Calss.getItemMeta();
            kCalss.setColor(Color.BLUE);
            Calss.setItemMeta((ItemMeta)kCalss);
            final ItemStack Bota = new ItemStack(Material.LEATHER_BOOTS);
            final LeatherArmorMeta kBota = (LeatherArmorMeta)Capacete.getItemMeta();
            kBota.setColor(Color.BLUE);
            Bota.setItemMeta((ItemMeta)kBota);
            Zey.PvP.Kits.Sonic.Armadura.put(p.getName(), p.getInventory().getArmorContents());
            p.getInventory().setHelmet(Capacete);
            p.getInventory().setChestplate(Peitoral);
            p.getInventory().setLeggings(Calss);
            p.getInventory().setBoots(Bota);
            p.updateInventory();
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.getInventory().setArmorContents((ItemStack[])null);
                    p.updateInventory();
                }
            }, 50L);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @SuppressWarnings("unlikely-arg-type")
				@Override
                public void run() {
                    Zey.PvP.Kits.Sonic.cooldownm.remove(p);
                    Zey.PvP.Kits.Sonic.Sonic.remove(p);
                    KitUtil.ccooldown(p);
                    p.getWorld().playSound(p.getLocation(), Sound.BURP, 5.0f, 5.0f);
                }
            }, 700L);
        }
    }
}
