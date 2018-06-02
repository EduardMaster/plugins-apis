/*
 * Decompiled with CFR 0_102.
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 *  org.bukkit.block.Block
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandExecutor
 *  org.bukkit.command.CommandSender
 *  org.bukkit.configuration.file.FileConfiguration
 *  org.bukkit.entity.Player
 *  org.bukkit.plugin.Plugin
 */
package me.recenthg.stark.Comandos;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import me.recent.stark.Main;
import me.recenthg.stark.Comandos.CMDListener;
import me.recenthg.stark.Feast.Feaste;
import me.recenthg.stark.Manager.Habilidade;
import me.recenthg.stark.Tempo.StringTimer;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

@SuppressWarnings("unused")
public class Jogo implements CommandExecutor, Listener {
	public Jogo(Main main) {
		// TODO Auto-generated constructor stub
	}

	public Jogo() {
		// TODO Auto-generated constructor stub
	}
	


	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§b�? §6Comandos apenas no servidor!");
			return true;
		}
		Player p = (Player) sender;
		String KitName = Habilidade.NomeDoKit(Habilidade.getAbility(p));
		if (cmd.getName().equalsIgnoreCase("jogo")) {
			if (Main.PreGame) {
				p.sendMessage("§4§l--------- Informaçoes ---------");
				p.sendMessage("§4§lEstagio - §7§nPreGame");
				p.sendMessage("§4§lInicia em - §7§n" + StringTimer.TimerGame(Main.TimerIniciando));
				p.sendMessage("§4§lJogadores na Partida - §7§n" + Main.Jogadores.size());
				p.sendMessage("§4§lIP do Servidor - §7§n" + Main.instance.getConfig().getString("ip"));
				p.sendMessage("§4§l--------- Informaçoes---------");
			}
			if (Main.PreInvencibilidade) {
				p.sendMessage("§4§l--------- Informaçoes---------");
				p.sendMessage("§4§lEstagio - §7§nInvencibilidade");
				p.sendMessage("§4§lInvencibilidade - §7§n" + StringTimer.TimerGame(Main.TimerInvencibilidade));
				p.sendMessage("§4§lJogadores na Partida - §7§n" + Main.Jogadores.size());
				p.sendMessage("§4§lIP do Servidor - §7§n" + Main.instance.getConfig().getString("ip"));
				p.sendMessage("§4§l--------- Informaçoes---------");
			}
			if (Main.Partida) {
				p.sendMessage("§4§l--------- Informaçoes---------");
				p.sendMessage("§4§lEstagio - §7§nAndamento");
				if (Main.Partida) {
					int millis = Main.Andamento * 1000;
					SimpleDateFormat df = new SimpleDateFormat("mm:ss");
					String time = df.format(Integer.valueOf(millis));
					p.sendMessage("§4§l§7Tempo - §7§n" + time);
					p.sendMessage("§4§lKit - §7§n" + KitName);
					p.sendMessage("§4§lJogadores na Partida - §7§n" + Main.Jogadores.size());
					p.sendMessage("§4§lIP do Servidor - §7§n" + Main.instance.getConfig().getString("ip"));
					p.sendMessage("§4§lKills - §7§n" + CMDListener.getKs(p));
					p.sendMessage("§4§lJogadores participando - §7§n" + Main.Jogadores.size());
					p.sendMessage("§4§l--------- Informaçoes---------");
				}
				return true;
			}
		}
		return false;
	}
}
