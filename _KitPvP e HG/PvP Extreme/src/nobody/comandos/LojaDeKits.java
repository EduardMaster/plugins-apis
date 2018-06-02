package nobody.comandos;

import nobody.eventos.KitAPI;
import nobody.eventos.Money;
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
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LojaDeKits
  implements CommandExecutor, Listener
{
  public static ItemStack vidro;
  public static ItemMeta vidrometa;
  public static ItemStack vinha;
  public static ItemMeta vinhameta;
  public static ItemStack Anchor;
  public static ItemMeta Anchormeta;
  public static ItemStack Stomper;
  public static ItemMeta Stompermeta;
  public static ItemStack Endermage;
  public static ItemMeta Endermagemeta;
  public static ItemStack Camel;
  public static ItemMeta Camelmeta;
  public static ItemStack Avatar;
  public static ItemMeta Avatarmeta;
  public static ItemStack ForceField;
  public static ItemMeta ForceFieldmeta;
  public static ItemStack Rain;
  public static ItemMeta Rainmeta;
  public static ItemStack Snail;
  public static ItemMeta Snailmeta;
  
  @EventHandler
  public void Clicar(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if ((e.getMaterial() == Material.DIAMOND) && (e.getItem().getType() == Material.DIAMOND) && (KitAPI.getkit(p) == "Nenhum"))
    {
      p.playSound(p.getLocation(), Sound.CHEST_OPEN, 1.0F, 1.0F);
      p.chat("/loja");
    }
  }
  
  @EventHandler
  public void PvP(InventoryClickEvent e)
  {
    if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null))
    {
      Player p = (Player)e.getWhoClicked();
      Inventory inv = e.getInventory();
      if (inv.getTitle().equalsIgnoreCase("§b§l§nLoja de Kits"))
      {
        if (e.getCurrentItem().isSimilar(vidro)) {
          e.setCancelled(true);
        }
        if (e.getCurrentItem().isSimilar(Anchor))
        {
          e.setCancelled(true);
          if (Main.getInstance().loja.getString(p.getName().toLowerCase() + ".Anchor").equals("false"))
          {
            if (Money.getMoney(p) >= 30000)
            {
              Sucesso(p, "Anchor");
              Money.removeMoney(p, 30000);
            }
            else
            {
              MoneyErro(p, "Anchor", 30000);
            }
          }
          else {
            Jatem(p);
          }
        }
        if (e.getCurrentItem().isSimilar(Stomper))
        {
          e.setCancelled(true);
          if (Main.getInstance().loja.getString(p.getName().toLowerCase() + ".Stomper").equals("false"))
          {
            if (Money.getMoney(p) >= 35000)
            {
              Sucesso(p, "Stomper");
              Money.removeMoney(p, 35000);
            }
            else
            {
              MoneyErro(p, "Stomper", 35000);
            }
          }
          else {
            Jatem(p);
          }
        }
        if (e.getCurrentItem().isSimilar(Endermage))
        {
          e.setCancelled(true);
          if (Main.getInstance().loja.getString(p.getName().toLowerCase() + ".Endermage").equals("false"))
          {
            if (Money.getMoney(p) >= 30000)
            {
              Sucesso(p, "Endermage");
              Money.removeMoney(p, 30000);
            }
            else
            {
              MoneyErro(p, "Endermage", 30000);
            }
          }
          else {
            Jatem(p);
          }
        }
        if (e.getCurrentItem().isSimilar(Camel))
        {
          e.setCancelled(true);
          if (Main.getInstance().loja.getString(p.getName().toLowerCase() + ".Camel").equals("false"))
          {
            if (Money.getMoney(p) >= 30000)
            {
              Sucesso(p, "Camel");
              Money.removeMoney(p, 30000);
            }
            else
            {
              MoneyErro(p, "Camel", 30000);
            }
          }
          else {
            Jatem(p);
          }
        }
        if (e.getCurrentItem().isSimilar(Avatar))
        {
          e.setCancelled(true);
          if (Main.getInstance().loja.getString(p.getName().toLowerCase() + ".Avatar").equals("false"))
          {
            if (Money.getMoney(p) >= 35000)
            {
              Sucesso(p, "Avatar");
              Money.removeMoney(p, 35000);
            }
            else
            {
              MoneyErro(p, "Avatar", 35000);
            }
          }
          else {
            Jatem(p);
          }
        }
        if (e.getCurrentItem().isSimilar(ForceField))
        {
          e.setCancelled(true);
          if (Main.getInstance().loja.getString(p.getName().toLowerCase() + ".ForceField").equals("false"))
          {
            if (Money.getMoney(p) >= 35000)
            {
              Sucesso(p, "ForceField");
              Money.removeMoney(p, 35000);
            }
            else
            {
              MoneyErro(p, "ForceField", 35000);
            }
          }
          else {
            Jatem(p);
          }
        }
        if (e.getCurrentItem().isSimilar(Rain))
        {
          e.setCancelled(true);
          if (Main.getInstance().loja.getString(p.getName().toLowerCase() + ".Rain").equals("false"))
          {
            if (Money.getMoney(p) >= 35000)
            {
              Sucesso(p, "Rain");
              Money.removeMoney(p, 35000);
            }
            else
            {
              MoneyErro(p, "Rain", 35000);
            }
          }
          else {
            Jatem(p);
          }
        }
        if (e.getCurrentItem().isSimilar(Snail))
        {
          e.setCancelled(true);
          if (Main.getInstance().loja.getString(p.getName().toLowerCase() + ".Snail").equals("false"))
          {
            if (Money.getMoney(p) >= 30000)
            {
              Sucesso(p, "Snail");
              Money.removeMoney(p, 30000);
            }
            else
            {
              MoneyErro(p, "Snail", 30000);
            }
          }
          else {
            Jatem(p);
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
    Inventory loja = Bukkit.createInventory(p, 45, "§b§l§nLoja de Kits");
    
    vidro = new ItemStack(Material.STAINED_GLASS_PANE, 0);
    vidrometa = vidro.getItemMeta();
    vidrometa.setDisplayName("§7-");
    vidro.setItemMeta(vidrometa);
    
    vinha = new ItemStack(Material.STAINED_GLASS_PANE, 0);
    vinhameta = vinha.getItemMeta();
    vinhameta.setDisplayName("§7-");
    vinha.setItemMeta(vinhameta);
    
    Anchor = new ItemStack(Material.ANVIL, 1);
    Anchormeta = Anchor.getItemMeta();
    Anchormeta.setDisplayName("§6§lAnchor §aR$ 30.000");
    Anchor.setItemMeta(Anchormeta);
    
    Stomper = new ItemStack(Material.LEATHER_BOOTS, 1);
    Stompermeta = Stomper.getItemMeta();
    Stompermeta.setDisplayName("§6§lStomper §aR$ 35.000");
    Stomper.setItemMeta(Stompermeta);
    
    Endermage = new ItemStack(Material.PORTAL, 1);
    Endermagemeta = Endermage.getItemMeta();
    Endermagemeta.setDisplayName("§6§lEndermage §aR$ 30.000");
    Endermage.setItemMeta(Endermagemeta);
    
    Camel = new ItemStack(Material.SAND, 1);
    Camelmeta = Camel.getItemMeta();
    Camelmeta.setDisplayName("§6§lCamel §aR$ 3");
    Camel.setItemMeta(Camelmeta);
    
    Avatar = new ItemStack(Material.WOOL, 1);
    Avatarmeta = Avatar.getItemMeta();
    Avatarmeta.setDisplayName("§6§lAvatar §aR$ 35.000");
    Avatar.setItemMeta(Avatarmeta);
    
    ForceField = new ItemStack(Material.COMPASS, 1);
    ForceFieldmeta = ForceField.getItemMeta();
    ForceFieldmeta.setDisplayName("§6§lForceField §aR$ 35.000");
    ForceField.setItemMeta(ForceFieldmeta);
    
    Rain = new ItemStack(Material.ARROW, 1);
    Rainmeta = Rain.getItemMeta();
    Rainmeta.setDisplayName("§6§lRain §aR$ 35.000");
    Rain.setItemMeta(Rainmeta);
    
    Snail = new ItemStack(Material.WEB, 1);
    Snailmeta = Snail.getItemMeta();
    Snailmeta.setDisplayName("§6§lSnail §aR$ 30.000");
    Snail.setItemMeta(Snailmeta);
    for (int i = 0; i != 45; i++) {
      loja.setItem(i, vidro);
    }
    loja.setItem(10, Anchor);
    loja.setItem(12, Stomper);
    loja.setItem(14, Endermage);
    loja.setItem(16, Camel);
    loja.setItem(28, Avatar);
    loja.setItem(30, ForceField);
    loja.setItem(32, Rain);
    loja.setItem(34, Snail);
    p.openInventory(loja);
    return false;
  }
  
  public void MoneyErro(Player p, String k, int m)
  {
    p.sendMessage("§c§lVocê não tem " + m + " §c§lDe Money Para comprar esse Kit");
    p.closeInventory();
  }
  
  public void Jatem(Player p)
  {
    p.sendMessage("§c§lVocê já possui esse Kit !");
    p.closeInventory();
  }
  
  public void Sucesso(Player p, String k)
  {
    p.sendMessage("§a§lParab§ns Você comprou o Kit §6" + k);
    Main.getInstance().loja.set(p.getName().toLowerCase() + "." + k, Boolean.valueOf(true));
    Main.getInstance().save2();
    p.closeInventory();
  }
}
