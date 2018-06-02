package me.rafael.vinagre.KomboPvP.Comandos;

import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.rafael.vinagre.KomboPvP.Listeners.Board;
import me.rafael.vinagre.KomboPvP.MySQL.MySQLManager;

public class Setar 
implements CommandExecutor
{
	
	public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("setar")){
			if(!sender.hasPermission("kitpvp.tag.dono")){
				return true;
			}
			if(args.length != 3){
				sender.sendMessage("§cUse /setar <coins/caixa> <quantidade> <jogador>");
				return true;
			}
			if(args[0].equalsIgnoreCase("coins")){
				int quantidade = Integer.parseInt(args[1]);
				Player p2 = Bukkit.getPlayer(args[2]);
				if(p2 == null){
					sender.sendMessage("§cJogador nao encontrado !");
					return true;
				}
				try {
					MySQLManager.setCoins(p2, MySQLManager.getCoins(p2) + quantidade);
					Board.setScoreBoard(p2);
					sender.sendMessage("§c" + p2.getName() + " agora tem " + MySQLManager.getCoins(p2) + " Coins !");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(args[0].equalsIgnoreCase("caixan")){
				int quantidade = Integer.parseInt(args[1]);
				Player p2 = Bukkit.getPlayer(args[2]);
				if(p2 == null){
					sender.sendMessage("§cJogador nao encontrado !");
					return true;
				}
				try {
					MySQLManager.setCaixaN(p2, MySQLManager.getCaixasN(p2) + quantidade);
					Board.setScoreBoard(p2);
					sender.sendMessage("§c" + p2.getName() + " agora tem " + MySQLManager.getCaixasN(p2) + " Caixas Normais !");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(args[0].equalsIgnoreCase("caixal")){
				int quantidade = Integer.parseInt(args[1]);
				Player p2 = Bukkit.getPlayer(args[2]);
				if(p2 == null){
					sender.sendMessage("§cJogador nao encontrado !");
					return true;
				}
				try {
					MySQLManager.setCaixaL(p2, MySQLManager.getCaixasL(p2) + quantidade);
					Board.setScoreBoard(p2);
					sender.sendMessage("§c" + p2.getName() + " agora tem " + MySQLManager.getCaixasL(p2) + " Caixas Normais !");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}
}