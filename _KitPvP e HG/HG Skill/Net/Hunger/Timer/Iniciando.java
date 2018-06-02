package Net.Hunger.Timer;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import Net.Hunger.Main;
import Net.Hunger.Habilidades.KangarooPreGame;
import Net.Hunger.Manager.Habilidade;
import Net.Hunger.Manager.IniciandoEvt;

public class Iniciando { 

	public static Scoreboard getScoreBoard() {
	ScoreboardManager manager = Bukkit.getScoreboardManager();
	Scoreboard board = manager.getNewScoreboard();
	return board;
	}
	 
	public static Integer ReIniciando = Integer.valueOf(180);
	public static ArrayList<String> RelogPreGame = new ArrayList<String>();
    private static Integer shed_id = null;
    public Objective o;
	
    public Iniciando() {
     if(Main.PreGame) {
	 shed_id = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.instance, new Runnable() {
		public void run() {     
	     if (Main.TimerIniciando > 0) {
	      if (Main.TimerIniciando >= 30 & Main.TimerIniciando % 30 == 0) {
	       for (Player pl : Bukkit.getOnlinePlayers()) {
	       pl.setHealth(20);
	       pl.setFoodLevel(20);
	       pl.setExp(0);
	       pl.setRemainingAir(20);
	       }
	       if ((Main.PreGame) && (Main.TimerIniciando == 180)) {
	       Bukkit.broadcastMessage("§7[§a!§7] A Partida inicia em " + ChatColor.WHITE + "3 Minutos!");
	       }
	       if ((Main.PreGame) && (Main.TimerIniciando == 120)) {
	       Bukkit.broadcastMessage("§7[§a!§7] A Partida inicia em " + ChatColor.WHITE + "2 Minutos!");
	       }
	       if ((Main.PreGame) && (Main.TimerIniciando == 60)) {
	 	   Bukkit.broadcastMessage("§7[§a!§7] A Partida inicia em " + ChatColor.WHITE + "1 Minuto!");
	       }
           if ((Main.PreGame) && (Main.TimerIniciando == 30)) {
     	   Bukkit.broadcastMessage("§7[§a!§7] A Partida inicia em " + ChatColor.WHITE + "30 Segundos!");
           }
           if((Main.PreGame) && (Main.TimerIniciando == 10)) {
     	   Bukkit.broadcastMessage("§7[§a!§7] A Partida inicia em " + ChatColor.WHITE + "10 Segundos!");
           }
	       } if ((Main.PreGame) && (Main.TimerIniciando < 6)) {
		   Bukkit.broadcastMessage("§7[§a!§7] A Partida inicia em " + ChatColor.WHITE + StringTimer.TimerGame(Integer.valueOf(Main.TimerIniciando)));
		   for(Player pl : Bukkit.getOnlinePlayers()) {
		   if(Main.Jogadores.contains(pl.getName())) {
		   pl.setAllowFlight(false);
		   pl.setFlying(false);
           IniciandoEvt.onTeleport();
		   pl.playSound(pl.getLocation(), Sound.CLICK, 1.0F, (byte) 1);
		   IniciandoEvt.Teleportar = true;
		   KangarooPreGame.Kangaroo = false;
           RelogPreGame.add(pl.getName());
	       pl.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 120, 50));
	       pl.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 120, 50));
	       pl.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 120, 1000));
		   }
		   }
	      }
	      Main.TimerIniciando--;
	      if(Main.PreGame) {
              for (Player p : Bukkit.getOnlinePlayers()) {
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
                  Score a12 = o.getScore("§aInicia:");
                  a12.setScore(2);
                  Score a13 = o.getScore("§f" + StringTimer.TimerGame(Main.TimerIniciando));
                  a13.setScore(1);
                  p.setScoreboard(board);
	       }
	      }
	     } else if ((Main.PreGame) && (Main.Jogadores.size() < Main.MinimoJogadores.intValue())) {
	       Main.TimerIniciando = ReIniciando.intValue();
		   Bukkit.broadcastMessage("§7[§a?§7] §7Contagem reiniciada aguardando §a5§7 jogadores.");
		   IniciandoEvt.Teleportar = false;
		   KangarooPreGame.Kangaroo = true;
	       for (Player pl : Bukkit.getOnlinePlayers()) {
	       if(Main.Jogadores.contains(pl.getName())) {
	       for (PotionEffect effect : pl.getActivePotionEffects()) {
	        pl.removePotionEffect(effect.getType());
	    	}
	       }
	       }
	    } else {
	     Main.IniciarPartida();
	     }
	    }
	   }, 0, 20);
	  }
	 }
	 public static void cancel() {
	  if(shed_id != null) {
	   Bukkit.getServer().getScheduler().cancelTask(shed_id);
	   shed_id = null;
	  }
	 }
	}