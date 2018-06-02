package nobody.comandos;

import java.util.ArrayList;

import nobody.scoreboard.Scoreboards;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Score extends Scoreboards implements CommandExecutor {

	public static ArrayList<String> temscore = new ArrayList<>();
	public static ArrayList<String> ntemscore = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("score")) {
			if (!ntemscore.contains(p.getName())) {
				ntemscore.add(p.getName());
				temscore.remove(p.getName());
				p.sendMessage("§7{§c§lSCORE§7} §7Score Adicionada");
			}else{
				temscore.add(p.getName());
				ntemscore.remove(p.getName());
				p.sendMessage("§7{§c§lSCORE§7} §7Score Removida");
			}
		}
		return false;
	}

}
