package br.com.alpha.pregame;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import br.com.alpha.MCAlpha;
import br.com.alpha.APIs.APIClass;
import br.com.alpha.APIs.Title;
import br.com.alpha.Invencibilidade.InvencibilidadeEventAPI;
import br.com.alpha.Invencibilidade.ManagerInvencibilidade;
import br.com.alpha.ScoreBoard.Scores;

public class ManagerPreGame {

	public static BukkitTask taskPreGame;

	@SuppressWarnings("deprecation")
	public static void startPreGame() {
		for (Player all : Bukkit.getOnlinePlayers()) {
			Scores.scorePreGame(all);
		}
		taskPreGame = new BukkitRunnable() {
			public void run() {

				Messages(MCAlpha.Time);
				MCAlpha.Time--;

			}
		}.runTaskTimer(MCAlpha.mcAlpha, 0, 20L);
	}

	private static void endPreGameTask() {
		taskPreGame.cancel();
	}

	@SuppressWarnings("deprecation")
	public static void Messages(Integer tempo) {
		String baseString = MCAlpha.Logo + " §fTorneio inicia em ";
		if (tempo <= MCAlpha.needPlayers) {
			hasMoreFivePlayers();
		}
		if (APIClass.JogadoresInGame.size() >= MCAlpha.needPlayers) {
			switch (tempo) {
			case 5:
				BukkitBroadcastMessage(baseString + "§45 segundos.");
				for (Player all : Bukkit.getOnlinePlayers()) {
					all.teleport(all.getWorld().getSpawnLocation());
				}
				break;
			case 4:
				BukkitBroadcastMessage(baseString + "§44 segundos.");
				break;
			case 3:
				BukkitBroadcastMessage(baseString + "§43 segundos.");
				break;
			case 2:
				BukkitBroadcastMessage(baseString + "§42 segundos.");
				break;
			case 1:
				BukkitBroadcastMessage(baseString + "§41 segundo.");
				break;
			case 0:
				BukkitBroadcastMessage("§6O torneio iniciou!");
				
				Bukkit.getPluginManager().callEvent(new InvencibilidadeEventAPI(APIClass.JogadoresInGame));
				for (Player all : Bukkit.getOnlinePlayers()) {

					all.setAllowFlight(false);
					
				}
				APIClass.changeStatusServer();
				ManagerInvencibilidade.removePistonsColiseu();
				endPreGameTask();

				break;
			}
		}
	}

	private static void BukkitBroadcastMessage(String msg) {
		Bukkit.broadcastMessage(msg);
	}

	private static void hasMoreFivePlayers() {
		if (!(APIClass.JogadoresInGame.size() >= MCAlpha.needPlayers)) {
			BukkitBroadcastMessage(MCAlpha.Logo + " §cNão há jogadores suficientes para iniciar a partida.");
			BukkitBroadcastMessage(MCAlpha.Logo + " §7Tempo alterado para §c1:00 minuto.");
			MCAlpha.Time = 61;
		}
	}

	@SuppressWarnings("deprecation")
	public static void loopSendTitle(String titulo) {
		for (Player x : Bukkit.getOnlinePlayers()) {
			Title.sendTitle(x, titulo);
		}
	}

	@SuppressWarnings("deprecation")
	public static void loopSendSubTitle(String titulo) {
		for (Player x : Bukkit.getOnlinePlayers()) {
			Title.sendSubTitle(x, titulo);
		}
	}

	@SuppressWarnings("deprecation")
	public static void sendXPMessageLoop(String msg) {
		for (Player x : Bukkit.getOnlinePlayers()) {
			Title.sendXPBarMessage(x, msg);
		}
	}
}
