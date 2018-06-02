package nobody.comandos;

import java.util.ArrayList;
import java.util.List;

import nobody.eventos.KitAPI;
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
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Caixas
  implements Listener, CommandExecutor
{
  public static ItemStack vidro;
  public static ItemMeta vidrometa;
  public static ItemStack vidro1;
  public static ItemMeta vidro1meta;
  public static ItemStack comprarcaixa;
  public static ItemMeta comprarcaixameta;
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
  public void Clicar(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if ((e.getMaterial() == Material.CHEST) && (e.getItem().getType() == Material.CHEST) && (KitAPI.getkit(p) == "Nenhum"))
    {
      p.playSound(p.getLocation(), Sound.CHEST_OPEN, 1.0F, 1.0F);
      p.chat("/caixa");
    }
  }
  
  @EventHandler
  public void Caixa(final InventoryClickEvent e)
  {
    if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null))
    {
      final Player p = (Player)e.getWhoClicked();
      Inventory inv = e.getInventory();
      if (inv.getTitle().equalsIgnoreCase("§6§l§k|| §e§l§nCaixas§f §6§l§k||"))
      {
        if (e.getCurrentItem().isSimilar(vidro)) {
          e.setCancelled(true);
        }
        if (e.getCurrentItem().isSimilar(comprarcaixa))
        {
          p.closeInventory();
          e.setCancelled(true);
          p.chat("/comprarcaixa");
          p.playSound(p.getLocation(), Sound.ANVIL_USE, 2.0F, 2.0F);
          p.updateInventory();
        }
        if (e.getCurrentItem().isSimilar(Gold))
        {
          p.closeInventory();
          if (Main.getInstance().caixa.getString(p.getName().toLowerCase() + ".Gold").equals("false"))
          {
            p.sendMessage("§c§lVocê não tem essa caixa");
            return;
          }
          if (Main.getInstance().caixa.getString(p.getName().toLowerCase() + ".Gold").equals("true"))
          {
            String kit = KitsAleatorios.Kit();
            Main.getInstance().caixa.set(p.getName().toLowerCase() + ".Gold", "false");
            p.sendMessage("§aParabéns Você ganhou o Kit §b" + kit + " §aNa Caixa");
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add kit." + kit);
            Bukkit.broadcastMessage("§6{§a§lCAIXA§6} §b" + p.getName() + " §aAbriu a Caixa §e§lGold §ae ganhou o Kit: §b" + kit);
            p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 2.0F, 2.0F);
            p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
            p.sendMessage("§2§lRelogue no servidor para ganhar seu Kit !");
            e.setCancelled(true);
            Main.getInstance().save();
          }
        }
        if (e.getCurrentItem().isSimilar(Diamante))
        {
          p.closeInventory();
          e.setCancelled(true);
          if (Main.getInstance().caixa.getString(p.getName().toLowerCase() + ".Diamante").equals("false"))
          {
            p.sendMessage("§cVocê não tem esta caixa");
            return;
          }
          if (Main.getInstance().caixa.getString(p.getName().toLowerCase() + ".Diamante").equals("true"))
          {
            final String kit1 = KitsAleatorios.Kit();
            p.sendMessage("§eParabéns Você ganhou o Kit §b" + kit1 + " §aNa Primeira Caixa");
            Main.getInstance().caixa.set(p.getName().toLowerCase() + ".Diamante", "false");
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add kit." + kit1);
            p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 2.0F, 2.0F);
            p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
            {
              public void run()
              {
                String kit2 = KitsAleatorios.Kit();
                p.sendMessage("§eParabéns Você ganhou o Kit §b" + kit2 + " §aNa Segunda Caixa");
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add kit." + kit2);
                Bukkit.broadcastMessage("§6{§a§lCAIXA§6} §b" + p.getName() + " §aAbriu a Caixa §b§lDiamante §ae ganhou os Kits: §b" + kit1 + " e " + kit2);
                p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 2.0F, 2.0F);
                p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
                p.sendMessage("§7§lRelogue no servidor para ganhar seu Kit !");
                Main.getInstance().save();
              }
            }, 60L);
          }
        }
        if (e.getCurrentItem().isSimilar(Esmeralda))
        {
          p.closeInventory();
          e.setCancelled(true);
          if (Main.getInstance().caixa.getString(p.getName().toLowerCase() + ".Esmeralda").equals("false"))
          {
            p.sendMessage("§c§lVocê não tem essa caixa");
            return;
          }
          if (Main.getInstance().caixa.getString(p.getName().toLowerCase() + ".Esmeralda").equals("true"))
          {
            final String kit1 = KitsAleatorios.Kit();
            final String kit2 = KitsAleatorios.Kit();
            p.sendMessage("§eParabéns Você ganhou o Kit §b" + kit1 + " §eNa Primeira Caixa");
            Main.getInstance().caixa.set(p.getName().toLowerCase() + ".Esmeralda", "false");
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add kit." + kit1);
            p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 2.0F, 2.0F);
            p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
            {
              public void run()
              {
                p.sendMessage("§eParabéns Você ganhou o Kit §b" + kit2 + " §eNa Segunda Caixa");
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add kit." + kit2);
                p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 2.0F, 2.0F);
                p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
                e.setCancelled(true);
                Main.getInstance().save();
              }
            }, 60L);
            
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
            {
              public void run()
              {
                String kit3 = KitsAleatorios.Kit();
                p.sendMessage("§eParabéns Você ganhou o Kit §b" + kit3 + " §eNa Terceira Caixa");
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add kit." + kit3);
                Bukkit.broadcastMessage("§6{§a§lCAIXA§6} §b" + p.getName() + " §aAbriu a Caixa §a§lEsmeralda §ae ganhou os Kits: §b" + kit1 + ", " + kit2 + " e " + kit3);
                p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 2.0F, 2.0F);
                p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
                p.sendMessage("§6{§a§lCAIXA§6} §2§lRelogue no servidor para ganhar seu Kit !");
                e.setCancelled(true);
                Main.getInstance().save();
              }
            }, 120L);
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
    Inventory loja = Bukkit.createInventory(p, 27, "§6§l§k|| §e§l§nCaixas§f §6§l§k||");
    
    vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1,(short)4);
    vidrometa = vidro.getItemMeta();
    vidrometa.setDisplayName("§7-");
    vidro.setItemMeta(vidrometa);
    
    vidro1 = new ItemStack(Material.STAINED_GLASS_PANE, 1,(short)3);
    vidro1meta = vidro1.getItemMeta();
    vidro1meta.setDisplayName("§7-");
    vidro1.setItemMeta(vidro1meta);
    
    comprarcaixa = new ItemStack(Material.CHEST);
    comprarcaixameta = comprarcaixa.getItemMeta();
    comprarcaixameta.setDisplayName("§e§lCOMPRAR CAIXAS");
    comprarcaixa.setItemMeta(comprarcaixameta);
    
    Gold = new ItemStack(Material.GOLD_BLOCK, 1);
    Goldmeta = Gold.getItemMeta();
    Goldmeta.setDisplayName("§eCaixa §e§lGOLD");
    Goldmeta.setLore(Lore("§fGanhe Um Kit Aleatório!"));
    Goldmeta.setLore(Lore("§f"));
    if (Main.getInstance().caixa.getString(p.getName().toLowerCase() + ".Gold").equals("true")) {
      Goldmeta.setLore(Lore("§aVocê tem esta caixa"));
    } else if (Main.getInstance().caixa.getString(p.getName().toLowerCase() + ".Gold").equals("false")) {
      Goldmeta.setLore(Lore("§cVocê não tem esta caixa"));
    }
    Gold.setItemMeta(Goldmeta);
    
    Diamante = new ItemStack(Material.DIAMOND_BLOCK, 1);
    Diamantemeta = Diamante.getItemMeta();
    Diamantemeta.setDisplayName("§eCaixa §b§lDIAMANTE");
    Diamantemeta.setLore(Lore("§fGanhe Dois Kits Aleatórios"));
    Diamantemeta.setLore(Lore("§f"));
    if (Main.getInstance().caixa.getString(p.getName().toLowerCase() + ".Diamante").equals("true")) {
      Diamantemeta.setLore(Lore("§aVocê tem esta caixa"));
    } else if (Main.getInstance().caixa.getString(p.getName().toLowerCase() + ".Diamante").equals("false")) {
      Diamantemeta.setLore(Lore("§cVocê não tem esta caixa"));
    }
    Diamante.setItemMeta(Diamantemeta);
    
    Esmeralda = new ItemStack(Material.EMERALD_BLOCK, 1);
    Esmeraldameta = Esmeralda.getItemMeta();
    Esmeraldameta.setDisplayName("§eCaixa §a§lESMERALDA");
    Esmeraldameta.setLore(Lore("§fGanhe Três Kits Aleatórios!"));
    Esmeraldameta.setLore(Lore("§f"));
    if (Main.getInstance().caixa.getString(p.getName().toLowerCase() + ".Esmeralda").equals("true")) {
      Esmeraldameta.setLore(Lore("§aVocê tem esta caixa"));
    } else if (Main.getInstance().caixa.getString(p.getName().toLowerCase() + ".Esmeralda").equals("false")) {
      Esmeraldameta.setLore(Lore("§cVocê não tem esta caixa"));
    }
    Esmeralda.setItemMeta(Esmeraldameta);
    for (int i = 0; i != 27; i++) {
      loja.setItem(i, vidro);
    }
    loja.setItem(0, vidro1);
    loja.setItem(2, vidro1);
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
    loja.setItem(4, comprarcaixa);
    loja.setItem(11, Gold);
    loja.setItem(13, Diamante);
    loja.setItem(15, Esmeralda);
    p.openInventory(loja);
    return false;
  }
}
