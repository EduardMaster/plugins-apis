package Pedrao.Comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Pedrao.Main;

public class Kits
  implements Listener, CommandExecutor
{
  public Kits(Main main) {}

@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
public static void guiKits1(Player p)
  {
    Inventory inv = Bukkit.getServer().createInventory(p, 54, "§6Seletor de Kits:");
    
    ItemStack vidro = new ItemStack(Material.AIR);
    ItemMeta metav = vidro.getItemMeta();
    vidro.setItemMeta(metav);
    
    ItemStack ant = new ItemStack(Material.getMaterial(171), 1, (short)8);
    ItemMeta antv = ant.getItemMeta();
    antv.setDisplayName("§cImpossivel voltar");
    ant.setItemMeta(antv);
    inv.setItem(0, ant);
    
    ItemStack prox = new ItemStack(Material.getMaterial(171), 1, (short)10);
    ItemMeta proxv = prox.getItemMeta();
    proxv.setDisplayName("§aProximo");
    prox.setItemMeta(proxv);
    inv.setItem(8, prox);
    
    ItemStack stats = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
    ItemMeta statsv = stats.getItemMeta();
    statsv.setDisplayName("§7" + p.getName());
    stats.setItemMeta(statsv);
    inv.setItem(2, stats);
    
    ItemStack mkits = new ItemStack(Material.DIAMOND);
    ItemMeta mkitsv = prox.getItemMeta();
    mkitsv.setDisplayName("§A§LLista de Kits");
    mkits.setItemMeta(mkitsv);
    inv.setItem(4, mkits);
    
    ItemStack camu = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
    ItemMeta camuv = camu.getItemMeta();
    camuv.setDisplayName(Main.prefix);
    camu.setItemMeta(camuv);
    
    ItemStack camu1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)0);
    ItemMeta camu1v = camu1.getItemMeta();
    camu1v.setDisplayName(Main.prefix);
    camu1.setItemMeta(camu1v);
    
    inv.setItem(1, camu);
    inv.setItem(2, camu1);
    inv.setItem(3, camu);
    inv.setItem(5, camu);
    inv.setItem(6, camu1);
    inv.setItem(7, camu);
    if (p.hasPermission("kit.pvp"))
    {
      ItemStack pyro = new ItemStack(Material.STONE_SWORD);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lPvP");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Sem Abilidade");
      descpyro1.add("§a§l- §7");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }   
    if (p.hasPermission("kit.Archer"))
    {
      ItemStack pyro = new ItemStack(Material.BOW);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lArcher");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Ganhe um arco GG");
      descpyro1.add("§a§l- §7");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    } 
    if (p.hasPermission("kit.Kangaroo"))
    {
      ItemStack pyro = new ItemStack(Material.FIREWORK);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lKangaroo");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7De super pulos com");
      descpyro1.add("§a§l- §7seu firework ");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    } 
    if (p.hasPermission("kit.Fisherman"))
    {
      ItemStack pyro = new ItemStack(Material.FISHING_ROD);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lFisherman");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Vc vira um pescador");
      descpyro1.add("§a§l- §7de players");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    } 
    if (p.hasPermission("kit.Anchor"))
    {
      ItemStack pyro = new ItemStack(Material.ANVIL);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lAnchor");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Nao tome Knockback");
      descpyro1.add("§a§l- §7");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    } 
    if (p.hasPermission("kit.Kronos"))
    {
      ItemStack pyro = new ItemStack(Material.GLOWSTONE_DUST);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lKronos");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Fly + Speed");
      descpyro1.add("§a§l- §7");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    } 
    if (p.hasPermission("kit.Stomper"))
    {
      ItemStack pyro = new ItemStack(Material.LEATHER_BOOTS);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lStomper");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Seja um super peso");
      descpyro1.add("§a§l- §7e esmagios o seus");
      descpyro1.add("§a§l- §7inimigos");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    } 
    if (p.hasPermission("kit.Viper"))
    {
      ItemStack pyro = new ItemStack(Material.FERMENTED_SPIDER_EYE);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lViper");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Tenha 33% de");
      descpyro1.add("§a§l- §7dar veneno em");
      descpyro1.add("§a§l- §7seus inimigos");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    } 
    if (p.hasPermission("kit.Snail"))
    {
      ItemStack pyro = new ItemStack(Material.WEB);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lSnail");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Tenha 33% de");
      descpyro1.add("§a§l- §7dar veneno em");
      descpyro1.add("§a§l- §7seus inimigos");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    } 
    if (p.hasPermission("kit.Curandeiro"))
    {
      ItemStack pyro = new ItemStack(Material.SULPHUR);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lCurandeiro");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Curese e fique");
      descpyro1.add("§a§l- §7imortal");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("kit.WaterBender"))
    {
      ItemStack pyro = new ItemStack(Material.INK_SACK,1,(short)4);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lWaterBender");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Circulo de agua");
      descpyro1.add("§a§l- §7acida");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("kit.FireBender"))
    {
      ItemStack pyro = new ItemStack(Material.REDSTONE);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lFireBender");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Circulo de fogo");
      descpyro1.add("§a§l- §7quima");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("kit.DeathNote"))
    {
      ItemStack pyro = new ItemStack(Material.BOOK);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lDeathNote");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Coloque macunba");
      descpyro1.add("§a§l- §7em seus inimigos");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("kit.BloodGun"))
    {
      ItemStack pyro = new ItemStack(Material.WOOD_HOE);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lBloodGun");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Tenha uma super");
      descpyro1.add("§a§l- §7gun");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("kit.Grandpa"))
    {
      ItemStack pyro = new ItemStack(Material.STICK);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lGrandpa");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Tenha uma super");
      descpyro1.add("§a§l- §7varinha de kb");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("kit.urgal"))
    {
      ItemStack pyro = new ItemStack(Material.POTION,1,(short)8201);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lUrgal");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Tenha umas Poçao");
      descpyro1.add("§a§l- §7de  força");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("kit.Cactus"))
    {
      ItemStack pyro = new ItemStack(Material.CACTUS);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lCactus");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Seja feito de");
      descpyro1.add("§a§l- §7espinhos");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("kit.Tornado"))
    {
      ItemStack pyro = new ItemStack(Material.HOPPER);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lTornado");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Crie um tornado");
      descpyro1.add("§a§l- §7");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("kit.Urano"))
    {
      ItemStack pyro = new ItemStack(Material.SLIME_BALL);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lUrano");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Vire um material");
      descpyro1.add("§a§l- §7radioativo");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("kit.Terrorista"))
    {
      ItemStack pyro = new ItemStack(Material.MAGMA_CREAM);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lTerrorista");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Alaha Boom");
      descpyro1.add("§a§l- §7");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("kit.DeshFire"))
    {
      ItemStack pyro = new ItemStack(Material.REDSTONE_BLOCK);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lDeshFire");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7De um desh e");
      descpyro1.add("§a§l- §7deixe seus inimigos");
      descpyro1.add("§a§l- §7pegando fogo");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("kit.Sonic"))
    {
      ItemStack pyro = new ItemStack(Material.LAPIS_BLOCK);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lSonic");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7De um desh e");
      descpyro1.add("§a§l- §7deixe seus inimigos");
      descpyro1.add("§a§l- §7com poison");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("kit.Gravity"))
    {
      ItemStack pyro = new ItemStack(Material.BLAZE_ROD);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lGravity");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Puxe uma tnt do nada");
      descpyro1.add("§a§l- §7");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("kit.Rain"))
    {
      ItemStack pyro = new ItemStack(Material.ARROW);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lRain");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Spawn muita flecha");
      descpyro1.add("§a§l- §7em seu inimigo");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("kit.Jutso"))
    {
      ItemStack pyro = new ItemStack(Material.PAPER);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lJutso");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Faça jutso");
      descpyro1.add("§a§l- §7substituiçao");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("kit.Velotrol"))
    {
      ItemStack pyro = new ItemStack(Material.MINECART);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lVelotrol");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Bush e Bomm");
      descpyro1.add("§a§l- §7");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("kit.ForceField"))
    {
      ItemStack pyro = new ItemStack(Material.NETHER_FENCE);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lForceField");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Hack + FF");
      descpyro1.add("§a§l- §7");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("kit.Sasuke"))
    {
      ItemStack pyro = new ItemStack(Material.FIREWORK_CHARGE);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lSasuke");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Faça jutso bola de fogo");
      descpyro1.add("§a§l- §7");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("kit.Pikachu"))
    {
      ItemStack pyro = new ItemStack(Material.FLINT);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lPikachu");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7De um choque do troval");
      descpyro1.add("§a§l- §7e voa e teleporte para mira");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("kit.Laucher"))
    {
      ItemStack pyro = new ItemStack(Material.SPONGE);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lLaucher");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Ganhe sponjas com jump");
      descpyro1.add("§a§l- §7");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("kit.Vunerable"))
    {
      ItemStack pyro = new ItemStack(Material.BEACON);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lVunerable");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Fique NoDamege");
      descpyro1.add("§a§l- §7");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("kit.Grappler"))
    {
      ItemStack pyro = new ItemStack(Material.LEASH);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lGrappler");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Se movimente mais rapido");
      descpyro1.add("§a§l- §7");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("kit.Gladiator"))
    {
      ItemStack pyro = new ItemStack(Material.IRON_FENCE);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lGladiator");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7crie um 1v1");
      descpyro1.add("§a§l- §7");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("kit.Ninja"))
    {
      ItemStack pyro = new ItemStack(Material.COAL_BLOCK);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lNinja");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Teleport ao player");
      descpyro1.add("§a§l- §7hitado");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("kit.Hulk"))
    {
      ItemStack pyro = new ItemStack(Material.SADDLE);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lHulk");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Puxe o player na sua");
      descpyro1.add("§a§l- §7cabeça");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("kit.LifeStealer"))
    {
      ItemStack pyro = new ItemStack(Material.NETHER_STALK);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lLifeStealer");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7A cada kill ganhe");
      descpyro1.add("§a§l- §7+ 1 coraçao");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("kit.ChestPlate"))
    {
      ItemStack pyro = new ItemStack(Material.DIAMOND_CHESTPLATE);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lChestPlate");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7A cada kill up");
      descpyro1.add("§a§l- §7seu peitoral");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("kit.Sword"))
    {
      ItemStack pyro = new ItemStack(Material.DIAMOND_SWORD);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lSword");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Ao clicar troque");
      descpyro1.add("§a§l- §7de espadas");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("kit.Mago"))
    {
      ItemStack pyro = new ItemStack(Material.BONE);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lMago");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Seja o mago do");
      descpyro1.add("§a§l- §7ar");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("kit.C4"))
    {
      ItemStack pyro = new ItemStack(Material.TNT);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lC4");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Tenha uma c4");
      descpyro1.add("§a§l- §7");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("kit.Thresh"))
    {
      ItemStack pyro = new ItemStack(Material.GOLD_PICKAXE);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7Kit §6§lThresh");
      ArrayList descpyro1 = new ArrayList();
      descpyro1.add("§a§l- §7Tenha um laço");
      descpyro1.add("§a§l- §7e puxe seus inimigos");
      descpyro1.add("§a§l- §7");
      metapyro.setLore(descpyro1);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    ItemStack[] arrayOfItemStack;
    int descpyro1 = (arrayOfItemStack = inv.getContents()).length;
    for (int metapyro1 = 0; metapyro1 < descpyro1; metapyro1++)
    {
      ItemStack item = arrayOfItemStack[metapyro1];
      if (item == null) {
        inv.setItem(inv.firstEmpty(), vidro);
      }
    }
    p.openInventory(inv);
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if ((commandLabel.equalsIgnoreCase("kits")))
    {
      Player p = (Player)sender;
      
      guiKits1(p);
    }
    return false;
  }
  
  @SuppressWarnings("deprecation")
