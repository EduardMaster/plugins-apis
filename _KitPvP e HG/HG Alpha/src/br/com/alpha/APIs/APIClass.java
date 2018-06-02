package br.com.alpha.APIs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import br.com.alpha.MCAlpha;
import br.com.alpha.InGame.Schematic.Schematic;
import br.com.alpha.gamemanagement.GameTime;



public class APIClass {
	public static List<UUID> moderadores = new ArrayList<>();
	public static List<UUID> JogadoresInGame = new ArrayList<>();
	public static List<UUID> espectadores = new ArrayList<>();
	public static ArrayList<Block> BlocosColiseu = new ArrayList<>();
	public static List<Block> PistoesColiseu = new ArrayList<>();
	public static ArrayList<Block> BlocosFeast = new ArrayList<>();
	public static boolean ganhou =false;

	public static void changeStatusServer() {
		MCAlpha.Status = getNextStatus(MCAlpha.Status);
	}

	private static GameTime getNextStatus(GameTime AtualStatus) {
		if (AtualStatus == GameTime.PREGAME) {
			return GameTime.INVENCIBILIDADE;
		} else if (AtualStatus == GameTime.INVENCIBILIDADE) {
			return GameTime.INGAME;
		} else {
			return GameTime.INGAME;
		}
	}

	public static String returnFormatted(String For) {
		String Primeira = For.substring(0, 1);
		String result = For.toLowerCase().substring(1, For.length());
		return Primeira.toUpperCase() + result.toLowerCase();
	}

	@SuppressWarnings("deprecation")
	public static void sendSoundToAllPlayers(Sound Som, Float x1, Float x2) {
		for (Player s : Bukkit.getServer().getOnlinePlayers()) {
			s.playSound(s.getLocation(), Som, x1, x2);
		}
	}
	public static String timerMin(Integer i) {
		  int minutes = i.intValue() / 60;
		  int seconds = i.intValue() % 60;
		  String disMinu = (minutes < 10 ? "" : "") + minutes;
		  String disSec = (seconds < 10 ? "0" : "") + seconds;
		  String formattedTime = disMinu + "m " + disSec + "s";
		  return formattedTime;
		 }
	public static String formatDifferenceStr(long time) {
		if (time == 0) {
			return "NEVER";
		}
		long day = TimeUnit.MILLISECONDS.toDays(time);
		long hours = TimeUnit.MILLISECONDS.toHours(time) - (day * 24);
		long minutes = TimeUnit.MILLISECONDS.toMinutes(time) - (TimeUnit.MILLISECONDS.toHours(time) * 60);
		long seconds = TimeUnit.MILLISECONDS.toSeconds(time) - (TimeUnit.MILLISECONDS.toMinutes(time) * 60);
		StringBuilder sb = new StringBuilder();
		if (day > 0) {
			sb.append(day).append("").append(day == 1 ? "D" : "D").append(" ");
		}
		if (hours > 0) {
			sb.append(hours).append("").append(hours == 1 ? "H" : "H").append(" ");
		}
		if (minutes > 0) {
			sb.append(minutes).append("").append(minutes == 1 ? "M" : "M").append(" ");
		}
		if (seconds > 0) {
			sb.append(seconds).append("").append(seconds == 1 ? "S" : "S");
		}
		String diff = sb.toString();
		return diff.isEmpty() ? "AGORA" : diff;
	}

	public static Long currentMilliMoreSeg(Integer seg) {
		return Long.valueOf(System.currentTimeMillis()) + seg * 1000L;
	}
	static HashSet<Block> boloBlocks = new HashSet<>();
	public static void checkWinner() {
		 if (JogadoresInGame.size() == 0) {
				Bukkit.shutdown();
				return;
			}
		if (JogadoresInGame.size() > 1) {
			return;
		}
		Player p = Bukkit.getPlayer(JogadoresInGame.get(0));
		if (JogadoresInGame.size() == 1) {
			ganhou =true;
			MySQL.addWin(p.getUniqueId(), 1);
			MySQL.addMoney(p.getUniqueId(), 200);
			p.sendMessage("§bVocê ganhou o jogo e recebeu 200 coins a mais!");
			p.getInventory().addItem(new ItemStack(Material.MAP));

			try {

				boloBlocks = Schematic.assembleSchematic(Bukkit.getWorld("world"), new Location(Bukkit.getWorld("world"), 300, 120, 300), Schematic.loadSchematic(new File("plugins/schematics/bolo.schematic")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Location loc = new Location(Bukkit.getWorld("world"), 302 ,124 ,302);
			p.teleport(loc);
			new BukkitRunnable() {
				
				@Override
				public void run() {
					Bukkit.broadcastMessage(ChatColor.RED + p.getName() + " venceu!");
				}
			}.runTaskTimer(MCAlpha.mcAlpha, 0, 80L);
			new BukkitRunnable() {
				@SuppressWarnings("deprecation")
				public void run() {
					for (Player jogadores : Bukkit.getOnlinePlayers()) {
						if (jogadores.getName() !=p.getName()) {
							jogadores.kickPlayer("§c" + p.getName() + " §avenceu a partida, reiniciando...");
						}
					}
					p.kickPlayer("§aParabens, Você venceu a partida, ...\n§bVocê recebeu 250 Coins");
					Bukkit.shutdown();
				}
			}.runTaskLater(MCAlpha.mcAlpha, 800L);
		}
	}
	
	public static void deleteFile(File arquivo) {
		if (arquivo.isDirectory()) {
			String[] lista = arquivo.list();
			for (int i = 0; i < lista.length; i++) {
				deleteFile(new File(arquivo, lista[i]));
			}
		}
		arquivo.delete();
	}
}
