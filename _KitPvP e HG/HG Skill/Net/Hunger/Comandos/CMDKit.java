package Net.Hunger.Comandos;

import java.util.ArrayList;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Net.Hunger.Main;
import Net.Hunger.Inv.InvKit;
import Net.Hunger.Manager.Habilidade;

public class CMDKit implements Listener, CommandExecutor {
 
  public static void onKitChest(Player p) {
  if(Main.PreGame) {
  InvKit.InventarioKitsGui(p);
  } else {
  return;
  }
  }

  public static ArrayList<String> CopyCat = new ArrayList<String>();
  
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
   if (!(sender instanceof Player)) {
     sender.sendMessage("§7[§a!§7] §aComandos apenas no servidor!");
     return true;
    }
    Player p = (Player)sender;
    if ((cmd.getName().equalsIgnoreCase("kit"))) {
     if((args.length == 0)) {
      onKitChest(p);
      return true;
      }
      if ((p.hasPermission("HungerGames.Kit.Kangaroo")) && (args[0].equalsIgnoreCase("kangaroo"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aKangaroo");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Kangaroo");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Crafter")) && (args[0].equalsIgnoreCase("crafter"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aCrafter");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Crafter");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Launcher")) && (args[0].equalsIgnoreCase("launcher"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aLauncher");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Launcher");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Well")) && (args[0].equalsIgnoreCase("Well"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aWell");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Well");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Swords")) && (args[0].equalsIgnoreCase("swords"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aSwords");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Swords");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Madman")) && (args[0].equalsIgnoreCase("madman"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aMadman");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Madman");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Rush")) && (args[0].equalsIgnoreCase("rush"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aRush");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Rush");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.BigJump")) && (args[0].equalsIgnoreCase("bigjump"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aBigJump");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "BigJump");
      }
      if ((p.hasPermission("HungerGames.Kit.Enderman")) && (args[0].equalsIgnoreCase("enderman"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aEnderman");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Enderman");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Grandpa")) && (args[0].equalsIgnoreCase("grandpa"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aGrandpa");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Grandpa");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Copycat")) && (args[0].equalsIgnoreCase("Copycat"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aCopyCat");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "CopyCat");
      CopyCat.add(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Backpacker")) && (args[0].equalsIgnoreCase("Backpacker"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aBackPacker");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "BackPacker");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Surprise")) && (args[0].equalsIgnoreCase("Surprise"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aSurprise");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Surprise");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Cultivator")) && (args[0].equalsIgnoreCase("cultivator"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aCultivator");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Cultivator");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Anchor")) && (args[0].equalsIgnoreCase("anchor"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aAnchor");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Anchor");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Durability")) && (args[0].equalsIgnoreCase("durability"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aDurability");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Durability");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Hulk")) && (args[0].equalsIgnoreCase("hulk"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aHulk");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Hulk");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Demoman")) && (args[0].equalsIgnoreCase("Demoman"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aDemoman");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Demoman");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Dwarf")) && (args[0].equalsIgnoreCase("dwarf"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aDwarf");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Dwarf");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Wolff")) && (args[0].equalsIgnoreCase("wolff"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aWolff");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Wolff");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Endermage")) && (args[0].equalsIgnoreCase("endermage"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aEndermage");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Endermage");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Tower")) && (args[0].equalsIgnoreCase("tower"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aTower");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Tower");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Firer")) && (args[0].equalsIgnoreCase("firer"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aFirer");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Firer");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Cacto")) && (args[0].equalsIgnoreCase("cacto"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aCacto");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Cacto");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Fisherman")) && (args[0].equalsIgnoreCase("Fisherman"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aFisherman");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Fisherman");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Forger")) && (args[0].equalsIgnoreCase("forger"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aForger");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Forger");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Gladiator")) && (args[0].equalsIgnoreCase("gladiator"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aGladiator");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Gladiator");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Grappler")) && (args[0].equalsIgnoreCase("grappler"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aGrappler");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Grappler");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Jellyfish")) && (args[0].equalsIgnoreCase("jellyfish"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aJellyfish");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Jellyfish");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Lumberjack")) && (args[0].equalsIgnoreCase("lumberjack"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aLumberjack");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Lumberjack");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Miner")) && (args[0].equalsIgnoreCase("miner"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aMiner");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Miner");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Monk")) && (args[0].equalsIgnoreCase("monk"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aMonk");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Monk");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Fireman")) && (args[0].equalsIgnoreCase("fireman"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aFireman");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Fireman");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Viking")) && (args[0].equalsIgnoreCase("viking"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aViking");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Viking");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Ninja")) && (args[0].equalsIgnoreCase("ninja"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aNinja");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Ninja");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Poseidon")) && (args[0].equalsIgnoreCase("poseidon"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aPoseidon");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Poseidon");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Reaper")) && (args[0].equalsIgnoreCase("reaper"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aReaper");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Reaper");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Snail")) && (args[0].equalsIgnoreCase("snail"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aSnail");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Snail");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Specialist")) && (args[0].equalsIgnoreCase("specialist"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aSpecialist");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Specialist");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Stomper")) && (args[0].equalsIgnoreCase("stomper"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aStomper");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Stomper");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Switcher")) && (args[0].equalsIgnoreCase("Switcher"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aSwitcher");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Switcher");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Tank")) && (args[0].equalsIgnoreCase("tank"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aTank");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Tank");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Thor")) && (args[0].equalsIgnoreCase("thor"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aThor");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Thor");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Timelord")) && (args[0].equalsIgnoreCase("timelord"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aTimelord");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Timelord");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Turtle")) && (args[0].equalsIgnoreCase("turtle"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aTurtle");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Turtle");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Viper")) && (args[0].equalsIgnoreCase("Viper"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aViper");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Viper");
      CopyCat.remove(p.getName());
      }
      if ((p.hasPermission("HungerGames.Kit.Worm")) && (args[0].equalsIgnoreCase("worm"))) {
      p.sendMessage("§7[§a!§7] §7Você pegou o kit §aWorm");
      p.sendMessage("§7[§a!§7] §7Use §a/Kits §7para ver a lista de todos kits.");
	  p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      Habilidade.removeAbility(p);
      Habilidade.setAbility(p, "Worm");
      CopyCat.remove(p.getName());
      }
     }
	return true;  
   }
  }