package EventosPrincipais;

import Outros.ScoreBoard;
import Utils.KitAPI;
import Utils.WarpsAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Parkour
  extends ScoreBoard
  implements Listener
{
	public static ItemStack kits;
	public static ItemMeta kitsmeta;
	public static ItemStack warps;
	public static ItemMeta warpsmeta;
	public static ItemStack click;
	public static ItemMeta clickmeta;
	public static ItemStack parkour;
	public static ItemMeta parkourmeta;
	public static ItemStack loja;
	public static ItemMeta lojameta;
  
  @SuppressWarnings("deprecation")
@EventHandler
  public void ClickSlime(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if ((KitAPI.getKit(p).equals("Parkour")) && 
      ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
      (e.getItem().getType().equals(Material.SLIME_BALL)))
    {
      ItemStack hoe = new ItemStack(Material.MAGMA_CREAM);
      ItemMeta hoemeta = hoe.getItemMeta();
      hoemeta.setDisplayName("§cMostrar Jogadores");
      hoe.setItemMeta(hoemeta);
      
      p.getInventory().setItem(0, hoe);
      Player[] arrayOfPlayer;
      int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
      for (int i = 0; i < j; i++)
      {
        Player s = arrayOfPlayer[i];
        p.hidePlayer(s);
      }
      p.sendMessage("§cVoce escondeu os Jogadores!");
      p.updateInventory();
    }
  }
  
  @EventHandler
  public void Magma(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if ((KitAPI.getKit(p).equals("Parkour")) && 
      ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
      (e.getItem().getType().equals(Material.MAGMA_CREAM)))
    {
      ItemStack espada = new ItemStack(Material.SLIME_BALL);
      ItemMeta espadameta = espada.getItemMeta();
      espadameta.setDisplayName("§aEsconder Jogadores");
      espada.setItemMeta(espadameta);
      p.getInventory().setItem(0, espada);
      Player[] arrayOfPlayer;
      @SuppressWarnings("deprecation")
	int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
      for (int i = 0; i < j; i++)
      {
        Player s = arrayOfPlayer[i];
        p.showPlayer(s);
      }
      p.sendMessage("§aVoce revelou os Jogadores!");
      p.updateInventory();
    }
  }
  
  @EventHandler
  public void HitKill(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if ((KitAPI.getKit(p).equals("Parkour")) && 
      ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
      (e.getItem().getType().equals(Material.NAME_TAG)))
    {
      WarpsAPI.ir(p, "Parkour");
      p.updateInventory();
    }
  }
  
	@EventHandler
	  public void DanoDeQueda(EntityDamageEvent e)
	  {
	    if (((e.getEntity() instanceof Player)) && (e.getCause() == EntityDamageEvent.DamageCause.FALL)) {
	    Player p = (Player)e.getEntity();
	    if (KitAPI.getKit(p).equals("Parkour"))
	    {
	      e.setCancelled(true);
	      e.setDamage(0.0D);
	      WarpsAPI.ir(p, "Parkour");
	      p.playSound(p.getLocation(), Sound.NOTE_PLING, 1.0F, 1.0F);
	    }
	    }
	  }

  
  @EventHandler
  public void Sair(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if ((KitAPI.getKit(p).equals("Parkour")) && 
      ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
      (e.getItem().getType().equals(Material.REDSTONE_BLOCK)))
    {
      p.getInventory().clear();
	  WarpsAPI.ir(p, "spawn");
      KitAPI.RemoveKit(p);
      KitAPI.KitDelay.remove(p.getName());
      
	    kits = new ItemStack(Material.CHEST);
	    kitsmeta = kits.getItemMeta();
	    kitsmeta.setDisplayName("§a§lKits");
	    kits.setItemMeta(kitsmeta);
	    
	    warps = new ItemStack(Material.BOOK);
	    warpsmeta = warps.getItemMeta();
	    warpsmeta.setDisplayName("§a§lWarps");
	    warps.setItemMeta(warpsmeta);
	    
	    click = new ItemStack(Material.WOOD_SWORD);
	    clickmeta = click.getItemMeta();
	    clickmeta.setDisplayName("§a§lClick-Teste");
	    click.setItemMeta(clickmeta);
	    
	    parkour = new ItemStack(Material.NAME_TAG);
	    parkourmeta = parkour.getItemMeta();
	    parkourmeta.setDisplayName("§a§lParkour");
	    parkour.setItemMeta(parkourmeta);
	    
	    loja = new ItemStack(Material.EMERALD);
	    lojameta = parkour.getItemMeta();
	    lojameta.setDisplayName("§a§lLoja");
	    loja.setItemMeta(lojameta);
	    
	    p.getInventory().setItem(1, kits);
	    p.getInventory().setItem(2, warps);
	    p.getInventory().setItem(4, click);
	    p.getInventory().setItem(6, parkour);
	    p.getInventory().setItem(7, loja);
      p.updateInventory();
    }
  }
}