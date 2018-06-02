package nobody.eventos;

import nobody.main.Main;

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
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Cabeças
  implements Listener, CommandExecutor
{
  public static Main plugin;
  
  public Cabeças(Main main)
  {
    plugin = main;
  }
  
  public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args)
  {
    Player p = (Player)Sender;
    if (Label.equalsIgnoreCase("heads"))
    {
      if (Sender.hasPermission("tk.heads"))
      {
      }
    }
    
    Inventory inv = Bukkit.getServer().createInventory(p, 27, "§aHeads");
    
    @SuppressWarnings("deprecation")
	ItemStack vidro = new ItemStack(Material.getMaterial(160),1 ,(short)2);
    ItemMeta vidrometa = vidro.getItemMeta();
    vidrometa.setDisplayName(" ");
    vidro.setItemMeta(vidrometa);
    
    ItemStack vidro1 = new ItemStack(Material.STAINED_GLASS_PANE);
    ItemMeta vidrometa1 = vidro1.getItemMeta();
    vidrometa1.setDisplayName(" ");
    vidro1.setItemMeta(vidrometa1);
    
    ItemStack folha = new ItemStack(Material.FIRE);
    ItemMeta folhameta = folha.getItemMeta();
    folhameta.setDisplayName("§eExtreme§fKits");
    folha.setItemMeta(folhameta);
    
    ItemStack a = new ItemStack(Material.JACK_O_LANTERN);
    
    ItemStack b = new ItemStack(Material.BOOKSHELF);
    
    ItemStack c = new ItemStack(Material.DISPENSER);
    
    ItemStack d = new ItemStack(Material.GLASS);
    
    ItemStack e = new ItemStack(Material.PISTON_STICKY_BASE);
    
    ItemStack f = new ItemStack(Material.WORKBENCH);
    
    ItemStack h = new ItemStack(Material.TNT);
    
    inv.setItem(0, folha);
    inv.setItem(1, vidro);
    inv.setItem(2, vidro);
    inv.setItem(3, vidro);
    inv.setItem(4, vidro1);
    inv.setItem(5, vidro);
    inv.setItem(6, vidro);
    inv.setItem(7, vidro);
    inv.setItem(8, folha);
    inv.setItem(9, vidro);
    inv.setItem(10, vidro);
    inv.setItem(11, a);
    inv.setItem(12, b);
    inv.setItem(13, c);
    inv.setItem(14, d);
    inv.setItem(15, e);
    inv.setItem(16, vidro);
    inv.setItem(17, vidro);
    inv.setItem(18, vidro);
    inv.setItem(19, vidro);
    inv.setItem(20, f);
    inv.setItem(21, vidro);
    inv.setItem(22, vidro);
    inv.setItem(23, vidro);
    inv.setItem(24, h);
    inv.setItem(25, vidro);
    inv.setItem(26, vidro);
    
    p.openInventory(inv);
	return false;
      }
  
@SuppressWarnings("deprecation")
@EventHandler
  public void onPlaye4254rCLic54kInventr432y15(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if ((e.getInventory().getTitle().equalsIgnoreCase("§aHeads")) && 
      (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
    {
      e.setCancelled(true);
      p.closeInventory();
      if (e.getCurrentItem().getType() == Material.JACK_O_LANTERN)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.getInventory().setHelmet(new ItemStack(Material.JACK_O_LANTERN));
        p.sendMessage("§aVocê trocou de cabeça!");
        p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1.0F, 1.0F);
        return;
      }
      if (e.getCurrentItem().getType() == Material.BOOKSHELF)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.getInventory().setHelmet(new ItemStack(Material.BOOKSHELF));
        p.sendMessage("§aVocê trocou de cabeça!");
        p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1.0F, 1.0F);
        return;
      }
      if (e.getCurrentItem().getType() == Material.DISPENSER)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.getInventory().setHelmet(new ItemStack(Material.DISPENSER));
        p.sendMessage("§aVocê trocou de cabeça!");
        p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1.0F, 1.0F);
        return;
      }
      if (e.getCurrentItem().getType() == Material.GLASS)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.getInventory().setHelmet(new ItemStack(Material.GLASS));
        p.sendMessage("§aVocê trocou de cabeça!");
        p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1.0F, 1.0F);
        return;
      }
      if (e.getCurrentItem().getType() == Material.PISTON_STICKY_BASE)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.getInventory().setHelmet(new ItemStack(Material.PISTON_STICKY_BASE));
        p.sendMessage("§aVocê trocou de cabeça!");
        p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1.0F, 1.0F);
        return;
      }
      if (e.getCurrentItem().getType() == Material.TNT)
      {
        e.setCancelled(true);
        p.getInventory().setHelmet(new ItemStack(Material.TNT));
        p.sendMessage("§aVocê trocou de cabeça!");
        p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1.0F, 1.0F);
        return;
      }
      if (e.getCurrentItem().getType() == Material.WORKBENCH)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.getInventory().setHelmet(new ItemStack(Material.WORKBENCH));
        p.sendMessage("§aVocê trocou de cabeça!");
        p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1.0F, 1.0F);
        return;
      }
    }
  }
}
