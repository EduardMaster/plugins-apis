package Pedrao.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Pedrao.Main;
import Pedrao.XP.XpM;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Loja
  implements Listener
{
  public Loja(Main main) {
	}

public static void GuiLojaKit(Player p)
  {
    Inventory inv = Bukkit.getServer().createInventory(p, 54, "§e§lLoja De XP");
    
    ItemStack coins = new ItemStack(Material.EMERALD);
    ItemMeta coinsmeta = coins.getItemMeta();
    coinsmeta.setDisplayName("§7XP: §c" + XpM.getPlayerMoney(p));
    coins.setItemMeta(coinsmeta);
    
    ItemStack wither = new ItemStack(Material.LEATHER_BOOTS);
    ItemMeta kitsmeta = wither.getItemMeta();
    kitsmeta.setDisplayName("§7- §6Stomper §aR$2.000");
    wither.setItemMeta(kitsmeta);
    
    ItemStack wither1 = new ItemStack(Material.WOOD_HOE);
    ItemMeta kitsmeta1 = wither1.getItemMeta();
    kitsmeta1.setDisplayName("§7- §6BloodGun §aR$2.000");
    wither1.setItemMeta(kitsmeta1);
    
    ItemStack wither11 = new ItemStack(Material.REDSTONE);
    ItemMeta kitsmeta11 = wither11.getItemMeta();
    kitsmeta11.setDisplayName("§7- §6FireBender §aR$2.000");
    wither11.setItemMeta(kitsmeta11);
    
    ItemStack wither111 = new ItemStack(Material.NAME_TAG);
    ItemMeta kitsmeta111 = wither111.getItemMeta();
    kitsmeta111.setDisplayName("§7- §6Entrar Com Servidor Lotado §aR$500");
    wither111.setItemMeta(kitsmeta111);
    
    ItemStack wither1111 = new ItemStack(Material.ENDER_CHEST);
    ItemMeta kitsmeta1111 = wither1111.getItemMeta();
    kitsmeta1111.setDisplayName("§7- §6Todos Kits §aR$50.000");
    wither1111.setItemMeta(kitsmeta1111);
    
    ItemStack wither11111 = new ItemStack(Material.SKULL_ITEM);
    ItemMeta kitsmeta11111 = wither11111.getItemMeta();
    kitsmeta11111.setDisplayName("§eWither §bR$2.000");
    wither11111.setItemMeta(kitsmeta11111);
    
    ItemStack terrorista = new ItemStack(Material.TNT);
    ItemMeta permsmeta = terrorista.getItemMeta();
    permsmeta.setDisplayName("§eTerrorista §bR$5.000");
    terrorista.setItemMeta(permsmeta);
    
    ItemStack velotrol = new ItemStack(Material.MINECART);
    ItemMeta xpmeta = velotrol.getItemMeta();
    xpmeta.setDisplayName("§eVelotrol §bR$8.000");
    velotrol.setItemMeta(xpmeta);
    
    ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)13);
    ItemMeta vidrometa = vidro.getItemMeta();
    vidrometa.setDisplayName(Main.prefix);
    vidro.setItemMeta(vidrometa);
    
    ItemStack vidro1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)11);
    ItemMeta vidrometa1 = vidro1.getItemMeta();
    vidrometa1.setDisplayName(Main.prefix);
    vidro1.setItemMeta(vidrometa1);
    
    inv.setItem(0, vidro);
    inv.setItem(4, coins);
    inv.setItem(22, wither);
    inv.setItem(23, wither1);
    inv.setItem(21, wither11);
    inv.setItem(30, wither111);
    inv.setItem(32, wither1111);
    p.openInventory(inv);
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

  @SuppressWarnings("deprecation")
@EventHandler
  public void onPlayerCLickInventry(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if ((e.getInventory().getTitle().equalsIgnoreCase("§e§lLoja De XP")) && 
      (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
    {
      e.setCancelled(true);
      if (e.getCurrentItem().getType() == Material.LEATHER_BOOTS) {
        if (XpM.getPlayerMoney(p) >= 2000)
        {
          e.setCancelled(true);
          p.closeInventory();
          XpM.removeMoney(p, 2000);
          PermissionsEx.getUser(p.getName()).addPermission("kit.stomper");
          p.sendMessage(Main.prefix + "§aVoce comprou o kit stomper");
        }
        else
        {
          p.sendMessage(Main.prefix + "§cVoce não possue xp suficientes.");
          p.playSound(p.getLocation(), Sound.EXPLODE, 8.0F, 8.0F);
          e.setCancelled(true);
          p.closeInventory();
          return;
        }
        if (e.getCurrentItem().getType() == Material.WOOD_HOE) {
            if (XpM.getPlayerMoney(p) >= 2000)
            {
              e.setCancelled(true);
              p.closeInventory();
              XpM.removeMoney(p, 2000);
              PermissionsEx.getUser(p.getName()).addPermission("kit.bloodgun");
              p.sendMessage(Main.prefix + "§aVoce comprou o kit bloodgun");
            }
            else
            {
              p.sendMessage(Main.prefix + "§cVoce não possue xp suficientes.");
              p.playSound(p.getLocation(), Sound.EXPLODE, 8.0F, 8.0F);
              e.setCancelled(true);
              p.closeInventory();
              return;
            }
        }
            if (e.getCurrentItem().getType() == Material.REDSTONE) {
                if (XpM.getPlayerMoney(p) >= 2000)
                {
                  e.setCancelled(true);
                  p.closeInventory();
                  XpM.removeMoney(p, 2000);
                  PermissionsEx.getUser(p.getName()).addPermission("kit.firebender");
                  p.sendMessage(Main.prefix + "§aVoce comprou o kit firebender");
                }
                else
                {
                  p.sendMessage(Main.prefix + "§cVoce não possue xp suficientes.");
                  p.playSound(p.getLocation(), Sound.EXPLODE, 8.0F, 8.0F);
                  e.setCancelled(true);
                  p.closeInventory();
                  return;
                }
          }
            if (e.getCurrentItem().getType() == Material.NAME_TAG) {
                if (XpM.getPlayerMoney(p) >= 500)
                {
                  e.setCancelled(true);
                  p.closeInventory();
                  XpM.removeMoney(p, 500);
                  PermissionsEx.getUser(p.getName()).addPermission("kitpvp.entrar");
                  p.sendMessage(Main.prefix + "§aVoce comprou a permissao de entrar vip");
                }
                else
                {
                  p.sendMessage(Main.prefix + "§cVoce não possue xp suficientes.");
                  p.playSound(p.getLocation(), Sound.EXPLODE, 8.0F, 8.0F);
                  e.setCancelled(true);
                  p.closeInventory();
                  return;
                }
          }
            if (e.getCurrentItem().getType() == Material.ENDER_CHEST) {
                if (XpM.getPlayerMoney(p) >= 50000)
                {
                  e.setCancelled(true);
                  p.closeInventory();
                  XpM.removeMoney(p, 50000);
                  PermissionsEx.getUser(p.getName()).addPermission("kit.*");
                  p.sendMessage(Main.prefix + "§aVoce comprou Todos Kits");
                }
                else
                {
                  p.sendMessage(Main.prefix + "§cVoce não possue xp suficientes.");
                  p.playSound(p.getLocation(), Sound.EXPLODE, 8.0F, 8.0F);
                  e.setCancelled(true);
                  p.closeInventory();
                  return;
                }
          }
      }
    }
  }
}
