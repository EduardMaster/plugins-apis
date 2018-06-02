package br.com.alpha.InGame.Listeners.Feast;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

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
import br.com.alpha.InGame.Schematic.Schematic;


public class Feast {
	public static HashSet<Block> feastBlocks, enchantBlock, chestBlocks;
	public static Location feastLoc, EnchantLocation;
	public static String logoFeast = "§3§lFEAST §e»";

	public static void prepareFeast() throws InstantiationException, IllegalAccessException {
		int x = new Random().nextInt(151);
		int z = new Random().nextInt(151);
		int y = Bukkit.getWorld("world").getHighestBlockYAt(x,z);
		feastLoc = new Location(Bukkit.getWorld("world"),x, y, z);
		
		try {
			feastBlocks = Schematic.assembleSchematic(feastLoc.getWorld(), feastLoc,
					Schematic.loadSchematic(new File("plugins/schematics/feast.schematic")));
			chestBlocks = new HashSet<>();
			for (Block block : feastBlocks) {
				if (block.getType().name().contains("CHEST")) {
					chestBlocks.add(block);
					block.setType(Material.AIR);
				}
				if (block.getType().name().contains("ENCHANTMENT")) {
					EnchantLocation = block.getLocation();
					block.setType(Material.AIR);
				}
			}
		} catch (IOException e) {
			System.out.println("Erro ao spawnar schematic: " + e.toString());
		}
		new Feast();
	}

	public static int tempo;

	public Feast() {
		tempo = 301;

		Integer a = Integer.valueOf(feastLoc.getBlockX() + 53);
		Integer b = Integer.valueOf(feastLoc.getBlockY() + 3);
		Integer c = Integer.valueOf(feastLoc.getBlockZ() + 52);
		Location FeastLocalizacao = new Location(Bukkit.getWorld("world"), a, b, c);

		new BukkitRunnable() {
			public void run() {
				tempo--;
				if (tempo % 60 == 0 && tempo > 60) {
					Bukkit.broadcastMessage(
							logoFeast + "  §eO Feast irá spawnar nas coordenadas(" + FeastLocalizacao.getBlockX() + ", "
									+ FeastLocalizacao.getBlockY() + ", " + FeastLocalizacao.getBlockZ() + ") em §4§l"
									+ APIClass.formatDifferenceStr(tempo * 1000).replace("m", " §4minutos!"));
				}
				if (tempo % 60 == 0 && tempo == 60) {
					Bukkit.broadcastMessage(
							logoFeast + "  §cO Feast irá spawnar nas coordenadas(" + FeastLocalizacao.getBlockX() + ", "
									+ FeastLocalizacao.getBlockY() + ", " + FeastLocalizacao.getBlockZ() + ") em §4§l"
									+ APIClass.formatDifferenceStr(tempo * 1000).replace("m", " §4minuto!"));
				}
				if (tempo < 6 && tempo > 1) {
					Bukkit.broadcastMessage(
							logoFeast + "  §aO Feast irá spawnar nas coordenadas(" + FeastLocalizacao.getBlockX() + ", "
									+ FeastLocalizacao.getBlockY() + ", " + FeastLocalizacao.getBlockZ() + ") em §2§l"
									+ APIClass.formatDifferenceStr(tempo * 1000).replace("s", " segundos!"));
				}
				if (tempo < 5 && tempo == 1) {
					Bukkit.broadcastMessage(
							logoFeast + "  §aO Feast irá spawnar nas coordenadas(" + FeastLocalizacao.getBlockX() + ", "
									+ FeastLocalizacao.getBlockY() + ", " + FeastLocalizacao.getBlockZ() + ") em §2§l"
									+ APIClass.formatDifferenceStr(tempo * 1000).replace("s", " segundo!"));
				}
				if (tempo == 0) {
					Bukkit.broadcastMessage(
							logoFeast + " §cO Feast spawnou nas coordenadas: §f§l" + FeastLocalizacao.getBlockX() + ", "
									+ FeastLocalizacao.getBlockY() + ", " + FeastLocalizacao.getBlockZ() + "§c!");

					spawnBaus();
					spawnEnchant();
					for (Block chest : feastBlocks) {
						if (chest.getType() == Material.CHEST) {
							Chest bau = (Chest) chest.getState();
							encherFeast(bau);
						}
					}
					cancel();
				}
			}

		}.runTaskTimer(MCAlpha.mcAlpha, 0L, 20L);
	}
	
	@SuppressWarnings("deprecation")
	private void encherFeast(Chest chest) {
		List<String> items = MCAlpha.mcAlpha.getConfig().getStringList("FeastItems");
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
			int amount = 1;
			
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
				
				if (random.nextInt(100) < MCAlpha.mcAlpha.getConfig().getInt("chancefeast")) chest.getInventory().setItem(slot, item_add);
				
				chest.update();
			}
		}
	}


	public static void spawnBaus() {
		for (Block block : chestBlocks) {
			block.setType(Material.CHEST);
		}
	}

	public static void spawnEnchant() {
		EnchantLocation.getBlock().setType(Material.ENCHANTMENT_TABLE);
	}
}
