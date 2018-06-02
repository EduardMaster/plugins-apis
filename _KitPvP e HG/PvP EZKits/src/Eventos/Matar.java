package Eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import Outros.ScoreBoard;
import Utils.KillDeathsMoney;
import Utils.KitAPI;

public class Matar implements Listener{
	
	@EventHandler
	public void Matanca(PlayerDeathEvent e) {
		Player p = e.getEntity();
		if (e.getEntity().getKiller() instanceof Player) {
			Player t = (Player)p.getKiller();
			KillDeathsMoney.addDeath(p);
			KillDeathsMoney.removeMoney(p);
			KillDeathsMoney.addKill(t);
			KillDeathsMoney.addMoney(t);
			KitAPI.RemoveKit(p);
			ScoreBoard.UpdateScore(p);
			ScoreBoard.UpdateScore(t);
			e.setDeathMessage(null);
			p.sendMessage("§c§lVoce Morreu Para§b§l" + t.getDisplayName());
			p.sendMessage("§c§l -60");
			t.sendMessage("§c§lVoce Matou o§b§l" + p.getDisplayName());
			t.sendMessage("§c§l +100");
		}else {
			KitAPI.RemoveKit(p);
			p.sendMessage("§c§lVoce Morreu");
		}
	}

}
