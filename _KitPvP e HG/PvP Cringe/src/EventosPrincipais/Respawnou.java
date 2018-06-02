package EventosPrincipais;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Kits.Kangaroo;
import Kits.TimeLord;
import Outros.ScoreBoard;
import Utils.KitAPI;

public class Respawnou implements Listener {
	
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
	
	
	@EventHandler
	public void Respawnar(PlayerRespawnEvent e) {
		Player p = e.getPlayer();
		if (Kangaroo.KangarroStats.containsKey(p.getName())) {
			Kangaroo.KangarroStats.remove(p.getName());
		        }
		KitAPI.RemoveKit(p);
		p.setLevel(0);
		p.getInventory().clear();
		ScoreBoard.UpdateScore(p);
		KitAPI.KitDelay.remove(p.getName());
		TimeLord.freeze.remove(p.getName());
	    kits = new ItemStack(Material.STORAGE_MINECART);
	    kitsmeta = kits.getItemMeta();
	    kitsmeta.setDisplayName("§b§lKITS");
	    kits.setItemMeta(kitsmeta);
	    
	    warps = new ItemStack(Material.COMPASS);
	    warpsmeta = warps.getItemMeta();
	    warpsmeta.setDisplayName("§a§LWARPS");
	    warps.setItemMeta(warpsmeta);
	    
	    click = new ItemStack(Material.DIAMOND_SWORD);
	    clickmeta = click.getItemMeta();
	    clickmeta.setDisplayName("§9§LCLICK-TESTE");
	    click.setItemMeta(clickmeta);
	    
	    parkour = new ItemStack(Material.NAME_TAG);
	    parkourmeta = parkour.getItemMeta();
	    parkourmeta.setDisplayName("§6§LPARKOUR");
	    parkour.setItemMeta(parkourmeta);
	    
	    loja = new ItemStack(Material.DIAMOND);
	    lojameta = parkour.getItemMeta();
	    lojameta.setDisplayName("§1§LLOJA");
	    loja.setItemMeta(lojameta);
	    
	    p.getInventory().setItem(0, kits);
	    p.getInventory().setItem(2, warps);
	    p.getInventory().setItem(6, click);
	    p.getInventory().setItem(8, loja);
	    p.updateInventory();
	}

  }
