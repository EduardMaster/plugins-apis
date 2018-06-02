package Pedrao.Habilidades;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import Pedrao.KitAPI;
import Pedrao.Main;

public class Ninja implements Listener {
	public static HashMap<Player, Player> a = new HashMap<Player, Player>();
	public static HashMap<Player, Long> b = new HashMap<Player, Long>();
	public static List<Player> cooldownbk = new ArrayList<Player>();

	public Ninja(Main main) {
	}

	@EventHandler
	public void a(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
		if (((paramEntityDamageByEntityEvent.getDamager() instanceof Player))
				&& ((paramEntityDamageByEntityEvent.getEntity() instanceof Player))) {
			final Player localPlayer1 = (Player) paramEntityDamageByEntityEvent.getDamager();
			Player localPlayer2 = (Player) paramEntityDamageByEntityEvent.getEntity();
			if (KitAPI.Ninja.contains(localPlayer1.getName())) {
				a.put(localPlayer1, localPlayer2);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
					public void run() {
						Ninja.cooldownbk.remove(localPlayer1);
					}
				}, 200L);
			}
		}
	}

	@EventHandler
	public void a(PlayerToggleSneakEvent paramPlayerToggleSneakEvent) {
		Player localPlayer1 = paramPlayerToggleSneakEvent.getPlayer();
		Player localPlayer2;
		if ((paramPlayerToggleSneakEvent.isSneaking()) && (KitAPI.Ninja.contains(localPlayer1.getName()))
				&& (a.containsKey(localPlayer1)) && ((localPlayer2 = (Player) a.get(localPlayer1)) != null)
				&& (!localPlayer2.isDead())) {
			String str = null;
			if (b.get(localPlayer1) != null) {
				long l = ((Long) b.get(localPlayer1)).longValue() - System.currentTimeMillis();
				DecimalFormat localDecimalFormat = new DecimalFormat("##");
				int i = (int) l / 1000;
				str = localDecimalFormat.format(i);
			}
			if ((b.get(localPlayer1) == null)
					|| (((Long) b.get(localPlayer1)).longValue() < System.currentTimeMillis())) {
				if (localPlayer1.getLocation().distance(localPlayer2.getLocation()) < 100.0D) {
					localPlayer1.teleport(localPlayer2.getLocation());
					localPlayer1.sendMessage(Main.prefix + "Teleportado");
					b.put(localPlayer1, Long.valueOf(System.currentTimeMillis() + 10000L));
				} else {
					localPlayer1.sendMessage(Main.prefix + "O Ultimo jogador hitado esta muito longe!");
				}
			} else {
				localPlayer1.sendMessage(Main.prefix + "§c§lCooldown §f> §6" + str + " segundos!");
			}
		}
	}
}
