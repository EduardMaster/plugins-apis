package br.com.alpha.ScoreBoard;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import br.com.alpha.MCAlpha;
import br.com.alpha.APIs.APIClass;
import br.com.alpha.ENUMs.KitsEnum;








public class Scores {
	
	public static void update(final Player p){
		// Método para atualizar a score do jogador
		Thread th = new Thread(new Runnable() {

			@Override
			public void run() {
				
				// Checar se o jogador possui uma scoreboard
				if (p.getScoreboard() != null){
					// Checar se a scoreboard que ele possui é a que nós criamos a cima
					if (p.getScoreboard().getObjective("score3") != null){
						
						Team l2 = p.getScoreboard().getTeam("line2");
						Team l3 = p.getScoreboard().getTeam("line3");
						Team l5 = p.getScoreboard().getTeam("line5");
						Team l6 = p.getScoreboard().getTeam("line6");
						Team l8 = p.getScoreboard().getTeam("line8");
						Team l0 = p.getScoreboard().getTeam("line0");

						//line2: Rank
						//line3: AlphaCoins
						//line5: Kit
						//Line6: players
						l8.setSuffix("alphahg.com.br");
						l0.setSuffix("");
						l2.setSuffix("" + APIClass.timerMin(MCAlpha.Time));
						l3.setSuffix("" + MCAlpha.getSQL().getMoney(p.getUniqueId()));
						l5.setSuffix("" + p.getStatistic(Statistic.PLAYER_KILLS));
						l6.setSuffix(APIClass.JogadoresInGame.size() + "/"  + Bukkit.getMaxPlayers());
					}
					if (p.getScoreboard().getObjective("score2") != null){
						
						Team l2 = p.getScoreboard().getTeam("line2");
						Team l3 = p.getScoreboard().getTeam("line3");
						Team l5 = p.getScoreboard().getTeam("line5");
						Team l6 = p.getScoreboard().getTeam("line6");
						Team l8 = p.getScoreboard().getTeam("line8");
						Team l0 = p.getScoreboard().getTeam("line0");

						//line2: Rank
						//line3: AlphaCoins
						//line5: Kit
						//Line6: players
						l8.setSuffix("alphahg.com.br");
						l0.setSuffix("");
						l2.setSuffix("" + APIClass.timerMin(MCAlpha.Time));
						l3.setSuffix("" + MCAlpha.getSQL().getMoney(p.getUniqueId()));
						l5.setSuffix("" + KitsEnum.getKit(p));
						l6.setSuffix(APIClass.JogadoresInGame.size() + "/"  + Bukkit.getMaxPlayers());
					}
						// Checar para ver se o servidor possui SimpleClans
					if (p.getScoreboard().getObjective("score1") != null){
						// Agora agente declara as teams, para atualizar o prefixo delas
						
						Team l2 = p.getScoreboard().getTeam("line2");
						Team l3 = p.getScoreboard().getTeam("line3");
						Team l5 = p.getScoreboard().getTeam("line5");
						Team l6 = p.getScoreboard().getTeam("line6");
						Team l8 = p.getScoreboard().getTeam("line8");
						Team l0 = p.getScoreboard().getTeam("line0");

						//line2: Rank
						//line3: AlphaCoins
						//line5: Kit
						//Line6: players
						l8.setSuffix("alphahg.com.br");
						l0.setSuffix("");
						l2.setSuffix("" + APIClass.timerMin(MCAlpha.Time));
						l3.setSuffix("" + MCAlpha.getSQL().getMoney(p.getUniqueId()));
						l5.setSuffix("" + KitsEnum.getKit(p));
						l6.setSuffix(APIClass.JogadoresInGame.size() + "/"  + Bukkit.getMaxPlayers());
						


						
					}
				}
				
			}
		});
		th.start();
	}
	public static void run(){
		new BukkitRunnable() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				for (Player p : Bukkit.getOnlinePlayers()){ // Pegar todos jogadres
					update(p); // Atualizar a score dele.
				}
				
			}
		}.runTaskTimer(MCAlpha.mcAlpha, 0, 20L);
	}
	// Método para pegar o money do player
	public static void scorePreGame(Player player){
		// Criando a scoreboard...
		
		Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = sb.registerNewObjective("score1", "dummy");
		obj.setDisplayName("§b§lHardcoreGames");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
	
		// Criando os valores da score.
		
		
		FastOfflinePlayer line0 = new FastOfflinePlayer("§3");
		FastOfflinePlayer line1 = new FastOfflinePlayer("§0");
		FastOfflinePlayer line2 = new FastOfflinePlayer("§fTempo §7");
		FastOfflinePlayer line3 = new FastOfflinePlayer("§fCoins §6");
		FastOfflinePlayer line4 = new FastOfflinePlayer("§1");
		FastOfflinePlayer line5 = new FastOfflinePlayer("§fKit §a");
		FastOfflinePlayer line6 = new FastOfflinePlayer("§fJogadores §7");
		FastOfflinePlayer line7 = new FastOfflinePlayer("§0");
		FastOfflinePlayer line8 = new FastOfflinePlayer("§f");

		Team l2 = sb.registerNewTeam("line2");
		Team l3 = sb.registerNewTeam("line3");
		Team l5 = sb.registerNewTeam("line5");
		Team l6 = sb.registerNewTeam("line6");
		Team l8 = sb.registerNewTeam("line8");
		Team l0 = sb.registerNewTeam("line0");
		
		l2.addPlayer(line2);
		l3.addPlayer(line3);
		l5.addPlayer(line5);
		l6.addPlayer(line6);
		l8.addPlayer(line8);
		l0.addPlayer(line0);
		//line2: Rank
		//line3: AlphaCoins
		//line5: Servidor
		//Line6: players
		
		obj.getScore(line0.getName()).setScore(15);
		obj.getScore(line1.getName()).setScore(14);
		obj.getScore(line2.getName()).setScore(13);
		obj.getScore(line3.getName()).setScore(12);
		obj.getScore(line4.getName()).setScore(11);
		obj.getScore(line5.getName()).setScore(10);
		obj.getScore(line6.getName()).setScore(9);
		obj.getScore(line7.getName()).setScore(8);
		obj.getScore(line8.getName()).setScore(7);
		
		player.setScoreboard(sb);
	}

	public static void scoreInvencibility(Player player){
		// Criando a scoreboard...
		
				Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
				Objective obj = sb.registerNewObjective("score2", "dummy");
				obj.setDisplayName("§b§lHardcoreGames");
				obj.setDisplaySlot(DisplaySlot.SIDEBAR);
			
				// Criando os valores da score.
				FastOfflinePlayer line0 = new FastOfflinePlayer("§3");
				FastOfflinePlayer line1 = new FastOfflinePlayer("§0");
				FastOfflinePlayer line2 = new FastOfflinePlayer("§fTempo §7");
				FastOfflinePlayer line3 = new FastOfflinePlayer("§fCoins §6");
				FastOfflinePlayer line4 = new FastOfflinePlayer("§1");
				FastOfflinePlayer line5 = new FastOfflinePlayer("§fKit §a");
				FastOfflinePlayer line6 = new FastOfflinePlayer("§fJogadores §7");
				FastOfflinePlayer line7 = new FastOfflinePlayer("§0");
				FastOfflinePlayer line8 = new FastOfflinePlayer("§f");

				Team l2 = sb.registerNewTeam("line2");
				Team l3 = sb.registerNewTeam("line3");
				Team l5 = sb.registerNewTeam("line5");
				Team l6 = sb.registerNewTeam("line6");
				Team l8 = sb.registerNewTeam("line8");
				Team l0 = sb.registerNewTeam("line0");
				
				l2.addPlayer(line2);
				l3.addPlayer(line3);
				l5.addPlayer(line5);
				l6.addPlayer(line6);
				l8.addPlayer(line8);
				l0.addPlayer(line0);
				//line2: Rank
				//line3: AlphaCoins
				//line5: Servidor
				//Line6: players
				
				obj.getScore(line0.getName()).setScore(15);
				obj.getScore(line1.getName()).setScore(14);
				obj.getScore(line2.getName()).setScore(13);
				obj.getScore(line3.getName()).setScore(12);
				obj.getScore(line4.getName()).setScore(11);
				obj.getScore(line5.getName()).setScore(10);
				obj.getScore(line6.getName()).setScore(9);
				obj.getScore(line7.getName()).setScore(8);
				obj.getScore(line8.getName()).setScore(7);
				player.setScoreboard(sb);
	}		


	public static void scoreGame(Player player){
		// Criando a scoreboard...
		
				Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
				Objective obj = sb.registerNewObjective("score3", "dummy");
				obj.setDisplayName("§b§lHardcoreGames");
				obj.setDisplaySlot(DisplaySlot.SIDEBAR);
			
				FastOfflinePlayer line0 = new FastOfflinePlayer("§3");
				FastOfflinePlayer line1 = new FastOfflinePlayer("§0");
				FastOfflinePlayer line2 = new FastOfflinePlayer("§fTempo §7");
				FastOfflinePlayer line3 = new FastOfflinePlayer("§fCoins §6");
				FastOfflinePlayer line4 = new FastOfflinePlayer("§1");
				FastOfflinePlayer line5 = new FastOfflinePlayer("§fKills §a");
				FastOfflinePlayer line6 = new FastOfflinePlayer("§fJogadores §7");
				FastOfflinePlayer line7 = new FastOfflinePlayer("§0");
				FastOfflinePlayer line8 = new FastOfflinePlayer("§f");

				Team l2 = sb.registerNewTeam("line2");
				Team l3 = sb.registerNewTeam("line3");
				Team l5 = sb.registerNewTeam("line5");
				Team l6 = sb.registerNewTeam("line6");
				Team l8 = sb.registerNewTeam("line8");
				Team l0 = sb.registerNewTeam("line0");
				
				l2.addPlayer(line2);
				l3.addPlayer(line3);
				l5.addPlayer(line5);
				l6.addPlayer(line6);
				l8.addPlayer(line8);
				l0.addPlayer(line0);
				//line2: Rank
				//line3: AlphaCoins
				//line5: Servidor
				//Line6: players
				
				obj.getScore(line0.getName()).setScore(15);
				obj.getScore(line1.getName()).setScore(14);
				obj.getScore(line2.getName()).setScore(13);
				obj.getScore(line3.getName()).setScore(12);
				obj.getScore(line4.getName()).setScore(11);
				obj.getScore(line5.getName()).setScore(10);
				obj.getScore(line6.getName()).setScore(9);
				obj.getScore(line7.getName()).setScore(8);
				obj.getScore(line8.getName()).setScore(7);
				player.setScoreboard(sb);
	}
}