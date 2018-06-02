package br.com.alpha.pregame.listeners;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {
	Material material;
	String display;
	Integer quantity;
	short durability;
	List<String> lore;
	Enchantment enchantment;
	Integer enchantlevel;
	Enchantment enchantment2;
	Integer enchantlevel2;

	public ItemBuilder(Material material) {
		this.material = material;
		this.quantity = 1;
		this.durability = (short) 0;
	}

	public ItemBuilder(Material material, String display) {
		this.material = material;
		this.display = display;
		this.quantity = 1;
		this.durability = (short) 0;
	}

	public ItemBuilder(Material material, String display, Integer quantity) {
		this.material = material;
		this.display = display;
		this.quantity = quantity;
		this.durability = (short) 0;
	}

	public ItemBuilder(Material material, String display, Integer quantity, short durability) {
		this.material = material;
		this.display = display;
		this.quantity = quantity;
		this.durability = durability;
	}

	public ItemBuilder(Material material, String display, Integer quantity, short durability, List<String> lore) {
		this.material = material;
		this.display = display;
		this.quantity = quantity;
		this.durability = durability;
		this.lore = lore;
	}

	public ItemBuilder(Material material, String display, Integer quantity, short durability, List<String> lore,
			Enchantment enchantment) {
		this.material = material;
		this.display = display;
		this.quantity = quantity;
		this.durability = durability;
		this.lore = lore;
		this.enchantment = enchantment;
	}

	public ItemBuilder(Material material, String display, Integer quantity, short durability, List<String> lore,
			Enchantment enchantment, Integer enchantlevel) {
		this.material = material;
		this.display = display;
		this.quantity = quantity;
		this.durability = durability;
		this.lore = lore;
		this.enchantment = enchantment;
		this.enchantlevel = enchantlevel;
	}

	public ItemBuilder(Material material, String display, Integer quantity, short durability, List<String> lore,
			Enchantment enchantment, Integer enchantlevel, Enchantment enchantment2) {
		this.material = material;
		this.display = display;
		this.quantity = quantity;
		this.durability = durability;
		this.lore = lore;
		this.enchantment = enchantment;
		this.enchantlevel = enchantlevel;
		this.enchantment2 = enchantment2;
	}

	public ItemBuilder(Material material, String display, Integer quantity, short durability, List<String> lore,
			Enchantment enchantment, Integer enchantlevel, Enchantment enchantment2, Integer enchantlevel2) {
		this.material = material;
		this.display = display;
		this.quantity = quantity;
		this.durability = durability;
		this.lore = lore;
		this.enchantment = enchantment;
		this.enchantlevel = enchantlevel;
		this.enchantment2 = enchantment2;
		this.enchantlevel2 = enchantlevel2;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setDurability(short durability) {
		this.durability = (short) durability;
	}

	public void setLore(List<String> lore) {
		this.lore = lore;
	}

	public void setEnchantment(Enchantment enchantment) {
		this.enchantment = enchantment;
	}

	public void setLevel(Integer enchantlevel) {
		this.enchantlevel = enchantlevel;
	}

	public void setEnchantment2(Enchantment enchantment2) {
		this.enchantment2 = enchantment2;
	}

	public void setLevel2(Integer enchantlevel2) {
		this.enchantlevel2 = enchantlevel2;
	}

	public Material getMaterial() {
		return this.material;
	}

	public String getDisplay() {
		return this.display;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public short getDurability() {
		return this.durability;
	}

	public List<String> getLore() {
		return this.lore;
	}

	public Enchantment getEnchantment() {
		return this.enchantment;
	}

	public Integer getEnchantmentLevel() {
		return this.enchantlevel;
	}

	public Enchantment getEnchantment2() {
		return this.enchantment2;
	}

	public Integer getEnchantmentLevel2() {
		return this.enchantlevel2;
	}

	public ItemStack getItemStack() {
		ItemStack item = new ItemStack(getMaterial(), this.quantity, this.durability);
		ItemMeta meta = item.getItemMeta();
		if (display != null) {
			meta.setDisplayName(this.display);
		}
		if (this.enchantment != null) {
			if (enchantlevel != null) {
				item.addEnchantment(this.enchantment, 1);
			} else {
				item.addEnchantment(this.enchantment, this.enchantlevel);
			}
		}
		if (this.enchantment2 != null) {
			if (enchantlevel2 != null) {
				item.addEnchantment(this.enchantment2, 1);
			} else {
				item.addEnchantment(this.enchantment2, this.enchantlevel2);
			}
		}
		if (lore != null) {
			meta.setLore(this.lore);
		}
		item.setItemMeta(meta);
		return item;
	}
}