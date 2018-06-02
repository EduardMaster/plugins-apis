package Zey.PvP.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Zey.PvP.Main.*;


public class SetVipCommand implements CommandExecutor {
	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("setvip")) {
			if (!(sender.hasPermission("zey.pvp.setvip"))) {
				sender.sendMessage("§cVocê não tem permissão para isso.");
				return true;
			}
			if(args.length == 0) {
				p.sendMessage(String.valueOf(Main.prefix) + " §7» §cErrado, utilize a sintaxe correta: /setvip [Jogador(a)] [Vip]");
				p.sendMessage("§cGrupos disponiveis§f: §7[NORMAL]§f, §a[VIP]§f, §9[MVP]§f, §6[PRO]§f, §e[SUPREMO]§f, §1[BETA]§f.");
				return true;
			}
			if(args.length == 1) {
				
			}
			if(args.length == 2) {
				String vipgroup = args[1];
				Player jogador = Bukkit.getPlayer(args[0]);
				
				if(vipgroup.equalsIgnoreCase("normal")) {
					p.sendMessage("§aO jogador " + jogador.getName() + " §ateve seu VIP removido.");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + jogador.getName() + " group set Normal");
					jogador.kickPlayer("§cSeu VIP foi removido." + "\n" + "§cSeu grupo foi alterado para §7[NORMAL]§c." + "\n" + "§aPara evitar prossíveis bugs você foi kickado, apenas relogue.");
					return true;
				}
				if(vipgroup.equalsIgnoreCase("vip")) {
					p.sendMessage("§aO jogador " + jogador.getName() + " §ateve o VIP §a[VIP] §asetado.");
					Bukkit.broadcastMessage("§aO jogador §f" + jogador.getName() + " §aativou o VIP §a[VIP]§a.");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + jogador.getName() + " group set Vip");
					jogador.kickPlayer("§cSeu VIP foi ativado com sucesso." + "\n" + "§cSeu grupo foi alterado para §a[VIP]§c." + "\n" + "\n" + "§aEntre novamente no servidor e seus benefícios/vantagens já estarao disponíveis." + "\n" + "\n" + "§cCaso os benefícios/vantagens, não estejam ativadas no Lobby, entre em nosso discord §fDiscord.me/ZeyNetwork §cE pessa para um Admin ou superior, ativa-lo.");
					return true;
				}
				if(vipgroup.equalsIgnoreCase("mvp")) {
					p.sendMessage("§aO jogador " + jogador.getName() + " §ateve o VIP §9[MVP] §asetado.");
					Bukkit.broadcastMessage("§aO jogador §f" + jogador.getName() + " §aativou o VIP §9[MVP]§a.");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + jogador.getName() + " group set Mvp");
					jogador.kickPlayer("§cSeu VIP foi ativado com sucesso." + "\n" + "§cSeu grupo foi alterado para §9[MVP]§c." + "\n" + "\n" + "§aEntre novamente no servidor e seus benefícios/vantagens já estarao disponíveis." + "\n" + "\n" + "§cCaso os benefícios/vantagens, não estejam ativadas no Lobby, entre em nosso discord §fDiscord.me/ZeyNetwork §cE pessa para um Admin ou superior, ativa-lo.");
					return true;
				}
				if(vipgroup.equalsIgnoreCase("pro")) {
					p.sendMessage("§aO jogador " + jogador.getName() + " §ateve o VIP §6[PRO] §asetado.");
					Bukkit.broadcastMessage("§aO jogador §f" + jogador.getName() + " §aativou o VIP §6[PRO]§a.");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + jogador.getName() + " group set Pro");
					jogador.kickPlayer("§cSeu VIP foi ativado com sucesso." + "\n" + "§cSeu grupo foi alterado para §6[PRO]§c." + "\n" + "\n" + "§aEntre novamente no servidor e seus benefícios/vantagens já estarao disponíveis." + "\n" + "\n" + "§cCaso os benefícios/vantagens, não estejam ativadas no Lobby, entre em nosso discord §fDiscord.me/ZeyNetwork §cE pessa para um Admin ou superior, ativa-lo.");
					return true;
				}
				if(vipgroup.equalsIgnoreCase("supremo")) {
					p.sendMessage("§aO jogador " + jogador.getName() + " §ateve o VIP §e[SUPREMO] §asetado.");
					Bukkit.broadcastMessage("§aO jogador §f" + jogador.getName() + " §aativou o VIP §e[SUPREMO]§a.");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + jogador.getName() + " group set Supremo");
					jogador.kickPlayer("§cSeu VIP foi ativado com sucesso." + "\n" + "§cSeu grupo foi alterado para §e[SUPREMO]§c." + "\n" + "\n" + "§aEntre novamente no servidor e seus benefícios/vantagens já estarao disponíveis." + "\n" + "\n" + "§cCaso os benefícios/vantagens, não estejam ativadas no Lobby, entre em nosso discord §fDiscord.me/ZeyNetwork §cE pessa para um Admin ou superior, ativa-lo.");
					return true;
				}
				if(vipgroup.equalsIgnoreCase("beta")) {
					p.sendMessage("§aO jogador " + jogador.getName() + " §ateve o VIP §1[BETA] §asetado.");
					Bukkit.broadcastMessage("§aO jogador §f" + jogador.getName() + " §aativou o VIP §1[BETA]§a.");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + jogador.getName() + " group set Beta");
					jogador.kickPlayer("§cSeu VIP foi ativado com sucesso." + "\n" + "§cSeu grupo foi alterado para §1[BETA]§c." + "\n" + "\n" + "§aEntre novamente no servidor e seus benefícios/vantagens já estarao disponíveis." + "\n" + "\n" + "§cCaso os benefícios/vantagens, não estejam ativadas no Lobby, entre em nosso discord §fDiscord.me/ZeyNetwork §cE pessa para um Admin ou superior, ativa-lo.");
					return true;
				}
	        }
		}
		return false;
	}
}
