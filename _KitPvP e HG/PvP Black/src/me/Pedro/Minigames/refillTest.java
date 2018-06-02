package me.Pedro.Minigames;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.Pedro.Main;
import me.Pedro.Eventos.API;
import me.Pedro.Eventos.KitAPI;

public class refillTest{
	Random rand = new Random();

	public refillTest(final Player p) {
		if (KitAPI.refillTest.contains(p.getName())){
			p.sendMessage(API.sev + "§7Você ká está em um treino");
			return ;
		}
		new BukkitRunnable() {
			int seconds = 5;

			public void run() {
				if (seconds > 0) {
					p.sendMessage(API.sev + "§7Minigame Iniciando em " + seconds + " segundos!");
					seconds = seconds - 1;
					return;
				}

				if (seconds == 0) {
					seconds = -1;
					p.getInventory().clear();
					p.sendMessage(API.sev + "§7O Desafio §cComeçou!!");
					KitAPI.refillTest.add(p.getName());
					KitAPI.refillTestTime.put(p.getName(), getTime(p) + 1);
					ItemStack sopa = Methodos.itemStack(Material.MUSHROOM_SOUP, "§aSopa");
					int r = rand.nextInt(16);
					Methodos.fillLinhaInventory(p.getInventory(), r + 9, sopa, sopa, sopa, sopa, sopa, sopa, sopa, sopa,
							sopa);
				}

				KitAPI.refillTestTime.put(p.getName(), getTime(p) + 1);
				p.setLevel(getTime(p));

				if (hasRefiled(p)) {
					p.setExp(0);
					p.getInventory().clear();
					p.sendMessage(API.sev + "§7Você terminou seu refiltest , ele foi feito em §c" + Stringtimer.timerChecker(KitAPI.refillTestTime.get(p.getName())));
		      		API.GiveSpawn(p);
		    		p.teleport(p.getWorld().getSpawnLocation());
					KitAPI.refillTest.remove(p.getName());
					KitAPI.refillTestTime.remove(p.getName());
					this.cancel();

					return;
				}

				if (!KitAPI.refillTest.contains(p.getName()) && seconds < 0) {
					this.cancel();
				}
				
				if (seconds >= 60) {
					p.sendMessage(API.sev + "§7Se passou 1 minuto e você não terminou o refil , teste cancelado");
					this.cancel();
				}
			}
		}.runTaskTimer(Main.instance, 0, 20);
	}

	private int getTime(Player p) {
		if (!KitAPI.refillTestTime.containsKey(p.getName()))
			return 0;
		else
			return KitAPI.refillTestTime.get(p.getName());
	}

	private boolean hasRefiled(Player p) {
		
		try {
			
			if (p.getInventory().getItem(0).getType() == Material.AIR) {
				return false;
			}
			if (p.getInventory().getItem(1).getType() == Material.AIR) {
				return false;
			}
			if (p.getInventory().getItem(2).getType() == Material.AIR) {
				return false;
			}
			if (p.getInventory().getItem(3).getType() == Material.AIR) {
				return false;
			}
			if (p.getInventory().getItem(4).getType() == Material.AIR) {
				return false;
			}
			if (p.getInventory().getItem(5).getType() == Material.AIR) {
				return false;
			}
			if (p.getInventory().getItem(6).getType() == Material.AIR) {
				return false;
			}
			if (p.getInventory().getItem(7).getType() == Material.AIR) {
				return false;
			}
			if (p.getInventory().getItem(8).getType() == Material.AIR) {
				return false;
			}
			
		} catch (Exception e) {
			return false;
		}

		return true;
	}

}