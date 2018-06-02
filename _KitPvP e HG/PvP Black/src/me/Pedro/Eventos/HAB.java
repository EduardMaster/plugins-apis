package me.Pedro.Eventos;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;

import de.slikey.effectlib.EffectLib;
import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.effect.ArcEffect;
import de.slikey.effectlib.effect.AtomEffect;
import de.slikey.effectlib.effect.BigBangEffect;
import de.slikey.effectlib.effect.BleedEffect;
import de.slikey.effectlib.effect.DnaEffect;
import de.slikey.effectlib.effect.EarthEffect;
import de.slikey.effectlib.effect.ExplodeEffect;
import de.slikey.effectlib.effect.FlameEffect;
import de.slikey.effectlib.effect.FountainEffect;
import de.slikey.effectlib.effect.GridEffect;
import de.slikey.effectlib.effect.HelixEffect;
import de.slikey.effectlib.effect.JumpEffect;
import de.slikey.effectlib.effect.LineEffect;
import de.slikey.effectlib.effect.LoveEffect;
import de.slikey.effectlib.effect.MusicEffect;
import de.slikey.effectlib.effect.ShieldEffect;
import de.slikey.effectlib.effect.SkyRocketEffect;
import de.slikey.effectlib.effect.SmokeEffect;
import de.slikey.effectlib.effect.StarEffect;
import de.slikey.effectlib.effect.TextEffect;
import de.slikey.effectlib.effect.TraceEffect;
import de.slikey.effectlib.effect.VortexEffect;
import de.slikey.effectlib.effect.WarpEffect;
import de.slikey.effectlib.util.ParticleEffect;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

import de.slikey.effectlib.effect.EarthEffect;
import me.Pedro.Main;

public class HAB implements Listener{
	public HAB(Main main) {
	}

	@EventHandler
	  private static void d(EntityDamageEvent paramEntityDamageEvent)
	  {
	    if (!(paramEntityDamageEvent.getEntity() instanceof Player)) {
	      return;
	    }
	    Player localPlayer1 = (Player)paramEntityDamageEvent.getEntity();
	    if ((KitAPI.Stomper.contains(localPlayer1.getName())) && (paramEntityDamageEvent.getCause() == EntityDamageEvent.DamageCause.FALL))
	    {
	      Iterator localIterator = localPlayer1.getNearbyEntities(6.0D, 4.0D, 6.0D).iterator();
	      Object localObject;
	      while (localIterator.hasNext()) {
	        if ((((localObject = (Entity)localIterator.next()) instanceof Player)))
	        {
	          Player localPlayer2 = (Player)localObject;
	          if (KitAPI.AntiStomper.contains(localPlayer2.getName()))
	          {
	            localPlayer2.damage(4.0D);
	          }
	          else if (!localPlayer2.isSneaking())
	          {
	            localPlayer2.damage(0.1D, localPlayer1);
	            localPlayer2.damage(paramEntityDamageEvent.getDamage());
	          }
	          else
	          {
	            localPlayer2.damage(0.1D, localPlayer1);
	            localPlayer2.damage(3.9D);
	          }
	        }
	      }
	      for (double d1 = -1.0D; d1 <= 1.0D; d1 += 1.0D) {
	        for (double d2 = -1.0D; d2 <= 1.0D; d2 += 1.0D)
	        {
	          localObject = new Location(localPlayer1.getWorld(), localPlayer1.getLocation().getX() + d1, localPlayer1.getLocation().getY(), localPlayer1.getLocation().getZ() + d2);
	          for (int i = 0; i < 3; i++) {
	            ((Location)localObject).getWorld().playEffect((Location)localObject, Effect.WITCH_MAGIC, 100);
	              
	              
	          }
	        }
	      }
	      if (paramEntityDamageEvent.getDamage() > 4.0D) {
	        paramEntityDamageEvent.setDamage(4.0D);
	      }
	    }
	  }
	  private HashMap<Player, Integer> jumped = new HashMap();
	  public static ArrayList<Player> kangarooc = new ArrayList();
	  
