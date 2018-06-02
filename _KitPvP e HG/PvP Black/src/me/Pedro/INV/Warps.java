package me.Pedro.INV;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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

import me.Pedro.Main;

public class Warps
  implements Listener, CommandExecutor
{
  public Warps(Main main) {
	}

public static void gui(Player p)
  {
    Inventory inv = Bukkit.createInventory(null, 27, ChatColor.GOLD + "Warps");
    
    ItemStack Painel = new ItemStack(Material.THIN_GLASS);
    ItemMeta PainelMeta = Painel.getItemMeta();
    PainelMeta.setDisplayName(ChatColor.GRAY + " ");
    Painel.setItemMeta(PainelMeta);
    
    ItemStack fps = new ItemStack(Material.GLASS);
    ItemMeta fpsmeta = fps.getItemMeta();
    fpsmeta.setDisplayName(ChatColor.GOLD + "§7Warp §cFPS");
    fps.setItemMeta(fpsmeta);
    
    ItemStack rdm = new ItemStack(Material.CAKE);
    ItemMeta rdmmeta = rdm.getItemMeta();
    rdmmeta.setDisplayName(ChatColor.GOLD + "§7Evento §cRDM");
    rdm.setItemMeta(rdmmeta);
    
    ItemStack challenge = new ItemStack(Material.LAVA_BUCKET);
    ItemMeta challengemeta = challenge.getItemMeta();
    challengemeta.setDisplayName(ChatColor.GOLD + "§7Warp §cLAVA");
    challenge.setItemMeta(challengemeta);
    
    ItemStack versos = new ItemStack(Material.BLAZE_ROD);
    ItemMeta versosmeta = versos.getItemMeta();
    versosmeta.setDisplayName(ChatColor.GOLD + "§7Warp §c1v1");
    versos.setItemMeta(versosmeta);
    
    fpsmeta.setDisplayName(ChatColor.GOLD + "§7Warp §cFPS");
    fps.setItemMeta(fpsmeta);
    
    inv.setItem(9, fps);
    
    rdmmeta.setDisplayName(ChatColor.GOLD + "§7Evento §cRDM");
    rdm.setItemMeta(rdmmeta);
    
    inv.setItem(17, rdm);
    
    challengemeta.setDisplayName(ChatColor.GOLD + "§7Warp §cLava");
    challenge.setItemMeta(challengemeta);
    
    inv.setItem(10, challenge);
    
    versosmeta.setDisplayName(ChatColor.GOLD + "§7Warp §c1v1");
    versos.setItemMeta(versosmeta);
    
    inv.setItem(11, versos);
    p.openInventory(inv);
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if ((commandLabel.equalsIgnoreCase("warps")) || (commandLabel.equalsIgnoreCase("warp")))
    {
      Player p = (Player)sender;
      
      gui(p);
    }
    return false;
  }
  
  @EventHandler
  public void onInteract(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if (e.getInventory().getName().equalsIgnoreCase(ChatColor.GOLD + "Warps"))
    {
      e.setCancelled(true);
      if (e.getCurrentItem().getType() == Material.GLASS)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/fps");
      }
      if (e.getCurrentItem().getType() == Material.DIAMOND_SWORD)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/mdr");
      }
      if (e.getCurrentItem().getType() == Material.CAKE)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/rdm");
      }
      if (e.getCurrentItem().getType() == Material.BLAZE_ROD)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/1v1");
      }
      if (e.getCurrentItem().getType() == Material.BOWL)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/hg");
      }
      if (e.getCurrentItem().getType() == Material.LAVA_BUCKET)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/lava");
      }
      if (e.getCurrentItem().getType() == Material.POTION)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/main");
      }
      if (e.getCurrentItem().getType() == Material.WATER_BUCKET)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/mlg");
      }
      if (e.getCurrentItem().getType() == Material.STICK)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/knock");
      }
    }
  }
}
