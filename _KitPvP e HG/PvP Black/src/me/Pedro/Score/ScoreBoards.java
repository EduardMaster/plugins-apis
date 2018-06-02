package me.Pedro.Score;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import me.Pedro.Main;
import me.Pedro.Eventos.API;
import me.Pedro.XP.XpM;

public class ScoreBoards {
	
	
	public static Scoreboard getScoreBoard() {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		return board;
	}
	  public static String Rank(Player p)
	  {
	    double a =   +  Main.plugin.getConfig().getInt(new StringBuilder("status.").append(p.getName().toLowerCase()).append(".kills").toString());
	    if (a <= 0.0D) {
	      return "Bronze V";
	    }
	    if (a <= 50.0D) {
	      return "Bronze IV";
	    }
	    if (a <= 100.0D) {
	      return "Bronze III";
	    }
	    if (a <= 150.0D) {
	      return "Bronze II";
	    }
	    if (a <= 200.0D) {
	      return "Bronze I";
	    }
	    if (a <= 250.0D) {
	      return "Prata V";
	    }
	    if (a <= 300.0D) {
	      return "Prata IV";
	    }
	    if (a <= 450.0D) {
		      return "Prata III";
		    }
		    if (a <= 500.0D) {
		      return "Prata II";
		    }
		    if (a <= 550.0D) {
		      return "Prata I";
		    }
		    if (a <= 600.0D) {
		      return "Ouro V";
		    }
		    if (a <= 650.0D) {
		      return "Ouro IV";
		    }
		    if (a <= 700.0D) {
		      return "Ouro III";
		    }
		    if (a <= 750.0D) {
		      return "Ouro II";
		    }
		    if (a <= 800.0D) {
			      return "Ouro I";
			    }
		    if (a <= 850.0D) {
			      return "Platina V";
			    }
			    if (a <= 900.0D) {
			      return "Platina IV";
			    }
			    if (a <= 950.0D) {
			      return "Platina III";
			    }
			    if (a <= 1000.0D) {
			      return "Platina II";
			    }
			    if (a <= 1050.0D) {
			      return "Platina I";
			    }
			    if (a <= 1100.0D) {
			      return "Desafiante V";
			    }
			    if (a <= 1150.0D) {
			      return "Desafiante IV";
			    }
			    if (a <= 1200.0D) {
				      return "Desafiante III";
				    }
			    if (a <= 1250.0D) {
				      return "Desafiante II";
				    }
				    if (a <= 1300.0D) {
				      return "Desafiante I";
				    }
	    return "Desafiante I";
	  }
	
	@SuppressWarnings({ "deprecation",  })
	public static void setScoreBoard(Player p) {
	      int ping = ((CraftPlayer)p).getHandle().ping;
			
		SimpleScoreboard board = new SimpleScoreboard("      "+ API.sev +"    ");
		board.add("§fMatou:§a " +  Main.plugin.getConfig().getInt(new StringBuilder("status.").append(p.getName().toLowerCase()).append(".kills").toString()));
		board.add("§fMorreu:§a " + Main.plugin.getConfig().getInt(new StringBuilder("status.").append(p.getName().toLowerCase()).append(".mortes").toString()));
		board.add("§fKs: §a" + p.getExpToLevel());
		board.add("§f");
		board.add("§fElo: §a" + Rank(p));
		board.add("§fKit: §a" + Habilidade.getAbility(p));
		board.add("§fNick: §a" + p.getName());
		board.add("§f");
		board.add("§fXP:§a " + XpM.getPlayerMoney(p));
		board.add("§fPing:§a " + ping);
		board.add("§fGrupo:§a DC");
		board.add("§f");
		board.add("§fServer:§a KitPvP");
		board.add("§f§l/Score");
		
		
			board.build();
			board.send(p);
			
	}
	
	public static void clearScoreboard(Player p) {
		getScoreBoard().clearSlot(DisplaySlot.SIDEBAR);
		p.setScoreboard(getScoreBoard());
	}

}
