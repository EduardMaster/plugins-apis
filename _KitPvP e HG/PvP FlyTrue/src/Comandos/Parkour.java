package Comandos;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;

	import Main.Main;
	import Outros.ScoreBoard;
	import Utils.KitAPI;
	import Utils.WarpsAPI;
	import me.confuser.barapi.BarAPI;

	public class Parkour extends WarpsAPI implements CommandExecutor {
		

		@Override
		public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("§bPrecisa ser um Player para usar esse comando");
				return true;
			}
			final Player p = (Player)sender;
			if (args.length == 0) {
			if (KitAPI.getKit(p) != "Nenhum") {
				p.sendMessage("§cVoce ja pegou um kit!");
				return true;
			}
			if (KitAPI.getKit(p) == "Nenhum") {
				segundos.add(p.getDisplayName());
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable() {
					@SuppressWarnings("deprecation")
					@Override
					public void run() {
						if (segundos.contains(p.getDisplayName())) {
						p.sendMessage("§c§lFly§7§lTrue §a: §7§lVoce entrou no Parkour!");
						BarAPI.setMessage(p, "§c§lFly§7§lTrue §a: §7§lVoce entrou no §c§lParkour", 3);
						p.playSound(p.getLocation(), Sound.NOTE_PLING, 1.0F, 1.0F);
						ir(p, "Parkour");
						p.setLevel(0);
						segundos.remove(p.getDisplayName());
						KitAPI.Parkour(p);
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
				    	Set(p, "Parkour");
				    	p.sendMessage("§c§lFly§7§lTrue §a: §b§lVoce setou o Parkour!");
				}
			  }
			}
			return false;
		}
	@EventHandler
	  public void DanoDeQueda(EntityDamageEvent e)
	  {
	    if (((e.getEntity() instanceof Player)) && (e.getCause() == EntityDamageEvent.DamageCause.FALL)) {}
	    Player p = (Player)e.getEntity();
	    if (KitAPI.getKit(p).equals("Parkour"))
	    {
	      e.setCancelled(true);
	      e.setDamage(0.0D);
	    }
	  }
	}