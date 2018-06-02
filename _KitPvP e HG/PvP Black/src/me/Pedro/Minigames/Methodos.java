package me.Pedro.Minigames;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.server.v1_7_R4.EntityVillager;
import net.minecraft.server.v1_7_R4.PacketPlayOutSpawnEntityLiving;
import net.minecraft.server.v1_7_R4.WorldServer;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;

public class Methodos {

	public static void registerEvents(Listener classe, Plugin main) {
		Bukkit.getServer().getPluginManager().registerEvents(classe, main);
	}

	public static void DarItem(Player p, Material item, int slot, String name) {
		ItemStack give = new ItemStack(item);
		ItemMeta givem = give.getItemMeta();
		givem.setDisplayName(name);
		give.setItemMeta(givem);

		p.getInventory().setItem(slot, give);
	}

	public static void spawnFirework(Location loc) {

		Firework fw = (Firework) loc.getWorld().spawnEntity(loc,
				EntityType.FIREWORK);
		FireworkMeta fwm = fw.getFireworkMeta();
		Random r = new Random();
		int rt = r.nextInt(4) + 1;
		FireworkEffect.Type type = FireworkEffect.Type.BALL;
		if (rt == 1) {
			type = FireworkEffect.Type.BALL;
		}
		if (rt == 2) {
			type = FireworkEffect.Type.BALL_LARGE;
		}
		if (rt == 3) {
			type = FireworkEffect.Type.BURST;
		}
		if (rt == 4) {
			type = FireworkEffect.Type.CREEPER;
		}
		if (rt == 5) {
			type = FireworkEffect.Type.STAR;
		}
		Color c1 = Color.RED;
		Color c2 = Color.YELLOW;
		Color c3 = Color.ORANGE;
		FireworkEffect effect = FireworkEffect.builder()
				.flicker(r.nextBoolean()).withColor(c1).withColor(c2)
				.withFade(c3).with(type).trail(r.nextBoolean()).build();
		fwm.addEffect(effect);
		fwm.setPower(1);
		fw.setFireworkMeta(fwm);

	}

	public static ItemStack itemStack(Material material, String nome) {
		ItemStack item = new ItemStack(material);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(nome);
		item.setItemMeta(itemmeta);
		return item;
	}

	public static void fillLinhaInventory(Inventory inv, int fristSlot,
			ItemStack slot1, ItemStack slot2, ItemStack slot3, ItemStack slot4,
			ItemStack slot5, ItemStack slot6, ItemStack slot7, ItemStack slot8,
			ItemStack slot9) {
		inv.setItem(fristSlot, slot1);
		inv.setItem(fristSlot + 1, slot2);
		inv.setItem(fristSlot + 2, slot3);
		inv.setItem(fristSlot + 3, slot4);
		inv.setItem(fristSlot + 4, slot5);
		inv.setItem(fristSlot + 5, slot6);
		inv.setItem(fristSlot + 6, slot7);
		inv.setItem(fristSlot + 7, slot8);
		inv.setItem(fristSlot + 8, slot9);
	}

	public static ItemStack itemStack(Material material, String nome,
			String lore) {
		ItemStack item = new ItemStack(material);
		ItemMeta itemmeta = item.getItemMeta();
		List<String> iteml = new ArrayList<>();
		iteml.add(lore);
		itemmeta.setLore(iteml);
		itemmeta.setDisplayName(nome);
		item.setItemMeta(itemmeta);
		return item;
	}

	@SuppressWarnings("deprecation")
	public static void spawnNpc(Location loc, Player player, String name) {
		WorldServer world = ((org.bukkit.craftbukkit.v1_7_R4.CraftWorld) loc
				.getWorld()).getHandle();

		EntityVillager villager = new EntityVillager(world);

		villager.setCustomName(name);
		villager.setCustomNameVisible(true);

		villager.setLocation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(),
				loc.getPitch());

		PacketPlayOutSpawnEntityLiving packedt = new PacketPlayOutSpawnEntityLiving(
				villager);

		for (Player all : Bukkit.getOnlinePlayers()) {
			((CraftPlayer) all).getHandle().playerConnection
					.sendPacket(packedt);
		}
	}

	public static ItemStack itemStack(Material material, String nome,
			String lore, Enchantment enchant, int levelEnchant) {
		ItemStack item = new ItemStack(material);
		item.addUnsafeEnchantment(enchant, levelEnchant);
		ItemMeta itemmeta = item.getItemMeta();
		List<String> iteml = new ArrayList<>();
		iteml.add(lore);
		itemmeta.setLore(iteml);
		itemmeta.setDisplayName(nome);
		item.setItemMeta(itemmeta);
		return item;
	}

	public static ItemStack itemStack(Material material, String nome,
			List<String> lore) {
		ItemStack item = new ItemStack(material);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setLore(lore);
		itemmeta.setDisplayName(nome);
		item.setItemMeta(itemmeta);
		return item;
	}

	public static ItemStack itemStack(Material material, String nome,
			int amount, int durability) {
		ItemStack item = new ItemStack(material, amount, (short) durability);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(nome);
		item.setItemMeta(itemmeta);
		return item;
	}

	public static ItemStack itemStack(Material material, String nome,
			int amount, int durability, List<String> lore) {
		ItemStack item = new ItemStack(material, amount, (short) durability);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setLore(lore);
		itemmeta.setDisplayName(nome);
		item.setItemMeta(itemmeta);
		return item;
	}

	public static ItemStack headStack(String namePlayer, String displayName,
			List<String> lore) {
		ItemStack item = new ItemStack(Material.SKULL_ITEM, 1,
				(short) SkullType.PLAYER.ordinal());
		SkullMeta itemmeta = (SkullMeta) item.getItemMeta();
		itemmeta.setLore(lore);
		itemmeta.setOwner(namePlayer);
		itemmeta.setDisplayName(displayName);
		item.setItemMeta(itemmeta);
		return item;
	}

}