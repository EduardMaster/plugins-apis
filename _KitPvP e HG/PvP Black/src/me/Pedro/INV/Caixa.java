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

public class Caixa
  implements Listener
{
  public Caixa(Main main) {
	}

public static void guiKits(Player p)
  {
    Inventory inv = Bukkit.getServer().createInventory(p, 27, "§5Caixas");
    
    ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)11);
    ItemMeta metav = vidro.getItemMeta();
    metav.setDisplayName(" ");
    vidro.setItemMeta(metav);
    
    ItemStack warp = new ItemStack(Material.CHEST);
    ItemMeta warpv = warp.getItemMeta();
    warpv.setDisplayName("§c§lCAIXA DE KIT");
    warp.setItemMeta(warpv);
    inv.setItem(12, warp);
    
    ItemStack warp1 = new ItemStack(Material.EXP_BOTTLE);
    ItemMeta warp1v = warp1.getItemMeta();
    warp1v.setDisplayName("§c§LCAIXA XP");
    warp1.setItemMeta(warp1v);
    inv.setItem(14, warp1);

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
    if ((e.getInventory().getTitle().equalsIgnoreCase("§5Caixas")) && 
      (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
    {
      e.setCancelled(true);
      if (e.getSlot() == 12)
      {
        e.setCancelled(true);
        p.closeInventory();
		if (CaixaKit.setandokit.contains(p.getName())) {
			p.sendMessage("§7Voce ja usou");
			return;
		}

		e.setCancelled(true);

		CaixaKit.Inventario(p);

		CaixaKit.setandokit.add(p.getName());
      }
      if (e.getSlot() == 14)
      {
        e.setCancelled(true);
        p.closeInventory();
		if (CaixaXP.setandokit.contains(p.getName())) {
			p.sendMessage("§7Voce ja usou");
			return;
		}

		e.setCancelled(true);

		CaixaXP.Inventario(p);

		CaixaXP.setandokit.add(p.getName());
    }
    }
  }
}
