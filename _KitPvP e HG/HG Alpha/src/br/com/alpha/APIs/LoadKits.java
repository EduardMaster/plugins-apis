package br.com.alpha.APIs;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import br.com.alpha.ENUMs.KitsEnum;

public class LoadKits {

	public static ItemStack criarItem(Player p, Material item, String nome, int slot, short sh, int quantidade,
			Enchantment enchant, int level) {
		ItemStack stack = new ItemStack(item, quantidade, sh);
		ItemMeta m = stack.getItemMeta();
		stack.addEnchantment(enchant, level);
		m.hasEnchant(enchant);
		m.addEnchant(enchant, level, true);
		m.setDisplayName(nome);
		stack.setItemMeta(m);
		p.getInventory().setItem(slot, stack);
		return stack;
	}

	public static ItemStack criarItem(Player p, Material item, String nome, int slot, short sh, int quantidade) {
		ItemStack stack = new ItemStack(item, quantidade, sh);
		ItemMeta m = stack.getItemMeta();
		m.setDisplayName(nome);
		stack.setItemMeta(m);
		p.getInventory().setItem(slot, stack);
		return stack;
	}

	public static void loadKits(Player player) {
		if (KitsEnum.getKit(player) == KitsEnum.BACKPACKER) {
			criarItem(player, Material.ENDER_CHEST, "§cBackPacker", 1, (short) 0, 1);
		}
		if (KitsEnum.getKit(player) == KitsEnum.BARBARIAN) {
			criarItem(player, Material.WOOD_SWORD, "§cBarbarian", 1, (short) 0, 1, Enchantment.DURABILITY, 2);
		}
		if (KitsEnum.getKit(player) == KitsEnum.CANNIBAL) {
			criarItem(player, Material.COOKED_FISH, null, 1, (short) 0, 1);
		}
		if (KitsEnum.getKit(player) == KitsEnum.CRAFTER) {
			criarItem(player, Material.NETHER_STAR, "Crafting Table", 1, (short) 0, 1);
			criarItem(player, Material.BLAZE_POWDER, "§cFurnace", 2, (short) 0, 1);
		}
		if (KitsEnum.getKit(player) == KitsEnum.DEMOMAN) {
			criarItem(player, Material.STONE_PLATE, null, 1, (short)0, 5);
			criarItem(player, Material.GRAVEL, null, 1, (short)0, 5);
		}
		if (KitsEnum.getKit(player) == KitsEnum.ENDERMAGE) {
			criarItem(player, Material.PORTAL, null, 1, (short)0, 1);

		}
		if (KitsEnum.getKit(player) == KitsEnum.FIREMAN) {
			criarItem(player, Material.WATER_BUCKET, null, 1, (short)0, 1);

		}
		if (KitsEnum.getKit(player) == KitsEnum.FISHERMAN) {
			criarItem(player, Material.FISHING_ROD, null, 1, (short)0, 1);

		}
		if (KitsEnum.getKit(player) == KitsEnum.GRANDPA) {
			criarItem(player, Material.STICK, null, 1, (short)0, 1, Enchantment.KNOCKBACK, 2);

		}
		if (KitsEnum.getKit(player) == KitsEnum.JACKHAMMER) {
			criarItem(player, Material.STONE_AXE, null, 1, (short)0, 1);

		}
		if (KitsEnum.getKit(player) == KitsEnum.JUMPER) {
			criarItem(player, Material.ENDER_PEARL, null, 1, (short)0, 5);

		}
		if (KitsEnum.getKit(player) == KitsEnum.KANGAROO) {
			criarItem(player, Material.FIREWORK, null, 1, (short)0, 1);

		}
		if (KitsEnum.getKit(player) == KitsEnum.JACKHAMMER) {
			criarItem(player, Material.STONE_AXE, null, 1, (short)0, 1);

		}
		if (KitsEnum.getKit(player) == KitsEnum.LAUNCHER) {
			criarItem(player, Material.SPONGE, null, 1, (short)0, 20);

		}
		if (KitsEnum.getKit(player) == KitsEnum.LUMBERJACK) {
			criarItem(player, Material.WOOD_AXE, null, 1, (short)0, 1);

		}
		if (KitsEnum.getKit(player) == KitsEnum.MINER) {
			criarItem(player, Material.STONE_PICKAXE, "Miner Pickaxe", 1, (short)0, 1, Enchantment.DURABILITY, 2);
			criarItem(player, Material.APPLE, null, 2, (short)0, 5);

		}
		if (KitsEnum.getKit(player) == KitsEnum.MONK) {
			criarItem(player, Material.BLAZE_ROD, null, 1, (short)0, 1);

		}
		if (KitsEnum.getKit(player) == KitsEnum.PHANTOM) {
			criarItem(player, Material.FEATHER, null, 1, (short)0, 1);

		}
		if (KitsEnum.getKit(player) == KitsEnum.PYRO) {
			criarItem(player, Material.FIREBALL, null, 1, (short)0, 5);
			criarItem(player, Material.FLINT_AND_STEEL, null, 1, (short)0, 5);

		}
		if (KitsEnum.getKit(player) == KitsEnum.REAPER) {
			criarItem(player, Material.WOOD_HOE, null, 1, (short)0, 1);

		}
		if (KitsEnum.getKit(player) == KitsEnum.SCOUT) {
			criarItem(player, Material.POTION, null, 1, (short)8194, 3);

		}
		if (KitsEnum.getKit(player) == KitsEnum.SWITCHER) {
			criarItem(player, Material.SNOW_BALL, null, 1, (short)0, 16);

		}
		if (KitsEnum.getKit(player) == KitsEnum.THOR) {
			criarItem(player, Material.WOOD_AXE, null, 1, (short)0, 1);

		}
		if (KitsEnum.getKit(player) == KitsEnum.URGAL) {
			criarItem(player, Material.POTION, null, 1, (short)8201, 3);

		}
		if (KitsEnum.getKit(player) == KitsEnum.SPECIALIST) {
			criarItem(player, Material.BOOK, null, 1, (short)0, 1);

		}
	}
}