package Zey.PvP.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import Zey.PvP.Main.Main;

public class InfoCommand implements CommandExecutor {

	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		
		Player player = (Player)Sender;
		
		if(Cmd.getName().equalsIgnoreCase("ajuda")) {
            player.sendMessage(String.valueOf(Main.prefix) + " §7» §fAqui está algumas informações, sobre nossa rede.");
        	player.sendMessage("§f ");
            player.sendMessage("§fSite: §ewww.zeynetwork.tk");
            player.sendMessage("§fTwitter: §bwww.twitter.com/ZeyNetwork_");
            player.sendMessage("§fYouTube: §cwww.youtube.com/§f");
            player.sendMessage("§fDiscord: §9www.discord.me/ZeyNetwork");
            player.sendMessage("§f ");
		}
		return false;
	}
}
