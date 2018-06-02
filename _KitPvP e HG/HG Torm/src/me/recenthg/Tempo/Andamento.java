package me.recenthg.Tempo;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import me.recenthg.Main;
import me.recenthg.Schematic;
import me.recenthg.stark.Comandos.Arena;
import me.recenthg.Manager.Feastar;
import me.recenthg.Manager.MiniFeast;
import me.recenthg.Manager.Win;
import me.recenthg.Score.Scoreboasrdsadd;
import me.recenthg.Utils.Estado;
import me.recenthg.jnbt.DataException;

public class Andamento implements Listener {

	public static void onAndamento() {
		Main.estados = Estado.ANDAMENTO;
		new BukkitRunnable() {
			@SuppressWarnings("deprecation")
			public void run() {
				Main.TimerAndamento += 1;
				for (Player p : Bukkit.getOnlinePlayers()) {
					Scoreboasrdsadd.ScoreBoardAndamento(p);
				}
				Win.verificaWin();
				if (Main.TimerAndamento == 1) {
					MiniFeast.announceFeast();
				}
				if (Main.TimerAndamento == 350) {
					MiniFeast.announceFeast();
				}
				if (Main.TimerAndamento == 450) {
					MiniFeast.announceFeast();
				}
				if (Main.TimerAndamento == 550) {
					MiniFeast.announceFeast();
				}
				if (Main.TimerAndamento == 650) {
					MiniFeast.announceFeast();
				}
				if (Main.TimerAndamento == 750) {
					MiniFeast.announceFeast();
				}
				if (Main.TimerAndamento == 850) {
					MiniFeast.announceFeast();
				}
				if (Main.TimerAndamento == 950) {
					MiniFeast.announceFeast();
				}
				if (Main.TimerAndamento == 1000) {
					MiniFeast.announceFeast();
				}
				if (Main.TimerAndamento == 1200) {
					MiniFeast.announceFeast();
				}
				if (Main.TimerAndamento == 1300) {
					MiniFeast.announceFeast();
				}
				if (Main.TimerAndamento == 1400) {
					MiniFeast.announceFeast();
				}
				if (Main.TimerAndamento == 1500) {
					MiniFeast.announceFeast();
				}
				if (Main.TimerAndamento == 1600) {
					MiniFeast.announceFeast();
				}
				if (Main.TimerAndamento == 1600) {
					if (!Feastar.spawnou) {
						final int x = new Random().nextInt(80), z = new Random().nextInt(80);
						final int y = Bukkit.getWorld("world").getHighestBlockYAt(x, z);
						Location loc = new Location(Bukkit.getWorld("world"), x, y, z);
						Feastar.prepararFeast(loc);
					}
				}
				if (Main.TimerAndamento == 1601) {
					if (Main.instance.getConfig().getBoolean("Coliseu")) {
						try {
							Bukkit.getConsoleSender().sendMessage("");
							Bukkit.getConsoleSender().sendMessage("EffectsHG - Iniciando Uma Nova Tarefa");
							Bukkit.getConsoleSender().sendMessage("Tarefa - Tentando Remover Coliseu");
							Bukkit.getConsoleSender().sendMessage("");
							Schematic s=Schematic.getInstance().carregarSchematics(new File(Main.instance.getDataFolder(), "coliseuremove.schematic"));
							Schematic.getInstance().generateSchematic(Main.instance.getServer().getWorlds().get(0), new Location(Main.instance.getServer().getWorlds().get(0), -27.5D, 200.0D, -27.5D), s, Main.coliseu);
							Bukkit.getConsoleSender().sendMessage("");
							Bukkit.getConsoleSender().sendMessage("EffectsHG - Tarefa Concluida");
							Bukkit.getConsoleSender().sendMessage("Tarefa - Remover Coliseu");
							Bukkit.getConsoleSender().sendMessage("");
						} catch (IOException | DataException e){
							Bukkit.getConsoleSender().sendMessage("");
							Bukkit.getConsoleSender().sendMessage("EffectsHG - Erro de schematic");
							Bukkit.getConsoleSender().sendMessage("Motivo - ColiseuRemove.schematic");
							Bukkit.getConsoleSender().sendMessage("");
						}
					}
				}
				if (Main.TimerAndamento == 1700) {
					MiniFeast.announceFeast();
				}
				if (Main.TimerAndamento == 1800) {
					MiniFeast.announceFeast();
				}
				if (Main.TimerAndamento == 1900) {
					MiniFeast.announceFeast();
				}
				if (Main.TimerAndamento == 2000) {
					MiniFeast.announceFeast();
				}
				if (Main.TimerAndamento == 2100) {
					MiniFeast.announceFeast();
				}
				if (Main.TimerAndamento == 2200) {
					MiniFeast.announceFeast();
				}
				if (Main.TimerAndamento == 2300) {
					MiniFeast.announceFeast();
				}
				if (Main.TimerAndamento == 2400) {
					MiniFeast.announceFeast();
				}
				if (Main.TimerAndamento == 2500) {
					MiniFeast.announceFeast();
				}
				if (Main.TimerAndamento == 2600) {
					MiniFeast.announceFeast();
				}
				if (Main.TimerAndamento == 2800) {
					MiniFeast.announceFeast();
				}
				if (Main.TimerAndamento == 2900) {
					MiniFeast.announceFeast();
				}
				if (Main.TimerAndamento == 3000) {
					MiniFeast.announceFeast();
					Arena.ArenaFinal();
				}
				if (Main.TimerAndamento == 3100) {
					MiniFeast.announceFeast();
				}
				if (Main.TimerAndamento == 3200) {
					MiniFeast.announceFeast();
				}
				if (Main.TimerAndamento == 3300) {
					MiniFeast.announceFeast();
				}
				if (Main.TimerAndamento == 3400) {
					MiniFeast.announceFeast();
					Arena.criarAreaBatle();
				}
				if (Main.TimerAndamento == 3500) {
					MiniFeast.announceFeast();
				}
				if (Main.TimerAndamento == 3600) {
					for (Player s : Bukkit.getOnlinePlayers()) {
						s.kickPlayer("§7Ninguem ganhou a partida !");
					}
					Bukkit.shutdown();
					cancel();
				}
			}
		}.runTaskTimer(Main.plugin, 0, 20);
	}

}