package GUI;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitSelector
  implements Listener
{
  public static ArrayList<String> ListaKits2 = new ArrayList<String>();

  @SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
public static void InventarioKitsGui(Player p)
  {
    Inventory inv = Bukkit.getServer().createInventory(p, 54,"§2Seus Kits [1]");
    
    ItemStack vidro1 = new ItemStack(Material.getMaterial(160), 1, (short)12);
    ItemMeta metav1 = vidro1.getItemMeta();
    metav1.setDisplayName("§f Em Breve Um EZKIT");
    vidro1.setItemMeta(metav1);

	final ItemStack Carpet = new ItemStack(Material.getMaterial(160));
	Carpet.setDurability((short) 14);
	ItemMeta CarpetMeta = Carpet.getItemMeta();
	CarpetMeta.setDisplayName("§aProxima Página");
	Carpet.setItemMeta(CarpetMeta);
	
	final ItemStack Carpet1 = new ItemStack(Material.getMaterial(160));
	Carpet.setDurability((short) 4);
	ItemMeta Carpet1Meta = Carpet1.getItemMeta();
	CarpetMeta.setDisplayName("§f Em Breve Um EZKIT");
	Carpet.setItemMeta(Carpet1Meta);

    inv.setItem(0, vidro1);
    inv.setItem(1, vidro1);
    inv.setItem(2, vidro1);
    inv.setItem(3, vidro1);
    inv.setItem(5, vidro1);
    inv.setItem(6, vidro1);
    inv.setItem(7, vidro1);
    inv.setItem(4, vidro1);
    inv.setItem(8, Carpet);
    inv.setItem(33, Carpet1);
    inv.setItem(34, Carpet1);
    inv.setItem(37, Carpet1);
    inv.setItem(38, Carpet1);
    inv.setItem(39, Carpet1);
    inv.setItem(40, Carpet1);
    inv.setItem(41, Carpet1);
    inv.setItem(43, Carpet1);
    inv.setItem(42, Carpet1);
    
    
    
    inv.setItem(9, vidro1);
    inv.setItem(17, vidro1);
    inv.setItem(18, vidro1);
    inv.setItem(26, vidro1);
    inv.setItem(27, vidro1);
    inv.setItem(35, vidro1);
    inv.setItem(36, vidro1);
    inv.setItem(44, vidro1);
    inv.setItem(45, vidro1);
    inv.setItem(46, vidro1);
    inv.setItem(47, vidro1);
    inv.setItem(48, vidro1);
    inv.setItem(49, vidro1);
    inv.setItem(50, vidro1);
    inv.setItem(51, vidro1);
    inv.setItem(52, vidro1);
    inv.setItem(53, vidro1);
    
    

    if (p.hasPermission("kit.pvp")) {
      ItemStack pyro = new ItemStack(Material.STONE_SWORD);
      ItemMeta metapyro = pyro.getItemMeta();
      metapyro.setDisplayName("§7§lKit §ePvP");
      ArrayList descpyro = new ArrayList();
      descpyro.add("§7Kit Sem Habilidades");
      metapyro.setLore(descpyro);
      pyro.setItemMeta(metapyro);
      inv.addItem(new ItemStack[] { pyro });
    }
    if (p.hasPermission("kit.sonic")) {
        ItemStack pyro = new ItemStack(Material.LAPIS_BLOCK);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7§lKit §eSonic");
        ArrayList descpyro = new ArrayList();
        descpyro.add("§eSaia com seu desh e envenene seus inimigos");
        metapyro.setLore(descpyro);
        pyro.setItemMeta(metapyro);
        inv.addItem(new ItemStack[] { pyro });
      }
    if (p.hasPermission("kit.deshfire")) {
        ItemStack pyro = new ItemStack(Material.REDSTONE_BLOCK);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7§lKit §eDeshFire");
        ArrayList descpyro = new ArrayList();
        descpyro.add("§7Taque Fogo nas inimigas");
        metapyro.setLore(descpyro);
        pyro.setItemMeta(metapyro);
        inv.addItem(new ItemStack[] { pyro });
      }
    if (p.hasPermission("kit.fisherman")) {
        ItemStack pyro = new ItemStack(Material.FISHING_ROD);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7§lKit §eFisherman");
        ArrayList descpyro = new ArrayList();
        descpyro.add("§7Puxe Seus Inimigos Fisgando Eles");
        metapyro.setLore(descpyro);
        pyro.setItemMeta(metapyro);
        inv.addItem(new ItemStack[] { pyro });
      }
    if (p.hasPermission("kit.grappler")) {
        ItemStack pyro = new ItemStack(Material.LEASH);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7§lKit §eGrappler");
        ArrayList descpyro = new ArrayList();
        descpyro.add("§7Locomova-se Com Sua Corda");
        metapyro.setLore(descpyro);
        pyro.setItemMeta(metapyro);
        inv.addItem(new ItemStack[] { pyro });
      }
    if (p.hasPermission("kit.gladiator")) {
        ItemStack pyro = new ItemStack(Material.IRON_FENCE);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7§lKit §eGladiator");
        ArrayList descpyro = new ArrayList();
        descpyro.add("§7Tire 1v1 Com Seus Inimigos");
        metapyro.setLore(descpyro);
        pyro.setItemMeta(metapyro);
        inv.addItem(new ItemStack[] { pyro });
      }
    if (p.hasPermission("kit.waterbender")) {
        ItemStack pyro = new ItemStack(Material.INK_SACK, 1, (short) 4);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7§lKit §eWaterBender");
        ArrayList descpyro = new ArrayList();
        descpyro.add("§7Prenda Seus Inimigos em uma jaula de água causando veneno");
        metapyro.setLore(descpyro);
        pyro.setItemMeta(metapyro);
        inv.addItem(new ItemStack[] { pyro });
      }
    if (p.hasPermission("kit.urgal")) {
        ItemStack pyro = new ItemStack(Material.POTION);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7§lKit §eUrgal");
        ArrayList descpyro = new ArrayList();
        descpyro.add("§7Fique Forte Usando Sua Redstone");
        metapyro.setLore(descpyro);
        pyro.setItemMeta(metapyro);
        inv.addItem(new ItemStack[] { pyro });
      }
    if (p.hasPermission("kit.kangaroo")) {
        ItemStack pyro = new ItemStack(Material.FIREWORK);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7§lKit §eKangaroo");
        ArrayList descpyro = new ArrayList();
        descpyro.add("§7Pule Igual um Kanguru");
        metapyro.setLore(descpyro);
        pyro.setItemMeta(metapyro);
        inv.addItem(new ItemStack[] { pyro });
      }
    if (p.hasPermission("kit.firebender")) {
        ItemStack pyro = new ItemStack(Material.REDSTONE);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7§lKit §eFireBender");
        ArrayList descpyro = new ArrayList();
        descpyro.add("§7Prenda Seus Inimigos em uma jaula de fogo causando fogo");
        metapyro.setLore(descpyro);
        pyro.setItemMeta(metapyro);
        inv.addItem(new ItemStack[] { pyro });
      }
    if (p.hasPermission("kit.poseidon")) {
        ItemStack pyro = new ItemStack(Material.WATER_BUCKET);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7§lKit §ePoseidon");
        ArrayList descpyro = new ArrayList();
        descpyro.add("§7Fique Rápido e Forte ao entrar na água");
        metapyro.setLore(descpyro);
        pyro.setItemMeta(metapyro);
        inv.addItem(new ItemStack[] { pyro });
      }
    if (p.hasPermission("kit.stomper")) {
        ItemStack pyro = new ItemStack(Material.IRON_BOOTS);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7§lKit §eStomper");
        ArrayList descpyro = new ArrayList();
        descpyro.add("§7Mate Seus Inimigos Pulando Neles");
        metapyro.setLore(descpyro);
        pyro.setItemMeta(metapyro);
        inv.addItem(new ItemStack[] { pyro });
      }
    if (p.hasPermission("kit.anchor")) {
        ItemStack pyro = new ItemStack(Material.ANVIL);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7§lKit §eAnchor");
        ArrayList descpyro = new ArrayList();
        descpyro.add("§7Não Leve Knock e Nem de Knock");
        metapyro.setLore(descpyro);
        pyro.setItemMeta(metapyro);
        inv.addItem(new ItemStack[] { pyro });
      }
    if (p.hasPermission("kit.magma")) {
        ItemStack pyro = new ItemStack(Material.FIRE);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7§lKit §eMagma");
        ArrayList descpyro = new ArrayList();
        descpyro.add("§7Fassa Seus Inimigos Pegarem Fogo ao Baterem Neles");
        metapyro.setLore(descpyro);
        pyro.setItemMeta(metapyro);
        inv.addItem(new ItemStack[] { pyro });
      }
    if (p.hasPermission("kit.ninja")) {
        ItemStack pyro = new ItemStack(Material.COAL_BLOCK);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7§lKit §eNinja");
        ArrayList descpyro = new ArrayList();
        descpyro.add("§7Aperte Shift e Teleporte-se para seus inimigos");
        metapyro.setLore(descpyro);
        pyro.setItemMeta(metapyro);
        inv.addItem(new ItemStack[] { pyro });
      }
    if (p.hasPermission("kit.viper")) {
        ItemStack pyro = new ItemStack(Material.SPIDER_EYE);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7§lKit §eViper");
        ArrayList descpyro = new ArrayList();
        descpyro.add("§7Envenene seus inimigos");
        metapyro.setLore(descpyro);
        pyro.setItemMeta(metapyro);
        inv.addItem(new ItemStack[] { pyro });
      }
    if (p.hasPermission("kit.viking")) {
        ItemStack pyro = new ItemStack(Material.IRON_AXE);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7§lKit §eViking");
        ArrayList descpyro = new ArrayList();
        descpyro.add("§7De Mais Dano Com Machados");
        metapyro.setLore(descpyro);
        pyro.setItemMeta(metapyro);
        inv.addItem(new ItemStack[] { pyro });
      }
    if (p.hasPermission("kit.snail")) {
        ItemStack pyro = new ItemStack(Material.STRING);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7§lKit §eSnail");
        ArrayList descpyro = new ArrayList();
        descpyro.add("§7Deixe seus inimigos Lentos");
        metapyro.setLore(descpyro);
        pyro.setItemMeta(metapyro);
        inv.addItem(new ItemStack[] { pyro });
      }
    if (p.hasPermission("kit.c4")) {
        ItemStack pyro = new ItemStack(Material.TNT);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7§lKit §eC4");
        ArrayList descpyro = new ArrayList();
        descpyro.add("§7Exploda as Falsianes!");
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
        inv.setItem(inv.firstEmpty(), vidro1);
      }
    }
    p.openInventory(inv);
    ListaKits2.add(p.getName());
  }
  @EventHandler
  public void Kits(PlayerInteractEvent e) {
    Player p = e.getPlayer();
    if ((p.getItemInHand().getType() == Material.CHEST)) {
      InventarioKitsGui(p);
    }
  }

  @SuppressWarnings("deprecation")
