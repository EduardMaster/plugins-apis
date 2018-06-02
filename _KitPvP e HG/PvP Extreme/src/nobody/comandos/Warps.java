package nobody.comandos;

import nobody.eventos.ItemManager;

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

public class Warps
  implements CommandExecutor, Listener
{
  private static ItemManager im = new ItemManager();
  
  
  @SuppressWarnings("deprecation")
public void guiWarps(Player p)
  {
    ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1,(short)15);
    ItemStack sex = new ItemStack(Material.STAINED_GLASS_PANE, 1,(short)14);
    Inventory inv = Bukkit.createInventory(p, 27, "§eMenu de Warps");
    ItemStack fps = im.createItem(Material.getMaterial(354), "§eEventos", "§eEventos", new String[0], 1, (short)0);
    ItemStack challenge = im.createItem(Material.getMaterial(327), "§eWarps", "§eWarps", new String[0], 1, (short)0);
    

    inv.setItem(9, vidro);
    inv.setItem(15, fps);
    inv.setItem(10, vidro);
    inv.setItem(11, challenge);
    inv.setItem(12, vidro);
    inv.setItem(13, vidro);
    inv.setItem(14, vidro);
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
    for (int i = 0; i < inv.getSize(); i++) {
      if (inv.getItem(i) == null) {
        inv.setItem(i, sex);
      }
    }
    p.openInventory(inv);
  }
  
  @EventHandler
  public void dontClick(InventoryClickEvent event)
  {
    Player p = (Player)event.getWhoClicked();
    if ((p.getOpenInventory().getTitle().equalsIgnoreCase("§eMenu de Warps")) || (p.getOpenInventory().getTitle().equalsIgnoreCase("Servidor JapaaPvP")))
    {
      event.setCancelled(true);
      p.updateInventory();
    
      if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eWarps"))
      {
        p.chat("/warpss");
      }
      if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eEventos"))
      {
        p.chat("/eventos");
    }
    }
    }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (commandLabel.equalsIgnoreCase("warps"))
    {
      Player p = (Player)sender;
      
      guiWarps(p);
    }
    return false;
  }
}
