package br.com.alpha.Comandos;

import java.util.ArrayList;
import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import br.com.alpha.MCAlpha;
import br.com.alpha.APIs.APIClass;
import br.com.alpha.ENUMs.KitsEnum;
import br.com.alpha.gamemanagement.GameTime;

public class Desistir implements CommandExecutor {

	public static HashSet<Player> admin = new HashSet<>();
	public static boolean desistir= false;
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String a, String[] args) {
		Player p = (Player)sender;
		if(a.equalsIgnoreCase("admin")) {
			if (!p.hasPermission("alpha.trial")||!p.hasPermission("alpha.mod")||!p.hasPermission("alpha.modplus")||!p.hasPermission("alpha.admin")) {
				return true;
			}
			if (!admin.contains(p)) {
				admin.add(p);
				for (Player all: Bukkit.getOnlinePlayers()) {
					all.hidePlayer(p);
				}
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				APIClass.JogadoresInGame.remove(p.getUniqueId());
				APIClass.moderadores.add(p.getUniqueId());
				APIClass.espectadores.remove(p.getUniqueId());
				p.setGameMode(GameMode.CREATIVE);
				KitsEnum.setKit(p, KitsEnum.NONE);
				p.sendMessage("§cVocê entrou no modo admin.");
				return true;
			}
			if (admin.contains(p)) {
				admin.remove(p);
				for (Player all: Bukkit.getOnlinePlayers()) {
					all.showPlayer(p);
				}
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				KitsEnum.setKit(p, KitsEnum.NONE);
				APIClass.JogadoresInGame.add(p.getUniqueId());
				APIClass.moderadores.remove(p.getUniqueId());
				APIClass.espectadores.remove(p.getUniqueId());
				p.setGameMode(GameMode.SURVIVAL);
				p.sendMessage("§cVocê saiu do modo admin.");
				return true;
			}
			
		}
		if (a.equalsIgnoreCase("desistir")) {
			if (MCAlpha.Status != GameTime.INGAME) {
				p.sendMessage("§cSó é possivel utilizar este comando no estado de jogo.");
				return true;
			}
			if (desistir == true) {
				return true;
			}else
			if (!p.hasPermission("alpha.espectar")) {
			APIClass.JogadoresInGame.remove(p.getUniqueId());
			Bukkit.broadcastMessage("§8⦗§e§l!§8⦘ §6" + p.getName() + "§8(§b" + KitsEnum.getKit(p) + "§8) §7Desistiu.");
			p.kickPlayer("§cVocê desistiu do jogo.");
		}else {
			if (p.hasPermission("alpha.trial")||p.hasPermission("alpha.mod")||p.hasPermission("alpha.modplus")||p.hasPermission("alpha.admin")) {
				APIClass.moderadores.add(p.getUniqueId());
				APIClass.JogadoresInGame.remove(p.getUniqueId());
				APIClass.espectadores.remove(p.getUniqueId());
				p.setGameMode(GameMode.CREATIVE);
				for (Player all : Bukkit.getOnlinePlayers()) {
					all.hidePlayer(p);
				}
			}
			APIClass.JogadoresInGame.remove(p.getUniqueId());
			APIClass.espectadores.add(p.getUniqueId());
			Bukkit.broadcastMessage("§8⦗§e§l!§8⦘ §6" + p.getName() + "§8(§b" + KitsEnum.getKit(p) + "§8) §7Desistiu.");
			for (Player all : Bukkit.getOnlinePlayers()) {
				all.hidePlayer(p);
				p.setAllowFlight(true);
				p.getInventory().clear();
			}
			p.setAllowFlight(true);
			p.getInventory().clear();
			p.getInventory().setItem(4, new ItemStack(Material.BOOK));
			if (p.getItemInHand().getType() == Material.BOOK) {
				Inventory inv = Bukkit.createInventory(p, 54, "§aJogadores");
				for (Player jogadores : Bukkit.getOnlinePlayers()) {
					if (APIClass.JogadoresInGame.contains(jogadores)) {
						ItemStack stack = new ItemStack(Material.SKULL_ITEM);
						ItemMeta meta = stack.getItemMeta();
						meta.setDisplayName("§a" + jogadores.getName());
						ArrayList<String> lore = new ArrayList<>();
						lore.add("§aKit: " + KitsEnum.getKit(jogadores));
						stack.setItemMeta(meta);
						inv.addItem(stack);
					}
				}
			
				p.openInventory(inv);
			}
		}
			
		}
		return false;
	}
	

}
