package br.com.alpha.ENUMs;

public enum Success {

	TELEPORTE("§7Você foi teleportado com sucesso!");

	private String msg;

	private Success(String msg) {
		this.msg = msg;
	}

	public String msg() {
		return this.msg;
	}
}
