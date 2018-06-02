package br.com.alpha.InGame.Listeners.Kits.Managers;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitRunnable;

import br.com.alpha.MCAlpha;
import br.com.alpha.APIs.APIClass;
import br.com.alpha.APIs.Title;

public class CooldownManagement {

	public static HashMap<UUID, Long> cooldownPlayerManager = new HashMap<>();

	private UUID p;

	public CooldownManagement(UUID p) {
		this.p = p;
	}

	public void setPlayerCooldown(Integer segundos) {
		cooldownPlayerManager.put(p, APIClass.currentMilliMoreSeg(segundos));
	}

	public Boolean playerHasCooldown() {
		return cooldownPlayerManager.containsKey(p);
	}

	public Boolean canUseItem() {
		return System.currentTimeMillis() > cooldownPlayerManager.get(p) ? true : false;
	}

	public void removePlayerCooldown() {
		if (cooldownPlayerManager.containsKey(p)) {
			Bukkit.getPlayer(p).sendMessage("                                              ");
			Bukkit.getPlayer(p).sendMessage("§aSeu kit não está mais no cooldown!");
			Bukkit.getPlayer(p).sendMessage("                                              ");
			Title.sendXPBarMessage(Bukkit.getPlayer(p), "§a§lPINTO");
			Bukkit.getPlayer(p).playSound(Bukkit.getPlayer(p).getLocation(), Sound.SUCCESSFUL_HIT, 1F, 1F);
			cooldownPlayerManager.remove(p);
		}
	}

	public Integer getPlayerCooldownInt() {
		return cooldownPlayerManager.containsKey(p) ? Math.round(cooldownPlayerManager.get(p)) : 0;
	}

	public Long getPlayerCooldownLong() {
		return cooldownPlayerManager.containsKey(p) ? cooldownPlayerManager.get(p) : 0;
	}

	public static void runTaskTimer() {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				new BukkitRunnable() {
					public void run() {
						if (!(cooldownPlayerManager.isEmpty())) {
							for (Entry<UUID, Long> cooldown : cooldownPlayerManager.entrySet()) {
								if (new CooldownManagement(cooldown.getKey()).canUseItem()) {
									new CooldownManagement(cooldown.getKey()).removePlayerCooldown();
								}
							}
						}
					}
				}.runTaskTimer(MCAlpha.mcAlpha, 0, 20L);

			}
		});
		t.start();
	}
}
