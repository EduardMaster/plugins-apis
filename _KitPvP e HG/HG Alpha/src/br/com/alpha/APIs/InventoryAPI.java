package br.com.alpha.APIs;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryAPI {

	public static ItemStack newItemStackEnchanted(Material material, Integer amount, byte Byte, List<String> lore,
			String display, Enchantment enchament, Integer nivel) {

		ItemStack stack = new ItemStack(material, amount, Byte);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setLore(lore);
		stackMeta.setDisplayName(display);
		stackMeta.addEnchant(enchament, nivel, true);

		stack.setItemMeta(stackMeta);
		return stack;
	}

	public static ItemStack newItemStack(Material material, Integer amount, byte Byte, List<String> lore,
			String display) {

		ItemStack stack = new ItemStack(material, amount, Byte);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setLore(lore);
		stackMeta.setDisplayName(display);

		stack.setItemMeta(stackMeta);
		return stack;
	}

	public static void setItemOnInventory(Inventory inventario, Integer slot, ItemStack item) {
		inventario.setItem(slot, item);
	}

	public static void addItemOnInventory(Inventory inventario, ItemStack item) {
		inventario.addItem(item);
	}

	public static Boolean InventoryHasSpace(Player p) {
		if (p.getInventory().firstEmpty() == -1) {
			return false;
		} else {
			return true;
		}
	}

	public static void clearInventory(Player p) {

		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
	}

	public static void addItemToaPlayer(Player p, ItemStack item) {
		p.getInventory().addItem(item);
	}

	public static void setItemToaPlayer(Player p, ItemStack item, Integer slot) {
		p.getInventory().setItem(slot, item);
	}
}
