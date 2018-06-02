package Pedrao.Comandos;

import java.util.ArrayList;

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

import Pedrao.Main;
import Pedrao.Eventos.Habilidade;
import Pedrao.XP.XpM;

public class StatusM
  implements Listener, CommandExecutor
{
  public StatusM(Main main) {}

@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
public static void guiKits1(Player p)
  {
    Inventory inv = Bukkit.getServer().createInventory(p, 9, "§5Status");
    
    ItemStack vidro = new ItemStack(Material.AIR);
    ItemMeta metav = vidro.getItemMeta();
    vidro.setItemMeta(metav);
    
    ItemStack ant = new ItemStack(Material.getMaterial(171), 1, (short)8);
    ItemMeta antv = ant.getItemMeta();
    antv.setDisplayName("§cImpossivel voltar");
    ant.setItemMeta(antv);
    inv.setItem(0, ant);
    
    ItemStack prox = new ItemStack(Material.getMaterial(171), 1, (short)10);
    ItemMeta proxv = prox.getItemMeta();
    proxv.setDisplayName("§aProximo");
    prox.setItemMeta(proxv);
    inv.setItem(8, prox);
    
    ItemStack stats = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
    ItemMeta statsv = stats.getItemMeta();
    statsv.setDisplayName("§7" + p.getName());
    stats.setItemMeta(statsv);
    inv.setItem(2, stats);
    
    ItemStack camu = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
    ItemMeta camuv = camu.getItemMeta();
    camuv.setDisplayName(Main.prefix);
    camu.setItemMeta(camuv);
    
    ItemStack camu1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)0);
    ItemMeta camu1v = camu1.getItemMeta();
    camu1v.setDisplayName(Main.prefix);
    camu1.setItemMeta(camu1v);
    
    inv.setItem(1, camu);
    inv.setItem(2, camu1);
    inv.setItem(3, camu);
    inv.setItem(5, camu);
    inv.setItem(6, camu1);
    inv.setItem(7, camu);
    inv.setItem(8, camu);
    inv.setItem(0, camu);
    if (p.hasPermission("kit.pvp"))
    {
      ItemStack pyro = new ItemStack(Material.SKULL_ITEM,1,(short)3);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7§lStatus");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§lKills §7" + Main.plugin.getConfig().getInt(new StringBuilder("status.").append(p.getName().toLowerCase()).append(".kills").toString()));
      descpyro1.add("§a§lMortes §7" + Main.plugin.getConfig().getInt(new StringBuilder("status.").append(p.getName().toLowerCase()).append(".mortes").toString()));
      descpyro1.add("§a§lKit §7" + Habilidade.getAbility(p));
      descpyro1.add("§a§lXP §7" + XpM.getPlayerMoney(p));
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }   
    ItemStack[] arrayOfItemStack;
    int descpyro1 = (arrayOfItemStack = inv.getContents()).length;
    for (int metapyro1 = 0; metapyro1 < descpyro1; metapyro1++)
    {
      ItemStack item = arrayOfItemStack[metapyro1];
      if (item == null) {
        inv.setItem(inv.firstEmpty(), vidro);
      }
    }
    p.openInventory(inv);
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if ((commandLabel.equalsIgnoreCase("")))
    {
      Player p = (Player)sender;
      
      guiKits1(p);
    }
    return false;
  }
  
  @SuppressWarnings("deprecation")
@EventHandler
  public void onPlayerCLickInventry(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if ((e.getInventory().getTitle().equalsIgnoreCase("§5Status")) && 
      (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
    {
      e.setCancelled(true);
    }
  }
}
