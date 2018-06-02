package nobody.comandos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MenuDeLojas
  implements CommandExecutor, Listener
{
  public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args)
  {
    Player p = (Player)Sender;
    if (Cmd.getName().equalsIgnoreCase("lojas"))
    {
		Inventory menu = Bukkit.getServer().createInventory(p, InventoryType.HOPPER, "§6§k-- §e§lLOJAS §6§k--");
      
      ItemStack kHeads = new ItemStack(Material.DIAMOND_SWORD);
      ItemMeta mHeads = kHeads.getItemMeta();
      mHeads.setDisplayName("§aKits");
      kHeads.setItemMeta(mHeads);
      
      ItemStack kEfeitos = new ItemStack(Material.GOLD_INGOT);
      ItemMeta mEfeitos = kEfeitos.getItemMeta();
      mEfeitos.setDisplayName("§aPermissoes");
      kEfeitos.setItemMeta(mEfeitos);
      
      ItemStack kSurprise = new ItemStack(Material.LEATHER_CHESTPLATE);
      ItemMeta mSurprise = kSurprise.getItemMeta();
      mSurprise.setDisplayName("§aItens");
      kSurprise.setItemMeta(mSurprise);

      ItemStack kbuy = new ItemStack(Material.DIAMOND);
      ItemMeta mbuy = kbuy.getItemMeta();
      mbuy.setDisplayName("§aBuycraft");
      kbuy.setItemMeta(mbuy);   
      
      
      ItemStack kSlotVazio = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)0);
      ItemMeta mSlotVazio = kSlotVazio.getItemMeta();
      mSlotVazio.setDisplayName(" ");
      kSlotVazio.setItemMeta(mSlotVazio);
      
		menu.setItem(0, kHeads);
		menu.setItem(1, kEfeitos);
		menu.setItem(2, kSlotVazio);
		menu.setItem(3, kSurprise);
		menu.setItem(4, kbuy);
      
      
      p.openInventory(menu);
    }
    return false;
  }
  
  @EventHandler
  public void clickevent(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if (e.getInventory().getTitle().equalsIgnoreCase("§6§k-- §e§lLOJAS §6§k--"))
    {
      e.getCurrentItem();
      e.setCancelled(true);
    
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aKits"))
      {
          p.closeInventory();
          p.chat("/loja");
        }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aPermissoes"))
      {
          p.closeInventory();
        p.chat("/lojaperms");
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aItens"))
      {
          p.closeInventory();
        p.chat("/lojaitens");
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aBuycraft"))
      {
          p.closeInventory();
        p.chat("/Buy");
      }

      }
  }
    }


