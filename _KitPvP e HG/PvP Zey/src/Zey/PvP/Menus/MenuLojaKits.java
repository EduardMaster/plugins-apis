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

public class MenuLojaKits implements Listener, CommandExecutor
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
    
    public MenuLojaKits(final Main main) { }
    
    @EventHandler
    public void warps(final InventoryClickEvent e) {
        if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
            final Inventory inv = e.getInventory();
            final Player p = (Player)e.getWhoClicked();
            inv.getTitle().equals("§7» §e§lLOJA KITS");
            
            if (e.getCurrentItem().isSimilar(MenuLojaKits.ninja)) {
                if (ZeyCoins.getPlayerMoney(p) >= 14000) {
                    ZeyCoins.removeMoney(p, 14000);
                    Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kit.quickdropper");
                    p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Kit §a§lQUICKDROPPER§7 Agora Est\u00e1 Nos Seus Kits");
                    e.setCancelled(true);
                    p.closeInventory();
                    p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 5.0f, 5.0f);
                }
                else if (ZeyCoins.getPlayerMoney(p) < 14000) {
                    p.sendMessage(String.valueOf(Main.prefix) + " §7» §cMoedas Insuficientes");
                    e.setCancelled(true);
                    p.closeInventory();
                    p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 5.0f, 5.0f);
                }
            }
            if (e.getCurrentItem().isSimilar(MenuLojaKits.viking)) {
                if (ZeyCoins.getPlayerMoney(p) >= 25000) {
                    ZeyCoins.removeMoney(p, 25000);
                    Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kit.Stomper");
                    p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Kit §a§lSTOMPER§7 Agora Est\u00e1 Nos Seus Kits");
                    e.setCancelled(true);
                    p.closeInventory();
                    p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 5.0f, 5.0f);
                }
                else if (ZeyCoins.getPlayerMoney(p) < 25000) {
                    p.sendMessage(String.valueOf(Main.prefix) + " §7» §cMoedas Insuficientes");
                    e.setCancelled(true);
                    p.closeInventory();
                    p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 5.0f, 5.0f);
                }
            }
            if (e.getCurrentItem().isSimilar(MenuLojaKits.stomper)) {
                if (ZeyCoins.getPlayerMoney(p) >= 5000) {
                    ZeyCoins.removeMoney(p, 5000);
                    Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kit.thor");
                    p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Kit §a§lTHOR§7 Agora Est\u00e1 Nos Seus Kits");
                    e.setCancelled(true);
                    p.closeInventory();
                    p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 5.0f, 5.0f);
                }
                else if (ZeyCoins.getPlayerMoney(p) < 5000) {
                    p.sendMessage(String.valueOf(Main.prefix) + " §7» §cMoedas Insuficientes");
                    e.setCancelled(true);
                    p.closeInventory();
                    p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 5.0f, 5.0f);
                }
            }
            if (e.getCurrentItem().isSimilar(MenuLojaKits.viper)) {
                if (ZeyCoins.getPlayerMoney(p) >= 15000) {
                    ZeyCoins.removeMoney(p, 15000);
                    Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kit.anchor");
                    p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Kit §a§lANCHOR§7 Agora Est\u00e1 Nos Seus Kits");
                    e.setCancelled(true);
                    p.closeInventory();
                    p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 5.0f, 5.0f);
                }
                else if (ZeyCoins.getPlayerMoney(p) < 15000) {
                    p.sendMessage(String.valueOf(Main.prefix) + " §7» §cMoedas Insuficientes");
                    e.setCancelled(true);
                    p.closeInventory();
                    p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 5.0f, 5.0f);
                }
            }
            if (e.getCurrentItem().isSimilar(MenuLojaKits.snail)) {
                if (ZeyCoins.getPlayerMoney(p) >= 7000) {
                    ZeyCoins.removeMoney(p, 7000);
                    Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kit.c4");
                    p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Kit §a§lC4§7 Agora Est\u00e1 Nos Seus Kits");
                    e.setCancelled(true);
                    p.closeInventory();
                    p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 5.0f, 5.0f);
                }
                else if (ZeyCoins.getPlayerMoney(p) < 7000) {
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
        if (cmd.getName().equalsIgnoreCase("lojakits")) {
            final Inventory warps = Bukkit.createInventory((InventoryHolder)p, 27, "§7» §e§lLOJA KITS");
            
            final ItemStack event46 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
            final ItemMeta event4v = event46.getItemMeta();
            event4v.setDisplayName("§c§lVOLTAR");
            event46.setItemMeta(event4v);
            warps.setItem(0, event46);
            
                final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)0);
                final ItemMeta vidrox = vidro.getItemMeta();
                vidrox.setDisplayName("§6§lZey§f§lPvP");
                vidro.setItemMeta(vidrox);
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
            
            MenuLojaKits.stomper = new ItemStack(Material.GOLD_AXE);
            (MenuLojaKits.stompermeta = MenuLojaKits.stomper.getItemMeta()).setDisplayName("§eThor §b- §e5000");
            MenuLojaKits.stomper.setItemMeta(MenuLojaKits.stompermeta);
            
            MenuLojaKits.viking = new ItemStack(Material.LEATHER_BOOTS);
            (MenuLojaKits.vikingmeta = MenuLojaKits.viking.getItemMeta()).setDisplayName("§eStomper §b- §e25000");
            MenuLojaKits.viking.setItemMeta(MenuLojaKits.vikingmeta);
            
            MenuLojaKits.viper = new ItemStack(Material.ANVIL);
            (MenuLojaKits.vipermeta = MenuLojaKits.viper.getItemMeta()).setDisplayName("§eAnchor §b- §e15000");
            MenuLojaKits.viper.setItemMeta(MenuLojaKits.vipermeta);
            
            MenuLojaKits.ninja = new ItemStack(Material.BOWL);
            (MenuLojaKits.ninjameta = MenuLojaKits.ninja.getItemMeta()).setDisplayName("§eQuickdropper §b- §e14000");
            MenuLojaKits.ninja.setItemMeta(MenuLojaKits.ninjameta);
            
            MenuLojaKits.snail = new ItemStack(Material.SLIME_BALL);
            (MenuLojaKits.snailmeta = MenuLojaKits.snail.getItemMeta()).setDisplayName("§eC4 §b- §e7000");
            MenuLojaKits.snail.setItemMeta(MenuLojaKits.snailmeta);
            
            for (int i = 0; i != 54; ++i) {
                warps.setItem(11, MenuLojaKits.stomper);
                warps.setItem(12, MenuLojaKits.viper);
                warps.setItem(13, MenuLojaKits.snail);
                warps.setItem(14, MenuLojaKits.ninja);
                warps.setItem(15, MenuLojaKits.viking);
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
        if (e.getInventory().getTitle().equalsIgnoreCase("§7» §e§lLOJA KITS") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
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
