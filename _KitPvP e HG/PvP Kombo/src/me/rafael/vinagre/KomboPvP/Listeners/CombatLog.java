package me.rafael.vinagre.KomboPvP.Listeners;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import XP.XpM;
import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.PvPBar;


public class CombatLog implements Listener
{
	  
	  @SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<String> Sair = new ArrayList();
	  
	  @EventHandler
	  public void onEntityDamage(EntityDamageByEntityEvent e)
	  {
	    if (((e.getDamager() instanceof Player)) && ((e.getEntity() instanceof Player)))
	    {
	      final Player p = (Player)e.getEntity();
	      final Player hitter = (Player)e.getDamager();
	      
	      if((!Main.areaPvP(hitter)) || (!Main.areaPvP(p))){
	    	  return;
	      }
	      if(hitter.getGameMode() == GameMode.CREATIVE){
	    	  return;
	      }
	      if ((!Sair.contains(p.getName())) && (!Sair.contains(hitter.getName())))
	      {
	        Sair.add(p.getName());
	        Sair.add(hitter.getName());
	        p.sendMessage("§c§lCOMBATLOG: §cVoce entrou em combate com §7" + hitter.getPlayerListName());
	        hitter.sendMessage("§c§lCOMBATLOG: §cVoce entrou em combate com §7" + p.getPlayerListName());
	       
	        Scoreboard.ScoreDoBasic.iscoriboard(p);
	        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	        {
	          public void run()
	          {
	            CombatLog.Sair.remove(p.getName());
	            CombatLog.Sair.remove(hitter.getName());
	           
	            p.sendMessage("§c§lCOMBATLOG: §cVoce nao esta mas em combate !");
	            hitter.sendMessage("§c§lCOMBATLOG: §cVoce nao esta mas em combate !");
	            Scoreboard.ScoreDoBasic.iscoriboard(p);
	          }
	        }, 200L);
	      }
	    }
	  }
	  
	  @EventHandler
	  public void onPlayerExit(PlayerQuitEvent e) throws SQLException
	  {
	    Player p = e.getPlayer();
	    if (Sair.contains(p.getName()))
	    {
	      p.setHealth(0.0D);
	      p.teleport(p.getWorld().getSpawnLocation());
	      Bukkit.broadcastMessage("§c§lCOMBATLOG: §c" + p.getName() + " deslogou em combate e perdeu §7200 §cde §7XP §c!");
	      XpM.removeMoney(p, 200);
	    }
	  }
	  
	  @EventHandler
	  public void onMe2(PlayerCommandPreprocessEvent event)
	  {
	    Player p = event.getPlayer();
	    if ((Sair.contains(p.getName())) && (
	      (event.getMessage().toLowerCase().startsWith("/spawn"))))
	    	 
	    {
	      event.setCancelled(true);
	      p.sendMessage("§c§lCOMBATLOG: §cVoce esta em combate !");
	      if ((Sair.contains(p.getName())) && (
	    	      (event.getMessage().toLowerCase().startsWith("/warp"))))
	    	    	 
	    	    {
	    	      event.setCancelled(true);
	    	      p.sendMessage("§c§lCOMBATLOG: §cVoce esta em combate !");
	    	      if ((Sair.contains(p.getName())) && (
	    	    	      (event.getMessage().toLowerCase().startsWith("/gm"))))
	    	    	    	 
	    	    	    {
	    	    	      event.setCancelled(true);
	    	    	      p.sendMessage("§c§lCOMBATLOG: §cVoce esta em combate !");
	    	    	      if ((Sair.contains(p.getName())) && (
	    	    	    	      (event.getMessage().toLowerCase().startsWith("/gamemode"))))
	    	    	    	    	 
	    	    	    	    {
	    	    	    	      event.setCancelled(true);
	    	    	    	      p.sendMessage("§c§lCOMBATLOG: §cVoce esta em combate !");
	    	    	    	      if ((Sair.contains(p.getName())) && (
	    	    	    	    	      (event.getMessage().toLowerCase().startsWith("/fly"))))
	    	    	    	    	    	 
	    	    	    	    	    {
	    	    	    	    	      event.setCancelled(true);
	    	    	    	    	      p.sendMessage("§c§lCOMBATLOG: §cVoce esta em combate !");
	    }
	  }
	}
}
}
}
}