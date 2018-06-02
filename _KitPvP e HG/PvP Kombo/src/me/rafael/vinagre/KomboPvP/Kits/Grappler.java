package me.rafael.vinagre.KomboPvP.Kits;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.FireworkEffect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerLeashEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;

public class Grappler 
implements Listener, CommandExecutor
{
	  public static Main plugin;
	  
	  public Grappler(Main main)
	  {
	    plugin = main;
	  }
	  
	  Map<Player, CordaGrappler> hooks = new HashMap();
	  
	  @EventHandler
	  public void onSlot(PlayerItemHeldEvent e)
	  {
	    if (this.hooks.containsKey(e.getPlayer()))
	    {
	      ((CordaGrappler)this.hooks.get(e.getPlayer())).remove();
	      this.hooks.remove(e.getPlayer());
	    }
	  }
	  
	  @EventHandler
	  public void grapplerDamageNoLeash(EntityDamageEvent event)
	  {
	    if (!(event.getEntity() instanceof Player)) {
	      return;
	    }
	    Player player = (Player)event.getEntity();
	    if (event.getCause() != EntityDamageEvent.DamageCause.FALL) {
	      return;
	    }
	    if ((this.hooks.containsKey(player)) && 
	      (((CordaGrappler)this.hooks.get(player)).isHooked()) && 
	      (event.getDamage() > 3.0D)) {
	      event.setDamage(3.0D);
	    }
	  }
	  
	  @EventHandler
	  public void onMove(PlayerMoveEvent e)
	  {
	    if ((this.hooks.containsKey(e.getPlayer())) && 
	      (!e.getPlayer().getItemInHand().getType().equals(Material.LEASH)))
	    {
	      ((CordaGrappler)this.hooks.get(e.getPlayer())).remove();
	      this.hooks.remove(e.getPlayer());
	    }
	  }
	  
	  @EventHandler
	  public void onLeash(PlayerLeashEntityEvent e)
	  {
	    Player p = e.getPlayer();
	    if (e.getPlayer().getItemInHand().getType().equals(Material.LEASH))
	    {
	      e.setCancelled(true);
	      e.getPlayer().updateInventory();
	      e.setCancelled(true);
	      if (!this.hooks.containsKey(p)) {
	        return;
	      }
	      if (!((CordaGrappler)this.hooks.get(p)).isHooked()) {
	        return;
	      }
	      double d = ((CordaGrappler)this.hooks.get(p)).getBukkitEntity()
	        .getLocation().distance(p.getLocation());
	      double t = d;
	      double v_x = (1.0D + 0.07D * t) * (
	        ((CordaGrappler)this.hooks.get(p)).getBukkitEntity()
	        .getLocation().getX() - p.getLocation().getX()) / t;
	      double v_y = (1.0D + 0.03D * t) * (
	        ((CordaGrappler)this.hooks.get(p)).getBukkitEntity()
	        .getLocation().getY() - p.getLocation().getY()) / t;
	      double v_z = (1.0D + 0.07D * t) * (
	        ((CordaGrappler)this.hooks.get(p)).getBukkitEntity()
	        .getLocation().getZ() - p.getLocation().getZ()) / t;
	      
	      Vector v = p.getVelocity();
	      v.setX(v_x);
	      v.setY(v_y);
	      v.setZ(v_z);
	      p.setVelocity(v);
	    }
	  }
	  
	  @EventHandler
	  public void onClick(PlayerInteractEvent e)
	  {
	    Player p = e.getPlayer();
	    if (e.getPlayer().getItemInHand().getType().equals(Material.LEASH) && (Array.kit.get(p) == "Grappler"))
	    {
	      e.setCancelled(true);
	      if ((e.getAction() == Action.LEFT_CLICK_AIR) || 
	        (e.getAction() == Action.LEFT_CLICK_BLOCK))
	      {
	        if (this.hooks.containsKey(p)) {
	          ((CordaGrappler)this.hooks.get(p)).remove();
	        }
	        CordaGrappler nmsHook = new CordaGrappler(p.getWorld(), 
	          ((CraftPlayer)p).getHandle());
	        nmsHook.spawn(p.getEyeLocation().add(
	          p.getLocation().getDirection().getX(), 
	          p.getLocation().getDirection().getY(), 
	          p.getLocation().getDirection().getZ()));
	        nmsHook.move(p.getLocation().getDirection().getX() * 5.0D, p
	          .getLocation().getDirection().getY() * 5.0D, p
	          .getLocation().getDirection().getZ() * 5.0D);
	        this.hooks.put(p, nmsHook);
	      }
	      else
	      {
	        if (!this.hooks.containsKey(p)) {
	          return;
	        }
	        if (!((CordaGrappler)this.hooks.get(p)).isHooked()) {
	          return;
	        }
	        double d = ((CordaGrappler)this.hooks.get(p))
	          .getBukkitEntity().getLocation()
	          .distance(p.getLocation());
	        double t = d;
	        double v_x = (1.0D + 0.2D * t) * (
	          ((CordaGrappler)this.hooks.get(p))
	          .getBukkitEntity().getLocation().getX() - p
	          .getLocation().getX()) / t;
	        double v_y = (1.0D + 0.03D * t) * (
	          ((CordaGrappler)this.hooks.get(p))
	          .getBukkitEntity().getLocation().getY() - p
	          .getLocation().getY()) / t;
	        double v_z = (1.0D + 0.2D * t) * (
	          ((CordaGrappler)this.hooks.get(p))
	          .getBukkitEntity().getLocation().getZ() - p
	          .getLocation().getZ()) / t;
	        
	        Vector v = p.getVelocity();
	        v.setX(v_x);
	        v.setY(v_y);
	        v.setZ(v_z);
	        p.setVelocity(v);
	      }
	    }
	  }
	  
	  @EventHandler
	  public void onTomarDano(EntityDamageEvent event)
	  {
	    Entity e = event.getEntity();
	    if ((e instanceof Player))
	    {
	      Player player = (Player)e;
	      if (((event.getEntity() instanceof Player)) && 
	        (event.getCause() == EntityDamageEvent.DamageCause.FALL) && 
	        (player.getInventory().contains(Material.LEASH)) && 
	        (event.getDamage() >= 12.0D)) {
	        event.setDamage(12.0D);
	      }
	    }
	  }
	  
	  public void playFirework(World paramWorld, Location paramLocation, FireworkEffect paramFireworkEffect)
	    throws Exception
	  {
	    throw new Error("");
	  }
	  
	  private static Method getMethod(Class<?> cl, String method)
	  {
	    Method[] arrayOfMethod;
	    int j = (arrayOfMethod = cl.getMethods()).length;
	    for (int i = 0; i < j; i++)
	    {
	      Method m = arrayOfMethod[i];
	      if (m.getName().equals(method)) {
	        return m;
	      }
	    }
	    return null;
	  }
	  public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args)
	  {
	    Player p = (Player)sender;
	    ItemStack dima = new ItemStack(Material.STONE_SWORD);
	    ItemMeta souperaa = dima.getItemMeta();
	    souperaa.setDisplayName("§cEspada");
	    dima.setItemMeta(souperaa);
	    ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
	    ItemMeta sopas = sopa.getItemMeta();
	    sopas.setDisplayName("§6Sopa");
	    sopa.setItemMeta(sopas);
	    ItemStack especial = new ItemStack(Material.LEASH);
	    ItemMeta especial1 = especial.getItemMeta();
	    especial1.setDisplayName("§bGrappler");
	    especial.setItemMeta(especial1);
	    
	    ItemStack capacete0 = new ItemStack(Material.AIR);
	    
	    ItemStack peitoral0 = new ItemStack(Material.AIR);
	    
	    ItemStack calca0 = new ItemStack(Material.AIR);
	    
	    ItemStack Bota0 = new ItemStack(Material.AIR);
	    
	    p.getInventory().setHelmet(capacete0);
	    p.getInventory().setChestplate(peitoral0);
	    p.getInventory().setLeggings(calca0);
	    p.getInventory().setBoots(Bota0);
	    
	    if (cmd.equalsIgnoreCase("grappler")) {
	      if (Array.used.contains(p.getName())) {
	    	  p.sendMessage("§7» §cVoce ja esta usando um kit!");
	        return true;
	      }
	      if (!p.hasPermission("kitpvp.kit.grappler")) {
		      p.sendMessage("§cVoce nao tem permissao para usar este kit !");
	        return true;
	      }
	      Array.used.add(p.getName());
	      p.sendMessage("§7» Voce escolheu o kit §cGrappler §7!");
	      p.setGameMode(GameMode.ADVENTURE);
	      p.getInventory().clear();
	      Array.kit.put(p, "Grappler");
	      Main.Dj.remove(p.getName());
	      Main.stomper.remove(p.getName());
	      
	      Scoreboard.ScoreDoBasic.iscoriboard(p);
	      p.getInventory().addItem(new ItemStack[] { dima });
	      p.getInventory().addItem(new ItemStack[] { especial });
	      Main.give(p);
	      for (int i = 0; i <= 34; i++) {
	        p.getInventory().addItem(new ItemStack[] { sopa });
	        
	      }
	    }
	    me.rafael.vinagre.KomboPvP.Comandos.SetArena.TeleportArenaRandom(p);
	    return false;
	  }
}