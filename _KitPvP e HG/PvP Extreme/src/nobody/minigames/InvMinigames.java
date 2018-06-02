package nobody.minigames;

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

public class InvMinigames
  implements Listener
{
  public static ArrayList<String> ListaKits2 = new ArrayList<String>();
  
  @SuppressWarnings("deprecation")
public static void kaka(Player p)
  {
    Inventory inv = Bukkit.getServer().createInventory(p, 9, "§2Minigames");
    
    ItemStack hah = new ItemStack(Material.getMaterial(160), 1);
    ItemMeta metav11 = hah.getItemMeta();
    metav11.setDisplayName("§eExtreme§fKits");
    hah.setItemMeta(metav11);
    
    
    ItemStack vidro1 = new ItemStack(Material.MUSHROOM_SOUP);
    ItemMeta metav1 = vidro1.getItemMeta();
    metav1.setDisplayName("§6RefilTest");
    vidro1.setItemMeta(metav1);
    
    ItemStack cli = new ItemStack(Material.DIAMOND_SWORD);
    ItemMeta clik = cli.getItemMeta();
    clik.setDisplayName("§6ClickTest");
    cli.setItemMeta(clik);
    
    ItemStack Carpet = new ItemStack(Material.LAVA_BUCKET);
    ItemMeta CarpetMeta = Carpet.getItemMeta();
    CarpetMeta.setDisplayName("§6VoidChallenge");
    Carpet.setItemMeta(CarpetMeta);
    
    ItemStack kangaroo = new ItemStack(Material.FIREWORK);
    ItemMeta kangmeta = kangaroo.getItemMeta();
    kangmeta.setDisplayName("§6Treino Kangaroo");
    kangaroo.setItemMeta(kangmeta);
    
    ItemStack grappler = new ItemStack(Material.LEASH);
    ItemMeta grapmeta = grappler.getItemMeta();
    grapmeta.setDisplayName("§6Treino Grappler");
    grappler.setItemMeta(grapmeta);
    
    inv.setItem(0, kangaroo);
    inv.setItem(1, hah);
    inv.setItem(2, vidro1);
    inv.setItem(3, hah);
    inv.setItem(4, cli);
    inv.setItem(5, hah);
    inv.setItem(6, Carpet);
    inv.setItem(7, hah);
    inv.setItem(8, grappler);
    
    p.openInventory(inv);
  }
  
  @EventHandler
  public void auhdaij(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if (p.getItemInHand().getType() == Material.BONE) {
      kaka(p);
    }
  }
  
  @SuppressWarnings("deprecation")
@EventHandler
  public void onPlayerCLickInventry(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if ((e.getInventory().getTitle().equalsIgnoreCase("§2Minigames")) && (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
    {
      e.setCancelled(true);
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6RefilTest"))
      {
        e.setCancelled(true);
        p.closeInventory();
        Minigames.joinMinigame(p, ListGames.refillTest);
        return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6VoidChallenge"))
      {
        e.setCancelled(true);
        p.closeInventory();
        Minigames.joinMinigame(p, ListGames.voidChallenge);
        return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6ClickTest"))
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/clicktest");
        return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6Treino Kangaroo"))
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kangaru");
        return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6Treino Grappler"))
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/grapler");
        return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§eExtreme§fKits"))
      {
        e.setCancelled(true);
        return;
      }
    }
  }
}
