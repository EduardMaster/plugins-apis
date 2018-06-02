package Net.Hunger.Comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDKits implements CommandExecutor {
	
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
	if(!(sender instanceof Player)) {
	sender.sendMessage("§7[§a!§7] §aComandos apenas no servidor!");
	return true;
	}
    Player player = (Player)sender;
    if(cmd.getName().equalsIgnoreCase("kits")) {
      StringBuilder free = new StringBuilder();
      StringBuilder other = new StringBuilder();
      String[] Kits = { "Tower", "Crafter", "Cultivator", "Demoman", "Dwarf", "Endermage", "Firer", "Fisherman", "Forger", 
      "Madman", "Gladiator", "Grappler", "Hulk", "Wolff", "Enderman", "Jellyfish", "Kangaroo", "Lumberjack","Miner", "Monk",
      "Ninja", "Poseidon", "Reaper", "Snail", "Specialist", "Stomper","Switcher", "Tank", "Fireman", "Thor", "Grandpa", "Surprise",
      "BigJump", "Rush", "CopyCat", "Well", "Swords", "Launcher", "Cacto", "Anchor", "Timelord", "Durability", "Turtle", "Viper", "Worm"};
      for (String kit : Kits) {
      if (player.hasPermission("HungerGames.Kit." + kit.toLowerCase())) {
      free.append(ChatColor.WHITE + kit + ChatColor.GREEN + ", ");
      } else {
      other.append(ChatColor.WHITE + kit + ChatColor.RED + ", ");
      }
      }
      if (free.length() == 0) {
      player.sendMessage("§7[§a?§7] " + "§7Seus Kits: §a" + "Voce nao tem nenhum kit!");
      } else {
      player.sendMessage("§7[§a!§7] " + "§7Seus Kits: §f" + free.toString());
      }
      if (other.length() == 0) {
      player.sendMessage("§7[§a!§7] " + "§7Outros Kits : §a" + "Você possue todos kits!");
      } else {
      player.sendMessage("§7[§a?§7] " + "§7Outros Kits : §f" + other.toString());
      }
    }
    return true;
  }
}