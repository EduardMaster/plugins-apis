package Zey.PvP.Eventos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.scheduler.BukkitRunnable;

import Zey.PvP.Config.ZeyCoins;
import Zey.PvP.Main.Main;

@SuppressWarnings({ "deprecation" })
public class Admin implements Listener {

	public Main main;
	
	public Admin(Main main) {
		this.main = main;
	}
	
	@EventHandler
	private void onPlayerInteractPlayerAdmin(PlayerInteractEntityEvent e) {
		if (!(e.getRightClicked() instanceof Player)) return;
		
		Player player = e.getPlayer();
		Player clicked = (Player)e.getRightClicked();
		
		String player_name = player.getName();
		
		if (Main.admins.contains(player_name)) {
			if (player.getItemInHand().getType() == Material.AIR) {
				player.openInventory(clicked.getInventory());
				
				player.sendMessage(String.valueOf(Main.prefix) + " §7» Você está vendo o inventario do jogador(a): §c" + clicked.getName());
				e.setCancelled(true);
			} else if (player.getItemInHand().getType().equals((Object)Material.BEDROCK) 
	        		&& player.getItemInHand().getItemMeta().hasDisplayName() 
	        		&& player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§cPrisão §7(Clique No Player)")) {
				player.performCommand("cage " + clicked.getName());
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	private void onPlayerInteractAdmin(PlayerInteractEvent e) {
		final Player player = e.getPlayer();
		String player_name = player.getName();
		
		if (Main.admins.contains(player_name)) {			
			if (player.getItemInHand() == null || !player.getItemInHand().hasItemMeta()) return;
			
		        if (player.getItemInHand().getType().equals((Object)Material.SLIME_BALL) 
		        		&& player.getItemInHand().getItemMeta().hasDisplayName() 
		        		&& player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§cTroca-Rapida §7(Clique)")) {
				player.performCommand("admin");
				
				new BukkitRunnable() {
					public void run() {
						player.performCommand("admin");
					}
				}.runTaskLater(main, 7);
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void InteragirEtiqueta(PlayerInteractEntityEvent e) {
			Player player = e.getPlayer();
			Player t = (Player)e.getRightClicked();
			if (player.hasPermission("zey.pvp.infoplayer")) {
	        if (player.getItemInHand().getType().equals((Object)Material.PAPER) 
	        		&& player.getItemInHand().getItemMeta().hasDisplayName() 
	        		&& player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§cInformações §7(Clique No Player)")) {
			Damageable hp = t;
			player.sendMessage("§cInformacoes do Player §e" + t.getName() + "§c.");
			player.sendMessage("§cVida: §7" + (int)hp.getHealth());
			player.sendMessage("§cKills: §7" + Main.plugin.getConfig().getInt("status." + t.getName().toLowerCase() + ".kills"));
			player.sendMessage("§cDeaths: §7" + Main.plugin.getConfig().getInt("status." + t.getName().toLowerCase() + ".mortes"));
			player.sendMessage("§cMoney: §7" + ZeyCoins.getPlayerMoney(t) + " ZeyCoins§c.");
			player.sendMessage("§clP: §7" + t.getAddress().getHostString());
			player.sendMessage("§clP (Reverso): §7" + t.getAddress().getHostName());
      }
			}
  }
	
	@EventHandler
	private void onPlayerDropItemAdmin(PlayerDropItemEvent e) {
		Player player = e.getPlayer();
		
		if (Main.admins.contains(player.getName())) {
			if (!e.getItemDrop().getItemStack().hasItemMeta()) return;
			
			if (!e.getItemDrop().getItemStack().getItemMeta().getDisplayName().contains(e.getItemDrop().getItemStack().getType().toString())) {
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	private void onPlayerPickUpAdmin(PlayerPickupItemEvent e) {
		Player player = e.getPlayer();
		
		if (Main.admins.contains(player.getName())) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	private void onPlayerJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		
		for (Player players : Bukkit.getOnlinePlayers()) {
			if (Main.admins.contains(players.getName()) && !player.hasPermission("zey.pvp.admin.ver")) {
				player.hidePlayer(players);
			}
		}
	}
}
