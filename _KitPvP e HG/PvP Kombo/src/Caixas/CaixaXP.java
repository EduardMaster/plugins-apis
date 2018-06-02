package Caixas;
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

import XP.XpM;
import me.rafael.vinagre.KomboPvP.Main;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class CaixaXP implements Listener {

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

	public CaixaXP(Main main) {
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
		if ((e.getInventory().getTitle().equalsIgnoreCase("ße ß7KITDIARIO ße")) && (e.getCurrentItem() != null)
				&& (e.getCurrentItem().getTypeId() != 0)) {
			e.setCancelled(true);
		}
	}

	@SuppressWarnings("deprecation")
	public static void Inventario(final Player jogador) {
		final Inventory random = Bukkit.createInventory(jogador, 9, "ße ß7KITDIARIO ße");

		final ItemStack vidro = new ItemStack(Material.getMaterial(102));
		ItemMeta vidrometa = vidro.getItemMeta();
		vidrometa.setDisplayName("ß7Sorteando O Item");
		vidro.setItemMeta(vidrometa);

		final ItemStack vidro1 = new ItemStack(Material.getMaterial(160));
		vidro1.setDurability((short) 7);
		ItemMeta vidrometa1 = vidro1.getItemMeta();
		vidrometa1.setDisplayName("ß7Sorteando O Item");
		vidro1.setItemMeta(vidrometa1);

		final ItemStack vidrovermelho = new ItemStack(Material.getMaterial(160),1 ,(short)2);
		vidrovermelho.setDurability((short) 14);
		ItemMeta vidrovermelhoa = vidrovermelho.getItemMeta();
		vidrovermelhoa.setDisplayName("ß7Sorteando O Item");
		vidrovermelho.setItemMeta(vidrovermelhoa);

		final ItemStack vidropreto = new ItemStack(Material.getMaterial(160),1 ,(short)4);
		vidropreto.setDurability((short) 0);
		ItemMeta vidropretoa = vidropreto.getItemMeta();
		vidropretoa.setDisplayName("ß7Sorteando O Item");
		vidropreto.setItemMeta(vidropretoa);

		final ItemStack espadademadeira = new ItemStack(Material.GOLD_NUGGET);
		  ItemMeta espadademadeiraa = espadademadeira.getItemMeta();
		  espadademadeiraa.setDisplayName("ße ß7200");
		  espadademadeira.setItemMeta(espadademadeiraa);

		  final ItemStack sopa = new ItemStack(Material.GOLD_INGOT);
		  ItemMeta sopaa = sopa.getItemMeta();
		  sopaa.setDisplayName("ße ß7400");
		  sopa.setItemMeta(sopaa);

		  final ItemStack ma√adourada = new ItemStack(Material.GOLD_BLOCK);
		  ItemMeta ma√adouradaa = ma√adourada.getItemMeta();
		  ma√adouradaa.setDisplayName("ße ß7800");
		  ma√adourada.setItemMeta(ma√adouradaa);

		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				Random r = new Random();
				int gg = r.nextInt(3) + 1;

				if (gg == 1) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
					random.setItem(4, espadademadeira);
					kitdiariofirebender.add(jogador.getName());


					jogador.sendMessage("ßbÄ¢ ß7Voce ganhou 200 XP");
					XpM.addMoney(jogador, 200);
					Scoreboard.ScoreDoBasic.iscoriboard(jogador);


				}

				if (gg == 2) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
					random.setItem(4, sopa);
					kitdiarioaladdin.add(jogador.getName());


					jogador.sendMessage("ßbÄ¢ ß7Voce ganhou 400 XP");
					XpM.addMoney(jogador, 400);
					Scoreboard.ScoreDoBasic.iscoriboard(jogador);

				}
				if (gg == 3) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
					random.setItem(4, ma√adourada);
					kitdiariowaterbender.add(jogador.getName());


					jogador.sendMessage("ßbÄ¢ ß7Voce ganhou 800 XP");
					XpM.addMoney(jogador, 800);
					Scoreboard.ScoreDoBasic.iscoriboard(jogador);


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
