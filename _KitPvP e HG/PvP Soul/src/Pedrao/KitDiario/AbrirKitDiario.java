package Pedrao.KitDiario;

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

import Pedrao.Main;


public class AbrirKitDiario implements Listener {

	@SuppressWarnings("unused")
	private static HashMap<String, Long> cooldown = new HashMap<String, Long>();

	 public static ArrayList<String> kitdiarioaladdin = new ArrayList<>();
	 public static ArrayList<String> kitdiariowaterbender = new ArrayList<>();
	 public static ArrayList<String> kitdiariofirebender = new ArrayList<>();
	 public static ArrayList<String> kitdiraioironman = new ArrayList<>();
	 public static ArrayList<String> kitdiariolumberjack = new ArrayList<>();
	 public static ArrayList<String> kitdiariomerlin = new ArrayList<>();
	 public static ArrayList<String> kitdiariokangaroo = new ArrayList<>();
	 public static ArrayList<String> kitdiariogladiator = new ArrayList<>();
	 public static ArrayList<String> kitdiariograppler = new ArrayList<>();
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
		if ((e.getInventory().getTitle().equalsIgnoreCase("§4§lKitDiario")) && (e.getCurrentItem() != null)
				&& (e.getCurrentItem().getTypeId() != 0)) {
			e.setCancelled(true);
		}
	}

	@SuppressWarnings("deprecation")
	public static void Inventario(final Player jogador) {
		final Inventory random = Bukkit.createInventory(jogador, 27, "§4§lKitDiario");

		final ItemStack vidro = new ItemStack(Material.getMaterial(160),1,(short)0);
		ItemMeta vidrometa = vidro.getItemMeta();
		vidrometa.setDisplayName("§7Sorteando §4§lKitDiario");
		vidro.setItemMeta(vidrometa);
		
		final ItemStack vidro1 = new ItemStack(Material.getMaterial(160),1,(short)5);
		ItemMeta vidro1meta = vidro1.getItemMeta();
		vidro1meta.setDisplayName("§7Sorteando §4§lKitDiario");
		vidro1.setItemMeta(vidro1meta);
		
		final ItemStack vidro11 = new ItemStack(Material.getMaterial(160),1,(short)14);
		ItemMeta vidro11meta = vidro11.getItemMeta();
		vidro11meta.setDisplayName("§7Sorteando §4§lKitDiario");
		vidro11.setItemMeta(vidro11meta);
		
		final ItemStack vidro111 = new ItemStack(Material.getMaterial(160),1,(short)4);
		ItemMeta vidro111meta = vidro111.getItemMeta();
		vidro111meta.setDisplayName("§7Sorteando §4§lKitDiario");
		vidro111.setItemMeta(vidro111meta);
		
		final ItemStack vidro1111 = new ItemStack(Material.getMaterial(160),1,(short)11);
		ItemMeta vidro1111meta = vidro1111.getItemMeta();
		vidro1111meta.setDisplayName("§7Sorteando §4§lKitDiario");
		vidro1111.setItemMeta(vidro1111meta);
		
		final ItemStack Bau = new ItemStack(Material.getMaterial(54));
		ItemMeta Baumeta = Bau.getItemMeta();
		Baumeta.setDisplayName("§7Espera ae Fera");
		Bau.setItemMeta(Baumeta);
		
		final ItemStack espadademadeira = new ItemStack(Material.LAVA_BUCKET);
		  ItemMeta espadademadeiraa = espadademadeira.getItemMeta();
		  espadademadeiraa.setDisplayName("§e» §7FireBender");
		  espadademadeira.setItemMeta(espadademadeiraa);

		  final ItemStack sopa = new ItemStack(Material.CARPET);
		  ItemMeta sopaa = sopa.getItemMeta();
		  sopaa.setDisplayName("§e» §7Aladdin");
		  sopa.setItemMeta(sopaa);

		  final ItemStack maÃçadourada = new ItemStack(Material.WATER_BUCKET);
		  ItemMeta maÃçadouradaa = maÃçadourada.getItemMeta();
		  maÃçadouradaa.setDisplayName("§e» §7WaterBender");
		  maÃçadourada.setItemMeta(maÃçadouradaa);

		  final ItemStack espadadepedra = new ItemStack(Material.IRON_FENCE);
		  ItemMeta espadadepedraa = espadadepedra.getItemMeta();
		  espadadepedraa.setDisplayName("§e» §7Gladiator");
		  espadadepedra.setItemMeta(espadadepedraa);

		  final ItemStack xp = new ItemStack(Material.IRON_INGOT);
		  ItemMeta xpa = xp.getItemMeta();
		  xpa.setDisplayName("§e» §7IronMan");
		  xp.setItemMeta(xpa);

		  final ItemStack lumberjack = new ItemStack(Material.STONE_AXE);
		  ItemMeta lumberjacka = lumberjack.getItemMeta();
		  lumberjacka.setDisplayName("§e» §7LumberJack");
		  lumberjack.setItemMeta(lumberjacka);

		  final ItemStack enderperal = new ItemStack(Material.FIREWORK);
		  ItemMeta enderperala = enderperal.getItemMeta();
		  enderperala.setDisplayName("§e» §7Kangaroo");
		  enderperal.setItemMeta(enderperala);
		  
		  final ItemStack grappler = new ItemStack(Material.LEASH);
		  ItemMeta grapplera = grappler.getItemMeta();
		  grapplera.setDisplayName("§e» §7Grappler");
		  grappler.setItemMeta(grapplera);

		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(0, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 5L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(1, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 10L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(2, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 15L);

		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(3, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 20L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(4, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 25L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(5, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 30L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(6, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 35L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(7, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 40L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(8, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 45L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(18, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 50L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(19, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 55L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(20, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 60L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(21, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 65L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(22, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 70L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(23, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		},75L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(24, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		},80L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(25, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		},85L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(26, vidro);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		},90L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(9, vidro1111);
				random.setItem(17, vidro1111);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		},100L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(10, vidro1);
				random.setItem(16, vidro1);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		},110L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(11, vidro111);
				random.setItem(15, vidro111);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		},120L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(12, vidro11);
				random.setItem(14, vidro11);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		},130L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				random.setItem(13, Bau);
				jogador.getWorld().playSound(jogador.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 135L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				Random r = new Random();
				int gg = r.nextInt(7) + 1;

				if (gg == 1) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
					random.setItem(13, espadademadeira);
					kitdiariofirebender.add(jogador.getName());

					jogador.sendMessage(" ");
					jogador.sendMessage("§b€¢ §7Voce ganhou o Kit FireBender");
					jogador.sendMessage(" ");

				}

				if (gg == 2) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
					random.setItem(13, sopa);
					kitdiarioaladdin.add(jogador.getName());

					jogador.sendMessage(" ");
					jogador.sendMessage("§b€¢ §7Voce ganhou o Kit Alladin");
					jogador.sendMessage(" ");

				}
				if (gg == 3) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
					random.setItem(13, maÃçadourada);
					kitdiariowaterbender.add(jogador.getName());

					jogador.sendMessage(" ");
					jogador.sendMessage("§b€¢ §7Voce ganhou o Kit WaterBender");
					jogador.sendMessage(" ");

				}
				if (gg == 4) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
					random.setItem(13, xp);
					kitdiraioironman.add(jogador.getName());

					jogador.sendMessage(" ");
					jogador.sendMessage("§b€¢ §7Voce ganhou o Kit IronMan");
					jogador.sendMessage(" ");

				}
				if (gg == 5) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
					random.setItem(13, espadadepedra);
					kitdiariogladiator.add(jogador.getName());

					jogador.sendMessage(" ");
					jogador.sendMessage("§b€¢ §7Voce ganhou o Kit Gladiator");
					jogador.sendMessage(" ");

				}
				if (gg == 6) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
					random.setItem(13, lumberjack);
					kitdiariolumberjack.add(jogador.getName());

					jogador.sendMessage(" ");
					jogador.sendMessage("§b€¢ §7Voce ganhou o Kit LumberJack");
					jogador.sendMessage(" ");

				}
				if (gg == 7) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
					random.setItem(13, enderperal);
					kitdiariokangaroo.add(jogador.getName());

					jogador.sendMessage(" ");
					jogador.sendMessage("§b€¢ §7Voce ganhou o Kit Kangaroo");
					jogador.sendMessage(" ");

				}
				if (gg == 8) {
					jogador.getWorld().playSound(jogador.getLocation(), Sound.CLICK, 10F, 10F);
					random.setItem(13, grappler);
					kitdiariograppler.add(jogador.getName());

					jogador.sendMessage(" ");
					jogador.sendMessage("§b€¢ §7Voce ganhou o Kit Grappler");
					jogador.sendMessage(" ");

				}
				}
		}, 200L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				jogador.closeInventory();
			}
		}, 250L);

		jogador.openInventory(random);
	}

	@EventHandler
	public void aoInteragir(final PlayerInteractEvent evento) {
		final Player jogador = evento.getPlayer();
		if (jogador.getItemInHand().getType() == Material.STORAGE_MINECART) {
			if ((evento.getAction() == Action.RIGHT_CLICK_AIR) || (evento.getAction() == Action.RIGHT_CLICK_BLOCK)) {
				if (setandokit.contains(jogador.getName())) {
					jogador.sendMessage(Main.prefix + "Voce ja recebeu seu §4§lKitDiario §b§l! ");
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
