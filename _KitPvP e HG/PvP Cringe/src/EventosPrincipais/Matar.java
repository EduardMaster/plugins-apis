package EventosPrincipais;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import Outros.ScoreBoard;
import Utils.KillsDeathsMoney;
import Utils.KitAPI;
import Utils.WarpsAPI;

public class Matar implements Listener {
	
	@EventHandler
	public void Matança(PlayerDeathEvent e ) {
		Player p = e.getEntity();
		WarpsAPI.ir(p, "spawn");
		if (e.getEntity().getKiller() instanceof Player) {
			Player t = (Player)p.getKiller();
			KillsDeathsMoney.addDeaths(p, 1);
			KillsDeathsMoney.addKill(t, 1);
			KillsDeathsMoney.addMoney(t, 100);
			KillsDeathsMoney.removermoney(p, 60);
			KitAPI.RemoveKit(p);
			ScoreBoard.UpdateScore(p);
			ScoreBoard.UpdateScore(t);
			e.setDeathMessage(null);
			p.sendMessage("§3§lKILL §fVoce morreu para " + t.getDisplayName());
			t.sendMessage("§3§lKILL §fVoce matou " + p.getDisplayName());
		} else {
			ScoreBoard.UpdateScore(p);
			KitAPI.RemoveKit(p);
			e.setDeathMessage(null);
			p.sendMessage("§3§lKILL §fVocê morreu");
		}
	}

}
