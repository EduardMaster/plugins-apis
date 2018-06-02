package Zey.PvP.Menus;

import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

import Zey.PvP.Main.Main;

import org.bukkit.command.*;
import org.bukkit.event.inventory.*;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.*;
import org.bukkit.event.*;

public class MenuWarps implements Listener, CommandExecutor
{
    @SuppressWarnings({ "unused" })
	public static void guiKits(final Player p) {
        final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder)p, 27, "§7» §e§lWARPS");
      
        if (!Zey.PvP.Commands.IniciarCommand.evento) {
            final ItemStack magma = new ItemStack(Material.CAKE);
            final ItemMeta magmam = magma.getItemMeta();
            magmam.setDisplayName("§c§l(NÃO HÁ EVENTOS DISPONIVEIS, NO MOMENTO.)");
            // Não há eventos disponiveis, no momento.
            final ArrayList<String> desc = new ArrayList<String>();
            magmam.setLore((List<String>)desc);
            magma.setItemMeta(magmam);
            inv.setItem(8, magma);
        }
        else if (Zey.PvP.Commands.IniciarCommand.evento) {
            final ItemStack magma = new ItemStack(Material.CAKE);
            final ItemMeta magmam = magma.getItemMeta();
            magmam.setDisplayName("§e§lEVENTO (ABERTO)");
            final ArrayList<String> desc = new ArrayList<String>();
            magmam.setLore((List<String>)desc);
            magma.setItemMeta(magmam);
            inv.setItem(8, magma);
        }
        
        final ItemStack event458 = new ItemStack(Material.STAINED_GLASS, 1, (short)15);
        final ItemMeta eventv2 = event458.getItemMeta();
        eventv2.setDisplayName("§e§lFPS");
        event458.setItemMeta(eventv2);
        inv.setItem(11, event458);
        
        final ItemStack event459 = new ItemStack(Material.LAVA_BUCKET, 1, (short)0);
        final ItemMeta eventv3 = event459.getItemMeta();
        eventv3.setDisplayName("§e§lCHALLENGE");
        event459.setItemMeta(eventv3);
        inv.setItem(12, event459);
        
        final ItemStack event460 = new ItemStack(Material.BLAZE_ROD, 1, (short)0);
        final ItemMeta eventv4 = event460.getItemMeta();
        eventv4.setDisplayName("§e§l1v1");
        event460.setItemMeta(eventv4);
        inv.setItem(13, event460);
        
        final ItemStack event461 = new ItemStack(Material.GRASS, 1, (short)0);
        final ItemMeta eventv5 = event461.getItemMeta();
        eventv5.setDisplayName("§e§lPARKOUR");
        event461.setItemMeta(eventv5);
        inv.setItem(14, event461);
        
        final ItemStack event462 = new ItemStack(Material.POTION, 1, (short)8201);
        final ItemMeta eventv6 = event462.getItemMeta();
        eventv6.setDisplayName("§e§lMAIN");
        event462.setItemMeta(eventv6);
        inv.setItem(15, event462);
        
            final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)0);
            final ItemMeta vidrox = vidro.getItemMeta();
            vidrox.setDisplayName("§6§lZey§f§lPvP");
            vidro.setItemMeta(vidrox);
            inv.setItem(0, vidro);
            inv.setItem(1, vidro);
            inv.setItem(2, vidro);
            inv.setItem(3, vidro);
            inv.setItem(4, vidro);
            inv.setItem(5, vidro);
            inv.setItem(6, vidro);
            inv.setItem(7, vidro);
            inv.setItem(9, vidro);
            inv.setItem(10, vidro);
            inv.setItem(16, vidro);
            inv.setItem(17, vidro);
            inv.setItem(18, vidro);
            inv.setItem(19, vidro);
            inv.setItem(20, vidro);
            inv.setItem(21, vidro);
            inv.setItem(22, vidro);
            inv.setItem(23, vidro);
            inv.setItem(24, vidro);
            inv.setItem(25, vidro);
            inv.setItem(26, vidro);
        
        
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
            
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lEVENTO (ABERTO)")) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/evento");
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lFPS")) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/fps");
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§l1v1")) {
                e.setCancelled(true);
                p.closeInventory();
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §cEsta Warp. Está em desenvolvimento.");
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lCHALLENGE")) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/challenge");
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lMAIN")) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/main");
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lPARKOUR")) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/parkour");
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
            }
        }
    }
    
    public static void ir(final Player p, final String string) {
    }
}
