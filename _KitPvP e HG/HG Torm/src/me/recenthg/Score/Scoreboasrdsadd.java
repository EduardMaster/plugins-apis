package me.recenthg.Score;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import me.recenthg.Main;
import me.recenthg.Dinheiro.DinheiroM;
import me.recenthg.Manager.Habilidade;
import me.recenthg.Manager.Listeners;
import me.recenthg.Tempo.StringTimer;
import me.recenthg.Utils.Estado;


public class Scoreboasrdsadd implements Listener {
	
	public static Scoreboard getScoreBoard() {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		return board;
	}
	
	public static String Rank(Player p) {
	    double a = DinheiroM.MostrarEloPlayer(p);
	    if (a <= 200.0D) {
	      return "Bronze";
	    }
	    if (a <= 1500.0D) {
	      return "Prata";
	    }
	    if (a <= 4500.0D) {
	      return "Ouro";
	    }
	    if (a <= 8500.0D) {
	      return "Platina";
	    }
	    if (a <= 11500.0D) { 
	      return "Diamante";
	    }
	    if (a <= 18000.0D) {
	      return "Ruby";
	    }
	    if (a <= 25000.0D) {
	      return "Esmeralda";
	    }
	    if (a <= 35000.0D) {
		  return "Monster";
		}
	    if (a <= 45000.0D) {
		  return "Obsidian";
		}
	    if (a <= 55000.0D) {
		  return "Bedrock";
		}
	    return "Bedrock";
	  }
	
	public static String RankS(Player p) {
	    double a = DinheiroM.MostrarEloPlayer(p);
	    if (a <= 200.0D) {
	      return " §6§lBRZ";
	    }
	    if (a <= 1500.0D) {
	      return " §7§lPRT";
	    }
	    if (a <= 4500.0D) {
	      return " §e§lOUR";
	    }
	    if (a <= 8500.0D) {
	      return " §8§lPLT";
	    }
	    if (a <= 11500.0D) { 
	      return " §b§lDMT";
	    }
	    if (a <= 18000.0D) {
	      return " §c§lRUB";
	    }
	    if (a <= 25000.0D) {
	      return " §a§lEMD";
	    }
	    if (a <= 35000.0D) {
		  return " §5§lMST";
		}
	    if (a <= 45000.0D) {
		  return " §0§lOSD";
		}
	    if (a <= 55000.0D) {
		  return " §3§lBDR";
		}
	    return " §3§lBDR";
	  }
	
	public static String Grupo(Player p) {
		if (p.hasPermission("tag.normal")) {
			return "§7Normal";
		}
		if (p.hasPermission("tag.vip")) {
			return "§aVip";
		}
		if (p.hasPermission("tag.mvp")) {
			return "§9Mvp";
		}
		if (p.hasPermission("tag.pro")) {
			return "§6Pro";
		}
		if (p.hasPermission("tag.youtuber")) {
			return "§bYoutuber";
		}
		if (p.hasPermission("tag.trial")) {
			return "§dTrial";
		}
		if (p.hasPermission("tag.mod")) {
			return "§5Mod";
		}
		if (p.hasPermission("tag.modplus")) {
			return "§5§lModPlus";
		}
		if (p.hasPermission("tag.admin")) {
			return "§cAdmin";
		}
		if (p.hasPermission("tag.adminplus")) {
			return "§4AdminPlus";
		}
		if (p.hasPermission("tag.dono")) {
			return "§4§lDono";
		}
		return "§4§lDono";
	}

