package Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import Main.Main;

public class ChatMute
implements CommandExecutor,
Listener {
    public static boolean b = false;

    public ChatMute(Main instace) {
		// TODO Auto-generated constructor stub
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage((Object)ChatColor.RED + "Apenas jogadores podem dar este comando!");
            return true;
        }
        Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("fecharchat") && p.hasPermission("cmd.admin")) {
            if (!b) {
            	Bukkit.broadcastMessage((String)(" "));
                Bukkit.broadcastMessage((String)("§6§lCHAT §fO Chat §3§lGERAL §fFoi §c§lDESATIVADO."));
                Bukkit.broadcastMessage((String)(" "));
                b = true;
            } else if (b) {
            	Bukkit.broadcastMessage((String)(" "));
                Bukkit.broadcastMessage((String)("§6§lCHAT §fO Chat §3§lGERAL §fFoi §a§lATIVADO."));
                Bukkit.broadcastMessage((String)(" "));
                b = false;
            }
        }
        return false;
    }

    @EventHandler
    public void a(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("cringed.chat") && b) {
            event.setCancelled(true);
            player.sendMessage("§6§lCHAT §fO Chat está atualmente §c§lDESATIVADO§f.");
        }
    }
}