package Net.Hunger.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Net.Hunger.Manager.Habilidade;

public class CMDCheck implements CommandExecutor, Listener {

   @SuppressWarnings("deprecation")
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player)) {
       sender.sendMessage("§7[§a!§7] §aComandos apenas no servidor!");
       return true;
     }
     Player player = (Player)sender;
     if(cmd.getName().equalsIgnoreCase("invis") && (player.hasPermission("HungerGames.c.admin"))) {
     player.sendMessage("§7[§a!§7] Você ficou §aInvisivel");
     for(Player ps : Bukkit.getOnlinePlayers()) {
     ps.hidePlayer(player);
     }
    }
     if (cmd.getName().equalsIgnoreCase("checar")) {
       if (!player.hasPermission("HungerGames.c.check"))
       {
 	     player.sendMessage("§7[§a?§7] Você não possue permissão para isso!");
         return true;
       }
       if (args.length == 1) {
         Player target = Bukkit.getPlayerExact(args[0]);
         if ((target == null) || (!(target instanceof Player))) {
           player.sendMessage("§7[§a?§7] Jogador não encontrado!");
           return true;
         }
    	 final String KitName = Habilidade.NomeDoKit(Habilidade.getAbility(target));
       if (args.length == 0) {
         player.sendMessage("§7[§a?§7] Use /check [player] para checar o player");
         return true;
       }
       if (args.length == 1) {
        Player jogador = Bukkit.getPlayerExact(args[0]);
        if ((target instanceof Player)) 
         player.sendMessage("§7[§a!§7] " + "Nick: §7" + jogador.getName());
         player.sendMessage("§7[§a!§7] " + "Endereço IP: §7" + jogador.getAddress().getHostString());
	     player.sendMessage("§7[§a!§7] " + "Kit selecionado: §7" + KitName);
	     player.sendMessage("§7[§a!§7] " + "Vida: §7" + ((CraftPlayer) jogador).getHealth() + "/" + ((CraftPlayer) jogador).getMaxHealth());
	     player.sendMessage("§7[§a!§7] " + "Fome: §7" + jogador.getFoodLevel());
	     player.sendMessage("§7[§a!§7] " + "Kills: §7" + CMDListener.getKs(jogador));
	     player.sendMessage("§7[§a!§7] " + "Gamemode: §7" + jogador.getGameMode());
	     player.sendMessage("§7[§a!§7] " + "Cordenadas §7" + jogador.getLocation().getBlockX() + ", " + jogador.getLocation().getBlockY() + ", " + target.getLocation().getBlockZ());
	     player.sendMessage("§7[§a!§7] " + "Distancia: §7" + target.getLocation().distance(player.getLocation()) + " §7blocos");
	     Bukkit.getLogger().info(player.getDisplayName() + " Verificou os ids de " + jogador.getName());  
   	     Bukkit.broadcast("§7[§a!§7] §a" + player.getName() + ChatColor.GRAY + " Verificou §a" + jogador.getName(), "hg.admin");
       }
       }
     }
	return true;
   }
}