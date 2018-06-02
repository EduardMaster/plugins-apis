package Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


import Utils.KitAPI;

public class Kit implements CommandExecutor{
	
	@Override
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (!(sender instanceof Player)) {
			sender.sendMessage("Para usar isso tem que ser um player");
			return true;
		}
		Player p = (Player)sender;
		if (args.length == 0) {
			p.sendMessage("§c Use /Kit <nome do kit> ");
			return true;
		}else {
			if (args[0].equalsIgnoreCase("pvp")) {
				if (p.hasPermission("kit.pvp")) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.PvP(p);
						p.sendMessage("§7[§c!§7]§6Voce Pegou o Kit PvP");
			
						return true;
					}else{
						p.sendMessage("§c Voce ja pegou Kit");
						return true;
					}
				} else {
					p.sendMessage("§c Voce Não tem este kit");
					return true;
				}
			}
			
			if (args[0].equalsIgnoreCase("Sonic")) {
				if (p.hasPermission("kit.sonic")) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Sonic(p);
						p.sendMessage("§7[§c!§7]§6Voce Pegou o Kit Sonic");
			
						return true;
					}else{
						p.sendMessage("§c Voce ja pegou Kit");
						return true;
					}
				} else {
					p.sendMessage("§c Voce Não tem este kit");
					return true;
				}
			}


			
			if (args[0].equalsIgnoreCase("viper")) {
				if (p.hasPermission("kit.viper")) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Viper(p);
						p.sendMessage("§7[§c!§7]§6Voce Pegou o Kit Viper");
						
						return true;
					}else{
						p.sendMessage("§c Voce ja pegou Kit");
						return true;
					}
				} else {
					p.sendMessage("§c Voce Não tem este kit");
					return true;
				}
			}
			if (args[0].equalsIgnoreCase("Sonic")) {
				if (p.hasPermission("kit.sonic")) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Viper(p);
						p.sendMessage("§7[§c!§7]§6Voce Pegou o Kit Sonic");
						
						return true;
					}else{
						p.sendMessage("§c Voce ja pegou Kit");
						return true;
					}
				} else {
					p.sendMessage("§c Voce Não tem este kit");
					return true;
				}
			}
			
			if (args[0].equalsIgnoreCase("Terrorista")) {
				if (p.hasPermission("kit.terrorista")) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Terrorista(p);
						p.sendMessage("§7[§c!§7]§6Voce Pegou o Kit Terorista");
						
						return true;
					}else{
						p.sendMessage("§c Voce ja pegou Kit");
						return true;
					}
				} else {
					p.sendMessage("§c Voce Não tem este kit");
					return true;
				}
			}
		
			

			
			
			if (args[0].equalsIgnoreCase("kangaroo")) {
				if (p.hasPermission("kit.kangaroo")) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.kangaroo(p);
						p.sendMessage("§7[§c!§7]§6Voce Pegou o Kit Kangaroo");
						
						return true;
					}else{
						p.sendMessage("§c Voce ja pegou Kit");
						return true;
					}
				} else {
					p.sendMessage("§c Voce Não tem este kit");
					return true;
				}
			}
			
			
			if (args[0].equalsIgnoreCase("snail")) {
				if (p.hasPermission("kit.snail")) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Snail(p);
						p.sendMessage("§7[§c!§7]§6Voce Pegou o Kit Snail");
					
						return true;
					}else{
						p.sendMessage("§c Voce ja pegou Kit");
						return true;
					}
				} else {
					p.sendMessage("§c Voce Não tem este kit");
					return true;
				}
			}
			
			if (args[0].equalsIgnoreCase("fisherman")) {
				if (p.hasPermission("kit.fisherman")) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Fisherman(p);
						p.sendMessage("§7[§c!§7]§6Voce Pegou o Kit Fisherman");
						
						return true;
					}else{
						p.sendMessage("§c Voce ja pegou Kit");
						return true;
					}
				} else {
					p.sendMessage("§c Voce Não tem este kit");
					return true;
				}
			}
			
			if (args[0].equalsIgnoreCase("stomper")) {
				if (p.hasPermission("kit.stomper")) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Stomper(p);
						p.sendMessage("§7[§c!§7]§6Voce Pegou o Kit Stomper");
						
						return true;
					}else{
						p.sendMessage("§c Voce ja pegou Kit");
						return true;
					}
				} else {
					p.sendMessage("§c Voce Não tem este kit");
					return true;
				}
			}
			
			if (args[0].equalsIgnoreCase("viking")) {
				if (p.hasPermission("kit.viking")) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Viking(p);
						p.sendMessage("§7[§c!§7]§6Voce Pegou o Kit Viking");
						
						return true;
					}else{
						p.sendMessage("§c Voce ja pegou Kit");
						return true;
					}
				} else {
					p.sendMessage("§c Voce Não tem este kit");
					return true;
				}
			}
			
			if (args[0].equalsIgnoreCase("ninja")) {
				if (p.hasPermission("kit.ninja")) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Ninja(p);
						p.sendMessage("§7[§c!§7]§6Voce Pegou o Kit Ninja");
						
						return true;
					}else{
						p.sendMessage("§c Voce ja pegou Kit");
						return true;
					}
				} else {
					p.sendMessage("§c Voce Não tem este kit");
					return true;
				}
			}
			
			if (args[0].equalsIgnoreCase("Thor")) {
				if (p.hasPermission("kit.thor")) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Thor(p);
						p.sendMessage("§7[§c!§7]§6Voce Pegou o Kit thor");
						
						return true;
					}else{
						p.sendMessage("§c Voce ja pegou Kit");
						return true;
					}
				} else {
					p.sendMessage("§c Voce Não tem este kit");
					return true;
				}
			}
			if (args[0].equalsIgnoreCase("C4")) {
				if (p.hasPermission("kit.c4")) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.C4(p);
						p.sendMessage("§7[§c!§7]§6Voce Pegou o Kit C4");
						
						return true;
					}else{
						p.sendMessage("§c Voce ja pegou Kit");
						return true;
					}
				} else {
					p.sendMessage("§c Voce Não tem este kit");
					return true;
				}
			}
			if (args[0].equalsIgnoreCase("ForceField")) {
				if (p.hasPermission("kit.ff")) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.ForceField(p);
						p.sendMessage("§7[§c!§7]§6Voce Pegou o Kit FF");
						
						return true;
					}else{
						p.sendMessage("§c Voce ja pegou Kit");
						return true;
					}
				} else {
					p.sendMessage("§c Voce Não tem este kit");
					return true;
				}
			}
			if (args[0].equalsIgnoreCase("Deshfire")) {
				if (p.hasPermission("kit.ff")) {
					if (KitAPI.getKit(p) == "Nenhum") {
						KitAPI.Deshfire(p);
						p.sendMessage("§7[§c!§7]§6Voce Pegou o Kit Deshfire");
						
						return true;
					}else{
						p.sendMessage("§c Voce ja pegou Kit");
						return true;
					}
				} else {
					p.sendMessage("§c Voce Não tem este kit");
					return true;
				}
			}
			p.sendMessage("§c Esse Kit §7§6" + args[0] + " §c É Invalido");
	}
		return false;
	}
}
