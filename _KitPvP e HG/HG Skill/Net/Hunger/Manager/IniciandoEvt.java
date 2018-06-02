package Net.Hunger.Manager;

import java.text.SimpleDateFormat;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.server.ServerListPingEvent;

import Net.Hunger.Main;
import Net.Hunger.Comandos.CMDAdmin;
import Net.Hunger.Timer.StringTimer;

public class IniciandoEvt implements Listener {
	
	public static boolean Teleportar;
	
	@EventHandler
	public void onTeleport(PlayerTeleportEvent e) {
	if(Teleportar) {
	e.setCancelled(true);
	}
	}
		
    @EventHandler(priority = EventPriority.MONITOR)
	public void onPing(ServerListPingEvent e) {
	if(Main.PreGame) {
	e.setMotd("§7§l[§e§l!!§7§l]§e§l Skill§e§lHG §b§l= §a§lAguardando jogadores!\n§7§l[§e§l?§7§l] Partida iniciando em §c§l»§f§l " + StringTimer.TimerGame(Main.TimerIniciando));
    }
	if(Main.PreInvencibilidade) {
	e.setMotd("§7§l[§e§l!!§7§l]§e§l Skill§e§lHG §b§l= §c§lPartida em progresso!\n§7§l[§e§l?§7§l] Invencibilidade acaba em §c§l»§f§l " + StringTimer.TimerGame(Main.TimerInvencibilidade));
	}
	if(Main.Partida) {
	int millis = Main.Andamento * 1000;
	SimpleDateFormat df = new SimpleDateFormat("mm:ss");
	String time = df.format(Integer.valueOf(millis)); 
	e.setMotd("§7§l[§e§l!!§7§l]§e§l Skill§e§lHG §b§l= §c§lPartida em progresso!\n§7§l[§e§l?§7§l] Tempo de partida §c§l»§f§l " + time);
	}
	if(Main.Finalizando) {
	e.setMotd("§7§l[§e§l!!§7§l]§e§l Skill§e§lHG §b§l= §c§lServidor reiniciando!\n§a§lServidores: §f§l01.Skill-HG.com §7§la §f§l07.Skill-HG.com.");
	}
	}

	public static void onTeleport() {
	for(Player p : Bukkit.getOnlinePlayers()) {
    if(Main.Jogadores.contains(p.getName())) {
    int x = new Random().nextInt(5) + 30;
	int y = new Random().nextInt(5) + 90;
	int z = new Random().nextInt(5) + 30;
	Location loc = new Location(p.getWorld(), x,y,z);
	p.teleport(loc);  
	}
	}
    }
}