package Zey.PvP.Commands;

import org.bukkit.event.*;

import Zey.PvP.APIs.TheTitle;
import Zey.PvP.APIs.WarpAPI;
import Zey.PvP.Essencial.*;
import Zey.PvP.Eventos.*;
import Zey.PvP.Main.*;
import Zey.PvP.Utils.Proteção;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.enchantments.*;

public class KitCommand implements CommandExecutor, Listener
{
    public KitCommand(final Main main) {
    }
    
    @SuppressWarnings("deprecation")
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("kit")) {
            if (args.length == 0) {
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §cErrado, utilize a sintaxe correta: /kit (kit)");
                return true;
            }
            
            if(Zey.PvP.APIs.WarpAPI.getWarp(p) == "Nenhuma") {
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §cNo momento, você está no /admin. Para pegar um kit, volte ao spawn usando o comando: /spawn");
            	return true;
            }
            if(Zey.PvP.APIs.WarpAPI.getWarp(p) == "Arena") {
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §cVocê já está utilizando um Kit. Para pegar outro, volte ao spawn usando o comando: /spawn");
            	return true;
            }
            if(Zey.PvP.APIs.WarpAPI.getWarp(p) == "Evento") {
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §cVocê está em uma Warp. Para utilizar um Kit, volte ao spawn usando o comando: /spawn");
            	return true;
            }
            if(Zey.PvP.APIs.WarpAPI.getWarp(p) == "Fps") {
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §cVocê está em uma Warp. Para utilizar um Kit, volte ao spawn usando o comando: /spawn");
            	return true;
            }
            if(Zey.PvP.APIs.WarpAPI.getWarp(p) == "Challenge") {
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §cVocê está em uma Warp. Para utilizar um Kit, volte ao spawn usando o comando: /spawn");
            	return true;
            }
            if(Zey.PvP.APIs.WarpAPI.getWarp(p) == "Parkour") {
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §cVocê está em uma Warp. Para utilizar um Kit, volte ao spawn usando o comando: /spawn");
            	return true;
            }
            if(Zey.PvP.APIs.WarpAPI.getWarp(p) == "Main") {
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §cVocê está em uma Warp. Para utilizar um Kit, volte ao spawn usando o comando: /spawn");
            	return true;
            }
        }
        
    	if (p.hasPermission("zey.pvp.admin") &&  	
				Zey.PvP.APIs.WarpAPI.getWarp(p) == "Nenhuma") {
			Main.admins.remove(p.getName());
			p.sendMessage(String.valueOf(Main.prefix) + " §7» Você saiu do modo §c§lADMIN");
			
			for (Player players : Bukkit.getOnlinePlayers()) {
				players.showPlayer(p);
			}
    	}
        
		Proteção.setImortal(p, false);
		Proteção.isImortal(p);
		
        if (args[0].equalsIgnoreCase("pvp")) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.swordkitpvp(p);
                Habilidade.setAbility(p, "PvP");
                KitAPI.Kit.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lPVP");
                TheTitle.sendTitle(p, "§e§lPVP");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        if (args[0].equalsIgnoreCase("ajnin")) {
            if (p.hasPermission("kit.ajnin") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Ajnin");
                KitAPI.Kit.add(p.getName());
                KitAPI.Ajnin.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lAJNIN");
                TheTitle.sendTitle(p, "§e§lAJNIN");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("camel")) {
            if (p.hasPermission("kit.camel") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Camel");
                KitAPI.Kit.add(p.getName());
                KitAPI.Camel.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lCamel");
                TheTitle.sendTitle(p, "§e§lCAMEL");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("anchor")) {
            if (p.hasPermission("kit.anchor") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Anchor");
                KitAPI.Kit.add(p.getName());
                KitAPI.Anchor.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lANCHOR");
                TheTitle.sendTitle(p, "§e§lANCHOR");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("armor")) {
            if (p.hasPermission("kit.armor") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Armor");
                KitAPI.Kit.add(p.getName());
                KitAPI.Armor.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lARMOR");
                KitAPI.setitem(p, Material.GOLD_INGOT, "§e§lARMOR", 1, Enchantment.DAMAGE_ALL, 0, false);
                TheTitle.sendTitle(p, "§e§lARMOR");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("rain")) {
            if (p.hasPermission("kit.rain") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Rain");
                KitAPI.Kit.add(p.getName());
                KitAPI.Rain.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lRAIN");
                KitAPI.setitem(p, Material.ARROW, "§e§lRAIN", 1, Enchantment.DAMAGE_ALL, 0, false);
                TheTitle.sendTitle(p, "§e§lRAIN");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("timelord")) {
            if (p.hasPermission("kit.timelord") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "TimeLord");
                KitAPI.Kit.add(p.getName());
                KitAPI.TimeLord.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lTIMELORD");
                KitAPI.setitem(p, Material.WATCH, "§e§lTIMELORD", 1, Enchantment.DAMAGE_ALL, 0, false);
                TheTitle.sendTitle(p, "§e§lTIMELORD");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("confuser")) {
            if (p.hasPermission("kit.confuser") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Confuser");
                KitAPI.Kit.add(p.getName());
                KitAPI.Confuser.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lCONFUSER");
                KitAPI.setitem(p, Material.COAL, "§e§lCONFUSER", 1, Enchantment.DAMAGE_ALL, 0, false);
                TheTitle.sendTitle(p, "§e§lCONFUSER");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("avatar")) {
            if (p.hasPermission("kit.avatar") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Avatar");
                KitAPI.Kit.add(p.getName());
                KitAPI.Avatar.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lAVATAR");
                KitAPI.setitem(p, Material.BEACON, "§e§lAVATAR", 1, Enchantment.DAMAGE_ALL, 0, false);
                TheTitle.sendTitle(p, "§e§lAVATAR");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("C4")) {
            if (p.hasPermission("kit.C4") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "C4");
                KitAPI.Kit.add(p.getName());
                KitAPI.C4.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lC4");
                KitAPI.setitem(p, Material.SLIME_BALL, "§e§lC4", 1, Enchantment.DAMAGE_ALL, 0, false);
                TheTitle.sendTitle(p, "§e§lC4");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("DeshFire")) {
            if (p.hasPermission("kit.deshfire") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "DeshFire");
                KitAPI.Kit.add(p.getName());
                KitAPI.DeshFire.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lDESHFIRE");
                KitAPI.setitem(p, Material.REDSTONE_BLOCK, "§e§lDESHFIRE", 1, Enchantment.DAMAGE_ALL, 0, false);
                TheTitle.sendTitle(p, "§e§lDESHFIRE");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("fisherman")) {
            if (p.hasPermission("kit.fisherman") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Fisherman");
                KitAPI.Kit.add(p.getName());
                KitAPI.Fisherman.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lFISHERMAN");
                KitAPI.setitem(p, Material.FISHING_ROD, "§e§lFISHERMAN", 1, Enchantment.DAMAGE_ALL, 0, false);
                TheTitle.sendTitle(p, "§e§lFISHERMAN");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("gladiator")) {
            if (p.hasPermission("kit.gladiator") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Gladiator");
                KitAPI.Kit.add(p.getName());
                KitAPI.Gladiator.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lGLADIATOR");
                KitAPI.setitem(p, Material.IRON_FENCE, "§e§lGLADIATOR", 1, Enchantment.DAMAGE_ALL, 0, false);
                TheTitle.sendTitle(p, "§e§lGLADIATOR");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("grappler")) {
            if (p.hasPermission("kit.grappler") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Grappler");
                KitAPI.Kit.add(p.getName());
                KitAPI.Grappler.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lGRAPPLER");
                KitAPI.setitem(p, Material.LEASH, "§e§lGRAPPLER", 1, Enchantment.DAMAGE_ALL, 0, false);
                TheTitle.sendTitle(p, "§e§lGRAPPLER");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("hulk")) {
            if (p.hasPermission("kit.hulk") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Hulk");
                KitAPI.Kit.add(p.getName());
                KitAPI.Hulk.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lHULK");
                KitAPI.setitem(p, Material.SADDLE, "§e§lHULK", 1, Enchantment.DAMAGE_ALL, 0, false);
                TheTitle.sendTitle(p, "§e§lHULK");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("jellyfish")) {
            if (p.hasPermission("kit.jellyfish") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "JellyFish");
                KitAPI.Kit.add(p.getName());
                KitAPI.JellyFish.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lJELLYFISH");
                KitAPI.setitem(p, Material.CLAY_BALL, "§e§lJELLYFISH", 1, Enchantment.DAMAGE_ALL, 0, false);
                TheTitle.sendTitle(p, "§e§lJELLYFISH");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("quickdropper")) {
            if (p.hasPermission("kit.quickdropper") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "QuickDropper");
                KitAPI.Kit.add(p.getName());
                KitAPI.QuickDropper.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lQUICKDROPPER");
                TheTitle.sendTitle(p, "§e§lQUICKDROPPER");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("kangaroo")) {
            if (p.hasPermission("kit.kangaroo") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Kangaroo");
                KitAPI.Kit.add(p.getName());
                KitAPI.Kangaroo.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lKANGAROO");
                KitUtil.darItem(p, Material.FIREWORK, 1, "§e§lKANGAROO", 1);
                TheTitle.sendTitle(p, "§e§lKANGAROO");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("magma")) {
            if (p.hasPermission("kit.magma") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Magma");
                KitAPI.Kit.add(p.getName());
                KitAPI.Magma.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lMAGMA");
                TheTitle.sendTitle(p, "§e§lMAGMA");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("monk")) {
            if (p.hasPermission("kit.monk") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Monk");
                KitAPI.Kit.add(p.getName());
                KitAPI.Monk.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lMONK");
                KitAPI.setitem(p, Material.BLAZE_ROD, "§e§lMONK", 1, Enchantment.DAMAGE_ALL, 0, false);
                TheTitle.sendTitle(p, "§e§lMONK");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("ninja")) {
            if (p.hasPermission("kit.ninja") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Ninja");
                KitAPI.Kit.add(p.getName());
                KitAPI.Ninja.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lNINJA");
                TheTitle.sendTitle(p, "§e§lNINJA");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("poseidon")) {
            if (p.hasPermission("kit.poseidon") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Poseidon");
                KitAPI.Kit.add(p.getName());
                KitAPI.Poseidon.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lPOSEIDON");
                TheTitle.sendTitle(p, "§e§lPOSEIDON");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("resouper")) {
            if (p.hasPermission("kit.resouper") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Resouper");
                KitAPI.Kit.add(p.getName());
                KitAPI.Resouper.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lRESOUPER");
                TheTitle.sendTitle(p, "§e§lRESOUPER");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("snail")) {
            if (p.hasPermission("kit.snail") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Snail");
                KitAPI.Kit.add(p.getName());
                KitAPI.Snail.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lSNAIL");
                TheTitle.sendTitle(p, "§e§lSNAIL");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("sonic")) {
            if (p.hasPermission("kit.sonic") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Sonic");
                KitAPI.Kit.add(p.getName());
                KitAPI.Sonic.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lSONIC");
                KitAPI.setitem(p, Material.LAPIS_BLOCK, "§e§lSONIC", 1, Enchantment.DAMAGE_ALL, 0, false);
                TheTitle.sendTitle(p, "§e§lSONIC");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("archer")) {
            if (p.hasPermission("kit.archer") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Archer");
                KitAPI.Kit.add(p.getName());
                KitAPI.Archer.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lArcher");
                KitAPI.setitem(p, Material.BOW, "§e§lARCHER", 1, Enchantment.ARROW_INFINITE, 1, false);
                KitAPI.setitem(p, Material.ARROW, "§cFLECHA", 2, Enchantment.DAMAGE_ALL, 1, false);
                TheTitle.sendTitle(p, "§e§lARCHER");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("stomper")) {
            if (p.hasPermission("kit.stomper") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Stomper");
                KitAPI.Kit.add(p.getName());
                KitAPI.Stomper.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lSTOMPER");
                TheTitle.sendTitle(p, "§e§lSTOMPER");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("switcher")) {
            if (p.hasPermission("kit.switcher") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Switcher");
                KitAPI.Kit.add(p.getName());
                KitAPI.Switcher.add(p.getName());
                KitUtil.darItem(p, Material.SNOW_BALL, 64, "§e§lSWITCHER", 1);
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lSWITCHER");
                TheTitle.sendTitle(p, "§e§lSWITCHER");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("swords")) {
            if (p.hasPermission("kit.swords") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Swords");
                KitAPI.Kit.add(p.getName());
                KitAPI.Swords.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lSWORDS");
                TheTitle.sendTitle(p, "§e§lSWORDS");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("forcefield")) {
            if (p.hasPermission("kit.forcefield") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "ForceField");
                KitAPI.Kit.add(p.getName());
                KitAPI.ForceField.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lFORCEFIELD");
                KitAPI.setitem(p, Material.NETHER_FENCE, "§e§lFORCEFIELD", 1, Enchantment.DAMAGE_ALL, 0, false);
                TheTitle.sendTitle(p, "§e§lFORCEFIELD");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("thor")) {
            if (p.hasPermission("kit.thor") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Thor");
                KitAPI.Kit.add(p.getName());
                KitAPI.Thor.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lTHOR");
                KitAPI.setitem(p, Material.GOLD_AXE, "§e§lTHOR", 1, Enchantment.DAMAGE_ALL, 0, false);
                TheTitle.sendTitle(p, "§e§lTHOR");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("thresh")) {
            if (p.hasPermission("kit.thresh") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Thresh");
                KitAPI.Kit.add(p.getName());
                KitAPI.Thresh.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lTHRESH");
                KitAPI.setitem(p, Material.LEVER, "§e§lTHRESH", 1, Enchantment.DAMAGE_ALL, 0, false);
                TheTitle.sendTitle(p, "§e§lTHRESH");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("turtle")) {
            if (p.hasPermission("kit.turtle") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Turtle");
                KitAPI.Kit.add(p.getName());
                KitAPI.Turtle.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lTURTLE");
                TheTitle.sendTitle(p, "§e§lTURTLE");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("viper")) {
            if (p.hasPermission("kit.viper") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Viper");
                KitAPI.Kit.add(p.getName());
                KitAPI.Viper.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lVIPER");
                TheTitle.sendTitle(p, "§e§lVIPER");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("viking")) {
            if (p.hasPermission("kit.Viking") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitUtil.darItem(p, Material.STONE_AXE, 1, "§e§lVIKING", 0);
                Habilidade.setAbility(p, "Viking");
                KitAPI.Kit.add(p.getName());
                KitAPI.Viking.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lVIKING");
                TheTitle.sendTitle(p, "§e§lVIKING");
                SetArenaCommand.TeleportArenaRandom(p);
                WarpAPI.setWarp(p, "Arena");
            }
        }
        if (args[0].equalsIgnoreCase("madman")) {
            if (p.hasPermission("kit.madman") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Madman");
                KitAPI.Kit.add(p.getName());
                KitAPI.AntiTower.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lMADMAN");
                TheTitle.sendTitle(p, "§e§lMADMAN");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("specialist")) {
            if (p.hasPermission("kit.specialist") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "Specialist");
                KitUtil.darItem(p, Material.ENCHANTED_BOOK, 1, "§e§lSPECIALIST", 1);
                KitAPI.Kit.add(p.getName());
                KitAPI.Specialist.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lSPECIALIST");
                TheTitle.sendTitle(p, "§e§lSPECIALIST");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("hotpotato")) {
            if (p.hasPermission("kit.hotpotato") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "HotPotato");
                KitUtil.darItem(p, Material.POTATO, 1, "§e§lHOTPOTATO", 1);
                KitAPI.Kit.add(p.getName());
                KitAPI.Specialist.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lHOTPOTATO");
                TheTitle.sendTitle(p, "§e§lHOTPOTATO");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        if (args[0].equalsIgnoreCase("AntiTower")) {
            if (p.hasPermission("kit.antitower") || IniciarCommand.fullkit) {
                p.getInventory().clear();
                KitAPI.recraft(p);
                KitAPI.sopa(p);
                KitAPI.sword(p);
                Habilidade.setAbility(p, "AntiTower");
                KitAPI.Kit.add(p.getName());
                KitAPI.AntiTower.add(p.getName());
                p.sendMessage(String.valueOf(Main.prefix) + " §7» §7Você selecionou o Kit: §a§lAntiTower");
                TheTitle.sendTitle(p, "§e§lANTI-TOWER");
                SetArenaCommand.TeleportArenaRandom(p);
            }
        }
        return false;
    }
}
