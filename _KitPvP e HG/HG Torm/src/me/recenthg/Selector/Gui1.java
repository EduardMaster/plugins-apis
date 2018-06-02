package me.recenthg.Selector;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.recenthg.Main;
import me.recenthg.Utils.Estado;

public class Gui1 implements Listener {

	public static ArrayList<String> ListaKits2 = new ArrayList<String>();
	
	@SuppressWarnings("deprecation")
	public static void InventarioGui(Player p) {
		Inventory inv = Bukkit.getServer().createInventory(p, 54, ChatColor.RED + "§7Kit [§e1§7]");
		ItemStack vidro1 = new ItemStack(Material.getMaterial(160), 1, (short) 0);
		ItemMeta metav1 = vidro1.getItemMeta();
		metav1.setDisplayName(" ");
		vidro1.setItemMeta(metav1);

		ItemStack vidro12 = new ItemStack(Material.getMaterial(160), 1, (short) 11);
		ItemMeta metav12 = vidro12.getItemMeta();
		metav12.setDisplayName(" ");
		vidro12.setItemMeta(metav12);

		inv.setItem(0, vidro12);
		inv.setItem(1, vidro12);
		inv.setItem(2, vidro12);
		inv.setItem(3, vidro12);
		inv.setItem(4, vidro12);
		inv.setItem(5, vidro12);
		inv.setItem(6, vidro12);
		inv.setItem(7, vidro12);
		inv.setItem(8, vidro12);
		inv.setItem(9, vidro12);
		inv.setItem(17, vidro12);
		inv.setItem(26, vidro12);
		inv.setItem(18, vidro12);
		inv.setItem(27, vidro12);
		inv.setItem(35, vidro12);
		inv.setItem(36, vidro12);
		inv.setItem(44, vidro12);
		inv.setItem(45, vidro12);
		inv.setItem(46, vidro12);
		inv.setItem(47, vidro12);
		inv.setItem(48, vidro12);
		inv.setItem(49, vidro12);
		inv.setItem(50, vidro12);
		inv.setItem(51, vidro12);
		inv.setItem(52, vidro12);
		inv.setItem(53, vidro12);

		ItemStack Carpets = new ItemStack(Material.getMaterial(351), 1, (short) 10);
		ItemMeta metacarpets = Carpets.getItemMeta();
		metacarpets.setDisplayName("§a§lProxima Pagina");
		Carpets.setItemMeta(metacarpets);
		inv.setItem(8, Carpets);

		if (p.hasPermission("Torm.Kit.Kangaroo") || p.hasPermission("Torm.Kit.*")) {
			ItemStack pyro = new ItemStack(Material.FIREWORK);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§aKangaroo");
			ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇ §e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			descpyro.add(ChatColor.GREEN + "Com Seu Firework De Double-Jumps!");
			descpyro.add(ChatColor.GREEN + "Clique Com O Botao Direito!");
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("Torm.Kit.Viper") || p.hasPermission("Torm.Kit.*")) {
			ItemStack pyro = new ItemStack(Material.FERMENTED_SPIDER_EYE);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§aViper");
			ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ §7▇ ▆ ▅ ▄ ▃ ▂");
			descpyro.add(ChatColor.GREEN + "Hit Um Player E De Veneno A Ele!");
			descpyro.add(ChatColor.GREEN + "Clique Com O Botao Direito!");
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ §7▇ ▆ ▅ ▄ ▃ ▂");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("Torm.Kit.Snail") || p.hasPermission("Torm.Kit.*")) {
			ItemStack pyro = new ItemStack(Material.STRING);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§aSnail");
			ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			descpyro.add(ChatColor.GREEN + "Hit Um Player E De Lentidao A Ele!");
			descpyro.add(ChatColor.GREEN + "Clique Com O Botao Direito!");
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("Torm.Kit.Anchor") || p.hasPermission("Torm.Kit.*")) {
			ItemStack pyro = new ItemStack(Material.ANVIL);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§aAnchor");
			ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			descpyro.add(ChatColor.GREEN + "Hit Um Player E Nao Deixe Ele Andar!");
			descpyro.add(ChatColor.GREEN + "Clique Com O Botao Direito!");
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("Torm.Kit.Aladdin") || p.hasPermission("Torm.Kit.*")) {
			ItemStack pyro = new ItemStack(Material.CARPET);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§aAladdin");
			ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			descpyro.add(ChatColor.GREEN + "Voe Com Seu Tapete Magico!");
			descpyro.add(ChatColor.GREEN + "Clique Com O Botao Direito!");
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("Torm.Kit.Thor") || p.hasPermission("Torm.Kit.*")) {
			ItemStack pyro = new ItemStack(Material.STONE_AXE);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§aThor");
			ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			descpyro.add(ChatColor.GREEN + "Lançe Raio Com Seu Machado!");
			descpyro.add(ChatColor.GREEN + "Clique Com O Botao Direito!");
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("Torm.Kit.LumberJack") || p.hasPermission("Torm.Kit.*")) {
			ItemStack pyro = new ItemStack(Material.WOOD_AXE);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§aLumberJack");
			ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			descpyro.add(ChatColor.GREEN + "Quebre Madeiras Rapidamente!");
			descpyro.add(ChatColor.GREEN + "Clique Com O Botao Direito!");
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("Torm.Kit.Fisherman") || p.hasPermission("Torm.Kit.*")) {
			ItemStack pyro = new ItemStack(Material.FISHING_ROD);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§aFisherman");
			ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			descpyro.add(ChatColor.GREEN + "Fisgue Os Players Com Sua Vara!");
			descpyro.add(ChatColor.GREEN + "Clique Com O Botao Direito!");
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("Torm.Kit.Fireman") || p.hasPermission("Torm.Kit.*")) {
			ItemStack pyro = new ItemStack(Material.LAVA_BUCKET);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§aFireman");
			ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			descpyro.add(ChatColor.GREEN + "Seja Imuniu A Lava!");
			descpyro.add(ChatColor.GREEN + "Clique Com O Botao Direito!");
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("Torm.Kit.Poseidon") || p.hasPermission("Torm.Kit.*")) {
			ItemStack pyro = new ItemStack(Material.WATER_BUCKET);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§aPoseidon");
			ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			descpyro.add(ChatColor.GREEN + "Ganhe Foras Na Agua!");
			descpyro.add(ChatColor.GREEN + "Clique Com O Botao Direito!");
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("Torm.Kit.Surprise") || p.hasPermission("Torm.Kit.*")) {
			ItemStack pyro = new ItemStack(Material.NAME_TAG);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§aSurprise");
			ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			descpyro.add(ChatColor.GREEN + "Ganhe Kits Ramdon!");
			descpyro.add(ChatColor.GREEN + "Clique Com O Botao Direito!");
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("Torm.Kit.Ninja") || p.hasPermission("Torm.Kit.*")) {
			ItemStack pyro = new ItemStack(Material.COAL_BLOCK);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§aNinja");
			ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			descpyro.add(ChatColor.GREEN + "Ao Hitar um jogador Teleporte Ate Ele!");
			descpyro.add(ChatColor.GREEN + "Clique Com O Botao Direito!");
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("Torm.Kit.Specialist") || p.hasPermission("Torm.Kit.*")) {
			ItemStack pyro = new ItemStack(Material.BOOK);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§aSpecialist");
			ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			descpyro.add(ChatColor.GREEN + "Ao Matar um jogador Ganhe 1 De XP!");
			descpyro.add(ChatColor.GREEN + "Clique Com O Botao Direito!");
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("Torm.Kit.Stomper") || p.hasPermission("Torm.Kit.*")) {
			ItemStack pyro = new ItemStack(Material.IRON_BOOTS);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§aStomper");
			ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			descpyro.add(ChatColor.GREEN + "Coma Terra E Estompe Inimigos!");
			descpyro.add(ChatColor.GREEN + "Clique Com O Botao Direito!");
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("Torm.Kit.Tower") || p.hasPermission("Torm.Kit.*")) {
			ItemStack pyro = new ItemStack(Material.GRASS);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§aTower");
			ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			descpyro.add(ChatColor.GREEN + "Coma Terra E Estompe Inimigos!");
			descpyro.add(ChatColor.GREEN + "Clique Com O Botao Direito!");
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("Torm.Kit.Grappler") || p.hasPermission("Torm.Kit.*")) {
			ItemStack pyro = new ItemStack(Material.LEASH);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§aGrappler");
			ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			descpyro.add(ChatColor.GREEN + "Se Mova Rapidamente Com Sua Corda!");
			descpyro.add(ChatColor.GREEN + "Clique Com O Botao Direito!");
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("Torm.Kit.Endermage") || p.hasPermission("Torm.Kit.*")) {
			ItemStack pyro = new ItemStack(Material.ENDER_PORTAL_FRAME);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§aEndermage");
			ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			descpyro.add(ChatColor.GREEN + "Puxe Os Players Com Seu Portal!");
			descpyro.add(ChatColor.GREEN + "Clique Com O Botao Direito!");
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("Torm.Kit.Cultivator") || p.hasPermission("Torm.Kit.*")) {
			ItemStack pyro = new ItemStack(Material.SEEDS);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§aCultivator");
			ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			descpyro.add(ChatColor.GREEN + "Seja Cultivador!");
			descpyro.add(ChatColor.GREEN + "Clique Com O Botao Direito!");
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("Torm.Kit.BurstMaster") || p.hasPermission("Torm.Kit.*")) {
			ItemStack pyro = new ItemStack(Material.GOLD_HOE);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§aBurstMaster");
			ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			descpyro.add(ChatColor.GREEN + "Lançe Uma Rajada De Fogo!");
			descpyro.add(ChatColor.GREEN + "Clique Com O Botao Direito!");
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("Torm.Kit.Turtle") || p.hasPermission("Torm.Kit.*")) {
			ItemStack pyro = new ItemStack(Material.DIAMOND_CHESTPLATE);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§aTurtle");
			ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			descpyro.add(ChatColor.GREEN + "Tome Menos Dano De Shift!");
			descpyro.add(ChatColor.GREEN + "Clique Com O Botao Direito!");
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("Torm.Kit.Vulcanos") || p.hasPermission("Torm.Kit.*")) {
			ItemStack pyro = new ItemStack(Material.FIREWORK_CHARGE);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§aVulcanos");
			ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ §7▇ ▆ ▅ ▄ ▃ ▂");
			descpyro.add(ChatColor.GREEN + "Seja Um Vulcano!");
			descpyro.add(ChatColor.GREEN + "Clique Com O Botao Direito!");
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ §7▇ ▆ ▅ ▄ ▃ ▂");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("Torm.Kit.Crafter") || p.hasPermission("Torm.Kit.*")) {
			ItemStack pyro = new ItemStack(Material.WORKBENCH);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§aCrafter");
			ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ §7▇ ▆ ▅ ▄ ▃ ▂");
			descpyro.add(ChatColor.GREEN + "Tenha Uma CraftTable Portatil!");
			descpyro.add(ChatColor.GREEN + "Clique Com O Botao Direito!");
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ §7▇ ▆ ▅ ▄ ▃ ▂");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("Torm.Kit.Hulk") || p.hasPermission("Torm.Kit.*")) {
			ItemStack pyro = new ItemStack(Material.JUKEBOX);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§aHulk");
			ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			descpyro.add(ChatColor.GREEN + "Pegue Os Players Com Sua Mao!");
			descpyro.add(ChatColor.GREEN + "Clique Com O Botao Direito!");
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("Torm.Kit.Gladiator") || p.hasPermission("Torm.Kit.*")) {
			ItemStack pyro = new ItemStack(Material.IRON_FENCE);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§aGladiator");
			ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			descpyro.add(ChatColor.GREEN + "Puxe Os Player Para Ir Em Uma Arena 1v1!");
			descpyro.add(ChatColor.GREEN + "Clique Com O Botao Direito!");
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("Torm.Kit.Velotrol") || p.hasPermission("Torm.Kit.*")) {
			ItemStack pyro = new ItemStack(Material.MINECART);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§aVelotrol");
			ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			descpyro.add(ChatColor.GREEN + "Voe E Exploda Seu Inimigos!");
			descpyro.add(ChatColor.GREEN + "Clique Com O Botao Direito!");
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("Torm.Kit.Reaper") || p.hasPermission("Torm.Kit.*")) {
			ItemStack pyro = new ItemStack(Material.WOOD_HOE);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§aReaper");
			ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			descpyro.add(ChatColor.GREEN + "De Poder De Whiter!");
			descpyro.add(ChatColor.GREEN + "Clique Com O Botao Direito!");
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("Torm.Kit.CopyCat") || p.hasPermission("Torm.Kit.*")) {
			ItemStack pyro = new ItemStack(Material.getMaterial(175));
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§aCopyCat");
			ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			descpyro.add(ChatColor.GREEN + "Ao Matar Um Player Robe o Kit Dele!");
			descpyro.add(ChatColor.GREEN + "Clique Com O Botao Direito!");
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("Torm.Kit.Well") || p.hasPermission("Torm.Kit.*")) {
			ItemStack pyro = new ItemStack(Material.GOLD_NUGGET);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§aWell");
			ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			descpyro.add(ChatColor.GREEN + "Crie Um Poço Dos Desejos!");
			descpyro.add(ChatColor.GREEN + "Clique Com O Botao Direito!");
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("Torm.Kit.Monk") || p.hasPermission("Torm.Kit.*")) {
			ItemStack pyro = new ItemStack(Material.BLAZE_ROD);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§aMonk");
			ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			descpyro.add(ChatColor.GREEN + "Desarme Seu Oponente!");
			descpyro.add(ChatColor.GREEN + "Clique Com O Botao Direito!");
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇§e█ §f█ ▇ ▆ ▅ ▄ ▃ ▂");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		
		ItemStack[] arrayOfItemStack;
		int descpyro = (arrayOfItemStack = inv.getContents()).length;
		for (int metapyro = 0; metapyro < descpyro; metapyro++) {
			ItemStack item = arrayOfItemStack[metapyro];
			if (item == null) {
				inv.setItem(inv.firstEmpty(), vidro1);
			}
		}
		p.openInventory(inv);
		ListaKits2.add(p.getName());
	}

	@EventHandler
	public void Kits1(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((p.getItemInHand().getType() == Material.CHEST) && (Main.estados == Estado.INICIANDO))
			Gui1.InventarioGui(p);
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerCLickInventry(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if ((e.getInventory().getTitle().equalsIgnoreCase(ChatColor.RED + "§7Kit [§e1§7]"))
				&& (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0)) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§lProxima Pagina")) {
				e.setCancelled(true);
				Gui2.InventarioGui21(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§lPagina Anterior")) {
				e.setCancelled(true);
				InventarioGui(p);
				return;
			}
			if (e.getCurrentItem().getType() == Material.FIREWORK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit kangaroo");
				return;
			}
			if (e.getCurrentItem().getType() == Material.WOOD_HOE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit reaper");
				return;
			}
			if (e.getCurrentItem().getType() == Material.BLAZE_ROD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit monk");
				return;
			}
			if (e.getCurrentItem().getType() == Material.GOLD_NUGGET) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit well");
				return;
			}
			if (e.getCurrentItem().getType() == Material.getMaterial(175)) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit copycat");
				return;
			}
			if (e.getCurrentItem().getType() == Material.MINECART) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit velotrol");
				return;
			}
			if (e.getCurrentItem().getType() == Material.IRON_FENCE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit gladiator");
				return;
			}
			if (e.getCurrentItem().getType() == Material.WORKBENCH) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit crafter");
				return;
			}
			if (e.getCurrentItem().getType() == Material.JUKEBOX) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit hulk");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FIREWORK_CHARGE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit Vulcanos");
				return;
			}
			if (e.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit turtle");
				return;
			}
			if (e.getCurrentItem().getType() == Material.COAL_BLOCK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit ninja");
				return;
			}
			if (e.getCurrentItem().getType() == Material.LEASH) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit grappler");
				return;
			}
			if (e.getCurrentItem().getType() == Material.ENDER_PORTAL_FRAME) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit endermage");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SEEDS) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit cultivator");
				return;
			}
			if (e.getCurrentItem().getType() == Material.GOLD_HOE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit BurstMaster");
				return;
			}
			if (e.getCurrentItem().getType() == Material.BOOK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit specialist");
				return;
			}
			if (e.getCurrentItem().getType() == Material.NAME_TAG) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit surprise");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FERMENTED_SPIDER_EYE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit viper");
				return;
			}
			if (e.getCurrentItem().getType() == Material.WATER_BUCKET) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit poseidon");
				return;
			}
			if (e.getCurrentItem().getType() == Material.GRASS) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit tower");
				return;
			}
			
			if (e.getCurrentItem().getType() == Material.IRON_BOOTS) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit stomper");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FISHING_ROD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit fisherman");
				return;
			}
			if (e.getCurrentItem().getType() == Material.STONE_AXE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit thor");
				return;
			}
			if (e.getCurrentItem().getType() == Material.WOOD_AXE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit lumberjack");
				return;
			}
			if (e.getCurrentItem().getType() == Material.STRING) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit snail");
				return;
			}
			if (e.getCurrentItem().getType() == Material.ANVIL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit anchor");
				return;
			}
			if (e.getCurrentItem().getType() == Material.CARPET) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit aladdin");
				return;
			}
			if (e.getCurrentItem().getType() == Material.LAVA_BUCKET) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit fireman");
				return;
			}
		}
	}
}