	  @EventHandler
	  public void interact(PlayerInteractEvent e)
	  {
	    Player p = e.getPlayer();
	    Entity Entity = p;
	    if ((KitAPI.Kangaroo.contains(p.getName())) && 
	      (p.getItemInHand().getType() == Material.FIREWORK))
	    {
	      e.setCancelled(true);
	      if (!this.jumped.containsKey(p)) {
	        if (!p.isSneaking())
	        {
	          if (!((CraftPlayer)p).getHandle().onGround)
	          {
	            this.jumped.put(p, Integer.valueOf(1));
	            p.setVelocity(new Vector(p.getVelocity().getX(), 1.0D, p.getVelocity().getZ()));
	          }
	          else
	          {
	            p.setVelocity(new Vector(p.getVelocity().getX(), 1.0D, p.getVelocity().getZ()));
	          }
	        }
	        else if (!((CraftPlayer)p).getHandle().onGround)
	        {
	          p.setVelocity(p.getLocation().getDirection().multiply(1.2D));
	          p.setVelocity(new Vector(p.getVelocity().getX(), 0.5D, p.getVelocity().getZ()));
	          this.jumped.put(p, Integer.valueOf(1));
	        }
	        else
	        {
	          p.setVelocity(p.getLocation().getDirection().multiply(1.2D));
	          p.setVelocity(new Vector(p.getVelocity().getX(), 0.5D, p.getVelocity().getZ()));
	        }
	      }
	    }
	  }
	  
	  @EventHandler
	  public void landed(PlayerMoveEvent e)
	  {
	    if ((e.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR) && 
	      (this.jumped.containsKey(e.getPlayer()))) {
	      this.jumped.remove(e.getPlayer());
	    }
	  }
	  
	  @EventHandler
	  public void poucodano(EntityDamageEvent e)
	  {
	    if ((e.getEntity() instanceof Player))
	    {
	      Player p = (Player)e.getEntity();
	      if (KitAPI.Kangaroo.contains(p.getName())) {
	        if (e.getDamage() > 7.0D) {
	          e.setDamage(7);
	        } else {
	          e.setDamage(e.getDamage());
	        }
	      }
	    }
	  }
	  @EventHandler(priority=EventPriority.NORMAL)
	  public void onPlayerInteract(PlayerInteractEvent e)
	  {
	    final Player p = e.getPlayer();
	    if ((KitAPI.Thor.contains(p.getName())) && (
	      (e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)))
	    {
	      ItemStack hand = p.getItemInHand();
	      if (hand.getType() == Material.WOOD_AXE) {
	        if (Tempo.add(p))
	        {
	          p.sendMessage(API.sev + "Voce esta em cooldown espera §c" + Tempo.tempo(p) + "s");
	        }
	        else
	        {
	          Location loc = p.getTargetBlock(null, 40).getLocation();
	          p.getLocation().getBlock().getWorld().strikeLightning(loc);
	          
	          Tempo.add(p, 10);
	        }
	      }
	    }
	  }

