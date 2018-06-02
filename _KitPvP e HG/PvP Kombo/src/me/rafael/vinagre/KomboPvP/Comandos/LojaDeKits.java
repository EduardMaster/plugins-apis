package me.rafael.vinagre.KomboPvP.Comandos;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Scoreboard.ScoreDoBasic;
import XP.XpM;
import me.rafael.vinagre.KomboPvP.Main;

public class LojaDeKits
  implements Listener, CommandExecutor
{
  public static ItemStack vidro;
  public static ItemMeta vidrometa;
  public static ItemStack vidro2;
  public static ItemMeta vidro2meta;
  public static ItemStack ninja;
  public static ItemMeta ninjameta;
  public static ItemStack viking;
  public static ItemMeta vikingmeta;
  public static ItemStack f;
  public static ItemMeta fmeta;
  public static ItemStack d;
  public static ItemMeta dmeta;
  public static ItemStack c;
  public static ItemMeta cmeta;
  public static ItemStack fi;
  public static ItemMeta fimeta;
  public static ItemStack n;
  public static ItemMeta nmeta;
  public static ItemStack t;
  public static ItemMeta tmeta;
  public static ItemStack jp;
  public static ItemMeta jpmeta;
  public static ItemStack sub;
  public static ItemMeta submeta;
  public static ItemStack stomper;
  public static ItemMeta stompermeta;
  public static ItemStack gaara;
  public static ItemMeta gaarameta;
  public static ItemStack anchorv;
  public static ItemMeta anchorvmeta;
  public static ItemStack viper;
  public static ItemMeta vipermeta;
  public static ItemStack snail;
  public static ItemMeta snailmeta;
  public static ItemStack barbarian;
  public static ItemMeta barbarianmeta;
  public static ItemStack fisherman;
  public static ItemMeta fishermanmeta;
  public static ItemStack thor;
  public static ItemMeta thormeta;
  public static ItemStack glad;
  public static ItemMeta gladmeta;
  public static ItemStack xp;
  public static ItemMeta xpmeta;
private ItemStack fujao;
private ItemStack grappler;
private ItemStack anchor;
private CommandSender p;
  
	public LojaDeKits(me.rafael.vinagre.KomboPvP.Main main) {
	}

  
  @EventHandler
  public void warps(InventoryClickEvent e)
  {
    if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null))
    {
      Inventory inv = e.getInventory();
      Player p = (Player)e.getWhoClicked();
      if (inv.getTitle().equals( " §eKits"))
      {
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
        e.setCancelled(true);
        p.closeInventory();
      }
      if (e.getCurrentItem().isSimilar(ninja)) {
        if (XpM.getPlayerMoney(p) >= 7500)
        {
          XpM.removeMoney(p, 7500);
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.ninja");
          p.sendMessage("§7[§2V§7] Voce comprou o kit §a§lNinja, §c- 7.500 Coins");
          Scoreboard.ScoreDoBasic.iscoriboard(p);
          e.setCancelled(true);
          p.closeInventory();
        }
        else if (XpM.getPlayerMoney(p) < 7500)
        {
          p.sendMessage("§7[§4X§7] Voce nao tem §c§lXP §7suficiente para comprar este kit!");
          e.setCancelled(true);
          p.closeInventory();
        }
      }
      if (e.getCurrentItem().isSimilar(sub)) {
          if (XpM.getPlayerMoney(p) >= 10000)
          {
            XpM.removeMoney(p, 10000);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.subzero");
            p.sendMessage("§7[§2V§7] Voce comprou o kit §a§lSubZero, §c- 10000 Coins");
            Scoreboard.ScoreDoBasic.iscoriboard(p);
            e.setCancelled(true);
            p.closeInventory();
          }
          else if (XpM.getPlayerMoney(p) < 10000)
          {
            p.sendMessage("§7[§4X§7] Voce nao tem §c§lXP §7suficiente para comprar este kit!");
            e.setCancelled(true);
            p.closeInventory();
          }
        }
      if (e.getCurrentItem().isSimilar(fi)) {
          if (XpM.getPlayerMoney(p) >= 8000)
          {
            XpM.removeMoney(p, 8000);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.fireman");
            p.sendMessage("§7[§2V§7] Voce comprou o kit §a§lFireman, §c- 8000 Coins");
            Scoreboard.ScoreDoBasic.iscoriboard(p);
            e.setCancelled(true);
            p.closeInventory();
          }
          else if (XpM.getPlayerMoney(p) < 8000)
          {
            p.sendMessage("§7[§4X§7] Voce nao tem §c§lXP §7suficiente para comprar este kit!");
            e.setCancelled(true);
            p.closeInventory();
          }
        }
      if (e.getCurrentItem().isSimilar(d)) {
          if (XpM.getPlayerMoney(p) >= 10000)
          {
            XpM.removeMoney(p, 10000);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.doublejump");
            p.sendMessage("§7[§2V§7] Voce comprou o kit §a§lDoublejump, §c- 10.000 Coins");
            p.sendMessage("§6Veja o kit na ultima pagina de kit");
            Scoreboard.ScoreDoBasic.iscoriboard(p);
            e.setCancelled(true);
            p.closeInventory();
          }
          else if (XpM.getPlayerMoney(p) < 10000)
          {
            p.sendMessage("§7[§4X§7] Voce nao tem §c§lXP §7suficiente para comprar este kit!");
            e.setCancelled(true);
            p.closeInventory();
          }
        }
      if (e.getCurrentItem().isSimilar(c)) {
          if (XpM.getPlayerMoney(p) >= 8000)
          {
            XpM.removeMoney(p, 8000);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.confuser");
            p.sendMessage("§7[§2V§7] Voce comprou o kit §a§lConfuser, §c- 8000 Coins");
            Scoreboard.ScoreDoBasic.iscoriboard(p);
            e.setCancelled(true);
            p.closeInventory();
          }
          else if (XpM.getPlayerMoney(p) < 8000)
          {
            p.sendMessage("§7[§4X§7] Voce nao tem §c§lXP §7suficiente para comprar este kit!");
            e.setCancelled(true);
            p.closeInventory();
          }
        }
	if (e.getCurrentItem().isSimilar(viking)) {
        if (XpM.getPlayerMoney(p) >= 7500)
        {
          XpM.removeMoney(p, 7500);
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.fujao");
          p.sendMessage("§7[§2V§7] Voce comprou o kit §a§lFujao, §c- 7.500 Coins");
          Scoreboard.ScoreDoBasic.iscoriboard(p);
          e.setCancelled(true);
          p.closeInventory();
        }
        else if (XpM.getPlayerMoney(p) < 7500)
        {
          p.sendMessage("§7[§4X§7] Voce nao tem §c§lXP §7suficiente para comprar este kit!");
          e.setCancelled(true);
          p.closeInventory();
        }
      }
	if (e.getCurrentItem().isSimilar(t)) {
        if (XpM.getPlayerMoney(p) >= 8500)
        {
          XpM.removeMoney(p, 8500);
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.timelord");
          p.sendMessage("§7[§2V§7] Voce comprou o kit §a§lTimelord, §c- 8500 Coins");
          Scoreboard.ScoreDoBasic.iscoriboard(p);
          e.setCancelled(true);
          p.closeInventory();
        }
        else if (XpM.getPlayerMoney(p) < 8500)
        {
          p.sendMessage("§7[§4X§7] Voce nao tem §c§lXP §7suficiente para comprar este kit!");
          e.setCancelled(true);
          p.closeInventory();
        }
      }
	if (e.getCurrentItem().isSimilar(n)) {
        if (XpM.getPlayerMoney(p) >= 12000)
        {
          XpM.removeMoney(p, 12000);
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.naruto");
          p.sendMessage("§7[§2V§7] Voce comprou o kit §a§lNaruto, §c- 12000 Coins");
          Scoreboard.ScoreDoBasic.iscoriboard(p);
          e.setCancelled(true);
          p.closeInventory();
        }
        else if (XpM.getPlayerMoney(p) < 12000)
        {
          p.sendMessage("§7[§4X§7] Voce nao tem §c§lXP §7suficiente para comprar este kit!");
          e.setCancelled(true);
          p.closeInventory();
        }
      }
	if (e.getCurrentItem().isSimilar(jp)) {
        if (XpM.getPlayerMoney(p) >= 8000)
        {
          XpM.removeMoney(p, 8000);
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.jumper");
          p.sendMessage("§7[§2V§7] Voce comprou o kit §a§lFujao, §c- 8000 Coins");
          Scoreboard.ScoreDoBasic.iscoriboard(p);
          e.setCancelled(true);
          p.closeInventory();
        }
        else if (XpM.getPlayerMoney(p) < 8000)
        {
          p.sendMessage("§7[§4X§7] Voce nao tem §c§lXP §7suficiente para comprar este kit!");
          e.setCancelled(true);
          p.closeInventory();
        }
      }
	if (e.getCurrentItem().isSimilar(barbarian)) {
        if (XpM.getPlayerMoney(p) >= 15000)
        {
          XpM.removeMoney(p, 15000);
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.barbarian");
          p.sendMessage("§7[§2V§7] Voce comprou o kit §a§lBarbarian, §c- 15000 Coins");
          Scoreboard.ScoreDoBasic.iscoriboard(p);
          e.setCancelled(true);
          p.closeInventory();
        }
        else if (XpM.getPlayerMoney(p) < 15000)
        {
          p.sendMessage("§7[§4X§7] Voce nao tem §c§lXP §7suficiente para comprar este kit!");
          e.setCancelled(true);
          p.closeInventory();
        }
      }
	if (e.getCurrentItem().isSimilar(glad)) {
        if (XpM.getPlayerMoney(p) >= 15000)
        {
          XpM.removeMoney(p, 15000);
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.gladiator");
          p.sendMessage("§7[§2V§7] Voce comprou o kit §a§lGladiator, §c- 15000 Coins");
          Scoreboard.ScoreDoBasic.iscoriboard(p);
          e.setCancelled(true);
          p.closeInventory();
        }
        else if (XpM.getPlayerMoney(p) < 15000)
        {
          p.sendMessage("§7[§4X§7] Voce nao tem §c§lXP §7suficiente para comprar este kit!");
          e.setCancelled(true);
          p.closeInventory();
        }
      }
      if (e.getCurrentItem().isSimilar(stomper)) {
        if (XpM.getPlayerMoney(p) >= 14000)
        {
          XpM.removeMoney(p, 14000);
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.grappler");
          p.sendMessage("§7[§2V§7] Voce comprou o kit §a§lGrappler, §c- 14.000 XP");
          e.setCancelled(true);
          p.closeInventory();
          Scoreboard.ScoreDoBasic.iscoriboard(p);
        }
        else if (XpM.getPlayerMoney(p) < 14000)
        {
          p.sendMessage("§7[§4X§7] Voce nao tem §c§lXP §7suficiente para comprar este kit!");
          e.setCancelled(true);
          p.closeInventory();
        }
      }
      if (e.getCurrentItem().isSimilar(anchorv)) {
          if (XpM.getPlayerMoney(p) >= 8000)
          {
            XpM.removeMoney(p, 8000);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.anchor");
            p.sendMessage("§7[§2V§7] Voce comprou o kit §a§lAnchor, §c- 8.000 XP");
            e.setCancelled(true);
            p.closeInventory();
            Scoreboard.ScoreDoBasic.iscoriboard(p);
          }
          else if (XpM.getPlayerMoney(p) < 8000)
          {
            p.sendMessage("§7[§4X§7] Voce nao tem §c§lXP §7suficiente para comprar este kit!");
            e.setCancelled(true);
            p.closeInventory();
          }
        }
      if (e.getCurrentItem().isSimilar(viper)) {
        if (XpM.getPlayerMoney(p) >= 5000)
        {
          XpM.removeMoney(p, 5000);
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.viper");
          p.sendMessage("§7[§2V§7] Voce comprou o kit §a§lViper, §c- 5.000 XP");
          e.setCancelled(true);
          p.closeInventory();
          Scoreboard.ScoreDoBasic.iscoriboard(p);
        }
        else if (XpM.getPlayerMoney(p) < 5000)
        {
          p.sendMessage("§7[§4X§7] Voce nao tem §c§lXP §7suficiente para comprar este kit!");
          e.setCancelled(true);
          p.closeInventory();
        }
      }
      if (e.getCurrentItem().isSimilar(snail)) {
        if (XpM.getPlayerMoney(p) >= 5000)
        {
          XpM.removeMoney(p, 5000);
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.snail");
          p.sendMessage("§7[§2V§7] Voce comprou o kit §a§lSnail, §c- 5.000 XP");
          e.setCancelled(true);
          p.closeInventory();
          Scoreboard.ScoreDoBasic.iscoriboard(p);
        }
        else if (XpM.getPlayerMoney(p) < 5000)
        {
          p.sendMessage("§7[§4X§7] Voce nao tem §c§lXP §7suficiente para comprar este kit!");
          e.setCancelled(true);
          p.closeInventory();
        }
      }
      if (e.getCurrentItem().isSimilar(gaara)) {
          if (XpM.getPlayerMoney(p) >= 15000)
          {
            XpM.removeMoney(p, 15000);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.gaara");
            p.sendMessage("§7[§2V§7] Voce comprou o kit §a§lGaara, §c- 15.000 XP veja o kit na pag 2");
            e.setCancelled(true);
            p.closeInventory();
            Scoreboard.ScoreDoBasic.iscoriboard(p);
          }
          else if (XpM.getPlayerMoney(p) < 15000)
          {
            p.sendMessage("§7[§4X§7] Voce nao tem §c§lXP §7suficiente para comprar este kit!");
            e.setCancelled(true);
            p.closeInventory();
          }
        }
      if (e.getCurrentItem().isSimilar(f)) {
          if (XpM.getPlayerMoney(p) >= 6000)
          {
            XpM.removeMoney(p, 6000);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.cyclope");
            p.sendMessage("§7[§2V§7] Voce comprou o kit §a§lCyclope, §c- 6.000 XP");
            e.setCancelled(true);
            p.closeInventory();
            Scoreboard.ScoreDoBasic.iscoriboard(p);
          }
          else if (XpM.getPlayerMoney(p) < 6000)
          {
            p.sendMessage("§7[§4X§7] Voce nao tem §c§lXP §7suficiente para comprar este kit!");
            e.setCancelled(true);
            p.closeInventory();
          }
        }
      if (e.getCurrentItem().isSimilar(fisherman)) {
        if (XpM.getPlayerMoney(p) >= 7000)
        {
          XpM.removeMoney(p, 8000);
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.fisherman");
          p.sendMessage("§7[§2V§7] Voce comprou o kit §a§lFisherman, §c- 8.000 XP");
          e.setCancelled(true);
          p.closeInventory();
          Scoreboard.ScoreDoBasic.iscoriboard(p);
        }
        else if (XpM.getPlayerMoney(p) < 8000)
        {
          p.sendMessage("§7[§4X§7] Voce nao tem §c§lXP §7suficiente para comprar este kit!");
          e.setCancelled(true);
          p.closeInventory();
        }
      }
    }
   
    
  


  
  
  }
  
  @SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player)) {
      return true;
    }
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("lojadekits"))
    {
      Inventory warps = Bukkit.createInventory(p, 54,  " §eKits");
      
      vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)13);
      vidrometa = vidro.getItemMeta();
      vidrometa = vidro.getItemMeta();
      vidro.setItemMeta(vidrometa);
      
      vidro2 = new ItemStack(Material.getMaterial(160), 1, (short)14);
      vidro2meta = vidro2.getItemMeta();
      vidro2meta.setDisplayName("Loja");
      vidro2.setItemMeta(vidro2meta);
      
      anchorv = new ItemStack(Material.ANVIL);
      anchorvmeta = anchorv.getItemMeta();
      anchorvmeta.setDisplayName("§aAnchor §6Preço: §7XP 8000");
      anchorv.setItemMeta(anchorvmeta);
      
      fi = new ItemStack(Material.FIRE);
      fimeta = fi.getItemMeta();
      fimeta.setDisplayName("§aFireman §6Preço: §7XP 8000");
      fi.setItemMeta(fimeta);
      
      d = new ItemStack(Material.GOLD_BOOTS);
      dmeta = d.getItemMeta();
      dmeta.setDisplayName("§aDoubleJump §6Preço: §7XP 10000");
      d.setItemMeta(dmeta);
      
      c = new ItemStack(Material.POTION);
      cmeta = c.getItemMeta();
      cmeta.setDisplayName("§aConfuser §6Preço: §7XP 8000");
      c.setItemMeta(cmeta);
      
      t = new ItemStack(Material.WATCH);
      tmeta = t.getItemMeta();
      tmeta.setDisplayName("§aTimelord §6Preço: §7XP 8500");
      t.setItemMeta(tmeta);
      
      sub = new ItemStack(Material.PACKED_ICE);
      submeta = sub.getItemMeta();
      submeta.setDisplayName("§aSubZero §6Preço: §7XP 10000");
      sub.setItemMeta(submeta);
      
      n = new ItemStack(Material.NETHER_STAR);
      nmeta = n.getItemMeta();
      nmeta.setDisplayName("§aNaruto §6Preço: §7XP 12000");
      n.setItemMeta(nmeta);
      
      glad = new ItemStack(Material.IRON_FENCE);
      gladmeta = glad.getItemMeta();
      gladmeta.setDisplayName("§aGladiator §6Preço: §7XP 15000");
      glad.setItemMeta(gladmeta);
      
      ninja = new ItemStack(Material.COAL_BLOCK);
      ninjameta = ninja.getItemMeta();
      ninjameta.setDisplayName("§aNinja §6Preço: §7XP 7500");
      ninja.setItemMeta(ninjameta);
      
      barbarian = new ItemStack(Material.WOOD_SWORD);
      barbarianmeta = barbarian.getItemMeta();
      barbarianmeta.setDisplayName("§aBarbarian §6Preço: §7XP 15000");
      barbarian.setItemMeta(barbarianmeta);
      
      gaara = new ItemStack(Material.SANDSTONE);
      gaarameta = gaara.getItemMeta();
      gaarameta.setDisplayName("§aGaara §6Preço: §7XP 15000");
      gaara.setItemMeta(gaarameta);
      
      viking = new ItemStack(Material.REDSTONE_TORCH_ON);
      vikingmeta = viking.getItemMeta();
      vikingmeta.setDisplayName("§aFujao §6Preço: §7XP 7500");
      viking.setItemMeta(vikingmeta);
      
      stomper = new ItemStack(Material.LEASH);
      stompermeta = stomper.getItemMeta();
      stompermeta.setDisplayName("§aGrappler §6Preço: §7XP 14000");
      stomper.setItemMeta(stompermeta);
      
      f = new ItemStack(Material.REDSTONE_BLOCK);
      fmeta = f.getItemMeta();
      fmeta.setDisplayName("§aCyclope §6Preço: §7XP 7000");
      f.setItemMeta(fmeta);
      
      viper = new ItemStack(Material.SPIDER_EYE);
      vipermeta = viper.getItemMeta();
      vipermeta.setDisplayName("§aViper §6Preço: §7XP 5000");
      viper.setItemMeta(vipermeta);
      
      snail = new ItemStack(Material.WEB);
      snailmeta = snail.getItemMeta();
      snailmeta.setDisplayName("§aSnail §6Preço: §7XP 5000");
      snail.setItemMeta(snailmeta);
      
      fisherman = new ItemStack(Material.FISHING_ROD);
      fishermanmeta = fisherman.getItemMeta();
      fishermanmeta.setDisplayName("§aFisherman §6Preço: §7XP 7000");
      fisherman.setItemMeta(fishermanmeta);
      
      jp = new ItemStack(Material.EYE_OF_ENDER);
      jpmeta = jp.getItemMeta();
      jpmeta.setDisplayName("§aJumper §6Preço: §7XP 8000");
      jp.setItemMeta(jpmeta);
      
      thor = new ItemStack(Material.PUMPKIN_SEEDS);
      thormeta = thor.getItemMeta();
      thormeta.setDisplayName("§aIndio §6Preço: §7XP 1400");
      thor.setItemMeta(thormeta);
      
      xp = new ItemStack(Material.EXP_BOTTLE);
      xpmeta = xp.getItemMeta();
      xpmeta.setDisplayName("§aCoins:");
      List<String> lore = new ArrayList();
      lore.add("§7Voce Possui §c§l" + XpM.getPlayerMoney(p) + " §7De Coins");
      xpmeta.setLore(lore);
      xp.setItemMeta(xpmeta);
      for (int i = 0; i != 54; i++)
      {
        warps.setItem(i, vidro);
        warps.setItem(0, vidro2);
        warps.setItem(2, vidro2);
        warps.setItem(4, xp);
        warps.setItem(6, vidro2);
        warps.setItem(8, vidro2);
        warps.setItem(9, anchorv);
        warps.setItem(10, ninja);
        warps.setItem(11, viking);
        warps.setItem(12, stomper);
        warps.setItem(13, viper);
        warps.setItem(14, snail);
        warps.setItem(15, fisherman);
        warps.setItem(16, thor);
        warps.setItem(17, f);
        warps.setItem(18, c);
        warps.setItem(19, t);
        warps.setItem(20, jp);
        warps.setItem(21, glad);
        warps.setItem(22, gaara);
        warps.setItem(23, barbarian);
        warps.setItem(24, sub);
        warps.setItem(25, n);
        warps.setItem(26, fi);
        warps.setItem(28, vidro2);
        warps.setItem(30, vidro2);
        warps.setItem(31, d);
        warps.setItem(32, vidro2);
        warps.setItem(34, vidro2);
        warps.setItem(36, vidro2);
        warps.setItem(38, vidro2);
        warps.setItem(40, vidro2);
        warps.setItem(42, vidro2);
        warps.setItem(44, vidro2);
        warps.setItem(46, vidro2);
        warps.setItem(48, vidro2);
        warps.setItem(49, xp);
        warps.setItem(50, vidro2);
        warps.setItem(52, vidro2);
      }
      p.openInventory(warps);
      return true;
    }
    return true;
  }
}


