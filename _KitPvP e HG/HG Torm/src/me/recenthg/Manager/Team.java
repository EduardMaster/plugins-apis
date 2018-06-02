
package me.recenthg.Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.recenthg.Main;

@SuppressWarnings("deprecation")
public class Team
implements Listener {
    
	public static HashMap<String, String> time = new HashMap<>();

	public static ArrayList<String> in = new ArrayList<String>();
    
	public static ArrayList<Player> chat = new ArrayList<Player>();
    public static String args;
    public static List<String> times;

    static {
        times = new ArrayList<String>();
    }
    
    public static String getClan(Player p) {
    	if (Main.instance.clan.getString(p.getUniqueId() + ".Clan") != "Nenhum") {
    		return Main.instance.clan.getString(p.getUniqueId() + ".Clan");
    	} else {
    		return Main.instance.clan.getString(p.getUniqueId() + ".Clan", "Nenhum");
    	}
    }
    
    public static void setClan(Player p, String clan) {
    	time.put(p.getName(), clan);
    	Main.instance.clan.set(p.getUniqueId() + ".Clan", clan);
        Main.instance.save();
    }
    
    public static void removeClan(Player p) {
    	time.remove(p.getName());
    	Main.instance.clan.set(p.getUniqueId() + ".Clan", "Nenhum");
        Main.instance.save();
    }

    
	public static List<Player> getPlayers(Player p, String team) {
        ArrayList<Player> amigos = new ArrayList<Player>();
        Player[] arrplayer = Bukkit.getServer().getOnlinePlayers();
        int n = arrplayer.length;
        int n2 = 0;
        while (n2 < n) {
            Player o = arrplayer[n2];
            if (!time.get((Object)o).equalsIgnoreCase("Nenhum") && time.get((Object)o).equalsIgnoreCase(team)) {
                amigos.add(o);
            }
            if (Main.instance.clan.getString(p.getUniqueId() + ".Clan") != "Nenhum" && Main.instance.clan.getString(p.getUniqueId() + ".Clan") == team) {
                amigos.add(o);
                Main.instance.save();
            }
            ++n2;
        }
        return amigos;
    }

    public static void enterTime(Player p, String clan) {
    	if (getClan(p) == "Nenhum") {
            setClan(p, clan);
            p.sendMessage(Main.Menssagems + "Voce entrou no clan");
            for (Player tme : Team.getPlayers(p, time.get(p))) {
                tme.sendMessage(ChatColor.AQUA + "O player -> " + p.getDisplayName() + ChatColor.AQUA + " entrou!");
            }
    	} else {
    		p.sendMessage("§cVoce ja e de uma clan !");
    	}

    }

    public static void removeTime(Player p) {
        if (getClan(p) == "Nenhum") {
            p.sendMessage(Main.Menssagems + "Voce e de nenhuma clan !");
            return;
        }
        p.sendMessage(Main.Menssagems + "Voce saiu da sua clan!");
    
        for (Player tme : Team.getPlayers(p, time.get(p))) {
            tme.sendMessage(Main.Menssagems + "O Jogador §a" + p.getDisplayName() + " §7Saiu Da Sua Clan!");
        }
        removeClan(p);
     
    }

    @EventHandler
    public void onsair(PlayerQuitEvent event) {
        Team.removeTime(event.getPlayer());
    }

    @EventHandler
    public void onDamgage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player p = (Player)event.getEntity();
            time.get(p.getName());
         
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
    	Player p = event.getPlayer();
    	if (!Main.instance.clan.contains(p.getUniqueId() + ".Clan")) {
    		time.put(p.getName(), "Nenhum");
    		Main.instance.clan.set(p.getUniqueId() + ".Clan", "Nenhum");
			Main.instance.save();
    	}
    }
}

