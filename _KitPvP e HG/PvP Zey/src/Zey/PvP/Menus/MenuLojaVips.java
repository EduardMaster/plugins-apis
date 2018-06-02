package Zey.PvP.Menus;

import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

import org.bukkit.command.*;
import org.bukkit.event.inventory.*;
import org.bukkit.*;
import org.bukkit.event.*;

public class MenuLojaVips implements Listener, CommandExecutor
{
	public static void guiKits(final Player p) {
        final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder)p, 9, "§7» §e§lLOJA");
        
        final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)0);
        final ItemMeta vidrom = vidro.getItemMeta();
        vidrom.setDisplayName("§6§lZey§f§lPvP");
        vidro.setItemMeta(vidrom);
        inv.setItem(0, vidro);
        inv.setItem(1, vidro);
        inv.setItem(3, vidro);
        inv.setItem(5, vidro);
        inv.setItem(7, vidro);
        inv.setItem(8, vidro);
        
        final ItemStack event457 = new ItemStack(Material.INK_SACK, 1, (short)8);
        final ItemMeta eventv1 = event457.getItemMeta();
        eventv1.setDisplayName("§e§lKITS");
        event457.setItemMeta(eventv1);
        inv.setItem(2, event457);
        
        final ItemStack event458 = new ItemStack(Material.INK_SACK, 1, (short)8);
        final ItemMeta eventv2 = event458.getItemMeta();
        eventv2.setDisplayName("§e§lEXTRAS");
        event458.setItemMeta(eventv2);
        inv.setItem(6, event458);
        
        final ItemStack event459 = new ItemStack(Material.EMERALD, 1, (short)0);
        final ItemMeta eventv3 = event459.getItemMeta();
        eventv3.setDisplayName("§e§lVIP & MAIS");
        event459.setItemMeta(eventv3);
        inv.setItem(4, event459);
        
        for (int descpyro2 = (inv.getContents()).length, metapyro2 = 0; metapyro2 < descpyro2; ++metapyro2) {
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
        if (e.getInventory().getTitle().equalsIgnoreCase("§7» §e§lLOJA") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
            e.setCancelled(true);

            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lKITS")) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/lojakits");
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lEXTRAS")) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/lojaextras");
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lVIP & MAIS")) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/buy");
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
            }
        }
    }
    
    public static void ir(final Player p, final String string) {
    }
}
