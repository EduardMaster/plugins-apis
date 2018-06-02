package br.com.alpha.Comandos;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.alpha.MCAlpha;
import br.com.alpha.ENUMs.Prefix;
import br.com.alpha.ENUMs.Success;
import br.com.alpha.gamemanagement.GameTime;

public class Spawn implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player && cmd.getName().equalsIgnoreCase("spawn")) {

			Player p = (Player) sender;

			if (MCAlpha.Status != GameTime.PREGAME) {
				p.sendMessage(MCAlpha.Logo + " §cNão é possível teleportar você para o spawn nessa parte do jogo.");
				return true;
			}

			Location spawn = p.getWorld().getSpawnLocation();

			Integer randomX = new Random().nextInt(spawn.getBlockX() + 50);
			Integer RandomZ = new Random().nextInt(spawn.getBlockZ() + 75);
			Integer YHigh = p.getWorld().getHighestBlockYAt(randomX, RandomZ);

			p.teleport(new Location(p.getWorld(), randomX, YHigh, RandomZ));
			Prefix.TELEPORT.enviar(p, Success.TELEPORTE.msg());

		}
		return false;
	}

}
