package me.recenthg.Tempo;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import me.recenthg.Main;
import me.recenthg.Score.Scoreboasrdsadd;
import me.recenthg.Utils.Estado;

public class Invencibilidade implements Listener {

	public static void onInvencivel() {
		Main.estados = Estado.INVENCIBILIDADE;
		new BukkitRunnable() {
			@SuppressWarnings("deprecation")
			public void run() {

				Main.TimerInvencibilidade -= 1;
				for (Player p : Bukkit.getOnlinePlayers()) {
					Scoreboasrdsadd.ScoreBoardInvencibilidade(p);
				}
				switch (Main.TimerInvencibilidade) {
				case 120:
					Bukkit.broadcastMessage("§e§lEffects§f§lHG "+Main.Menssagems+"O Invencibilidade Acabara Em: §e§l2 minutos");
					break;
				case 60:
					Bukkit.broadcastMessage("§e§lEffects§f§lHG "+Main.Menssagems+"O Invencibilidade Acabara Em: §e§l1 minutos");
					break;
				case 30:
					Bukkit.broadcastMessage("§e§lEffects§f§lHG "+Main.Menssagems+"O Invencibilidade Acabara Em: §e§l30 segundos");
					break;
				case 5:
					Bukkit.broadcastMessage("§e§lEffects§f§lHG "+Main.Menssagems+"O Invencibilidade Acabara Em: §e§l5 segundos");
					break;
				case 4:
					Bukkit.broadcastMessage("§e§lEffects§f§lHG "+Main.Menssagems+"O Invencibilidade Acabara Em: §e§l4 segundos");
					break;
				case 3:
					Bukkit.broadcastMessage("§e§lEffects§f§lHG "+Main.Menssagems+"O Invencibilidade Acabara Em: §e§l3 segundos");
					break;
				case 2:
					Bukkit.broadcastMessage("§e§lEffects§f§lHG "+Main.Menssagems+"O Invencibilidade Acabara Em: §e§l2 segundos");
					break;
				case 1:
					Bukkit.broadcastMessage("§e§lEffects§f§lHG "+Main.Menssagems+"O Invencibilidade Acabara Em: §e§l1 segundo");
					break;
				case 0:
					Bukkit.broadcastMessage("§4§lA Invencibilidade Acabou !");

					Andamento.onAndamento();
					cancel();
					break;

				}
			}
		}.runTaskTimer(Main.plugin, 0, 20);
	}

}