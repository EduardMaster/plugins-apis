package Pedrao.Warps;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Pedrao.Main;

public class Warp
  implements Listener, CommandExecutor
{
  public static void guiKits(Player p)
  {
    Inventory inv = Bukkit.getServer().createInventory(p, 27, "§6Warps");
    
    ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
    ItemMeta metav = vidro.getItemMeta();
    metav.setDisplayName(Main.prefix);
    vidro.setItemMeta(metav);
    
    ItemStack event = new ItemStack(Material.WATER_BUCKET);
    ItemMeta eventv = event.getItemMeta();
    eventv.setDisplayName("§7- §A§LMLG");
    event.setItemMeta(eventv);
    inv.setItem(11, event);
    
    ItemStack comun = new ItemStack(Material.SPONGE);
    ItemMeta comunv = comun.getItemMeta();
    comunv.setDisplayName("§7- §A§LFPS");
    comun.setItemMeta(comunv);
    inv.setItem(15, comun);
    
    ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
    ItemMeta glassv = glass.getItemMeta();
    glassv.setDisplayName(Main.prefix);
    glass.setItemMeta(glassv);
    
    inv.setItem(10, glass);
    inv.setItem(12, glass);
    inv.setItem(14, glass);
    inv.setItem(16, glass);
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
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if ((commandLabel.equalsIgnoreCase("warps")))
    {
      Player p = (Player)sender;
      
      guiKits(p);
    }
    return false;
  }
  
  @SuppressWarnings("deprecation")
@EventHandler
  public void onPlayerCLickInventry(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if ((e.getInventory().getTitle().equalsIgnoreCase("§6Warps")) && 
      (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
    {
      e.setCancelled(true);
      if (e.getSlot() == 11)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/mlg");
        return;
      }
      if (e.getSlot() == 15)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/fps");
        return;
      }
    }
  }
}
