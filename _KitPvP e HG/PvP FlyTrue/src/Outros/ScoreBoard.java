package Outros;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import APIs.SimpleScoreboard;
import Main.Main;
import Utils.KillsDeathsMoney;
import Utils.KitAPI;

public class ScoreBoard implements Listener {
	
	public static Scoreboard getScoreBoard() {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		return board;
	}
	public static Main plugin;
	
	@SuppressWarnings({ "deprecation" })
	public static void UpdateScore(Player p) {
		int online = Bukkit.getOnlinePlayers().length;
		int kills = KillsDeathsMoney.getKills(p);
		int deaths = KillsDeathsMoney.getDeaths(p);
		int coins = KillsDeathsMoney.getMoney(p);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable() {
			@Override
			public void run() {
				SimpleScoreboard scoreboard = new SimpleScoreboard("§c§lFly§7§lTrue");
				scoreboard.add("     §7flytrue.com.br");
				scoreboard.blankLine();
				scoreboard.add("§aKills ➜ §7" + kills);
				scoreboard.add("§aDeaths ➜ §7" + deaths);
				scoreboard.blankLine();
				scoreboard.add("§9Kit ➜ §7" + KitAPI.getKit(p));
				scoreboard.blankLine();
				scoreboard.add("§dCoins ➜ §7" + coins);
				scoreboard.add("§bOnline ➜ §7" + online + "/" + Bukkit.getMaxPlayers());
				scoreboard.blankLine();
				scoreboard.add("§7/score");
				scoreboard.build();
				scoreboard.send(p);
			}
		}, 5L);
		
	}
	public static void clearScoreboard(Player p) {
		getScoreBoard().clearSlot(DisplaySlot.SIDEBAR);
		p.setScoreboard(getScoreBoard());
	}
}
