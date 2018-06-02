package Pedrao.Eventos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Pedrao.Main;

public class Placa
  implements Listener
{
  @SuppressWarnings("unused")
private Placa plugin;
  
  public Placa(Placa instance)
  {
    this.plugin = instance;
  }
  
  public Placa() {}
  
  public Placa(Main main) {
}

@EventHandler
  public void onSignChange(SignChangeEvent e)
  {
    if (e.getLine(0).equalsIgnoreCase("recraft"))
    {
      e.setLine(0, "§4=-=()=-=");
      e.setLine(1, "§2Gratis");
      e.setLine(2, "§bRecraft!");
      e.setLine(3, "§4=-=()=-=");
    }
  }
  
  @EventHandler
  public void inv(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    

    ItemStack sopas = new ItemStack(Material.BOWL, 64);
    ItemMeta ksopas = sopas.getItemMeta();
    ksopas.setDisplayName("§3--> §7Pote §3<--");
    sopas.setItemMeta(ksopas);
    
    ItemStack cogur = new ItemStack(Material.RED_MUSHROOM, 64);
    ItemMeta kcogur = cogur.getItemMeta();
    kcogur.setDisplayName("§3--> §cVermelho §3<--");
    cogur.setItemMeta(kcogur);
    
    ItemStack cogum = new ItemStack(Material.BROWN_MUSHROOM, 64);
    ItemMeta kcogum = cogum.getItemMeta();
    kcogum.setDisplayName("§3--> §8Marrom §3<--");
    cogum.setItemMeta(kcogum);
    
    Inventory inve = Bukkit.getServer().createInventory(p, 36, "§bRecraft");
    
    inve.setItem(0, sopas);
    inve.setItem(1, sopas);
    inve.setItem(2, sopas);
    inve.setItem(3, sopas);
    inve.setItem(4, sopas);
    inve.setItem(5, sopas);
    inve.setItem(6, sopas);
    inve.setItem(7, sopas);
    inve.setItem(8, sopas);
    inve.setItem(9, sopas);
    inve.setItem(10, sopas);
    inve.setItem(11, sopas);
    inve.setItem(12, sopas);
    inve.setItem(13, sopas);
    inve.setItem(14, sopas);
    inve.setItem(15, sopas);
    inve.setItem(16, sopas);
    inve.setItem(17, sopas);
    inve.setItem(27, cogur);
    inve.setItem(28, cogur);
    inve.setItem(29, cogur);
    inve.setItem(30, cogur);
    inve.setItem(31, cogur);
    inve.setItem(32, cogur);
    inve.setItem(33, cogur);
    inve.setItem(34, cogur);
    inve.setItem(35, cogur);
    inve.setItem(18, cogum);
    inve.setItem(19, cogum);
    inve.setItem(20, cogum);
    inve.setItem(21, cogum);
    inve.setItem(22, cogum);
    inve.setItem(23, cogum);
    inve.setItem(24, cogum);
    inve.setItem(25, cogum);
    inve.setItem(26, cogum);
    if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && (e.getClickedBlock() != null) && (
      (e.getClickedBlock().getType() == Material.WALL_SIGN) || (e.getClickedBlock().getType() == Material.SIGN_POST)))
    {
      Sign s = (Sign)e.getClickedBlock().getState();
      String[] lines = s.getLines();
      if ((lines.length > 0) && (lines[0].equals("§4=-=()=-=")) && 
        (lines.length > 1) && (lines[1].equals("§2Gratis")) && 
        (lines.length > 2) && (lines[2].equals("§bRecraft!")) && 
        (lines.length > 3) && (lines[3].equals("§4=-=()=-="))) {
        p.openInventory(inve);
      }
    }
  }
  
  @EventHandler
  public void onPlayerColor(SignChangeEvent e)
  {
    if (e.getLine(0).contains("&")) {
      e.setLine(0, e.getLine(0).replace("&", "§"));
    }
    if (e.getLine(1).contains("&")) {
      e.setLine(1, e.getLine(1).replace("&", "§"));
    }
    if (e.getLine(2).contains("&")) {
      e.setLine(2, e.getLine(2).replace("&", "§"));
    }
    if (e.getLine(3).contains("&")) {
      e.setLine(3, e.getLine(3).replace("&", "§"));
    }
  }
}
