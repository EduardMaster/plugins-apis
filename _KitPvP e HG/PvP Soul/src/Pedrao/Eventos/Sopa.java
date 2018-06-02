package Pedrao.Eventos;

import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Pedrao.Main;

public class Sopa
  implements Listener
{
  public Sopa(Main main) {}
  
  @SuppressWarnings("deprecation")
@EventHandler 
  public void onSoup(PlayerInteractEvent e)
  {
    ItemStack pote = new ItemStack(Material.BOWL, 1);
    ItemMeta kpote = pote.getItemMeta();
    pote.setItemMeta(kpote);
    Player p = e.getPlayer();
    Damageable hp = p;
    if (hp.getHealth() != 20.0D)
    {
      int sopa = 7;
      if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && (p.getItemInHand().getTypeId() == 282))
      {
        p.setHealth(hp.getHealth() + sopa > hp.getMaxHealth() ? hp.getMaxHealth() : hp.getHealth() + sopa);
        p.getItemInHand().setType(Material.BOWL);
        p.getItemInHand().setItemMeta(kpote);
        p.getItemInHand().setType(Material.BOWL);
      }
    }
  }
}
