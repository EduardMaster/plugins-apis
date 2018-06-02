package Zey.PvP.Menus;

import java.util.ArrayList;
import java.util.List;

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
import Zey.PvP.Score.SPlayer;

public class MenuPerfil implements Listener, CommandExecutor
{
    @SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public static void guiKits(final Player p) {
        final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder)p, 27, "§f» §e§lPERFIL");
        
        final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)0);
        final ItemMeta vidrox = vidro.getItemMeta();
        vidrox.setDisplayName("§6§lZey§f§lPvP");
        vidro.setItemMeta(vidrox);
        inv.setItem(1, vidro);
        inv.setItem(2, vidro);
        inv.setItem(3, vidro);
        inv.setItem(4, vidro);
        inv.setItem(5, vidro);
        inv.setItem(6, vidro);
        inv.setItem(7, vidro);
        inv.setItem(9, vidro);
        inv.setItem(10, vidro);
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
        
        final ItemStack event457 = new ItemStack(Material.INK_SACK, 1, (short)8);
        final ItemMeta eventv1 = event457.getItemMeta();
        eventv1.setDisplayName("§e§lOUTROS");
        event457.setItemMeta(eventv1);
        inv.setItem(8, event457);
        
        ItemStack pyro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§c§lVOLTAR");
        ArrayList descpyro1 = new ArrayList();
        metapyro.setLore((List)descpyro1);
        pyro.setItemMeta(metapyro);
        inv.setItem(0, pyro);
        
        pyro = new ItemStack(Material.MAGMA_CREAM);
        metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§e§lSTATUS");
        descpyro1 = new ArrayList();
        descpyro1.add("§f  ");
        descpyro1.add("§f» §e§lDEATHS");
        descpyro1.add("§7" + Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".mortes"));
        metapyro.setLore((List)descpyro1);
        pyro.setItemMeta(metapyro);
        inv.setItem(11, pyro);
        
        pyro = new ItemStack(Material.IRON_SWORD);
        metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§e§lSTATUS");
        descpyro1 = new ArrayList();
        descpyro1.add("§f  ");
        descpyro1.add("§f» §e§lKILLS");
        descpyro1.add("§7" + Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".kills"));
        metapyro.setLore((List)descpyro1);
        pyro.setItemMeta(metapyro);
        inv.setItem(12, pyro);
        
        pyro = new ItemStack(Material.GOLD_INGOT);
        metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§e§lSTATUS");
        descpyro1 = new ArrayList();
        descpyro1.add("§f  ");
        descpyro1.add("§f» §e§lMOEDAS");
        descpyro1.add("§7" + ZeyCoins.getPlayerMoney(p));
        metapyro.setLore((List)descpyro1);
        pyro.setItemMeta(metapyro);
        inv.setItem(13, pyro);
        
        pyro = new ItemStack(Material.SLIME_BALL);
        metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§e§lSTATUS");
        descpyro1 = new ArrayList();
        descpyro1.add("§f  ");
        descpyro1.add("§f» §e§lRANK");
        descpyro1.add(SPlayer.Liga(p));
        metapyro.setLore((List)descpyro1);
        pyro.setItemMeta(metapyro);
        inv.setItem(14, pyro);
        
        pyro = new ItemStack(Material.BOOK);
        metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§e§lSTATUS");
        descpyro1 = new ArrayList();
        descpyro1.add("§f  ");
        descpyro1.add("§f» §e§lLIGA");
        descpyro1.add(SPlayer.Rank(p));
        metapyro.setLore((List)descpyro1);
        pyro.setItemMeta(metapyro);
        inv.setItem(15, pyro);
        
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
        if (e.getInventory().getTitle().equalsIgnoreCase("§f» §e§lPERFIL") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
            e.setCancelled(true);
            
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lVOLTAR")) {
                e.setCancelled(true);
                p.closeInventory();
                MenuGeral1.guiKits(p);
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lOUTROS")) {
                e.setCancelled(true);
                p.closeInventory();
                MenuOutros.guiKits(p);
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
            }
        }
    }
    
    public static void ir(final Player p, final String string) {
    }
}
