package Pedrao.Habilidades;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import Pedrao.KitAPI;
import Pedrao.Main;

public class LifeStealer implements Listener {

	public LifeStealer(Main main) {
	}


	  @EventHandler
	  public void onKill(PlayerDeathEvent e)
	  {
	    if ((e.getEntity().getKiller() instanceof Player))
	    {
	      Player k = e.getEntity().getKiller();
	      if (KitAPI.LifeStealer.contains(k.getName())) {
	        if (k.getItemInHand().getType() == Material.WOOD_SWORD)
	        {
	          k.setHealthScale(24.0D);
	          k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
	          k.sendMessage(Main.prefix + "UPGRADE! Level " + ChatColor.WHITE + "1");
	        }
	        else if (k.getItemInHand().getType() == Material.WOOD_SWORD)
	        {
	          k.setHealthScale(28.0D);
	          k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
	          k.sendMessage(Main.prefix + "UPGRADE! Level " + ChatColor.WHITE + "2");
	        }
	        else if (k.getItemInHand().getType() == Material.WOOD_SWORD)
	        {
	          k.setHealthScale(32.0D);
	          k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
	          k.sendMessage(Main.prefix + "UPGRADE! Level " + ChatColor.WHITE + "3");
	        }
	        else if (k.getItemInHand().getType() == Material.WOOD_SWORD)
	        {
	          k.setHealthScale(36.0D);
	          k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
	          k.sendMessage(Main.prefix + "UPGRADE! Level " + ChatColor.WHITE + "4");
	        }
	        else if (k.getItemInHand().getType() == Material.WOOD_SWORD)
	        {
	          k.setHealthScale(40.0D);
	          k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
	          k.sendMessage(Main.prefix + "UPGRADE! Level " + ChatColor.WHITE + "5");
	        }
	        else
	        {
	          k.sendMessage(Main.prefix + "Voce esta no level maximo!");
	        }
	      }
	    }
	  }
	}