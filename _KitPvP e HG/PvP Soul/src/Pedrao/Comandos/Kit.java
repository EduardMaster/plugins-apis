package Pedrao.Comandos;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Pedrao.KitAPI;
import Pedrao.Main;
import Pedrao.Eventos.Habilidade;

public class Kit implements CommandExecutor, Listener {

	public Kit(Main main) {
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;

		if (label.equalsIgnoreCase("kit")) {
			if (args.length == 0) {
				p.sendMessage(Main.prefix + " §c§l Use /Kit [Abilidade]");
				return true;
			}
			if (KitAPI.Kit.contains(p.getName())) {
				p.sendMessage(Main.prefix + "Você já esta usando um kit!");
				return true;
			}
			if (args[0].equalsIgnoreCase("pvp")) {
				if (p.hasPermission("kit.pvp")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "PvP");
					KitAPI.Kit.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit PvP");
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("archer")) {
				if (p.hasPermission("kit.archer")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "Archer");
					KitAPI.Kit.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit Archer");
					KitAPI.setitem(p, Material.BOW, "§B§LArco", 8, Enchantment.ARROW_INFINITE, 1, true);
					KitAPI.setitem(p, Material.ARROW, "§B§LFlecha", 9, Enchantment.ARROW_INFINITE, 1, false);
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("Kangaroo")) {
				if (p.hasPermission("kit.Kangaroo")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "Kangaroo");
					KitAPI.Kit.add(p.getName());
					KitAPI.Kangaroo.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit Kangaroo");
					KitAPI.setitem(p, Material.FIREWORK, "§B§LKangaroo", 8, Enchantment.DURABILITY, 1, false);
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("fisherman")) {
				if (p.hasPermission("kit.Fisherman")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "Fisherman");
					KitAPI.Kit.add(p.getName());
					KitAPI.Fisherman.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit Fisherman");
					KitAPI.setitem(p, Material.FISHING_ROD, "§B§LFisherman", 8, Enchantment.DURABILITY, 3, false);
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("Anchor")) {
				if (p.hasPermission("kit.Anchor")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "Anchor");
					KitAPI.Kit.add(p.getName());
					KitAPI.Anchor.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit Anchor");
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("Kronos")) {
				if (p.hasPermission("kit.Kronos")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "Kronos");
					KitAPI.Kit.add(p.getName());
					KitAPI.Kronos.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit Kronos");
					KitAPI.setitem(p, Material.GLOWSTONE_DUST, "§B§LHACK", 8, Enchantment.DURABILITY, 1, false);
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("Viper")) {
				if (p.hasPermission("kit.Viper")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "Viper");
					KitAPI.Kit.add(p.getName());
					KitAPI.Viper.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit Viper");
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("Snail")) {
				if (p.hasPermission("kit.Snail")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "Snail");
					KitAPI.Kit.add(p.getName());
					KitAPI.Snail.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit Snail");
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("Stomper")) {
				if (p.hasPermission("kit.Stomper")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "Stomper");
					KitAPI.Kit.add(p.getName());
					KitAPI.Stomper.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit Stomper");
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("FireBender")) {
				if (p.hasPermission("kit.FireBender")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "FireBender");
					KitAPI.Kit.add(p.getName());
					KitAPI.FireBender.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit FireBender");
					KitAPI.setitem(p, Material.REDSTONE, "§B§LFireBender", 8, Enchantment.DURABILITY, 1, false);
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("WaterBender")) {
				if (p.hasPermission("kit.WaterBender")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "WaterBender");
					KitAPI.Kit.add(p.getName());
					KitAPI.WaterBender.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit WaterBender");
					KitAPI.setitem(p, Material.INK_SACK, "§B§LWaterBender", 8, Enchantment.DURABILITY, 1, false);
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("Curandeiro")) {
				if (p.hasPermission("kit.Curandeiro")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "Curadeiro");
					KitAPI.Kit.add(p.getName());
					KitAPI.Curandeiro.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit Curadeiro");
					KitAPI.setitem(p, Material.SULPHUR, "§B§LCuradeiro", 8, Enchantment.DURABILITY, 1, false);
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("Cactus")) {
				if (p.hasPermission("kit.Cactus")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "Cactus");
					KitAPI.Kit.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit Cactus");
					ItemStack cacts = new ItemStack(Material.CACTUS);
					ItemMeta cactsmeta = cacts.getItemMeta();
					cactsmeta.setDisplayName("§aCactus");
					cactsmeta.addEnchant(Enchantment.THORNS, 3, true);
					cacts.setItemMeta(cactsmeta);
					p.getInventory().setHelmet(cacts);
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("Grandpa")) {
				if (p.hasPermission("kit.Grandpa")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "Grandpa");
					KitAPI.Kit.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit Grandpa");
					ItemStack kpiru = new ItemStack(Material.STICK);
					kpiru.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
					ItemMeta kkpiru = kpiru.getItemMeta();
					kkpiru.setDisplayName("§aGrandpa");
					kpiru.setItemMeta(kkpiru);
					p.getInventory().setItem(8, kpiru);
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("Laucher")) {
				if (p.hasPermission("kit.Laucher")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "Laucher");
					KitAPI.Kit.add(p.getName());
					KitAPI.Laucher.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit Laucher");
					ItemStack kpiru = new ItemStack(Material.SPONGE,15);
					ItemMeta kkpiru = kpiru.getItemMeta();
					kkpiru.setDisplayName("§aLaucher");
					kpiru.setItemMeta(kkpiru);
					p.getInventory().setItem(8, kpiru);
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("Urgal")) {
				if (p.hasPermission("kit.Urgal")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "Urgal");
					KitAPI.Kit.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit Urgal");
					ItemStack mf = new ItemStack(Material.POTION, 3, (short) 8201);
					ItemMeta kmf = mf.getItemMeta();
					kmf.setDisplayName("§aUrgal");
					mf.setItemMeta(kmf);
					p.getInventory().setItem(8, mf);
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("DeathNote")) {
				if (p.hasPermission("kit.DeathNote")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "DeathNote");
					KitAPI.Kit.add(p.getName());
					KitAPI.DeathNote.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit DeathNote");
					KitAPI.setitem(p, Material.BOOK, "§B§LDeathNote", 8, Enchantment.DURABILITY, 1, false);
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("BloodGun")) {
				if (p.hasPermission("kit.BloodGun")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "BloodGun");
					KitAPI.Kit.add(p.getName());
					KitAPI.BloodGun.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit BloodGun");
					KitAPI.setitem(p, Material.WOOD_HOE, "§B§LBloodGun", 8, Enchantment.DURABILITY, 1, false);
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("Urano")) {
				if (p.hasPermission("kit.Urano")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "Urano");
					KitAPI.Kit.add(p.getName());
					KitAPI.Urano.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit Urano");
					KitAPI.setitem(p, Material.SLIME_BALL, "§B§LUrano", 8, Enchantment.DURABILITY, 1, false);
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("Tornado")) {
				if (p.hasPermission("kit.Tornado")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "Tornado");
					KitAPI.Kit.add(p.getName());
					KitAPI.Tornado.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit Tornado");
					KitAPI.setitem(p, Material.HOPPER, "§B§LTornado", 8, Enchantment.DURABILITY, 1, false);
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("Terrorista")) {
				if (p.hasPermission("kit.Terrorista")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "Terrorista");
					KitAPI.Kit.add(p.getName());
					KitAPI.Terrorista.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit Terrorista");
					KitAPI.setitem(p, Material.MAGMA_CREAM, "§B§LTerrorista", 8, Enchantment.DURABILITY, 1, false);
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("Sonic")) {
				if (p.hasPermission("kit.Sonic")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "Sonic");
					KitAPI.Kit.add(p.getName());
					KitAPI.Sonic.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit Sonic");
					KitAPI.setitem(p, Material.LAPIS_BLOCK, "§B§LSonic", 8, Enchantment.DURABILITY, 1, false);
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("DeshFire")) {
				if (p.hasPermission("kit.DeshFire")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "DeshFire");
					KitAPI.Kit.add(p.getName());
					KitAPI.DeshFire.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit DeshFire");
					KitAPI.setitem(p, Material.REDSTONE_BLOCK, "§B§LDeshFire", 8, Enchantment.DURABILITY, 1, false);
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("Gravity")) {
				if (p.hasPermission("kit.Gravity")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "Gravity");
					KitAPI.Kit.add(p.getName());
					KitAPI.Gravity.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit Gravity");
					KitAPI.setitem(p, Material.BLAZE_ROD, "§B§LGravity", 8, Enchantment.DURABILITY, 1, false);
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("Rain")) {
				if (p.hasPermission("kit.Rain")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "Rain");
					KitAPI.Kit.add(p.getName());
					KitAPI.Rain.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit Rain");
					KitAPI.setitem(p, Material.ARROW, "§B§LRain", 8, Enchantment.DURABILITY, 1, false);
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("Velotrol")) {
				if (p.hasPermission("kit.Velotrol")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "Velotrol");
					KitAPI.Kit.add(p.getName());
					KitAPI.Velotrol.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit Velotrol");
					KitAPI.setitem(p, Material.MINECART, "§B§LVelotrol", 8, Enchantment.DURABILITY, 1, false);
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("Jutso")) {
				if (p.hasPermission("kit.Jutso")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "Jutso");
					KitAPI.Kit.add(p.getName());
					KitAPI.Jutso.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit Jutso");
					KitAPI.setitem(p, Material.PAPER, "§B§LJutso", 8, Enchantment.DURABILITY, 1, false);
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("ForceField")) {
				if (p.hasPermission("kit.ForceField")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "ForceField");
					KitAPI.Kit.add(p.getName());
					KitAPI.ForceField.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit ForceField");
					KitAPI.setitem(p, Material.NETHER_FENCE, "§B§LForceField", 8, Enchantment.DURABILITY, 1, false);
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("Sasuke")) {
				if (p.hasPermission("kit.Sasuke")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "Sasuke");
					KitAPI.Kit.add(p.getName());
					KitAPI.Sasuke.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit Sasuke");
					KitAPI.setitem(p, Material.FIREWORK_CHARGE, "§B§LSasuke", 8, Enchantment.DURABILITY, 1, false);
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("Pikachu")) {
				if (p.hasPermission("kit.Pikachu")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "Pikachu");
					KitAPI.Kit.add(p.getName());
					KitAPI.Pikachu.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit Pikachu");
					KitAPI.setitem(p, Material.FLINT, "§B§LPikachu", 8, Enchantment.DURABILITY, 1, false);
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("Vunerable")) {
				if (p.hasPermission("kit.Vunerable")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "Vunerable");
					KitAPI.Kit.add(p.getName());
					KitAPI.Vunerable.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit Vunerable");
					KitAPI.setitem(p, Material.BEACON, "§B§LVunerable", 8, Enchantment.DURABILITY, 1, false);
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("Gladiator")) {
				if (p.hasPermission("kit.Gladiator")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "Gladiator");
					KitAPI.Kit.add(p.getName());
					KitAPI.Gladiator.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit Gladiator");
					KitAPI.setitem(p, Material.IRON_FENCE, "§B§LGladiator", 8, Enchantment.DURABILITY, 1, false);
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("Ninja")) {
				if (p.hasPermission("kit.Ninja")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "Ninja");
					KitAPI.Kit.add(p.getName());
					KitAPI.Ninja.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit Ninja");
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("LifeStealer")) {
				if (p.hasPermission("kit.LifeStealer")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "LifeStealer");
					KitAPI.Kit.add(p.getName());
					KitAPI.LifeStealer.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit LifeStealer");
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("ChestPlate")) {
				if (p.hasPermission("kit.ChestPlate")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "ChestPlate");
					KitAPI.Kit.add(p.getName());
					KitAPI.ChestPlate.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit ChestPlate");
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("Grappler")) {
				if (p.hasPermission("kit.Grappler")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "Grappler");
					KitAPI.Kit.add(p.getName());
					KitAPI.Grappler.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit Grappler");
					KitAPI.setitem(p, Material.LEASH, "§B§LGrappler", 8, Enchantment.DURABILITY, 1, false);
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("Sword")) {
				if (p.hasPermission("kit.Sword")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "Sword");
					KitAPI.Kit.add(p.getName());
					KitAPI.SwordKit.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit Sword");
					ItemStack mf = new ItemStack(Material.WOOD_SWORD);
					ItemMeta kmf = mf.getItemMeta();
					kmf.setDisplayName("§aSword");
					mf.setItemMeta(kmf);
					p.getInventory().setItem(0, mf);
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("Hulk")) {
				if (p.hasPermission("kit.Hulk")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "Hulk");
					KitAPI.Kit.add(p.getName());
					KitAPI.Hulk.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit Hulk");
					KitAPI.setitem(p, Material.SADDLE, "§B§LHulk", 8, Enchantment.DURABILITY, 1, false);
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("Mago")) {
				if (p.hasPermission("kit.Mago")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "Mago");
					KitAPI.Kit.add(p.getName());
					KitAPI.Mago.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit Mago");
					KitAPI.setitem(p, Material.BONE, "§B§LMago", 8, Enchantment.DURABILITY, 1, false);
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("C4")) {
				if (p.hasPermission("kit.C4")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "C4");
					KitAPI.Kit.add(p.getName());
					KitAPI.C4.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit C4");
					KitAPI.setitem(p, Material.TNT, "§B§LC4", 8, Enchantment.DURABILITY, 1, false);
				} else {
					p.sendMessage(Main.semperm);
				}
			}
			if (args[0].equalsIgnoreCase("Thresh")) {
				if (p.hasPermission("kit.Thresh")) {
					p.getInventory().clear();
					KitAPI.recraft(p);
					KitAPI.sopa(p);
					KitAPI.sword(p);
					Arena.TeleportArenaRandom(p);
					Habilidade.setAbility(p, "Thresh");
					KitAPI.Kit.add(p.getName());
					KitAPI.Thresh.add(p.getName());
					p.sendMessage(Main.prefix + "§b§lVoce escoleu o Kit Thresh");
					KitAPI.setitem(p, Material.GOLD_PICKAXE, "§B§LThresh", 8, Enchantment.DURABILITY, 1, false);
				} else {
					p.sendMessage(Main.semperm);
				}
			}
		}
		return false;
	}
}
