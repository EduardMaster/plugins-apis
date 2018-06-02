package Eventos;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Kits.Kangaroo;
import Outros.ScoreBoard;

public class Respawnou extends Entrou implements Listener{
	
	@EventHandler
	public void Respawnar(PlayerRespawnEvent e) {
		Player p = e.getPlayer();
		ScoreBoard.UpdateScore(p);
		if (Kangaroo.KangarooStats.containsKey(p.getName())) {
			Kangaroo.KangarooStats.remove(p.getName());
		}
		p.getInventory().clear();
		
		  ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE);
          ItemMeta vidro12 = vidro.getItemMeta();
          vidro12.setDisplayName(" ");
          vidro.setItemMeta(vidro12);
          
          ItemStack vidro2 = new ItemStack(Material.THIN_GLASS);
          ItemMeta vidro22 = vidro2.getItemMeta();
          vidro22.setDisplayName(" ");
          vidro2.setItemMeta(vidro22);
          
          ItemStack kits = new ItemStack(Material.CHEST);
          ItemMeta kits1 = kits.getItemMeta();
          kits1.setDisplayName("§e§lSeus kits");
          kits.setItemMeta(kits1);
          
          ItemStack menu = new ItemStack(Material.EMERALD);
          ItemMeta menu1 = menu.getItemMeta();
          menu1.setDisplayName("§e§lLoja");
          menu.setItemMeta(menu1);
          
          ItemStack warps = new ItemStack(Material.COMPASS);
          ItemMeta warps1 = warps.getItemMeta();
          warps1.setDisplayName("§e§lWarps");
          warps.setItemMeta(warps1);

          ItemStack mg = new ItemStack(Material.JUKEBOX);
          ItemMeta mg1 = warps.getItemMeta();
          mg1.setDisplayName("§e§lMenu");
          mg.setItemMeta(mg1);
          
          ItemStack mga = new ItemStack(Material.LEASH);
          ItemMeta mg2 = warps.getItemMeta();
          mg2.setDisplayName("§e§lMinigames");
          mga.setItemMeta(mg2);
          
          p.getInventory().setItem(5, mg);
          p.getInventory().setItem(1, vidro2);
          p.getInventory().setItem(2, vidro);
          p.getInventory().setItem(4, kits);
          p.getInventory().setItem(0, menu);
          p.getInventory().setItem(8, warps);
          p.getInventory().setItem(6, vidro);
          p.getInventory().setItem(7, vidro2);
          p.getInventory().setItem(3, mga);
	}

}
