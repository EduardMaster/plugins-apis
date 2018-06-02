package Net.Hunger.Inv;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AllKits implements Listener {
	
  public static void InventarioKitsGuiInd(Player p) {
	   
    Inventory inv = Bukkit.getServer().createInventory(p, 54, ChatColor.RED + "Kits - Todos Kits [1]");
    ItemStack vidro = new ItemStack(Material.THIN_GLASS);
    ItemMeta metav = vidro.getItemMeta();
    metav.setDisplayName("");
    vidro.setItemMeta(metav);
    
    inv.setItem(0, vidro);
    inv.setItem(1, vidro);
    inv.setItem(2, vidro);
    inv.setItem(3, vidro);
    inv.setItem(4, vidro);
    inv.setItem(5, vidro);
    inv.setItem(6, vidro);
    inv.setItem(7, vidro);
    inv.setItem(8, vidro); 
    
    ItemStack thor1 = new ItemStack(Material.SULPHUR);
    ItemMeta metathor1 = thor1.getItemMeta();
    metathor1.setDisplayName("§c§lSkill§6§lHG");
    thor1.setItemMeta(metathor1);
    inv.setItem(4, thor1);
    
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.FIREWORK);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aKangaroo");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.GRAY + " - Com seu Firework");
      descpyro.add(ChatColor.GRAY + " - Se mova rapidamente");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.WORKBENCH);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aCrafter");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.GRAY + " - Tenha uma WorkBench");
      descpyro.add(ChatColor.GRAY + " - Portatil");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.IRON_SWORD);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aSword");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.GRAY + " - Altere seus tipos de");
      descpyro.add(ChatColor.GRAY + " - Espadas");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.FERMENTED_SPIDER_EYE);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aMadman");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.GRAY + " - Deixe seus oponentes com efeito");
      descpyro.add(ChatColor.GRAY + " - De fraqueza!");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
     ItemStack pyro = new ItemStack(Material.BOWL);
     ItemMeta metapyro = pyro.getItemMeta();
     metapyro.setDisplayName("§a§lKit: §aRush");
     ArrayList<String> descpyro = new ArrayList<String>();
     descpyro.add(ChatColor.GRAY + " - Venha com itens iniciais para pvp");
     descpyro.add(ChatColor.GRAY + " - Espada,Recraft");
     metapyro.setLore(descpyro);
     pyro.setItemMeta(metapyro);
     inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.STICK);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aGrandpa");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.GRAY + " - Nasca com um stick");
      descpyro.add(ChatColor.GRAY + " - Knockback 2!");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
     }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
     ItemStack pyro = new ItemStack(Material.LEATHER_BOOTS);
     ItemMeta metapyro = pyro.getItemMeta();
     metapyro.setDisplayName("§a§lKit: §aBigJump");
     ArrayList<String> descpyro = new ArrayList<String>();
     descpyro.add(ChatColor.AQUA + "Habilidades:");
     descpyro.add(ChatColor.GRAY + " - Ao ativar seu kit seja jogado");
     descpyro.add(ChatColor.GRAY + " - Para cima se beneficiando!");
     metapyro.setLore(descpyro);
     pyro.setItemMeta(metapyro);
     inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
     ItemStack pyro = new ItemStack(Material.NAME_TAG);
     ItemMeta metapyro = pyro.getItemMeta();
     metapyro.setDisplayName("§a§lKit: §aSurprise");
     ArrayList<String> descpyro = new ArrayList<String>();
     descpyro.add(ChatColor.AQUA + "Habilidades:");
     descpyro.add(ChatColor.GRAY + " - Venha com um item random");
     descpyro.add(ChatColor.GRAY + " - Ao iniciar a partida!");
     metapyro.setLore(descpyro);
     pyro.setItemMeta(metapyro);
     inv.addItem(new ItemStack[] { pyro });
     }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.getMaterial(175));
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aCopyCat");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.GRAY + " - Ao Matar um jogador");
      descpyro.add(ChatColor.GRAY + " - Receba o kit dele!");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.BREAD);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aCultivator");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.GRAY + " - Plante arvores e trigo");
      descpyro.add(ChatColor.GRAY + " - Instantaneamente!");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("HungerGames.Kit.Cactus")) {
      ItemStack pyro = new ItemStack(Material.CACTUS);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aCacto");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.GRAY + " - Receba speed II no deserto");
      descpyro.add(ChatColor.GRAY + " - E Quebre cactos Instantâneos!");
      metapyro.setLore(descpyro);
     pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.ANVIL);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aAnchor");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.GRAY + " - Tenha seu pvp");
      descpyro.add(ChatColor.GRAY + " - Em velocidade 0!");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
     }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.LEATHER);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aBackPacker");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.GRAY + " - Tenha uma mochila com");
      descpyro.add(ChatColor.GRAY + " - Sopas gratis!");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
     }
    if (p.hasPermission("HungerGames.Kit.Enderman")) {
      ItemStack pyro = new ItemStack(Material.ENDER_PEARL);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aEnderman");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.GRAY + " - Nasca com 3 perolas do ender");
      descpyro.add(ChatColor.GRAY + " - Ao matar um jogador ganhe + 1!");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
     }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.SADDLE);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aHulk");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.GRAY + " - Pegue jogadores no colo");
      descpyro.add(ChatColor.GRAY + " - Matando com facilidade");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.LAVA_BUCKET);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aFireman");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.GRAY + " - Nao receba dano de fogo");
      descpyro.add(ChatColor.GRAY + " - Espadas de madeira dao chamas em oponentes");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
     }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.DIAMOND_BOOTS);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aTower");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.GRAY + " - Kit perfeito para torres!");
      descpyro.add(ChatColor.GRAY + " - Seja Stomper/Worm em 1 so kit!");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
     }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.IRON_AXE);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aViking");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.GRAY + " - Tenha um dano");
      descpyro.add(ChatColor.GRAY + " - Mais fortes que espadas!");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
     }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.GRAVEL);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aDemoman");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.GRAY + " - Ao colocar uma gravel e a stone plate");
      descpyro.add(ChatColor.GRAY + " - Quem pisar sera morto por uma explosao!");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.GOLD_BOOTS);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aDwarf");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.GRAY + " - Ao ficar no shift receba forças");
      descpyro.add(ChatColor.GRAY + " - Ao soltar jogue todos ao seu redor longe!");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.PORTAL);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aEndermage");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.GRAY + " - Com seu portal puxe jogadores");
      descpyro.add(ChatColor.GRAY + " - A sua posição!");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.FIRE);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aFirer");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.GRAY + " - Ao segurar shift todos ao seu redor");
      descpyro.add(ChatColor.GRAY + " - Pegarão fogo receberão Slow");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.COAL);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aForger");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.GRAY + " - Seja uma fornalha automatica");
      descpyro.add(ChatColor.GRAY + " - Faça minerios rapidamente");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.IRON_FENCE);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aGladiator");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.GRAY + " - Crie uma arena 1v1");
      descpyro.add(ChatColor.GRAY + " - Contra algum jogador!");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.LEASH);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aGrappler");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.GRAY + " - Com sua corda se mova");
      descpyro.add(ChatColor.GRAY + " - Rapidamente");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.CLAY_BALL);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aJellyfish");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.GRAY + " - Coloque agua com sua mão");
      descpyro.add(ChatColor.GRAY + " - Jogadores que cair nela receberão poison");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.WOOD);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aLumberjack");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.GRAY + " - Quebre arvores");
      descpyro.add(ChatColor.GRAY + " - Instantaneamente");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.STONE_PICKAXE);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aMiner");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.GRAY + " - Ao quebrar qualquer minerio");
      descpyro.add(ChatColor.GRAY + " - Instantaneamente");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.BLAZE_ROD);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aMonk");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.AQUA + "Habilidades:");
      descpyro.add(ChatColor.GRAY + " - Desarme seus oponentes");
      descpyro.add(ChatColor.GRAY + " - Com o item do seu kit!");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.COAL_BLOCK);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aNinja");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.AQUA + "Habilidades:");
      descpyro.add(ChatColor.GRAY + " - Ao Hitar um jogador");
      descpyro.add(ChatColor.GRAY + " - Teleporte-se a posicao dele");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.WATER_BUCKET);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aPoseidon");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.AQUA + "Habilidades:");
      descpyro.add(ChatColor.GRAY + " - Ao ficar na agua receba");
      descpyro.add(ChatColor.GRAY + " - Forca e velocidade!");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.WOOD_HOE);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aReaper");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.AQUA + "Habilidades:");
      descpyro.add(ChatColor.GRAY + " - Ao Hitar um jogador de");
      descpyro.add(ChatColor.GRAY + " - Efeito de Wither nele");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.WEB);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aSnail");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.AQUA + "Habilidades:");
      descpyro.add(ChatColor.GRAY + " - Ao hitar um jogador tenha 33% de");
      descpyro.add(ChatColor.GRAY + " - Dar efeito de lentidao II no oponente");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.FISHING_ROD);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aFisherman");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.AQUA + "Habilidades:");
      descpyro.add(ChatColor.GRAY + " - Com sua vara de pesca puxe jogadores");
      descpyro.add(ChatColor.GRAY + " - Para sua posição!");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
      }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.BOOK);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aSpecialist");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.AQUA + "Habilidades:");
      descpyro.add(ChatColor.GRAY + " - Tenha uma Enchant portatil");
      descpyro.add(ChatColor.GRAY + " - Ao matar algum jogador receba 1 de xp");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.IRON_BOOTS);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aStomper");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.AQUA + "Habilidades:");
      descpyro.add(ChatColor.GRAY + " - Esmague seus oponente");
      descpyro.add(ChatColor.GRAY + " - Bom para torres");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.SNOW_BALL);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aSwitcher");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.AQUA + "Habilidades:");
      descpyro.add(ChatColor.GRAY + " - Troque de posição com seus inimigos");
      descpyro.add(ChatColor.GRAY + " - Podendo fazer estrategias");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.TNT);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aTank");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.AQUA + "Habilidades:");
      descpyro.add(ChatColor.GRAY + " - Ao matar um jogador crie uma explosao");
      descpyro.add(ChatColor.GRAY + " - Atenção: Você não leva dano por explosoes");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.WOOD_AXE);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aThor");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.AQUA + "Habilidades:");
      descpyro.add(ChatColor.GRAY + " - Solte raios com");
      descpyro.add(ChatColor.GRAY + " - Seu machado!");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.WATCH);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aTimelord");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.AQUA + "Habilidades:");
      descpyro.add(ChatColor.GRAY + " - Congele seus oponentes");
      descpyro.add(ChatColor.GRAY + " - No ar podendo mata-lo rapidamente");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.IRON_BLOCK);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aDurability");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.AQUA + "Habilidades:");
      descpyro.add(ChatColor.GRAY + " - Seus espadas e armaduras");
      descpyro.add(ChatColor.GRAY + " - Nunca irão quebrar!");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
     }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.DIAMOND_CHESTPLATE);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aTurtle");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.AQUA + "Habilidades:");
      descpyro.add(ChatColor.GRAY + " - Ao Segurar shift");
      descpyro.add(ChatColor.GRAY + " - Tenha seu dano reduzido");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.SPIDER_EYE);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aViper");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.AQUA + "Habilidades:");
      descpyro.add(ChatColor.GRAY + " - Ao hitar um jogador tenha 33% de");
      descpyro.add(ChatColor.GRAY + " - Dar efeito de Poison no oponente");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.FLINT);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aWolff");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.AQUA + "Habilidades:");
      descpyro.add(ChatColor.GRAY + " - Ao Ativar seu kit");
      descpyro.add(ChatColor.GRAY + " - Tenha 1 cachorro a sua disposição!");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
     }
    if (p.hasPermission("HungerGames.Kit.Indisponiveis")) {
      ItemStack pyro = new ItemStack(Material.DIRT);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§a§lKit: §aWorm");
      ArrayList<String> descpyro = new ArrayList<String>();
      descpyro.add(ChatColor.AQUA + "Habilidades:");
      descpyro.add(ChatColor.GRAY + " - Pegue terra instantaneamente");
      descpyro.add(ChatColor.GRAY + " - Tenha seu dano reduzido");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    ItemStack[] arrayOfItemStack;
    int descpyro = (arrayOfItemStack = inv.getContents()).length;
    for (int metapyro = 0; metapyro < descpyro; metapyro++)
    {
      ItemStack item = arrayOfItemStack[metapyro];
      if (item == null) {
        inv.setItem(inv.firstEmpty(), vidro);
      }
    }
    p.openInventory(inv);
  }
  @SuppressWarnings("deprecation")
  @EventHandler
   public void onPlayerCLickInventry(InventoryClickEvent e) {
    Player p = (Player)e.getWhoClicked();
    if ((e.getInventory().getTitle().equalsIgnoreCase(ChatColor.RED + "Kits - Todos Kits [1]")) && (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0)) {
      e.setCancelled(true);
      if (e.getCurrentItem().getType() == Material.ENDER_PEARL) {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit enderman");
        return;
        }
      if (e.getCurrentItem().getType() == Material.CACTUS) {
        e.setCancelled(true);
        p.closeInventory();
        p.chat("/kit cacto");
        return;
      }
      if (e.getCurrentItem().getType() == Material.FLINT) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit wolff");
          return;
        }
      if (e.getCurrentItem().getType() == Material.FIRE) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit firer");
          return;
        }
      if (e.getCurrentItem().getType() == Material.getMaterial(5)) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit lumberjack");
          return;
        }
      if (e.getCurrentItem().getType() == Material.MUSHROOM_SOUP) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit hermit");
          return;
        }
      if (e.getCurrentItem().getType() == Material.ANVIL) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit anchor");
          return;
        }
      if (e.getCurrentItem().getType() == Material.CAKE) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit surprise");
          return;
        }
      if (e.getCurrentItem().getType() == Material.YELLOW_FLOWER) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit copycat");
          return;
        }
      if (e.getCurrentItem().getType() == Material.WORKBENCH) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit crafter");
          return;
        }
      if (e.getCurrentItem().getType() == Material.BREAD) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit cultivator");
          return;
        }
      if (e.getCurrentItem().getType() == Material.IRON_BLOCK) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit durability");
          return;
        }
      if (e.getCurrentItem().getType() == Material.getMaterial(175)) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit copycat");
          return;
        }
      if (e.getCurrentItem().getType() == Material.GRAVEL) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit demoman");
          return;
        }
      if (e.getCurrentItem().getType() == Material.GOLD_BOOTS) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit dwarf");
          return;
        }
      if (e.getCurrentItem().getType() == Material.PORTAL) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit endermage");
          return;
        }
      if (e.getCurrentItem().getType() == Material.FISHING_ROD) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit fisherman");
          return;
        }
      if (e.getCurrentItem().getType() == Material.COAL) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit forger");
          return;
        }
      if (e.getCurrentItem().getType() == Material.IRON_FENCE) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit gladiator");
          return;
        }
      if (e.getCurrentItem().getType() == Material.LEASH) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit grappler");
          return;
        }
      if (e.getCurrentItem().getType() == Material.SADDLE) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit hulk");
          return;
        }
      if (e.getCurrentItem().getType() == Material.LEATHER) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit backpacker");
          return;
        }
      if (e.getCurrentItem().getType() == Material.DIAMOND_BOOTS) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit tower");
          return;
        }
      if (e.getCurrentItem().getType() == Material.CLAY_BALL) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit jellyfish");
          return;
        }
      if (e.getCurrentItem().getType() == Material.FIREWORK) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit kangaroo");
          return;
        }
      if (e.getCurrentItem().getType() == Material.YELLOW_FLOWER) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit copycat");
          return;
        }
      if (e.getCurrentItem().getType() == Material.WOOD) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit lubmberjack");
          return;
        }
      if (e.getCurrentItem().getType() == Material.IRON_SWORD) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit swords");
          return;
        }
      if (e.getCurrentItem().getType() == Material.STONE_PICKAXE) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit miner");
          return;
        }
      if (e.getCurrentItem().getType() == Material.BLAZE_ROD) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit monk");
          return;
        }
      if (e.getCurrentItem().getType() == Material.COAL_BLOCK) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit ninja");
          return;
        }
      if (e.getCurrentItem().getType() == Material.WATER_BUCKET) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit poseidon");
          return;
        }
      if (e.getCurrentItem().getType() == Material.IRON_AXE) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit viking");
          return;
        }
      if (e.getCurrentItem().getType() == Material.LAVA_BUCKET) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit fireman");
          return;
        }
      if (e.getCurrentItem().getType() == Material.BOOK) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit specialist");
          return;
        }
      if (e.getCurrentItem().getType() == Material.LEATHER_BOOTS) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit bigjump");
          return;
        }
      if (e.getCurrentItem().getType() == Material.WOOD_HOE) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit reaper");
          return;
        }
      if (e.getCurrentItem().getType() == Material.BOWL) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit rush");
          return;
        }
      if (e.getCurrentItem().getType() == Material.EYE_OF_ENDER) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit seeker");
          return;
        }
      if (e.getCurrentItem().getType() == Material.WEB) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit snail");
          return;
        }
      if (e.getCurrentItem().getType() == Material.SPIDER_EYE) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit viper");
          return;
        }
      if (e.getCurrentItem().getType() == Material.ENCHANTED_BOOK) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit specialist");
          return;
        }
      if (e.getCurrentItem().getType() == Material.IRON_BOOTS) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit stomper");
          return;
        }
      if (e.getCurrentItem().getType() == Material.SNOW_BALL) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit switcher");
          return;
        }
      if (e.getCurrentItem().getType() == Material.TNT) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit tank");
          return;
        }
      if (e.getCurrentItem().getType() == Material.SLIME_BALL) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit frag");
          return;
        }
      if (e.getCurrentItem().getType() == Material.WOOD_AXE) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit thor");
          return;
        }
      if (e.getCurrentItem().getType() == Material.NAME_TAG) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit surprise");
          return;
        }
      if (e.getCurrentItem().getType() == Material.STICK) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit grandpa");
          return;
        }
      if (e.getCurrentItem().getType() == Material.FERMENTED_SPIDER_EYE) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit madman");
          return;
        }
      if (e.getCurrentItem().getType() == Material.WATCH) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit timelord");
          return;
        }
      if (e.getCurrentItem().getType() == Material.FERMENTED_SPIDER_EYE) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit madman");
          return;
        }
      if (e.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit turtle");
          return;
        }
      if (e.getCurrentItem().getType() == Material.DIRT) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit worm");
          return;
        }
      if (e.getCurrentItem().getType() == Material.POTION) {
          e.setCancelled(true);
          p.closeInventory();
          p.chat("/kit urgal");
          return;
        }
    }
  }
}