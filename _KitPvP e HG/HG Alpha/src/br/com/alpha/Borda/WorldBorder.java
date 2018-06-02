package br.com.alpha.Borda;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

import br.com.alpha.MCAlpha;
import br.com.alpha.gamemanagement.GameTime;

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
    shed_id = Integer.valueOf(Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(MCAlpha.mcAlpha, new Runnable() {
	@SuppressWarnings("deprecation")
	public void run() {
        for (Player p : Bukkit.getOnlinePlayers())
          if (!inBorder(p.getLocation(), BorderType.STOP)) {
            p.sendMessage("§6§l!! §7Você esta no forcefield!");
            if(MCAlpha.Status == GameTime.PREGAME) {
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
            if ((MCAlpha.Status == GameTime.PREGAME) && (!inBorder(p.getLocation(), BorderType.WARN))) {
              p.sendMessage("§6§l!! §7Você esta perto do forcefield!");
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