	  @EventHandler
	  public void BloodClick(PlayerInteractEvent event)
	  {
	    final Player p = event.getPlayer();
	    if ((event.getPlayer().getItemInHand().getType() == Material.GOLD_BARDING) && 
	    		
	      (KitAPI.Bazooka.contains(event.getPlayer().getName())))
	    {
	      if ((event.getAction() == Action.LEFT_CLICK_AIR) || 
	        (event.getAction() == Action.LEFT_CLICK_BLOCK)) {
	        event.setCancelled(true);
	      }
	      if (Tempo.add(p))
	      {
	        p.sendMessage(API.sev + "Voce esta em cooldown espera §c" + Tempo.tempo(p) + "s");
	      }
	      else
	      {
	        Vector velo1 = p.getLocation().getDirection().normalize().multiply(9);
	        Snowball boladenve = (Snowball)p.launchProjectile(Snowball.class);
	        boladenve.setVelocity(velo1);
	        Location location = p.getEyeLocation();
	        BlockIterator blocksToAdd = new BlockIterator(location, 0.0D, 30);
	        while (blocksToAdd.hasNext())
	        {
	          Tempo.add(p, 30);
	    }
	      }
	    }
	  }
	  @EventHandler
	  public void onPlayerFish(PlayerFishEvent event)
	  {
	    Entity caught = event.getCaught();
	    Block block = event.getHook().getLocation().getBlock();
	    if ((caught != null) && (caught != block) && 
	      (KitAPI.Fisherman.contains(event.getPlayer().getName()))) {
	      caught.teleport(event.getPlayer().getLocation());
	    }
	  }
	  public static HashMap<Player, Player> a = new HashMap();
	  public static HashMap<Player, Long> b = new HashMap();
	  public static List<Player> cooldownbk = new ArrayList();
	  @EventHandler
	  public void a(EntityDamageByEntityEvent paramEntityDamageByEntityEvent)
	  {
	    if (((paramEntityDamageByEntityEvent.getDamager() instanceof Player)) && ((paramEntityDamageByEntityEvent.getEntity() instanceof Player)))
	    {
	      final Player localPlayer1 = (Player)paramEntityDamageByEntityEvent.getDamager();
	      Player localPlayer2 = (Player)paramEntityDamageByEntityEvent.getEntity();
	      if (KitAPI.Ninja.contains(localPlayer1.getName()))
	      {
	        a.put(localPlayer1, localPlayer2);
	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	        {
	          public void run()
	          {
	            cooldownbk.remove(localPlayer1);
	          }
	        }, 200L);
	      }
	    }
	  }
	  
	  @EventHandler
	  public void a(PlayerToggleSneakEvent paramPlayerToggleSneakEvent)
	  {
	    Player localPlayer1 = paramPlayerToggleSneakEvent.getPlayer();
	    if ((paramPlayerToggleSneakEvent.isSneaking()) && (KitAPI.Ninja.contains(localPlayer1.getName())) && (a.containsKey(localPlayer1)))
	    {
	      Player localPlayer2 = (Player)a.get(localPlayer1);
	      if ((localPlayer2 != null) && (!localPlayer2.isDead()))
	      {
	        String str = null;
	        if (b.get(localPlayer1) != null)
	        {
	          long l = ((Long)b.get(localPlayer1)).longValue() - System.currentTimeMillis();
	          DecimalFormat localDecimalFormat = new DecimalFormat("##");
	          int i = (int)l / 1000;
	          str = localDecimalFormat.format(i);
	        }
	        if ((b.get(localPlayer1) == null) || (((Long)b.get(localPlayer1)).longValue() < System.currentTimeMillis()))
	        {
	          if (localPlayer1.getLocation().distance(localPlayer2.getLocation()) < 100.0D)
	          {
	            localPlayer1.teleport(localPlayer2.getLocation());
	            localPlayer1.sendMessage("§c§lTeleportado");
	            b.put(localPlayer1, Long.valueOf(System.currentTimeMillis() + 10000L));
	          }
	          else
	          {
	          }
	        }
	        else {
	          localPlayer1.sendMessage(API.sev + "Voce esta em cooldown espera §c" + str + "s");
	        }
	      }
	    }
	  }
	  @EventHandler
	  public void a1(EntityDamageByEntityEvent paramEntityDamageByEntityEvent)
	  {
	    if (((paramEntityDamageByEntityEvent.getDamager() instanceof Player)) && ((paramEntityDamageByEntityEvent.getEntity() instanceof Player)))
	    {
	      final Player localPlayer1 = (Player)paramEntityDamageByEntityEvent.getDamager();
	      Player localPlayer2 = (Player)paramEntityDamageByEntityEvent.getEntity();
	      if (KitAPI.Ajnin.contains(localPlayer1.getName()))
	      {
	        a.put(localPlayer1, localPlayer2);
	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	        {
	          public void run()
	          {
	            cooldownbk.remove(localPlayer1);
	          }
	        }, 200L);
	      }
	    }
	  }
	  
	  @EventHandler
	  public void a1(PlayerToggleSneakEvent paramPlayerToggleSneakEvent)
	  {
	    Player localPlayer1 = paramPlayerToggleSneakEvent.getPlayer();
	    if ((paramPlayerToggleSneakEvent.isSneaking()) && (KitAPI.Ajnin.contains(localPlayer1.getName())) && (a.containsKey(localPlayer1)))
	    {
	      Player localPlayer2 = (Player)a.get(localPlayer1);
	      if ((localPlayer2 != null) && (!localPlayer2.isDead()))
	      {
	        String str = null;
	        if (b.get(localPlayer1) != null)
	        {
	          long l = ((Long)b.get(localPlayer1)).longValue() - System.currentTimeMillis();
	          DecimalFormat localDecimalFormat = new DecimalFormat("##");
	          int i = (int)l / 1000;
	          str = localDecimalFormat.format(i);
	        }
	        if ((b.get(localPlayer1) == null) || (((Long)b.get(localPlayer1)).longValue() < System.currentTimeMillis()))
	        {
	          if (localPlayer1.getLocation().distance(localPlayer2.getLocation()) < 100.0D)
	          {
	            localPlayer2.teleport(localPlayer1.getLocation());
	            localPlayer1.sendMessage("§c§lTeleportado");
	            b.put(localPlayer1, Long.valueOf(System.currentTimeMillis() + 10000L));
	          }
	          else
	          {
	          }
	        }
	        else {
	          localPlayer1.sendMessage(API.sev + "Voce esta em cooldown espera §c" + str + "s");
	        }
	      }
	    }
	  }
	  @EventHandler(priority=EventPriority.MONITOR)
	  public void onPlayerHitAnchor(EntityDamageByEntityEvent e)
	  {
	    if (!(e.getEntity() instanceof Player)) {
	      return;
	    }
	    if (!(e.getDamager() instanceof Player)) {
	      return;
	    }
	    final Player p = (Player)e.getEntity();
	    Player a = (Player)e.getDamager();
	    if (KitAPI.Anchor.contains(p.getName()))
	    {
	      p.setVelocity(new Vector());
	      p.playSound(p.getLocation(), Sound.ZOMBIE_METAL, 4.0F, 4.0F);
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	          p.setVelocity(new Vector());
	        }
	      }, 1L);
	    }
	    if (KitAPI.Anchor.contains(a.getName()))
	    {
	      a.playSound(a.getLocation(), Sound.ZOMBIE_METAL, 4.0F, 4.0F);
	      p.setVelocity(new Vector());
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	          p.setVelocity(new Vector());
	        }
	      }, 1L);
	    }
	  }
	  @EventHandler
	  public void AirMageHAB(PlayerInteractEvent event)
	  {
	    final Player player = event.getPlayer();
	    if ((player.getItemInHand().getType().equals(Material.WOOL)) && (event.getAction().name().contains("RIGHT")))
	    {
	      if (Tempo.add(player))
	      {
	        player.sendMessage(API.sev + "Voce esta em cooldown espera §c" + Tempo.tempo(player) + "s");
	        return;
	      }
	      if (KitAPI.Levitator.contains(event.getPlayer().getName())) {
	        for (Entity target : event.getPlayer().getNearbyEntities(8.0D, 5.0D, 8.0D)) {
	          if ((target instanceof Player))
	          {
	            final Player t = (Player)target;
	            
	            Vector sponge = t.getLocation().getDirection().multiply(0).setY(0.8D);
	            Vector sponge2 = t.getLocation().getDirection().multiply(0).setY(1);
	            Vector sponge22 = t.getLocation().getDirection().multiply(0).setY(1.2D);
	            final Vector sponge222 = t.getLocation().getDirection().multiply(0).setY(1.2D);
	            t.setVelocity(sponge);
	            t.sendMessage(API.sev + "§fVoce esta Levitando!");
	            Tempo.add(player, 20);
	            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	            {
	              public void run()
	              {
	                t.setVelocity(sponge222);
	              }
	            }, 15L);
	            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	            {
	              public void run()
	              {
	                t.setVelocity(sponge222);
	              }
	            }, 15L);
	            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	            {
	              public void run()
	              {
	                t.setVelocity(sponge222);
	              }
	            }, 20L);
	          }
	        }
	      }
	    }
	  }
	  @EventHandler
	  public void interact1(PlayerInteractEvent e)
	  {
		    final Player p = e.getPlayer();
		    if ((e.getPlayer().getItemInHand().getType() == Material.GOLD_HOE) && 
		      (KitAPI.BurstMaster.contains(e.getPlayer().getName())))
		    {
	      if (Tempo.add(p))
	      {
		      p.sendMessage(API.sev + "Voce esta em cooldown espera §c" + Tempo.tempo(p) + "s");
		      return;
	      }
	        e.setCancelled(true);
	        p.updateInventory();
	        Vector velo1 = p.getLocation().getDirection().normalize().multiply(2);
	        final Snowball boladenve = (Snowball)p.launchProjectile(Snowball.class);
	        boladenve.setVelocity(velo1);
	        boladenve.setFireTicks(0);
	        
	        Location location = p.getEyeLocation();
	        BlockIterator blocksToAdd = new BlockIterator(location, 0.0D, 30);
	        
	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	        {
	          public void run()
	          {
	            boladenve.remove();
	          }
	        }, 10L);
	        
	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	        {
	          public void run()
	          {
	            p.getWorld().createExplosion(boladenve.getLocation().add(0.0D, 1.0D, 0.0D), 3.1F);
	          }
	        }, 15L);
	        while (blocksToAdd.hasNext())
	        {
	          Location blockToAdd = blocksToAdd.next().getLocation();
	          Effect a = Effect.STEP_SOUND;
	          
	          p.getWorld().playEffect(blockToAdd, a, 46);
	        }
	        Tempo.add(p, 30);
	      }
	    }
	  @EventHandler
	  public void click(PlayerInteractEntityEvent e)
	  {
	    final Player p = e.getPlayer();
	    if ((e.getRightClicked() instanceof Player))
	    {
	      Player p2 = (Player)e.getRightClicked();
	      ItemStack i = p.getItemInHand();
	      if ((i.getType() == Material.BOOK) && (KitAPI.DeathNote.contains(p.getName())))
	      {
	        e.setCancelled(true);
	        if (Tempo.add(p))
	        {
	          p.sendMessage(API.sev + "Voce esta em cooldown espera §c" + Tempo.tempo(p) + "s");
	          return;
	        }
	        Tempo.add(p, 15);
	        p.sendMessage(ChatColor.GOLD + "Voce escreveu o player " + p2.getName() + " no Death Note!");
	        p2.sendMessage(ChatColor.GOLD + "Seu nome foi escrito no Death Note!!");
	        
	        Random r = new Random();
	        int rand = r.nextInt(100);
	        if (rand > 90)
	        {
	          p2.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 200, 5));
	          p2.sendMessage(ChatColor.GREEN + "Voce esta com poison!");
	        }
	        else if (rand > 80)
	        {
	          p2.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 5));
	          p2.sendMessage(ChatColor.GREEN + "Voce esta com slow!");
	        }
	        else if (rand > 65)
	        {
	          p2.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 5));
	          p2.sendMessage(ChatColor.GREEN + "Voce esta confuso!");
	        }
	        else if (rand > 50)
	        {
	          p2.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 0));
	          p2.sendMessage(ChatColor.GREEN + "Voce esta cego!");
	        }
	        else if (rand > 25)
	        {
	          p2.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 200, 0));
	          p2.sendMessage(ChatColor.GREEN + "Voce esta fraco!");
	        }
	        else
	        {
	          p2.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 200, 5));
	          p2.sendMessage(ChatColor.GREEN + "Voce esta passando mal!");
	        }
	      }
	    }
	  }
	  public int boost = Integer.valueOf(6).intValue();
	  public static ArrayList<String> Deshfire = new ArrayList();
	  static ArrayList<String> fall = new ArrayList();
	  public static HashMap<String, ItemStack[]> Armadura = new HashMap();
	  public static HashMap<String, ItemStack[]> saveinv = new HashMap();
	  public static HashMap<String, ItemStack[]> armadura = new HashMap();
	  public static HashMap<String, ItemStack[]> Armadura2 = new HashMap();
	  @EventHandler
	  public void DeshClick(PlayerInteractEvent event)
	  {
	    int fire = Integer.valueOf(6).intValue();
	    
	    final Player p = event.getPlayer();
	    if ((event.getPlayer().getItemInHand().getType() == Material.REDSTONE_BLOCK) && 
	      (KitAPI.Deshfire.contains(event.getPlayer().getName())))
	    {
	      if ((event.getAction() == Action.LEFT_CLICK_AIR) || 
	        (event.getAction() == Action.LEFT_CLICK_BLOCK) || 
	        (event.getAction() == Action.RIGHT_CLICK_BLOCK) || 
	        (event.getAction() == Action.RIGHT_CLICK_AIR)) {
	        event.setCancelled(true);
	      }
	      if (Tempo.add(p))
	      {
	        p.sendMessage(API.sev + "Voce esta em cooldown espera §c" + Tempo.tempo(p) + "s");
	        return;
	      }
	      Tempo.add(p, 20);
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
	          ((Player)pertos).setFireTicks(fire * 20);
	        }
	      }
	      ItemStack Capacete = new ItemStack(Material.LEATHER_HELMET);
	      LeatherArmorMeta kCapacete = (LeatherArmorMeta)Capacete.getItemMeta();
	      kCapacete.setColor(Color.RED);
	      Capacete.setItemMeta(kCapacete);
	      
	      ItemStack Peitoral = new ItemStack(Material.LEATHER_CHESTPLATE);
	      LeatherArmorMeta kPeitoral = (LeatherArmorMeta)Peitoral.getItemMeta();
	      kPeitoral.setColor(Color.RED);
	      Peitoral.setItemMeta(kPeitoral);
	      
	      ItemStack Calss = new ItemStack(Material.LEATHER_LEGGINGS);
	      LeatherArmorMeta kCalss = (LeatherArmorMeta)Calss.getItemMeta();
	      kCalss.setColor(Color.RED);
	      Calss.setItemMeta(kCalss);
	      
	      ItemStack Bota = new ItemStack(Material.LEATHER_BOOTS);
	      LeatherArmorMeta kBota = (LeatherArmorMeta)Capacete.getItemMeta();
	      kBota.setColor(Color.RED);
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
	          fall.remove(p.getName());
	        }
	      }, 50L);
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
	  public static ArrayList<String> Sonic = new ArrayList();
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
	      if (Tempo.add(p))
	      {
	        p.sendMessage(API.sev + "Voce esta em cooldown espera §c" + Tempo.tempo(p) + "s");
	        return;
	      }
	      Tempo.add(p, 20);
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
	          ((Player)pertos).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 105, 105));
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
	          fall.remove(p.getName());
	        }
	      }, 50L);
	      
	    }
	  }
	  @EventHandler
	  public void onVacuum(PlayerInteractEvent event)
	  {
	    Player p = event.getPlayer();
	    if ((KitAPI.Vaccum.contains(p.getName())) && 
	      (p.getItemInHand().getType().equals(Material.EYE_OF_ENDER))) {
	      for (Entity nearby : p.getNearbyEntities(15.0D, 15.0D, 15.0D))
	      {
	        Entity targetplayer = nearby;
	        if (!(targetplayer instanceof Player)) {
	          return;
	        }
	        if (Tempo.add(p))
	        {
	          p.sendMessage(API.sev + "Voce esta em cooldown espera §c" + Tempo.tempo(p) + "s");
	          return;
	        }
	        Location lc = targetplayer.getLocation();
	        Location to = p.getLocation();
	        
	        lc.setY(lc.getY() + 0.5D);
	        double g = -0.08D;
	        double d = to.distance(lc);
	        double t = d;
	        double v_x = (1.0D + 0.17D * t) * (
	          to.getX() - lc.getX()) / t;
	        double v_y = (1.0D + 0.03D * t) * (to.getY() - lc.getY()) / 
	          t - 0.5D * g * t;
	        double v_z = (1.0D + 0.17D * t) * (
	          to.getZ() - lc.getZ()) / t;
	        Vector v = p.getVelocity();
	        v.setX(v_x);
	        v.setY(v_y);
	        v.setZ(v_z);
	        targetplayer.setVelocity(v);
	        p.sendMessage(API.sev + "Voce esta puxando!");
	        Tempo.add(p, 10);
	      }
	    }
	  }
	  public static ArrayList<String> frozenPlayers = new ArrayList();
	  @EventHandler
	  public static void TIMELORDHAB(PlayerInteractEvent event)
	  {
	    Player player = event.getPlayer();
	    if ((player.getItemInHand().getType().equals(Material.WATCH)) && (event.getAction().name().contains("RIGHT")))
	    {
	      if (Tempo.add(player))
	      {
	        player.sendMessage(API.sev + "Voce esta em cooldown espera §c" + Tempo.tempo(player) + "s");
	        return;
	      }
	      if (KitAPI.TimeLord.contains(event.getPlayer().getName())) {
	        for (Entity target : event.getPlayer().getNearbyEntities(5.0D, 5.0D, 5.0D)) {
	          if ((target instanceof Player))
	          {
	            Player t = (Player)target;
	            frozenPlayers.add(t.getName());
	            player.sendMessage(API.sev + "Voce congelou os jogadores a 5 blocos ao seu redor!");
	            t.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 5));
	            Tempo.add(player, 30);
	            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	            {
	              public void run()
	              {
	                frozenPlayers.remove(t.getName());
	                t.sendMessage(ChatColor.GREEN + "Efeito cabou e.e");
	              }
	            }, 150L);
	          }
	        }
	      }
	    }
	  }
	  
	  @EventHandler
	  public void TIMELORDMOVEALVO(PlayerMoveEvent e)
	  {
	    if (frozenPlayers.contains(e.getPlayer().getName())) {
	      e.getPlayer().teleport(e.getPlayer());
	    }
	  }
	  @EventHandler
	  public void Blood1lick(PlayerInteractEvent event)
	  {
	    final Player p = event.getPlayer();
	    if ((event.getPlayer().getItemInHand().getType() == Material.LEASH) && 
	      (KitAPI.Thresh.contains(event.getPlayer().getName())))
	    {
	      if ((event.getAction() == Action.LEFT_CLICK_AIR) || 
	        (event.getAction() == Action.LEFT_CLICK_BLOCK)) {
	        event.setCancelled(true);
	      }
	      if (Tempo.add(p))
	      {
	        p.sendMessage(API.sev + "Voce esta em cooldown espera §c" + Tempo.tempo(p) + "s");
	      }
	      else
	      {
	        Vector velo1 = p.getLocation().getDirection().normalize().multiply(30);
	        Snowball boladenve = (Snowball)p.launchProjectile(Snowball.class);
	        boladenve.setVelocity(velo1);
	        Location location = p.getEyeLocation();
	        BlockIterator blocksToAdd = new BlockIterator(location, 0.0D, 30);
	        while (blocksToAdd.hasNext())
	        {
	          Location blockToAdd = blocksToAdd.next().getLocation();
	          Effect a = Effect.STEP_SOUND;
	          p.getWorld().playEffect(blockToAdd, Effect.SMOKE, 5);
	          Tempo.add(p, 10);
	        }
	      }
	    }
	  }
	  
	  @EventHandler
	  public void DanoOstenta$aum(EntityDamageByEntityEvent e)
	  {
	    Entity ent = e.getEntity();
	    Entity damager = e.getDamager();
	    if ((ent instanceof Player))
	    {
	      Player hit = (Player)ent;
	      if ((damager instanceof Snowball))
	      {
	        Snowball snowball = (Snowball)damager;
	        if ((snowball.getShooter() instanceof Player))
	        {
	          Player shooter = (Player)snowball.getShooter();
	          if (!KitAPI.Thresh.contains(shooter.getName())) {
	            return;
	          }
	          Location ploc = shooter.getLocation();Location hitloc = hit.getLocation();
	          hit.teleport(ploc);
	          hit.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 1));
	          hit.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 1));
	        }
	      }
	    }
	  }
	  @EventHandler
	  public void Blood1li12ck(PlayerInteractEvent event)
	  {
	    final Player p = event.getPlayer();
	    if ((event.getPlayer().getItemInHand().getType() == Material.FIREBALL) && 
	      (KitAPI.Teleman.contains(event.getPlayer().getName())))
	    {
	      if ((event.getAction() == Action.LEFT_CLICK_AIR) || 
	        (event.getAction() == Action.LEFT_CLICK_BLOCK)) {
	        event.setCancelled(true);
	      }
	      if (Tempo.add(p))
	      {
	        p.sendMessage(API.sev + "Voce esta em cooldown espera §c" + Tempo.tempo(p) + "s");
	      }
	      else
	      {
	        Vector velo1 = p.getLocation().getDirection().normalize().multiply(30);
	        Snowball boladenve = (Snowball)p.launchProjectile(Snowball.class);
	        boladenve.setVelocity(velo1);
	        Location location = p.getEyeLocation();
	        BlockIterator blocksToAdd = new BlockIterator(location, 0.0D, 30);
	        while (blocksToAdd.hasNext())
	        {
	          Location blockToAdd = blocksToAdd.next().getLocation();
	          Effect a = Effect.STEP_SOUND;
	          p.getWorld().playEffect(blockToAdd, Effect.SMOKE, 5);
	          Tempo.add(p, 10);
	        }
	      }
	    }
	  }
	  
	  @EventHandler
	  public void DanoOstenta423532$aum(EntityDamageByEntityEvent e)
	  {
	    Entity ent = e.getEntity();
	    Entity damager = e.getDamager();
	    if ((ent instanceof Player))
	    {
	      Player hit = (Player)ent;
	      if ((damager instanceof Snowball))
	      {
	        Snowball snowball = (Snowball)damager;
	        if ((snowball.getShooter() instanceof Player))
	        {
	          Player shooter = (Player)snowball.getShooter();
	          if (!KitAPI.Teleman.contains(shooter.getName())) {
	            return;
	          }
	          Location ploc = shooter.getLocation();
	          Location hitloc = hit.getLocation();
	          shooter.teleport(hit);
	        }
	      }
	    }
	  }
}
