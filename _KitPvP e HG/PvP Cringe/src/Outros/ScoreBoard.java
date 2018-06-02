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
		  public static String RankStaff(Player p ){ 

			  if(p.hasPermission("*")){
				  return "§4§lDONO";
			  }
			  if(p.hasPermission("tag.admin")){
				  return "§c§lADMIN";
			  }
			  if(p.hasPermission("tag.mod")){
				  return "§5§lMOD";
			  }
			  if(p.hasPermission("tag.trial")){
				  return "§5§lTRIAL";
			  }
			  if(p.hasPermission("tag.yt")){
				  return "§b§lYT";
			  }
			  if(p.hasPermission("tag.gerente")){
				  return "§c§lGERENTE";
			  }
			  if(p.hasPermission("tag.BUILDER")){
				  return "§e§lBUILDER";
			  }
			  if(p.hasPermission("tag.premium")){
				  return "§6§lPREMIUM";
			  }
			  if(p.hasPermission("tag.light")){
				  return "§a§lLIGHT";
			  }
			  if(p.hasPermission("tag.normal")){
				  return "§7§lMEMBRO";
			  }
			  if(p.hasPermission("tag.modfull")){
				  return "§5§l§oMOD+";
			  }  
			  if(p.hasPermission("tag.ultimate")){
				  return "§d§lULTIMATE";
			  }
			return "§7§lMEMBRO";
		  }
			public static String scoreRank(Player p) {
				KillsDeathsMoney StatusManager = null;
				@SuppressWarnings("static-access")
				double a = StatusManager.getKills(p);
				if (a < 100.0D) {
					return "§f- UNRANKED";
				}
				if (a < 199.0D) {
					return "§f- UNRANKED";
				}
				if (a < 200.0D) {
					return "§a☰ PRIMARY";
				}
				if (a < 299.0D) {
					return "§e☲ ADVANCED";
				}
				if (a < 300.0D) {
					return "§1☷ EXPERT";
				}
				if (a < 399.0D) {
					return "§7✶ SILVER";
				}
				if (a < 400.0D) {
					return "§6✶ GOLD";
				}
				if (a < 499.0D) {
					return "§b✦ DIAMOND";
				}
				if (a < 500.0D) {
					return "§b✦ DIAMOND";
				}
				if (a < 599.0D) {
					return "§5✹ ELITE";
				}
				if (a < 600.0D) {
					return "§c✫ MASTER";
				}
				if (a < 699.0D) {
					return "§4✪ LEGENDARY";
				}
				return null;
			}
		  
			public static String Rank(Player p) {
				KillsDeathsMoney StatusManager = null;
				@SuppressWarnings("static-access")
				double a = StatusManager.getKills(p);
				if (a < 100.0D) {
					return "§8⚊";
				}
				if (a < 199.0D) {
					return "§8⚊";
				}
				if (a < 200.0D) {
					return "§e✦";
				}
				if (a < 299.0D) {
					return "§e✦";
				}
				if (a < 300.0D) {
					return "§7★";
				}
				if (a < 399.0D) {
					return "§7★";
				}
				if (a < 400.0D) {
					return "§6✪";
				}
				if (a < 499.0D) {
					return "§6✪";
				}
				if (a < 500.0D) {
					return "§b❄";
				}
				if (a < 599.0D) {
					return "§b❄";
				}
				if (a < 600.0D) {
					return "§a✲";
				}
				if (a < 699.0D) {
					return "§a✲";
				}
				if (a < 700.0D) {
					return "§c✿";
				}
				if (a < 799.0D) {
					return "§c✿";
				}
				if (a < 800.0D) {
					return "§3❂";
				}
				if (a < 899.0D) {
					return "§3❂";
				}
				if (a < 900.0D) {
					return "§d⚙";
				}
				if (a < 999.0D) {
					return "§d⚙";
				}
				if (a < 1000.0D) {
					return "§4✫";
				}
				return "§4✫";
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
				SimpleScoreboard scoreboard = new SimpleScoreboard("§e§lCRINGED§7§LKITS");
				scoreboard.blankLine();
				scoreboard.add("§7Rank: §b" + RankStaff(p));
				scoreboard.add("§7Liga: " + scoreRank(p));
				scoreboard.blankLine();
				scoreboard.add("§7Matou: §b" + kills);
				scoreboard.add("§7Morreu: §b" + deaths);
				scoreboard.blankLine();
				scoreboard.add("§7Kit Atual: §b" + KitAPI.getKit(p));
				scoreboard.blankLine();
				scoreboard.add("§7Moedas: §b" + coins);
				scoreboard.add("§7Online: §b" + online);
				scoreboard.blankLine();
				scoreboard.add("§6www.cringedkits.tk");
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
