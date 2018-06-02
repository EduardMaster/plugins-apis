package br.com.alpha.InGame;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import br.com.alpha.MCAlpha;
import br.com.alpha.APIs.APIClass;
//import br.com.alpha.APIs.APIClass;
import br.com.alpha.InGame.Listeners.Feast.Feast;
import br.com.alpha.InGame.Listeners.MiniFeast.MiniFeast;
import br.com.alpha.InGame.Schematic.Schematic;
import br.com.alpha.ScoreBoard.Scores;

public class ManagerInGame implements Listener {

	private static BukkitTask InGameTask;
	public static HashSet<Block> arenaBlocks = new HashSet<>();

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onGame(InGameEventAPI e) throws InstantiationException, IllegalAccessException {
		miniFeastsTime();
		APIClass.checkWinner();
		for (Player all : Bukkit.getOnlinePlayers()) {
			Scores.scoreGame(all);;
	
			
		}
		InGameTask = new BukkitRunnable() {

			public void run() {
				MCAlpha.Time++;
				if (MCAlpha.Time == 3001) {
					Bukkit.broadcastMessage(MCAlpha.Logo + "A Arena Final será spawnada em 5 minutos.");
				}
				if (MCAlpha.Time == 3301) {
					Bukkit.broadcastMessage(MCAlpha.Logo + "A Arena Final foi spawnada.");
					try {
						arenaBlocks = Schematic.assembleSchematic(Bukkit.getWorld("world"),
								Bukkit.getWorld("world").getSpawnLocation(),
								Schematic.loadSchematic(new File("plugins/schematics/arenafinal.schematic")));
						for (Player all : Bukkit.getOnlinePlayers()) {
							all.teleport(Bukkit.getWorld("world").getSpawnLocation());
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (MCAlpha.Time == 3601) {
					for (Player all : Bukkit.getOnlinePlayers()) {
						all.kickPlayer("§cNinguém venceu!");
						Bukkit.getServer().shutdown();
						InGameTask.cancel();
					}

				}
				try {
					feastSpawn();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.runTaskTimer(MCAlpha.mcAlpha, 0, 20L);

	}

	public static void endInGameTask() {
		InGameTask.cancel();
	}

	private static void feastSpawn() throws InstantiationException, IllegalAccessException {
		switch (MCAlpha.Time) {
		case 900:
			Feast.prepareFeast();
			break;
		}
	}

	private static void miniFeastsTime() throws InstantiationException, IllegalAccessException {
		MiniFeast.prepareMiniFeasts();
	}
}
