package Minigames;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import Main.Main;
import Utils.KitAPI;

public class voidChallenge {

	public voidChallenge(Player p) {
		new BukkitRunnable() {
			int seconds = 5;

			public void run() {
				if (seconds > 0) {
					p.sendMessage("§6§lEZKits §aMinigame Iniciando em " + seconds + " segundos!");
					seconds = seconds - 1;
					return;
				}

				if (seconds == 0) {
					seconds = -1;
					p.getInventory().clear();
					p.teleport(new Location(p.getWorld(), 0, -5, 0));
					p.sendMessage("§6§lEZKits §aO Desafio começou!!!");
					KitAPI.DarSopa(p);
					KitAPI.voidChallenge.add(p.getName());
				}

				KitAPI.voidChallengeTime.put(p.getName(), getTime(p) + 1);
				p.setLevel(getTime(p));

				if (!KitAPI.voidChallenge.contains(p.getName()) && seconds < 0) {
					this.cancel();
				}
			}
		}.runTaskTimer(Main.instance, 0, 20);
	}

	public static int getTime(Player p) {
		if (!KitAPI.voidChallengeTime.containsKey(p.getName()))
			return 0;
		else
			return KitAPI.voidChallengeTime.get(p.getName());
	}

}