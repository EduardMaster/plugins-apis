package Net.Hunger.Feast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import Net.Hunger.Main;
import Net.Hunger.Eventos.ChecarVitoria;

public class FeastManager {
	
  public static Block mainBlock = null;
  private static Integer radius = Integer.valueOf(20);
  public static Boolean spawned = Boolean.valueOf(false);
  private static Chest[] chests = new Chest[12];
  private static ArrayList<Location> fblocks = new ArrayList<Location>();
  
  public static void announceFeast(Integer time) {
   if (mainBlock == null) {
    do {
     int min = -20;
     int max = 20;
     Random r = new Random();
     int x = r.nextInt(max - min + 1) + max;
     int z = r.nextInt(max - min + 1) + max;
     Block maisalto = ((World)Bukkit.getServer().getWorlds().get(0)).getHighestBlockAt(x, z);
     Block loca = ((World)Bukkit.getServer().getWorlds().get(0)).getBlockAt(x, maisalto.getY(), z);
     mainBlock = loca;
     } while ((mainBlock.getType() == Material.LOG) || (mainBlock.getType() == Material.LEAVES));
     mainBlock.setType(Material.getMaterial(159));
     fblocks.add(mainBlock.getLocation());
     removeAbove(mainBlock);
     createFeast(Material.getMaterial(159));
     spawned = Boolean.valueOf(true);
     ChecarVitoria.ProtecaoFeast = true;
    }
    String s = "";
    if (time.intValue() > 1) {
    s = "s";
    }
    DecimalFormat df = new DecimalFormat("##.#");
    Bukkit.broadcastMessage("§7[§a!§7] O Feast nascera nas coordenadas §f" + df.format(mainBlock.getLocation().getX()) + "§7,§f " + df.format(mainBlock.getLocation().getY()) + "§7,§f " + df.format(mainBlock.getLocation().getZ()) + "§7 em §f" + time + " §7minuto" + s + "§7 Use §f/Feast");
    Bukkit.getWorld("world").setTime(19000L);
  }
  
  public static void spawnFeast() {
    if (mainBlock == null) {
    announceFeast(Integer.valueOf(0));
    }
    DecimalFormat df = new DecimalFormat("##.#");
    Bukkit.broadcastMessage("§7[§a!§7] O Feast nasceu em §f" + df.format(mainBlock.getLocation().getX()) + "§7, §f" + df.format(mainBlock.getLocation().getY()) + "§7, §f" + df.format(mainBlock.getLocation().getZ()) + " §7[§a§lBOA SORTE§7]");
    ChecarVitoria.ProtecaoFeast = false;
    FeastManager.spawned = false;
    if (Main.BausFeast.booleanValue()) {
    spawnChests();
    }
    List<?> items = Main.instance.getConfig().getStringList("ITEMS");
    for (Object item : items) {
      String[] oneitem = ((String)item).split(",");
      Random r = new Random();
      String itemid = oneitem[0];
      Integer minamount = Integer.valueOf(Integer.parseInt(oneitem[1]));
      Integer maxamount = Integer.valueOf(Integer.parseInt(oneitem[2]));
      Integer amount = Integer.valueOf(0);
      Boolean force = Boolean.valueOf(Boolean.parseBoolean(oneitem[3]));
      Boolean spawn = force;
      Integer id = null;
      Short durability = null;
      if (!force.booleanValue()) {
      spawn = Boolean.valueOf(r.nextBoolean());
      }
      if (spawn.booleanValue()) {
      if (((String)item).contains(":")) {
       String[] it = itemid.split(":");
       id = Integer.valueOf(Integer.parseInt(it[0]));
       durability = Short.valueOf(Short.parseShort(it[1]));
       } else {
        id = Integer.valueOf(Integer.parseInt(itemid));
        }
        ItemStack i = new ItemStack(id.intValue(), 1);
        if (durability != null) {
        i.setDurability(durability.shortValue());
        }
        if (oneitem.length == 6) {
        i.addUnsafeEnchantment(Enchantment.getById(Integer.parseInt(oneitem[4])), Integer.parseInt(oneitem[5]));
        }
        Integer ra = radius;
        if (maxamount == minamount) {
        amount = maxamount;
        } else {
        amount = Integer.valueOf(minamount.intValue() + r.nextInt(maxamount.intValue() - minamount.intValue() + 1));
        }
        int maxtry;
        if (Main.BausFeast.booleanValue()) {
          Integer localInteger1;
          for (; amount.intValue() > 0; localInteger1 = amount = Integer.valueOf(amount.intValue() - 1)) {
            Chest chest = chests[r.nextInt(12)];
            Integer slot = Integer.valueOf(r.nextInt(27));
            maxtry = 0;
            while ((chest.getInventory().getItem(slot.intValue()) != null) && (!chest.getInventory().getItem(slot.intValue()).getType().equals(i.getType())) && (maxtry < 1000)) {
            slot = Integer.valueOf(r.nextInt(27));
            }
            if (chest.getInventory().getItem(slot.intValue()) != null) {
            i.setAmount(i.getAmount() + 1);
            }
            chest.getInventory().setItem(slot.intValue(), i);
            chest.update();
            localInteger1 = amount;
          }
        }
        Location c = mainBlock.getLocation();
        c.add(-(ra.intValue() / 2) + r.nextInt(ra.intValue()), 1.0D, -(ra.intValue() / 2) + r.nextInt(ra.intValue()));
        Integer slot;
        for (; amount.intValue() > 0; maxtry = (amount = Integer.valueOf(amount.intValue() - 1)).intValue()) {
          ((World)Bukkit.getServer().getWorlds().get(0)).dropItemNaturally(c, i).setPickupDelay(100);
          slot = amount;
        }
      }
    }
  }
  
