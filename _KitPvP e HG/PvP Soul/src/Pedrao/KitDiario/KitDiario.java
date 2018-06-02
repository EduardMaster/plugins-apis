package Pedrao.KitDiario;

import java.util.Calendar;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import Pedrao.Main;

public class KitDiario {
	
	public KitDiario() {
		
		new BukkitRunnable() {
			public void run() {
				Calendar calendar1 = Calendar.getInstance();
				int hora = calendar1.get(Calendar.HOUR_OF_DAY);
				int minutos = calendar1.get(Calendar.MINUTE);
				int segundos = calendar1.get(Calendar.SECOND);
				if (hora == 00 && minutos == 00 && segundos == 00) {
					Bukkit.broadcastMessage(Main.prefix + "Todos os kits diarios foram resetados!");
				}
			}
		}.runTaskTimer(Main.instance, 0, 1 * 20);
	}
}
