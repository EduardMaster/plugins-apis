package Zey.PvP.Menus;

import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.command.*;
import org.bukkit.event.inventory.*;
import org.bukkit.*;
import org.bukkit.event.*;

public class MenuAdm implements Listener, CommandExecutor
{
    @SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public static void guiKits(final Player p) {
        final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder)p, 27, "§7» §e§lADMIN");
        final ItemStack pyro = new ItemStack(Material.POTION, 1, (short)8201);
        final ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§e§lADMIN");
        final ArrayList descpyro1 = new ArrayList();
        descpyro1.add("§7  ");
        descpyro1.add("§7» §e§lUTILIDADE");
        descpyro1.add("§7Testar Hackers");
        descpyro1.add("§7E Prender Jogadores");
        metapyro.setLore((List)descpyro1);
        pyro.setItemMeta(metapyro);
        inv.setItem(12, pyro);
        final ItemStack pyro2 = new ItemStack(Material.EXP_BOTTLE);
        final ItemMeta metapyro2 = pyro2.getItemMeta();
        metapyro2.setDisplayName("§e§lVIS");
        final ArrayList descpyro2 = new ArrayList();
        descpyro2.add("§7  ");
        descpyro2.add("§7» §e§lUTILIDADE");
        descpyro2.add("§7Ficar Totalmente");
        descpyro2.add("§7Invisivel");
        metapyro2.setLore((List)descpyro2);
        pyro2.setItemMeta(metapyro2);
        inv.setItem(14, pyro2);
        final ItemStack event1234 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
        final ItemMeta eventv1234 = event1234.getItemMeta();
        eventv1234.setDisplayName("§c§lVOLTAR");
        event1234.setItemMeta(eventv1234);
        inv.setItem(0, event1234);
        ItemStack[] arrayOfItemStack;
        for (int descpyro3 = (arrayOfItemStack = inv.getContents()).length, metapyro3 = 0; metapyro3 < descpyro3; ++metapyro3) {
            final ItemStack itemStack = arrayOfItemStack[metapyro3];
        }
        p.openInventory(inv);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (commandLabel.equalsIgnoreCase("wa")) {
            final Player p = (Player)sender;
            guiKits(p);
        }
        return false;
    }
    
    @SuppressWarnings("deprecation")
	@EventHandler
    public void ClickFoda(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (!e.getInventory().getTitle().equalsIgnoreCase("§7» §e§lADMIN") || e.getCurrentItem() == null || e.getCurrentItem().getTypeId() == 0) {
            return;
        }
        e.setCancelled(true);
        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lVOLTAR")) {
            e.setCancelled(true);
            p.closeInventory();
            MenuGeral.guiKits(p);
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
            return;
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lADMIN")) {
            e.setCancelled(true);
            p.closeInventory();
            p.chat("/admin");
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
            return;
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lVIS")) {
            e.setCancelled(true);
        }
        p.closeInventory();
        p.chat("/vis");
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
    }
    
    public static void ir(final Player p, final String string) {
    }
}
