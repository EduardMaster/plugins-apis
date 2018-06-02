package Comandos;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.potion.PotionEffect;

import Main.Main;
import Outros.ScoreBoard;
import Utils.KitAPI;
import Utils.WarpsAPI;
import me.confuser.barapi.BarAPI;

public class Fisherman extends WarpsAPI implements CommandExecutor, Listener {
	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§bPrecisa ser um Player para usar esse comando");
			return true;
		}
		final Player p = (Player)sender;
		if (args.length == 0) {
		if (KitAPI.getKit(p) != "Nenhum") {
			p.sendMessage("§c§lFly§7§lTrue §a: §cVoce ja pegou um kit!");
			return true;
		}
		if (KitAPI.getKit(p) == "Nenhum") {
			segundos.add(p.getDisplayName());
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable() {
				@SuppressWarnings("deprecation")
				@Override
				public void run() {
					if (segundos.contains(p.getDisplayName())) {
					p.sendMessage("§c§lFly§7§lTrue §a: §7§lVoce entrou na arena Fisherman!");
					BarAPI.setMessage(p, "§7§lVoce entrou na arena §c§lFisherman", 3);
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 1.0F, 1.0F);
					ir(p, "Fisherman1");
					p.setLevel(0);
					segundos.remove(p.getDisplayName());
					KitAPI.ArenaFish(p);
					ScoreBoard.UpdateScore(p);
			        for (PotionEffect effect : p.getActivePotionEffects()) {
 		            p.removePotionEffect(effect.getType());
			        }
					p.setHealth(20);
					  }
				  }
			}, 1L);
			}
		} else {
			if (args[0].equalsIgnoreCase("set")) {
			    if (p.hasPermission("fly.set")) {
			    	Set(p, "Fisherman1");
			    	p.sendMessage("§c§lFly§7§lTrue §a: §b§lVoce setou a arena Fisherman!");
			}
		  }
		}
		return false;
	}
	
	@EventHandler
	public void Pescar(PlayerFishEvent e) {
		Player p = e.getPlayer();
		if (e.getCaught() instanceof Player && KitAPI.getKit(p) == "ArenaFish") {
			Player t = (Player)e.getCaught();
			t.teleport(p);
			p.sendMessage("§a§lVoce pescou §b" + t.getDisplayName());
			t.sendMessage("§aVoce foi pescado por §b" + p.getDisplayName());
		}
		
	}
 }