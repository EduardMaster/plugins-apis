package me.recenthg.Eventss;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.recenthg.Main;
import me.recenthg.CMDS.Tag;
import me.recenthg.Utils.Estado;


public class PreJoinEvt implements Listener {

	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		if (Main.estados == Estado.INICIANDO)
			e.setCancelled(true);
	}

	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		if (Main.estados == Estado.INICIANDO)
			e.setCancelled(true);
	}

	@EventHandler
	public void onFood(FoodLevelChangeEvent e) {
		if (Main.estados == Estado.INICIANDO)
			e.setCancelled(true);
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if (Main.estados == Estado.INICIANDO)
			e.setCancelled(true);
	}

	@EventHandler
	public void onPickup(PlayerPickupItemEvent e) {
		if (Main.estados == Estado.INICIANDO)
			e.setCancelled(true);
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if (Main.estados == Estado.INICIANDO)
			Main.Jogadores.remove(p.getName());
	}

	@EventHandler
	public void DamageMobs(EntityDamageEvent e) {
		if (!(e.getEntity() instanceof LivingEntity)) {
			return;
		}
		if (Main.estados == Estado.INICIANDO)
			e.setCancelled(true);
		return;

	}

	@EventHandler
	public void DamagePlayers(EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		if (Main.estados == Estado.INICIANDO)
			e.setCancelled(true);
		return;

	}

	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (Main.estados == Estado.INICIANDO)
			e.setCancelled(true);
		return;
	}

	@EventHandler
	public void onDrop1(PlayerDropItemEvent e) {
		if (Main.estados == Estado.INICIANDO) {
			e.setCancelled(true);
		}
		if (e.getItemDrop().getItemStack().getType() == Material.BOWL)
			e.setCancelled(false);
	}

	@EventHandler
	public void onSoupRemove(final ItemSpawnEvent e) {
		if (Main.estados == Estado.INICIANDO)
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
				public void run() {
					e.getEntity().remove();
				}
			}, 30L);
	}	

	@EventHandler
	public void onJoin(final PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage(null);
		if (Main.estados == Estado.INICIANDO)
			p.sendMessage("§a" + p.getName() + " §7Entrou No Torneio!");
			p.getInventory().clear();
			p.getInventory().setArmorContents(null);
		
		if (!Main.Jogadores.contains(p.getName())) {
			Main.Jogadores.add(p.getName());
		}
		
		p.teleport(new Location(Bukkit.getWorld("world"), -9, 210, -11));
	
			ItemStack kits = new ItemStack(Material.CHEST);
			ItemMeta rkits = kits.getItemMeta();
			rkits.setDisplayName("§e§lPrimeiro Kit §7(Clique§7)");
			kits.setItemMeta(rkits);

			ItemStack buycraft = new ItemStack(Material.EMERALD);
			ItemMeta rbuycraft = buycraft.getItemMeta();
			rbuycraft.setDisplayName("§e§lBuycraft §7(Clique§7)");
			buycraft.setItemMeta(rbuycraft);
			
			Tag.AtualizarTag(p);
			
			if (!Main.instance.stats.contains(p.getUniqueId() + "")) {
				Main.instance.stats.set(p.getUniqueId() + ".Wins", 0);
				Main.instance.stats.set(p.getUniqueId() + ".Matou", 0);
				Main.instance.stats.set(p.getUniqueId() + ".Morreu", 0);
				Main.instance.save();
			}


			ItemStack buycraft21222 = new ItemStack(Material.EXPLOSIVE_MINECART);
			ItemMeta rbuycraft2122 = buycraft21222.getItemMeta();
			rbuycraft2122.setDisplayName("§e§lCoins Diaria §7(Clique§7)");
			buycraft21222.setItemMeta(rbuycraft2122);
			
			ItemStack buycraft22122 = new ItemStack(Material.MINECART);
			ItemMeta rbuycraft22122 = buycraft22122.getItemMeta();
			rbuycraft22122.setDisplayName("§e§lKit Diario §7(Clique§7)");
			buycraft22122.setItemMeta(rbuycraft22122);
			
			ItemStack item141 = new ItemStack(Material.SKULL_ITEM);
			ItemMeta itemmeta141 = item141.getItemMeta();
			itemmeta141.setDisplayName("§e§lStatus §7(Clique§7)");
			item141.setItemMeta(itemmeta141);
			
			p.getInventory().setItem(0, kits);
			p.getInventory().setItem(4, item141);
			p.getInventory().setItem(8, buycraft);
			p.getInventory().setItem(7, buycraft22122);
			p.getInventory().setItem(3, buycraft21222);
			
			p.playSound(p.getLocation(), Sound.WITHER_SPAWN, 4.0F, 4.0F);

			p.sendMessage("§a§m--()---------------------()§a§m--");
			p.sendMessage("");
			p.sendMessage("§7Bem Vindo Ao §e§lEffects§f§lHG!");
			p.sendMessage("§7Servidor Na Versão 1.0 Qualquer bug reporte !");
			p.sendMessage("§7Tenha Um Bom Torneio!");
			p.sendMessage("");
			p.sendMessage("§a§m--()---------------------()§a§m--");
			p.sendMessage("");
		
	

	}
	
	@EventHandler
	protected void onPlayerLeaveColiseu(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		
		if (Main.estados == Estado.INICIANDO) {
			if (player.getLocation().getY() < 120 || player.getLocation().getX() < -30 || player.getLocation().getZ() < -31 && Main.instance.getConfig().getBoolean("Coliseu")) {
				player.teleport(new Location(Bukkit.getWorld("world"), -10, 210, -12));
				player.setFallDistance(0.0F);
			}
		}
	}

}