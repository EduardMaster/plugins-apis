package me.recenthg.Manager;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import com.google.common.collect.Lists;

import me.recenthg.Main;
import me.recenthg.Schematic;

@SuppressWarnings({"deprecation"})
public class Feastar {
	
	public static Location loc2;
	public static boolean spawnou = false;
	private static ArrayList<Block> Baus = new ArrayList<>();
	public static ArrayList<Block> remove = new ArrayList<>();
	
	public static void prepararFeast(Location loc) {
		for (int x=-20;x<=20;x++) {
			for (int z=-20;z<=20;z++) {
				spawnou=true;
				Location feast=new Location(loc.getWorld(), loc.getX() + x, loc.getY(), loc.getZ()+z);
				if (feast.distance(loc)<=20) {
					limparTerreno(feast.getBlock());
					if (new Random().nextBoolean()) {
						feast.getBlock().setType(Material.SNOW_BLOCK);
					} else {
						feast.getBlock().setType(Material.PUMPKIN);
					}
				}
			}
		}
		loc2=loc.clone().add(0, 1, 0);
        Location[] baus={loc.clone().add(1,1,1), loc.clone().add(-1,1,-1), loc.clone().add(1,1,-1), loc.clone().add(-1,1,1),
                loc.clone().add(-2,1,2), loc.clone().add(-2,1,-2), loc.clone().add(-2,1,0), loc.clone().add(2,1,0),
                loc.clone().add(0,1,-2), loc.clone().add(0,1,2), loc.clone().add(+2,1,-2), loc.clone().add(2,1,2)};
		for (Location blocos:baus) {
			Baus.add(blocos.getBlock());
		}
		new Feastar();
	}
	
	public static void limparTerreno(Block b) {
		Location loc = b.getLocation().add(0, 1, 0);
		Block br = loc.getBlock();
		do {
			br.setType(Material.AIR);
			loc.setY(loc.getY() + 1);
			br = loc.getBlock();
			
		} while (loc.getY() < loc.getWorld().getMaxHeight());
	}
	
	public static BukkitTask task;
	public static int tempo;
	
	public Feastar() {
		tempo = 301;
		task = new BukkitRunnable() {
			
			@Override
			public void run() {
				tempo--;
				if (tempo == 300) {
					Bukkit.broadcastMessage("§6§l>> §7Feast ira spawnar em §a5§7 minutos. Entre §7[§a"+loc2.getBlockX()+"§8,§a"+loc2.getBlockY()+"§8,§a"+loc2.getBlockZ()+"§7].");
				}
				if (tempo == 240) {
					Bukkit.broadcastMessage("§6§l>> §7Feast ira spawnar em §a4§7 minutos. Entre §7[§a"+loc2.getBlockX()+"§8,§a"+loc2.getBlockY()+"§8,§a"+loc2.getBlockZ()+"§7].");
				}
				if (tempo == 160) {
					Bukkit.broadcastMessage("§6§l>> §7Feast ira spawnar em §a3§7 minutos. Entre §7[§a"+loc2.getBlockX()+"§8,§a"+loc2.getBlockY()+"§8,§a"+loc2.getBlockZ()+"§7].");
				}
				if (tempo == 120) {
					Bukkit.broadcastMessage("§6§l>> §7Feast ira spawnar em §a2§7 minutos. Entre §7[§a"+loc2.getBlockX()+"§8,§a"+loc2.getBlockY()+"§8,§a"+loc2.getBlockZ()+"§7].");
				}
				if (tempo == 60) {
					Bukkit.broadcastMessage("§6§l>> §7Feast ira spawnar em §a1§7 minuto. Entre §7[§a"+loc2.getBlockX()+"§8,§a"+loc2.getBlockY()+"§8,§a"+loc2.getBlockZ()+"§7].");
				}
				if (tempo == 30) {
					Bukkit.broadcastMessage("§6§l>> §7Feast ira spawnar em §a30§7 segundos. Entre §7[§a"+loc2.getBlockX()+"§8,§a"+loc2.getBlockY()+"§8,§a"+loc2.getBlockZ()+"§7].");
				}
				if (tempo == 15) {
					Bukkit.broadcastMessage("§6§l>> §7Feast ira spawnar em §a15§7 segundos. Entre §7[§a"+loc2.getBlockX()+"§8,§a"+loc2.getBlockY()+"§8,§a"+loc2.getBlockZ()+"§7].");
				}
				if (tempo == 10) {
					Bukkit.broadcastMessage("§6§l>> §7Feast ira spawnar em §a10§7 segundos. Entre §7[§a"+loc2.getBlockX()+"§8,§a"+loc2.getBlockY()+"§8,§a"+loc2.getBlockZ()+"§7].");
				}
				if (tempo == 5) {
					Bukkit.broadcastMessage("§6§l>> §7Feast ira spawnar em §a5§7 segundos. Entre §7[§a"+loc2.getBlockX()+"§8,§a"+loc2.getBlockY()+"§8,§a"+loc2.getBlockZ()+"§7].");
				}
				if (tempo == 4) {
					Bukkit.broadcastMessage("§6§l>> §7Feast ira spawnar em §a4§7 segundos. Entre §7[§a"+loc2.getBlockX()+"§8,§a"+loc2.getBlockY()+"§8,§a"+loc2.getBlockZ()+"§7].");
				}
				if (tempo == 3) {
					Bukkit.broadcastMessage("§6§l>> §7Feast ira spawnar em §a3§7 segundos. Entre §7[§a"+loc2.getBlockX()+"§8,§a"+loc2.getBlockY()+"§8,§a"+loc2.getBlockZ()+"§7].");
				}
				if (tempo == 2) {
					Bukkit.broadcastMessage("§6§l>> §7Feast ira spawnar em §a2§7 segundos. Entre §7[§a"+loc2.getBlockX()+"§8,§a"+loc2.getBlockY()+"§8,§a"+loc2.getBlockZ()+"§7].");
				}
				if (tempo == 1) {
					Bukkit.broadcastMessage("§6§l>> §7Feast ira spawnar em §a1§7 segundos. Entre §7[§a"+loc2.getBlockX()+"§8,§a"+loc2.getBlockY()+"§8,§a"+loc2.getBlockZ()+"§7].");
				}
				if (tempo == 0) {
					for (Player s : Bukkit.getOnlinePlayers()) {
						s.playSound(s.getLocation(), Sound.EXPLODE, 2.0F, 2.0F);
						s.playSound(s.getLocation(), Sound.LEVEL_UP, 2.0F, 2.0F);
					}
					Bukkit.broadcastMessage("§6§l>> §7Feast spawnou entre §7[§a"+loc2.getBlockX()+"§8,§a"+loc2.getBlockY()+"§8,§a"+loc2.getBlockZ()+"§7].");
					Location loc=loc2.add(0, 1, 0);
					Bukkit.getWorld("world").strikeLightning(loc);
					task.cancel();
					cancel();
					Spawnar();
				}
			}
		}.runTaskTimer(Main.instance, 0L, 20L);
	}
	
