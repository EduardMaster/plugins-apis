package Zey.PvP.Kits;

import java.util.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.util.Vector;
import org.bukkit.inventory.*;

import Zey.PvP.Config.ZeyCoins;
import Zey.PvP.Essencial.*;
import Zey.PvP.Eventos.*;
import Zey.PvP.Main.*;

import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;

public class C4 implements Listener
{
    public static HashMap<String, Item> bomba;
    
    static {
        C4.bomba = new HashMap<String, Item>();
    }
    
    @EventHandler
    public void aoBotar(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (Habilidade.getAbility(p).equalsIgnoreCase("C4")) {
            if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if (p.getItemInHand().getType() == Material.SLIME_BALL) {
                    if (Cooldown.add(p)) {
                        KitUtil.MensagemCooldown(p);
                        return;
                    }
                    final Location loc = p.getLocation();
                    final Vector vec = new Vector(0, 2, 0);
                    final Location direc = loc.add(vec);
                    final Item item = p.getWorld().dropItem(direc, new ItemStack(Material.TNT, 1));
                    item.setVelocity(p.getEyeLocation().getDirection());
                    C4.bomba.put(p.getName(), item);
                    final ItemStack itemb = new ItemStack(Material.STONE_BUTTON);
                    final ItemMeta itembm = itemb.getItemMeta();
                    itembm.setDisplayName("§e§lC4");
                    itemb.setItemMeta(itembm);
                    p.getInventory().setItemInHand(itemb);
                    p.updateInventory();
                    p.sendMessage(String.valueOf(Main.prefix) + " §7» §cSua C4 foi implantada");
                }
                
                else if (p.getItemInHand().getType() == Material.STONE_BUTTON) {
                    final ItemStack itemb2 = new ItemStack(Material.SLIME_BALL);
                    final ItemMeta itembm2 = itemb2.getItemMeta();
                    itembm2.setDisplayName("§e§lC4");
                    itemb2.setItemMeta(itembm2);
                    p.getInventory().setItemInHand(itemb2);
                    final Item item2 = C4.bomba.get(p.getName());
                    p.getWorld().createExplosion(item2.getLocation(), 2.5f);
                    item2.getWorld().playEffect(item2.getLocation(), Effect.EXPLOSION_HUGE, 10);
                    C4.bomba.remove(p.getName());
                    item2.remove();
                    p.updateInventory();
                    p.sendMessage(String.valueOf(Main.prefix) + " §7» §aSua C4 foi ativada");
                    Cooldown.add(p, 20);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            KitUtil.ccooldown(p);
                        }
                    }, 400L);
                }
            }
            else if ((e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.STONE_BUTTON) {
                if (Cooldown.add(p)) {
                    KitUtil.MensagemCooldown(p);
                    return;
                }
                final ItemStack itemb2 = new ItemStack(Material.SLIME_BALL);
                final ItemMeta itembm2 = itemb2.getItemMeta();
                itembm2.setDisplayName("§e§lC4");
                itemb2.setItemMeta(itembm2);
                p.getInventory().setItemInHand(itemb2);
                final Item item2 = C4.bomba.get(p.getName());
                C4.bomba.remove(p.getName());
                item2.remove();
                p.updateInventory();
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §aC4 Desarmada");
            }
        }
    }
    
    @EventHandler
    public void aomorrer(final PlayerDeathEvent e) {
        final Player p = e.getEntity();
        if (C4.bomba.containsKey(p.getName())) {
            final Item item = C4.bomba.get(p.getName());
            item.remove();
            C4.bomba.remove(p.getName());
            
            ZeyCoins.removeMoney(p, 50);
            
            KitAPI.remove(p);
            Habilidade.removeAbility(p);
            KitAPI.removeAbility(p);
            p.setGameMode(GameMode.SURVIVAL);
            
            Zey.PvP.APIs.WarpAPI.setWarp(p, "Spawn");
        }
    }
}
