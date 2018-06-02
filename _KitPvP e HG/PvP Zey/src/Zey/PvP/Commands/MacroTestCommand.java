package Zey.PvP.Commands;

import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.event.player.*;

import Zey.PvP.Main.*;

import org.bukkit.event.block.*;
import org.bukkit.event.*;
import org.bukkit.command.*;

public class MacroTestCommand implements Listener, CommandExecutor
{
    static final HashMap<String, Integer> Clicks;
    static final ArrayList<String> macro;
    
    static {
        Clicks = new HashMap<String, Integer>();
        macro = new ArrayList<String>();
    }
    
    public static void testeMAcro(final Player p, final Player t) {
        p.sendMessage(String.valueOf(Main.prefix) + " §7» §e§lMACROTEST: §7Testando no jogador(a): §e" + t.getName());
        MacroTestCommand.macro.add(t.getName());
        MacroTestCommand.Clicks.put(t.getName(), 0);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
			@Override
            public void run() {
                p.sendMessage("§c ");
                p.sendMessage("                 §e§lMACROTEST              ");
                p.sendMessage("§e» §bJogador: §7" + t.getName());
                p.sendMessage("§e» §bTotal De Clicks: §7" + MacroTestCommand.Clicks.get(t.getName()));
                p.sendMessage("§e» §bClicks 5s: §7" + MacroTestCommand.Clicks.get(t.getName()) / 2);
                p.sendMessage("§e» §bClicks 1s: §7" + MacroTestCommand.Clicks.get(t.getName()) / 10);
                p.sendMessage("§c ");
                MacroTestCommand.macro.remove(t.getName());
                if (MacroTestCommand.Clicks.get(t.getName()) >= 350) {
                	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + p.getName() + "1 semana [AutoBan] Uso de Macro/AutoClicker");
                }
            }
        }, 200L);
    }
    
    @EventHandler
    public void macro(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (MacroTestCommand.macro.contains(p.getName()) && (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK)) {
            MacroTestCommand.Clicks.put(p.getName(), MacroTestCommand.Clicks.get(p.getName()) + 1);
        }
    }
    
    public final boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
        final Player p = (Player)Sender;
        if (p.hasPermission("zey.pvp.testmacro")) {
            if (Args.length == 0) {
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §cErrado, utilize a sintaxe correta: /testmacro [Jogador(a)]");
                return true;
            }
            final Player t = Bukkit.getPlayer(Args[0]);
            if (t != null) {
                testeMAcro(p, t);
            }
        }
        return false;
    }
}
