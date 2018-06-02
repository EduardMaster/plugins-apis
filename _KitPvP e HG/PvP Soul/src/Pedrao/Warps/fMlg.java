package Pedrao.Warps;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import Pedrao.Main;

public class fMlg
  implements Listener
{
  Main plugin;
  
  public fMlg(Main plugin)
  {
    this.plugin = plugin;
  }
  
  @SuppressWarnings("deprecation")
@EventHandler
  public void Mlg(PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    Action a = e.getAction();
    Block b = e.getClickedBlock();
    if ((p.getItemInHand().getType() == Material.WATER_BUCKET) && (a == Action.RIGHT_CLICK_BLOCK))
    {
      int x = b.getX();
      int y = b.getY() + 1;
      int z = b.getZ();
      
      final Location water = new Location(Bukkit.getWorld("world"), x, y, z);
      if (Bukkit.getWorld("world").getBlockAt(water).getType() != Material.AIR)
      {
        p.sendMessage(Main.prefix + "Voce nao pode fazer MLG aqui!");
        e.setCancelled(true);
      }
      else
      {
        Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(this.plugin, new Runnable()
        {
          public void run()
          {
            Bukkit.getWorld("mlg.world").getBlockAt(water).setType(Material.AIR);
            p.sendMessage(Main.prefix + "§7Parabens voce §6acertou!");
            p.chat("/mlg");
          }
        }, 10L);
      }
    }
  }
}
