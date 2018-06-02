package Hacks;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import Main.Main;

public class TesteMacraum implements Listener, CommandExecutor {

	static final HashMap<String, Integer> Clicks = new HashMap<>();
	static final ArrayList<String> macro = new ArrayList<>();

	public static void testeMAcro(Player p, Player t) {
		p.sendMessage("§6§lEZKits §7Testando Macro No Jogador §e" + t.getName());
		macro.add(t.getName());
		Clicks.put(t.getName(), 0);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			@SuppressWarnings("deprecation")
			public void run() {
				p.sendMessage("§c§l§m----------------------------");
				p.sendMessage("§7Player Testado §c" + t.getName());
				p.sendMessage("§7Clicks Total §c" + Clicks.get(t.getName()));
				p.sendMessage("§7Clicks 5s §c" + Clicks.get(t.getName()) / 2);
				p.sendMessage("§7Clicks 1s §c" + Clicks.get(t.getName()) / 10);
				p.sendMessage("§c§l§m----------------------------");
				macro.remove(t.getName());
				if (Clicks.get(t.getName()) >= 350) {
					t.setBanned(true);
					t.kickPlayer("§7MACRIN");
					Bukkit.broadcastMessage("§6§lEZKits " + t.getName() + " §cFoi Banido Por Macrin");
					;
				}
			}
		}, 20 * 10);
	}

	@EventHandler
	public void macro(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (macro.contains(p.getName())) {
			if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
				Clicks.put(p.getName(), Clicks.get(p.getName()) + 1);
			}
		}
	}

	@Override
	public final boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		Player p = (Player) Sender;
		if (p.hasPermission("system.testmacro")) {
			if (Args.length == 0) {
				p.sendMessage("§6§lEZKits §7Use /testmacro (Nick)");
				return true;
			}
			Player t = Bukkit.getPlayer(Args[0]);
			if (t != null) {
				testeMAcro(p, t);
			}
		}
		return false;
		// testmacro
	}

}
