package Pedrao;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.DefaultFlag;

public class KitAPI implements Listener {
	public static ArrayList<String> Vunerable = new ArrayList<String>();
	public static ArrayList<String> Laucher = new ArrayList<String>();
	public static ArrayList<String> Pikachu = new ArrayList<String>();
	public static ArrayList<String> Cagao = new ArrayList<String>();
	public static ArrayList<String> ForceField = new ArrayList<String>();
	public static ArrayList<String> ForceField1 = new ArrayList<String>();
	public static ArrayList<String> DeathNote = new ArrayList<String>();
	public static ArrayList<String> BloodGun = new ArrayList<String>();
	public static ArrayList<String> WaterBender = new ArrayList<String>();
	public static ArrayList<String> FireBender = new ArrayList<String>();
	public static ArrayList<String> Curandeiro = new ArrayList<String>();
	public static ArrayList<String> Stomper = new ArrayList<String>();
	public static ArrayList<String> Viper = new ArrayList<String>();
	public static ArrayList<String> Snail = new ArrayList<String>();
	public static ArrayList<String> Kronos = new ArrayList<String>();
	public static ArrayList<String> Kangaroo = new ArrayList<String>();
	public static ArrayList<String> Fisherman = new ArrayList<String>();
	public static ArrayList<String> Anchor = new ArrayList<String>();
	public static ArrayList<String> Kit = new ArrayList<String>();
	public static ArrayList<String> Terrorista = new ArrayList<String>();
	public static ArrayList<String> Tornado = new ArrayList<String>();
	public static ArrayList<String> Tornado1 = new ArrayList<String>();
	public static ArrayList<String> Urano = new ArrayList<String>();
	public static ArrayList<String> Urano1 = new ArrayList<String>();
	public static ArrayList<String> Sonic = new ArrayList<String>();
	public static ArrayList<String> DeshFire = new ArrayList<String>();
	public static ArrayList<String> Gravity = new ArrayList<String>();
	public static ArrayList<String> Rain = new ArrayList<String>();
	public static ArrayList<String> Velotrol = new ArrayList<String>();
	public static ArrayList<String> Jutso = new ArrayList<String>();
	public static ArrayList<String> reload = new ArrayList<String>();
	public static ArrayList<String> Sasuke = new ArrayList<String>();
	public static ArrayList<String> Gladiator = new ArrayList<String>();
	public static ArrayList<String> gladGladiator = new ArrayList<String>();
	public static ArrayList<String> Grappler = new ArrayList<String>();
	public static ArrayList<String> Ninja = new ArrayList<String>();
	public static ArrayList<String> Hulk = new ArrayList<String>();
	public static ArrayList<String> LifeStealer = new ArrayList<String>();
	public static ArrayList<String> ChestPlate = new ArrayList<String>();
	public static ArrayList<String> SwordKit = new ArrayList<String>();
	public static ArrayList<String> Mago = new ArrayList<String>();
	public static ArrayList<String> C4 = new ArrayList<String>();
	public static ArrayList<String> Thresh = new ArrayList<String>();

	public KitAPI(Main main) {
	}

	public static void remove(Player p) {
		Kit.remove(p.getName());
		Ninja.remove(p.getName());
		SwordKit.remove(p.getName());
		Mago.remove(p.getName());
		C4.remove(p.getName());
		Thresh.remove(p.getName());
		Hulk.remove(p.getName());
		LifeStealer.remove(p.getName());
		ChestPlate.remove(p.getName());
		Kangaroo.remove(p.getName());
		Anchor.remove(p.getName());
		Jutso.remove(p.getName());
		Velotrol.remove(p.getName());
		Rain.remove(p.getName());
		Fisherman.remove(p.getName());
		DeathNote.remove(p.getName());
		Cagao.remove(p.getName());
		ForceField.remove(p.getName());
		ForceField1.remove(p.getName());
		BloodGun.remove(p.getName());
		Kronos.remove(p.getName());
		Gladiator.remove(p.getName());
		gladGladiator.remove(p.getName());
		Grappler.remove(p.getName());
		Stomper.remove(p.getName());
		Snail.remove(p.getName());
		Viper.remove(p.getName());
		WaterBender.remove(p.getName());
		FireBender.remove(p.getName());
		Tornado1.remove(p.getName());
		Curandeiro.remove(p.getName());
		Terrorista.remove(p.getName());
		Tornado.remove(p.getName());
		Urano.remove(p.getName());
		Urano1.remove(p.getName());
		Gravity.remove(p.getName());
		Pikachu.remove(p.getName());
		Sonic.remove(p.getName());
		DeshFire.remove(p.getName());
		reload.remove(p.getName());
		Laucher.remove(p.getName());
		Sasuke.remove(p.getName());
	}

	public static void sopa(Player p) {
		ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		ItemMeta ksopa = sopa.getItemMeta();
		ksopa.setDisplayName("§5§lSopa");
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

	public static void recraft(Player p) {
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
	}

	public static void sword(Player p) {
		ItemStack espada = new ItemStack(Material.WOOD_SWORD);
		ItemMeta kespada = espada.getItemMeta();
		kespada.setDisplayName("§5§lEspada");
		kespada.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		espada.setItemMeta(kespada);
		p.getInventory().setItem(0, espada);
	}

	public static void setitem(Player p, Material mat, String nome, int lugar, Enchantment enchant, int level,
			boolean trueorfalse) {
		ItemStack item = new ItemStack(mat);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(nome);
		itemmeta.addEnchant(enchant, level, trueorfalse);
		item.setItemMeta(itemmeta);
		p.getInventory().setItem(lugar, item);
	}

	public static WorldGuardPlugin getWorldGuard() {
		Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
		if ((plugin == null) || (!(plugin instanceof WorldGuardPlugin))) {
			return null;
		}
		return (WorldGuardPlugin) plugin;
	}

	public static boolean areaPvP(Player p) {
		ApplicableRegionSet region = getWorldGuard().getRegionManager(p.getWorld())
				.getApplicableRegions(p.getLocation());
		if (region.allows(DefaultFlag.PVP)) {
			return true;
		}
		return false;
	}
}
