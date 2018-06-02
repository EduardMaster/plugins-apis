package neero.demon.eventos;


import neero.demon.Main;

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

public class Menus 
  implements Listener
{
  
  public static void guiKits(Player p)
  {
    Inventory inv = Bukkit.getServer().createInventory(p, 27, "§aRanks");
    
    ItemStack vidro = new ItemStack(Material.THIN_GLASS);
    ItemMeta metav = vidro.getItemMeta();
    vidro.setItemMeta(metav);
    
    ItemStack warp = new ItemStack(Material.COAL);
    ItemMeta warpv = warp.getItemMeta();
    warpv.setDisplayName("§fFIRST");
    warp.setItemMeta(warpv);
    inv.setItem(9, warp);
    
    ItemStack warp1 = new ItemStack(Material.IRON_INGOT);
    ItemMeta warpv1 = warp1.getItemMeta();
    warpv1.setDisplayName("§fNOOB");
    warp1.setItemMeta(warpv1);
    inv.setItem(10, warp1);
    
    ItemStack warp11 = new ItemStack(Material.GOLD_INGOT);
    ItemMeta warpv11 = warp11.getItemMeta();
    warpv11.setDisplayName("§fPRIMARY");
    warp11.setItemMeta(warpv11);
    inv.setItem(11, warp11);
    
    ItemStack warp111 = new ItemStack(Material.getMaterial(351), 1,(short)14);
    ItemMeta warpv111 = warp111.getItemMeta();
    warpv111.setDisplayName("§eINTERMEADIARY");
    warp111.setItemMeta(warpv111);
    inv.setItem(12, warp111);
    
    ItemStack warp1111 = new ItemStack(Material.getMaterial(351), 1,(short)10);
    ItemMeta warpv1111 = warp1111.getItemMeta();
    warpv1111.setDisplayName("§eADVANCED");
    warp1111.setItemMeta(warpv1111);
    inv.setItem(13, warp1111);
    
    ItemStack warp2 = new ItemStack(Material.getMaterial(351), 1,(short)12);
    ItemMeta warp2v = warp2.getItemMeta();
    warp2v.setDisplayName("§eEXPERT");
    warp2.setItemMeta(warp2v);
    inv.setItem(14, warp2);
    
    ItemStack warp22 = new ItemStack(Material.getMaterial(351), 1,(short)9);
    ItemMeta warp22v = warp22.getItemMeta();
    warp22v.setDisplayName("§6BRONZE");
    warp22.setItemMeta(warp22v);
    inv.setItem(15, warp22);
    
    ItemStack warp23 = new ItemStack(Material.getMaterial(351), 1,(short)13);
    ItemMeta warp23v = warp23.getItemMeta();
    warp23v.setDisplayName("§6SILVER");
    warp23.setItemMeta(warp23v);
    inv.setItem(16, warp23);
    
    ItemStack warp25 = new ItemStack(Material.getMaterial(351), 1,(short)5);
    ItemMeta warp25v = warp25.getItemMeta();
    warp2v.setDisplayName("§cDIAMOND");
    warp25.setItemMeta(warp25v);
    inv.setItem(17, warp25);
    
    ItemStack warp26 = new ItemStack(Material.DIAMOND);
    ItemMeta warp26v = warp26.getItemMeta();
    warp26v.setDisplayName("§4LEGENDARY");
    warp26.setItemMeta(warp26v);
    inv.setItem(22, warp26);
    
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
  public static void guiStatus(Player p)
  {
    Inventory inv = Bukkit.getServer().createInventory(p, 27, "§aStatus");
    ItemStack vidro = new ItemStack(Material.THIN_GLASS);
    ItemMeta metav = vidro.getItemMeta();
    vidro.setItemMeta(metav);
    
    ItemStack warp = new ItemStack(Material.WOOD_SWORD);
    ItemMeta warpv = warp.getItemMeta();
    warpv.setDisplayName("§4§lMATOU§f: " );
    warp.setItemMeta(warpv);
    inv.setItem(11, warp);
    
    ItemStack warp1 = new ItemStack(Material.GOLD_INGOT);
    ItemMeta warpv1 = warp1.getItemMeta();
    warpv1.setDisplayName("§4§lCOINS: " + Dinheiro.getMoney(p));
    warp1.setItemMeta(warpv1);
    inv.setItem(13, warp1);
    
    ItemStack warp11 = new ItemStack(Material.REDSTONE);
    ItemMeta warpv11 = warp11.getItemMeta();
    warpv11.setDisplayName("§4§lMORREU: " );
    warp11.setItemMeta(warpv11);
    inv.setItem(15, warp11);
    
    
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
}