	public static void Spawnar() {
		loc2.clone().add(0, -1, 0).getBlock().setType(Material.ENCHANTMENT_TABLE);
		for (Block baus:Baus) {
			baus.setType(Material.CHEST);
			Chest bau = (Chest)baus.getState();
			bau.update(true);
			int[] i = {310,311,312,313,276,261,262,276,322,282,326,327};
			for (int item:i) {
				if (new Random().nextInt(100)<27){bau.getInventory().setItem(new Random().nextInt(27), new ItemStack(item));}
			}
 		}
	}

	public void createMinifeast() {
		int x = new Random().nextInt(300);
	    int z = new Random().nextInt(300);
		
	    ArrayList<Block> array = Lists.newArrayList();
	    
		try {
			Schematic sch = Schematic.getInstance().carregarSchematics(new File(Main.instance.getDataFolder(), "minifeast.schematic"));
			Schematic.getInstance().generateSchematic(Bukkit.getWorld("world"), new Location(Bukkit.getWorld("world"), x, Bukkit.getWorld("world").getHighestBlockAt(x, z).getY(), z), sch, array);
		} catch (Exception e) {
			return;
		}

		int xM = x + 50;
		int xN = x - 50;
		int zM = z + 50;
		int zN = z - 50;
		
		for (Iterator<?> iterator = array.iterator(); iterator.hasNext(); ) {
			Block block = (Block)iterator.next();
			
			if (block.getType() == Material.CHEST) {
				Chest chest = (Chest)block.getState();
				encherMinifeast(chest);
			}
		}

		Bukkit.broadcastMessage(Main.Menssagems +  " §7Um minifeast nasceu entre: §c(" + xM + "§7,§c" + xN + ")§7 e §c(" + zM + "§7, §c" + zN + ")");
	}
	
	private void encherMinifeast(Chest chest) {
		List<String> items = Main.instance.getConfig().getStringList("minifeast");
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
				
				if (random.nextInt(100) < Main.instance.getConfig().getInt("chanceminifeast")) chest.getInventory().setItem(slot, item_add);
				
				chest.update();
			}
		}
	}
}
