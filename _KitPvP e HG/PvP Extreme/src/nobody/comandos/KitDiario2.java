package nobody.comandos;

import java.util.Calendar;

import nobody.main.Main;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;


public class KitDiario2 {
	
	public KitDiario2() {
		
		new BukkitRunnable() {
			public void run() {
				Calendar calendar1 = Calendar.getInstance();
				int hora = calendar1.get(Calendar.HOUR_OF_DAY);
				int minutos = calendar1.get(Calendar.MINUTE);
				int segundos = calendar1.get(Calendar.SECOND);
				if (hora == 00 && minutos == 00 && segundos == 00) {
				Bukkit.broadcastMessage("§6{§a§lKITDIARIO§6} §cTodos os kits diarios foram resetados!");
				}
			}
		}.runTaskTimer(Main.instance, 0, 1 * 20);
	}
}
