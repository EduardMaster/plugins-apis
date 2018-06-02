package Net.Hunger.Habilidades;

import java.util.ArrayList;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import Net.Hunger.Main;

public class Launcher implements Listener{
	
   public Main plugin;	
   public Launcher(Main plugin) {
   this.plugin = plugin;
   }
   
   protected ArrayList<String> dano = new ArrayList<String>();

  @SuppressWarnings("deprecation")
  @EventHandler
  public void onPlayerMove(PlayerMoveEvent event){
    Player player = event.getPlayer();
    Location standBlock = player.getWorld().getBlockAt(player.getLocation().add(0.0D, -0.01D, 0.0D)).getLocation();
    if (standBlock.getBlock().getType() == Material.SPONGE) {
      int xblock = 0;
      double xvel = 0.0D;
      int yblock = -1;
      double yvel = 0.0D;
      int zblock = 0;
      double zvel = 0.0D;
      while (standBlock.getBlock().getLocation()
        .add(xblock - 1, -1.0D, 0.0D).getBlock().getType() == Material.SPONGE) {
        xblock--;
        xvel += 1.0D;
      }
      while (standBlock.getBlock().getLocation().add(0.0D, yblock, 0.0D).getBlock().getType() == Material.SPONGE) {
        yblock--;
        yvel += 0.7D;
      }
      while (standBlock.getBlock().getLocation()
        .add(0.0D, -1.0D, zblock - 1).getBlock().getType() == Material.SPONGE) {
        zblock--;
        zvel += 1.0D;
      }
      xblock = 0;
      zblock = 0;
      while (standBlock.getBlock().getLocation()
        .add(xblock + 1, -1.0D, 0.0D).getBlock().getType() == Material.SPONGE) {
        xblock++;
        xvel -= 1.0D;
      }
      while (standBlock.getBlock().getLocation()
        .add(0.0D, -1.0D, zblock + 1).getBlock().getType() == Material.SPONGE) {
        zblock++;
        zvel -= 1.0D;
      }
      if ((xvel != 0.0D) || (yvel != 0.0D) || (zvel != 0.0D)) {
        player.setVelocity(new Vector(xvel, yvel, zvel));
        player.playSound(player.getLocation(), Sound.ENDERDRAGON_HIT, 5.0F, -5.0F);
        player.playEffect(player.getLocation(), Effect.SMOKE, 10);
        if (!dano.contains(player.getName())) {
            dano.add(player.getName());
        }
      }
    }
  } 
@EventHandler
  public void onEntityDamage(EntityDamageEvent event) {
    if ((event.getEntity() instanceof Player)) {
      Player player = (Player)event.getEntity();

      if ((dano.contains(player.getName())) && (event.getCause().equals(EntityDamageEvent.DamageCause.FALL))) {
        event.setCancelled(true);
        dano.remove(player.getName());
      }
    }
  }
}