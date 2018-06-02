package Scoreboard;

import org.bukkit.entity.*;
import org.bukkit.event.Listener;

import me.rafael.vinagre.KomboPvP.Main;

import org.bukkit.*;
import org.bukkit.craftbukkit.v1_7_R4.entity.*;

public class Genocida implements Listener
{
    
    
    public static void adicionarKill(final Player p, final int i) {
        final int Value = Main.getInstance().status.getInt(String.valueOf(p.getName()) + ".Matou");
        Main.getInstance().status.set(String.valueOf(p.getName()) + ".Matou", (Object)(Value + i));
        Main.getInstance().save();
    }
    
    public static void adicionarDeaths(final Player p, final int i) {
        final int Value = Main.getInstance().status.getInt(String.valueOf(p.getName()) + ".Morreu");
        Main.getInstance().status.set(String.valueOf(p.getName()) + ".Morreu", (Object)(Value + i));
        Main.getInstance().save();
    }
    
    
    
    public static int getKills(final Player p) {
        return Main.getInstance().status.getInt(String.valueOf(p.getName()) + ".Matou");
    }
    
    public static int getDeaths(final Player p) {
        return Main.getInstance().status.getInt(String.valueOf(p.getName()) + ".Morreu");
    }
    
}