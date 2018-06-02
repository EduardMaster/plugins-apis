package Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import Utils.TagsAPI;

public class Tag implements CommandExecutor, Listener {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("Comando apenas para jogadores");
			return true;
		}
		Player p = (Player) sender;
		if(args.length == 0) {
			if(p.hasPermission("tag.admin")) {
				p.sendMessage("§fUse /tag §7NORMAL §eBETA §aVIP §9MVP §6PRO §bYOUTUBER §2BUILDER §dTRIAL §5MOD §cADMIN §4SUBDONO §4DONO");
				return true;
			}
			if(p.hasPermission("tag.mod")) {
				p.sendMessage("§fUse /tag §7NORMAL §eBETA §aVIP §9MVP §6PRO §bYOUTUBER §2BUILDER §dTRIAL §5MOD §cADMIN §4SUBDONO §4DONO");
				return true;
			}
			if(p.hasPermission("tag.trial")) {
				p.sendMessage("§fUse /tag §7NORMAL §eBETA §aVIP §9MVP §6PRO §bYOUTUBER §2BUILDER §dTRIAL §5MOD §cADMIN §4SUBDONO §4DONO");
				return true;
			}
			if(p.hasPermission("tag.youtuber")) {
				p.sendMessage("§fUse /tag §7NORMAL §eBETA §aVIP §9MVP §6PRO §bYOUTUBER §2BUILDER §dTRIAL §5MOD §cADMIN §4SUBDONO §4DONO");
				return true;
			}
			if(p.hasPermission("tag.pro")) {
				p.sendMessage("§fUse /tag §7NORMAL §eBETA §aVIP §9MVP §6PRO §bYOUTUBER §2BUILDER §dTRIAL §5MOD §cADMIN §4SUBDONO §4DONO");
				return true;
			}
			if(p.hasPermission("tag.mvp")) {
				p.sendMessage("§fUse /tag §7NORMAL §eBETA §aVIP §9MVP §6PRO §bYOUTUBER §2BUILDER §dTRIAL §5MOD §cADMIN §4SUBDONO §4DONO");
				return true;
			}
			if(p.hasPermission("tag.vip")) {
				p.sendMessage("§fUse /tag §7NORMAL §eBETA §aVIP §9MVP §6PRO §bYOUTUBER §2BUILDER §dTRIAL §5MOD §cADMIN §4SUBDONO §4DONO");
				return true;
			}
			p.sendMessage("§fUse /tag §7NORMAL §eBETA §aVIP §9MVP §6PRO §bYOUTUBER §2BUILDER §dTRIAL §5MOD §cADMIN §4SUBDONO §4DONO");
			return true;
		}
		if(p.hasPermission("tag.dono")) {
			if(args[0].equalsIgnoreCase("dono")) {
				TagsAPI.setarTag(p, "§4§lDONO §4");
				p.setPlayerListName("§4" + p.getName());
				p.sendMessage("Tag alterada");
				
				return true;
			 }
			}
		if (p.hasPermission("tag.admin")) {
			if(args[0].equalsIgnoreCase("admin")) {
				TagsAPI.setarTag(p, "§c§lADMIN §c");
				p.setPlayerListName("§c" + p.getName());
				p.sendMessage("Tag alterada");
				
				return true;
			 }
			}
		if (p.hasPermission("tag.subdono")) {
			if(args[0].equalsIgnoreCase("subdono")) {
				TagsAPI.setarTag(p, "§c§lSUB§4DONO §4");
				p.setPlayerListName("§4" + p.getName());
				p.sendMessage("Tag alterada");
				
				return true;
			 }
			}
		     if (p.hasPermission("tag.mod")) {
			 if(args[0].equalsIgnoreCase("mod")) {
				TagsAPI.setarTag(p, "§5§lMOD §5");
				p.setPlayerListName("§5" + p.getName());
				p.sendMessage("Tag alterada");
				
				return true;
			 }
			}
		     if (p.hasPermission("tag.trial")) {
			 if(args[0].equalsIgnoreCase("trial")) {
				TagsAPI.setarTag(p, "§d§lTRIAL §d");
				p.setPlayerListName("§d" + p.getName());
				p.sendMessage("Tag alterada");
				
				return true;
			 }
			}
		     if (p.hasPermission("tag.builder")) {
			 if(args[0].equalsIgnoreCase("builder")) {
				TagsAPI.setarTag(p, "§2§lBUILDER §2");
				p.setPlayerListName("§2" + p.getName());
				p.sendMessage("Tag alterada");
				
				return true;
			 }
			}
		     if (p.hasPermission("tag.youtuber")) {
			 if(args[0].equalsIgnoreCase("youtuber")) {
				TagsAPI.setarTag(p, "§b§lYOUTUBER §b");
				p.setPlayerListName("§b" + p.getName());
				p.sendMessage("Tag alterada");
				
				return true;
			 }
			}
		     if (p.hasPermission("tag.pro")) {
			 if(args[0].equalsIgnoreCase("pro")) {
				TagsAPI.setarTag(p, "§6§lPRO §6");
				p.setPlayerListName("§6" + p.getName());
				p.sendMessage("Tag alterada");
				
				return true;
			 }
			}
		     if (p.hasPermission("tag.mvp")) {
			 if(args[0].equalsIgnoreCase("mvp")) {
				TagsAPI.setarTag(p, "§9§lMVP §9");
				p.setPlayerListName("§9" + p.getName());
				p.sendMessage("Tag alterada");
				
				return true;
			 }
			}
		     if (p.hasPermission("tag.vip")) {
			 if(args[0].equalsIgnoreCase("vip")) {
				TagsAPI.setarTag(p, "§a§lVIP §a");
				p.setPlayerListName("§a" + p.getName());
				p.sendMessage("Tag alterada");
				
				return true;
			 }
			}
		     if (p.hasPermission("tag.normal")) {
			 if(args[0].equalsIgnoreCase("normal")) {
				TagsAPI.setarTag(p, "§7§lNormal §7");
				p.setPlayerListName("§7" + p.getName());
				p.sendMessage("Tag alterada");
				
				return true;
			 }
			}
		return false;
	}
}
