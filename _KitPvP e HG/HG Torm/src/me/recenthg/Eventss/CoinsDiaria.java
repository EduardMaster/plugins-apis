package me.recenthg.Eventss;

import java.util.Calendar;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import me.recenthg.Main;
import me.recenthg.Manager.Listeners;
import me.recenthg.Utils.Estado;

public class CoinsDiaria extends LojaDiaria implements Listener {

	@EventHandler
	public void clicar(PlayerInteractEvent e) {
		Player p = e.getPlayer();
	
		if (p.getItemInHand().getType() == Material.EXPLOSIVE_MINECART) {
			if (Main.estados == Estado.INICIANDO) {
				Shop1(p, 1, 0, 0);
			}
		}

	}
	
	public static void Shop1(Player sender, int dia, int horas, int minutos) {
		Setup1(sender);
		if ((getInt1("Dia") <= Calendar.getInstance().get(Calendar.DAY_OF_MONTH))
				&& (getInt1("Horas") <= Calendar.getInstance().get(Calendar.HOUR_OF_DAY))
				&& (getInt1("Minutos") <= Calendar.getInstance().get(Calendar.MINUTE))) {
	Integer [] teste = {10,48, 10, 40, 100, 80, 200,};	
			Random r = new Random();
			int ra = r.nextInt(teste.length);
			String kit = String.valueOf(teste[ra]);
			sender.sendMessage("§7Você Ganhou §4§l" + kit + " §7Coins");
			Listeners.firework(sender);
			LojaDiaria.SetConfig1("Dia", Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + dia);
			LojaDiaria.SetConfig1("Horas", Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + horas);
			LojaDiaria.SetConfig1("Minutos", Calendar.getInstance().get(Calendar.MINUTE) + minutos);
			

		} else {

			sender.sendMessage("§7Pegue Mais Coins No Dia §4" + getProxKIT(sender));

		}
	}

}
