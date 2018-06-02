package nobody.comandos;

import nobody.eventos.Money;

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

public class LojaPerms
  implements CommandExecutor, Listener
{
  public static ItemStack vidro;
  public static ItemMeta vidrometa;
  public static ItemStack vinha;
  public static ItemMeta vinhameta;
  public static ItemStack Armario;
  public static ItemMeta Armariometa;
  public static ItemStack Colorido;
  public static ItemMeta Coloridometa;
  public static ItemStack Cheio;
  public static ItemMeta Cheiometa;
  public static ItemStack Camel;
  public static ItemMeta Camelmeta;
  public static ItemStack Avatar;
  public static ItemMeta Avatarmeta;
  public static ItemStack ForceField;
  public static ItemMeta ForceFieldmeta;
  public static ItemStack Rain;
  public static ItemMeta Rainmeta;
  public static ItemStack Whitelist;
  public static ItemMeta Whitelistmeta;
  

  @EventHandler
  public void PvP(InventoryClickEvent e)
  {
    if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null))
    {
      Player p = (Player)e.getWhoClicked();
      Inventory inv = e.getInventory();
      if (inv.getTitle().equalsIgnoreCase("§b§l§nLoja de Perms"))
      {
        if (e.getCurrentItem().isSimilar(vidro)) {
          e.setCancelled(true);
        }
        if (e.getCurrentItem().isSimilar(Armario))
        {
          e.setCancelled(true);
          {
            if (Money.getMoney(p) >= 1000000)
            {
              Sucesso(p, "Armario");
              Money.removeMoney(p, 1000000);
            }
            else
            {
              MoneyErro(p, "Armario", 1000000);
            }
          }
          }
        }
        if (e.getCurrentItem().isSimilar(Colorido))
        {
          e.setCancelled(true);          {
        	  
            if (Money.getMoney(p) >= 110000)
            {
              colorido(p, "Colorido");
              Money.removeMoney(p, 110000);
            }
            else
            {
              MoneyErro(p, "Colorido", 110000);
            }
          }
          }
        if (e.getCurrentItem().isSimilar(Cheio))
        {
          e.setCancelled(true);
          {
            if (Money.getMoney(p) >= 10000)
            {
              cheiio(p, "Cheio");
              Money.removeMoney(p, 10000);
            }
            else
            {
              MoneyErro(p, "Cheio", 10000);
            }
          }
          
        }
        if (e.getCurrentItem().isSimilar(Whitelist))
        {
          e.setCancelled(true);
          {
            if (Money.getMoney(p) >= 10000)
            {
              whitelist(p, "Whitelist");
              Money.removeMoney(p, 10000);
            }
            else
            {
              MoneyErro(p, "Whitelist", 10000);
            }
          }
          }
        }
      }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage("§7[§cErro§7] §cApenas jogadores podem executar esse comando");
      return true;
    }
    Player p = (Player)sender;
    Inventory loja = Bukkit.createInventory(p, 27, "§b§l§nLoja de Permissoes");
    
    vidro = new ItemStack(Material.STAINED_GLASS_PANE, 0);
    vidrometa = vidro.getItemMeta();
    vidrometa.setDisplayName("§7-");
    vidro.setItemMeta(vidrometa);
    
    vinha = new ItemStack(Material.STAINED_GLASS_PANE, 0);
    vinhameta = vinha.getItemMeta();
    vinhameta.setDisplayName("§7-");
    vinha.setItemMeta(vinhameta);
    
    Colorido = new ItemStack(Material.VINE, 1);
    Coloridometa = Colorido.getItemMeta();
    Coloridometa.setDisplayName("§6§lFalar C§2o§al§5o§4r§3i§1d§9o §aR$ 10000");
    Colorido.setItemMeta(Coloridometa);
    
    Whitelist = new ItemStack(Material.LAVA_BUCKET, 1);
    Whitelistmeta = Whitelist.getItemMeta();
    Whitelistmeta.setDisplayName("§6§lEntrar na Whitelist §aR$ 10000");
    Whitelist.setItemMeta(Whitelistmeta);
    
    Cheio = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
    Cheiometa = Cheio.getItemMeta();
    Cheiometa.setDisplayName("§6§lEntrar com Servidor Cheio §aR$ 10000");
    Cheio.setItemMeta(Cheiometa);
    
    Armario = new ItemStack(Material.WEB, 1);
    Armariometa = Armario.getItemMeta();
    Armariometa.setDisplayName("§6§lArmario §aR$ MANUTENÇÃO");
    Armario.setItemMeta(Armariometa);
    for (int i = 0; i != 27; i++) {
      loja.setItem(i, vidro);
    }
    loja.setItem(10, Colorido);
    loja.setItem(12, Whitelist);
    loja.setItem(14, Cheio);
    loja.setItem(16, Armario);
    p.openInventory(loja);
    return false;
  }
  
  public void MoneyErro(Player p, String k, int m)
  {
    p.sendMessage("§c§lVocê não tem " + m + " §c§lDe Money Para comprar essa Permissão");
    p.closeInventory();
  }
  
  
  public void Sucesso(Player p, String k)
  {
    p.sendMessage("§a§lParabéns Você comprou a Permissão §6" + k);
    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kit." + k);
    p.closeInventory();
  }

public void colorido(Player p, String k)
{
  p.sendMessage("§a§lParabéns Você comprou a Permissão §6" + k);
  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add tk.colorido");
  p.closeInventory();
}

public void whitelist(Player p, String k)
{
  p.sendMessage("§a§lParabéns Você comprou a Permissão §6" + k);
  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "whitelist add " + p.getName());
  p.closeInventory();
}


public void cheiio(Player p, String k)
{
  p.sendMessage("§a§lParabéns Você comprou a Permissão §6" + k);
  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add tk.cheio");
  p.closeInventory();
}
}