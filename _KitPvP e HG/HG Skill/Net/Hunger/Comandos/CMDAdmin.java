package Net.Hunger.Comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Net.Hunger.Main;
import Net.Hunger.Manager.EspectadoresManager;

public class CMDAdmin implements CommandExecutor {
	
	public static ArrayList<Player> admin = new ArrayList<Player>();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	 if (!(sender instanceof Player)) {
      sender.sendMessage("§7[§b!§7] §bComandos apenas no servidor!");
     return true;
    }
    Player p = (Player) sender;
    if (cmd.getName().equalsIgnoreCase("admin")) {
     if(p.hasPermission("HungerGames.c.admin")) {
      if (!admin.contains(p)) {
       admin.add(p);
        p.setGameMode(GameMode.CREATIVE);
        p.sendMessage("§7[§a!§7] Você entrou no modo §aAdmin");
        p.sendMessage("§7[§a!§7] Você esta §ainvisivel §7para todos");
        Bukkit.getLogger().info(p.getName() + " Entrou no modo Admin");
        for(Player jogadores : Bukkit.getOnlinePlayers()) {
        jogadores.hidePlayer(p);
        }
     	Bukkit.broadcast(p.getName() + ChatColor.GRAY + " Entrou no modo Admin ", "hg.admin");
        Main.Watch.remove(p.getName());
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
        public void run() {
        Main.Jogadores.remove(p.getName());
        }
        },3L);
        } else {  
        admin.remove(p);
        p.sendMessage("§7[§a!§7] Você saiu no modo §aAdmin");
        p.sendMessage("§7[§a!§7] Você esta §avisivel§7 para todos");
        for(Player jogadores : Bukkit.getOnlinePlayers()) {
        jogadores.showPlayer(p);
        }
        p.setGameMode(GameMode.SURVIVAL);
        Bukkit.getLogger().info(p.getName() + " Saiu no modo Admin");
     	Bukkit.broadcast(p.getName() + ChatColor.GRAY + " Saiu do modo Admin ", "hg.admin");
        Main.Watch.remove(p.getName());
        EspectadoresManager.DamageMobs.remove(p.getName());
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
        public void run() {
        Main.Jogadores.add(p.getName());
        }
        },3L);
        }
       } else {
    	p.sendMessage("§7[§a?§7] Você não tem permissao para fazer isso!");
    	return true;
       }
      }
    return true;
 }
}