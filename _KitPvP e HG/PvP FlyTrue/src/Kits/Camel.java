package Kits;
import Utils.KitAPI;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Camel
  implements Listener
{  
  @EventHandler
  public void onPlayerCamel(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    if (((e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SAND) || (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SANDSTONE)) && 
      (KitAPI.getKit(p) == "Camel"))
    {
      p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 120, 1));
      p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 120, 0));
      return;
    }
  }
}