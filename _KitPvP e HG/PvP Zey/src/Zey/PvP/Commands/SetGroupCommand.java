package Zey.PvP.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Zey.PvP.Main.Main;


public class SetGroupCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("setgroup")) {
			if (!(sender.hasPermission("zey.pvp.setgroup"))) {
				sender.sendMessage("§cVocê não tem permissão para isso.");
				return true;
			}
			if(args.length == 1) {
				
			}
			if(args.length == 2) {
				String grupo = args[1];
				Player player = Bukkit.getPlayer(args[0]);
				if(grupo.equalsIgnoreCase("normal")) {
					p.sendMessage("§aO jogador " + player.getName() + " §ateve o grupo alterado para §7[NORMAL]");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " group set Normal");
					player.kickPlayer("§cAviso de alteração de grupo" + "\n" + "§fSeu grupo foi alterado para §7[NORMAL]§f." + "\n" + "§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
					return true;
				}
					if(grupo.equalsIgnoreCase("friend")) {
						p.sendMessage("§aO jogador " + player.getName() + " §ateve o grupo alterado para §a[FRIEND]");
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " group set Friend");
						player.kickPlayer("§cAviso de alteração de grupo" + "\n" + "§fSeu grupo foi alterado para §a[FRIEND]§f." + "\n" + "§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
						return true;
				}
					if(grupo.equalsIgnoreCase("youtuber")) {
						p.sendMessage("§aO jogador " + player.getName() + " §ateve o grupo alterado para §b[YOUTUBER]");
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " group set YouTuber");
						player.kickPlayer("§cAviso de alteração de grupo" + "\n" + "§fSeu grupo foi alterado para §b[YOUTUBER]§f." + "\n" + "§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
						return true;
				}
					if(grupo.equalsIgnoreCase("builder")) {
						p.sendMessage("§aO jogador " + player.getName() + " §ateve o grupo alterado para §2[BUILDER]");
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " group set Builder");
						player.kickPlayer("§cAviso de alteração de grupo" + "\n" + "§fSeu grupo foi alterado para  §2[BUILDER]§f." + "\n" + "§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
						return true;
				}
					if(grupo.equalsIgnoreCase("helper")) {
						p.sendMessage("§aO jogador " + player.getName() + " §ateve o grupo alterado para §d[HELPER]");
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " group set Helper");
						player.kickPlayer("§cAviso de alteração de grupo" + "\n" + "§fSeu grupo foi alterado para §d[HELPER]§f." + "\n" + "§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
						return true;
				}
					if(grupo.equalsIgnoreCase("trial")) {
						p.sendMessage("§aO jogador " + player.getName() + " §ateve o grupo alterado para §d[TRIAL]");
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " group set Trial");
						player.kickPlayer("§cAviso de alteração de grupo" + "\n" + "§fSeu grupo foi alterado para §d[TRIAL]§f." + "\n" + "§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
						return true;
				}
					if(grupo.equalsIgnoreCase("mod")) {
						p.sendMessage("§aO jogador " + player.getName() + " §ateve o grupo alterado para §5[MOD]");
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " group set Mod");
						player.kickPlayer("§cAviso de alteração de grupo" + "\n" + "§fSeu grupo foi alterado para §5[MOD]§f." + "\n" + "§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
						return true;
				}
					if(grupo.equalsIgnoreCase("admin")) {
						p.sendMessage("§aO jogador " + player.getName() + " §ateve o grupo alterado para §c[ADMIN]");
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " group set Admin");
						player.kickPlayer("§cAviso de alteração de grupo" + "\n" + "§fSeu grupo foi alterado para §c[ADMIN]§f." + "\n" + "§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
						return true;						
				}
					if(grupo.equalsIgnoreCase("gerente")) {
						p.sendMessage("§aO jogador " + player.getName() + " §ateve o grupo alterado para §c[GERENTE]");
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " group set Gerente");
						player.kickPlayer("§cAviso de alteração de grupo" + "\n" + "§fSeu grupo foi alterado para §c[ADMIN]§f." + "\n" + "§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
						return true;
				}
					if (sender.hasPermission("*"))
					if(grupo.equalsIgnoreCase("developer")) {
						p.sendMessage("§aO jogador " + player.getName() + " §ateve o grupo alterado para §3[DEVELOPER]");
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " group set Developer");
						player.kickPlayer("§cAviso de alteração de grupo" + "\n" + "§fSeu grupo foi alterado para §3[DEVELOPER]§f." + "\n" + "§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
						return true;
				}
					if(grupo.equalsIgnoreCase("subdona")) {
						p.sendMessage("§aO jogador " + player.getName() + " §ateve o grupo alterado para §4[SUB-DONA]");
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " group set SubDona");
						player.kickPlayer("§cAviso de alteração de grupo" + "\n" + "§fSeu grupo foi alterado para §4[SUB-DONA]§f." + "\n" + "§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
						return true;			
				}
					if (sender.hasPermission("*"))
					if(grupo.equalsIgnoreCase("subdono")) {
						p.sendMessage("§aO jogador " + player.getName() + " §ateve o grupo alterado para §4[SUB-DONO]");
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " group set SubDono");
						player.kickPlayer("§cAviso de alteração de grupo" + "\n" + "§fSeu grupo foi alterado para §4[SUB-DONO]§f." + "\n" + "§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
						return true;
				}
					if (sender.hasPermission("*"))
					if(grupo.equalsIgnoreCase("dona")) {
						p.sendMessage("§aO jogador " + player.getName() + " §ateve o grupo alterado para §4[DONA]");
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " group set Dona");
						player.kickPlayer("§cAviso de alteração de grupo" + "\n" + "§fSeu grupo foi alterado para §4[DONA]§f." + "\n" + "§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
						return true;			
				}
					if (sender.hasPermission("*"))
					if(grupo.equalsIgnoreCase("dono")) {
						p.sendMessage("§aO jogador " + player.getName() + " §ateve o grupo alterado para §4[DONO]");
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " group set Dono");
						player.kickPlayer("§cAviso de alteração de grupo" + "\n" + "§fSeu grupo foi alterado para §4[DONO]§f." + "\n" + "§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
						return true;
					}
				} else {
	                p.sendMessage(String.valueOf(Main.prefix) + " §7» §cErrado, utilize a sintaxe correta: /setgroup [Jogador(a)] [Grupo]");
					p.sendMessage("§cGrupos disponiveis§f: §7[NORMAL]§f, §a[FRIEND]§f, §b[YOUTUBER]§f, §2[BUILDER]§f, §d[HELPER]§f, §d[TRIAL]§f, §5[MOD]§f, §c[GERENTE]§f, §3[DEVELOPER]§f, §4[SUB-DONA]§f, §4[SUB-DONO]§f, §4[DONA]§f, §4[DONO]§f.");
					return true;
				}
				}
		return false;
	}
}
