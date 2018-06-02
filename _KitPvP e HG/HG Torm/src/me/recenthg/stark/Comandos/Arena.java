package me.recenthg.stark.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

import me.recent.stark.Strings;
import me.recenthg.stark.Manager.Title;

public class Arena implements CommandExecutor, Listener {

	public static void AreaBattle(Location loc, int r, Material mat, int alturaY) {
		int cx = loc.getBlockX();
		int cy = loc.getBlockY();
		int cz = loc.getBlockZ();
		World w = loc.getWorld();
		int rSquared = r * r;
		for (int x = cx - r; x <= cx + r; x++) {
			for (int z = cz - r; z <= cz + r; z++) {
				for (int y = cy + 1; y <= cy + alturaY; y++) {
					if ((cx - x) * (cx - x) + (cz - z) * (cz - z) <= rSquared) {
						w.getBlockAt(x, y, z).setType(mat);
					}
				}
			}
		}
	}

	@SuppressWarnings("deprecation")
	public static void criarAreaBatle() {
		int aleatorioX = (int) (1.0D + Math.random() * 10.0D);
		int aleatorioZ = (int) (1.0D + Math.random() * 10.0D);
		int aleatorioY = 0;
		World world = Bukkit.getServer().getWorld("world");
		for (int i = 90; i > 40; i--) {
			Block blockY = world.getBlockAt(aleatorioX, i, aleatorioZ);
			int y = blockY.getTypeId();
			if (y == 0) {
				aleatorioY = i;
			}
		}

		MiniArena = true;

		Location loc = new Location(world, aleatorioX, aleatorioY, aleatorioZ);
		AreaBattle(loc, 11, Material.GLASS, 11);

		Location loc2 = new Location(world, aleatorioX, aleatorioY + 9, aleatorioZ);
		AreaBattle(loc2, 10, Material.GLOWSTONE, 1);

		Location loc3 = new Location(world, aleatorioX, aleatorioY + 1, aleatorioZ);
		AreaBattle(loc3, 10, Material.AIR, 8);

		Location loc4 = new Location(world, aleatorioX, aleatorioY + 10, aleatorioZ);
		AreaBattle(loc4, 11, Material.GLASS, 1);
		for (Player player : Bukkit.getOnlinePlayers()) {
			player.teleport(new Location(Bukkit.getWorld("world"), aleatorioX, aleatorioY + 4, aleatorioZ));
			Bukkit.getServer().getWorld("world").setTime(20000L);
		}
	}

	public static boolean MiniArena;

	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = (Player) e.getPlayer();
		if (MiniArena) {
			e.setCancelled(true);
			p.sendMessage("§8\u276e§2§l!§8\u276f §7Você não pode quebrar blocos na arena final");
			return;
		}
	}

	@EventHandler
	public void onBreak(EntityExplodeEvent e) {
		if (MiniArena) {
			e.setCancelled(true);
			return;
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String l, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§8\u276e§2§l!§8\u276f §7Comandos apenas no servidor!");
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("miniarena")) {
			if (p.hasPermission("HungerGames.c.Arena")) {
				criarAreaBatle();
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você gerou a arena final!");
				  Title.sendTitle(p, "§a! §fArena Final §a!");
			} else {
				p.sendMessage(Strings.semperm);
				return true;
			}
		}
		return true;
	}
}