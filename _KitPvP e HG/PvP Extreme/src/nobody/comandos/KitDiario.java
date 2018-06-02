package nobody.comandos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import nobody.eventos.KitAPI;
import nobody.eventos.Money;
import nobody.main.Main;

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

public class KitDiario implements Listener {

	@SuppressWarnings("unused")
	private static HashMap<String, Long> cooldown = new HashMap<String, Long>();

	 public static ArrayList<String> XPDIARIOaladdin = new ArrayList<>();
	 public static ArrayList<String> XPDIARIOwaterbender = new ArrayList<>();
	 public static ArrayList<String> XPDIARIOfirebender = new ArrayList<>();
	 public static ArrayList<String> kitdiraioironman = new ArrayList<>();
	 public static ArrayList<String> XPDIARIOlumberjack = new ArrayList<>();
	 public static ArrayList<String> XPDIARIOmerlin = new ArrayList<>();
	 public static ArrayList<String> XPDIARIOkangaroo = new ArrayList<>();
	 public static ArrayList<String> XPDIARIOgladiator = new ArrayList<>();
	 public static ArrayList<String> XPDIARIOgrappler = new ArrayList<>();
	 public static ArrayList<String> setandokit = new ArrayList<>();

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
		if ((e.getInventory().getTitle().equalsIgnoreCase("§7• §7XPDIARIO §7•")) && (e.getCurrentItem() != null)
				&& (e.getCurrentItem().getTypeId() != 0)) {
			e.setCancelled(true);
		}
	}

	@SuppressWarnings("deprecation")
	public static void Inventario(final Player jogador) {
		final Inventory random = Bukkit.createInventory(jogador, 9, "§7• §7XPDIARIO §7•");

		final ItemStack vidro = new ItemStack(Material.getMaterial(102));
		ItemMeta vidrometa = vidro.getItemMeta();
		vidrometa.setDisplayName("§7Sorteando seu XP...");
		vidro.setItemMeta(vidrometa);
		
		final ItemStack vidro1 = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)3);
		ItemMeta vidrometa1 = vidro.getItemMeta();
		vidrometa.setDisplayName("§7Sorteando seu XP...");
		vidro1.setItemMeta(vidrometa1);



		final ItemStack espadademadeira = new ItemStack(Material.EXP_BOTTLE);
		  ItemMeta espadademadeiraa = espadademadeira.getItemMeta();
		  espadademadeiraa.setDisplayName("§7• §7100§7 de XP §7•");
		  espadademadeira.setItemMeta(espadademadeiraa);

		  final ItemStack sopa = new ItemStack(Material.EXP_BOTTLE);
		  ItemMeta sopaa = sopa.getItemMeta();
		  sopaa.setDisplayName("§7• §7200§7 de XP §7•");
		  sopa.setItemMeta(sopaa);

		  final ItemStack maçadourada = new ItemStack(Material.EXP_BOTTLE);
		  ItemMeta maçadouradaa = maçadourada.getItemMeta();
		  maçadouradaa.setDisplayName("§7• §7300§7 de XP §7•");
		  maçadourada.setItemMeta(maçadouradaa);

		  final ItemStack espadadepedra = new ItemStack(Material.EXP_BOTTLE);
		  ItemMeta espadadepedraa = espadadepedra.getItemMeta();
		  espadadepedraa.setDisplayName("§7• §7400§7 de XP §7•");
		  espadadepedra.setItemMeta(espadadepedraa);

		  final ItemStack xp = new ItemStack(Material.EXP_BOTTLE);
		  ItemMeta xpa = xp.getItemMeta();
		  xpa.setDisplayName("§7• §7500§7 de XP §7•");
		  xp.setItemMeta(xpa);

		  final ItemStack lumberjack = new ItemStack(Material.EXP_BOTTLE);
		  ItemMeta lumberjacka = lumberjack.getItemMeta();
		  lumberjacka.setDisplayName("§7• §7600§7 de XP §7•");
		  lumberjack.setItemMeta(lumberjacka);

		  final ItemStack enderperal = new ItemStack(Material.EXP_BOTTLE);
		  ItemMeta enderperala = enderperal.getItemMeta();
		  enderperala.setDisplayName("§7• §7700§7 de XP §7•");
		  enderperal.setItemMeta(enderperala);
		  
		  final ItemStack grappler = new ItemStack(Material.EXP_BOTTLE);
		  ItemMeta grapplera = grappler.getItemMeta();
		  grapplera.setDisplayName("§7• §7800§7 de XP §7•");
		  grappler.setItemMeta(grapplera);

		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(0, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
			}
		}, 5L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(1, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
			}
		}, 10L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(2, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
			}
		}, 15L);

		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(3, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
			}
		}, 20L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(4, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
			}
		}, 25L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(5, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
			}
		}, 30L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(6, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
			}
		}, 35L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(7, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
			}
		}, 40L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(8, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
			}
		}, 45L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(0, vidro);
				random.setItem(1, vidro);
				random.setItem(2, vidro);
				random.setItem(3, vidro);
				random.setItem(4, vidro);
				random.setItem(5, vidro);
				random.setItem(6, vidro);
				random.setItem(7, vidro);
				random.setItem(8, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
			}
		}, 50L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(0, vidro1);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
			}
		}, 55L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(1, vidro1);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
			}
		}, 65L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(2, vidro1);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
			}
		}, 70L);

		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(3, vidro1);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
			}
		}, 75L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(4, vidro1);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
			}
		}, 80L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(5, vidro1);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
			}
		}, 85L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(6, vidro1);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
			}
		}, 90L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(7, vidro1);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
			}
		}, 95L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(8, vidro1);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
			}
		}, 200L);
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(9, vidro1);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
			}
		}, 200L);
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(4, vidro1);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.LEVEL_UP, 10F, 10F);
			}
		}, 105L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				Random r = new Random();
				int gg = r.nextInt(7) + 1;

				if (gg == 1) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.LEVEL_UP, 10F, 10F);
					random.setItem(4, espadademadeira);
					XPDIARIOfirebender.add(jogador.getName());
					jogador.sendMessage("§7[§6§l!§7] §7Você Ganhou §b  100§7 de XP!");
					Money.addMoney(100, jogador);
				}

				if (gg == 2) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.LEVEL_UP, 10F, 10F);
					random.setItem(4, sopa);
					XPDIARIOaladdin.add(jogador.getName());
					jogador.sendMessage("§7[§6§l!§7] §7Você Ganhou §b  200§7 de XP!");
					Money.addMoney(200, jogador);
				}
				if (gg == 3) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.LEVEL_UP, 10F, 10F);
					random.setItem(4, maçadourada);
					XPDIARIOwaterbender.add(jogador.getName());
					jogador.sendMessage("§7[§6§l!§7] §7Você Ganhou §b  300§7 de XP!");
					Money.addMoney(300, jogador);
				}
				if (gg == 4) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.LEVEL_UP, 10F, 10F);
					random.setItem(4, xp);
					kitdiraioironman.add(jogador.getName());
					jogador.sendMessage("§7[§6§l!§7] §7Você Ganhou §b  400§7 de XP!");
					Money.addMoney(400, jogador);
				}
				if (gg == 5) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.LEVEL_UP, 10F, 10F);
					random.setItem(4, espadadepedra);
					XPDIARIOgladiator.add(jogador.getName());
					jogador.sendMessage("§7[§6§l!§7] §7Você Ganhou §b  500§7 de XP!");
					Money.addMoney(500, jogador);
				}
				if (gg == 6) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.LEVEL_UP, 10F, 10F);
					random.setItem(4, lumberjack);
					XPDIARIOlumberjack.add(jogador.getName());
					jogador.sendMessage("§7[§6§l!§7] §7Você Ganhou §b  600§7 de XP!");
					Money.addMoney(600, jogador);
				}
				if (gg == 7) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.LEVEL_UP, 10F, 10F);
					random.setItem(4, enderperal);
					XPDIARIOkangaroo.add(jogador.getName());
					jogador.sendMessage("§7[§6§l!§7] §7Você Ganhou §b  700§7 de XP!");
					Money.addMoney(700, jogador);
				}
				if (gg == 8) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.LEVEL_UP, 10F, 10F);
					random.setItem(4, grappler);
					XPDIARIOgrappler.add(jogador.getName());
					jogador.sendMessage("§7[§6§l!§7] §7Você Ganhou §b 800§7 de XP!");
					Money.addMoney(800, jogador);
				}
				}
		}, 110L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				jogador.closeInventory();
			}
		}, 130L);

		jogador.openInventory(random);
	}

	@EventHandler
	public void aoInteragir(final PlayerInteractEvent evento) {
		final Player jogador = evento.getPlayer();
		if (KitAPI.getkit(jogador) == "Nenhum") {
		if (jogador.getItemInHand().getType() == Material.EXP_BOTTLE) {
			if ((evento.getAction() == Action.RIGHT_CLICK_AIR) || (evento.getAction() == Action.RIGHT_CLICK_BLOCK)) {
				if (setandokit.contains(jogador.getName())) {
					jogador.sendMessage("§6{§a§lXPDIARIO§6} Voce já recebeu seu Item!");
					evento.setCancelled(true);
					return;
				}

				evento.setCancelled(true);

				Inventario(jogador);

				playFirework(jogador.getLocation(), Color.RED, evento.getPlayer());
				playFirework(jogador.getLocation(), Color.LIME, evento.getPlayer());
				playFirework(jogador.getLocation(), Color.AQUA, evento.getPlayer());

				setandokit.add(jogador.getName());

				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
					public void run() {
						playFirework(jogador.getLocation(), Color.ORANGE, evento.getPlayer());
						playFirework(jogador.getLocation(), Color.GREEN, evento.getPlayer());
						playFirework(jogador.getLocation(), Color.PURPLE, evento.getPlayer());
					}
				}, 20L);

			}
			
		}
	}
}
}
