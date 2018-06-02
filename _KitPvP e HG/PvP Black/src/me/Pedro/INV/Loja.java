package me.Pedro.INV;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.Pedro.Main;
import me.Pedro.XP.XpM;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Loja
  implements Listener
{
  public Loja(Main main) {
	}

public static void GuiLojaKit(Player p)
  {
    Inventory inv = Bukkit.getServer().createInventory(p, 27, "§e§lLoja De XP");
    
    ItemStack coins = new ItemStack(Material.EMERALD);
    ItemMeta coinsmeta = coins.getItemMeta();
    coinsmeta.setDisplayName("§7Coins: §c" + XpM.getPlayerMoney(p));
    coins.setItemMeta(coinsmeta);
    
    ItemStack BurstMaster = new ItemStack(Material.GOLD_HOE);
    ItemMeta kitsmeta = BurstMaster.getItemMeta();
    kitsmeta.setDisplayName("§eBurstMaster §bR$2.000");
    BurstMaster.setItemMeta(kitsmeta);
    
    ItemStack Ajnin = new ItemStack(Material.TNT);
    ItemMeta permsmeta = Ajnin.getItemMeta();
    permsmeta.setDisplayName("§eAjnin §bR$5.000");
    Ajnin.setItemMeta(permsmeta);
    
    ItemStack Ninja = new ItemStack(Material.MINECART);
    ItemMeta xpmeta = Ninja.getItemMeta();
    xpmeta.setDisplayName("§eNinja §bR$8.000");
    Ninja.setItemMeta(xpmeta);
    
    ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)0);
    ItemMeta vidrometa = vidro.getItemMeta();
    vidrometa.setDisplayName("");
    vidro.setItemMeta(vidrometa);
    
    inv.setItem(0, vidro);
    inv.setItem(1, vidro);
    inv.setItem(2, vidro);
    inv.setItem(3, vidro);
    inv.setItem(4, vidro);
    inv.setItem(5, vidro);
    inv.setItem(6, vidro);
    inv.setItem(7, vidro);
    inv.setItem(8, coins);
    inv.setItem(9, vidro);
    inv.setItem(10, vidro);
    inv.setItem(11, BurstMaster);
    inv.setItem(12, vidro);
    inv.setItem(13, Ajnin);
    inv.setItem(14, vidro);
    inv.setItem(15, Ninja);
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
    p.openInventory(inv);
  }
  
  @EventHandler
  public void onPlayerCLickInventry(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if ((e.getInventory().getTitle().equalsIgnoreCase("§e§lLoja De XP")) && 
      (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
    {
      e.setCancelled(true);
      if (e.getCurrentItem().getType() == Material.GOLD_HOE) {
        if (XpM.getPlayerMoney(p) >= 2000)
        {
          e.setCancelled(true);
          p.closeInventory();
          XpM.removeMoney(p, 2000);
          PermissionsEx.getUser(p.getName()).addPermission("kit.BurstMaster");
          p.sendMessage("§aVoce comprou o kit BurstMaster");
        }
        else
        {
          p.sendMessage("§cVoce não possue xp suficientes.");
          p.playSound(p.getLocation(), Sound.EXPLODE, 8.0F, 8.0F);
          e.setCancelled(true);
          p.closeInventory();
          return;
        }
      }
      if (e.getCurrentItem().getType() == Material.TNT) {
        if (XpM.getPlayerMoney(p) >= 5000)
        {
          e.setCancelled(true);
          p.closeInventory();
          XpM.removeMoney(p, 5000);
          PermissionsEx.getUser(p.getName()).addPermission("kit.Ajnin");
          p.sendMessage("§aVoce comprou o kit Ajnin");
        }
        else
        {
          p.sendMessage("§cVoce não possue xp suficientes.");
          p.playSound(p.getLocation(), Sound.EXPLODE, 8.0F, 8.0F);
          e.setCancelled(true);
          p.closeInventory();
          return;
        }
      }
      if (e.getCurrentItem().getType() == Material.MINECART) {
        if (XpM.getPlayerMoney(p) >= 8000)
        {
          e.setCancelled(true);
          p.closeInventory();
          XpM.removeMoney(p, 8000);
          PermissionsEx.getUser(p.getName()).addPermission("kit.Ninja");
          p.sendMessage("§aVoce comprou o kit Ninja");
        }
        else
        {
          p.sendMessage("§cVoce não possue xp suficientes.");
          p.playSound(p.getLocation(), Sound.EXPLODE, 8.0F, 8.0F);
          e.setCancelled(true);
          p.closeInventory();
          return;
        }
      }
    }
  }
}
