package me.Pedro.INV;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.Pedro.Main;
import me.Pedro.Minigames.ListGames;
import me.Pedro.Minigames.Minigames;

public class MiniGamesInv
  implements Listener
{
  public MiniGamesInv(Main main) {
		// TODO Auto-generated constructor stub
	}

public static void guiKits(Player p)
  {
    Inventory inv = Bukkit.getServer().createInventory(p, 27, "§6MiniGames");
    
    ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)11);
    ItemMeta metav = vidro.getItemMeta();
    metav.setDisplayName(" ");
    vidro.setItemMeta(metav);
    
    ItemStack warp = new ItemStack(Material.MUSHROOM_SOUP);
    ItemMeta warpv = warp.getItemMeta();
    warpv.setDisplayName("§c§lREFILL");
    warp.setItemMeta(warpv);
    inv.setItem(13, warp);
    
    ItemStack warp1 = new ItemStack(Material.BEDROCK);
    ItemMeta warp1v = warp1.getItemMeta();
    warp1v.setDisplayName("§c§LVOID");
    warp1.setItemMeta(warp1v);
    inv.setItem(11, warp1);
    
    ItemStack warp2 = new ItemStack(Material.DIAMOND_SWORD);
    ItemMeta warp2v = warp2.getItemMeta();
    warp2v.setDisplayName("§c§LCLICKTEST");
    warp2.setItemMeta(warp2v);
    inv.setItem(15, warp2);
    
    ItemStack[] arrayOfItemStack;
    int descpyro1 = (arrayOfItemStack = inv.getContents()).length;
    for (int metapyro1 = 0; metapyro1 < descpyro1; metapyro1++)
    {
      ItemStack item = arrayOfItemStack[metapyro1];
      if (item == null) {
        inv.setItem(inv.firstEmpty(), vidro);
      }
    }
    p.openInventory(inv);
  }
  
  @EventHandler
  public void onPlayerCLickInventry(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if ((e.getInventory().getTitle().equalsIgnoreCase("§6MiniGames")) && 
      (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
    {
      e.setCancelled(true);
      if (e.getSlot() == 13)
      {
        e.setCancelled(true);
        p.closeInventory();
  	  Minigames.joinMinigame(p, ListGames.refillTest);
        return;
      }
      if (e.getSlot() == 11)
      {
        e.setCancelled(true);
        p.closeInventory();
  	  Minigames.joinMinigame(p, ListGames.voidChallenge);
        return;
      }
      if (e.getSlot() == 12)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/CLICKTEST");
        return;
      }
    }
  }
}
