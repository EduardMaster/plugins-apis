package Utils;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitAPI {
	
	public static ItemStack sopas;
	public static ItemMeta sopameta;
	public static ItemStack cogu1;
	public static ItemMeta cogu1meta;
	public static ItemStack cogu2;
	public static ItemMeta cogu2meta;
	public static ItemStack pote;
	public static ItemMeta potemeta;
	
	public static ArrayList<String> Grappler = new ArrayList<>();
	public static HashMap<String, String> Kit = new HashMap<>();
	public static HashMap<String, Integer> KitDelay = new HashMap<>();
	public static ArrayList<String> voidChallenge = new ArrayList<String>();
	public static HashMap<String, Integer> voidChallengeTime = new HashMap<>();
	public static ArrayList<String> refillTest = new ArrayList<String>();
	public static HashMap<String, Integer> refillTestTime = new HashMap<>();	
	public static void setKit(Player p, String kit) {
		Kit.put(p.getName(), kit);
	}
	public static String getKit(Player p) {
		if (Kit.containsKey(p.getName())) {
			return Kit.get(p.getName());
		} else {
			return "Nenhum";
		}
	}
	public static void RemoveKit(Player p) {
		Kit.remove(p.getName());
	}
	
	public static void DarSopa(Player p) {
	
		
		
		sopas = new ItemStack(Material.MUSHROOM_SOUP);
		sopameta = sopas.getItemMeta();
		sopameta.setDisplayName("§4Sopinga de Gogumelo");
		sopas.setItemMeta(sopameta);
		
		cogu1 = new ItemStack(Material.RED_MUSHROOM, 64);
		cogu1meta = cogu1.getItemMeta();
		cogu1meta.setDisplayName("§6Gogumelo Vermelho");
		cogu1.setItemMeta(cogu1meta);
		
		cogu2 = new ItemStack(Material.BROWN_MUSHROOM, 64);
	    cogu2meta = cogu2.getItemMeta();
		cogu2meta.setDisplayName("§6Gogumelo Marron");
		cogu2.setItemMeta(cogu2meta);
		
		pote = new ItemStack(Material.BOWL, 64);
		potemeta = pote.getItemMeta();
		potemeta.setDisplayName("§bCumbuca");
		pote.setItemMeta(potemeta);
		
		for (int i = 1; i < 35; i++) {
			p.getInventory().addItem(sopas);
			p.getInventory().setItem(9, cogu1);
			p.getInventory().setItem(10, cogu2);
			p.getInventory().setItem(11, pote);
		}
	}
	
	public static void inicial(Player p) {
		p.getInventory().clear();
	}
	
	public static void PvP(Player p) {
		p.getInventory().clear();
		p.getInventory().clear();
		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		p.getInventory().setBoots(new ItemStack(Material.AIR));
		DarSopa(p);
		setKit(p, "PvP");
		ItemStack espada = new ItemStack(Material.STONE_SWORD);
	    ItemMeta espadameta = espada.getItemMeta();
		espadameta.setDisplayName("§f §k aa §4 Espada de Pedra §f §k aa");
		espada.setItemMeta(espadameta);
		p.getInventory().setItem(0, espada);
	}
	
	public static void Ninja(Player p) {
		p.getInventory().clear();
		p.getInventory().clear();
		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		p.getInventory().setBoots(new ItemStack(Material.AIR));
		DarSopa(p);
		setKit(p, "Ninja");
		ItemStack espada = new ItemStack(Material.STONE_SWORD);
	    ItemMeta espadameta = espada.getItemMeta();
		espadameta.setDisplayName("§f §k aa §4 Espada de Pedra §f §k aa");
		espada.setItemMeta(espadameta);
		p.getInventory().setItem(0, espada);
	}
	
	public static void Viper(Player p) {
		p.getInventory().clear();
		p.getInventory().clear();
		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		p.getInventory().setBoots(new ItemStack(Material.AIR));
		DarSopa(p);
		setKit(p, "Viper");
		ItemStack espada = new ItemStack(Material.STONE_SWORD);
	    ItemMeta espadameta = espada.getItemMeta();
		espadameta.setDisplayName("§f §k aa §4 Espada de Pedra §f §k aa");
		espada.setItemMeta(espadameta);
		p.getInventory().setItem(0, espada);
	}
	
	public static void Snail(Player p) {
		p.getInventory().clear();
		p.getInventory().clear();
		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		p.getInventory().setBoots(new ItemStack(Material.AIR));
		DarSopa(p);
		setKit(p, "Snail");
		ItemStack espada = new ItemStack(Material.STONE_SWORD);
	    ItemMeta espadameta = espada.getItemMeta();
		espadameta.setDisplayName("§f §k aa §4 Espada de Pedra §f §k aa");
		espada.setItemMeta(espadameta);
		p.getInventory().setItem(0, espada);
	}
	
	public static void kangaroo(Player p) {
		Kits.Kangaroo.KangarooStats.put(p.getName(), Integer.valueOf(0));
		p.getInventory().clear();
		p.getInventory().clear();
		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		p.getInventory().setBoots(new ItemStack(Material.AIR));
		DarSopa(p);
		setKit(p, "Kangaroo");
		ItemStack espada = new ItemStack(Material.STONE_SWORD);
	    ItemMeta espadameta = espada.getItemMeta();
		espadameta.setDisplayName("§f §k aa §4 Espada de kangaroo §f §k aa");
		espada.setItemMeta(espadameta);
	    p.getInventory().setItem(0, espada);
	    ItemStack kangaroo = new ItemStack(Material.FIREWORK);
	    ItemMeta kangaroometa = espada.getItemMeta();
		kangaroometa.setDisplayName("§f §k aa §4 kangaroo §f §k aa");
		kangaroo.setItemMeta(kangaroometa);
		p.getInventory().setItem(1, kangaroo);
		p.updateInventory();
	}
	
	public static void Fisherman(Player p) {
		p.getInventory().clear();
		p.getInventory().clear();
		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		p.getInventory().setBoots(new ItemStack(Material.AIR));
		DarSopa(p);
		setKit(p, "Fisherman");
		ItemStack espada = new ItemStack(Material.STONE_SWORD);
	    ItemMeta espadameta = espada.getItemMeta();
		espadameta.setDisplayName("§f §k aa §4 Espada de fisherman §f §k aa");
		espada.setItemMeta(espadameta);
	    p.getInventory().setItem(0, espada);
	    ItemStack fisherman = new ItemStack(Material.FISHING_ROD);
	    ItemMeta fishermanmeta = espada.getItemMeta();
		fishermanmeta.setDisplayName("§f §k aa §4 Fisherman §f §k aa");
		fisherman.setItemMeta(fishermanmeta);
		p.getInventory().setItem(1, fisherman);
		p.updateInventory();
	}
	
	public static void Thor(Player p) {
		p.getInventory().clear();
		p.getInventory().clear();
		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		p.getInventory().setBoots(new ItemStack(Material.AIR));
		DarSopa(p);
		setKit(p, "Thor");
		ItemStack espada = new ItemStack(Material.STONE_AXE);
	    ItemMeta espadameta = espada.getItemMeta();
		espadameta.setDisplayName("§f §k aa §4 Espada de Thor §f §k aa");
		espada.setItemMeta(espadameta);
	    p.getInventory().setItem(0, espada);
	    ItemStack fisherman = new ItemStack(Material.LEASH);
	    ItemMeta fishermanmeta = espada.getItemMeta();
		fishermanmeta.setDisplayName("§f §k aa §4 Machado de Thor §f §k aa");
		fisherman.setItemMeta(fishermanmeta);
		p.getInventory().setItem(1, fisherman);
		p.updateInventory();
	}
	
	public static void Stomper(Player p) {
		p.getInventory().clear();
		p.getInventory().clear();
		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		p.getInventory().setBoots(new ItemStack(Material.AIR));
		DarSopa(p);
		setKit(p, "Stomper");
		ItemStack espada = new ItemStack(Material.STONE_SWORD);
	    ItemMeta espadameta = espada.getItemMeta();
		espadameta.setDisplayName("§f §k aa §4 Espada de Pedra §f §k aa");
		espada.setItemMeta(espadameta);
		p.getInventory().setItem(0, espada);
	}
	
	public static void Viking(Player p) {
		p.getInventory().clear();
		p.getInventory().clear();
		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		p.getInventory().setBoots(new ItemStack(Material.AIR));
		DarSopa(p);
		setKit(p, "Viking");
		ItemStack espada = new ItemStack(Material.STONE_AXE);
	    ItemMeta espadameta = espada.getItemMeta();
		espadameta.setDisplayName("§f §k aa §4 Machado de Viking §f §k aa");
		espada.setItemMeta(espadameta);
		p.getInventory().setItem(0, espada);
	}
	
	public static void C4(Player p) {
		p.getInventory().clear();
		p.getInventory().clear();
		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		p.getInventory().setBoots(new ItemStack(Material.AIR));
		DarSopa(p);
		setKit(p, "C4");
		ItemStack espada = new ItemStack(Material.STONE_SWORD);
	    ItemMeta espadameta = espada.getItemMeta();
		espadameta.setDisplayName("§f §k aa §4 Espada de Pedra §f §k aa");
		espada.setItemMeta(espadameta);
		p.getInventory().setItem(0, espada);
		ItemStack fisherman = new ItemStack(Material.SLIME_BALL);
	    ItemMeta fishermanmeta = espada.getItemMeta();
		fishermanmeta.setDisplayName("§f §k aa §4 ALLAHU ARKBAR §f §k aa");
		fisherman.setItemMeta(fishermanmeta);
		p.getInventory().setItem(1, fisherman);
		p.updateInventory();
	}
	public static void ForceField(Player p) {
		p.getInventory().clear();
		p.getInventory().clear();
		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		p.getInventory().setBoots(new ItemStack(Material.AIR));
		DarSopa(p);
		setKit(p, "ForceField");
		ItemStack espada = new ItemStack(Material.STONE_SWORD);
	    ItemMeta espadameta = espada.getItemMeta();
		espadameta.setDisplayName("§f §k aa §4 Espada de Pedra §f §k aa");
		espada.setItemMeta(espadameta);
		p.getInventory().setItem(0, espada);
		ItemStack fisherman = new ItemStack(Material.IRON_FENCE);
	    ItemMeta fishermanmeta = espada.getItemMeta();
		fishermanmeta.setDisplayName("§f §k aa §4 FF §f §k aa");
		fisherman.setItemMeta(fishermanmeta);
		p.getInventory().setItem(1, fisherman);
		p.updateInventory();
	}
	public static void Deshfire(Player p) {
		p.getInventory().clear();
		p.getInventory().clear();
		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		p.getInventory().setBoots(new ItemStack(Material.AIR));
		DarSopa(p);
		setKit(p, "Deshfire");
		ItemStack espada = new ItemStack(Material.STONE_SWORD);
	    ItemMeta espadameta = espada.getItemMeta();
		espadameta.setDisplayName("§f §k aa §4 Espada de Pedra §f §k aa");
		espada.setItemMeta(espadameta);
		p.getInventory().setItem(0, espada);
		ItemStack fisherman = new ItemStack(Material.REDSTONE_BLOCK);
	    ItemMeta fishermanmeta = espada.getItemMeta();
		fishermanmeta.setDisplayName("§f §k aa §4 Desh §f §k aa");
		fisherman.setItemMeta(fishermanmeta);
		p.getInventory().setItem(1, fisherman);
		p.updateInventory();
	}
	public static void Sonic(Player p) {
		p.getInventory().clear();
		p.getInventory().clear();
		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		p.getInventory().setBoots(new ItemStack(Material.AIR));
		DarSopa(p);
		setKit(p, "Sonic");
		ItemStack espada = new ItemStack(Material.STONE_SWORD);
	    ItemMeta espadameta = espada.getItemMeta();
		espadameta.setDisplayName("§f §k aa §4 Espada de Pedra §f §k aa");
		espada.setItemMeta(espadameta);
		p.getInventory().setItem(0, espada);
		ItemStack fisherman = new ItemStack(Material.LAPIS_BLOCK);
	    ItemMeta fishermanmeta = espada.getItemMeta();
		fishermanmeta.setDisplayName("§f §k aa §4 SonicDesh §f §k aa");
		fisherman.setItemMeta(fishermanmeta);
		p.getInventory().setItem(1, fisherman);
		p.updateInventory();
	}
	public static void Terrorista(Player p) {
		p.getInventory().clear();
		p.getInventory().clear();
		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		p.getInventory().setBoots(new ItemStack(Material.AIR));
		DarSopa(p);
		setKit(p, "Terrorista");
		ItemStack espada = new ItemStack(Material.STONE_SWORD);
	    ItemMeta espadameta = espada.getItemMeta();
		espadameta.setDisplayName("§f §k aa §4 Espada de Pedra §f §k aa");
		espada.setItemMeta(espadameta);
		p.getInventory().setItem(0, espada);
		ItemStack fisherman = new ItemStack(Material.MAGMA_CREAM);
	    ItemMeta fishermanmeta = espada.getItemMeta();
		fishermanmeta.setDisplayName("§f §k aa §4 Alahhuuu §f §k aa");
		fisherman.setItemMeta(fishermanmeta);
		p.getInventory().setItem(1, fisherman);
		p.updateInventory();
	}
}
