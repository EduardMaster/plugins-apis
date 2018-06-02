package Pedrao.ScoreB;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import Pedrao.Main;
import Pedrao.Eventos.Habilidade;
import Pedrao.XP.XpM;

public class ScoreDoBasic implements Listener {

	public static Main plugin;

	public static void setScoreBoard(Player p) {
	
		
		Random r = new Random();

		int animar = r.nextInt(12);

		if (animar == 1) {
			
			SimpleScoreboard scoreboard = new SimpleScoreboard("§0§LSoul§f§lNetwork");
			
			scoreboard.add("§7Sevidor : §6§lKitPvP");
			scoreboard.add("§7Matou :§6§l "  + Main.plugin.getConfig().getInt(new StringBuilder("status.").append(p.getName().toLowerCase()).append(".kills").toString()));
			scoreboard.add("§7Morreu :§6§l "  + Main.plugin.getConfig().getInt(new StringBuilder("status.").append(p.getName().toLowerCase()).append(".mortes").toString()));
			scoreboard.blankLine();
			scoreboard.add("§7Kit :§6§l " + Habilidade.getAbility(p));
			scoreboard.add("§7XP§7 : §6§l" + XpM.getPlayerMoney(p));
			scoreboard.blankLine();
			scoreboard.add("§a/score");	
			scoreboard.build();
			scoreboard.send(p);
		}

		if (animar == 2) {

			SimpleScoreboard scoreboard = new SimpleScoreboard("§1§LSoul§f§lNetwork");
			
			scoreboard.add("§7Sevidor : §6§lKitPvP");
			scoreboard.add("§7Matou :§6§l "  + Main.plugin.getConfig().getInt(new StringBuilder("status.").append(p.getName().toLowerCase()).append(".kills").toString()));
			scoreboard.add("§7Morreu :§6§l "  + Main.plugin.getConfig().getInt(new StringBuilder("status.").append(p.getName().toLowerCase()).append(".mortes").toString()));
			scoreboard.blankLine();
			scoreboard.add("§7Kit :§6§l " + Habilidade.getAbility(p));
			scoreboard.add("§7XP§7 : §6§l" + XpM.getPlayerMoney(p));
			scoreboard.blankLine();
			scoreboard.add("§a/score");	
			scoreboard.build();
			scoreboard.send(p);
		}

		if (animar == 3) {
			
			SimpleScoreboard scoreboard = new SimpleScoreboard("§2§LSoul§f§lNetwork");
			
			scoreboard.add("§7Sevidor : §6§lKitPvP");
			scoreboard.add("§7Matou :§6§l "  + Main.plugin.getConfig().getInt(new StringBuilder("status.").append(p.getName().toLowerCase()).append(".kills").toString()));
			scoreboard.add("§7Morreu :§6§l "  + Main.plugin.getConfig().getInt(new StringBuilder("status.").append(p.getName().toLowerCase()).append(".mortes").toString()));
			scoreboard.blankLine();
			scoreboard.add("§7Kit :§6§l " + Habilidade.getAbility(p));
			scoreboard.add("§7XP§7 : §6§l" + XpM.getPlayerMoney(p));
			scoreboard.blankLine();
			scoreboard.add("§a/score");	
			scoreboard.build();
			scoreboard.send(p);
		}

		if (animar == 4) {
			
			SimpleScoreboard scoreboard = new SimpleScoreboard("§3§LSoul§f§lNetwork");
			
			scoreboard.add("§7Sevidor : §6§lKitPvP");
			scoreboard.add("§7Matou :§6§l "  + Main.plugin.getConfig().getInt(new StringBuilder("status.").append(p.getName().toLowerCase()).append(".kills").toString()));
			scoreboard.add("§7Morreu :§6§l "  + Main.plugin.getConfig().getInt(new StringBuilder("status.").append(p.getName().toLowerCase()).append(".mortes").toString()));
			scoreboard.blankLine();
			scoreboard.add("§7Kit :§6§l " + Habilidade.getAbility(p));
			scoreboard.add("§7XP§7 : §6§l" + XpM.getPlayerMoney(p));
			scoreboard.blankLine();
			scoreboard.add("§a/score");	
			scoreboard.build();
			scoreboard.send(p);
		}
		if (animar == 5) {
			SimpleScoreboard scoreboard = new SimpleScoreboard("§4§LSoul§f§lNetwork");
			
			scoreboard.add("§7Sevidor : §6§lKitPvP");
			scoreboard.add("§7Matou :§6§l "  + Main.plugin.getConfig().getInt(new StringBuilder("status.").append(p.getName().toLowerCase()).append(".kills").toString()));
			scoreboard.add("§7Morreu :§6§l "  + Main.plugin.getConfig().getInt(new StringBuilder("status.").append(p.getName().toLowerCase()).append(".mortes").toString()));
			scoreboard.blankLine();
			scoreboard.add("§7Kit :§6§l " + Habilidade.getAbility(p));
			scoreboard.add("§7XP§7 : §6§l" + XpM.getPlayerMoney(p));
			scoreboard.blankLine();
			scoreboard.add("§a/score");	
			scoreboard.build();
			scoreboard.send(p);
		}
		if (animar == 6) {
			SimpleScoreboard scoreboard = new SimpleScoreboard("§5§LSoul§f§lNetwork");
			
			scoreboard.add("§7Sevidor : §6§lKitPvP");
			scoreboard.add("§7Matou :§6§l "  + Main.plugin.getConfig().getInt(new StringBuilder("status.").append(p.getName().toLowerCase()).append(".kills").toString()));
			scoreboard.add("§7Morreu :§6§l "  + Main.plugin.getConfig().getInt(new StringBuilder("status.").append(p.getName().toLowerCase()).append(".mortes").toString()));
			scoreboard.blankLine();
			scoreboard.add("§7Kit :§6§l " + Habilidade.getAbility(p));
			scoreboard.add("§7XP§7 : §6§l" + XpM.getPlayerMoney(p));
			scoreboard.blankLine();
			scoreboard.add("§a/score");	
			scoreboard.build();
			scoreboard.send(p);
		}
		if (animar == 7) {
			SimpleScoreboard scoreboard = new SimpleScoreboard("§6§LSoul§f§lNetwork");
			
			scoreboard.add("§7Sevidor : §6§lKitPvP");
			scoreboard.add("§7Matou :§6§l "  + Main.plugin.getConfig().getInt(new StringBuilder("status.").append(p.getName().toLowerCase()).append(".kills").toString()));
			scoreboard.add("§7Morreu :§6§l "  + Main.plugin.getConfig().getInt(new StringBuilder("status.").append(p.getName().toLowerCase()).append(".mortes").toString()));
			scoreboard.blankLine();
			scoreboard.add("§7Kit :§6§l " + Habilidade.getAbility(p));
			scoreboard.add("§7XP§7 : §6§l" + XpM.getPlayerMoney(p));
			scoreboard.blankLine();
			scoreboard.add("§a/score");	
			scoreboard.build();
			scoreboard.send(p);
		}
		if (animar == 8) {
			SimpleScoreboard scoreboard = new SimpleScoreboard("§7§LSoul§f§lNetwork");
			
			scoreboard.add("§7Sevidor : §6§lKitPvP");
			scoreboard.add("§7Matou :§6§l "  + Main.plugin.getConfig().getInt(new StringBuilder("status.").append(p.getName().toLowerCase()).append(".kills").toString()));
			scoreboard.add("§7Morreu :§6§l "  + Main.plugin.getConfig().getInt(new StringBuilder("status.").append(p.getName().toLowerCase()).append(".mortes").toString()));
			scoreboard.blankLine();
			scoreboard.add("§7Kit :§6§l " + Habilidade.getAbility(p));
			scoreboard.add("§7XP§7 : §6§l" + XpM.getPlayerMoney(p));
			scoreboard.blankLine();
			scoreboard.add("§a/score");	
			scoreboard.build();
			scoreboard.send(p);
		}
	}

	public static void removeScoreBoard(Player p) {
		Scoreboard score = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective o = score.registerNewObjective("tuts", "PvP");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName("");
		p.setScoreboard(score);
	}
}




