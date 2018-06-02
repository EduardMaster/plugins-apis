package GUI;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Main.Main;

public class Warps
  implements Listener
{
  @SuppressWarnings("unused")
private Main plugin;
  
  public Warps(Main instance)
  {
    this.plugin = instance;
  }
  
  @SuppressWarnings("deprecation")
public static void guiWarp(Player p)
  {
    Inventory inv = Bukkit.getServer().createInventory(p, 27, "§2Warps");
    
    ItemStack vidro = new ItemStack(Material.getMaterial(160), 1, (short)14);
    ItemMeta zvidro = vidro.getItemMeta();
    zvidro.setDisplayName("  ");
    vidro.setItemMeta(zvidro);
    
    ItemStack vidro1 = new ItemStack(Material.getMaterial(160), 1, (short)15);
    ItemMeta zvidro1 = vidro1.getItemMeta();
    zvidro1.setDisplayName("  ");
    vidro1.setItemMeta(zvidro1);
    
    ItemStack fps = new ItemStack(Material.GLASS);
    ItemMeta zfps = fps.getItemMeta();
    zfps.setDisplayName("§bFPS");
    fps.setItemMeta(zfps);
    
    ItemStack fps2 = new ItemStack(Material.POTION);
    ItemMeta zfps2 = fps2.getItemMeta();
    zfps2.setDisplayName("§bMain");
    fps2.setItemMeta(zfps2);
    
    ItemStack fps22 = new ItemStack(Material.LAVA);
    ItemMeta zfps22 = fps22.getItemMeta();
    zfps22.setDisplayName("§bLava Challenge");
    fps22.setItemMeta(zfps22);
    
    ItemStack fps222 = new ItemStack(Material.BLAZE_ROD);
    ItemMeta zfps222 = fps222.getItemMeta();
    zfps222.setDisplayName("§b1v1");
    fps222.setItemMeta(zfps222);
    
    ItemStack fps2222 = new ItemStack(Material.BLAZE_ROD, 2);
    ItemMeta zfps2222 = fps222.getItemMeta();
    zfps2222.setDisplayName("§b2v2");
    fps2222.setItemMeta(zfps2222);
    
    inv.setItem(0, vidro);
    inv.setItem(1, vidro1);
    inv.setItem(2, vidro);
    inv.setItem(3, vidro1);
    inv.setItem(4, vidro);
    inv.setItem(5, vidro1);
    inv.setItem(6, vidro);
    inv.setItem(7, vidro1);
    inv.setItem(8, vidro);
    
    inv.setItem(9, fps222);
    inv.setItem(10, vidro);
    inv.setItem(11, fps);
    inv.setItem(12, vidro);
    inv.setItem(13, fps22);
    inv.setItem(14, vidro);
    inv.setItem(15, fps2);
    inv.setItem(16, vidro);
    inv.setItem(17, fps2222);
    
    inv.setItem(18, vidro);
    inv.setItem(19, vidro1);
    inv.setItem(20, vidro);
    inv.setItem(21, vidro1);
    inv.setItem(22, vidro);
    inv.setItem(23, vidro1);
    inv.setItem(24, vidro);
    inv.setItem(25, vidro1);
    inv.setItem(26, vidro);
    
    p.openInventory(inv);
  }
  
  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if (p.getItemInHand().getType() == Material.COMPASS) {
      guiWarp(p);
    }
  }
  
  @EventHandler
  public void ClickInventory(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null)) {}
    Inventory inv = e.getInventory();
    if (inv.getTitle().equals("§2Warps"))
    {
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("  "))
      {
        e.setCancelled(true);
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bFPS"))
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/fps");
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bMain"))
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/main");
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bLava Challenge"))
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/challenge");
      }
      
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b1v1"))
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/1v1");
      }
      
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b2v2"))
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/2v2");
      }
    }
  }
}