package Net.Hunger.Comandos;

import java.text.DecimalFormat;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Net.Hunger.Main;
import Net.Hunger.Feast.FeastManager;
import Net.Hunger.Manager.Habilidade;
import Net.Hunger.Timer.StringTimer;

public class CMDInfo implements CommandExecutor {
	
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player)) {
      sender.sendMessage("§7[§a!§7] §aComandos apenas no servidor!");
      return true;
    }
    Player p = (Player)sender;
	 final String KitName = Habilidade.NomeDoKit(Habilidade.getAbility(p));
     if ((cmd.getName().equalsIgnoreCase("info"))) {
     if (Main.PreGame) {
     p.sendMessage("§7[§a!§7] " + "§7Informaçoes - §a" + p.getName());
     p.sendMessage("§7[§a!§7] " + "§7Kit - §a " + KitName);
     p.sendMessage("§7[§a!§7] " + "§7Estagio - §aPreGame");
     p.sendMessage("§7[§a!§7] " + "§7Tempo - §a" + StringTimer.TimerGame(Main.TimerIniciando));
     p.sendMessage("§7[§a!§7] " + "§7Jogadores participando - §a" + Main.Jogadores.size());
     }
     if (Main.PreInvencibilidade) {  
     p.sendMessage("§7[§a!§7] " + "§7Informaçoes - §a" + p.getName());
     p.sendMessage("§7[§a!§7] " + "§7Kit - §a " + KitName);
     p.sendMessage("§7[§a!§7] " + "§7Estagio - §aInvencibilidade");
     p.sendMessage("§7[§a!§7] " + "§7Tempo - §a" + StringTimer.TimerGame(Main.TimerInvencibilidade));
     p.sendMessage("§7[§a!§7] " + "§7Jogadores participando - §a" + Main.Jogadores.size());
     }
     if (Main.Partida) {
     p.sendMessage("§7[§a!§7] " + "§7Informaçoes - §a" + p.getName());
     p.sendMessage("§7[§a!§7] " + "§7Kit - §a " + KitName);
     p.sendMessage("§7[§a!§7] " + "§7Estagio - §aAndamento");
     if(Main.Andamento >= 900) {
     DecimalFormat df = new DecimalFormat("##.#");
     p.sendMessage("§7[§a!§7] " + "§7Feast - §f" + df.format(FeastManager.mainBlock.getLocation().getX()) + "§7, §f" + df.format(FeastManager.mainBlock.getLocation().getY()) + "§7, §f" + df.format(FeastManager.mainBlock.getLocation().getZ()));
     }
     p.sendMessage("§7[§a!§7] " + "§7Kills - §a" + CMDListener.getKs(p));
     p.sendMessage("§7[§a!§7] " + "§7Jogadores participando - §a" + Main.Jogadores.size());
     }
    return true;
  }
  return true;
 }
}