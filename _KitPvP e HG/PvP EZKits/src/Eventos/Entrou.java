package Eventos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Main.Main;
import Outros.ScoreBoard;


public class Entrou implements Listener{
	
	public static ItemStack bau123;
	public static ItemMeta bau123meta;
	public static ItemStack loja;
	public static ItemMeta lojameta;
	public static ItemStack warp;
	public static ItemMeta warpmeta;
	public static ItemStack mg;
	public static ItemMeta mgmeta;
	public static ItemStack hot1;
	public static ItemMeta hot1meta;
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void Entrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		ScoreBoard.UpdateScore(p);
		if (!Main.getInstance().stats.contains(p.getUniqueId() + "")) {
			Main.getInstance().stats.set(p.getUniqueId() + ".Kills", Integer.valueOf(0));
			Main.getInstance().stats.set(p.getUniqueId() + ".Deaths", Integer.valueOf(0));
			Main.getInstance().stats.set(p.getUniqueId() + ".Money", Integer.valueOf(100));
		}
		e.setJoinMessage(null);
		for (Player s : Bukkit.getOnlinePlayers()) {
			s.sendMessage("§7[§4+§7] " + p.getName());
		}
		p.teleport(p.getWorld().getSpawnLocation());
		p.getInventory().clear();
		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		p.getInventory().setBoots(new ItemStack(Material.AIR));
		p.getActivePotionEffects().clear();
		p.sendMessage("§3==========================");
		p.sendMessage("§5++++++++++++++++++++++++++");
		p.sendMessage("§3==========================");
		p.sendMessage("§6§lBem Vindo Ao Servidor");
		p.sendMessage("§3==========================");
		p.sendMessage("§5++++++++++++++++++++++++++");
		p.sendMessage("§3==========================");
		
		
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
	          mg2.setDisplayName("§e§lEMBreve");
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
		
		p.updateInventory();
		
	}

}
