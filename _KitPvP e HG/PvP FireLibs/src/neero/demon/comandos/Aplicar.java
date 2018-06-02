package neero.demon.comandos;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Aplicar implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		Player p = (Player) sender;
		if(label.equalsIgnoreCase("aplicar")) {
			p.sendMessage("§e§lFORMULÁRIO §c§npastebin.com/CJp9zt5G \n§a§lBOA SORTE");
			p.playSound(p.getLocation(), Sound.BLAZE_HIT, 12.0F, 12.0F);
		}
		return false;
	}
}