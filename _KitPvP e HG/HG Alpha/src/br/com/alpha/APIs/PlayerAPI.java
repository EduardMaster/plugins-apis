package br.com.alpha.APIs;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class PlayerAPI {
	
	private HashMap<Player, String> nome = new HashMap<>();
	
	private static PlayerAPI instance = new PlayerAPI();
	
	public static PlayerAPI getInstance() {
		return instance;
	}
	
	public void setOriginalName(Player p, String nome) {
		this.nome.put(p, nome);
	}
	
	public String getOriginalName(Player p) {
		return this.nome.get(p);
	}

}
