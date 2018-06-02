package br.com.alpha.ENUMs;

import org.bukkit.entity.Player;

public enum Prefix {

	TELEPORT("§a§lTELEPORTE ");

	private String prefix;

	private Prefix(String prefix) {
		this.prefix = prefix;
	}

	public void enviar(Player p, String msg) {
		p.sendMessage(this.prefix + msg);
	}
	public String msg(String msg){
		return this.prefix + msg;
	}

}
