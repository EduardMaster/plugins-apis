package Kits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import Main.Main;
import Utils.Array;

public class C4L
  implements Listener
{
  @SuppressWarnings({ "unchecked", "rawtypes" })
private ArrayList<Player> cooldown = new ArrayList();
  public static Main plugin;
  @SuppressWarnings({ "unchecked", "rawtypes" })
private Map<Player, Item> inbomb = new HashMap();
  
  public C4L(Main main)
  {
    plugin = main;
  }
  
  @EventHandler
  public void a(PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    if (p.getItemInHand().getType() == Material.AIR) {
      return;
    }
    if (p.getInventory().getItemInHand().getType() != Material.SLIME_BALL) {
      return;
    }
    if (e.getAction().name().contains("RIGHT"))
    {
      if ((this.inbomb.containsKey(p)) && 
        (Array.C4.contains(p.getName()))) {
        return;
      }
      if (this.cooldown.contains(p))
      {
        p.sendMessage("§7[§c!§7]§c Cooldown §7[§c!§7]");
        return;
      }
      Item C4bomb = p.getWorld().dropItem(p.getEyeLocation(), new ItemStack(Material.TNT));
      C4bomb.setVelocity(e.getPlayer().getEyeLocation().getDirection().multiply(0.6D));
      C4bomb.setPickupDelay(999999);
      C4bomb.getItemStack().getItemMeta().setDisplayName("§a§oC4");
      this.inbomb.put(p, C4bomb);
      this.cooldown.add(p);
    }
    else if (this.inbomb.containsKey(p))
    {
      Item C4bomb = (Item)this.inbomb.get(p);
      p.getWorld().createExplosion(C4bomb.getLocation(), 3.0F, true);
      this.inbomb.remove(p);
      C4bomb.remove();
      Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
      {
        public void run()
        {
          C4L.this.cooldown.remove(p);
          p.sendMessage("§7[§c!§7]§a Você ja pode usar novamente seu C4! §7[§c!§7]");
        }
      }, 1000L);
    }
    else
    {
      p.sendMessage("§7[§c!§7]§c A Bomba Ainda Não Foi Plantada §7[§c!§7]");
    }
  }
}
