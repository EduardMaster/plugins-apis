package Pedrao.Habilidades;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Pedrao.KitAPI;
import Pedrao.Main;

public class DeathNote implements Listener {

	public DeathNote(Main main) {
	}
	 public static ArrayList<Player> cooldown = new ArrayList<Player>();
	  @EventHandler
	  public void click(PlayerInteractEntityEvent e)
	  {
	    final Player p = e.getPlayer();
	    if ((e.getRightClicked() instanceof Player))
	    {
	      Player p2 = (Player)e.getRightClicked();
	      ItemStack i = p.getItemInHand();
	      if ((i.getType() == Material.BOOK) && 
	        (i.hasItemMeta()) && 
	        (KitAPI.DeathNote.contains(p.getName())))
	      {
	        e.setCancelled(true);
	        if (cooldown.contains(p))
	        {
	          p.sendMessage(Main.semperm);
	          return;
	        }
	        cooldown.add(p);
	        p.sendMessage(Main.prefix + "Voce escreveu o player " + p2.getName() + " no Death Note!");
	        p2.sendMessage(Main.prefix + "Seu nome foi escrito no Death Note!!");
	        
	        Random r = new Random();
	        int rand = r.nextInt(100);
	        if (rand > 90)
	        {
	          p2.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 200, 5));
	          p2.sendMessage(Main.prefix + "Voce esta com poison!");
	        }
	        else if (rand > 80)
	        {
	          p2.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 5));
	          p2.sendMessage(Main.prefix + "Voce esta com slow!");
	        }
	        else if (rand > 65)
	        {
	          p2.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 5));
	          p2.sendMessage(Main.prefix + "Voce esta confuso!");
	        }
	        else if (rand > 50)
	        {
	          p2.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 0));
	          p2.sendMessage(Main.prefix + "Voce esta cego!");
	        }
	        else if (rand > 25)
	        {
	          p2.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 200, 0));
	          p2.sendMessage(Main.prefix + "Voce esta fraco!");
	        }
	        else
	        {
	          p2.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 200, 5));
	          p2.sendMessage(Main.prefix + "Voce esta passando mal!");
	        }
	      }
	    }
	    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
	    {
	      public void run()
	      {
	        DeathNote.cooldown.remove(p);
	      }
	    }, 800L);
	  }
	}
