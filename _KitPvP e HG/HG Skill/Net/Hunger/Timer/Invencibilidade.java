package Net.Hunger.Timer;

import java.text.SimpleDateFormat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Difficulty;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import Net.Hunger.Main;
import Net.Hunger.Eventos.ChecarVitoria;
import Net.Hunger.Manager.BarAPI;
import Net.Hunger.Manager.Habilidade;
import Net.Hunger.Manager.SimpleScoreboard;

public class Invencibilidade {
	
  private static Integer shed_id;
  
	public static Scoreboard getScoreBoard() {
    ScoreboardManager manager = Bukkit.getScoreboardManager();
	Scoreboard board = manager.getNewScoreboard();
	return board;
	}
    public static void resetScoreboard(Player p) {
    ScoreboardManager manager = Bukkit.getScoreboardManager();
    p.setScoreboard(manager.getNewScoreboard());
    }
    public Invencibilidade() {
    shed_id = Integer.valueOf(Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.instance, new Runnable() {
	public void run() {       
    if(Main.TimerInvencibilidade > 0) {
     if (((Main.TimerInvencibilidade >= 10 ? 1 : 0) & (
     Main.TimerInvencibilidade % 10 == 0 ? 1 : 0)) != 0) {
     if((Main.PreInvencibilidade) && (Main. TimerInvencibilidade == 60)) {
     ((World)Bukkit.getServer().getWorlds().get(0)).setDifficulty(Difficulty.PEACEFUL);
     Bukkit.broadcastMessage("§7[§a!§7] A Invencibilidade acaba em " + ChatColor.WHITE + "1 Minuto!");
     }
     if((Main.PreInvencibilidade) && (Main. TimerInvencibilidade == 30)) {
   	 Bukkit.broadcastMessage("§7[§a!§7] A Invencibilidade acaba em " + ChatColor.WHITE + "30 Segundos!");
     }
     if((Main.PreInvencibilidade) && (Main. TimerInvencibilidade == 10)) {
     Bukkit.broadcastMessage("§7[§a!§7] A Invencibilidade acaba em " + ChatColor.WHITE + "10 Segundos!");
     }
     } else if ((Main.PreInvencibilidade) && (Main.TimerInvencibilidade < 6)) {
     Bukkit.broadcastMessage("§7[§a!§7] A Invencibilidade acaba em " + ChatColor.WHITE + StringTimer.TimerGame(Integer.valueOf(Main.TimerInvencibilidade)));
     for (Player pl : Bukkit.getOnlinePlayers()) {
     pl.playSound(pl.getLocation(), Sound.CLICK, 1.0F, 1.0F);
     }
     }
     Main.TimerInvencibilidade --;
     if(Main.PreInvencibilidade) {
	  for(Player p : Bukkit.getOnlinePlayers()) {
            String kit = Habilidade.NomeDoKit(Habilidade.getAbility(p));
            Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective o = board.registerNewObjective("board", "SkillHG");
            o.setDisplayName("§c§o» §f§oSkill§a§oHG §c§o«");
            o.setDisplaySlot(DisplaySlot.SIDEBAR);
            Score a2 = o.getScore("§c");
            a2.setScore(9);
            Score a4 = o.getScore("§aJogadores:");
            a4.setScore(8);
            Score a5 = o.getScore("§f" + Main.Jogadores.size() + "/" + Bukkit.getServer().getMaxPlayers());
            a5.setScore(7);
            Score a6 = o.getScore("§6");
            a6.setScore(6);
            Score a7 = o.getScore("§aKit:");
            a7.setScore(5);
            Score a8 = o.getScore("§f" + kit);
            a8.setScore(4);
            Score a16 = o.getScore("§a");
            a16.setScore(3);
            Score a12 = o.getScore("§aInvencivel:");
            a12.setScore(2);
            Score a13 = o.getScore("§f" + StringTimer.TimerGame(Main.TimerInvencibilidade));
            a13.setScore(1);
            p.setScoreboard(board);
	    }
	   }
      } else {
    	Andamento.Iniciar(120);
    	Invencibilidade.cancel();
    	Bukkit.broadcastMessage("§7[§a!§7] §7Invencibilidade Acabou!");
        Bukkit.getServer().getWorld("world").setDifficulty(Difficulty.HARD);
        Main.PreInvencibilidade = false;
        Main.Partida = true;
        ChecarVitoria.verificaWin();
        for (Player pl : Bukkit.getOnlinePlayers()) {
         pl.playSound(pl.getLocation(), Sound.ANVIL_LAND, 30.0F, 30.0F);
     	 BarAPI.removeBar(pl);
         Invencibilidade.resetScoreboard(pl);
        }
        if(Main.Partida) {
        new Andamento();
        cancel();
         }
       }
      }
    }, 0L, 20L));
   }
  public static void cancel() {
  if(shed_id != null) {
   Bukkit.getServer().getScheduler().cancelTask(shed_id);
   shed_id = null;
   }
  }
 }