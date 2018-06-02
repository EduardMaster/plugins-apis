package Zey.PvP.Menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Zey.PvP.Config.ZeyCoins;
import Zey.PvP.Main.Main;

public class MenuLojaExtras implements Listener, CommandExecutor
{
    public static ItemStack vidro;
    public static ItemMeta vidrometa;
    public static ItemStack vidro2;
    public static ItemMeta vidro2meta;
    public static ItemStack ninja;
    public static ItemMeta ninjameta;
    public static ItemStack viking;
    public static ItemMeta vikingmeta;
    public static ItemStack stomper;
    public static ItemMeta stompermeta;
    public static ItemStack viper;
    public static ItemMeta vipermeta;
    public static ItemStack snail;
    public static ItemMeta snailmeta;
    public static ItemStack fisherman;
    public static ItemMeta fishermanmeta;
    public static ItemStack thor;
    public static ItemMeta thormeta;
    public static ItemStack xp;
    public static ItemMeta xpmeta;
    public static ItemStack coisa;
    public static ItemMeta coisameta;
    
    public MenuLojaExtras(final Main main) {
    }
    
    @EventHandler
    public void warps(final InventoryClickEvent e) {
        if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
            final Inventory inv = e.getInventory();
            final Player p = (Player)e.getWhoClicked();
            inv.getTitle().equals("§7» §e§lLOJA EXTRAS");
            
            if (e.getCurrentItem().isSimilar(MenuLojaExtras.viking)) {
                if (ZeyCoins.getPlayerMoney(p) >= 10000) {
                    ZeyCoins.removeMoney(p, 10000);
                    Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.cor");
                    p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Voc\u00ea Agora Pode §a§lFALAR COLORIDO");
                    e.setCancelled(true);
                    p.closeInventory();
                    p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 5.0f, 5.0f);
                }
                else if (ZeyCoins.getPlayerMoney(p) < 10000) {
                    p.sendMessage(String.valueOf(Main.prefix) + " §7» §cMoedas Insuficientes");
                    e.setCancelled(true);
                    p.closeInventory();
                    p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 5.0f, 5.0f);
                }
            }
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("lojaextras")) {
            final Inventory warps = Bukkit.createInventory((InventoryHolder)p, 27, "§7» §e§lLOJA EXTRAS");
            
            final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)0);
            final ItemMeta vidrom = vidro.getItemMeta();
            vidrom.setDisplayName("§6§lZey§f§lPvP");
            vidro.setItemMeta(vidrom);
            warps.setItem(1, vidro);
            warps.setItem(2, vidro);
            warps.setItem(3, vidro);
            warps.setItem(4, vidro);
            warps.setItem(5, vidro);
            warps.setItem(6, vidro);
            warps.setItem(7, vidro);
            warps.setItem(8, vidro);
            warps.setItem(9, vidro);
            warps.setItem(10, vidro);
            warps.setItem(11, vidro);
            warps.setItem(12, vidro);
            warps.setItem(14, vidro);
            warps.setItem(15, vidro);
            warps.setItem(16, vidro);
            warps.setItem(17, vidro);
            warps.setItem(18, vidro);
            warps.setItem(19, vidro);
            warps.setItem(20, vidro);
            warps.setItem(21, vidro);
            warps.setItem(22, vidro);
            warps.setItem(23, vidro);
            warps.setItem(24, vidro);
            warps.setItem(25, vidro);
            warps.setItem(26, vidro);
            
            final ItemStack event45 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
            final ItemMeta event45v = event45.getItemMeta();
            event45v.setDisplayName("§c§lVOLTAR");
            event45.setItemMeta(event45v);
            warps.setItem(0, event45);
            
            final ItemStack loja23 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)0);
            final ItemMeta loja23v = loja23.getItemMeta();
            loja23v.setDisplayName("§7=");
            loja23.setItemMeta(loja23v);
            
            MenuLojaExtras.viking = new ItemStack(Material.BOOK);
            (MenuLojaExtras.vikingmeta = MenuLojaExtras.viking.getItemMeta()).setDisplayName("§eFalar Colorido §b- §e10,000 ZeyCoins.");
            MenuLojaExtras.viking.setItemMeta(MenuLojaExtras.vikingmeta);
            for (int i = 0; i != 54; ++i) {
                warps.setItem(13, MenuLojaExtras.viking);
            }
            p.openInventory(warps);
            return true;
        }
        return true;
    }
    
    @SuppressWarnings("deprecation")
	@EventHandler
    public void onPlayerCLickInventry(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getTitle().equalsIgnoreCase("§7» §e§lLOJA EXTRAS") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
            e.setCancelled(true);
            
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lVOLTAR")) {
                e.setCancelled(true);
                p.closeInventory();
                MenuLojaVips.guiKits(p);
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                return;
            }
        }
    }
}
