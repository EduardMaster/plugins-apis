package me.recenthg.stark.Comandos;


import java.util.ArrayList;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.recent.stark.Main;
import me.recenthg.stark.Inv.InvKit;
import me.recenthg.stark.Manager.Habilidade;
import me.recenthg.stark.Manager.Title;

public class SelecionarKit2 implements Listener, CommandExecutor {
	public static ArrayList<String> CopyCat2 = new ArrayList<String>();
	

	public static void onKitChest(Player p) {
		if (Main.PreGame)
			InvKit.InventarioKitsGui(p);
		else;
			
		}


	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§8\u276e§2§l!§8\u276f §7Comandos apenas no servidor!");
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("kit")) {
			if (args.length == 0) {
				onKitChest(p);
				return true;
			}
			if ((p.hasPermission("HungerGames.Kit.Kangaroo")) && (args[0].equalsIgnoreCase("kangaroo"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aKangaroo");
				Title.sendTitle(p, "§c§lKangaroo!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Kangaroo");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Crafter")) && (args[0].equalsIgnoreCase("crafter"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aCrafter");
				Title.sendTitle(p, "§c§lCrafter!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Crafter");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.CheckPoint")) && (args[0].equalsIgnoreCase("checkpoint"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aCheckPoint");
				Title.sendTitle(p, "§c§lCheackPoint!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "CheckPoint");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Batman")) && (args[0].equalsIgnoreCase("Batman"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aBatman");
				Title.sendTitle(p, "§c§lBatman!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Batman");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Wither")) && (args[0].equalsIgnoreCase("wither"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aWither");
				Title.sendTitle(p, "§c§lWither!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Wither");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Phantom")) && (args[0].equalsIgnoreCase("phantom"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aPhantom");
				Title.sendTitle(p, "§c§lPhantom!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Phantom");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Wither")) && (args[0].equalsIgnoreCase("Wither"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aWither");
				Title.sendTitle(p, "§c§lWither!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Wither");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Gravedigger")) && (args[0].equalsIgnoreCase("gravedigger"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aGravedigger");
				Title.sendTitle(p, "§c§lGravedigger!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Gravedigger");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Vulcanos")) && (args[0].equalsIgnoreCase("Vulcanos"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aVulcanos");
				Title.sendTitle(p, "§c§lVulcanos!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Vulcanos");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Rider")) && (args[0].equalsIgnoreCase("Rider"))) {
				p.sendMessage("§aVoce selecionou o Kit Rider");
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Rider");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Rider")) && (args[0].equalsIgnoreCase("Rider"))) {
				p.sendMessage("§aVoce selecionou o Kit Rider");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Rider");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.HotPotato")) && (args[0].equalsIgnoreCase("hotpotato"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aHotPotato");
				Title.sendTitle(p, "§c§lHotPotato!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "HotPotato");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.BixoPapao")) && (args[0].equalsIgnoreCase("bixopapao"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aBixoPapao");
				Title.sendTitle(p, "§c§lBixoPapao!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "BixoPapao");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Launcher")) && (args[0].equalsIgnoreCase("launcher"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aLauncher");
				Title.sendTitle(p, "§c§lLauncher!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Launcher");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Well")) && (args[0].equalsIgnoreCase("Well"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aWell");
				Title.sendTitle(p, "§c§lWell!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Well");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Madman")) && (args[0].equalsIgnoreCase("madman"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aMadman");
				Title.sendTitle(p, "§c§lMadman!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Madman");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Rush")) && (args[0].equalsIgnoreCase("rush"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aRush");
				Title.sendTitle(p, "§c§lRush!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Rush");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Grandpa")) && (args[0].equalsIgnoreCase("grandpa"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aGrandpa");
				Title.sendTitle(p, "§c§lGrandpa!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Grandpa");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Copycat")) && (args[0].equalsIgnoreCase("Copycat"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aCopyCat");
				Title.sendTitle(p, "§c§lCopycat!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "CopyCat");
				CopyCat2.add(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Pyro")) && (args[0].equalsIgnoreCase("Pyro"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aPyro");
				Title.sendTitle(p, "§c§lPyro!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Pyro");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Surprise")) && (args[0].equalsIgnoreCase("Surprise"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aSurprise");
				Title.sendTitle(p, "§c§lSurprise!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Surprise");
				CopyCat2.remove(p.getName());
			}
		
			if ((p.hasPermission("HungerGames.Kit.Cultivator")) && (args[0].equalsIgnoreCase("cultivator"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aCultivator");
				Title.sendTitle(p, "§c§lCultivator!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Cultivator");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Anchor")) && (args[0].equalsIgnoreCase("anchor"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aAnchor");
				Title.sendTitle(p, "§c§lAnchor!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Anchor");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Durability")) && (args[0].equalsIgnoreCase("durability"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aDurability");
				Title.sendTitle(p, "§c§lDurability!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Durability");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Hulk")) && (args[0].equalsIgnoreCase("hulk"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aHulk");
				Title.sendTitle(p, "§c§lHulk!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Hulk");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Demoman")) && (args[0].equalsIgnoreCase("Demoman"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aDemoman");
				Title.sendTitle(p, "§c§lDemoman!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Demoman");
				CopyCat2.remove(p.getName());
			}
	
			if ((p.hasPermission("HungerGames.Kit.Wolff")) && (args[0].equalsIgnoreCase("wolff"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aWolff");
				Title.sendTitle(p, "§c§lWolff!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Wolff");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Endermage")) && (args[0].equalsIgnoreCase("endermage"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aEndermage");
				Title.sendTitle(p, "§c§lEndermage!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Endermage");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Tower")) && (args[0].equalsIgnoreCase("tower"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aTower");
				Title.sendTitle(p, "§c§lTower!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Tower");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Blink")) && (args[0].equalsIgnoreCase("blink"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aBlink");
				Title.sendTitle(p, "§c§lBlink!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Blink");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Firer")) && (args[0].equalsIgnoreCase("firer"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aFirer");
				Title.sendTitle(p, "§c§lFirer!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Firer");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Camel")) && (args[0].equalsIgnoreCase("camel"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aCamel");
				Title.sendTitle(p, "§c§lCamel!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Camel");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Aladdin")) && (args[0].equalsIgnoreCase("aladdin"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aAladdin");
				Title.sendTitle(p, "§c§lAladdin!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Aladdin");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Boxer")) && (args[0].equalsIgnoreCase("boxer"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aBoxer");
				Title.sendTitle(p, "§c§lBoxer!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Boxer");
				CopyCat2.remove(p.getName());
			}
		
			if ((p.hasPermission("HungerGames.Kit.IronMan")) && (args[0].equalsIgnoreCase("ironman"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aIronMan");
				Title.sendTitle(p, "§c§lIronMan!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "IronMan");
				CopyCat2.remove(p.getName());
			}

			if ((p.hasPermission("HungerGames.Kit.Fisherman")) && (args[0].equalsIgnoreCase("Fisherman"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aFisherman");
				Title.sendTitle(p, "§c§lFisherman!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Fisherman");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Forger")) && (args[0].equalsIgnoreCase("forger"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aForger");
				Title.sendTitle(p, "§c§lForger!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Forger");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Gladiator")) && (args[0].equalsIgnoreCase("gladiator"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aGladiator");
				Title.sendTitle(p, "§c§lGladiator!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Gladiator");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Grappler")) && (args[0].equalsIgnoreCase("grappler"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aGrappler");
				Title.sendTitle(p, "§c§lGrappler!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Grappler");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Velotrol")) && (args[0].equalsIgnoreCase("Velotrol"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aVelotrol");
				Title.sendTitle(p, "§c§lVelotrol!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Velotrol");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Jellyfish")) && (args[0].equalsIgnoreCase("jellyfish"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aJellyfish");
				Title.sendTitle(p, "§c§lJellyfish!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Jellyfish");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Lumberjack")) && (args[0].equalsIgnoreCase("lumberjack"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aLumberjack");
				Title.sendTitle(p, "§c§lLumberjack!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Lumberjack");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Miner")) && (args[0].equalsIgnoreCase("miner"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aMiner");
				Title.sendTitle(p, "§c§lMiner!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Miner");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Monk")) && (args[0].equalsIgnoreCase("monk"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aMonk");
				Title.sendTitle(p, "§c§lMonk!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Monk");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Fireman")) && (args[0].equalsIgnoreCase("fireman"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aFireman");
				Title.sendTitle(p, "§c§lFireman!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Fireman");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Viking")) && (args[0].equalsIgnoreCase("viking"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aViking");
				Title.sendTitle(p, "§c§lViking!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Viking");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Ninja")) && (args[0].equalsIgnoreCase("ninja"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aNinja");
				Title.sendTitle(p, "§c§lNinj!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Ninja");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Poseidon")) && (args[0].equalsIgnoreCase("poseidon"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aPoseidon");
				Title.sendTitle(p, "§c§lPoseidon!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Poseidon");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Reaper")) && (args[0].equalsIgnoreCase("reaper"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aReaper");
				Title.sendTitle(p, "§c§lReaper!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Reaper");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Snail")) && (args[0].equalsIgnoreCase("snail"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aSnail");
				Title.sendTitle(p, "§c§lSnail!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Snail");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Specialist")) && (args[0].equalsIgnoreCase("specialist"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aSpecialist");
				Title.sendTitle(p, "§c§lSpecialist!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Specialist");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Stomper")) && (args[0].equalsIgnoreCase("stomper"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aStomper");
				Title.sendTitle(p, "§c§lStomper!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Stomper");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Switcher")) && (args[0].equalsIgnoreCase("Switcher"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aSwitcher");
				Title.sendTitle(p, "§c§lSwitcher!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Switcher");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Tank")) && (args[0].equalsIgnoreCase("tank"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aTank");
				Title.sendTitle(p, "§c§lTank!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Tank");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Thor")) && (args[0].equalsIgnoreCase("thor"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aThor");
				Title.sendTitle(p, "§c§lThor!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Thor");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Timelord")) && (args[0].equalsIgnoreCase("timelord"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aTimelord");
				Title.sendTitle(p, "§c§lTimelord!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Timelord");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Turtle")) && (args[0].equalsIgnoreCase("turtle"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aTurtle");
				Title.sendTitle(p, "§c§lTurtle!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Turtle");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Viper")) && (args[0].equalsIgnoreCase("Viper"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aViper");
				Title.sendTitle(p, "§c§lViper!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Viper");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Worm")) && (args[0].equalsIgnoreCase("worm"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aWorm");
				Title.sendTitle(p, "§c§lWorm!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Worm");
				CopyCat2.remove(p.getName());
			}
			if ((p.hasPermission("HungerGames.Kit.Waterman")) && (args[0].equalsIgnoreCase("waterman"))) {
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aWaterman");
				Title.sendTitle(p, "§c§lWaterman!");
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Waterman");
				CopyCat2.remove(p.getName());
			}
		}
	
		if ((p.hasPermission("HungerGames.Kit.Urgal")) && (args[0].equalsIgnoreCase("Urgal"))) {
			p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aUrgal");
			Title.sendTitle(p, "§c§lUrgal!");
			p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
			Habilidade.removeAbility(p);
			Habilidade.setAbility(p, "Urgal");
			CopyCat2.remove(p.getName());
		}
		if ((p.hasPermission("HungerGames.Kit.Sonic")) && (args[0].equalsIgnoreCase("Sonic"))) {
			p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aSonic");
			Title.sendTitle(p, "§c§lSonic!");
			p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
			Habilidade.removeAbility(p);
			Habilidade.setAbility(p, "Sonic");
			CopyCat2.remove(p.getName());
		}
		if ((p.hasPermission("HungerGames.Kit.Barbarian")) && (args[0].equalsIgnoreCase("Barbarian"))) {
			p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aBarbarian");
			Title.sendTitle(p, "§c§lBarbarian!");
			p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
			Habilidade.removeAbility(p);
			Habilidade.setAbility(p, "Barbarian");
			CopyCat2.remove(p.getName());
		}
		if ((p.hasPermission("HungerGames.Kit.Deshfire")) && (args[0].equalsIgnoreCase("deshfire"))) {
			p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aDeshfire");
			Title.sendTitle(p, "§c§lDeshfire!");
			p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
			Habilidade.removeAbility(p);
			Habilidade.setAbility(p, "Deshfire");
			CopyCat2.remove(p.getName());
		}
		if ((p.hasPermission("HungerGames.Kit.Achilles")) && (args[0].equalsIgnoreCase("Achilles"))) {
			p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aAchilles");
			Title.sendTitle(p, "§c§lAchilles!");
			p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
			Habilidade.removeAbility(p);
			Habilidade.setAbility(p, "Achilles");
			CopyCat2.remove(p.getName());
		}
		if ((p.hasPermission("HungerGames.Kit.BloodGun")) && (args[0].equalsIgnoreCase("BloodGun"))) {
			p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aBloodGun");
			Title.sendTitle(p, "§c§lBloodGun!");
			p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
			Habilidade.removeAbility(p);
			Habilidade.setAbility(p, "BloodGun");
			CopyCat2.remove(p.getName());
		}
		if ((p.hasPermission("HungerGames.Kit.Sniper")) && (args[0].equalsIgnoreCase("Sniper"))) {
			p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aSniper");
			Title.sendTitle(p, "§c§lSniper!");
			p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
			Habilidade.removeAbility(p);
			Habilidade.setAbility(p, "Sniper");
			CopyCat2.remove(p.getName());
		}
		if ((p.hasPermission("HungerGames.Kit.BurstMaster")) && (args[0].equalsIgnoreCase("BurstMaster"))) {
			p.sendMessage("§8\u276e§2§l!§8\u276f §7Você Pegou O Kit §aBurstMaster");
			Title.sendTitle(p, "§c§lBurstMaster!");
			p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0F, 1.0F);
			Habilidade.removeAbility(p);
			Habilidade.setAbility(p, "BurstMaster");
			CopyCat2.remove(p.getName());
		}
	
		return true;
	}
}