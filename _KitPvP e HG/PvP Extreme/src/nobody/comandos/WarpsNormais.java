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

public class WarpsNormais
  implements CommandExecutor, Listener
{
  private static ItemManager im = new ItemManager();
  
  
  @SuppressWarnings("deprecation")
public void guiWarps(Player p)
  {
    ItemStack branco = new ItemStack(Material.STAINED_GLASS_PANE, 1,(short)0);
    ItemStack asdasd = new ItemStack(Material.STAINED_GLASS_PANE, 1,(short)2);
    Inventory inv = Bukkit.createInventory(p, 27, "§eWarps");
    ItemStack fps = im.createItem(Material.getMaterial(159), "fps", "§eFPS", new String[0], 1, (short)0);
    ItemStack spawn = im.createItem(Material.getMaterial(381), "spawn", "§eSpawn", new String[0], 1, (short)0);
    ItemStack challenge = im.createItem(Material.getMaterial(327), "challenge", "§eChallenge", new String[0], 1, (short)0);
    ItemStack text = im.createItem(Material.getMaterial(346), "textura", "§eFisherman", new String[0], 1, (short)0);
    ItemStack fulliron = im.createItem(Material.getMaterial(369), "1v1", "§e1v1", new String[0], 1, (short)0);
    ItemStack CSGO = im.createItem(Material.getMaterial(261), "CS-GO", "§eCS-GO", new String[0], 1, (short)0);
    ItemStack inferno = im.createItem(Material.getMaterial(87), "inferno", "§eInferno", new String[0], 1, (short)0);
    ItemStack mlg = im.createItem(Material.getMaterial(326), "mlg", "§eMLG", new String[0], 1, (short)0);
    ItemStack park = im.createItem(Material.getMaterial(65), "parkour", "§eParkour", new String[0], 1, (short)0);
    
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
    inv.setItem(13, inferno);
    inv.setItem(14, branco);
    inv.setItem(15, mlg);
    inv.setItem(16, branco);
    inv.setItem(17, fulliron);
    inv.setItem(18, branco);
    inv.setItem(19, spawn);
    inv.setItem(20, branco);
    inv.setItem(21, park);
    inv.setItem(22, branco);
    inv.setItem(23, CSGO);
    inv.setItem(24, branco);
    inv.setItem(25, text);
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
    if ((p.getOpenInventory().getTitle().equalsIgnoreCase("§eWarps")) || (p.getOpenInventory().getTitle().equalsIgnoreCase("Servidor JapaaPvP")))
    {
      event.setCancelled(true);
      p.updateInventory();
      if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eFPS"))
      {
        p.chat("/fps");
        p.closeInventory();
      }
      if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eChallenge"))
      {
        p.chat("/challenge");
        p.closeInventory();
    }
      if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e1v1"))
      {
        p.chat("/1v1");
        p.closeInventory();
    }
      if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eMLG"))
      {
        p.chat("/mlg");
        p.closeInventory();
    }
      if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eCS-GO"))
      {
        p.chat("/csgo");
        p.closeInventory();
    }
      if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eFisherman"))
      {
        p.chat("/fishermano");
        p.closeInventory();
    }
      if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eInferno"))
      {
        p.chat("/inferno");
        p.closeInventory();
    }
    }
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (commandLabel.equalsIgnoreCase("warpss"))
    {
      Player p = (Player)sender;
      
      guiWarps(p);
    }
    return false;
  }
}
