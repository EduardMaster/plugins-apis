package Net.Hunger.Habilidades;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import Net.Hunger.Main;
import Net.Hunger.Manager.Habilidade;

public class Frozen implements Listener {
	
  @EventHandler
  public void onFrozenBreak(PlayerInteractEvent e) {
    Player p = e.getPlayer();
    if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
     Block b = e.getClickedBlock();
     if((Habilidade.getAbility(p).equalsIgnoreCase("frozen")) && (b.getType().equals(Material.PACKED_ICE))) {
     b.setType(Material.AIR);
     }
    }
  }
  
  @EventHandler
  public void onFrozenBlock(PlayerMoveEvent event) {
     if ((event.getFrom().getBlockX() == event.getTo().getBlockX()) && (event.getFrom().getBlockZ() == event.getTo().getBlockZ()) && (event.getFrom().getBlockY() == event.getTo().getBlockY())) {
     return;
     }
	if((Main.Partida)) {
    Player player = event.getPlayer();
    if((Habilidade.getAbility(player).equalsIgnoreCase("frozen"))) {
      Block b = player.getLocation().getBlock();
      if (b.getY() >= 64) {
        Location z = b.getLocation();
        z.setY(z.getY() - 1.0D);
        Block d = z.getBlock();
        if (((d.getType().equals(Material.GRASS)) || (d.getType().equals(Material.SAND)) || (d.getType().equals(Material.DIRT)) || (d.getType().equals(Material.STONE))) &&  (b.getType().equals(Material.AIR))) {
        b.setType(Material.SNOW);
        }
      }
    }
  }
  }
  public void setIt(Block block)
  {
    if (block.getType().equals(Material.AIR)) {
      block.setType(Material.PACKED_ICE);
    }
  }
  
  @EventHandler
  public void onFrozen(PlayerMoveEvent event) {
    if ((event.getFrom().getBlockX() == event.getTo().getBlockX()) && (event.getFrom().getBlockZ() == event.getTo().getBlockZ()) && (event.getFrom().getBlockY() == event.getTo().getBlockY())) {
      return;
    }
    Player player = event.getPlayer();
	if((Main.Partida)) {
    if (Habilidade.getAbility(player).equalsIgnoreCase("frozen") && (player.getItemInHand().getType().equals(Material.SNOW_BALL))) {
       player.getItemInHand().setAmount(player.getItemInHand().getAmount() - 1);
      if(event.getPlayer().getLocation().getY() <= 120) {
      Location loc = player.getLocation();
      double locy = loc.getY() - 1.0D;
      loc.setY(locy);
      Block block = loc.getBlock();
      block.setType(Material.PACKED_ICE);
      setIt(block.getRelative(BlockFace.WEST));
      setIt(block.getRelative(BlockFace.EAST));
      setIt(block.getRelative(BlockFace.NORTH));
      setIt(block.getRelative(BlockFace.SOUTH));
      setIt(block.getRelative(BlockFace.WEST).getRelative(BlockFace.NORTH));
      setIt(block.getRelative(BlockFace.WEST).getRelative(BlockFace.SOUTH));
      setIt(block.getRelative(BlockFace.EAST).getRelative(BlockFace.NORTH));
      setIt(block.getRelative(BlockFace.EAST).getRelative(BlockFace.SOUTH));
     } else {
     return;
     }
    }
   }
  }
}