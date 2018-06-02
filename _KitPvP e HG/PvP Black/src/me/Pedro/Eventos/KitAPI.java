package me.Pedro.Eventos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import com.sk89q.jchronic.utils.Time;

import me.Pedro.Main;

public class KitAPI implements Listener {
	public static ArrayList<String> Thresh = new ArrayList<String>();
	public static ArrayList<String> Teleman = new ArrayList<String>();
	public static ArrayList<String> DeathNote = new ArrayList<String>();
	public static ArrayList<String> TimeLord = new ArrayList<String>();
	public static ArrayList<String> Vaccum = new ArrayList<String>();
	public static ArrayList<String> Sonic = new ArrayList<String>();
	public static ArrayList<String> Deshfire = new ArrayList<String>();
	public static ArrayList<String> BurstMaster = new ArrayList<String>();
	public static ArrayList<String> Ninja = new ArrayList<String>();
	public static ArrayList<String> Ajnin = new ArrayList<String>();
	public static ArrayList<String> Fisherman = new ArrayList<String>();
	public static ArrayList<String> Bazooka = new ArrayList<String>();
	public static ArrayList<String> Thor = new ArrayList<String>();
	public static ArrayList<String> Kangaroo = new ArrayList<String>();
	public static ArrayList<String> AntiStomper = new ArrayList<String>();
	public static ArrayList<String> Stomper = new ArrayList<String>();
	public static ArrayList<String> QuickDropper = new ArrayList<String>();
	public static ArrayList<String> Levitator = new ArrayList<String>();
	public static ArrayList<String> Anchor = new ArrayList<String>();
	public static ArrayList<String> Kit = new ArrayList<String>();

	public static ArrayList<String> voidChallenge = new ArrayList<String>();
	public static ArrayList<String> TellReceber = new ArrayList<String>();
	public static HashMap<String, Integer> voidChallengeTime = new HashMap<>();
	public static ArrayList<String> refillTest = new ArrayList<String>();
	public static HashMap<String, Integer> refillTestTime = new HashMap<>();
	public KitAPI(Main main) {
	}

	public static void remove(Player p) {
		Kit.remove(p.getName());
		QuickDropper.remove(p.getName());
		AntiStomper.remove(p.getName());
		Kangaroo.remove(p.getName());
		Stomper.remove(p.getName());
		Thor.remove(p.getName());
		Bazooka.remove(p.getName());
		DeathNote.remove(p.getName());
		BurstMaster.remove(p.getName());
		Ajnin.remove(p.getName());
		Sonic.remove(p.getName());
		TimeLord.remove(p.getName());
		Vaccum.remove(p.getName());
		Deshfire.remove(p.getName());
		Ninja.remove(p.getName());
		Anchor.remove(p.getName());
		Levitator.remove(p.getName());
		Fisherman.remove(p.getName());
		Teleman.remove(p.getName());
		Thresh.remove(p.getName());
		
		voidChallengeTime.remove(p.getName());
		voidChallenge.remove(p.getName());
	}

	public static void GiveKit(Player p) {
		API.setitem(p, Material.WOOD_SWORD, "", 0, Enchantment.DURABILITY, 1, true);
		API.setitem(p, Material.COMPASS, "", 8, Enchantment.DURABILITY, 1, true);
		p.setGameMode(GameMode.SURVIVAL);
		ItemStack sopas = new ItemStack(Material.BOWL, 64);
		ItemMeta ksopas = sopas.getItemMeta();
		sopas.setItemMeta(ksopas);
		ItemStack cogur = new ItemStack(Material.RED_MUSHROOM, 64);
		ItemMeta kcogur = cogur.getItemMeta();
		cogur.setItemMeta(kcogur);
		ItemStack cogum = new ItemStack(Material.BROWN_MUSHROOM, 64);
		ItemMeta kcogum = cogum.getItemMeta();
		cogum.setItemMeta(kcogum);
		p.getInventory().setItem(13, sopas);
		p.getInventory().setItem(14, cogur);
		p.getInventory().setItem(15, cogum);
		ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		ItemMeta ksopa = sopa.getItemMeta();
		ksopa.setDisplayName("§c• §cSopa §c•");
		sopa.setItemMeta(ksopa);

		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });

	}
}
