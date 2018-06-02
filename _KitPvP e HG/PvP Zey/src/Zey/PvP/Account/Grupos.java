package Zey.PvP.Account;

import org.bukkit.entity.Player;

public class Grupos {
	
	public static String getGrupos(Player p) {
		if (p.getName().equalsIgnoreCase("Neewaska_") || p.getName().equalsIgnoreCase("OwCry")) {
			return "§4[DONA]";
		}
		if (p.hasPermission("grupo.dono")) {
			return "§4[DONO]";
		}
		if (p.hasPermission("grupo.dona")) {
			return "§4[DONA]";
		}
		if (p.hasPermission("grupo.subdono")) {
			return "§4[SUB-DONO]";
		}
		if (p.hasPermission("grupo.subdona")) {
			return "§4[SUB-DONA]";
		}
		if (p.hasPermission("grupo.developer")) {
			return "§3[DEVELOPER]";
		}
		if (p.hasPermission("grupo.gerente")) {
			return "§c[GERENTE]";
		}
		if (p.hasPermission("grupo.admin")) {
			return "§c[ADMIN]";
		}
		if (p.hasPermission("grupo.mod")) {
			return "§5[MOD]";
		}
		if (p.hasPermission("grupo.trial")) {
			return "§d[TRIAL]";
		}
		if (p.hasPermission("grupo.helper")) {
			return "§d[HELPER]";
		}
		if (p.hasPermission("grupo.builder")) {
			return "§3[BUILDER]";
		}
		if (p.hasPermission("grupo.youtuber")) {
			return "§b[YOUTUBER]";
		}
		if (p.hasPermission("grupo.beta")) {
			return "§1[BETA]";
		}
		if (p.hasPermission("grupo.supremo")) {
			return "§6[SUPREMO]";
		}
		if (p.hasPermission("grupo.pro")) {
			return "§6[PRO]";
		}
		if (p.hasPermission("grupo.mvp")) {
			return "§9[MVP]";
		}
		if (p.hasPermission("grupo.vip")) {
			return "§a[VIP]";
		}
		if (p.hasPermission("grupo.normal")) {
			return "§7[NORMAL]";
		}
		return "§7[NORMAL]";
		}
}
