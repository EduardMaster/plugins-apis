package Zey.PvP.Menus;

import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.command.*;
import org.bukkit.event.inventory.*;
import org.bukkit.*;
import org.bukkit.event.*;

public class MenuEventos implements Listener, CommandExecutor
{
    @SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public static void guiKits(final Player p) {
        final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder)p, 54, "§7» §e§lWARPS");
        final ItemStack pyro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
        final ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§c§lVOLTAR");
        final ArrayList descpyro1 = new ArrayList();
        metapyro.setLore((List)descpyro1);
        pyro.setItemMeta(metapyro);
        inv.setItem(0, pyro);
        final ItemStack event456 = new ItemStack(Material.INK_SACK, 1, (short)8);
        final ItemMeta event456v = event456.getItemMeta();
        event456v.setDisplayName("§e§lTREINO");
        event456.setItemMeta(event456v);
        inv.setItem(12, event456);
        final ItemStack event457 = new ItemStack(Material.INK_SACK, 1, (short)10);
        final ItemMeta eventv1 = event457.getItemMeta();
        eventv1.setDisplayName("§e§lEVENTOS");
        event457.setItemMeta(eventv1);
        inv.setItem(14, event457);
        final ItemStack event458 = new ItemStack(Material.CAKE, 1, (short)0);
        final ItemMeta eventv2 = event458.getItemMeta();
        eventv2.setDisplayName("§e§lMDR");
        event458.setItemMeta(eventv2);
        inv.setItem(30, event458);
        final ItemStack event459 = new ItemStack(Material.IRON_FENCE, 1, (short)0);
        final ItemMeta eventv3 = event459.getItemMeta();
        eventv3.setDisplayName("§e§lRDM");
        event459.setItemMeta(eventv3);
        inv.setItem(32, event459);
        ItemStack[] arrayOfItemStack;
        for (int descpyro2 = (arrayOfItemStack = inv.getContents()).length, metapyro2 = 0; metapyro2 < descpyro2; ++metapyro2) {
            final ItemStack itemStack = arrayOfItemStack[metapyro2];
        }
        p.openInventory(inv);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (commandLabel.equalsIgnoreCase("warps")) {
            final Player p = (Player)sender;
            guiKits(p);
        }
        return false;
    }
    
    @SuppressWarnings("deprecation")
	@EventHandler
    public void onPlayerCLickInventry(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getTitle().equalsIgnoreCase("§7» §e§lWARPS") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lTREINO")) {
                e.setCancelled(true);
                p.closeInventory();
                MenuWarps.guiKits(p);
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lVOLTAR")) {
                e.setCancelled(true);
                p.closeInventory();
                MenuGeral.guiKits(p);
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lMDR")) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/mdr");
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lRDM")) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/rdm");
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
            }
        }
    }
    
    public static void ir(final Player p, final String string) {
    }
}
