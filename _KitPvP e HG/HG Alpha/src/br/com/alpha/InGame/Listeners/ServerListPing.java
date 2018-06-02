package br.com.alpha.InGame.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import br.com.alpha.MCAlpha;
import br.com.alpha.APIs.APIClass;
import br.com.alpha.gamemanagement.GameTime;

public class ServerListPing implements Listener {

	@EventHandler
	public void motd(ServerListPingEvent e) throws IllegalArgumentException, UnsupportedOperationException, Exception {
		e.setMotd("§e§lAlpha§f§lNetwork §7> §aHardcoreGames \n" + loadMotd());
	}

	public String loadMotd() {
		if (MCAlpha.Status == GameTime.PREGAME) {
			Integer conta = MCAlpha.needPlayers - APIClass.JogadoresInGame.size();
			return APIClass.JogadoresInGame.size() < MCAlpha.needPlayers
					? "§7Esperando §e" + conta + " §7jogadores para o início do jogo."
					: "§bO PreGame irá acabar em: §c" + APIClass.formatDifferenceStr(MCAlpha.Time * 1000L);
		} else if (MCAlpha.Status == GameTime.INVENCIBILIDADE) {
			return "§aA invencibilidade acabará em §c" + APIClass.formatDifferenceStr(MCAlpha.Time * 1000);
		} else if (MCAlpha.Status == GameTime.INGAME) {
			return "§cA partida já está acontecendo faz §f" + APIClass.formatDifferenceStr(MCAlpha.Time * 1000);
		}
		return null;
	}

}
