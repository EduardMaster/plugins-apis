package me.Pedro.CMD;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.Pedro.Main;
import me.Pedro.Eventos.API;
import me.Pedro.Eventos.KitAPI;
import me.Pedro.Score.Habilidade;

public class Kit implements CommandExecutor, Listener {

	public Kit(Main main) {
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;

		if (label.equalsIgnoreCase("kit")) {
			if (args.length == 0) {
				p.sendMessage(API.sev + "Use /Kit [Abilidade]");
				return true;
			}
			if (KitAPI.Kit.contains(p.getName())) {
				p.sendMessage(API.sev + "Você já esta usando um kit!");
				return true;
			}
			if (args[0].equalsIgnoreCase("pvp")) {
				if (p.hasPermission("kit.pvp")) {
					p.getInventory().clear();
					KitAPI.GiveKit(p);
					Habilidade.setAbility(p, "PvP");
					KitAPI.Kit.add(p.getName());
					p.sendMessage(API.sev + "Voce pegou o Kit§a§l PvP");
				} else {
					p.sendMessage(API.s);
				}
			}
			if (args[0].equalsIgnoreCase("Stomper")) {
				if (p.hasPermission("kit.Stomper")) {
					p.getInventory().clear();
					KitAPI.GiveKit(p);
					Habilidade.setAbility(p, "Stomper");
					KitAPI.Kit.add(p.getName());
					KitAPI.Stomper.add(p.getName());
					p.sendMessage(API.sev + "Voce pegou o Kit§a§l Stomper");
				} else {
					p.sendMessage(API.s);
				}
			}
			if (args[0].equalsIgnoreCase("AntiStomper")) {
				if (p.hasPermission("kit.AntiStomper")) {
					p.getInventory().clear();
					KitAPI.GiveKit(p);
					Habilidade.setAbility(p, "Stomper");
					KitAPI.Kit.add(p.getName());
					KitAPI.AntiStomper.add(p.getName());
					p.sendMessage(API.sev + "Voce pegou o Kit§a§l AntiStomper");
				} else {
					p.sendMessage(API.s);
				}
			}
			if (args[0].equalsIgnoreCase("QuickDropper")) {
				if (p.hasPermission("kit.QuickDropper")) {
					p.getInventory().clear();
					KitAPI.GiveKit(p);
					Habilidade.setAbility(p, "QuickDropper");
					KitAPI.Kit.add(p.getName());
					KitAPI.QuickDropper.add(p.getName());
					p.sendMessage(API.sev + "Voce pegou o Kit§a§l QuickDropper");
				} else {
					p.sendMessage(API.s);
				}
			}
			if (args[0].equalsIgnoreCase("Kangaroo")) {
				if (p.hasPermission("kit.Kangaroo")) {
					p.getInventory().clear();
					KitAPI.GiveKit(p);
					Habilidade.setAbility(p, "Kangaroo");
					KitAPI.Kit.add(p.getName());
					KitAPI.Kangaroo.add(p.getName());
					p.sendMessage(API.sev + "Voce pegou o Kit§a§l Kangaroo");
					API.setitem(p, Material.FIREWORK, "§7- §c§lKit §7- " + p.getName(), 1, Enchantment.ARROW_DAMAGE, 0,false);
				} else {
					p.sendMessage(API.s);
				}
			}
			if (args[0].equalsIgnoreCase("Thor")) {
				if (p.hasPermission("kit.Thor")) {
					p.getInventory().clear();
					KitAPI.GiveKit(p);
					Habilidade.setAbility(p, "Thor");
					KitAPI.Kit.add(p.getName());
					KitAPI.Thor.add(p.getName());
					p.sendMessage(API.sev + "Voce pegou o Kit§a§l Thor");
					API.setitem(p, Material.WOOD_AXE, "§7- §c§lKit §7- " + p.getName(), 1, Enchantment.ARROW_DAMAGE, 0,false);
				} else {
					p.sendMessage(API.s);
				}
			}
			if (args[0].equalsIgnoreCase("Bazooka")) {
				if (p.hasPermission("kit.Bazooka")) {
					p.getInventory().clear();
					KitAPI.GiveKit(p);
					Habilidade.setAbility(p, "Bazooka");
					KitAPI.Kit.add(p.getName());
					KitAPI.Bazooka.add(p.getName());
					p.sendMessage(API.sev + "Voce pegou o Kit§a§l Bazooka");
					API.setitem(p, Material.GOLD_BARDING, "§7- §c§lKit §7- " + p.getName(), 1, Enchantment.ARROW_DAMAGE, 0,false);
				} else {
					p.sendMessage(API.s);
				}
			}
			if (args[0].equalsIgnoreCase("Ajnin")) {
				if (p.hasPermission("kit.Ajnin")) {
					p.getInventory().clear();
					KitAPI.GiveKit(p);
					Habilidade.setAbility(p, "Ajnin");
					KitAPI.Kit.add(p.getName());
					KitAPI.Ajnin.add(p.getName());
					p.sendMessage(API.sev + "Voce pegou o Kit§a§l Ajnin");
				} else {
					p.sendMessage(API.s);
				}
			}
			if (args[0].equalsIgnoreCase("Ninja")) {
				if (p.hasPermission("kit.Ninja")) {
					p.getInventory().clear();
					KitAPI.GiveKit(p);
					Habilidade.setAbility(p, "Ninja");
					KitAPI.Kit.add(p.getName());
					KitAPI.Ninja.add(p.getName());
					p.sendMessage(API.sev + "Voce pegou o Kit§a§l Ninja");
				} else {
					p.sendMessage(API.s);
				}
			}
			if (args[0].equalsIgnoreCase("Anchor")) {
				if (p.hasPermission("kit.Anchor")) {
					p.getInventory().clear();
					KitAPI.GiveKit(p);
					Habilidade.setAbility(p, "Anchor");
					KitAPI.Kit.add(p.getName());
					KitAPI.Anchor.add(p.getName());
					p.sendMessage(API.sev + "Voce pegou o Kit§a§l Anchor");
				} else {
					p.sendMessage(API.s);
				}
			}
			if (args[0].equalsIgnoreCase("Fisherman")) {
				if (p.hasPermission("kit.Fisherman")) {
					p.getInventory().clear();
					KitAPI.GiveKit(p);
					Habilidade.setAbility(p, "Fisherman");
					KitAPI.Kit.add(p.getName());
					KitAPI.Fisherman.add(p.getName());
					p.sendMessage(API.sev + "Voce pegou o Kit§a§l Fisherman");
					API.setitem(p, Material.FISHING_ROD, "§7- §c§lKit §7- " + p.getName(), 1, Enchantment.ARROW_DAMAGE, 0,false);
				} else {
					p.sendMessage(API.s);
				}
			}
			if (args[0].equalsIgnoreCase("Levitator")) {
				if (p.hasPermission("kit.Levitator")) {
					p.getInventory().clear();
					KitAPI.GiveKit(p);
					Habilidade.setAbility(p, "Levitator");
					KitAPI.Kit.add(p.getName());
					KitAPI.Levitator.add(p.getName());
					p.sendMessage(API.sev + "Voce pegou o Kit§a§l Levitator");
					API.setitem(p, Material.WOOL, "§7- §c§lKit §7- " + p.getName(), 1, Enchantment.ARROW_DAMAGE, 0,false);
				} else {
					p.sendMessage(API.s);
				}
			}
			if (args[0].equalsIgnoreCase("DeathNote")) {
				if (p.hasPermission("kit.DeathNote")) {
					p.getInventory().clear();
					KitAPI.GiveKit(p);
					Habilidade.setAbility(p, "DeathNote");
					KitAPI.Kit.add(p.getName());
					KitAPI.DeathNote.add(p.getName());
					p.sendMessage(API.sev + "Voce pegou o Kit§a§l DeathNote");
					API.setitem(p, Material.BOOK, "§7- §c§lKit §7- " + p.getName(), 1, Enchantment.ARROW_DAMAGE, 0,false);
				} else {
					p.sendMessage(API.s);
				}
			}
			if (args[0].equalsIgnoreCase("BurstMaster")) {
				if (p.hasPermission("kit.BurstMaster")) {
					p.getInventory().clear();
					KitAPI.GiveKit(p);
					Habilidade.setAbility(p, "BurstMaster");
					KitAPI.Kit.add(p.getName());
					KitAPI.BurstMaster.add(p.getName());
					p.sendMessage(API.sev + "Voce pegou o Kit§a§l BurstMaster");
					API.setitem(p, Material.GOLD_HOE, "§7- §c§lKit §7- " + p.getName(), 1, Enchantment.ARROW_DAMAGE, 0,false);
				} else {
					p.sendMessage(API.s);
				}
			}
			if (args[0].equalsIgnoreCase("Sonic")) {
				if (p.hasPermission("kit.Sonic")) {
					p.getInventory().clear();
					KitAPI.GiveKit(p);
					Habilidade.setAbility(p, "Sonic");
					KitAPI.Kit.add(p.getName());
					KitAPI.Sonic.add(p.getName());
					p.sendMessage(API.sev + "Voce pegou o Kit§a§l Sonic");
					API.setitem(p, Material.LAPIS_BLOCK, "§7- §c§lKit §7- " + p.getName(), 1, Enchantment.ARROW_DAMAGE, 0,false);
				} else {
					p.sendMessage(API.s);
				}
			}
			if (args[0].equalsIgnoreCase("Deshfire")) {
				if (p.hasPermission("kit.Deshfire")) {
					p.getInventory().clear();
					KitAPI.GiveKit(p);
					Habilidade.setAbility(p, "Deshfire");
					KitAPI.Kit.add(p.getName());
					KitAPI.Deshfire.add(p.getName());
					p.sendMessage(API.sev + "Voce pegou o Kit§a§l Deshfire");
					API.setitem(p, Material.REDSTONE_BLOCK, "§7- §c§lKit §7- " + p.getName(), 1, Enchantment.ARROW_DAMAGE, 0,false);
				} else {
					p.sendMessage(API.s);
				}
			}
			if (args[0].equalsIgnoreCase("TimeLord")) {
				if (p.hasPermission("kit.TimeLord")) {
					p.getInventory().clear();
					KitAPI.GiveKit(p);
					Habilidade.setAbility(p, "TimeLord");
					KitAPI.Kit.add(p.getName());
					KitAPI.TimeLord.add(p.getName());
					p.sendMessage(API.sev + "Voce pegou o Kit§a§l TimeLord");
					API.setitem(p, Material.WATCH, "§7- §c§lKit §7- " + p.getName(), 1, Enchantment.ARROW_DAMAGE, 0,false);
				} else {
					p.sendMessage(API.s);
				}
			}
			if (args[0].equalsIgnoreCase("Vaccum")) {
				if (p.hasPermission("kit.Vaccum")) {
					p.getInventory().clear();
					KitAPI.GiveKit(p);
					Habilidade.setAbility(p, "Vaccum");
					KitAPI.Kit.add(p.getName());
					KitAPI.Vaccum.add(p.getName());
					p.sendMessage(API.sev + "Voce pegou o Kit§a§l Vaccum");
					API.setitem(p, Material.EYE_OF_ENDER, "§7- §c§lKit §7- " + p.getName(), 1, Enchantment.ARROW_DAMAGE, 0,false);
				} else {
					p.sendMessage(API.s);
				}
			}
			if (args[0].equalsIgnoreCase("Teleman")) {
				if (p.hasPermission("kit.Teleman")) {
					p.getInventory().clear();
					KitAPI.GiveKit(p);
					Habilidade.setAbility(p, "Teleman");
					KitAPI.Kit.add(p.getName());
					KitAPI.Teleman.add(p.getName());
					p.sendMessage(API.sev + "Voce pegou o Kit§a§l Teleman");
					API.setitem(p, Material.FIREBALL, "§7- §c§lKit §7- " + p.getName(), 1, Enchantment.ARROW_DAMAGE, 0,false);
				} else {
					p.sendMessage(API.s);
				}
			}
			if (args[0].equalsIgnoreCase("Thresh")) {
				if (p.hasPermission("kit.Thresh")) {
					p.getInventory().clear();
					KitAPI.GiveKit(p);
					Habilidade.setAbility(p, "Thresh");
					KitAPI.Kit.add(p.getName());
					KitAPI.Thresh.add(p.getName());
					p.sendMessage(API.sev + "Voce pegou o Kit§a§l Thresh");
					API.setitem(p, Material.LEASH, "§7- §c§lKit §7- " + p.getName(), 1, Enchantment.ARROW_DAMAGE, 0,false);
				} else {
					p.sendMessage(API.s);
				}
			}
		}
		return false;
	}
}