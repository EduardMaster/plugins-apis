package me.recenthg.Kits;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

import me.recenthg.Main;
import me.recenthg.Manager.Habilidade;
import me.recenthg.Utils.Estado;

public class BurstMaster implements org.bukkit.event.Listener {
	public BurstMaster() {
	}

	public static HashMap<String, Long> cooldown = new HashMap<String, Long>();

	@EventHandler
	public void interact(PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Main.estados == Estado.ANDAMENTO)
			if ((Habilidade.getAbility(p).equalsIgnoreCase("BurstMaster"))) {
				if (p.getItemInHand().getType() == Material.GOLD_HOE)
					if ((e.getAction() == Action.RIGHT_CLICK_AIR)
							|| (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
					if ((!cooldown.containsKey(p.getName()))
							|| (((Long) cooldown.get(p.getName())).longValue() <= System.currentTimeMillis())) {
						e.setCancelled(true);
						p.updateInventory();
						Vector velo1 = p.getLocation().getDirection().normalize().multiply(2);
						final Snowball boladenve = (Snowball) p.launchProjectile(Snowball.class);
						boladenve.setVelocity(velo1);
						boladenve.setFireTicks(0);

						Location location = p.getEyeLocation();
						BlockIterator blocksToAdd = new BlockIterator(location, 0.0D, 30);

						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
							public void run() {
								boladenve.remove();
							}
						}, 10L);

						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
							public void run() {
								p.getWorld().createExplosion(boladenve.getLocation().add(0.0D, 3.0D, 0.0D), 3.0F);
							}
						}, 15L);
						while (blocksToAdd.hasNext()) {
							Location blockToAdd = blocksToAdd.next().getLocation();
							Effect a = Effect.STEP_SOUND;

							p.getWorld().playEffect(blockToAdd, a, 46);
						}
						cooldown.put(p.getName(),
								Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(30L)));
						return;
					}
					p.sendMessage("§8\u276e§4§l!§8\u276f §7Faltam §4"
							+ TimeUnit.MILLISECONDS.toSeconds(
									((Long) cooldown.get(p.getName())).longValue() - System.currentTimeMillis())
							+ " §7Para Usar Novamente");
					}
			}
}
}
