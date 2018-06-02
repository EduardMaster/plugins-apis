package me.rafael.vinagre.KomboPvP.Comandos;

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

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Strings;

public class LojadoServidor
  implements Listener, CommandExecutor
{
  public static ItemStack vidro;
  public static ItemMeta vidrometa;
  public static ItemStack vidro2;
  public static ItemMeta vidro2meta;
  public static ItemStack VIP;
  public static ItemMeta VIPmeta;
  public static ItemStack Kits;
  public static ItemMeta Kitsmeta;
  public static ItemStack unban;
  public static ItemMeta unbanmeta;
  
	public LojadoServidor(me.rafael.vinagre.KomboPvP.Main main) {
	}

  
  @EventHandler
  public void warps(InventoryClickEvent e)
  {
    if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null))
    {
      Inventory inv = e.getInventory();
      Player p = (Player)e.getWhoClicked();
      if (inv.getTitle().equals( " §eServer"))
      {
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
        e.setCancelled(true);
      }
      if (e.getCurrentItem().isSimilar(VIP))
      {
        p.sendMessage("§7           " +  "§7           ");
        p.sendMessage("         §7» Adiquire seu VIP Em: «          ");
        p.sendMessage("§7           " +    ((Main.getPlugin().getConfig().getString("Site").replace("&", "§"))))         ;
        
        p.closeInventory();
      }
      if (e.getCurrentItem().isSimilar(Kits))
      {
        p.sendMessage("§7           " +  "§7           ");
        p.sendMessage("        §7» §7Adiquire seu Kits Em: «          ");
        p.sendMessage("§7           " +    ((Main.getPlugin().getConfig().getString("Site").replace("&", "§"))))       ;
        p.sendMessage("§7           " +  "§7           ");
        p.closeInventory();
      }
      if (e.getCurrentItem().isSimilar(unban))
      {
        p.sendMessage("§7           " +  "§7           ");
        p.sendMessage("        §7» §7Adiquire seu Unban Em: «          ");
        p.sendMessage("§7           " +   ((Main.getPlugin().getConfig().getString("Site").replace("&", "§"))))        ;
        p.sendMessage("§7           " +  "§7           ");
        p.closeInventory();
      }
    }
  }
  
 


@SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player)) {
      return true;
    }
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("lojadoservidor"))
    {
      Inventory lojadoservidor = Bukkit.createInventory(p, 27,  "§eLoja do Server");
      
      vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)13);
      vidrometa = vidro.getItemMeta();
      vidrometa.setDisplayName("§6§LLoja do SV");
      vidro.setItemMeta(vidrometa);
      
      vidro2 = new ItemStack(Material.getMaterial(160), 1, (short)14);
      vidro2meta = vidro2.getItemMeta();
      vidro2meta.setDisplayName("§6§LLoja do SV");
      vidro2.setItemMeta(vidro2meta);
      
      VIP = new ItemStack(Material.DIAMOND);
      VIPmeta = VIP.getItemMeta();
      VIPmeta.setDisplayName("§6§lVips");
      VIP.setItemMeta(VIPmeta);
      
      Kits = new ItemStack(Material.STORAGE_MINECART);
      Kitsmeta = Kits.getItemMeta();
      Kitsmeta.setDisplayName("§a§lKits");
      Kits.setItemMeta(Kitsmeta);
      
      unban = new ItemStack(Material.IRON_FENCE);
      unbanmeta = unban.getItemMeta();
      unbanmeta.setDisplayName("§c§lUnban");
      unban.setItemMeta(unbanmeta);
      for (int i = 0; i != 27; i++)
      {
        lojadoservidor.setItem(i, vidro);
        lojadoservidor.setItem(1, vidro2);
        lojadoservidor.setItem(3, vidro2);
        lojadoservidor.setItem(5, vidro2);
        lojadoservidor.setItem(7, vidro2);
        lojadoservidor.setItem(9, vidro2);
        lojadoservidor.setItem(11, VIP);
        lojadoservidor.setItem(13, Kits);
        lojadoservidor.setItem(15, unban);
        lojadoservidor.setItem(17, vidro2);
        lojadoservidor.setItem(19, vidro2);
        lojadoservidor.setItem(21, vidro2);
        lojadoservidor.setItem(23, vidro2);
        lojadoservidor.setItem(25, vidro2);
      }
      p.openInventory(lojadoservidor);
      return true;
    }
    return true;
  }
}