package me.rafael.vinagre.KomboPvP.Comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Caixas.Caixa;
import me.rafael.vinagre.KomboPvP.Main;;

public class Extra
  implements Listener, CommandExecutor
{
  public static ItemStack vidro;
  public static ItemMeta vidrometa;
  public static ItemStack vidro2;
  public static ItemMeta vidro2meta;
  public static ItemStack lojadekits;
  public static ItemMeta lojadekitsmeta;
  public static ItemStack outrascoisas;
  public static ItemMeta outrascoisasmeta;
  public static ItemStack lojadoservidor;
  public static ItemMeta lojadoservidormeta;
  
  public static ArrayList<String> setandokit = new ArrayList<>();
  
	public Extra() {
	}

  @EventHandler
  public void Clicou(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
      (p.getItemInHand().getType() == Material.PISTON_BASE) && 
      (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("Extra §7- [§cClique§7]")))
    {
      p.chat("/extra");
      p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
    }
  }
  
  @EventHandler
  public void warps(InventoryClickEvent e)
  {
    if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null))
    {
      Inventory inv = e.getInventory();
      Player p = (Player)e.getWhoClicked();
      if (inv.getTitle().equals(" §eExtra "))
      {
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);
        e.setCancelled(true);
        p.closeInventory();
      }
      if (e.getCurrentItem().isSimilar(lojadekits))
      {
        p.closeInventory();
        p.chat("/caixas");
      }
      if (e.getCurrentItem().isSimilar(lojadoservidor))
      {
        p.closeInventory();
        Hats.Inv(p);
      }
      
      if (e.getCurrentItem().isSimilar(outrascoisas))
      {
        p.closeInventory();
        p.chat("/efeitos");
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
    if (cmd.getName().equalsIgnoreCase("Extra"))
    {
      Inventory Extra = Bukkit.createInventory(p, 27, " §eExtra ");
      
      vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)13);
      vidrometa = vidro.getItemMeta();
      vidrometa.setDisplayName("outros");
      vidro.setItemMeta(vidrometa);
      
      vidro2 = new ItemStack(Material.getMaterial(160), 1, (short)14);
      vidro2meta = vidro2.getItemMeta();
      vidro2meta.setDisplayName("outros");
      vidro2.setItemMeta(vidro2meta);
      
      lojadekits = new ItemStack(Material.STORAGE_MINECART);
      lojadekitsmeta = lojadekits.getItemMeta();
      lojadekitsmeta.setDisplayName("§5Caixas");
      lojadekits.setItemMeta(lojadekitsmeta);
      
      outrascoisas = new ItemStack(Material.POTION);
      outrascoisasmeta = outrascoisas.getItemMeta();
      outrascoisasmeta.setDisplayName("§bEfeitos");
      outrascoisas.setItemMeta(outrascoisasmeta);
      
      lojadoservidor = new ItemStack(Material.JUKEBOX);
      lojadoservidormeta = lojadoservidor.getItemMeta();
      lojadoservidormeta.setDisplayName("§aCabeças");
      lojadoservidor.setItemMeta(lojadoservidormeta);
      for (int i = 0; i != 27; i++)
      {
    	Extra.setItem(i, vidro);
    	Extra.setItem(1, vidro2);
    	Extra.setItem(3, vidro2);
    	Extra.setItem(5, vidro2);
    	Extra.setItem(7, vidro2);
    	Extra.setItem(9, vidro2);
    	Extra.setItem(13, outrascoisas);
    	Extra.setItem(15, lojadekits);
    	Extra.setItem(11, lojadoservidor);
    	Extra.setItem(17, vidro2);
    	Extra.setItem(19, vidro2);
    	Extra.setItem(21, vidro2);
    	Extra.setItem(23, vidro2);
    	Extra.setItem(25, vidro2);
      }
      p.openInventory(Extra);
      return true;
    }
    return true;
  }
}
