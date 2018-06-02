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
