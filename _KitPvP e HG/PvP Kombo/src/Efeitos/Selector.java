package Efeitos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Server;
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

import me.rafael.vinagre.KomboPvP.Main;

@SuppressWarnings("unused")
public class Selector
  implements Listener, CommandExecutor
{
  public Selector(Main main) {}
  
  @EventHandler
  public void onClickKits(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if (e.getInventory().getTitle().equalsIgnoreCase("§6§lEfeitos [§a§l1§6§l]"))
    {
      if (e.getCurrentItem() == null) {
        return;
      }
      e.setCancelled(true);
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lEfeito: FLAME"))
      {
        p.closeInventory();
        p.chat("/efeito1");
      }
      e.setCancelled(true);
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lEfeito: ENDER_SIGNAL"))
      {
        p.closeInventory();
        p.chat("/efeito2");
      }
      e.setCancelled(true);
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lEfeito: SMOKE"))
      {
        p.closeInventory();
        p.chat("/efeito3");
      }
      e.setCancelled(true);
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lEfeito: REDSTONE_BLOCK"))
      {
        p.closeInventory();
        p.chat("/efeito4");
      }
      e.setCancelled(true);
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lEfeito: DIAMOND_BLOCK"))
      {
        p.closeInventory();
        p.chat("/efeito5");
      }
      e.setCancelled(true);
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lEfeito: WATER"))
      {
        p.closeInventory();
        p.chat("/efeito6");
      }
      e.setCancelled(true);
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lEfeito: POTION_BREAK"))
      {
        p.closeInventory();
        p.chat("/efeito7");
      }
      e.setCancelled(true);
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lEfeito: RAINBOW"))
      {
        p.closeInventory();
        p.chat("/efeito8");
      }
      e.setCancelled(true);
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§l-> RemoverEfeito <-"))
      {
        p.closeInventory();
        p.chat("/removerefeito");
        p.chat("/efeitos");
      }
      e.setCancelled(true);
      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f§ §cVoltar §f§"))
      {
        p.closeInventory();
        p.chat("/menu");
      }
    }
  }
  
  public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args)
  {
    if (Cmd.getName().equalsIgnoreCase("efeitos"))
    {
      Player p = (Player)Sender;
      
      Inventory inv = Bukkit.getServer().createInventory(p, 54, "§6§lEfeitos [§a§l1§6§l]");
      ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)13);
      ItemMeta metav = vidro.getItemMeta();
      metav.setDisplayName("§f-");
      vidro.setItemMeta(metav);
      
      ItemStack flame = new ItemStack(Material.BLAZE_POWDER);
      ItemMeta flamek = flame.getItemMeta();
      flamek.setDisplayName("§b§lEfeito: FLAME");
      flame.setItemMeta(flamek);
      
      ItemStack ender = new ItemStack(Material.EYE_OF_ENDER);
      ItemMeta kender = ender.getItemMeta();
      kender.setDisplayName("§b§lEfeito: ENDER_SIGNAL");
      ender.setItemMeta(kender);
      
      ItemStack smoke = new ItemStack(Material.FIREWORK_CHARGE);
      ItemMeta ksmoke = smoke.getItemMeta();
      ksmoke.setDisplayName("§b§lEfeito: SMOKE");
      smoke.setItemMeta(ksmoke);
      
      ItemStack redstone = new ItemStack(Material.REDSTONE_BLOCK);
      ItemMeta kredstone = redstone.getItemMeta();
      kredstone.setDisplayName("§b§lEfeito: REDSTONE_BLOCK");
      redstone.setItemMeta(kredstone);
      
      ItemStack diamond = new ItemStack(Material.DIAMOND_BLOCK);
      ItemMeta kdiamond = diamond.getItemMeta();
      kdiamond.setDisplayName("§b§lEfeito: DIAMOND_BLOCK");
      diamond.setItemMeta(kdiamond);
      
      ItemStack water = new ItemStack(Material.WATER);
      ItemMeta kwater = water.getItemMeta();
      kwater.setDisplayName("§b§lEfeito: WATER");
      water.setItemMeta(kwater);
      
      ItemStack potion = new ItemStack(Material.POTION);
      ItemMeta kpotion = potion.getItemMeta();
      kpotion.setDisplayName("§b§lEfeito: POTION_BREAK");
      potion.setItemMeta(kpotion);
      
      ItemStack rainbow = new ItemStack(Material.GOLDEN_APPLE, 1, (short)1);
      ItemMeta krainbow = rainbow.getItemMeta();
      krainbow.setDisplayName("§b§lEfeito: RAINBOW");
      rainbow.setItemMeta(krainbow);
      
      ItemStack remover = new ItemStack(Material.REDSTONE_TORCH_ON);
      ItemMeta kremover = remover.getItemMeta();
      kremover.setDisplayName("§c§l-> RemoverEfeito <-");
      remover.setItemMeta(kremover);
      
      ItemStack mais = new ItemStack(Material.COOKIE);
      ItemMeta maismeta = mais.getItemMeta();
      maismeta.setDisplayName("§c§l-> EmBreve Mais Efeifos <-");
      mais.setItemMeta(maismeta);
      
      ItemStack v = new ItemStack(Material.REDSTONE);
      ItemMeta kv = v.getItemMeta();
      kv.setDisplayName("§f|| §cVoltar §f||");
      v.setItemMeta(kv);
      
      ItemStack escada = new ItemStack(Material.STAINED_GLASS_PANE , 1 , (short)14);
      ItemMeta kescada = escada.getItemMeta();
      kescada.setDisplayName("§f-");
      escada.setItemMeta(kescada);
      
      inv.setItem(0, escada);
      inv.setItem(1, vidro);
      inv.setItem(2, escada);
      inv.setItem(3, vidro);
      inv.setItem(4, mais);
      inv.setItem(5, vidro);
      inv.setItem(6, escada);
      inv.setItem(7, vidro);
      inv.setItem(8, escada);
      
      inv.setItem(9, escada);
      inv.setItem(10, rainbow);
      inv.setItem(11, escada);
      inv.setItem(12, water);
      inv.setItem(13, escada);
      inv.setItem(14, diamond);
      inv.setItem(15, escada);
      inv.setItem(16, redstone);
      inv.setItem(17, escada);
      
      inv.setItem(18, v);
      inv.setItem(19, vidro);
      inv.setItem(20, escada);
      inv.setItem(21, vidro);
      inv.setItem(22, escada);
      inv.setItem(23, vidro);
      inv.setItem(24, escada);
      inv.setItem(25, vidro);
      inv.setItem(26, remover);
      
      inv.setItem(27, escada);
      inv.setItem(28, flame);
      inv.setItem(29, escada);
      inv.setItem(30, smoke);
      inv.setItem(31, escada);
      inv.setItem(32, ender);
      inv.setItem(33, escada);
      inv.setItem(34, potion);
      inv.setItem(35, escada);
      
      inv.setItem(36, escada);
      inv.setItem(37, vidro);
      inv.setItem(38, escada);
      inv.setItem(39, vidro);
      inv.setItem(40, escada);
      inv.setItem(41, vidro);
      inv.setItem(42, escada);
      inv.setItem(43, vidro);
      inv.setItem(44, escada);
      
      inv.setItem(45, escada);
      inv.setItem(46, vidro);
      inv.setItem(47, escada);
      inv.setItem(48, vidro);
      inv.setItem(49, mais);
      inv.setItem(50, vidro);
      inv.setItem(51, escada);
      inv.setItem(52, vidro);
      inv.setItem(53, escada);
      
      p.openInventory(inv);
      return true;
    }
    return false;
  }
}
