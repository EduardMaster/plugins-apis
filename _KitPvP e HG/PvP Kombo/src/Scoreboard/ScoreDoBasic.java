package Scoreboard;

import XP.XpM;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;

import java.util.HashMap;



import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import me.rafael.vinagre.KomboPvP.Listeners.KillsDeathsMoney;





public class ScoreDoBasic
  implements Listener
{
  public static Plugin plugin;
  
  public static String Rank(Player p)
  {
    double a = KillsDeathsMoney.getKills(p);
    if (a <= 20.0D) {
      return ChatColor.DARK_GRAY + "\u2717";
    }
    if (a <= 75.0D) {
      return ChatColor.GREEN + "\u2725";
    }
    if (a <= 130.0D) {
      return ChatColor.GREEN + "\u2725";
    }
    if (a <= 150.0D) {
      return ChatColor.GREEN + "\u2725";
    }
    if (a <= 180.0D) {
      return ChatColor.GREEN + "\u2725";
    }
    if (a <= 200.0D) {
      return ChatColor.GRAY + "\u2723";
    }
    if (a <= 215.0D) {
      return ChatColor.GRAY + "\u2723";
    }
    if (a <= 230.0D) {
      return ChatColor.GRAY + "\u2723";
    }
    if (a <= 250.0D) {
      return ChatColor.GRAY + "\u2723";
    }
    if (a <= 280.0D) {
      return ChatColor.GRAY + "\u2723";
    }
    if (a <= 300.0D) {
      return ChatColor.YELLOW + "\u2724";
    }
    if (a <= 315.0D) {
      return ChatColor.YELLOW + "\u2724";
    }
    if (a <= 330.0D) {
      return ChatColor.YELLOW + "\u2724";
    }
    if (a <= 350.0D) {
      return ChatColor.YELLOW + "\u2724";
    }
    if (a <= 380.0D) {
      return ChatColor.YELLOW + "\u2724";
    }
    if (a <= 400.0D) {
      return ChatColor.AQUA + "\u272a";
    }
    if (a <= 415.0D) {
      return ChatColor.AQUA + "\u272a";
    }
    if (a <= 430.0D) {
      return ChatColor.AQUA + "\u272a";
    }
    if (a <= 450.0D) {
      return ChatColor.AQUA + "\u272a";
    }
    if (a <= 480.0D) {
      return ChatColor.AQUA + "\u272a";
    }
    if (a <= 500.0D) {
      return ChatColor.GOLD + "\u2742";
    }
    if (a <= 515.0D) {
      return ChatColor.GOLD + "\u2742";
    }
    if (a <= 530.0D) {
      return ChatColor.GOLD + "\u2742";
    }
    if (a <= 550.0D) {
      return ChatColor.GOLD + "\u2742";
    }
    if (a <= 580.0D) {
      return ChatColor.GOLD + "\u2742";
    }
    if (a <= 600.0D) {
      return ChatColor.RED + "\u273e";
    }
    return ChatColor.RED + "\u273e";
  }
  
  public static String getRank(Player p)
  {
    double a = KillsDeathsMoney.getKills(p);
    if (a <= 20.0D) {
      return ChatColor.DARK_GRAY + "\u2717 Unranked";
    }
    if (a <= 75.0D) {
      return ChatColor.GREEN + "\u2725 Bronze IV";
    }
    if (a <= 130.0D) {
      return ChatColor.GREEN + "\u2725 Bronze III";
    }
    if (a <= 150.0D) {
      return ChatColor.GREEN + "\u2725 Bronze II";
    }
    if (a <= 180.0D) {
      return ChatColor.GREEN + "\u2725 Bronze I";
    }
    if (a <= 200.0D) {
      return ChatColor.GRAY + "\u2723 Silver IV";
    }
    if (a <= 215.0D) {
      return ChatColor.GRAY + "\u2723 Silver III";
    }
    if (a <= 230.0D) {
      return ChatColor.GRAY + "\u2723 Silver II";
    }
    if (a <= 250.0D) {
      return ChatColor.GRAY + "\u2723 Silver I";
    }
    if (a <= 280.0D) {
      return ChatColor.YELLOW + "\u2724 Gold IV";
    }
    if (a <= 300.0D) {
      return ChatColor.YELLOW + "\u2724 Gold III";
    }
    if (a <= 315.0D) {
      return ChatColor.YELLOW + "\u2724 Gold II";
    }
    if (a <= 330.0D) {
      return ChatColor.YELLOW + "\u2724 Gold I";
    }
    if (a <= 350.0D) {
      return ChatColor.YELLOW + "\u2724 Gold I";
    }
    if (a <= 380.0D) {
      return ChatColor.YELLOW + "\u2724 Gold +";
    }
    if (a <= 400.0D) {
      return ChatColor.AQUA + "\u272a Diamond IV";
    }
    if (a <= 415.0D) {
      return ChatColor.AQUA + "\u272a Diamond III";
    }
    if (a <= 430.0D) {
      return ChatColor.AQUA + "\u272a Diamond II";
    }
    if (a <= 450.0D) {
      return ChatColor.AQUA + "\u272a Diamond I";
    }
    if (a <= 480.0D) {
      return ChatColor.AQUA + "\u272a Diamond +";
    }
    if (a <= 500.0D) {
      return ChatColor.GOLD + "\u2742 Emerald IV";
    }
    if (a <= 515.0D) {
      return ChatColor.GOLD + "\u2742 Emerald III";
    }
    if (a <= 530.0D) {
      return ChatColor.GOLD + "\u2742 Emerald II";
    }
    if (a <= 550.0D) {
      return ChatColor.GOLD + "\u2742 Emerald I";
    }
    if (a <= 580.0D) {
      return ChatColor.GOLD + "\u2742 Emerald +";
    }
    if (a <= 600.0D) {
      return ChatColor.RED + "\u273e Ruby";
    }
    return ChatColor.RED + "\u273e Ruby";
  }
  
  public static void iscoriboard(Player p)
  {
	  String nick = p.getName();
	  String jogadoronline = String.valueOf(Bukkit.getServer().getOnlinePlayers().length) + "§7/§a" + Bukkit.getServer().getMaxPlayers();
    SimpleScoreboard iscori = new SimpleScoreboard(Main.getPlugin().getConfig().getString("NomeServer").replace("&", "§"));
    int kills = KillsDeathsMoney.getKills(p);
	int deaths = KillsDeathsMoney.getDeaths(p);
    iscori.add(Main.getPlugin().getConfig().getString("Ip").replace("&", "§"));
    iscori.blankLine();
    iscori.add("§4\u27a1 §2§lMatou§6: §f" +  kills, 5);
    iscori.add("§4\u27a1 §2§lMorreu§6: §f" + deaths, 4);
    
    
    
    iscori.add("§4\u27a1 §2§lRank§6: §f" + getRank(p));
    iscori.add("§4\u27a1 §2§lNick§6: §f" + nick);
    iscori.add("§4\u27a1 §2§lXP§6: §f" + XpM.getPlayerMoney(p));
    iscori.add("§4\u27a1 §2§lKit§6: §f" + (String)Array.kit.get(p));
    
    
    
    iscori.build();
    iscori.send(new Player[] { p });
  }
}
