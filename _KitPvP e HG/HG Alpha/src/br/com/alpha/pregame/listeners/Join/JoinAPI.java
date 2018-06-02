package br.com.alpha.pregame.listeners.Join;

import java.util.Arrays;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import br.com.alpha.MCAlpha;
import br.com.alpha.APIs.APIClass;
import br.com.alpha.APIs.InventoryAPI;

public class JoinAPI {

	public static void loadItensToaPlayer(Player p) {
		InventoryAPI.clearInventory(p);
		InventoryAPI.setItemToaPlayer(p, InventoryAPI.newItemStack(Material.CHEST, 1, (byte) 0,
				Arrays.asList("§eEscolha o Kit desejado"), "§aKit Selector §7(Clique Direito)"), 0);
		InventoryAPI.setItemToaPlayer(p, InventoryAPI.newItemStack(Material.ENDER_CHEST, 1, (byte) 0,
				Arrays.asList("Veja seu status"), "§aSeu Status §7(Clique Direito)"), 2);
		InventoryAPI.setItemToaPlayer(p, InventoryAPI.newItemStack(Material.ENCHANTED_BOOK, 1, (byte) 0,
				Arrays.asList("Lista de ranks"), "§aRanks §7(Clique Direito)"), 4);
		InventoryAPI.setItemToaPlayer(p, InventoryAPI.newItemStack(Material.GOLD_INGOT, 1, (byte) 0,
				Arrays.asList("Abra o menu de loja do servidor"), "§aLoja §7(Clique Direito)"), 6);
		InventoryAPI.setItemToaPlayer(p, InventoryAPI.newItemStack(Material.PAPER, 1, (byte) 0,
				Arrays.asList("Mostra as novidades do servidor"), "§aNOVIDADES §7(Clique Direito)"), 8);
	}

	public static void sendJoinMessageToaPlayer(Player p) {
		p.sendMessage(MCAlpha.Logo + " §7Seja bem-vindo ao nosso servidor, §e" + p.getName() + ".");
	}

	public static void addInMatch(Player p) {
		APIClass.JogadoresInGame.add(p.getUniqueId());
	}

	public static void sendScoreBoard(Player p) {
	}

	public static void teleportToSpawn(Player p) {

		p.teleport(new Location(p.getWorld(), 80.5, 165, 76.5, 0.0F, 0.0F));
	}

}
