package me.recenthg.Manager;

import java.util.ArrayList;

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

import me.recenthg.Main;
import me.recenthg.Dinheiro.DinheiroM;
import me.recenthg.Utils.Estado;

public class Status
  implements Listener
{
  @SuppressWarnings({})
public static void guiInfo(Player p)
  {
    Inventory inv = Bukkit.getServer().createInventory(p, 27,  "§6Seu Status");
    
    ItemStack vidro = new ItemStack(Material.THIN_GLASS);
    ItemMeta metav = vidro.getItemMeta();
    metav.setDisplayName("§e§lTorm§f§lHG");
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
    inv.setItem(9, vidro);
    inv.setItem(10, vidro);
    inv.setItem(11, vidro);

   
    inv.setItem(15, vidro);
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
    
	ItemStack prata = new ItemStack(Material.DIAMOND_SWORD);
	ItemMeta prata1 = prata.getItemMeta();
	prata1.setDisplayName("§cPerfil");
	ArrayList<String> lore = new ArrayList<>();
	lore.add("§7▂ ▃ ▄ ▅ ▆ ▇ █ █ ▇ ▆ ▅ ▄ ▃ ▂");
	lore.add("§2");
	lore.add("§fMatou §2» §6§l" + Manager.getMatou(p));
	lore.add("§fWins §2» §6§l" + Manager.getWin(p));
	lore.add("§fMorreu §2» §6§l" + Manager.getMorreu(p));
	lore.add("§fCoins §2» §6§l" + DinheiroM.MostrarDinheiroPlayer(p));
	lore.add("§2");
	lore.add("§7▂ ▃ ▄ ▅ ▆ ▇ █ █ ▇ ▆ ▅ ▄ ▃ ▂");
	prata1.setLore(lore);
	prata.setItemMeta(prata1);
	inv.setItem(13, prata);


    ItemStack[] arrayOfItemStack;
    int descpyro = (arrayOfItemStack = inv.getContents()).length;
    for (int metapyro = 0; metapyro < descpyro; metapyro++)
    {
      ItemStack item = arrayOfItemStack[metapyro];
      if (item == null) {
        inv.setItem(inv.firstEmpty(), vidro);
      }
    }
    p.openInventory(inv);
  }


	
				
				
@SuppressWarnings("deprecation")
@EventHandler
public void onPlayerCLickInventry(InventoryClickEvent e)
{
  if ((e.getInventory().getTitle().equalsIgnoreCase("§6Seu Status")) && 
    (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0)) {
    e.setCancelled(true);
  }
}

@EventHandler
public void abrirInfo(PlayerInteractEvent e)
{
  Player p = e.getPlayer();
 
if (Main.estados == Estado.INICIANDO) {
  if (p.getItemInHand().getType() == Material.SKULL_ITEM) {
	  Status.guiInfo(p);	
		
  {
    e.setCancelled(true);
    
  
  }
  }
}
}

}
