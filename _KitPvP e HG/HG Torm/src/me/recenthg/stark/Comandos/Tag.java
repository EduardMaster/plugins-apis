package me.recenthg.stark.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

import ca.wacos.nametagedit.NametagAPI;
import me.recenthg.stark.Manager.Title;


public class Tag implements CommandExecutor {
	@EventHandler
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§7Comandos apenas no servidor!");
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("tag")) {
			if (args.length == 0) {
				if (p.hasPermission("*")) {
					p.sendMessage(
							"§7[§6TAG§7]: §7[§fNORMAL, §aVIP, §6PRO, §bYT, §3SUBDONO, §dTRIAL, §5MOD, §cADM, §4DONO§7]");
					return true;
				}
				if (p.hasPermission("Tag.Admin")) {
					p.sendMessage("§7[§6TAG§7]: §7[§fNORMAL, §aVIP, §6PRO, §3SUBDONO, §bYT, §dTRIAL, §5MOD, §cADM§7]");
					return true;
				}
				if (p.hasPermission("Tag.Mod")) {
					p.sendMessage("§7[§6TAG§7]: §7[§fNORMAL, §aVIP, §6PRO, §bYT, §dTRIAL, §5MOD§7]");
					return true;
				}
				if (p.hasPermission("Tag.Trial")) {
					p.sendMessage("§7[§6TAG§7]: §7[§fNORMAL, §aVIP, §6PRO, §bYT, §dTRIAL§7]");
					return true;
				}
				if (p.hasPermission("Tag.Subdono")) {
					p.sendMessage("§7[§6TAG§7]: §7[§fNORMAL, §aVIP, §6PRO, §3SUBDONO, §bYT, §dTRIAL, §5MOD]");
					return true;
				}
				if (p.hasPermission("Tag.Youtuber")) {
					p.sendMessage("§7[§6TAG§7]: §7[§fNORMAL, §aVIP, §6PRO, §bYT§7]");
					return true;
				}
				if (p.hasPermission("Tag.Pro")) {
					p.sendMessage("§7[§6TAG§7]: §7[§fNORMAL, §aVIP, §6PRO§7]");
					return true;
				}
			
				if (p.hasPermission("Tag.Vip")) {
					p.sendMessage("§7[§6TAG§7]: §7[fNORMAL, §aVIP§7]");
					return true;
				}
				if (p.hasPermission("Tag.Normal")) {
					p.sendMessage("§7[§6TAG§7]: §7[§fNORMAL§7]");
					return true;
				}
			}
			if ((args[0].toLowerCase().equalsIgnoreCase("dono")) && (p.hasPermission("tag.dono"))) {
				p.sendMessage("§7Sua tag foi alterada!");
				p.setPlayerListName("§4§o" + CMDListener.getMod(p.getName()));
				p.setDisplayName("§4" + p.getName());
				Title.sendTitle(p, "§a! §fTAG DONO §a!");
				   NametagAPI.setPrefix(p.getName(), "§4§o");
			}
			if ((args[0].toLowerCase().equalsIgnoreCase("admin")) && (p.hasPermission("tag.admin"))) {
				p.sendMessage("§7Sua tag foi alterada!");
				p.setPlayerListName("§c§o" + CMDListener.getMod(p.getName()));
				p.setDisplayName("§c" + p.getName());
				   NametagAPI.setPrefix(p.getName(), "§c§o");
				   Title.sendTitle(p, "§a! §fTAG ADMIN §a!");
			}
			if ((args[0].toLowerCase().equalsIgnoreCase("mod")) && (p.hasPermission("tag.mod"))) {
				p.sendMessage("§7Sua tag foi alterada!");
				p.setPlayerListName("§5§o" + CMDListener.getMod(p.getName()));
				p.setDisplayName("§5" + p.getName());
				   NametagAPI.setPrefix(p.getName(), "§5§o");
				   Title.sendTitle(p, "§a! §fTAG MOD §a!");
			}
			if ((args[0].toLowerCase().equalsIgnoreCase("subdono")) && (p.hasPermission("tag.subdono"))) {
				p.sendMessage("§7Sua tag foi alterada!");
				p.setPlayerListName("§3§o" + CMDListener.getMod(p.getName()));
				p.setDisplayName("§3" + p.getName());
				   NametagAPI.setPrefix(p.getName(), "§3§o");
				   Title.sendTitle(p, "§a! §fTAG SUBDONO §a!");
			}
			if ((args[0].toLowerCase().equalsIgnoreCase("trial")) && (p.hasPermission("tag.trial"))) {
				p.sendMessage("§7Sua tag foi alterada!");
				p.setPlayerListName("§d§o" + CMDListener.getMod(p.getName()));
				p.setDisplayName("§d" + p.getName());
				   NametagAPI.setPrefix(p.getName(), "§d§o");
				   Title.sendTitle(p, "§a! §fTAG TRIAL §a!");
			}
			if ((args[0].toLowerCase().equalsIgnoreCase("youtuber")) && (p.hasPermission("tag.youtuber"))) {
				p.sendMessage("§7Sua tag foi alterada!");
				p.setPlayerListName("§b§o" + CMDListener.getMod(p.getName()));
				p.setDisplayName("§b" + p.getName());
				   NametagAPI.setPrefix(p.getName(), "§b§o");
				   Title.sendTitle(p, "§a! §fTAG YOUTUBER §a!");
			}
			if ((args[0].toLowerCase().equalsIgnoreCase("pro")) && (p.hasPermission("tag.pro"))) {
				p.sendMessage("§7Sua tag foi alterada!");
				p.setPlayerListName("§6§o" + CMDListener.getMod(p.getName()));
				p.setDisplayName("§6" + p.getName());
				   NametagAPI.setPrefix(p.getName(), "§6§o");
				   Title.sendTitle(p, "§a! §fTAG PRO §a!");
			}
			if ((args[0].toLowerCase().equalsIgnoreCase("vip")) && (p.hasPermission("tag.vip"))) {
				p.sendMessage("§7Sua tag foi alterada!");
				p.setPlayerListName("§a§o" + CMDListener.getMod(p.getName()));
				p.setDisplayName("§a" + p.getName());
				   NametagAPI.setPrefix(p.getName(), "§a§o");
				   Title.sendTitle(p, "§a! §fTAG VIP §a!");
			}
			if ((args[0].toLowerCase().equalsIgnoreCase("normal")) && (p.hasPermission("tag.normal"))) {
				p.sendMessage("§7Sua tag foi alterada!");
				p.setPlayerListName("§7§o" + CMDListener.getMod(p.getName()));
				p.setDisplayName("§7" + p.getName());
				   NametagAPI.setPrefix(p.getName(), "§7§o");
				   Title.sendTitle(p, "§a! §fTAG NORMAL §a!");
			}
			return true;
		}
		return true;
	}
}