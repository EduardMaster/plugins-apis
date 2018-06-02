package Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;


public class Rank
  implements CommandExecutor, Listener
{
  public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args)
  {
    Player p = (Player)Sender;
    Cmd.getName().equalsIgnoreCase("rank");
    {
		p.sendMessage("§6§lLIGA§f As ligas sao divisoes, voce pode lutar por elas, observe a abaixo algumas das ligas:");
		p.sendMessage("                              ");
		p.sendMessage("§f- UNRANKED");
		p.sendMessage("§a☰ PRIMARY");
		p.sendMessage("§e☲ ADVANCED");
		p.sendMessage("§1☷ EXPERT");
		p.sendMessage("§7✶ SILVER");
		p.sendMessage("§6✶ GOLD");
		p.sendMessage("§b✦ DIAMOND");
		p.sendMessage("§5✹ ELITE");
		p.sendMessage("§c✫ MASTER");
		p.sendMessage("§4✪ LEGENDARY");
		p.sendMessage("                              ");
		p.sendMessage("§6§lLIGA§f Voce pode adiquirir estas ligas, matando players. Apos matar os jogadores voce ganhar kills, é com essas kills voce ira upar! Boa sorte!");
		return true;
	}
}
}
