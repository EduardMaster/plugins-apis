package me.recenthg.Tempo;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import me.recenthg.Main;
import me.recenthg.Manager.Listeners;
import me.recenthg.Manager.Title;
import me.recenthg.Score.Scoreboasrdsadd;
import me.recenthg.Utils.Estado;

public class Iniciando implements Listener {

	public static ArrayList<String> Jogadores = new ArrayList<String>();
	public static Integer ReIniciando = Integer.valueOf(300);
	public static ArrayList<String> RelogPreGame = new ArrayList<String>();
	public static BukkitTask task;

	public static void onIniciando() {
		Main.estados = Estado.INICIANDO;
		task = new BukkitRunnable() {
			@SuppressWarnings("deprecation")
			public void run() {
				Main.TimerIniciando--;
				for (Player p : Bukkit.getOnlinePlayers()) {
					Scoreboasrdsadd.ScoreBoardIniciando(p);
				}

				switch (Main.TimerIniciando) {
				case 300:
					Bukkit.broadcastMessage("§e§lEffects§f§f§lHG "+Main.Menssagems+"§7O Torneio Irá dar inicio Em: §e5m");
					for (Player p : Bukkit.getOnlinePlayers()) {
						Title.sendTitle(p, "§6Iniciando Em:");
						Title.sendSubTitle(p, "§f5 Minutos");
					}
					break;
				case 240:
					Bukkit.broadcastMessage("§e§lEffects§f§lHG "+Main.Menssagems+"§7O Torneio Irá dar inicio Em: §e4m");
					for (Player p : Bukkit.getOnlinePlayers()) {
						Title.sendTitle(p, "§6Iniciando Em:");
						Title.sendSubTitle(p, "§f4 Minutos");
					}
					break;
				case 180:
					Bukkit.broadcastMessage("§e§lEffects§f§lHG "+Main.Menssagems+"§7O Torneio Irá dar inicio Em: §e3m");
					for (Player p : Bukkit.getOnlinePlayers()) {
						Title.sendTitle(p, "§6Iniciando Em:");
						Title.sendSubTitle(p, "§f3 Minutos");
					}
					break;
				case 120:
					Bukkit.broadcastMessage("§e§lEffects§f§lHG "+Main.Menssagems+"§7O Torneio Irá dar inicio Em: §e2m");
					for (Player p : Bukkit.getOnlinePlayers()) {
						Title.sendTitle(p, "§6Iniciando Em:");
						Title.sendSubTitle(p, "§f2 Minutos");
					}
					break;
				case 60:
					Bukkit.broadcastMessage("§e§lEffects§f§lHG "+Main.Menssagems+"§7O Torneio Irá dar inicio Em: §e1m");
					for (Player p : Bukkit.getOnlinePlayers()) {
						Title.sendTitle(p, "§6Iniciando Em:");
						Title.sendSubTitle(p, "§f1 Minuto");
					}
					break;
				case 30:
					Bukkit.broadcastMessage("§e§lEffects§f§lHG "+Main.Menssagems+"§7O Torneio Irá dar inicio Em: §e30s");
					for (Player p : Bukkit.getOnlinePlayers()) {
						Title.sendTitle(p, "§6Iniciando Em:");
						Title.sendSubTitle(p, "§f30 Segundos");
					}
					break;
				case 20:
					Bukkit.broadcastMessage("§e§lEffects§f§lHG "+Main.Menssagems+"§7O Torneio Irá dar inicio Em: §e20s");

					for (Player p : Bukkit.getServer().getOnlinePlayers()) {
						Title.sendTitle(p, "§6Iniciando Em:");
						Title.sendSubTitle(p, "§f20 Segundos");

					}
					break;
				case 10:
					Bukkit.broadcastMessage("§e§lEffects§f§lHG "+Main.Menssagems+"§7O Torneio Irá dar inicio Em: §e10s");
					for (Player p : Bukkit.getOnlinePlayers()) {
						Title.sendTitle(p, "§6Iniciando Em:");
						Title.sendSubTitle(p, "§f10 Segundos");
					}
					break;
				case 5:
					Bukkit.broadcastMessage("§e§lEffects§f§lHG "+Main.Menssagems+"§7O Torneio Irá dar inicio Em: §e5s");
					for (Player p : Bukkit.getOnlinePlayers()) {

						Title.sendTitle(p, "§6Iniciando Em:");
						Title.sendSubTitle(p, "§f5 Segundos");

					}
					break;
				case 4:
					Bukkit.broadcastMessage("§e§lEffects§f§lHG "+Main.Menssagems+"§7O Torneio Irá dar inicio Em: §e4s");
					for (Player p : Bukkit.getOnlinePlayers()) {
						Title.sendTitle(p, "§6Iniciando Em:");
						Title.sendSubTitle(p, "§f4 Segundos");
					}
					break;
				case 3:
					Bukkit.broadcastMessage("§e§lEffects§f§lHG "+Main.Menssagems+"§7O Torneio Irá dar inicio Em: §e3s");
					for (Player p : Bukkit.getOnlinePlayers()) {
						Title.sendTitle(p, "§6Iniciando Em:");
						Title.sendSubTitle(p, "§f3 Segundos");
					}
					break;
				case 2:
					Bukkit.broadcastMessage("§e§lEffects§f§lHG "+Main.Menssagems+"§7O Torneio Irá dar inicio Em: §e2s");
					for (Player p : Bukkit.getOnlinePlayers()) {
						Title.sendTitle(p, "§6Iniciando Em:");
						Title.sendSubTitle(p, "§f2 Segundos");
					}
					break;
				case 1:
					Bukkit.broadcastMessage("§e§lEffects§f§lHG "+Main.Menssagems+"§7O Torneio Irá dar inicio Em: §e1s");
					for (Player p : Bukkit.getOnlinePlayers()) {
						Title.sendTitle(p, "§6Iniciando Em:");
						Title.sendSubTitle(p, "§f1 Segundo");
					}
					break;
				case 0:
					if (Main.Jogadores.size() >= 5) {
						Listeners.IniciarPartida();
						cancel();
					} else {
						Main.TimerIniciando=121;
					}

					break;
				}

			}

		}.runTaskTimer(Main.plugin, 0, 20);
	}

}