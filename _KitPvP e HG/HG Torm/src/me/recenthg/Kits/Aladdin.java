package me.recenthg.Kits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import me.recenthg.Main;
import me.recenthg.Manager.Habilidade;
import me.recenthg.Utils.Estado;

public class Aladdin implements Listener {

	public static ArrayList<String> cooldown = new ArrayList<String>();

	@SuppressWarnings("deprecation")
	@EventHandler
	public void SonicClick(PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (Main.estados == Estado.ANDAMENTO || Main.estados == Estado.INVENCIBILIDADE)

			if ((Habilidade.getAbility(p).equalsIgnoreCase("aladdin")))
				if ((event.getPlayer().getItemInHand().getType() == Material.CARPET)) {
					if ((event.getAction() == Action.LEFT_CLICK_AIR) || (event.getAction() == Action.LEFT_CLICK_BLOCK)
							|| (event.getAction() == Action.RIGHT_CLICK_BLOCK)
							|| (event.getAction() == Action.RIGHT_CLICK_AIR)) {
						event.setCancelled(true);
					}

					if (!cooldown.contains(p.getName())) {
						p.sendMessage("§8\u276e§4§l!§8\u276f §7Voce estendeu seu tapete e agora esta voando");

						final FallingBlock tapete = p.getWorld().spawnFallingBlock(
								p.getLocation().clone().add(0.0D, 1.0D, 0.0D), Material.CARPET.getId(), (byte) 0);
						tapete.setDropItem(false);
						tapete.setVelocity(new Vector(0, 0, 0));
						tapete.setPassenger(p);
						Location loc = p.getLocation().clone();
						loc.setPitch(0.0F);
						cooldown.add(p.getName());
						Vector vec = p.getVelocity().clone();
						int forca = 7;
						Vector pular = vec.multiply(0.1D).setY(0.17D * forca);
						Vector olhar = loc.getDirection().normalize().multiply(1.5D);
						tapete.setVelocity(pular.add(olhar));
						tapete.getWorld().playEffect(loc, Effect.FLAME, 50, 50);

						Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
							public void run() {
								tapete.remove();
								p.sendMessage("§8\u276e§4§l!§8\u276f §7Seu tapete foi enrolado");
								tapete.getWorld().playEffect(tapete.getLocation(), Effect.EXPLOSION, 5, 5);
								tapete.getWorld().playEffect(tapete.getLocation(), Effect.EXPLOSION_HUGE, 10, 10);
								tapete.getWorld().playEffect(tapete.getLocation(), Effect.ENDER_SIGNAL, 10, 10);
								tapete.getWorld().playSound(tapete.getLocation(), Sound.EXPLODE, 5F, 5F);
							}
						}, 50L);

						Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
							public void run() {
								Aladdin.cooldown.remove(p.getName());
								p.sendMessage("§8\u276e§4§l!§8\u276f §7O Cooldown Acabou");
								p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 4.0F, 4.0F);
							}
						}, 400L);
					} else {
						p.sendMessage("§8\u276e§4§l!§8\u276f §7Seu Tapete Nao Esta Pronto");
					}
				}
	}

}