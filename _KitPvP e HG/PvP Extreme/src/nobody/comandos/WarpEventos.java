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

public class WarpEventos
  implements CommandExecutor, Listener
{
  private static ItemManager im = new ItemManager();
  
  
  @SuppressWarnings("deprecation")
public void guiWarps(Player p)
  {
    ItemStack branco = new ItemStack(Material.STAINED_GLASS_PANE, 1,(short)0);
    ItemStack asdasd = new ItemStack(Material.STAINED_GLASS_PANE, 1,(short)2);
    Inventory inv = Bukkit.createInventory(p, 27, "§eEventos");
    ItemStack fps = im.createItem(Material.getMaterial(35), "mdr", "§eMae da Rua", new String[0], 1, (short)0);
    ItemStack spawn = im.createItem(Material.getMaterial(354), "spawn", "§eRei da Mesa", new String[0], 1, (short)0);
    ItemStack challenge = im.createItem(Material.getMaterial(317), "challenge", "§eCorrida", new String[0], 1, (short)0);
    ItemStack text = im.createItem(Material.getMaterial(111), "textura", "§eFolha", new String[0], 1, (short)0);
    ItemStack fulliron = im.createItem(Material.getMaterial(41), "1v1", "§eMinicopa", new String[0], 1, (short)0);
    
    inv.setItem(0, asdasd);
    inv.setItem(1, asdasd);
    inv.setItem(2, asdasd);
    inv.setItem(3, asdasd);
    inv.setItem(4, asdasd);
    inv.setItem(5, asdasd);
    inv.setItem(6, asdasd);
    inv.setItem(7, asdasd);
    inv.setItem(8, asdasd);
    inv.setItem(9, fps);
    inv.setItem(10, branco);
    inv.setItem(11, challenge);
    inv.setItem(12, branco);
    inv.setItem(13, spawn);
    inv.setItem(15, fulliron);
    inv.setItem(17, text);
    inv.setItem(18, branco);
    inv.setItem(20, branco);
    inv.setItem(22, branco);
    inv.setItem(24, branco);
    inv.setItem(26, branco);
    
    for (int i = 0; i < inv.getSize(); i++) {
      if (inv.getItem(i) == null) {
        inv.setItem(i, branco);
      }
    }
    p.openInventory(inv);
  }
  
  @EventHandler
  public void dontClick(InventoryClickEvent event)
  {
    Player p = (Player)event.getWhoClicked();
    if ((p.getOpenInventory().getTitle().equalsIgnoreCase("§eEventos")) || (p.getOpenInventory().getTitle().equalsIgnoreCase("Servidor JapaaPvP")))
    {
      event.setCancelled(true);
      p.updateInventory();
      if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eRei da Mesa"))
      {
        p.chat("/rdm");
        p.closeInventory();
      }
      if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eMae da Rua"))
      {
        p.chat("/mdr");
        p.closeInventory();
    }
      if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eCorrida"))
      {
        p.chat("/corrida");
        p.closeInventory();
    }
      if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eFolha"))
      {
        p.chat("/folha");
        p.closeInventory();
    }
      if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eMinicopa"))
      {
        p.chat("/minicopa");
        p.closeInventory();
    }
    }
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (commandLabel.equalsIgnoreCase("eventos"))
    {
      Player p = (Player)sender;
      
      guiWarps(p);
      
    }
    return false;
  }
}
