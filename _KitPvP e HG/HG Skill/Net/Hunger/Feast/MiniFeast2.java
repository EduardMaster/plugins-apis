package Net.Hunger.Feast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import Net.Hunger.Main;
import Net.Hunger.Borda.BorderType;
import Net.Hunger.Borda.WorldBorder;
import Net.Hunger.Manager.Arquivos;

public class MiniFeast2
{
  private static Block mainBlock = null;
  private static Integer radius = Integer.valueOf(3);
  private static Logger log = Bukkit.getLogger();
  private static Boolean spawned = Boolean.valueOf(false);
  private static Chest[] chests = new Chest[4];
  private static ArrayList<Location> fblocks = new ArrayList();
  public static int presentEndingDataValue = 15;
  public static int presentStartingDataValue = 0;
  public static String presentName = ChatColor.WHITE + "" + ChatColor.ITALIC + 
    "Presente para kit - %s";
  
  public static Location getRespawn() {
  double borderSize = 100.0D;
  Location spawn = ((World)Bukkit.getWorlds().get(0)).getSpawnLocation();
  double addX = new Random().nextInt((int)(borderSize / 2.0D)) + borderSize / 2.0D; 
  double addZ = new Random().nextInt((int)(borderSize / 2.0D)) + borderSize / 2.0D;
  if (new Random().nextBoolean()) {
  addX = -addX;
  }
  if (new Random().nextBoolean()) {
  addZ = -addZ;
  }
  Block block = spawn.getWorld().getHighestBlockAt((int)(spawn.getX() + addX), (int)(spawn.getZ() + addZ));
  if (!block.getChunk().isLoaded()) {
  block.getChunk().load();
  }
  while ((block.getRelative(BlockFace.UP).getType() != Material.AIR) && (!block.isLiquid())) {
  block.getRelative(BlockFace.UP);
  }
  block.getLocation().add(0.0D, 2.0D, 0.0D);
  return block.getLocation();
  }
  public static void announceFeast()
  {
    if (mainBlock == null)
    {
      do
      {
        mainBlock = getRespawn().add(0.0D, 2.0D, 0.0D).getBlock();
      } while (!WorldBorder.inBorder(mainBlock.getLocation(), BorderType.WARN));
      mainBlock.setType(Material.GLASS);
      fblocks.add(mainBlock.getLocation());
      createFeast(Material.GLASS);
      spawned = Boolean.valueOf(true);
      spawnFeast();
    }
  }
  
  public static void spawnFeast() {
    DecimalFormat df = new DecimalFormat("##");
    Bukkit.broadcastMessage("§7[§a!§7] Um mini feast nasceu entre §fX: §f(" + 
    df.format(mainBlock.getLocation().getX() + 50.0D) + " §7e §f" + 
    df.format(mainBlock.getLocation().getX() - 50.0D) + ") §7e §fZ: (" + 
    df.format(mainBlock.getLocation().getZ() + 50.0D) + " §7e§f " + 
    df.format(mainBlock.getLocation().getZ() - 50.0D) + ")");
    spawnChests();
    
    List<String> items = Arquivos.MiniFeast.getStringList("ITEMS");
    for (String item : items) {
      String[] oneitem = item.split(",");
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
      if (spawn.booleanValue())
      {
        if (item.contains(":"))
        {
          String[] it = itemid.split(":");
          id = Integer.valueOf(Integer.parseInt(it[0]));
          durability = Short.valueOf(Short.parseShort(it[1]));
        }
        else
        {
          id = Integer.valueOf(Integer.parseInt(itemid));
        }
        if (maxamount == minamount) {
          amount = maxamount;
        } else {
          amount = Integer.valueOf(minamount.intValue() + r.nextInt(maxamount.intValue() - minamount.intValue() + 1));
        }
        ItemStack i = new ItemStack(id.intValue(), r.nextInt(amount.intValue()));
        if (i.getMaxStackSize() == 1) {
          i = new ItemStack(id.intValue(), 1);
        }
        if (durability != null) {
          i.setDurability(durability.shortValue());
        }
        if (oneitem.length == 6) {
          i.addUnsafeEnchantment(
            Enchantment.getById(Integer.parseInt(oneitem[4])), 
            Integer.parseInt(oneitem[5]));
        }
        while (amount.intValue() > 0)
        {
          Chest chest = chests[r.nextInt(4)];
          Integer slot = Integer.valueOf(r.nextInt(27));
          if (chest.getInventory().getItem(slot.intValue()) != null) {
            i.setAmount(i.getAmount() + 1);
            chest.update();
          }
          chest.getInventory().addItem(new ItemStack[] { i });
          chest.update();
          if (i.getAmount() > 1) {
            amount = Integer.valueOf(amount.intValue() - i.getAmount());
            chest.update();
          } else {
            amount = Integer.valueOf(amount.intValue() - 1);
            chest.update();
          }
          chest.update();
        }
      }
    }
  }
  
  private static void createFeast(Material m)
  {
    Integer r = radius;
    
    log.info("Generating feast.");
    for (double x = -r.intValue(); x <= r.intValue(); x += 1.0D) {
      for (double z = -r.intValue(); z <= r.intValue(); z += 1.0D)
      {
        Location loc = mainBlock.getLocation();
        Location l = new Location(
          (World)Bukkit.getServer().getWorlds().get(0), loc.getX() + x, 
          loc.getY(), loc.getZ() + z);
        if (l.distance(loc) <= r.intValue())
        {
          l.getBlock().setType(m);
          fblocks.add(l);
        }
      }
    }
  }
  
  private static void spawnChests()
  {
    Location loc = mainBlock.getLocation();
    loc.add(-3.0D, 1.0D, -3.0D);
    Integer curchest = Integer.valueOf(0);
    Integer[] co = { Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(-1), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(-1), Integer.valueOf(5), 
      Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(-1), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(3), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(-1), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(2), 
      Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(-1), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(-1), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(-2) };
    for (Integer i : co)
    {
      Material m = Material.AIR;
      switch (i.intValue())
      {
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
        m = Material.DIAMOND_BLOCK;
        break;
      case 7: 
        m = Material.BEACON;
        break;
      case -1: 
        break;
      case -2: 
        break;
      default: 
        log.warning("Algo ocorreu enquanto spawnava os baus: " + 
        i.toString());
      }
      if (i.intValue() == -1)
      {
        loc.add(0.0D, 0.0D, 1.0D);
        loc.subtract(7.0D, 0.0D, 0.0D);
      }
      else if (i.intValue() == -2)
      {
        loc.add(0.0D, 1.0D, 0.0D);
        loc.subtract(7.0D, 0.0D, 6.0D);
      }
      else if (i.intValue() == 5)
      {
        loc.add(1.0D, 0.0D, 0.0D);
      }
      else
      {
        loc.getBlock().setType(m);
        if (i.intValue() != 0) {
          fblocks.add(loc.getBlock().getLocation());
        }
        if (m == Material.CHEST)
        {
          chests[curchest.intValue()] = ((Chest)loc.getBlock().getState());
          if (curchest.intValue() < 4) {
            curchest = Integer.valueOf(curchest.intValue() + 1);
          }
        }
        loc.add(1.0D, 0.0D, 0.0D);
      }
    }
  }
  public static Block getMainBlock()
  {
    return mainBlock;
  }
}