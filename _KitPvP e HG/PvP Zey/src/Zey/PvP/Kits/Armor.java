package Zey.PvP.Kits;

import java.util.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;

import Zey.PvP.Essencial.*;
import Zey.PvP.Eventos.*;
import Zey.PvP.Main.*;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.inventory.*;

public class Armor implements Listener
{
    public static HashMap<String, ItemStack[]> salvararmor;
    
    static {
        Armor.salvararmor = new HashMap<String, ItemStack[]>();
    }
    
    public static ItemStack darArmaduraI(final Material material) {
        final ItemStack item = new ItemStack(material);
        final ItemMeta itemm = item.getItemMeta();
        item.setItemMeta(itemm);
        return item;
    }
    
    @EventHandler
    public void aoArmor(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (Habilidade.getAbility(p).equalsIgnoreCase("Armor") && (e.getAction() == Action.RIGHT_CLICK_AIR 
        		|| e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.GOLD_INGOT) {
            if (Cooldown.add(p)) {
                KitUtil.MensagemCooldown(p);
                return;
            }
            Armor.salvararmor.put(p.getName(), p.getInventory().getArmorContents());
            KitUtil.tirarArmadura(p);
            p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você recebeu sua armadura temporaria.");
            p.getInventory().setArmorContents(new ItemStack[] { darArmaduraI(Material.GOLD_HELMET), darArmaduraI(Material.GOLD_CHESTPLATE), darArmaduraI(Material.GOLD_LEGGINGS), darArmaduraI(Material.GOLD_BOOTS) });
            p.updateInventory();
            Cooldown.add(p, 25);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    KitUtil.tirarArmadura(p);
                    p.getInventory().setArmorContents((ItemStack[])Armor.salvararmor.get(p.getName()));
                    Armor.salvararmor.remove(p.getName());
                    p.updateInventory();
                }
            }, 200L);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    KitUtil.ccooldown(p);
                }
            }, 500L);
        }
    }
    
    @EventHandler
    public void aomecher(final InventoryClickEvent e) {
        try {
            final Player p = (Player)e.getWhoClicked();
            if (Armor.salvararmor.containsKey(p.getName()) && e.getSlotType().equals((Object)InventoryType.SlotType.ARMOR)) {
                e.setCancelled(true);
            }
        }
        catch (Exception ex) {}
    }
}
