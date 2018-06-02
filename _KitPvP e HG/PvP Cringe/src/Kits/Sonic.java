package Kits;

import Main.Main;
import Utils.KitAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class Sonic implements Listener
{
  public int boost = Integer.valueOf(6).intValue();
  public static ArrayList<String> sonic = new ArrayList<>();
  static ArrayList<String> fall = new ArrayList<>();
  public static HashMap<String, ItemStack[]> Armadura = new HashMap<>();
  public HashMap<String, ItemStack[]> saveinv = new HashMap<>();
  public static HashMap<String, ItemStack[]> savearmor = new HashMap<String, ItemStack[]>();
  public static HashMap<String, ItemStack[]> armadura = new HashMap<>();
  public static HashMap<String, ItemStack[]> Armadura2 = new HashMap<>();
  public static List<Player> cooldownm = new ArrayList<>();
  
  @SuppressWarnings("unused")
@EventHandler
  public void DeshClick(PlayerInteractEvent event)
  {
    int fire = Integer.valueOf(6).intValue();
    
    final Player p = event.getPlayer();
    if ((event.getPlayer().getItemInHand().getType() == Material.LAPIS_BLOCK) && 
      (KitAPI.getKit(p) == "Sonic"))
    {
      if ((event.getAction() == Action.LEFT_CLICK_AIR) || 
        (event.getAction() == Action.LEFT_CLICK_BLOCK) || 
        (event.getAction() == Action.RIGHT_CLICK_BLOCK) || 
        (event.getAction() == Action.RIGHT_CLICK_AIR)) {
        event.setCancelled(true);
      }
      if (cooldownm.contains(p))
      {
        p.sendMessage("§alAguarde o cooldown acabar!");
        return;
      }
      cooldownm.add(p);
      fall.add(p.getName());
      p.setVelocity(p.getEyeLocation().getDirection().multiply(this.boost).add(new Vector(0, 0, 0)));
      p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 10, 0);
      Location loc = p.getLocation();
      for (Entity pertos : p.getNearbyEntities(8.0D, 8.0D, 8.0D)) {
        if ((pertos instanceof Player))
        {
          Player perto = (Player)pertos;
          ((Player)pertos).damage(10.0D);
          pertos.setVelocity(new Vector(0.1D, 0.0D, 0.1D));
          ((Player)pertos).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 5*20, 1), true);
          ((Player)pertos).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 5*20, 1), true);
          ((Player)pertos).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 5*20, 1), true);
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
      
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
      {
        public void run()
        {
          p.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
        }
      }, 0L);
      
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
      {
        public void run()
        {
          p.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
        }
      }, 20L);
      
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
      {
        public void run()
        {
          p.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
        }
      }, 30L);
      
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
      {
        public void run()
        {
          p.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
        }
      }, 40L);
      
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
      {
        public void run()
        {
          p.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
        }
      }, 50L);
      
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
      {
        public void run()
        {
          p.updateInventory();
          fall.remove(p.getName());
          p.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
  		  p.getInventory().setHelmet(new ItemStack(Material.AIR));
  	      ItemStack peito = new ItemStack(Material.LEATHER_CHESTPLATE);
  	      LeatherArmorMeta kpeito = (LeatherArmorMeta)peito.getItemMeta();
  	      kpeito.setColor(Color.PURPLE);
  	      peito.setItemMeta(kpeito);
  	      p.getInventory().setChestplate(peito);
  	 	  p.getInventory().setLeggings(new ItemStack(Material.AIR));
  		  p.getInventory().setBoots(new ItemStack(Material.AIR));
        }
      }, 60L);
      
      
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
      {
        public void run()
        {
          cooldownm.remove(p);         
          sonic.remove(p);
        }
      }, 700L);
    }
  }
  
  @EventHandler
  public void AiMeuCuv5(EntityDamageEvent e)
  {
    if (!(e.getEntity() instanceof Player)) {
      return;
    }
    Player p = (Player)e.getEntity();
    if ((e.getCause() == EntityDamageEvent.DamageCause.FALL) && 
      (fall.contains(p.getName())))
    {
      fall.remove(p.getName());
      e.setDamage(6.5D);
      return;
    }
  }
}
