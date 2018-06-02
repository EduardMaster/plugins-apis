package me.rafael.vinagre.KomboPvP.Comandos;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Scoreboard.ScoreDoBasic;
import me.rafael.vinagre.KomboPvP.Comandos.Score;


public class Score extends ScoreDoBasic implements CommandExecutor
{
    public static ArrayList<String> temscore;
    public static ArrayList<String> ntemscore;
    
    static {
        Score.temscore = new ArrayList<String>();
        Score.ntemscore = new ArrayList<String>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("score")) {
            if (!Score.ntemscore.contains(p.getName())) {
                Score.ntemscore.add(p.getName());
                Score.temscore.remove(p.getName());
                p.sendMessage(String.valueOf("§bScore Adicionada"));
            }
            else {
                Score.temscore.add(p.getName());
                Score.ntemscore.remove(p.getName());
                p.sendMessage(String.valueOf( "§5Score Removida"));
            }
        }
        return false;
    }
}
