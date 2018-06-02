package br.com.alpha.pregame.listeners.Quit;

import org.bukkit.entity.Player;

import br.com.alpha.APIs.APIClass;

public class QuitAPI {

	public static void removeMatch(Player p) {
		APIClass.JogadoresInGame.remove(p.getUniqueId());
	}

}
