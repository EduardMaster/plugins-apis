package br.com.alpha.Invencibilidade;

import java.util.List;
import java.util.UUID;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class InvencibilidadeEventAPI extends Event {
	private static final HandlerList handlers = new HandlerList();

	private List<UUID> jogadoresVivos;;

	public InvencibilidadeEventAPI(List<UUID> jogadoresVivos) {
		this.jogadoresVivos = jogadoresVivos;
	}

	public List<UUID> getParticipantes() {
		return this.jogadoresVivos;
	}

	public Integer getParticipantesNr() {
		return this.jogadoresVivos.size();
	}

	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}
