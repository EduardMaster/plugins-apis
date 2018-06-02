package br.com.alpha.ScoreBoard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class APIScore {

	@SuppressWarnings("deprecation")
	public static void build(Player p) {
		Scoreboard score = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = score.registerNewObjective(p.getName(), "dummy");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.setDisplayName("     §6§l> §e§lKITPVP §6§l<   ");

		FastOfflinePlayer nada = new FastOfflinePlayer("§1");
		Team lnada = score.registerNewTeam("nada");
		lnada.addPlayer(nada);
		obj.getScore(nada).setScore(15);
	

		p.setScoreboard(score);

	}

	public static void update(final Scoreboard score, Player p) {

		Team nada = score.getTeam("nada");
		nada.setPrefix("§1");
		Team estado = score.getTeam("estado");
		estado.setPrefix(" §");
		

	}
}
