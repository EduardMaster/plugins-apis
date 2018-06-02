package me.rafael.vinagre.KomboPvP.Comandos;

import java.util.Random;
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

import Scoreboard.ScoreDoBasic;
import XP.XpM;
import me.rafael.vinagre.KomboPvP.Main;

public class LojadeOutros
  implements Listener, CommandExecutor
{
  public static ItemStack vidro;
  public static ItemMeta vidrometa;
  public static ItemStack vidro2;
  public static ItemMeta vidro2meta;
  public static ItemStack resetkdr;
  public static ItemMeta resetkdrmeta;
  public static ItemStack todososkits;
  public static ItemMeta todososkitsmeta;
  public static ItemStack winner;
  public static ItemMeta winnermeta;
  public static ItemStack randomkit;
  public static ItemMeta randomkitmeta;
  
	public LojadeOutros(Main main) {
	}

  
  @EventHandler
  public void warps(InventoryClickEvent e)
  {
    if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null))
    {
      Inventory inv = e.getInventory();
      Player p = (Player)e.getWhoClicked();
      if (inv.getTitle().equals( " §eOutros"))
      {
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
        e.setCancelled(true);
        p.closeInventory();
      }
      if (e.getCurrentItem().isSimilar(todososkits)) {
        if (XpM.getPlayerMoney(p) < 200000)
        {
          p.sendMessage( "§7[§4X§7] Voce nao tem §c§lCoins §7suficiente!");
        }
        else
        {
        	XpM.getPlayerMoney(p);
          
          XpM.removeMoney(p, 200000);
          p.sendMessage( " Voce comprou §a§ltodos os Kits §c- 200.000 Coins!");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.*");
          Scoreboard.ScoreDoBasic.iscoriboard(p);
        }
      }
      if (e.getCurrentItem().isSimilar(winner)) {
          if (XpM.getPlayerMoney(p) < 15000)
          {
            p.sendMessage( "§7[§4X§7] Voce nao tem §c§lCoins §7suficiente!");
          }
          else
          {
          	XpM.getPlayerMoney(p);
            
            XpM.removeMoney(p, 15000);
            p.sendMessage( "Voce comprou §c§la tag §a§lWinner! §9§l- 15.000 de XP!");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add tag.winner");
            Scoreboard.ScoreDoBasic.iscoriboard(p);
          }
        }
      if (e.getCurrentItem().isSimilar(randomkit)) {
        if (XpM.getPlayerMoney(p) < 30000)
        {
          p.sendMessage( "§7[§4X§7] Voce nao tem §c§lCoins §7suficiente!");
        }
        else
        {
          XpM.removeMoney(p, 30000);
          Scoreboard.ScoreDoBasic.iscoriboard(p);
          random(p);
        }
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
    if (cmd.getName().equalsIgnoreCase("lojadeoutros"))
    {
      Inventory lojadeoutros = Bukkit.createInventory(p, 27,  " §eOutros");
      
      vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)13);
      vidrometa = vidro.getItemMeta();
      vidrometa.setDisplayName("Loja");
      vidro.setItemMeta(vidrometa);
      
      vidro2 = new ItemStack(Material.getMaterial(160), 1, (short)14);
      vidro2meta = vidro2.getItemMeta();
      vidro2meta.setDisplayName("Loja");
      vidro2.setItemMeta(vidro2meta);
      
      todososkits = new ItemStack(Material.STORAGE_MINECART);
      todososkitsmeta = todososkits.getItemMeta();
      todososkitsmeta.setDisplayName("§6Todos Os Kits - 200.000 XP");
      todososkits.setItemMeta(todososkitsmeta);
      
      winner = new ItemStack(Material.EMERALD_BLOCK);
      winnermeta = winner.getItemMeta();
      winnermeta.setDisplayName("§aTag Winner - 15.000 XP");
      winner.setItemMeta(winnermeta);
      
      randomkit = new ItemStack(Material.JUKEBOX);
      randomkitmeta = randomkit.getItemMeta();
      randomkitmeta.setDisplayName("§6Random Kit - 30.000 XP");
      randomkit.setItemMeta(randomkitmeta);
      for (int i = 0; i != 27; i++)
      {
        lojadeoutros.setItem(i, vidro);
        lojadeoutros.setItem(1, vidro2);
        lojadeoutros.setItem(3, vidro2);
        lojadeoutros.setItem(5, vidro2);
        lojadeoutros.setItem(7, vidro2);
        lojadeoutros.setItem(9, vidro2);
        lojadeoutros.setItem(11, todososkits);
        lojadeoutros.setItem(13, randomkit);
        lojadeoutros.setItem(15, winner);
        lojadeoutros.setItem(17, vidro2);
        lojadeoutros.setItem(19, vidro2);
        lojadeoutros.setItem(21, vidro2);
        lojadeoutros.setItem(23, vidro2);
        lojadeoutros.setItem(25, vidro2);
      }
      p.openInventory(lojadeoutros);
      return true;
    }
    return true;
  }
  
  public void random(Player p)
  {
    Random r = new Random();
    int o = r.nextInt(14);
    if (o == 0)
    {
      p.sendMessage( "§7[§2V§7] Voce ganhou o kit §6Ninja!");
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.ninja");
    }
    else if (o == 1)
    {
      p.sendMessage( "§7[§2V§7] Voce ganhou o kit §6Monk!");
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.Monk");
    }
    else if (o == 2)
    {
      p.sendMessage( "§7[§2V§7] Voce ganhou o kit §6Stomper!");
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.stomper");
    }
    else if (o == 3)
    {
      p.sendMessage( "§7[§2V§7] Voce ganhou o kit §6Viper!");
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.viper");
    }
    else if (o == 4)
    {
      p.sendMessage( "§7[§2V§7] Voce ganhou o kit §6Snail!");
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.snail");
    }
    else if (o == 5)
    {
      p.sendMessage( "§7[§2V§7] Voce ganhou o kit §6Turtle!");
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.turtle");
    }
    else if (o == 6)
    {
      p.sendMessage( "§7 Voce ganhou o kit §6Grappler!");
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.grappler");
    }
      else if (o == 7)
      {
        p.sendMessage( "§7 Voce ganhou o kit §6Gladiator!");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.gladiator");
      }
        else if (o == 8)
        {
          p.sendMessage( "§7 Voce ganhou o kit §6Infernor!");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.infernor");
        }
          else if (o == 9)
          {
            p.sendMessage( "§7 Voce ganhou o kit §6Flash! Veja ele na 2 pag de kit");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.flash");
          }
            else if (o == 10)
            {
              p.sendMessage( "§7 Voce ganhou o kit §6Naruto! Veja ele na segunda pag de kit");
              Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.naruto");}
              else if (o == 11)
              {
                p.sendMessage( "§7 Voce ganhou o kit §6Thresh! Veja ele na segunda pag de kit");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.thresh");
        if ((o == 7) || 
        
        (o == 8) || 
        (o == 9) || 
        (o == 10) || 
        (o == 11) || 
        (o == 12)) {}
    
          }  
}
}