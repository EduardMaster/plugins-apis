package me.Pedro.INV;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import me.Pedro.Main;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class CaixaKit implements Listener {

	@SuppressWarnings("unused")
	private static HashMap<String, Long> cooldown = new HashMap<String, Long>();

	 public static ArrayList<String> kitdiarioaladdin = new ArrayList<>();
	 public static ArrayList<String> kitdiariowaterbender = new ArrayList<>();
	 public static ArrayList<String> kitdiariofirebender = new ArrayList<>();
	 public static ArrayList<String> kitdiraioTimeLord = new ArrayList<>();
	 public static ArrayList<String> kitdiarioAjnin = new ArrayList<>();
	 public static ArrayList<String> kitdiariomerlin = new ArrayList<>();
	 public static ArrayList<String> kitdiarioDeshFire = new ArrayList<>();
	 public static ArrayList<String> kitdiarioAntiStomper = new ArrayList<>();
	 public static ArrayList<String> kitdiarioSonic = new ArrayList<>();
	 public static ArrayList<String> setandokit = new ArrayList<>();

	public CaixaKit(Main main) {
		// TODO Auto-generated constructor stub
	}

	public static void playFirework(Location location, Color color, Player p) {
		Firework firework = (Firework) location.getWorld().spawn(location, Firework.class);
		FireworkMeta fMeta = firework.getFireworkMeta();
		fMeta.addEffect(FireworkEffect.builder().withColor(color).build());
		firework.setFireworkMeta(fMeta);
		firework.setVelocity(new Vector(0.0D, -1.0D, 0.0D));
	}

	public void playFirework(Location location, FireworkEffect effecta, Player p) {
		Firework firework = (Firework) location.getWorld().spawn(location, Firework.class);
		FireworkMeta fMeta = firework.getFireworkMeta();
		fMeta.addEffect(effecta);
		firework.setFireworkMeta(fMeta);
	}

	@SuppressWarnings({ "unused", "deprecation" })
	@EventHandler
	public void aoClicarNoInv(InventoryClickEvent e) {
		Player jogador = (Player) e.getWhoClicked();
		if ((e.getInventory().getTitle().equalsIgnoreCase("§e §7KITDIARIO §e")) && (e.getCurrentItem() != null)
				&& (e.getCurrentItem().getTypeId() != 0)) {
			e.setCancelled(true);
		}
	}

	@SuppressWarnings("deprecation")
	public static void Inventario(final Player jogador) {
		final Inventory random = Bukkit.createInventory(jogador, 9, "§e §7KITDIARIO §e");

		final ItemStack vidro = new ItemStack(Material.getMaterial(102));
		ItemMeta vidrometa = vidro.getItemMeta();
		vidrometa.setDisplayName("§7Sorteando O Item");
		vidro.setItemMeta(vidrometa);

		final ItemStack vidro1 = new ItemStack(Material.getMaterial(160));
		vidro1.setDurability((short) 7);
		ItemMeta vidrometa1 = vidro1.getItemMeta();
		vidrometa1.setDisplayName("§7Sorteando O Item");
		vidro1.setItemMeta(vidrometa1);

		final ItemStack vidrovermelho = new ItemStack(Material.getMaterial(160),1 ,(short)2);
		vidrovermelho.setDurability((short) 14);
		ItemMeta vidrovermelhoa = vidrovermelho.getItemMeta();
		vidrovermelhoa.setDisplayName("§7Sorteando O Item");
		vidrovermelho.setItemMeta(vidrovermelhoa);

		final ItemStack vidropreto = new ItemStack(Material.getMaterial(160),1 ,(short)4);
		vidropreto.setDurability((short) 0);
		ItemMeta vidropretoa = vidropreto.getItemMeta();
		vidropretoa.setDisplayName("§7Sorteando O Item");
		vidropreto.setItemMeta(vidropretoa);

		final ItemStack espadademadeira = new ItemStack(Material.LAVA_BUCKET);
		  ItemMeta espadademadeiraa = espadademadeira.getItemMeta();
		  espadademadeiraa.setDisplayName("§e §7FireBender");
		  espadademadeira.setItemMeta(espadademadeiraa);

		  final ItemStack sopa = new ItemStack(Material.CARPET);
		  ItemMeta sopaa = sopa.getItemMeta();
		  sopaa.setDisplayName("§e §7Aladdin");
		  sopa.setItemMeta(sopaa);

		  final ItemStack maÃadourada = new ItemStack(Material.WATER_BUCKET);
		  ItemMeta maÃadouradaa = maÃadourada.getItemMeta();
		  maÃadouradaa.setDisplayName("§e §7WaterBender");
		  maÃadourada.setItemMeta(maÃadouradaa);

		  final ItemStack espadadepedra = new ItemStack(Material.IRON_FENCE);
		  ItemMeta espadadepedraa = espadadepedra.getItemMeta();
		  espadadepedraa.setDisplayName("§e §7AntiStomper");
		  espadadepedra.setItemMeta(espadadepedraa);

		  final ItemStack xp = new ItemStack(Material.IRON_INGOT);
		  ItemMeta xpa = xp.getItemMeta();
		  xpa.setDisplayName("§e §7TimeLord");
		  xp.setItemMeta(xpa);

		  final ItemStack Ajnin = new ItemStack(Material.STONE_AXE);
		  ItemMeta Ajnina = Ajnin.getItemMeta();
		  Ajnina.setDisplayName("§e §7Ajnin");
		  Ajnin.setItemMeta(Ajnina);

		  final ItemStack enderperal = new ItemStack(Material.FIREWORK);
		  ItemMeta enderperala = enderperal.getItemMeta();
		  enderperala.setDisplayName("§e §7DeshFire");
		  enderperal.setItemMeta(enderperala);
		  
		  final ItemStack Sonic = new ItemStack(Material.LEASH);
		  ItemMeta Sonica = Sonic.getItemMeta();
		  Sonica.setDisplayName("§e §7Sonic");
		  Sonic.setItemMeta(Sonica);

		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				Random r = new Random();
				int gg = r.nextInt(7) + 1;

				if (gg == 1) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
					random.setItem(4, espadademadeira);
					kitdiariofirebender.add(jogador.getName());


					jogador.sendMessage("§b€¢ §7Voce ganhou o Kit FireBender");
					PermissionsEx.getUser(jogador.getName()).addPermission("kit.FireBender");


				}

				if (gg == 2) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
					random.setItem(4, sopa);
					kitdiarioaladdin.add(jogador.getName());


					jogador.sendMessage("§b€¢ §7Voce ganhou o Kit Vaccum");
					PermissionsEx.getUser(jogador.getName()).addPermission("kit.Vaccum");

				}
				if (gg == 3) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
					random.setItem(4, maÃadourada);
					kitdiariowaterbender.add(jogador.getName());


					jogador.sendMessage("§b€¢ §7Voce ganhou o Kit WaterBender");
					PermissionsEx.getUser(jogador.getName()).addPermission("kit.WaterBender");


				}
				if (gg == 4) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
					random.setItem(4, xp);
					kitdiraioTimeLord.add(jogador.getName());


					jogador.sendMessage("§b€¢ §7Voce ganhou o Kit TimeLord");
					PermissionsEx.getUser(jogador.getName()).addPermission("kit.TimeLord");


				}
				if (gg == 5) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
					random.setItem(4, espadadepedra);
					kitdiarioAntiStomper.add(jogador.getName());


					jogador.sendMessage("§b€¢ §7Voce ganhou o Kit AntiStomper");
					PermissionsEx.getUser(jogador.getName()).addPermission("kit.antistomper");


				}
				if (gg == 6) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
					random.setItem(4, Ajnin);
					kitdiarioAjnin.add(jogador.getName());


					jogador.sendMessage("§b€¢ §7Voce ganhou o Kit Ajnin");
					PermissionsEx.getUser(jogador.getName()).addPermission("kit.ajnin");


				}
				if (gg == 7) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
					random.setItem(4, enderperal);
					kitdiarioDeshFire.add(jogador.getName());


					jogador.sendMessage("§b€¢ §7Voce ganhou o Kit DeshFire");
					PermissionsEx.getUser(jogador.getName()).addPermission("kit.deshfire");


				}
				if (gg == 8) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
					random.setItem(4, Sonic);
					kitdiarioSonic.add(jogador.getName());


					jogador.sendMessage("§b€¢ §7Voce ganhou o Kit Sonic");
					PermissionsEx.getUser(jogador.getName()).addPermission("kit.Sonic");


				}
				}
		}, 10L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				jogador.closeInventory();
			}
		}, 60L);

		jogador.openInventory(random);
	}
}
