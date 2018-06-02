package me.rafael.vinagre.KomboPvP.Listeners;







import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.ScoreboardManager;

public class Board
{
  public static void getScoreBoardManagerAPI(Player jogador)
  {
    ScoreboardManager scoreboardmanager = Bukkit.getScoreboardManager();
    org.bukkit.scoreboard.Scoreboard scoreboard = scoreboardmanager.getNewScoreboard();
    Objective objective = scoreboard.registerNewObjective("KitPvP", "dummy");
    objective.setDisplaySlot(DisplaySlot.SIDEBAR);
    objective.setDisplayName(ChatColor.GRAY + jogador.getName());
    
    int Kills = Config.getConfig().getStats().getInt("Stats." + jogador.getUniqueId() + ".Kills");
    int Deaths = Config.getConfig().getStats().getInt("Stats." + jogador.getUniqueId() + ".Deaths");
    int Streak = Config.getConfig().getStats().getInt("Stats." + jogador.getUniqueId() + ".Streak");
    
    Score a15 = objective.getScore(ChatColor.RESET + "§a ");
    a15.setScore(10);
    Score a14 = objective.getScore(ChatColor.GRAY + "Kills ");
    a14.setScore(9);
    Score a13 = objective.getScore(ChatColor.GREEN + "§ " + Kills);
    a13.setScore(8);
    Score a12 = objective.getScore(ChatColor.RESET + "§0 ");
    a12.setScore(7);
    Score a11 = objective.getScore(ChatColor.GRAY + "Deaths ");
    a11.setScore(6);
    Score a10 = objective.getScore(ChatColor.RED + "§ " + Deaths);
    a10.setScore(5);
    Score a9 = objective.getScore(ChatColor.RESET + "§1 ");
    a9.setScore(4);
    Score a8 = objective.getScore(ChatColor.GRAY + "Streak ");
    a8.setScore(3);
    Score a7 = objective.getScore(ChatColor.AQUA + "§" + Streak);
    a7.setScore(2);
    Score a6 = objective.getScore(ChatColor.RESET + "§2 ");
    a6.setScore(1);
    
    jogador.setScoreboard(scoreboard);
  }

public static void setScoreBoard(Player p) {
	// TODO Auto-generated method stub
	
}
}
