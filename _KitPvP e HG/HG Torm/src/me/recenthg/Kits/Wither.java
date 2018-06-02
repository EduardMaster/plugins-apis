package me.recenthg.Kits;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import me.recenthg.Main;
import me.recenthg.Manager.Habilidade;
import me.recenthg.Utils.Estado;

public class Wither implements org.bukkit.event.Listener {
	public Wither() {
	}

	public static Wither m;
	PluginManager pm = Bukkit.getServer().getPluginManager();
	public static Plugin plugin;
	public static HashMap<String, Long> cooldown = new HashMap<String, Long>();

	@EventHandler
	public void onwithertiro(PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Main.estados == Estado.ANDAMENTO)
			if ((Habilidade.getAbility(p).equalsIgnoreCase("wither")))
				if (e.getAction() == Action.RIGHT_CLICK_AIR) {
					if (p.getItemInHand().getType() == Material.SKULL_ITEM) {
						if ((!cooldown.containsKey(p.getName()))
								|| (((Long) cooldown.get(p.getName())).longValue() <= System.currentTimeMillis())) {
							p.launchProjectile(WitherSkull.class);
							cooldown.put(p.getName(),
									Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(30L)));
							Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
								public void run() {
									p.launchProjectile(WitherSkull.class);
								}
							}, 5L);

							Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
								public void run() {
									p.launchProjectile(WitherSkull.class);
								}
							}, 10L);
						} else {
							p.sendMessage("§8\u276e§4§l!§8\u276f §7Faltam §4"
									+ TimeUnit.MILLISECONDS.toSeconds(
											((Long) cooldown.get(p.getName())).longValue() - System.currentTimeMillis())
									+ " §7segundos para poder usar novamente.");
							p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 4.0F, 4.0F);
						}
					}
				}
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (p.getItemInHand().getType() == Material.SKULL_ITEM) {
				if (p.getItemInHand().getItemMeta().getDisplayName().contains("wither")) {
					e.setCancelled(true);
					p.sendMessage("§8\u276e§4§l!§8\u276f §7Use o kit apontando para o ar!");
				}
			}
		}
	}
}
