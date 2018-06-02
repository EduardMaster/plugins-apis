package nobody.eventos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.server.ServerListPingEvent;

public class Motd implements Listener {
	@EventHandler
	public void motd(ServerListPingEvent e) {
		e.setMotd("§B§LKITPVP §e§L1.7 §f/ §e§l1.8 §F| §6§lVENHA TREINAR! "
				+ "\n§aVenha Se Divertir!");
		e.setMaxPlayers(130);
	}
	  @EventHandler(priority=EventPriority.HIGHEST)
	  public void onSoupDrink(PlayerInteractEvent e)
	  {
	    Player p = e.getPlayer();
	    if (p.getItemInHand().getType() != Material.MUSHROOM_SOUP) {
	      return;
	    }
	    Damageable d = p;
	    if (d.getHealth() == d.getMaxHealth()) {
	      return;
	    }
	    if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {

	}
	    if (d.getHealth() > d.getMaxHealth() - 7.0D) {
	      d.setHealth(d.getMaxHealth());
	    } else {
	      d.setHealth(d.getHealth() + 7.0D);
	    }
	    p.getItemInHand().setType(Material.BOWL);
	    p.playSound(p.getLocation(), Sound.BURP, 12F, 12F);
	  }
		
	
	@EventHandler
	public void onPlayer(PlayerMoveEvent e)
	{
	  Player p = e.getPlayer();
	  if ((!this.mecheu.contains(p.getName())) && 
	    (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.JUKEBOX))
	  {
	    
	    p.getInventory().clear();
	    
	    p.playSound(p.getLocation(), Sound.CHEST_CLOSE, 1.0F, 1.0F);
	    p.getInventory().clear();
	    p.getInventory().setArmorContents(null);
	    p.setGameMode(GameMode.ADVENTURE);
	    p.sendMessage(" §l§6» §eParabens Voce Concluiu o Nivel Facil do LavaChallenge e Por isso Recebeu §6400 §eCOINS !");
	    p.teleport(p.getWorld().getSpawnLocation());
	    Money.addMoney(400, p);
	  }
	}

	@EventHandler
	public void onPlayer1(PlayerMoveEvent e)
	{
	  Player p = e.getPlayer();
	  if ((!this.mecheu.contains(p.getName())) && 
	    (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.LAPIS_BLOCK))
	  {
	    
	    p.getInventory().clear();
	    
	    p.playSound(p.getLocation(), Sound.CHEST_CLOSE, 1.0F, 1.0F);
	    p.getInventory().clear();
	    p.getInventory().setArmorContents(null);
	    p.teleport(p.getWorld().getSpawnLocation());
	    p.setGameMode(GameMode.ADVENTURE);
	    
	    Money.addMoney(600, p);
	    Bukkit.broadcastMessage(p.getName() + " §6Completou o Nível Medio do Lava Challenge");
	    p.sendMessage(" §l§6» §eParabens Voce Concluiu o Nivel Medio do LavaChallenge e Por isso Recebeu §61000 §eCOINS !");
	  }
	}

	@EventHandler
	public void onPlayer11(PlayerMoveEvent e)
	{
	  Player p = e.getPlayer();
	  if ((!this.mecheu.contains(p.getName())) && 
	    (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.COAL_BLOCK))
	  {
	    
	    p.getInventory().clear();
	    
	    p.playSound(p.getLocation(), Sound.CHEST_CLOSE, 1.0F, 1.0F);
	    p.getInventory().clear();
	    p.getInventory().setArmorContents(null);

	    p.teleport(p.getWorld().getSpawnLocation());
	    
	    p.setGameMode(GameMode.ADVENTURE);
	    
	    Money.addMoney(700, p);
	    Bukkit.broadcastMessage(p.getName() + " §6Completou o Nível Dificil do Lava Challenge");
	    p.sendMessage(" §l§6» §eParabens Voce Concluiu o Nivel Dificil do LavaChallenge e Por isso Recebeu §62000 §eCOINS !");
	  }
	}

	@EventHandler
	public void parkouryyy(PlayerMoveEvent e)
	{
	  Player p = e.getPlayer();
	  if ((!this.mecheu.contains(p.getName())) && 
	    (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.MELON_BLOCK))
	  {
	    
	    p.getInventory().clear();
	    
	    p.playSound(p.getLocation(), Sound.CHEST_CLOSE, 1.0F, 1.0F);
	    p.getInventory().clear();
	    p.getInventory().setArmorContents(null);

	    p.teleport(p.getWorld().getSpawnLocation());
	    
	    p.setGameMode(GameMode.ADVENTURE);
	    
	    Money.addMoney(700, p);
	    Bukkit.broadcastMessage(p.getName() + " §6Completou o Parkour e Recebeu 1k De Money");
	    p.sendMessage(" §l§6» §eVocê terminou o parkour e recebeu 1000 Money!");
	  }
	}


	ArrayList<String> mecheu = new ArrayList<String>();

	@EventHandler
	public void onPlayer111(PlayerMoveEvent e)
	{
	  Player p = e.getPlayer();
	  if ((!this.mecheu.contains(p.getName())) && 
	    (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.QUARTZ_BLOCK))
	  {
	    
	    p.getInventory().clear();
	    
	    p.playSound(p.getLocation(), Sound.CHEST_CLOSE, 1.0F, 1.0F);
	    p.getInventory().clear();
	    p.getInventory().setArmorContents(null);
	    p.teleport(p.getWorld().getSpawnLocation());
	    
	    
	    p.setGameMode(GameMode.ADVENTURE);
	    Money.addMoney(1000, p);
	    Bukkit.broadcastMessage(p.getName() + " §6Completou o Nível Extreme do Lava Challenge");
	    p.sendMessage(" §l§6» §eParabens Voce Concluiu o Nivel Extreme do LavaChallenge e Por isso Recebeu §6300 §eCOINS + Kit ->");
	  }
	  {
	}
	}
}