@EventHandler
  public void onPlayerCLickInventry(InventoryClickEvent e)
  {
    Player p = (Player)e.getWhoClicked();
    if ((e.getInventory().getTitle().equalsIgnoreCase("§2Seus Kits [1]")) && (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0)) {
      e.setCancelled(true);
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lKit §ePvP")) {
    	  e.setCancelled(true);
    	  p.closeInventory();
    	  p.chat("/kit pvp");
          return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lKit §eFireBender")) {
    	  e.setCancelled(true);
    	  p.closeInventory();
    	  p.chat("/kit firebender");
          return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lKit §eSnail")) {
    	  e.setCancelled(true);
    	  p.closeInventory();
    	  p.chat("/kit snail");
          return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lKit §eViper")) {
    	  e.setCancelled(true);
    	  p.closeInventory();
    	  p.chat("/kit viper");
          return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lKit §eWaterBender")) {
    	  e.setCancelled(true);
    	  p.closeInventory();
    	  p.chat("/kit waterbender");
          return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lKit §eKangaroo")) {
    	  e.setCancelled(true);
    	  p.closeInventory();
    	  p.chat("/kit kangaroo");
          return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lKit §eStomper")) {
    	  e.setCancelled(true);
    	  p.closeInventory();
    	  p.chat("/kit stomper");
          return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lKit §eGrappler")) {
    	  e.setCancelled(true);
    	  p.closeInventory();
    	  p.chat("/kit grappler");
          return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lKit §ePoseidon")) {
    	  e.setCancelled(true);
    	  p.closeInventory();
    	  p.chat("/kit poseidon");
          return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lKit §eFisherman")) {
    	  e.setCancelled(true);
    	  p.closeInventory();
    	  p.chat("/kit fisherman");
          return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lKit §eUrgal")) {
    	  e.setCancelled(true);
    	  p.closeInventory();
    	  p.chat("/kit urgal");
          return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lKit §eGladiator")) {
    	  e.setCancelled(true);
    	  p.closeInventory();
    	  p.chat("/kit gladiator");
          return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lKit §eMagma")) {
    	  e.setCancelled(true);
    	  p.closeInventory();
    	  p.chat("/kit magma");
          return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lKit §eAnchor")) {
    	  e.setCancelled(true);
    	  p.closeInventory();
    	  p.chat("/kit anchor");
          return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lKit §eNinja")) {
    	  e.setCancelled(true);
    	  p.closeInventory();
    	  p.chat("/kit ninja");
          return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lKit §eViking")) {
    	  e.setCancelled(true);
    	  p.closeInventory();
    	  p.chat("/kit viking");
          return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lKit §eC4")) {
    	  e.setCancelled(true);
    	  p.closeInventory();
    	  p.chat("/kit c4");
          return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lKit §eDeshFire")) {
    	  e.setCancelled(true);
    	  p.closeInventory();
    	  p.chat("/kit deshfire");
          return;
      }
      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lKit §eSonic")) {
    	  e.setCancelled(true);
    	  p.closeInventory();
    	  p.chat("/kit sonic");
          return;
      }
      
    }
  }
}