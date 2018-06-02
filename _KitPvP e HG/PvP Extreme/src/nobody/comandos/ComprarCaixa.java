package nobody.comandos;

import java.util.ArrayList;
import java.util.List;

import nobody.eventos.Money;
import nobody.main.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ComprarCaixa
  implements Listener, CommandExecutor
{
  public static ItemStack vidro;
  public static ItemMeta vidrometa;
  public static ItemStack vidro1;
  public static ItemMeta vidro1meta;
  public static ItemStack Gold;
  public static ItemMeta Goldmeta;
  public static ItemStack Diamante;
  public static ItemMeta Diamantemeta;
  public static ItemStack Esmeralda;
  public static ItemMeta Esmeraldameta;
  
  public static List<String> Lore(String string)
  {
    String[] split = string.split(" ");
    string = "";
    ChatColor color = ChatColor.GOLD;
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	ArrayList<String> newString = new ArrayList();
    for (int i = 0; i < split.length; i++)
    {
      if ((string.length() > 20) || (string.endsWith(".")))
      {
        newString.add(color + string);
        if (string.endsWith(".")) {
          newString.add("");
        }
        string = "";
      }
      string = string + (string.length() == 0 ? "" : " ") + split[i];
    }
    newString.add(string);
    return newString;
  }
  
  @EventHandler
  public void Caixa(InventoryClickEvent e)
  {
    if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null))
    {
      Player p = (Player)e.getWhoClicked();
      Inventory inv = e.getInventory();
      if (inv.getTitle().equalsIgnoreCase(" §a§lLoja de Caixas "))
      {
        if (e.getCurrentItem().isSimilar(vidro)) {
          e.setCancelled(true);
        }
        if (e.getCurrentItem().isSimilar(Gold))
        {
          p.closeInventory();
          if (Main.getInstance().caixa.getString(p.getName().toLowerCase() + ".Gold").equals("false"))
          {
            if (Money.getMoney(p) >= 5000)
            {
              Money.removeMoney(p, 5000);
              p.sendMessage("§7[§6§lCAIXA§7]  §eVocê comprou sua Caixa §6§lGold§e, Boa Sorte");
              Bukkit.broadcastMessage("§b" + p.getName() + " §aComprou a caixa §0§lGold");
              p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 2.0F, 2.0F);
              p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
              p.closeInventory();
              Main.getInstance().caixa.set(p.getName().toLowerCase() + ".Gold", "true");
            }
            else if (Money.getMoney(p) < 5000)
            {
              p.sendMessage("§7[§6§lCAIXA§7]  §eVocê não tem 5000 money para comprar essa Caixa");
              p.closeInventory();
            }
          }
          else if (Main.getInstance().caixa.getString(p.getName().toLowerCase() + ".Gold").equals("true"))
          {
            p.sendMessage("§7[§6§lCAIXA§7]  §cVocê ja tem uma Caixa §e§lGold");
            p.closeInventory();
            return;
          }
          e.setCancelled(true);
        }
        if (e.getCurrentItem().isSimilar(Diamante))
        {
          p.closeInventory();
          if (Main.getInstance().caixa.getString(p.getName().toLowerCase() + ".Diamante").equals("false"))
          {
            if (Money.getMoney(p) >= 10000)
            {
              Money.removeMoney(p, 10000);
              p.sendMessage("§7[§6§lCAIXA§7]  §eVocê comprou sua Caixa §bDiamante§e, Boa Sorte");
              Bukkit.broadcastMessage("§b" + p.getName() + " §aComprou a caixa §f§lDiamante");
              p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 2.0F, 2.0F);
              p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
              p.closeInventory();
              Main.getInstance().caixa.set(p.getName().toLowerCase() + ".Diamante", "true");
            }
            else if (Money.getMoney(p) < 10000)
            {
              p.sendMessage("§7[§6§lCAIXA§7]  §eVocê não tem 10000 money para comprar essa Caixa");
              p.closeInventory();
            }
          }
          else if (Main.getInstance().caixa.getString(p.getName().toLowerCase() + ".Diamante").equals("true"))
          {
            p.sendMessage("§7[§6§lCAIXA§7]  §cVocê ja tem uma Caixa §eDiamante");
            p.closeInventory();
            return;
          }
          e.setCancelled(true);
        }
        if (e.getCurrentItem().isSimilar(Esmeralda))
        {
          p.closeInventory();
          if (Main.getInstance().caixa.getString(p.getName().toLowerCase() + ".Esmeralda").equals("false"))
          {
            if (Money.getMoney(p) >= 15000)
            {
              Money.removeMoney(p, 15000);
              p.sendMessage("§7[§6§lCAIXA§7]  §eVocê comprou sua Caixa §aEsmeralda§e, Boa Sorte");
              Bukkit.broadcastMessage("§b" + p.getName() + " §aComprou a caixa §e§lEsmeralda");
              p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 2.0F, 2.0F);
              p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
              p.closeInventory();
              Main.getInstance().caixa.set(p.getName().toLowerCase() + ".Esmeralda", "true");
            }
            else if (Money.getMoney(p) < 15000)
            {
              p.sendMessage("§7[§6§lCAIXA§7]  §eVocê não tem 15000 money para comprar essa Caixa");
              p.closeInventory();
            }
          }
          else if (Main.getInstance().caixa.getString(p.getName().toLowerCase() + ".Esmeralda").equals("true"))
          {
            p.sendMessage("§7[§6§lCAIXA§7]  §cVocê ja tem uma Caixa §aEsmeralda");
            p.closeInventory();
            return;
          }
          e.setCancelled(true);
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
    Inventory loja = Bukkit.createInventory(p, 27, " §a§lLoja de Caixas ");
    
    vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1,(short)3);
    vidrometa = vidro.getItemMeta();
    vidrometa.setDisplayName("§7-");
    vidro.setItemMeta(vidrometa);

    vidro1 = new ItemStack(Material.STAINED_GLASS_PANE, 1,(short)4);
    vidro1meta = vidro1.getItemMeta();
    vidro1meta.setDisplayName("§7-");
    vidro1.setItemMeta(vidro1meta);
    
    Gold = new ItemStack(Material.GOLD_BLOCK, 1);
    Goldmeta = Gold.getItemMeta();
    Goldmeta.setDisplayName("§eCaixa §e§lGOLD");
    Goldmeta.setLore(Lore("§f§lXP: §a5.000"));
    Gold.setItemMeta(Goldmeta);
    
    Diamante = new ItemStack(Material.DIAMOND_BLOCK, 1);
    Diamantemeta = Diamante.getItemMeta();
    Diamantemeta.setDisplayName("§eCaixa §b§lDIAMANTE");
    Diamantemeta.setLore(Lore("§f§lXP: §a10.000"));
    Diamante.setItemMeta(Diamantemeta);
    
    Esmeralda = new ItemStack(Material.EMERALD_BLOCK, 1);
    Esmeraldameta = Esmeralda.getItemMeta();
    Esmeraldameta.setDisplayName("§eCaixa §a§lESMERALDA");
    Esmeraldameta.setLore(Lore("§f§lXP: §a20.000"));
    Esmeralda.setItemMeta(Esmeraldameta);
    for (int i = 0; i != 27; i++) {
      loja.setItem(i, vidro);
    }
    loja.setItem(0, vidro1);
    loja.setItem(2, vidro1);
    loja.setItem(4, vidro1);
    loja.setItem(6, vidro1);
    loja.setItem(8, vidro1);
    loja.setItem(10, vidro1);
    loja.setItem(12, vidro1);
    loja.setItem(14, vidro1);
    loja.setItem(16, vidro1);
    loja.setItem(18, vidro1);
    loja.setItem(20, vidro1);
    loja.setItem(22, vidro1);
    loja.setItem(24, vidro1);
    loja.setItem(26, vidro1);
    loja.setItem(11, Gold);
    loja.setItem(13, Diamante);
    loja.setItem(15, Esmeralda);
    p.openInventory(loja);
    return false;
  }
}
