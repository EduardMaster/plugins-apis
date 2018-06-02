package Outros;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import Main.Main;
import Utils.KillDeathsMoney;

public class ScoreBoard {

	public static void UpdateScore(final Player p) {
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
				Objective o = board.registerNewObjective("EZKits", "dummy");
				o.setDisplayName("§4§kiii §6§lEZKits §4§kiii");
				o.setDisplaySlot(DisplaySlot.SIDEBAR);

				int kills = KillDeathsMoney.getKills(p);
				int deaths = KillDeathsMoney.getDeath(p);
				int money = KillDeathsMoney.getMoney(p);
				String name = p.getName();

				Score um = o.getScore(Bukkit.getOfflinePlayer("§6§6§6§6§6"));
				Score dois = o.getScore(Bukkit.getOfflinePlayer("§6Bem-Vindo"));
				Score treis = o.getScore(Bukkit.getOfflinePlayer(name));
				Score quatro = o.getScore(Bukkit.getOfflinePlayer("§2Kills"));
				Score cinco = o.getScore(Bukkit.getOfflinePlayer("§6§6§6 " + kills));
				Score seis = o.getScore(Bukkit.getOfflinePlayer("§2Deaths"));
				Score sete = o.getScore(Bukkit.getOfflinePlayer("§6§6§6" + deaths));
				Score oito = o.getScore(Bukkit.getOfflinePlayer("§2 XP"));
				Score nove = o.getScore(Bukkit.getOfflinePlayer("§6§6§6" + money));
				Score dez = o.getScore(Bukkit.getOfflinePlayer("§3Rank"));
				Score onze = o.getScore(Bukkit.getOfflinePlayer("EMBREVE"));

				um.setScore(10);
				dois.setScore(9);
				treis.setScore(8);
				quatro.setScore(7);
				cinco.setScore(6);
				seis.setScore(5);
				sete.setScore(4);
				oito.setScore(3);
				nove.setScore(2);
				dez.setScore(1);
				onze.setScore(0);
				p.setScoreboard(board);

			}

		}, 2L);
	}
}
