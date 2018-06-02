package Pedrao.Habilidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import Pedrao.KitAPI;
import Pedrao.Main;

public class Sonic implements Listener {

	public Sonic(Main main) {
	}
	  public int boost = Integer.valueOf(6).intValue();
	  public static ArrayList<String> Sonic = new ArrayList<String>();
	  public static HashMap<String, ItemStack[]> Armadura = new HashMap<String, ItemStack[]>();
	  public static Main plugin;
	  public static HashMap<String, ItemStack[]> saveinv = new HashMap<String, ItemStack[]>();
	  public static HashMap<String, ItemStack[]> armadura = new HashMap<String, ItemStack[]>();
	  public static HashMap<String, ItemStack[]> Armadura2 = new HashMap<String, ItemStack[]>();
	  public static List<Player> cooldownm = new ArrayList<Player>();
	  
	  @EventHandler
	  public void SonicLick(PlayerInteractEvent event)
	  {
	    final Player p = event.getPlayer();
	    if ((event.getPlayer().getItemInHand().getType() == Material.LAPIS_BLOCK) && 
	      (KitAPI.Sonic.contains(event.getPlayer().getName())))
	    {
	      if ((event.getAction() == Action.LEFT_CLICK_AIR) || 
	        (event.getAction() == Action.LEFT_CLICK_BLOCK) || 
	        (event.getAction() == Action.RIGHT_CLICK_BLOCK) || 
	        (event.getAction() == Action.RIGHT_CLICK_AIR)) {
	        event.setCancelled(true);
	      }
	      if (cooldownm.contains(p))
	      {
	        p.sendMessage(Main.cl);
	        return;
	      }
	      cooldownm.add(p);
	      p.setVelocity(p.getEyeLocation().getDirection().multiply(this.boost).add(new Vector(0, 0, 0)));
	      p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 10, 0);
	      p.getLocation();
	      for (Entity pertos : p.getNearbyEntities(8.0D, 8.0D, 8.0D)) {
	        if ((pertos instanceof Player))
	        {
	          ((Player)pertos).damage(10.0D);
	          pertos.setVelocity(new Vector(0.1D, 0.0D, 0.1D));
	          ((Player)pertos).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 105, 105));
	          p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 105, 105));
	        }
	      }
	      ItemStack Capacete = new ItemStack(Material.LEATHER_HELMET);
	      LeatherArmorMeta kCapacete = (LeatherArmorMeta)Capacete.getItemMeta();
	      kCapacete.setColor(Color.BLUE);
	      Capacete.setItemMeta(kCapacete);
	      
	      ItemStack Peitoral = new ItemStack(Material.LEATHER_CHESTPLATE);
	      LeatherArmorMeta kPeitoral = (LeatherArmorMeta)Peitoral.getItemMeta();
	      kPeitoral.setColor(Color.BLUE);
	      Peitoral.setItemMeta(kPeitoral);
	      
	      ItemStack Calss = new ItemStack(Material.LEATHER_LEGGINGS);
	      LeatherArmorMeta kCalss = (LeatherArmorMeta)Calss.getItemMeta();
	      kCalss.setColor(Color.BLUE);
	      Calss.setItemMeta(kCalss);
	      
	      ItemStack Bota = new ItemStack(Material.LEATHER_BOOTS);
	      LeatherArmorMeta kBota = (LeatherArmorMeta)Capacete.getItemMeta();
	      kBota.setColor(Color.BLUE);
	      Bota.setItemMeta(kBota);
	      
	      Armadura.put(p.getName(), p.getInventory().getArmorContents());
	      
	      p.getInventory().setHelmet(Capacete);
	      p.getInventory().setChestplate(Peitoral);
	      p.getInventory().setLeggings(Calss);
	      p.getInventory().setBoots(Bota);
	      p.updateInventory();
	      
	      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	          p.getInventory().setArmorContents(null);
	          p.updateInventory();
	        }
	      }, 50L);
	      
	      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	          cooldownm.remove(p);
	          Sonic.remove(p);
	          p.sendMessage(Main.prefix + "§3§oVoce pode usar novamente!");
	          p.getWorld().playSound(p.getLocation(), Sound.BURP, 5.0F, 5.0F);
	        }
	      }, 700L);
	    }
	  }
	}
