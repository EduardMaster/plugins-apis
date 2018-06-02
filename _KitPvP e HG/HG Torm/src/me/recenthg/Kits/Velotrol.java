package me.recenthg.Kits;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.util.Vector;

import me.recenthg.Main;
import me.recenthg.Manager.Habilidade;
import me.recenthg.Utils.Estado;

@SuppressWarnings("unused")
public class Velotrol
  implements CommandExecutor, Listener
{
   
  public static ArrayList<Player> Cooldown = new ArrayList<Player>();
  HashMap<String, Location> Bloco = new HashMap<String, Location>();
  
  @EventHandler
  public void SonicClick(PlayerInteractEvent event)
  {
    final Player p = event.getPlayer();
    if (Main.estados == Estado.ANDAMENTO)
    if ((Habilidade.getAbility(p).equalsIgnoreCase("velotrol")))
    if ((event.getPlayer().getItemInHand().getType() == Material.MINECART))
    {
      if ((event.getAction() == Action.LEFT_CLICK_AIR) || 
        (event.getAction() == Action.LEFT_CLICK_BLOCK) || 
        (event.getAction() == Action.RIGHT_CLICK_BLOCK) || 
        (event.getAction() == Action.RIGHT_CLICK_AIR)) {
        event.setCancelled(true);
      }
      if (Cooldown.contains(p))
      {
        p.sendMessage("§8\u276e§4§l!§8\u276f §7Kit em Cooldown!");
        return;
      }
      Cooldown.add(p);
      final Item VelotrolItem = p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.SOUL_SAND));
      VelotrolItem.setMetadata("velotrol", new FixedMetadataValue(Main.instance, p.getName()));
      
      Vector Vector = p.getEyeLocation().getDirection();
      Vector.multiply(0.8D);
      Vector.setY(0.3D);
      p.setVelocity(Vector);
      VelotrolItem.setVelocity(Vector);
      
      VelotrolItem.setPassenger(p);
      
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
      {
        public void run()
        {
          VelotrolItem.teleport(p.getLocation());
          VelotrolItem.teleport(p.getLocation());
          VelotrolItem.remove();
        }
      }, 20L);
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
      {
        public void run()
        {
          Velotrol.this.Bloco.put(p.getName(), p.getLocation());
          Location Loc = new Location(p.getWorld(), ((Location)Velotrol.this.Bloco.get(p.getName())).getX(), ((Location)Velotrol.this.Bloco.get(p.getName())).getY() + 1.0D, ((Location)Velotrol.this.Bloco.get(p.getName())).getZ());
          Location Loc1 = new Location(p.getWorld(), ((Location)Velotrol.this.Bloco.get(p.getName())).getX(), ((Location)Velotrol.this.Bloco.get(p.getName())).getY() + 2.0D, ((Location)Velotrol.this.Bloco.get(p.getName())).getZ());
          Block Bloco = Loc.getBlock();
          Bloco.setType(Material.SKULL);
        
        }
      }, 30L);
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
      {
        public void run()
        {
          VelotrolItem.removeMetadata("velotrol", Main.instance);
        }
      }, 40L);
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
      {
        public void run()
        {
          Location Explosao = (Location)Velotrol.this.Bloco.get(p.getName());
          p.getWorld().createExplosion(Explosao, 5.0F);
          Location Loc = new Location(p.getWorld(), ((Location)Velotrol.this.Bloco.get(p.getName())).getX(), ((Location)Velotrol.this.Bloco.get(p.getName())).getY() + 1.0D, ((Location)Velotrol.this.Bloco.get(p.getName())).getZ());
          Block Bloco = Loc.getBlock();
          Bloco.setType(Material.AIR);
        }
      }, 60L);
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
      {
        public void run()
        {
          Cooldown.remove(p);
          p.sendMessage("§8\u276e§4§l!§8\u276f §7Voce pode usar novamente!");
      	 p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 4.0F, 4.0F);
          Velotrol.this.Bloco.remove(p.getName());
        }
      }, 600L);
    }
  }
  
  @EventHandler
  public void PickupVelotrol(PlayerPickupItemEvent e)
  {
    if (e.getItem().hasMetadata("velotrol")) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void idknow(EntityDamageEvent e)
  {
    if ((e.getEntity() instanceof Player))
    {
      Player p = (Player)e.getEntity();
      if (e.getCause() != EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {
        return;
      }
        e.setCancelled(true);
      }
    }
  

@Override
public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
	// TODO Auto-generated method stub
	return false;
}
}