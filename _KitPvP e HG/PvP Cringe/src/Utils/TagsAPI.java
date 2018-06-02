package Utils;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import Main.Main;
import ca.wacos.nametagedit.NametagAPI;

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
				if(p.hasPermission("tag.dono")) {
					setarTag(p, "§4§lDONO §4");
					p.setPlayerListName("§4§lDONO§4 " + p.getName());
					return;
				}
				if(p.hasPermission("tag.admin")) {
					setarTag(p, "§c§lADMIN §c");
					p.setPlayerListName("§c" + p.getName());
					return;
				}
				if(p.hasPermission("tag.subdono")) {
					setarTag(p, "§c§lSUB§4DONO §4");
					p.setPlayerListName("§4" + p.getName());
					return;
				}
				if(p.hasPermission("tag.mod")) {
					setarTag(p, "§5§lMOD §5");
					p.setPlayerListName("§5" + p.getName());
					return;
				}
				if(p.hasPermission("tag.trial")) {
					setarTag(p, "§d§lTRIAL §d");
					p.setPlayerListName("§d" + p.getName());
					return;
				}
				if(p.hasPermission("tag.builder")) {
					setarTag(p, "§2§lBUILDER §2");
					p.setPlayerListName("§2" + p.getName());
					return;
				}
				if(p.hasPermission("tag.youtuber")) {
					setarTag(p, "§b§lYOUTUBER §b");
					p.setPlayerListName("§b" + p.getName());
					return;
				}
				if(p.hasPermission("tag.pro")) {
					setarTag(p, "§6§lPRO §6");
					p.setPlayerListName("§6" + p.getName());
					return;
				}
				if(p.hasPermission("tag.mvp")) {
					setarTag(p, "§9§lMVP §9");
					p.setPlayerListName("§9" + p.getName());
					return;
				}
				if(p.hasPermission("tag.vip")) {
					setarTag(p, "§a§lVIP §a");
					p.setPlayerListName("§a" + p.getName());
					return;
				}
				if(p.hasPermission("tag.normal")) {
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