@EventHandler
  public void onPlayerCLickInventry(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if ((e.getInventory().getTitle().equalsIgnoreCase("§6Seletor de Kits:")) && 
      (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
    {
      e.setCancelled(true);
      if (e.getCurrentItem().getType() == Material.STONE_SWORD)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit pvp");
        return;
      }
      if (e.getCurrentItem().getType() == Material.GOLD_PICKAXE)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit thresh");
        return;
      }
      if (e.getCurrentItem().getType() == Material.TNT)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit c4");
        return;
      }
      if (e.getCurrentItem().getType() == Material.BONE)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit mago");
        return;
      }
      if (e.getCurrentItem().getType() == Material.DIAMOND_SWORD)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit sword");
        return;
      }
      if (e.getCurrentItem().getType() == Material.HOPPER)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit tornado");
        return;
      }
      if (e.getCurrentItem().getType() == Material.NETHER_FENCE)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit forcefield");
        return;
      }
      if (e.getCurrentItem().getType() == Material.COAL_BLOCK)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit ninja");
        return;
      }
      if (e.getCurrentItem().getType() == Material.SADDLE)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit hulk");
        return;
      }
      if (e.getCurrentItem().getType() == Material.NETHER_STALK)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit lifestealer");
        return;
      }
      if (e.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit chestplate");
        return;
      }
      if (e.getCurrentItem().getType() == Material.LEASH)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit grappler");
        return;
      }
      if (e.getCurrentItem().getType() == Material.IRON_FENCE)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.sendMessage("§C§LManutençao");
        return;
      }
      if (e.getCurrentItem().getType() == Material.BEACON)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit vunerable");
        return;
      }
      if (e.getCurrentItem().getType() == Material.SPONGE)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit laucher");
        return;
      }
      if (e.getCurrentItem().getType() == Material.FLINT)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit pikachu");
        return;
      }
      if (e.getCurrentItem().getType() == Material.MINECART)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit velotrol");
        return;
      }
      if (e.getCurrentItem().getType() == Material.FIREWORK_CHARGE)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit sasuke");
        return;
      }
      if (e.getCurrentItem().getType() == Material.PAPER)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit jutso");
        return;
      }
      if (e.getCurrentItem().getType() == Material.ARROW)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit rain");
        return;
      }
      if (e.getCurrentItem().getType() == Material.LAPIS_BLOCK)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit sonic");
        return;
      }
      if (e.getCurrentItem().getType() == Material.REDSTONE_BLOCK)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit deshfire");
        return;
      }
      if (e.getCurrentItem().getType() == Material.BLAZE_ROD)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit gravity");
        return;
      }
      if (e.getCurrentItem().getType() == Material.SLIME_BALL)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit urano");
        return;
      }
      if (e.getCurrentItem().getType() == Material.MAGMA_CREAM)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit terrorista");
        return;
      }
      if (e.getCurrentItem().getType() == Material.BOOK)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit deathnote");
        return;
      }
      if (e.getCurrentItem().getType() == Material.CACTUS)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit cactus");
        return;
      }
      if (e.getCurrentItem().getType() == Material.STICK)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit grandpa");
        return;
      }
      if (e.getCurrentItem().getType() == Material.POTION)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit urgal");
        return;
      }
      if (e.getCurrentItem().getType() == Material.WOOD_HOE)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit bloodgun");
        return;
      }
      if (e.getCurrentItem().getType() == Material.WEB)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit snail");
        return;
      }
      if (e.getCurrentItem().getType() == Material.INK_SACK)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit waterbender");
        return;
      }
      if (e.getCurrentItem().getType() == Material.REDSTONE)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit firebender");
        return;
      }
      if (e.getCurrentItem().getType() == Material.SULPHUR)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit curandeiro");
        return;
      }
      if (e.getCurrentItem().getType() == Material.FERMENTED_SPIDER_EYE)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit viper");
        return;
      }
      if (e.getCurrentItem().getType() == Material.LEATHER_BOOTS)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit stomper");
        return;
      }
      if (e.getCurrentItem().getType() == Material.BOW)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit archer");
        return;
      }
      if (e.getCurrentItem().getType() == Material.ANVIL)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit anchor");
        return;
      }
      if (e.getCurrentItem().getType() == Material.FISHING_ROD)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit fisherman");
        return;
      }
      if (e.getCurrentItem().getType() == Material.GLOWSTONE_DUST)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit kronos");
        return;
      }
      if (e.getCurrentItem().getType() == Material.FIREWORK)
      {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit kangaroo");
        return;
      }
    }
  }
}
