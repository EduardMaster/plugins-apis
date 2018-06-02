package GUI;

import java.util.ArrayList;
import Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@SuppressWarnings("unused")
public class Menu
  implements CommandExecutor, Listener
{
  public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args)
  {
    Player p = (Player)Sender;
    if (Cmd.getName().equalsIgnoreCase("Menu"))
    {
      Inventory M = Bukkit.createInventory(p, 54, "§7[§c!§7]§6 Menu §7[§c!§7]");
      
      p.getPlayer().playSound(p.getPlayer().getLocation(), Sound.BURP, 5.0F, 5.0F);
      
      ItemStack kSeusKits = new ItemStack(Material.CHEST);
      ItemMeta mSeusKits = kSeusKits.getItemMeta();
      mSeusKits.setDisplayName("§7[§c!§7] §6§oEMBREVE §7[§c!§7]");
      kSeusKits.setItemMeta(mSeusKits);
      
      ItemStack kForm = new ItemStack(Material.PAPER);
      ItemMeta mForm = kForm.getItemMeta();
      mForm.setDisplayName("§7[§c!§7] §6§oEMBREVE §7[§c!§7]");
      kForm.setItemMeta(mForm);
      
      ItemStack kEfeitos = new ItemStack(Material.FIREWORK);
      ItemMeta mEfeitos = kEfeitos.getItemMeta();
      mEfeitos.setDisplayName("§7[§c!§7] §6§oEfeitos §7[§c!§7]");
      kEfeitos.setItemMeta(mEfeitos);
      
      ItemStack kSurprise = new ItemStack(Material.NAME_TAG);
      ItemMeta mSurprise = kSurprise.getItemMeta();
      mSurprise.setDisplayName("§7[§c!§7] §6§oKit Surprise §7[§c!§7]");
      kSurprise.setItemMeta(mSurprise);
      
      ItemStack kModoSopa = new ItemStack(Material.MUSHROOM_SOUP);
      ItemMeta mModoSopa = kModoSopa.getItemMeta();
      mModoSopa.setDisplayName("§7[§c!§7] §a§oModo: EMBREVE §7[§c!§7]");
      kModoSopa.setItemMeta(mModoSopa);
      
      ItemStack kModoPocao = new ItemStack(Material.POTION, 1, (short)16453);
      ItemMeta mModoPocao = kModoPocao.getItemMeta();
      mModoPocao.setDisplayName("§7[§c!§7] §a§oModo: EMBREVE §7[§c!§7]");
      kModoPocao.setItemMeta(mModoPocao);
      
      ItemStack kStatus = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
      ItemMeta mStatus = kStatus.getItemMeta();
      mStatus.setDisplayName("§7[§c!§7] §6§oStatus §7[§c!§7]");
      kStatus.setItemMeta(mStatus);
      
      ItemStack kLojaDKits = new ItemStack(Material.EMERALD);
      ItemMeta mLojaDKits = kLojaDKits.getItemMeta();
      mLojaDKits.setDisplayName("§7[§c!§7] §6§oLoja De Kits §7[§c!§7]");
      kLojaDKits.setItemMeta(mLojaDKits);
      
      ItemStack kLojaOnline = new ItemStack(Material.DIAMOND);
      ItemMeta mLojaOnline = kLojaOnline.getItemMeta();
      mLojaOnline.setDisplayName("§7[§c!§7] §6§oLoja Buycraft §7[§c!§7]");
      kLojaOnline.setItemMeta(mLojaOnline);
      

      ItemStack kSlotVazio = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
      ItemMeta mSlotVazio = kSlotVazio.getItemMeta();
      mSlotVazio.setDisplayName("§7[§c!§7] §8§oPvP §7[§c!§7]");
      kSlotVazio.setItemMeta(mSlotVazio);
      
      M.setItem(0, kSlotVazio);
      M.setItem(1, kSlotVazio);
      M.setItem(2, kSlotVazio);
      M.setItem(3, kSlotVazio);
      M.setItem(4, kSlotVazio);
      M.setItem(5, kSlotVazio);
      M.setItem(6, kSlotVazio);
      M.setItem(7, kSlotVazio);
      M.setItem(8, kSlotVazio);
      
      M.setItem(9, kModoSopa);
      
      M.setItem(10, kSlotVazio);
      M.setItem(11, kSlotVazio);
      M.setItem(12, kSlotVazio);
      
      M.setItem(13, kStatus);
      
      M.setItem(14, kSlotVazio);
      M.setItem(15, kSlotVazio);
      M.setItem(16, kSlotVazio);
      
      M.setItem(17, kModoPocao);
      
      M.setItem(18, kSlotVazio);
      M.setItem(19, kSlotVazio);
      
      M.setItem(20, kSeusKits);
      
      M.setItem(21, kSlotVazio);
      M.setItem(22, kSlotVazio);
      M.setItem(23, kSlotVazio);
      
      M.setItem(24, kForm);
      
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
  public void onPlayerInteract(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if (p.getItemInHand().getType() == Material.JUKEBOX) {
      p.chat("/menu");
    }
  }
  
  @EventHandler
  public void clickevent(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if (e.getInventory().getTitle().equalsIgnoreCase("§7[§c!§7]§6 Menu §7[§c!§7]"))
    {
      e.getCurrentItem();
      
      e.setCancelled(true);
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7[§c!§7] §6§oSeus Kits §7[§c!§7]"))
      {
        p.closeInventory();
        p.chat("/Kits");
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7[§c!§7] §6§oFormulário §7[§c!§7]"))
      {
        p.closeInventory();
        p.chat("/Form");
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7[§c!§7] §6§oEfeitos §7[§c!§7]"))
      {
        p.closeInventory();
        p.sendMessage("§7[§c!§7]§c Efeitos Em Manutenção §7[§c!§7]");
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7[§c!§7] §6§oKit Surprise §7[§c!§7]"))
      {
        p.closeInventory();
        p.chat("/surprise");
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7[§c!§7] §6§oStatus §7[§c!§7]"))
      {
        p.closeInventory();
        p.chat("/Status");
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7[§c!§7] §6§oLoja De Kits §7[§c!§7]"))
      {
        p.closeInventory();
        p.chat("/Shop");
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7[§c!§7] §6§oLoja Buycraft §7[§c!§7]"))
      {
        p.closeInventory();
        p.chat("/Buy");
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7[§c!§7] §a§o EMBREVE §7[§c!§7]"))
      {
  }
    }
  }
}
