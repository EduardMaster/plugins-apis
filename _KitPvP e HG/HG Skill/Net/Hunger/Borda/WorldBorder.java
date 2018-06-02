package Net.Hunger.Borda;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

import Net.Hunger.Main;

public class WorldBorder {
	
  private static Integer shed_id = null;
  private static HashMap<Player, Location> locations = new HashMap<Player, Location>();
  public static HashMap<BorderType, Border> BORDERS = new HashMap<BorderType, Border>();

	
  private static boolean inBorderCheck(Location checkHere, BorderType t) {
  if (!BORDERS.containsKey(t))
  return true;
  Border border = (Border)BORDERS.get(t);
  if (checkHere.getX() > border.radius)
  return false;
  if (checkHere.getZ() > border.radius)
  return false;
  if (checkHere.getX() < -border.radius)
  return false;
  if (checkHere.getZ() < -border.radius) {
  return false;
  }
  return true;
  }
  
  public static boolean inBorder(Location c, BorderType t) {
  if (t == BorderType.STOP) {
  return inBorderCheck(c, BorderType.STOP);
  }
  if (t == BorderType.WARN) {
  if ((!inBorderCheck(c, BorderType.WARN)) && (inBorderCheck(c, BorderType.STOP))) { 
  return false;
  }
  return true; 
  }
  if (t == BorderType.SHRINK) {
  if (BORDERS.containsKey(BorderType.SHRINK)) { 
  return inBorderCheck(c, BorderType.SHRINK);
  }
  return true;
  }
  return true;
  }
  
  public static void WorldBorderMove() {
    shed_id = Integer.valueOf(Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.instance, new Runnable() {
	public void run() {
        for (Player p : Bukkit.getOnlinePlayers())
          if (!inBorder(p.getLocation(), BorderType.STOP)) {
            p.sendMessage("§a§l!! §7Você esta no forcefield!");
            if(Main.PreGame) {
              if (p.isInsideVehicle()) {
              p.getVehicle().eject();
              }
              if ((WorldBorder.locations.containsKey(p)) && (inBorder((Location)WorldBorder.locations.get(p), BorderType.STOP))) {
                p.teleport((Location)WorldBorder.locations.get(p));
              }
            }  else {
              EntityDamageEvent entitydamage = new EntityDamageEvent(p, EntityDamageEvent.DamageCause.CUSTOM, 4.0D);
              if ((entitydamage instanceof Player)) {
              ((Player)entitydamage.getEntity()).damage(4.0D);
              }
              Bukkit.getPluginManager().callEvent(entitydamage);
            }
          } else {
            if ((Main.PreGame) && (!inBorder(p.getLocation(), BorderType.WARN))) {
              p.sendMessage("§a§l!! §7Você esta perto do forcefield!");
            }
          }
      }
    }, 0L, 20L));
  }
  public static void cancel() {
    if (shed_id != null) {
      Bukkit.getServer().getScheduler().cancelTask(shed_id.intValue());
      shed_id = null;
    }
  }
}