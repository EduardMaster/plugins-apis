package Kits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.util.Vector;

import Main.Main;
import Utils.KitAPI;

public class Hulk implements Listener {
	
	  ArrayList<Player> cooldown = new ArrayList<>();
	  public static ArrayList<Player> Hulk = new ArrayList<>();
	
	@EventHandler
	  public void onHulk(PlayerInteractEntityEvent event)
	  {
	    final Player p = event.getPlayer();
	    if ((event.getRightClicked() instanceof Player))
	    {
	      Player d = (Player)event.getRightClicked();
	      if (KitAPI.getKit(p) == "Hulk") {
	        if (KitAPI.getKit(p) == "Hulk")
	        {
	          if (p.getItemInHand().getType().equals(Material.STONE_SWORD)) {
	            if (this.cooldown.contains(p))
	            {
	                p.sendMessage("§7Voce tem que esperar para usar novamente");
	            }
	            else if (p.getPassenger() == null)
	            {
	              p.setPassenger(d);
	              d.sendMessage("§7Voce foi pego por um §c" + "Hulk! §7aperte shift para sair");
	              this.cooldown.add(p);
	              p.setVelocity(new Vector());
	              p.playSound(p.getLocation(), Sound.ZOMBIE_METAL, 4.0F, 4.0F);
	              Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable() 
	              {
	                public void run()
	                {
	                  Hulk.this.cooldown.remove(p);
	                }
	              }, 200L);
	            }
	            else
	            {
	              p.sendMessage("§7Voce ja tem uma pessoa na sua cabeca");
	            }
	          }
	        }
	        else {
	          p.sendMessage("§cVoce nao pode pegar outro Hulk");
	        }
	      }
	    }
	  }
	}
