package Minigames;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import Main.Main;
import Utils.KitAPI;


public class refillTest{
	Random rand = new Random();

	public refillTest(Player p) {
		if (KitAPI.refillTest.contains(p.getName())){
			p.sendMessage("§6§lEZKits §fVocê ká está em um treino");
			return ;
		}
		new BukkitRunnable() {
			int seconds = 5;

			public void run() {
				if (seconds > 0) {
					p.sendMessage("§6§lEZKits §aMinigame Iniciando em " + seconds + " segundos!");
					seconds = seconds - 1;
					return;
				}

				if (seconds == 0) {
					seconds = -1;
					p.getInventory().clear();
					p.sendMessage("§6§lEZKits §7O Desafio §cComeçou!!");
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
					p.sendMessage("§6§lEZKits §7Você terminou seu refiltest , ele foi feito em §c" + Stringtimer.timerChecker(KitAPI.refillTestTime.get(p.getName())));
					KitAPI.RemoveKit(p);
					p.teleport(Bukkit.getWorld("world").getSpawnLocation());
					KitAPI.inicial(p);
					KitAPI.refillTest.remove(p.getName());
					KitAPI.refillTestTime.remove(p.getName());
					this.cancel();

					return;
				}

				if (!KitAPI.refillTest.contains(p.getName()) && seconds < 0) {
					this.cancel();
				}
				
				if (seconds >= 60) {
					p.sendMessage("§6§lEZKits §cSe passou 1 minuto e você não terminou o refil , teste cancelado");
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