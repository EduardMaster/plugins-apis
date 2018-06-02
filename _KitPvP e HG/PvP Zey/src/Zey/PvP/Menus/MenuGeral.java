package Zey.PvP.Menus;

import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

import Zey.PvP.Cassino.*;

import org.bukkit.command.*;
import org.bukkit.event.inventory.*;
import org.bukkit.*;
import org.bukkit.event.*;

public class MenuGeral implements Listener, CommandExecutor
{
    @SuppressWarnings({ "deprecation", "rawtypes", "unchecked", "unused" })
	public static void guiKits(final Player p) {
        final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder)p, 54, "§7» §e§lMENU");
        final ItemStack pyro = new ItemStack(Material.getMaterial(340));
        final ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§e§lMenu Geral");
        final ArrayList descpyro1 = new ArrayList();
        descpyro1.add("§7  ");
        descpyro1.add("§7» §e§lUTILIDADE");
        descpyro1.add("§7Transi\u00e7\u00e3o Entre");
        descpyro1.add("§7Os Menus Do Server");
        metapyro.setLore((List)descpyro1);
        pyro.setItemMeta(metapyro);
        inv.setItem(13, pyro);
        final ItemStack event456 = new ItemStack(Material.CHEST);
        final ItemMeta event456v = event456.getItemMeta();
        event456v.setDisplayName("§e§lKITS");
        event456.setItemMeta(event456v);
        inv.setItem(38, event456);
        final ItemStack event457 = new ItemStack(Material.COMPASS);
        final ItemMeta eventv1 = event457.getItemMeta();
        eventv1.setDisplayName("§e§lWARPS");
        event457.setItemMeta(eventv1);
        inv.setItem(39, event457);
        final ItemStack event458 = new ItemStack(Material.EMERALD);
        final ItemMeta eventv2 = event458.getItemMeta();
        eventv2.setDisplayName("§e§lLOJA");
        event458.setItemMeta(eventv2);
        inv.setItem(40, event458);
        final ItemStack event459 = new ItemStack(Material.PAPER);
        final ItemMeta eventv3 = event459.getItemMeta();
        eventv3.setDisplayName("§e§lPERFIL");
        event459.setItemMeta(eventv3);
        inv.setItem(41, event459);
        final ItemStack event460 = new ItemStack(Material.GOLD_INGOT);
        final ItemMeta eventv4 = event460.getItemMeta();
        eventv4.setDisplayName("§e§lAPOSTAS");
        event460.setItemMeta(eventv4);
        inv.setItem(42, event460);
        
        if (!p.hasPermission("cmd.admin")) {
            final ItemStack magma = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
            final ItemMeta magmam = magma.getItemMeta();
            magmam.setDisplayName("§c§lBLOQUEADO");
            final ArrayList<String> desc = new ArrayList<String>();
            magmam.setLore((List)desc);
            magma.setItemMeta(magmam);
            inv.setItem(8, magma);
        }
        else if (p.hasPermission("cmd.admin")) {
            final ItemStack magma = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
            final ItemMeta magmam = magma.getItemMeta();
            magmam.setDisplayName("§a§lADMINISTRA\u00c7\u00c2O");
            final ArrayList<String> desc = new ArrayList<String>();
            magmam.setLore((List)desc);
            magma.setItemMeta(magmam);
            inv.setItem(8, magma);
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
        if (e.getInventory().getTitle().equalsIgnoreCase("§7» §e§lMENU") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lADMINISTRA\u00c7\u00c2O")) {
                e.setCancelled(true);
                p.closeInventory();
                MenuAdm.guiKits(p);
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lAPOSTAS")) {
                e.setCancelled(true);
                p.closeInventory();
                ApostasListener.Seletor(p.getPlayer());
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lKITS")) {
                e.setCancelled(true);
                p.closeInventory();
                MenuKits.GuiKit(p);
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lPERFIL")) {
                e.setCancelled(true);
                p.closeInventory();
                MenuPerfil.guiKits(p);
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lWARPS")) {
                e.setCancelled(true);
                p.closeInventory();
                MenuWarps.guiKits(p);
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lLOJA")) {
                e.setCancelled(true);
                p.closeInventory();
                MenuLojaVips.guiKits(p);
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
            }
        }
    }
    
    public static void ir(final Player p, final String string) {
    }
}
