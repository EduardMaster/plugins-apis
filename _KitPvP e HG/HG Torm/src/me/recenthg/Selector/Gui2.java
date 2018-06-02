package me.recenthg.Selector;

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

public class Gui2 implements Listener {

	@SuppressWarnings("deprecation")
	public static void InventarioGui21(Player p) {
		Inventory inv = Bukkit.getServer().createInventory(p, 54, ChatColor.RED + "§7Kit [§e2§7]");
		ItemStack vidro1 = new ItemStack(Material.getMaterial(160), 1, (short) 0);
		ItemMeta metav1 = vidro1.getItemMeta();
		metav1.setDisplayName(" ");
		vidro1.setItemMeta(metav1);

		ItemStack vidro12 = new ItemStack(Material.getMaterial(160), 1, (short) 10);
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
		metacarpets.setDisplayName("§a§lPagina Anterior");
		Carpets.setItemMeta(metacarpets);
		inv.setItem(0, Carpets);

		if (p.hasPermission("Torm.Kit.Whiter") || p.hasPermission("Torm.Kit.*")) {
			ItemStack pyro = new ItemStack(Material.SKULL_ITEM);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§aWither");
			ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇ §e█ §f█ §7▇ ▆ ▅ ▄ ▃ ▂");
			descpyro.add(ChatColor.GREEN + "Lançe Cabeça De Whiters!");
			descpyro.add(ChatColor.GREEN + "Clique Com O Botao Direito!");
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇ §e█ §f█ §7▇ ▆ ▅ ▄ ▃ ▂");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("Torm.Kit.Worm") || p.hasPermission("Torm.Kit.*")) {
			ItemStack pyro = new ItemStack(Material.DIRT);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§aWorm");
			ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇ §e█ §f█ §7▇ ▆ ▅ ▄ ▃ ▂");
			descpyro.add(ChatColor.GREEN + "Coma Terra Seu Morto De Fome!");
			descpyro.add(ChatColor.GREEN + "Clique Com O Botao Direito!");
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇ §e█ §f█ §7▇ ▆ ▅ ▄ ▃ ▂");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		if (p.hasPermission("Torm.Kit.Phantom") || p.hasPermission("Torm.Kit.*")) {
			ItemStack pyro = new ItemStack(Material.FEATHER);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§aPhantom");
			ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇ §e█ §f█ §7▇ ▆ ▅ ▄ ▃ ▂");
			descpyro.add(ChatColor.GREEN + "Voe Com Sua Pena!");
			descpyro.add(ChatColor.GREEN + "Clique Com O Botao Direito!");
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇ §e█ §f█ §7▇ ▆ ▅ ▄ ▃ ▂");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(pyro);
		}
		
		if (p.hasPermission("Torm.Kit.Gaara") || p.hasPermission("Torm.Kit.*")) {
			ItemStack pyro = new ItemStack(Material.SANDSTONE);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§aGaaea");
			ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇ §e█ §f█ §7▇ ▆ ▅ ▄ ▃ ▂");
			descpyro.add(ChatColor.GREEN + "Seja amigo da areia");
			descpyro.add(ChatColor.GREEN + "Clique Com O Botao Direito!");
			descpyro.add(ChatColor.GRAY + "▂ ▃ ▄ ▅ ▆ ▇ §e█ §f█ §7▇ ▆ ▅ ▄ ▃ ▂");
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

	}

	

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerCLickInventry(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if ((e.getInventory().getTitle().equalsIgnoreCase(ChatColor.RED + "§7Kit [§e2§7]"))
				&& (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0)) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§lPagina Anterior")) {
				e.setCancelled(true);
				Gui1.InventarioGui(p);
				return;
			}
		
			if (e.getCurrentItem().getType() == Material.SKULL_ITEM) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit wither");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SANDSTONE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit gaara");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FEATHER) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit phantom");
				return;
			}
			if (e.getCurrentItem().getType() == Material.DIRT) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit worm");
				return;
			}
		
		}
	}
}