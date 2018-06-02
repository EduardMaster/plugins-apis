package Vytor.KitDiario;

import java.util.Calendar;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import me.rafael.vinagre.KomboPvP.Main;


public class XpDiario2 {
	
	public XpDiario2() {
		
		new BukkitRunnable() {
			public void run() {
				Calendar calendar1 = Calendar.getInstance();
				int hora = calendar1.get(Calendar.HOUR_OF_DAY);
				int minutos = calendar1.get(Calendar.MINUTE);
				int segundos = calendar1.get(Calendar.SECOND);
				if (hora == 00 && minutos == 00 && segundos == 00) {
				Bukkit.broadcastMessage("§a§lCoinsDiario §cTodos os XP diarios foram resetados!");
				}
			}
		}.runTaskTimer(me.rafael.vinagre.KomboPvP.Main.instance, 0, 1 * 20);
	}
}
