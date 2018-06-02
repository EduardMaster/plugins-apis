package br.com.alpha.InGame.Listeners.MiniFeast;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import br.com.alpha.MCAlpha;
import br.com.alpha.APIs.APIClass;
import br.com.alpha.APIs.Title;
import br.com.alpha.InGame.Schematic.Schematic;


public class MiniFeast {

	private static Location miniFeastLoc;
	private static HashSet<Block> MiniFeastBlocks;

	public static void prepareMiniFeasts() throws InstantiationException, IllegalAccessException {
		new BukkitRunnable() {

			@Override
			public void run() {
				miniFeastLoc = new Location(Bukkit.getWorld("world"), new Random().nextInt(451), 0,
						new Random().nextInt(451));
				miniFeastLoc.setY(Bukkit.getWorld("world").getHighestBlockYAt(miniFeastLoc.getBlockX(),
						miniFeastLoc.getBlockZ()));
				try {
					MiniFeastBlocks = Schematic.assembleSchematic(miniFeastLoc.getWorld(), miniFeastLoc,
							Schematic.loadSchematic(new File("plugins/schematics/minifeast.schematic")));

				} catch (IOException e) {
					System.out.println("Erro ao spawnar schematic: " + e.toString());
				}
				miniFeastLoad();
				for (Block chest : MiniFeastBlocks) {
					if (chest.getType() == Material.CHEST) {
						Chest bau = (Chest) chest.getState();
							encherMinifeast(bau);
					}
				}

			}
		}.runTaskTimer(MCAlpha.mcAlpha, 300 * 20L, 300 * 20L);
	}
	
	@SuppressWarnings("deprecation")
	private static void encherMinifeast(Chest chest) {
		List<String> items = MCAlpha.mcAlpha.getConfig().getStringList("minifeast");
		for (Iterator<?> iterator = items.iterator(); iterator.hasNext();) {
			String spliter = (String) iterator.next();

			String[] split = spliter.split(",");
			Random random = new Random();
			
			String itemid = split[0];
			int minamount = Integer.valueOf(split[1]);
			int maxamount = Integer.valueOf(split[2]);
			boolean force = Boolean.valueOf(split[3]);
			short durability = 9999;
			boolean next = force;
			int id = 0;
			int amount = 0;
			
			if (force == false) next = random.nextBoolean();
			
			if (next == true) {
				if (spliter.contains(";")) {
					String[] Split = itemid.split(";");
					id = Integer.valueOf(Split[0]);
					durability = Short.valueOf(Split[1]);
				} else {
					id = Integer.valueOf(itemid);
				}
				
				ItemStack item_add = new ItemStack(id, 1);
				
				if (durability != 9999) item_add.setDurability(durability);
				
				if (split.length == 6)  item_add.addUnsafeEnchantment(Enchantment.getById(Integer.valueOf(split[4])), Integer.valueOf(split[5]));
				
				if (maxamount == minamount) amount = maxamount;
				else amount = random.nextInt(maxamount - minamount + 1);
				
				item_add.setAmount(amount);
				int slot = chest.getInventory().firstEmpty();
				
				if (random.nextInt(100) < MCAlpha.mcAlpha.getConfig().getInt("chanceminifeast")) chest.getInventory().setItem(slot, item_add);
				
				chest.update();
			}
		}
	}

	private static void miniFeastLoad() {
		Integer calX, calX2, CalZ, CalZ2;
		calX2 = miniFeastLoc.getBlockX() - new Random().nextInt(51);
		calX = miniFeastLoc.getBlockX() + new Random().nextInt(51);
		CalZ2 = miniFeastLoc.getBlockZ() - new Random().nextInt(51);
		CalZ = miniFeastLoc.getBlockZ() + new Random().nextInt(51);
		Bukkit.broadcastMessage("§aSpawnou um MiniFeast entre as coordenadas  §2§lX: §2" + calX + "~"
				+ calX2 + " §2§lZ: §2" + CalZ + "~" + CalZ2);
		for (UUID p : APIClass.JogadoresInGame) {
			Title.sendXPBarMessage(Bukkit.getPlayer(p).getPlayer(),
					"§2§lX: §2" + calX + "~" + calX2 + " §2§lZ: §2" + CalZ + "~" + CalZ2);
		}
	}
}