	public static void ScoreBoardIniciando(Player p) {
		SimpleScoreboard ScoreBoard = new SimpleScoreboard("§e§lEffects§f§lHG");
		ScoreBoard.addLinha("§1     ");	
		ScoreBoard.addLinha("§e§l* Partida");
		ScoreBoard.addLinha("§1     ");
		ScoreBoard.addLinha("§8{§e§l!§8} §fIniciando: §e" + StringTimer.TimerGame(Main.TimerIniciando));
		ScoreBoard.addLinha("§8{§e§l!§8} §fKit: §e" + Habilidade.NomeDoKit(Habilidade.getAbility(p)));
		ScoreBoard.addLinha("§2     ");
		ScoreBoard.addLinha("§e§l* Status");
		ScoreBoard.addLinha("§1");
		ScoreBoard.addLinha("§8{§e§l!§8} §fJogadores: §e" + Main.Jogadores.size() + "§f/§e" + Bukkit.getMaxPlayers());
		ScoreBoard.addLinha("§8{§e§l!§8} §fRank: §e" + Rank(p));
		ScoreBoard.addLinha("§8{§e§l!§8} §fTCoins:§e " + DinheiroM.MostrarDinheiroPlayer(p));
		ScoreBoard.addLinha("§8{§e§l!§8} §fElo:§e " + DinheiroM.MostrarEloPlayer(p));
		ScoreBoard.addLinha("§1     ");
		ScoreBoard.addLinha("hg.effects-network.com   ");
		ScoreBoard.build();
		ScoreBoard.send(p);
		
	}
	
	
	public static void ScoreBoardInvencibilidade(Player p) {
		SimpleScoreboard ScoreBoard2 = new SimpleScoreboard("§e§lEffects§f§lHG");
		ScoreBoard2.addLinha("§1     ");	
		ScoreBoard2.addLinha("§e§l* Partida");
		ScoreBoard2.addLinha("§1     ");
		ScoreBoard2.addLinha("§8{§e§l!§8} §fInvencivel: §e" + StringTimer.TimerGame(Main.TimerInvencibilidade));
		ScoreBoard2.addLinha("§8{§e§l!§8} §fKit: §e" + Habilidade.NomeDoKit(Habilidade.getAbility(p)));
		ScoreBoard2.addLinha("§2     ");
		ScoreBoard2.addLinha("§e§l* Status");
		ScoreBoard2.addLinha("§1");
		ScoreBoard2.addLinha("§8{§e§l!§8} §fJogadores: §e" + Main.Jogadores.size() + "§f/§e" + Bukkit.getMaxPlayers());
		ScoreBoard2.addLinha("§8{§e§l!§8} §fRank: §e" + Rank(p));
		ScoreBoard2.addLinha("§8{§e§l!§8} §fTCoins:§e " + DinheiroM.MostrarDinheiroPlayer(p));
		ScoreBoard2.addLinha("§8{§e§l!§8} §fElo:§e " + DinheiroM.MostrarEloPlayer(p));
		ScoreBoard2.addLinha("§1     ");
		ScoreBoard2.addLinha("hg.effects-network.com   ");
		ScoreBoard2.build();
		ScoreBoard2.send(p);
		
	}
	

	public static void ScoreBoardAndamento(Player p) {
		SimpleScoreboard ScoreBoard3 = new SimpleScoreboard("§e§lEffects§f§lHG");
		ScoreBoard3.addLinha("§1     ");	
		ScoreBoard3.addLinha("§e§l* Partida");
		ScoreBoard3.addLinha("§1     ");
		ScoreBoard3.addLinha("§8{§e§l!§8} §fAndamento: §e" + StringTimer.TimerGame(Main.TimerAndamento));
		ScoreBoard3.addLinha("§8{§e§l!§8} §fKit: §e" + Habilidade.NomeDoKit(Habilidade.getAbility(p)));
		ScoreBoard3.addLinha("§2     ");
		ScoreBoard3.addLinha("§e§l* Status");
		ScoreBoard3.addLinha("§1");
		ScoreBoard3.addLinha("§8{§e§l!§8} §fJogadores: §e" + Main.Jogadores.size() + "§f/§e" + Bukkit.getMaxPlayers());
		ScoreBoard3.addLinha("§8{§e§l!§8} §fKills: §e" + Listeners.getKs(p));
		ScoreBoard3.addLinha("§8{§e§l!§8} §fTCoins:§e " + DinheiroM.MostrarDinheiroPlayer(p));
		ScoreBoard3.addLinha("§8{§e§l!§8} §fElo:§e " + DinheiroM.MostrarEloPlayer(p));
		ScoreBoard3.addLinha("§1     ");
		ScoreBoard3.addLinha("hg.effects-network.com   ");
		ScoreBoard3.build();
		ScoreBoard3.send(p);
		
	}
	

	public static void clearScoreboard(Player p) {
		getScoreBoard().clearSlot(DisplaySlot.SIDEBAR);
		p.setScoreboard(getScoreBoard());
	}
	
	@EventHandler
	public void NomeDoKitCoracao(EntityDamageByEntityEvent e) {
		if (Main.estados == Estado.ANDAMENTO)
			
	if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player))) {
	final Player apanho = (Player) e.getEntity();
	final Player bateu = (Player) e.getDamager();

	Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {

	public void run() {
	Scoreboard sb = bateu.getScoreboard();
	Objective ob = sb.getObjective("kills");
	if (ob != null) {
	ob.unregister();
	}
	ob = sb.registerNewObjective("kills", "health");
	ob.setDisplaySlot(DisplaySlot.BELOW_NAME);
	ob.setDisplayName("§e§l" + Habilidade.NomeDoKit(Habilidade.getAbility(apanho)));
	}
	}, 20L);
	}
	}
	
}
