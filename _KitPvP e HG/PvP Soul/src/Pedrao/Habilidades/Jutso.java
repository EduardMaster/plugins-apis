package Pedrao.Habilidades;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import Pedrao.KitAPI;
import Pedrao.Main;

public class Jutso implements Listener {

	public Jutso(Main main) {
	}


	  @SuppressWarnings({ "unchecked", "rawtypes" })
	public static HashMap<String, Long> cooldown = new HashMap();
	  @SuppressWarnings({ "unchecked", "rawtypes" })
	  public ArrayList<String> Cima = new ArrayList();
	  @SuppressWarnings({ "unchecked", "rawtypes" })
	  ArrayList<String> tempo = new ArrayList();
	  @SuppressWarnings({ "unchecked", "rawtypes" })
	  private ArrayList<Block> remover = new ArrayList();
	  
	  @EventHandler
	  public void Clicar(PlayerInteractEvent e)
	  {
	    final Player p = e.getPlayer();
	    if ((p instanceof Player)) {
	      if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
	        (KitAPI.Jutso.contains(p.getName())) && 
	        (p.getItemInHand().getType() == Material.PAPER))
	      {
	        e.setCancelled(true);
	        if (!this.tempo.contains(p.getName()))
	        {
	          Location Local = e.getPlayer().getLocation();
	          Local = Local.getWorld().getHighestBlockAt(Local).getLocation().add(0.0D, 0.0D, 0.0D);
	          Player localPlayer = e.getPlayer();
	          for (int x = 0; x <= 0; x++) {
	            for (int z = 0; z <= 0; z++)
	            {
	              final Block a = Local.add(x, 0.0D, z).getBlock();
	              final Block b = Local.add(x, 1.0D, z).getBlock();
	              a.setType(Material.FENCE);
	              b.setType(Material.PUMPKIN);
	              localPlayer.playSound(localPlayer.getLocation(), Sound.ENDERMAN_TELEPORT, 
	                1.0F, 1.0F);
	              localPlayer.getWorld().playEffect(localPlayer.getLocation(), 
	                Effect.SMOKE, 10);
	              p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 120, 2));
	              p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 120, 0));
	              e.getPlayer().teleport(Local.add(5.0D, 8.0D, 0.0D));
	              p.chat(Main.prefix + "Jutso Substituicao!");
	              this.tempo.add(p.getName());
	              this.Cima.add(p.getName());
	              p.getPlayer().getInventory().setArmorContents(null);
	              Bukkit.getServer().getScheduler().runTaskLater(Main.plugin, new Runnable()
	              {
	                public void run()
	                {
	                  a.setType(Material.AIR);
	                  b.setType(Material.AIR);
	                  Jutso.this.remover.remove(a);
	                  
	                  p.sendMessage(Main.prefix + "Seu Chakra acabou!");
	                }
	              }, 120L);
	            }
	          }
	        }
	        else
	        {
	          p.sendMessage(Main.cl);
	        }
	      }
	    }
	  }
	  
	  @EventHandler
	  public void Cair(EntityDamageEvent e)
	  {
	    if (!(e.getEntity() instanceof Player)) {
	      return;
	    }
	    final Player p = (Player)e.getEntity();
	    if ((e.getCause() == EntityDamageEvent.DamageCause.FALL) && 
	      (this.Cima.contains(p.getName())))
	    {
	      e.setCancelled(true);
	      for (Entity Altura : p.getNearbyEntities(0.0D, 0.0D, 0.0D)) {
	        if ((Altura instanceof Player))
	        {
	          Player Pular = (Player)Altura;
	          Vector v = p.getLocation().getDirection().multiply(0).setY(0.0D);
	          Pular.setVelocity(v);
	        }
	      }
	      this.Cima.remove(p.getName());
	      Bukkit.getServer().getScheduler().runTaskLater(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	          Jutso.this.tempo.remove(p.getName());
	          p.sendMessage("§cChakra pronto");
	        }
	      }, 450L);
	      
	      return;
	    }
	  }
	}
