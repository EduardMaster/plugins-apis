package nobody.comandos;


import nobody.eventos.KitAPI;

import org.bukkit.Bukkit;
import org.bukkit.Material;
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

public class Extra
  implements CommandExecutor, Listener
{
  public static ItemStack vidro;
  public static ItemMeta vidrometa;
  public static ItemStack Caixa;
  public static ItemMeta Caixameta;
  public static ItemStack Loja;
  public static ItemMeta Lojameta;
  public static ItemStack LK;
  public static ItemMeta LKmeta;
  public static ItemStack tc;
  public static ItemMeta tcmeta;
  public static ItemStack vinha;
  public static ItemMeta vinhameta;
  public static ItemStack fogo;
  public static ItemMeta fogometa;
  
  @EventHandler
  public void Clicar(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if ((e.getMaterial() == Material.PISTON_STICKY_BASE) && (e.getItem().getType() == Material.PISTON_STICKY_BASE) && (KitAPI.getkit(p) == "Nenhum")) {
      p.chat("/extra");
    }
  }
  
  @EventHandler
  public void Warp(InventoryClickEvent e)
  {
    if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null))
    {
      Player p = (Player)e.getWhoClicked();
      Inventory inv = e.getInventory();
      if (inv.getTitle().equalsIgnoreCase("§c§lCoisas Extras"))
      {
        if (e.getCurrentItem().isSimilar(vidro)) {
          e.setCancelled(true);
        }
        if (e.getCurrentItem().isSimilar(Caixa))
        {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/Caixa");
        }
        if (e.getCurrentItem().isSimilar(Loja))
        {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/status");
        }
        if (e.getCurrentItem().isSimilar(tc))
        {
          e.setCancelled(true);
          p.closeInventory();
        }
      }
    }
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage("§f[§cErro§7] §cApenas jogadores podem usar isso");
      return true;
    }
    Player p = (Player)sender;
    Inventory extra = Bukkit.createInventory(p, 36, "§c§lCoisas Extras");
    
    fogo = new ItemStack(Material.FIRE, 1);
    fogometa = fogo.getItemMeta();
    fogometa.setDisplayName("§b§lKITPVP");
    fogo.setItemMeta(fogometa);
    
    vinha = new ItemStack(Material.VINE, 1);
    vinhameta = vinha.getItemMeta();
    vinhameta.setDisplayName("§2Vinha");
    vinha.setItemMeta(vinhameta);
    
    vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
    vidrometa = vidro.getItemMeta();
    vidrometa.setDisplayName("§7-");
    vidro.setItemMeta(vidrometa);
    
    Caixa = new ItemStack(Material.CHEST, 1);
    Caixameta = Caixa.getItemMeta();
    Caixameta.setDisplayName("§eCaixa");
    Caixa.setItemMeta(Caixameta);
    
    Loja = new ItemStack(Material.PAPER, 1);
    Lojameta = Loja.getItemMeta();
    Lojameta.setDisplayName("§cStatus");
    Loja.setItemMeta(Lojameta);
    
    LK = new ItemStack(Material.DIAMOND, 1);
    LKmeta = LK.getItemMeta();
    LKmeta.setDisplayName("§3Rank: §fFIRST");
    LK.setItemMeta(LKmeta);
    
    tc = new ItemStack(Material.NETHER_STAR, 1);
    tcmeta = tc.getItemMeta();
    tcmeta.setDisplayName("§7Teste seu click");
    tc.setItemMeta(tcmeta);
    for (int i = 0; i != 36; i++) {
      extra.setItem(i, vidro);
    }
    extra.setItem(0, vinha);
    extra.setItem(4, fogo);
    extra.setItem(8, vinha);
    extra.setItem(19, Caixa);
    extra.setItem(21, Loja);
    extra.setItem(23, LK);
    extra.setItem(25, tc);
    p.openInventory(extra);
    return false;
  }
}
