package Jumps;

import java.util.ArrayList;
import Main.Main;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

@SuppressWarnings("unused")
public class Ferro
  implements Listener
{
  public static Main plugin;
  
  public Ferro(Main main)
  {
    plugin = main;
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
public static ArrayList<String> Ferro = new ArrayList();
  
  @EventHandler(priority=EventPriority.MONITOR)
  public void onPlayerJump1(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.IRON_BLOCK)
    {
      Ferro.remove(p.getName());
      Location loc = e.getTo().getBlock().getLocation();
      Vector sponge = p.getLocation().getDirection().multiply(0).setY(2);
      p.setVelocity(sponge);
      p.playSound(loc, Sound.ANVIL_BREAK, 6.0F, 1.0F);
      p.playEffect(loc, Effect.ENDER_SIGNAL, null);
      Ferro.add(p.getName());
      return;
    }
  }
  
  @EventHandler
  public void onFall(EntityDamageEvent e)
  {
    if ((e.getEntity() instanceof Player))
    {
      Player p = (Player)e.getEntity();
      if ((e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) && 
        (Ferro.contains(p.getName())))
      {
        e.setCancelled(true);
        Ferro.remove(p.getName());
      }
    }
  }
}
