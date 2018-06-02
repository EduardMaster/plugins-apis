package Zey.PvP.Menus;

import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.command.*;
import org.bukkit.event.inventory.*;
import org.bukkit.*;
import org.bukkit.event.*;

public class MenuOutros implements Listener, CommandExecutor
{
    @SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public static void guiKits(final Player p) {
        final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder)p, 27, "§7» §e§lOUTROS");
        
        final ItemStack pyro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
        final ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§c§lVOLTAR");
        final ArrayList descpyro1 = new ArrayList();
        metapyro.setLore((List)descpyro1);
        pyro.setItemMeta(metapyro);
        inv.setItem(0, pyro);
        
        if (!p.hasPermission("zey.pvp.menuvip")) {
            final ItemStack magma = new ItemStack(Material.SKULL_ITEM, 1, (short)2);
            final ItemMeta magmam = magma.getItemMeta();
            magmam.setDisplayName("§c§lCABEÇAS APENAS PARA VIP'S");
            final ArrayList<String> desc = new ArrayList<String>();
            magmam.setLore((List)desc);
            magma.setItemMeta(magmam);
            inv.setItem(13, magma);
        }
        else if (p.hasPermission("zey.pvp.menuvip")) {
            final ItemStack magma = new ItemStack(Material.SKULL_ITEM, 1, (short)2);
            final ItemMeta magmam = magma.getItemMeta();
            magmam.setDisplayName("§e§lCABEÇAS");
            final ArrayList<String> desc = new ArrayList<String>();
            magmam.setLore((List)desc);
            magma.setItemMeta(magmam);
            inv.setItem(13, magma);
        }
        
        
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
        if (e.getInventory().getTitle().equalsIgnoreCase("§7» §e§lOUTROS") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
            e.setCancelled(true);
            
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lCABEÇAS")) {
                e.setCancelled(true);
                p.closeInventory();
                MenuCabeças.guiKits(p);
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                return;
            }
            
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lVOLTAR")) {
                e.setCancelled(true);
                p.closeInventory();
                MenuPerfil.guiKits(p);
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
            }
        }
    }
    
    public static void ir(final Player p, final String string) {
    }
}