  public static Boolean isFeastBlock(Block b) {
    if ((!Main.Feast.booleanValue()) || (!spawned.booleanValue())) {
    return Boolean.valueOf(false);
    }
    return Boolean.valueOf(fblocks.contains(b.getLocation()));
  }
  
  private static void createFeast(Material m) {
    Location loc = mainBlock.getLocation();
    Integer r = radius;
    for (double x = -r.intValue(); x <= r.intValue(); x += 1.0D) {
      for (double z = -r.intValue(); z <= r.intValue(); z += 1.0D) {
        Location l = new Location((World)Bukkit.getServer().getWorlds().get(0), loc.getX() + x, loc.getY(), loc.getZ() + z);
        if ((l.distance(loc) <= r.intValue()) && (l.getBlock().getType() != Material.NETHERRACK)) {
          removeAbove(l.getBlock());
          l.getBlock().setType(m);
          fblocks.add(l);
        }
      }
    }
  }
  
  private static void spawnChests() {
    Location loc = mainBlock.getLocation();
    loc.add(-3.0D, 1.0D, -3.0D);
    Integer curchest = Integer.valueOf(0);
    Main.ProtecaoFeast = Boolean.valueOf(false);
    Integer[] co = { Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(-1), Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(-1), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(-1), Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(3), Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(-1), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(-1), Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(-1), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(-1), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(-1), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(-1), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(-1), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(-1), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(-1), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(-1), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(-1) };
    for (Integer i : co) {
      Material m = Material.AIR;
      switch (i.intValue()) {
      case 0: 
        m = Material.AIR;
        break;
      case 1: 
        m = Material.OBSIDIAN;
        break;
      case 2: 
        m = Material.CHEST;
        break;
      case 3: 
        m = Material.ENCHANTMENT_TABLE;
        break;
      case 4: 
        m = Material.FENCE;
        break;
      case 5: 
        break;
      case 6: 
        m = Material.WOOD;
        break;
      case 7: 
        m = Material.GLOWSTONE;
        break;
      case -1: 
        break;
      }
      if (i.intValue() == -1) {
        loc.add(0.0D, 0.0D, 1.0D);
        loc.subtract(7.0D, 0.0D, 0.0D);
      } else if (i.intValue() == -2) {
        loc.add(0.0D, 1.0D, 0.0D);
        loc.subtract(7.0D, 0.0D, 6.0D);
      } else if (i.intValue() == 5) {
        loc.add(1.0D, 0.0D, 0.0D);
      } else {
        loc.getBlock().setType(m);
        if (i.intValue() != 0) {
        fblocks.add(loc.getBlock().getLocation());
        }
        if (m == Material.CHEST) {
          chests[curchest.intValue()] = ((Chest)loc.getBlock().getState());
          if (curchest.intValue() < 12) {
            Integer localInteger1 = curchest;localInteger1 = curchest = Integer.valueOf(curchest.intValue() + 1);
          }
        }
        loc.add(1.0D, 0.0D, 0.0D);
      }
    }
  }
  
  public static void removeAbove(Block block) {
    Location loc = block.getLocation();
    loc.setY(loc.getY() + 0.5D);
    Block newBlock = ((World)Bukkit.getServer().getWorlds().get(0)).getBlockAt(loc);
    while (loc.getY() < ((World)Bukkit.getServer().getWorlds().get(0)).getMaxHeight()) {
      newBlock.setType(Material.AIR);
      loc.setY(loc.getY() + 0.5D);
      newBlock = ((World)Bukkit.getServer().getWorlds().get(0)).getBlockAt(loc);
    }
  }
  
  public static Block getMainBlock() {
    return mainBlock;
  }
}
