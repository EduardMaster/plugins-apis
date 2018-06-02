package nobody.comandos;

import java.util.ArrayList;
import java.util.HashMap;

import nobody.main.Main;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;


public class Admin
  implements Listener, CommandExecutor
{
  @SuppressWarnings({ "unchecked", "rawtypes" })
public static ArrayList<String> Admin = new ArrayList();
  @SuppressWarnings({ "unchecked", "rawtypes" })
public static HashMap<String, ItemStack[]> SalvarInv = new HashMap();
  
  @EventHandler
  public void VaiAbrirOInvDoPlayer(PlayerInteractEntityEvent Event)
  {
    if (!(Event.getRightClicked() instanceof Player)) {
      return;
    }
    Player P1 = Event.getPlayer();
    Player r = (Player)Event.getRightClicked();
    if ((Admin.contains(P1.getName())) && (P1.getItemInHand().getType() == Material.AIR)) {
      P1.openInventory(r.getInventory());
    }
  }
  
  @EventHandler
  public void ColocarUmJogadroNaArena(PlayerInteractEntityEvent Event)
  {
    Player P = Event.getPlayer();
    if ((Admin.contains(P.getName())) && (P.getItemInHand().getType() == Material.IRON_FENCE))
    {
      Player P1 = (Player)Event.getRightClicked();
      if (P1 != null)
      {
          P1.getLocation().add(0.0D, 13.0D, 0.0D).getBlock().setType(Material.BEDROCK);
          P1.getLocation().add(0.0D, 11.0D, 1.0D).getBlock().setType(Material.BEDROCK);
          P1.getLocation().add(1.0D, 11.0D, 0.0D).getBlock().setType(Material.BEDROCK);
          P1.getLocation().add(0.0D, 11.0D, -1.0D).getBlock().setType(Material.BEDROCK);
          P1.getLocation().add(-1.0D, 11.0D, 0.0D).getBlock().setType(Material.BEDROCK);
          P1.getLocation().add(0.0D, 10.0D, 0.0D).getBlock().setType(Material.BEDROCK);
          P1.teleport(P1.getLocation().add(0.0D, 11.0D, -0.06D));
        P1.getPlayer().playSound(P1.getPlayer().getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
      }
    }
  }
  
	@EventHandler
	public void clicar(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		ItemStack i = p.getItemInHand();
		if (i.getType() == Material.LEVER) {
			p.setVelocity(p.getEyeLocation().getDirection().multiply(3).add(new Vector(0, 0.4, 0)));
		}
			}
	
  @EventHandler
  public void TestarOAutoSoupDoJogador(PlayerInteractEntityEvent Event)
  {
    if (!(Event.getRightClicked() instanceof Player)) {
      return;
    }
    Player P1 = Event.getPlayer();
    Player R = (Player)Event.getRightClicked();
    if ((Admin.contains(P1.getName())) && (P1.getItemInHand().getType() == Material.BOWL)) {
      P1.chat("/AutoSoup " + R.getName());
    }
  }
  
  @EventHandler
  public void MatarUmJogador(PlayerInteractEntityEvent Event)
  {
    if (!(Event.getRightClicked() instanceof Player)) {
      return;
    }
    Player P1 = Event.getPlayer();
    Player R = (Player)Event.getRightClicked();
    Player target = Bukkit.getPlayerExact(R.getName());
    if ((Admin.contains(P1.getName())) && (P1.getItemInHand().getType() == Material.DIAMOND_SWORD)) {
      target.setHealth(0.0);
    }
  }
  
  @EventHandler
  public void EventosAdmin(PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    if ((Admin.contains(p.getName())) && (
      (e.getAction() == Action.RIGHT_CLICK_BLOCK) || (e.getAction() == Action.RIGHT_CLICK_AIR)))
    {
      if (p.getItemInHand().getType() == Material.REDSTONE)
      {
        p.chat("/Admin");
        p.getInventory().setContents((ItemStack[])SalvarInv.get(p.getName()));
        p.updateInventory();
      }
      if (p.getItemInHand().getType() == Material.MAGMA_CREAM)
      {
        p.chat("/Admin");
        p.getInventory().setContents((ItemStack[])SalvarInv.get(p.getName()));
        p.updateInventory();
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
        {
          public void run()
          {
            p.chat("/Admin");
          }
        }, 10L);
      }
    }
  }
  
  @SuppressWarnings("deprecation")
public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args)
  {
    Player p = (Player)Sender;
    if (Cmd.getName().equalsIgnoreCase("Admin"))
    {
      if (!p.hasPermission("tk.Admin"))
      {
        p.sendMessage("§7[§6§l!§7] §cVocê não tem permissão para este comando!");
        return false;
      }
      if (Admin.contains(p.getName()))
      {
        Player[] arrayOfPlayer;
        int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
        for (int i = 0; i < j; i++)
        {
          Player all = arrayOfPlayer[i];
          all.showPlayer(p);
          if (all.hasPermission("tk.Admin"))
          {
              all.sendMessage("§7[§6§l!§7] §b" + p.getName() + " §cSaiu do Modo Admin ");
            p.getInventory().setContents((ItemStack[])SalvarInv.get(p.getName()));
            p.updateInventory();
          }
        }
        p.setGameMode(GameMode.SURVIVAL);
        for (int i1 = 0; i1 < 20; i1++) {}
        Admin.remove(p.getName());
      }
      else
      {
        Admin.add(p.getName());
        Player[] arrayOfPlayer;
        int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
        for (int i = 0; i < j; i++)
        {
          Player all = arrayOfPlayer[i];
          
          all.hidePlayer(p);
          if (all.hasPermission("tk.Admin"))
          {
            all.sendMessage("§7[§6§l!§7] §b" + p.getName() + " §aEntrou No Modo Admin ");
          }
        }
        p.setGameMode(GameMode.CREATIVE);
        p.getInventory().clear();
      }
    }
    SalvarInv.put(p.getName(), p.getInventory().getContents());
    p.getInventory().clear();
    darItem(p, Material.IRON_FENCE, "§b Colocar Um §cJogador §bEm Uma Arena ", 1);
    darItem(p, Material.REDSTONE, "§bSair Do §aAdmin", 4);
    darItem(p, Material.DIAMOND_SWORD, "§b Matar Um §cJogador ", 5);
    darItem(p, Material.MAGMA_CREAM, "§b Sair E Entrar Rapidamente Do §aAdmin ", 6);
    darItem(p, Material.BOWL, "§bTestar §cAuto-Soup §bEm Um §cJogador ", 9);
    darItem(p, Material.LEVER, "§bBrinque por aí!", 2);
    return true;
  }
  
  public void darItem(Player p, Material material, String nome, int slot)
  {
    ItemStack kDarItem = new ItemStack(material);
    ItemMeta metal = kDarItem.getItemMeta();
    metal.setDisplayName(nome);
    kDarItem.setItemMeta(metal);
    
    p.getInventory().setItem(slot - 1, kDarItem);
  }
}
