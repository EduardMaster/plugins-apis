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
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Menu
  implements CommandExecutor, Listener
{
  public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args)
  {
    Player p = (Player)Sender;
    if (Cmd.getName().equalsIgnoreCase("Menu"))
    {
      Inventory M = Bukkit.createInventory(p, 54, "§6ExtremeKits");
      
      ItemStack kSeusKits = new ItemStack(Material.CHEST);
      ItemMeta mSeusKits = kSeusKits.getItemMeta();
      mSeusKits.setDisplayName("§6Kits");
      kSeusKits.setItemMeta(mSeusKits);
      
      ItemStack kForm = new ItemStack(Material.ANVIL);
      ItemMeta mForm = kForm.getItemMeta();
      mForm.setDisplayName("§6Formulário");
      kForm.setItemMeta(mForm);
      
      @SuppressWarnings("deprecation")
	ItemStack kRed = new ItemStack(Material.getMaterial(160),1 ,(short)0);
      ItemMeta mRed = kRed.getItemMeta();
      mRed.setDisplayName("§6");
      kRed.setItemMeta(mRed);
      
      ItemStack kHeads = new ItemStack(Material.TNT);
      ItemMeta mHeads = kHeads.getItemMeta();
      mHeads.setDisplayName("§aCabeças");
      kHeads.setItemMeta(mHeads);
      
      ItemStack kEfeitos = new ItemStack(Material.BEACON);
      ItemMeta mEfeitos = kEfeitos.getItemMeta();
      mEfeitos.setDisplayName("§6Efeitos");
      kEfeitos.setItemMeta(mEfeitos);
      
      ItemStack kSurprise = new ItemStack(Material.PAPER);
      ItemMeta mSurprise = kSurprise.getItemMeta();
      mSurprise.setDisplayName("§6Warps");
      kSurprise.setItemMeta(mSurprise);   
      
      ItemStack kStatus = new ItemStack(Material.BOOK);
      ItemMeta mStatus = kStatus.getItemMeta();
      mStatus.setDisplayName("§6Status");
      kStatus.setItemMeta(mStatus);
      
      @SuppressWarnings("deprecation")
	ItemStack kLojaDKits = new ItemStack(Material.getMaterial(342));
      ItemMeta mLojaDKits = kLojaDKits.getItemMeta();
      mLojaDKits.setDisplayName("§6Menu de Lojas");
      kLojaDKits.setItemMeta(mLojaDKits);
      
      ItemStack kLojaOnline = new ItemStack(Material.DIAMOND);
      ItemMeta mLojaOnline = kLojaOnline.getItemMeta();
      mLojaOnline.setDisplayName("§6BuyCraft");
      kLojaOnline.setItemMeta(mLojaOnline);
      
      ItemStack kSlotVazio = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
      ItemMeta mSlotVazio = kSlotVazio.getItemMeta();
      mSlotVazio.setDisplayName(" ");
      kSlotVazio.setItemMeta(mSlotVazio);
      
      M.setItem(0, kRed);
      M.setItem(1, kRed);
      M.setItem(2, kRed);
      M.setItem(3, kRed);
      M.setItem(4, kRed);
      M.setItem(5, kRed);
      M.setItem(6, kRed);
      M.setItem(7, kRed);
      M.setItem(8, kRed);
      
      M.setItem(9, kSlotVazio);
      
      M.setItem(10, kSlotVazio);
      M.setItem(11, kSeusKits);
      M.setItem(12, kSlotVazio);
      
      M.setItem(13, kStatus);
      
      M.setItem(14, kSlotVazio);
      M.setItem(15, kForm);
      M.setItem(16, kSlotVazio);
      
      M.setItem(17, kSlotVazio);
      
      M.setItem(18, kSlotVazio);
      M.setItem(19, kSlotVazio);
      
      M.setItem(20, kSlotVazio);
      
      M.setItem(21, kSlotVazio);
      M.setItem(22, kHeads);
      M.setItem(23, kSlotVazio);
      
      M.setItem(24, kSlotVazio);
      
      M.setItem(25, kSlotVazio);
      M.setItem(26, kSlotVazio);
      M.setItem(27, kSlotVazio);
      M.setItem(28, kSlotVazio);
      M.setItem(29, kSlotVazio);
      M.setItem(30, kSlotVazio);
      
      M.setItem(31, kEfeitos);
      
      M.setItem(32, kSlotVazio);
      M.setItem(33, kSlotVazio);
      M.setItem(34, kSlotVazio);
      M.setItem(35, kSlotVazio);
      M.setItem(36, kSlotVazio);
      
      M.setItem(37, kLojaDKits);
      
      M.setItem(38, kSlotVazio);
      M.setItem(39, kSlotVazio);
      M.setItem(40, kSlotVazio);
      M.setItem(41, kSlotVazio);
      M.setItem(42, kSlotVazio);
      
      M.setItem(43, kLojaOnline);
      
      M.setItem(44, kSlotVazio);
      M.setItem(45, kSlotVazio);
      M.setItem(46, kSlotVazio);
      M.setItem(47, kSlotVazio);
      M.setItem(48, kSlotVazio);
      
      M.setItem(49, kSurprise);
      
      M.setItem(50, kSlotVazio);
      M.setItem(51, kSlotVazio);
      M.setItem(52, kSlotVazio);
      M.setItem(53, kSlotVazio);
      
      p.openInventory(M);
    }
    return false;
  }
  
  @EventHandler
  public void clickevent(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if (e.getInventory().getTitle().equalsIgnoreCase("§6ExtremeKits"))
    {
      e.getCurrentItem();
      e.setCancelled(true);

      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Kitss"))
      {
        p.chat("/kit");
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Formulário"))
      {
        p.closeInventory();
        p.chat("/aplicar");
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Efeitos"))
      {
        p.closeInventory();
        p.sendMessage("§c Efeitos Em Manutençao ");
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Warps"))
      {
    	  p.closeInventory();
        p.chat("/warps");
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Status"))
      {
        p.closeInventory();
        p.chat("/Status");
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Menu de Lojas"))
      {
        p.chat("/lojas");
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aCabeças"))
      {
        p.chat("/heads");
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6BuyCraft"))
      {
    	p.closeInventory();
        p.chat("/Buy");
      }

      }

    
  }
  }

