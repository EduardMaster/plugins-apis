package me.recenthg.Kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.recenthg.Main;
import me.recenthg.Manager.Habilidade;
import me.recenthg.Utils.Estado;

public class Thor implements Listener {
	public static Main plugin;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	static List<Player> cooldown = new ArrayList();

	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerInteract(PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Main.estados == Estado.ANDAMENTO)
			
				if (((Habilidade.getAbility(p).equalsIgnoreCase("thor"))))
					if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))) {
						
						ItemStack hand = p.getItemInHand();

						if (hand.getType() == Material.WOOD_AXE) {
							if (cooldown.contains(p)) {
								p.sendMessage("§8\u276e§4§l!§8\u276f §7Voce Esta Em Cooldown");
							} else {
								Location loc = p.getTargetBlock(null, 20).getLocation();

								p.getWorld().strikeLightning(loc);

								cooldown.add(p);
								Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
									public void run() {
										cooldown.remove(p);
										p.sendMessage("§8\u276e§4§l!§8\u276f §7Voce pode usar o Thor novamente!");
										p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 4.0F, 4.0F);
									}
								}, 80L);
							}
						}
					}
	}
}