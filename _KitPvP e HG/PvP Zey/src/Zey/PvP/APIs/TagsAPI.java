package Zey.PvP.APIs;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import ca.wacos.nametagedit.NametagAPI;
import Zey.PvP.Main.*;

public class TagsAPI implements Listener {
	public static void setarTag(Player p ,String tag) {
		new BukkitRunnable() {
			@Override
			public void run() {
				p.setDisplayName(tag + p.getName());
				NametagAPI.setPrefix(p.getName(), tag);
			}
		}.runTaskAsynchronously(Main.getInstace());
	}
	@EventHandler
	public void tag(PlayerJoinEvent e) {
		new BukkitRunnable() {
			@Override
			public void run() {
				Player p = e.getPlayer();
				if (p.getName().equalsIgnoreCase("OwZey")) {
					setarTag(p, "§4[DONO]§7 ");
					NametagAPI.setPrefix(p.getName(), "§4[DONO]§7 ");
					return;
				}
				if (p.getName().equalsIgnoreCase("Neewaska_") || p.getName().equalsIgnoreCase("OwCry")) {
					setarTag(p, "§4[DONA]§7 ");
					NametagAPI.setPrefix(p.getName(), "§4[DONA]§7 ");
					return;
				}
				if(p.hasPermission("grupo.dono")) {
					setarTag(p, "§4[DONO]§7 ");
					NametagAPI.setPrefix(p.getName(), "§4[DONO]§7 ");
					return;
				}
				if(p.hasPermission("grupo.dona")) {
					setarTag(p, "§4[DONA]§7 ");
					NametagAPI.setPrefix(p.getName(), "§4[DONA]§7 ");
					return;
				}
				if(p.hasPermission("grupo.subdono")) {
					setarTag(p, "§4[SUB-DONO]§7 ");
					NametagAPI.setPrefix(p.getName(), "§4[SUB-DONO]§7 ");
					return;
				}
				if(p.hasPermission("grupo.subdona")) {
					setarTag(p, "§4[SUB-DONA]§7 ");
					NametagAPI.setPrefix(p.getName(), "§4[SUB-DONA]§7 ");
					return;
				}
				if(p.hasPermission("grupo.developer")) {
					setarTag(p, "§3[DEVELOPER]§7 ");
					NametagAPI.setPrefix(p.getName(), "§3[DEVELOPER]§7 ");
					return;
				}
				if(p.hasPermission("grupo.gerente")) {
					setarTag(p, "§c[GERENTE]§7 ");
					NametagAPI.setPrefix(p.getName(), "§c[GERENTE]§7 ");
					return;
				}
				if(p.hasPermission("grupo.admin")) {
					setarTag(p, "§c[ADMIN]§7 ");
					NametagAPI.setPrefix(p.getName(), "§c[ADMIN]§7 ");
					return;
				}
				if(p.hasPermission("grupo.mod")) {
					setarTag(p, "§5[MOD]§7 ");
					NametagAPI.setPrefix(p.getName(), "§5[MOD]§7 ");
					return;
				}
				if(p.hasPermission("grupo.trial")) {
					setarTag(p, "§d[TRIAL]§7 ");
					NametagAPI.setPrefix(p.getName(), "§d[TRIAL]§7 ");
					return;
				}
				if(p.hasPermission("grupo.helper")) {
					setarTag(p, "§d[HELPER]§7 ");
					NametagAPI.setPrefix(p.getName(), "§d[HELPER]§7 ");
					return;
				}
				if(p.hasPermission("grupo.builder")) {
					setarTag(p, "§2[BUILDER]§7 ");
					NametagAPI.setPrefix(p.getName(), "§2[BUILDER]§7 ");
					return;
				}
				if(p.hasPermission("grupo.youtuber")) {
					setarTag(p, "§b[YOUTUBER]§7 ");
					NametagAPI.setPrefix(p.getName(), "§b[YOUTUBER]§7 ");
					return;
				}
				if(p.hasPermission("grupo.friend")) {
					setarTag(p, "§a[FRIEND]§7 ");
					NametagAPI.setPrefix(p.getName(), "§a[FRIEND]§7 ");
					return;
				}
				if(p.hasPermission("grupo.beta")) {
					setarTag(p, "§1[BETA]§7 ");
					NametagAPI.setPrefix(p.getName(), "§1[BETA]§7 ");
					return;
				}
				if(p.hasPermission("grupo.supremo")) {
					setarTag(p, "§e[SUPREMO]§7 ");
					NametagAPI.setPrefix(p.getName(), "§e[SUPREMO]§7 ");
					return;
				}
				if(p.hasPermission("grupo.pro")) {
					setarTag(p, "§6[PRO]§7 ");
					NametagAPI.setPrefix(p.getName(), "§6[PRO]§7 ");
					return;
				}
				if(p.hasPermission("grupo.mvp")) {
					setarTag(p, "§9[MVP]§7 ");
					NametagAPI.setPrefix(p.getName(), "§9[MVP]§7 ");
					return;
				}
				if(p.hasPermission("grupo.vip")) {
					setarTag(p, "§a[VIP]§7 ");
					NametagAPI.setPrefix(p.getName(), "§a[VIP]§7 ");
					return;
				}
				if(p.hasPermission("grupo.normal")) {
					setarTag(p, "§7");
					p.setPlayerListName("§7" + p.getName());
					return;
				}
				setarTag(p, "§7");
				p.setPlayerListName("§7" + p.getName());
				return;
				
			}
		}.runTaskAsynchronously(Main.getInstace());
	}
}
