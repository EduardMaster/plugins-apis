package Zey.PvP.Score;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;

import Zey.PvP.APIs.WarpAPI;
import Zey.PvP.Account.Grupos;
import Zey.PvP.Config.Status;
import Zey.PvP.Config.ZeyCoins;
import Zey.PvP.Eventos.Habilidade;
import Zey.PvP.Main.Main;

public class SPlayer
{
	private String player;
    private ScoreB sb;
    public static Main plugin;
    
    public static String Rank(final Player p) {
        final double a = Status.getKills(p);
        if (a <= 100.0) {
            return "§7(§f-§7)";
        }
        if (a <= 200.0) {
            return ChatColor.GREEN + "§7(\u268c§7)";
        }
        if (a <= 300.0) {
            return ChatColor.YELLOW + "§7(\u2630§7)";
        }
        if (a <= 400.0) {
            return "§7(§1\u2725§7)";
        }
        if (a <= 500.0) {
            return "§7(§7\u272f§7)";
        }
        if (a <= 600.0) {
            return "§7(§6\u272a§7)";
        }
        if (a <= 700.0) {
            return ChatColor.AQUA + "§7(§b\u2748§7)";
        }
        if (a <= 800.0) {
            return "§7(§2\u2738§7)";
        }
        if (a <= 900.0) {
            return ChatColor.RED + "§7(\u2739§7)";
        }
        if (a <= 1000.0) {
            return "§7(§3\u2737§7)";
        }
        if (a <= 1500.0) {
            return "§7(§4âœª§7)";
        }
        return "§7(§4âœª§7)";
    }
    
    public static String getRankConfig(final Player p) {
        final double a = Status.getKills(p);
        if (a <= 100.0) {
            return "§7Unranked";
        }
        if (a <= 200.0) {
            return "§aINICIANTE";
        }
        if (a <= 300.0) {
            return "§eAPRENDIZ";
        }
        if (a <= 400.0) {
            return "§1EXPERT";
        }
        if (a <= 500.0) {
            return "§7SILVER";
        }
        if (a <= 600.0) {
            return "§6GOLD";
        }
        if (a <= 700.0) {
            return "§bDIAMOND";
        }
        if (a <= 800.0) {
            return "§2EMERALD";
        }
        if (a <= 900.0) {
            return "§cRUBY";
        }
        if (a <= 1000.0) {
            return "§3SAFIRA";
        }
        if (a <= 1500.0) {
            return "§4LENDARIO";
        }
        return "§4LENDARIO";
    }
    
    public static String getNomeRank(final Player p) {
        final double a = Status.getKills(p);
        if (a <= 100.0) {
            return "§7Unranked";
        }
        if (a <= 200.0) {
            return "§aINICIANTE";
        }
        if (a <= 300.0) {
            return "§eAPRENDIZ";
        }
        if (a <= 400.0) {
            return "§1EXPERT";
        }
        if (a <= 500.0) {
            return "§7SILVER";
        }
        if (a <= 600.0) {
            return "§6GOLD";
        }
        if (a <= 700.0) {
            return "§bDIAMOND";
        }
        if (a <= 800.0) {
            return "§2EMERALD";
        }
        if (a <= 900.0) {
            return "§CRUBY";
        }
        if (a <= 1000.0) {
            return "§3SAFIRA";
        }
        if (a <= 1500.0) {
            return "§4LENDARIO";
        }
        return "§4LENDARIO";
    }
    
    public static String Liga(final Player p) {
        final double a = Status.getKills(p);
        if (a <= 100.0) {
            return "§7Unranked";
        }
        if (a <= 200.0) {
            return "§aINICIANTE";
        }
        if (a <= 300.0) {
            return "§eAPRENDIZ";
        }
        if (a <= 400.0) {
            return "§1EXPERT";
        }
        if (a <= 500.0) {
            return "§7SILVER";
        }
        if (a <= 600.0) {
            return "§6GOLD";
        }
        if (a <= 700.0) {
            return "§bDIAMOND";
        }
        if (a <= 800.0) {
            return "§2EMERALD";
        }
        if (a <= 900.0) {
            return "§cRUBY";
        }
        if (a <= 1000.0) {
            return "§3SAFIRA";
        }
        if (a <= 1500.0) {
            return "§4LENDARIO";
        }
        return "§4LENDARIO";
    }
    
    public SPlayer(final String player) {
        this.player = player;
        (this.sb = new ScoreB()).setSlot(DisplaySlot.SIDEBAR);
        this.sb.setName("  §6§lZey§f§lPvP  ");
        this.sb.addLine(15, "  §c ");
        this.sb.addLine(14, "  §fGrupo: ");
        this.sb.addLine(13, "  §fKills: ");
        this.sb.addLine(12, "  §fDeaths: ");
        this.sb.addLine(11, "  §c ");
        this.sb.addLine(10, "  §fZeyCoins: §a0");
        this.sb.addLine(9, "  §fKit: ");
        this.sb.addLine(8, "  §fWarp: ");
        this.sb.addLine(7, "  §fJogadores: ");
        this.sb.addLine(6, "  §c ");
        this.sb.addLine(5, "  §fRank: ");
        this.sb.addLine(4, "  §c ");
        this.sb.addLine(3, "§e    zeynetwork.tk  ");
    }    
    
    @SuppressWarnings("deprecation")
	public synchronized void updateScoreboard() {
        if (!this.sb.hasBoard(this.getPlayer())) {
            this.sb.setForPlayer(this.getPlayer());
            
        }
        final Player p = Bukkit.getPlayer(player);
		this.sb.updateLine(14, "  §fGrupo: " + Grupos.getGrupos(p));
		this.sb.updateLine(13, "  §fKills: §7" + Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".kills"));
		this.sb.updateLine(12, "  §fDeaths: §7" + Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".mortes"));
		this.sb.updateLine(10, "  §fZeyCoins: §a" + ZeyCoins.getPlayerMoney(p));
		this.sb.updateLine(9, "  §fKit: §e" + Habilidade.getAbility(p));
		this.sb.updateLine(8, "  §fWarp: §e" + WarpAPI.getWarp(p));
        this.sb.updateLine(7, "  §fJogadores: §7" + Bukkit.getOnlinePlayers().length + "§f/§7150  ");
		this.sb.updateLine(5, "  §fRank: " + Liga(p));
    }    	
    
    public Player getPlayer() {
        return Bukkit.getPlayer(this.player);
    }
}
