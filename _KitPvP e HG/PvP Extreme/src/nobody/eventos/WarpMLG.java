package nobody.eventos;
 

import nobody.main.Main;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
 
public class WarpMLG implements Listener {
 
	 @EventHandler
	 public void aoLevarDano(EntityDamageEvent Evento) {
	  Player Jogador = (Player) Evento.getEntity();
	  if (Main.mlg.contains(Jogador.getName())) {
	   if (Jogador.getFallDistance() > 2) {
	    if (Evento.getDamage() == 0) {
	     // Acertou
	     Evento.setCancelled(true);
	     Location Warp = new Location(Jogador.getWorld(), 2000.0D, 98.0D, 20000.0D);
	     Jogador.teleport(Warp);
	     Jogador.sendMessage("§aVoce Acertou Parabens :)");
	    }
	    if (Evento.getDamage() >= 1) {
	     // Errou
	     if (Evento.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
	      Evento.setCancelled(true);
	      Location Warp = new Location(Jogador.getWorld(), 2000.0D, 98.0D, 20000.0D);
	      Jogador.teleport(Warp);
	      Jogador.sendMessage("§aVoce errou :(");
	      Jogador.setHealth(20.0D);
	     }
	    }
	   }
	  }
	   }
	 }