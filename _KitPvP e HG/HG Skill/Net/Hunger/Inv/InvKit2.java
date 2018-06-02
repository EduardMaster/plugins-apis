package Net.Hunger.Inv;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InvKit2 implements Listener {
	
  public static void InventarioKitsGui2(Player p) {
	   
    Inventory inv = Bukkit.getServer().createInventory(p, 54, ChatColor.RED + "Kits - Disponiveis! [2]");
    ItemStack vidro = new ItemStack(Material.THIN_GLASS);
    ItemMeta metav = vidro.getItemMeta();
    metav.setDisplayName("");
    vidro.setItemMeta(metav);
    
    inv.setItem(0, vidro);
    inv.setItem(1, vidro);
    inv.setItem(2, vidro);
    inv.setItem(3, vidro);
    inv.setItem(4, vidro);
    inv.setItem(5, vidro);
    inv.setItem(6, vidro);
    inv.setItem(7, vidro);
    inv.setItem(8, vidro);
    inv.setItem(45, vidro);
    inv.setItem(46, vidro);
    inv.setItem(47, vidro);
    inv.setItem(48, vidro);
    inv.setItem(49, vidro);
    inv.setItem(50, vidro);
    inv.setItem(51, vidro);
    inv.setItem(52, vidro);
    inv.setItem(53, vidro);
    
    ItemStack thor1 = new ItemStack(Material.SULPHUR);
    ItemMeta metathor1 = thor1.getItemMeta();
    metathor1.setDisplayName("§c§lSkill§6§lHG");
    thor1.setItemMeta(metathor1);
    inv.setItem(4, thor1);
    
    ItemStack Carpets = new ItemStack(Material.REDSTONE_BLOCK);
    ItemMeta metacarpets = Carpets.getItemMeta();
    metacarpets.setDisplayName("§c§l<- §a§lPagina anterior");
    Carpets.setItemMeta(metacarpets);
    inv.setItem(0, Carpets);
    
    if (p.hasPermission("HungerGames.Kit.Well")) {
        ItemStack pyro = new ItemStack(Material.GOLD_NUGGET);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§a§lKit: §aWell");
        ArrayList<String> descpyro = new ArrayList<String>();
        descpyro.add(ChatColor.GRAY + " - Crie um poço com");
        descpyro.add(ChatColor.GRAY + " - Items random!");
        metapyro.setLore(descpyro);
        pyro.setItemMeta(metapyro);
        inv.addItem(new ItemStack[] { pyro });
      }
    if (p.hasPermission("HungerGames.Kit.Launcher")) {
        ItemStack pyro = new ItemStack(Material.SPONGE);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§a§lKit: §aLauncher");
        ArrayList<String> descpyro = new ArrayList<String>();
        descpyro.add(ChatColor.GRAY + " - Faça plataformas");
        descpyro.add(ChatColor.GRAY + " - Para se mover rapidamente!");
        metapyro.setLore(descpyro);
        pyro.setItemMeta(metapyro);
        inv.addItem(new ItemStack[] { pyro });
      }
    
    ItemStack[] arrayOfItemStack;
    int descpyro = (arrayOfItemStack = inv.getContents()).length;
    for (int metapyro = 0; metapyro < descpyro; metapyro++) {
    ItemStack item = arrayOfItemStack[metapyro];
    if (item == null) {
    inv.setItem(inv.firstEmpty(), vidro);
    }
    }
    p.openInventory(inv);
  }
  @SuppressWarnings("deprecation")
  @EventHandler
   public void onPlayerCLickInventry(InventoryClickEvent e) {
    Player p = (Player)e.getWhoClicked();
    if ((e.getInventory().getTitle().equalsIgnoreCase(ChatColor.RED + "Kits - Disponiveis! [2]")) && (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0)) {
     e.setCancelled(true);
     if (e.getCurrentItem().getType() == Material.REDSTONE_BLOCK) {
      e.setCancelled(true);
      InvKit.InventarioKitsGui(p);
      return;
     }
     if (e.getCurrentItem().getType() == Material.GOLD_NUGGET) {
         e.setCancelled(true);
         p.chat("/kit well");
          p.closeInventory();
         return;
        }
     if (e.getCurrentItem().getType() == Material.SPONGE) {
         e.setCancelled(true);
          p.chat("/kit Launcher");
          p.closeInventory();
         return;
        }
   } 
 }
}