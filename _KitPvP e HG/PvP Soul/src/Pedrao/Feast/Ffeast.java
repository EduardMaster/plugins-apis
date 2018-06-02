package Pedrao.Feast;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import Pedrao.Main;

public class Ffeast
  implements Listener
{
  public Ffeast(Main main) {
	}

public static void setSimulatorCords1(Player player)
  {
    ConfigurationSection list = Main.getPlugin().getConfig().getConfigurationSection("MiniFeast");
    Location loc = player.getLocation();
    list.set("x", Integer.valueOf(loc.getBlockX()));
    list.set("y", Integer.valueOf(loc.getBlockY()));
    list.set("z", Integer.valueOf(loc.getBlockZ()));
    Main.plugin.saveConfig();
  }
  
  @SuppressWarnings("deprecation")
public static void miniFeast()
  {
    for (Player p1 : Bukkit.getServer().getOnlinePlayers())
    {
      ConfigurationSection list = Main.getPlugin().getConfig().getConfigurationSection("MiniFeast");
      int x = ((Integer)list.get("x")).intValue();
      int y = ((Integer)list.get("y")).intValue();
      int z = ((Integer)list.get("z")).intValue();
      Random r = new Random();
      

      p1.getLocation().getWorld().getBlockAt(x + 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z + 1).setType(Material.CHEST);
      p1.getLocation().getWorld().getBlockAt(x - 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z - 1).setType(Material.CHEST);
      p1.getLocation().getWorld().getBlockAt(x - 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z + 1).setType(Material.CHEST);
      p1.getLocation().getWorld().getBlockAt(x + 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z - 1).setType(Material.CHEST);
      p1.getLocation().getWorld().getBlockAt(x + 2, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z).setType(Material.CHEST);
      p1.getLocation().getWorld().getBlockAt(x + 0, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z).setType(Material.ENCHANTMENT_TABLE);
      

      p1.getLocation().getWorld().getBlockAt(x - 2, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z).setType(Material.CHEST);
      


      p1.getLocation().getWorld().getBlockAt(x, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z + 2).setType(Material.CHEST);
      p1.getLocation().getWorld().getBlockAt(x, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z - 2).setType(Material.CHEST);
      

      Chest e2 = (Chest)p1.getLocation().getWorld().getBlockAt(x - 2, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z).getState();
      
      if (r.nextInt(100) <= 100) {
          e2.getBlockInventory().setItem(new Random().nextInt(e2.getBlockInventory().getSize()), new ItemStack(Material.GOLDEN_APPLE));
        }
        if (r.nextInt(100) <= 100) {
          e2.getBlockInventory().setItem(new Random().nextInt(e2.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_LEGGINGS));
        }
        if (r.nextInt(100) <= 100) {
          e2.getBlockInventory().setItem(new Random().nextInt(e2.getBlockInventory().getSize()), new ItemStack(Material.SNOW_BALL, 16));
        }
        if (r.nextInt(100) <= 100) {
          e2.getBlockInventory().setItem(new Random().nextInt(e2.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_HELMET));
        }
        if (r.nextInt(100) <= 100) {
          e2.getBlockInventory().setItem(new Random().nextInt(e2.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_CHESTPLATE));
        }
        if (r.nextInt(100) <= 100) {
          e2.getBlockInventory().setItem(new Random().nextInt(e2.getBlockInventory().getSize()), new ItemStack(Material.EXP_BOTTLE));
        }
        e2.getBlockInventory().setItem(new Random().nextInt(e2.getBlockInventory().getSize()), new ItemStack(Material.ENDER_PEARL, 3));
        if (r.nextInt(100) <= 100) {
          e2.getBlockInventory().setItem(new Random().nextInt(e2.getBlockInventory().getSize()), new ItemStack(Material.STONE_SWORD));
        }
        e2.getBlockInventory().setItem(new Random().nextInt(e2.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16410));
        if (r.nextInt(100) <= 100) {
          e2.getBlockInventory().setItem(new Random().nextInt(e2.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16426));
        }
        if (r.nextInt(100) <= 100) {
          e2.getBlockInventory().setItem(new Random().nextInt(e2.getBlockInventory().getSize()), new ItemStack(Material.POTION, 
            1, (short)16460));
        }
        if (r.nextInt(100) <= 100) {
          e2.getBlockInventory().setItem(new Random().nextInt(e2.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16418));
        }
        if (r.nextInt(100) <= 100) {
          e2.getBlockInventory().setItem(new Random().nextInt(e2.getBlockInventory().getSize()), new ItemStack(Material.EXP_BOTTLE));
          

          Chest f2 = (Chest)p1.getLocation().getWorld().getBlockAt(x + 2, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z).getState();
          if (r.nextInt(100) <= 100) {
            f2.getBlockInventory().setItem(new Random().nextInt(f2.getBlockInventory().getSize()), new ItemStack(Material.GOLDEN_APPLE));
          }
          if (r.nextInt(100) <= 100) {
            f2.getBlockInventory().setItem(new Random().nextInt(f2.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16424));
          }
          if (r.nextInt(100) <= 100) {
            f2.getBlockInventory().setItem(new Random().nextInt(f2.getBlockInventory().getSize()), new ItemStack(Material.ARROW, 5));
          }
          if (r.nextInt(100) <= 100) {
            f2.getBlockInventory().setItem(new Random().nextInt(f2.getBlockInventory().getSize()), new ItemStack(Material.BOW));
          }
          if (r.nextInt(100) <= 100) {
            f2.getBlockInventory().setItem(new Random().nextInt(f2.getBlockInventory().getSize()), new ItemStack(Material.ARROW,20));
          }
          if (r.nextInt(100) <= 100) {
            f2.getBlockInventory().setItem(new Random().nextInt(f2.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_CHESTPLATE));
          }
          if (r.nextInt(100) <= 100) {
            f2.getBlockInventory().setItem(new Random().nextInt(f2.getBlockInventory().getSize()), new ItemStack(Material.EXP_BOTTLE));
          }
          f2.getBlockInventory().setItem(new Random().nextInt(f2.getBlockInventory().getSize()), new ItemStack(Material.MUSHROOM_SOUP, 3));
          if (r.nextInt(100) <= 100) {
            f2.getBlockInventory().setItem(new Random().nextInt(f2.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_LEGGINGS));
          }
          f2.getBlockInventory().setItem(new Random().nextInt(f2.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16410));
          if (r.nextInt(100) <= 100) {
            f2.getBlockInventory().setItem(new Random().nextInt(f2.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16426));
          }
          if (r.nextInt(100) <= 100) {
            f2.getBlockInventory().setItem(new Random().nextInt(f2.getBlockInventory().getSize()), new ItemStack(Material.POTION, 
              1, (short)16460));
          }
          if (r.nextInt(100) <= 100) {
            f2.getBlockInventory().setItem(new Random().nextInt(f2.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16418));
            Chest d2 = (Chest)p1.getLocation().getWorld().getBlockAt(x + 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z - 1).getState();
            if (r.nextInt(100) <= 100) {
              d2.getBlockInventory().setItem(new Random().nextInt(d2.getBlockInventory().getSize()), new ItemStack(Material.GOLDEN_APPLE));
            }
            if (r.nextInt(100) <= 100) {
              d2.getBlockInventory().setItem(new Random().nextInt(d2.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16424));
            }
            if (r.nextInt(100) <= 100) {
              d2.getBlockInventory().setItem(new Random().nextInt(d2.getBlockInventory().getSize()), new ItemStack(Material.ARROW, 5));
            }
            if (r.nextInt(100) <= 100) {
              d2.getBlockInventory().setItem(new Random().nextInt(d2.getBlockInventory().getSize()), new ItemStack(Material.BOW));
            }
            if (r.nextInt(100) <= 100) {
              d2.getBlockInventory().setItem(new Random().nextInt(d2.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_HELMET));
            }
            if (r.nextInt(100) <= 100) {
              d2.getBlockInventory().setItem(new Random().nextInt(d2.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_CHESTPLATE));
            }
            if (r.nextInt(100) <= 100) {
              d2.getBlockInventory().setItem(new Random().nextInt(d2.getBlockInventory().getSize()), new ItemStack(Material.EXP_BOTTLE));
            }
            d2.getBlockInventory().setItem(new Random().nextInt(d2.getBlockInventory().getSize()), new ItemStack(Material.MUSHROOM_SOUP, 3));
            if (r.nextInt(100) <= 100) {
              d2.getBlockInventory().setItem(new Random().nextInt(d2.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_LEGGINGS));
            }
            d2.getBlockInventory().setItem(new Random().nextInt(d2.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16410));
            if (r.nextInt(100) <= 100) {
              d2.getBlockInventory().setItem(new Random().nextInt(d2.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16426));
            }
            if (r.nextInt(100) <= 100) {
              d2.getBlockInventory().setItem(new Random().nextInt(d2.getBlockInventory().getSize()), new ItemStack(Material.POTION, 
                1, (short)16460));
            }
            if (r.nextInt(100) <= 100) {
              d2.getBlockInventory().setItem(new Random().nextInt(d2.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16460));
            }
            Chest b2 = (Chest)p1.getLocation().getWorld().getBlockAt(x + 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z + 1).getState();
            if (r.nextInt(100) <= 100) {
              b2.getBlockInventory().setItem(new Random().nextInt(b2.getBlockInventory().getSize()), new ItemStack(Material.GOLDEN_APPLE));
            }
            if (r.nextInt(100) <= 100) {
              b2.getBlockInventory().setItem(new Random().nextInt(b2.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16424));
            }
            if (r.nextInt(100) <= 100) {
              b2.getBlockInventory().setItem(new Random().nextInt(b2.getBlockInventory().getSize()), new ItemStack(Material.ARROW, 5));
            }
            if (r.nextInt(100) <= 100) {
              b2.getBlockInventory().setItem(new Random().nextInt(b2.getBlockInventory().getSize()), new ItemStack(Material.BOW));
            }
            if (r.nextInt(100) <= 100) {
              b2.getBlockInventory().setItem(new Random().nextInt(b2.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_HELMET));
            }
            if (r.nextInt(100) <= 100) {
              b2.getBlockInventory().setItem(new Random().nextInt(b2.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_CHESTPLATE));
            }
            if (r.nextInt(100) <= 100) {
              b2.getBlockInventory().setItem(new Random().nextInt(b2.getBlockInventory().getSize()), new ItemStack(Material.EXP_BOTTLE));
            }
            b2.getBlockInventory().setItem(new Random().nextInt(b2.getBlockInventory().getSize()), new ItemStack(Material.MUSHROOM_SOUP, 3));
            if (r.nextInt(100) <= 100) {
              b2.getBlockInventory().setItem(new Random().nextInt(b2.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_LEGGINGS));
            }
            b2.getBlockInventory().setItem(new Random().nextInt(b2.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16410));
            if (r.nextInt(100) <= 100) {
              b2.getBlockInventory().setItem(new Random().nextInt(b2.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16426));
            }
            if (r.nextInt(100) <= 100) {
              b2.getBlockInventory().setItem(new Random().nextInt(b2.getBlockInventory().getSize()), new ItemStack(Material.POTION, 
                1, (short)16460));
            }
            if (r.nextInt(100) <= 100) {
              b2.getBlockInventory().setItem(new Random().nextInt(b2.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16418));
            }
            Chest b3 = (Chest)p1.getLocation().getWorld().getBlockAt(x - 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z - 1).getState();
            if (r.nextInt(100) <= 100) {
              b3.getBlockInventory().setItem(new Random().nextInt(b3.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_HELMET));
            }
            if (r.nextInt(100) <= 100) {
              b3.getBlockInventory().setItem(new Random().nextInt(b3.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_CHESTPLATE));
            }
            if (r.nextInt(100) <= 100) {
              b3.getBlockInventory().setItem(new Random().nextInt(b3.getBlockInventory().getSize()), new ItemStack(Material.GOLDEN_APPLE));
            }
            if (r.nextInt(100) <= 100) {
              b3.getBlockInventory().setItem(new Random().nextInt(b3.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16424));
            }
            if (r.nextInt(100) <= 100) {
              b3.getBlockInventory().setItem(new Random().nextInt(b3.getBlockInventory().getSize()), new ItemStack(Material.ARROW, 5));
            }
            if (r.nextInt(100) <= 100) {
              b3.getBlockInventory().setItem(new Random().nextInt(b3.getBlockInventory().getSize()), new ItemStack(Material.BOW));
            }
            if (r.nextInt(100) <= 100) {
              b3.getBlockInventory().setItem(new Random().nextInt(b3.getBlockInventory().getSize()), new ItemStack(Material.EXP_BOTTLE));
            }
            b3.getBlockInventory().setItem(new Random().nextInt(b3.getBlockInventory().getSize()), new ItemStack(Material.MUSHROOM_SOUP, 3));
            if (r.nextInt(100) <= 100) {
              b3.getBlockInventory().setItem(new Random().nextInt(b3.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_LEGGINGS));
            }
            b3.getBlockInventory().setItem(new Random().nextInt(b3.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16410));
            if (r.nextInt(100) <= 100) {
              b3.getBlockInventory().setItem(new Random().nextInt(b3.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16426));
            }
            if (r.nextInt(100) <= 100) {
              b3.getBlockInventory().setItem(new Random().nextInt(b3.getBlockInventory().getSize()), new ItemStack(Material.POTION, 
                1, (short)16460));
            }
            if (r.nextInt(100) <= 100) {
              Chest c1 = (Chest)p1.getLocation().getWorld().getBlockAt(x + 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z) + 1, z).getState();
              if (r.nextInt(100) <= 100) {
                c1.getBlockInventory().setItem(new Random().nextInt(c1.getBlockInventory().getSize()), new ItemStack(Material.GOLDEN_APPLE));
              }
              if (r.nextInt(100) <= 100) {
                c1.getBlockInventory().setItem(new Random().nextInt(c1.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16424));
              }
              if (r.nextInt(100) <= 100) {
                c1.getBlockInventory().setItem(new Random().nextInt(c1.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_HELMET));
              }
              if (r.nextInt(100) <= 100) {
                c1.getBlockInventory().setItem(new Random().nextInt(c1.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_CHESTPLATE));
              }
              if (r.nextInt(100) <= 100) {
                c1.getBlockInventory().setItem(new Random().nextInt(c1.getBlockInventory().getSize()), new ItemStack(Material.ARROW, 5));
              }
              if (r.nextInt(100) <= 100) {
                c1.getBlockInventory().setItem(new Random().nextInt(c1.getBlockInventory().getSize()), new ItemStack(Material.BOW));
              }
              if (r.nextInt(100) <= 100) {
                c1.getBlockInventory().setItem(new Random().nextInt(c1.getBlockInventory().getSize()), new ItemStack(Material.EXP_BOTTLE));
              }
              c1.getBlockInventory().setItem(new Random().nextInt(c1.getBlockInventory().getSize()), new ItemStack(Material.MUSHROOM_SOUP, 3));
              if (r.nextInt(100) <= 100) {
                c1.getBlockInventory().setItem(new Random().nextInt(c1.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_LEGGINGS));
              }
              c1.getBlockInventory().setItem(new Random().nextInt(c1.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16410));
              if (r.nextInt(100) <= 100) {
                c1.getBlockInventory().setItem(new Random().nextInt(c1.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16426));
              }
              if (r.nextInt(100) <= 100) {
                c1.getBlockInventory().setItem(new Random().nextInt(c1.getBlockInventory().getSize()), new ItemStack(Material.POTION, 
                  1, (short)16460));
              }
              if (r.nextInt(100) <= 100) {
                c1.getBlockInventory().setItem(new Random().nextInt(c1.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16418));
              }
              Chest c2 = (Chest)p1.getLocation().getWorld().getBlockAt(x + 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z) + 1, z).getState();
              if (r.nextInt(100) <= 100) {
                c2.getBlockInventory().setItem(new Random().nextInt(c2.getBlockInventory().getSize()), new ItemStack(Material.GOLDEN_APPLE));
              }
              if (r.nextInt(100) <= 100) {
                c2.getBlockInventory().setItem(new Random().nextInt(c2.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16424));
              }
              if (r.nextInt(100) <= 100) {
                c2.getBlockInventory().setItem(new Random().nextInt(c2.getBlockInventory().getSize()), new ItemStack(Material.ARROW, 5));
              }
              if (r.nextInt(100) <= 100) {
                c2.getBlockInventory().setItem(new Random().nextInt(c2.getBlockInventory().getSize()), new ItemStack(Material.BOW));
              }
              if (r.nextInt(100) <= 100) {
                c2.getBlockInventory().setItem(new Random().nextInt(c2.getBlockInventory().getSize()), new ItemStack(Material.EXP_BOTTLE));
              }
              c2.getBlockInventory().setItem(new Random().nextInt(c2.getBlockInventory().getSize()), new ItemStack(Material.MUSHROOM_SOUP, 3));
              if (r.nextInt(100) <= 100) {
                c2.getBlockInventory().setItem(new Random().nextInt(c2.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_LEGGINGS));
              }
              c2.getBlockInventory().setItem(new Random().nextInt(c2.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16410));
              if (r.nextInt(100) <= 100) {
                c2.getBlockInventory().setItem(new Random().nextInt(c2.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16426));
              }
              if (r.nextInt(100) <= 100) {
                c2.getBlockInventory().setItem(new Random().nextInt(c2.getBlockInventory().getSize()), new ItemStack(Material.POTION, 
                  1, (short)16460));
              }
              if (r.nextInt(100) <= 100) {
                c2.getBlockInventory().setItem(new Random().nextInt(c2.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_HELMET));
              }
              if (r.nextInt(100) <= 100) {
                c2.getBlockInventory().setItem(new Random().nextInt(c2.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_CHESTPLATE));
              }
              if (r.nextInt(100) <= 100) {
                c2.getBlockInventory().setItem(new Random().nextInt(c2.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16418));
              }
              Chest c3 = (Chest)p1.getLocation().getWorld().getBlockAt(x, p1.getLocation().getWorld().getHighestBlockYAt(x, z) + 1, z + 1).getState();
              if (r.nextInt(100) <= 100) {
                c3.getBlockInventory().setItem(new Random().nextInt(c3.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_HELMET));
              }
              if (r.nextInt(100) <= 100) {
                c3.getBlockInventory().setItem(new Random().nextInt(c3.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_CHESTPLATE));
              }
              if (r.nextInt(100) <= 100) {
                c3.getBlockInventory().setItem(new Random().nextInt(c3.getBlockInventory().getSize()), new ItemStack(Material.EXP_BOTTLE));
              }
              c3.getBlockInventory().setItem(new Random().nextInt(c3.getBlockInventory().getSize()), new ItemStack(Material.MUSHROOM_SOUP, 3));
              if (r.nextInt(100) <= 100) {
                c3.getBlockInventory().setItem(new Random().nextInt(c3.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_LEGGINGS));
              }
              c3.getBlockInventory().setItem(new Random().nextInt(c3.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16410));
              if (r.nextInt(100) <= 100) {
                c3.getBlockInventory().setItem(new Random().nextInt(c3.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16426));
              }
              if (r.nextInt(100) <= 100) {
                c3.getBlockInventory().setItem(new Random().nextInt(c3.getBlockInventory().getSize()), new ItemStack(Material.POTION, 
                  1, (short)16460));
              }
              if (r.nextInt(100) <= 100) {
                c3.getBlockInventory().setItem(new Random().nextInt(c3.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16418));
              }
              if (r.nextInt(100) <= 100) {
                c3.getBlockInventory().setItem(new Random().nextInt(c3.getBlockInventory().getSize()), new ItemStack(Material.GOLDEN_APPLE));
              }
              if (r.nextInt(100) <= 100) {
                c3.getBlockInventory().setItem(new Random().nextInt(c3.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16424));
              }
              if (r.nextInt(100) <= 100) {
                c3.getBlockInventory().setItem(new Random().nextInt(c3.getBlockInventory().getSize()), new ItemStack(Material.ARROW, 5));
              }
              if (r.nextInt(100) <= 100) {
                c3.getBlockInventory().setItem(new Random().nextInt(c3.getBlockInventory().getSize()), new ItemStack(Material.BOW));
                

                Chest c4 = (Chest)p1.getLocation().getWorld().getBlockAt(x, p1.getLocation().getWorld().getHighestBlockYAt(x, z) + 1, z - 1).getState();
                if (r.nextInt(100) <= 100) {
                  c4.getBlockInventory().setItem(new Random().nextInt(c4.getBlockInventory().getSize()), new ItemStack(Material.ARROW, 5));
                }
                if (r.nextInt(100) <= 100) {
                  c4.getBlockInventory().setItem(new Random().nextInt(c4.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_HELMET));
                }
                if (r.nextInt(100) <= 100) {
                  c4.getBlockInventory().setItem(new Random().nextInt(c4.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_CHESTPLATE));
                }
                if (r.nextInt(100) <= 100) {
                  c4.getBlockInventory().setItem(new Random().nextInt(c4.getBlockInventory().getSize()), new ItemStack(Material.BOW));
                }
                if (r.nextInt(100) <= 100) {
                  c4.getBlockInventory().setItem(new Random().nextInt(c4.getBlockInventory().getSize()), new ItemStack(Material.GOLDEN_APPLE));
                }
                if (r.nextInt(100) <= 100) {
                  c4.getBlockInventory().setItem(new Random().nextInt(c4.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16424));
                }
                if (r.nextInt(100) <= 100) {
                  c4.getBlockInventory().setItem(new Random().nextInt(c4.getBlockInventory().getSize()), new ItemStack(Material.EXP_BOTTLE));
                }
                c4.getBlockInventory().setItem(new Random().nextInt(c4.getBlockInventory().getSize()), new ItemStack(Material.MUSHROOM_SOUP, 3));
                if (r.nextInt(100) <= 100) {
                  c4.getBlockInventory().setItem(new Random().nextInt(c4.getBlockInventory().getSize()), new ItemStack(Material.EXP_BOTTLE));
                }
                c4.getBlockInventory().setItem(new Random().nextInt(c4.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16410));
                if (r.nextInt(100) <= 100) {
                  c4.getBlockInventory().setItem(new Random().nextInt(c4.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16426));
                }
                if (r.nextInt(100) <= 100) {
                  c4.getBlockInventory().setItem(new Random().nextInt(c4.getBlockInventory().getSize()), new ItemStack(Material.POTION, 
                    1, (short)16460));
                }
                if (r.nextInt(100) <= 100) {
                  c4.getBlockInventory().setItem(new Random().nextInt(c4.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16418));

              }
            }
          }

        }
        }
        }
  }
  
  public static void miniFeast1()
  {
    for (Player p1 : Bukkit.getServer().getOnlinePlayers())
    {
      ConfigurationSection list = Main.getPlugin().getConfig().getConfigurationSection("MiniFeast");
      int x = ((Integer)list.get("x")).intValue();
      int y = ((Integer)list.get("y")).intValue();
      int z = ((Integer)list.get("z")).intValue();
      Random r = new Random();
      
      p1.getLocation().getWorld().getBlockAt(x + 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z + 1).setType(Material.AIR);
      p1.getLocation().getWorld().getBlockAt(x - 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z - 1).setType(Material.AIR);
      p1.getLocation().getWorld().getBlockAt(x - 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z + 1).setType(Material.AIR);
      p1.getLocation().getWorld().getBlockAt(x + 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z - 1).setType(Material.AIR);
      p1.getLocation().getWorld().getBlockAt(x + 2, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z).setType(Material.AIR);
      p1.getLocation().getWorld().getBlockAt(x + 0, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z).setType(Material.AIR);
      

      p1.getLocation().getWorld().getBlockAt(x - 2, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z).setType(Material.AIR);
      


      p1.getLocation().getWorld().getBlockAt(x + 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z) + 1, z).setType(Material.AIR);
      p1.getLocation().getWorld().getBlockAt(x - 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z) + 1, z).setType(Material.AIR);
      p1.getLocation().getWorld().getBlockAt(x, p1.getLocation().getWorld().getHighestBlockYAt(x, z) + 1, z + 1).setType(Material.AIR);
      p1.getLocation().getWorld().getBlockAt(x, p1.getLocation().getWorld().getHighestBlockYAt(x, z) + 1, z - 1).setType(Material.AIR);
      p1.getLocation().getWorld().getBlockAt(x, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z + 2).setType(Material.AIR);
      p1.getLocation().getWorld().getBlockAt(x, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z - 2).setType(Material.AIR);
    }
  }
}
