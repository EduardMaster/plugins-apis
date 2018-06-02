package me.recenthg.Eventss;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.recenthg.Main;
import me.recenthg.CMDS.Admin;
import me.recenthg.Utils.Estado;

public class Compass
  implements Listener
{
  @EventHandler
  public void onCompass(PlayerInteractEvent event)
  {
    Player p = event.getPlayer();
    if ((p.getItemInHand().getType() == Material.COMPASS) && ((event.getAction() == Action.LEFT_CLICK_AIR) || (event.getAction() == Action.LEFT_CLICK_BLOCK) || (event.getAction() == Action.RIGHT_CLICK_BLOCK) || (event.getAction() == Action.RIGHT_CLICK_AIR)))
    {
      if (Main.estados == Estado.INVENCIBILIDADE)
      {
        p.sendMessage(Main.Menssagems + "§7A Bussola Esta Desativada na §aInvencibilidade!");
        return;
      }
          if (Main.estados == Estado.INICIANDO)
          {
            p.sendMessage(Main.Menssagems + "§7A Bussola Esta Desativada no §aPregame!");
            return;
          }
      Boolean found = Boolean.valueOf(false);
      for (int i = 0; i < 1000; i++)
      {
        List<?> entities = p.getNearbyEntities(i, 128.0D, i);
        for (Object e : entities) {
          if ((((Entity)e).getType().equals(EntityType.PLAYER)) && (p.getLocation().distance(((Entity)e).getLocation()) > 25.0D) && 
            (!Admin.admin.contains((Player)e)) && (!Main.Watch.contains(((Player)e).getName())))
          {
            p.setCompassTarget(((Entity)e).getLocation());
            p.sendMessage(Main.Menssagems + "§7Bussola apontando Para - §a" + ((Player)e).getDisplayName());
            found = Boolean.valueOf(true);
            break;
          }
        }
        if (found.booleanValue()) {
          break;
        }
      }
      if (!found.booleanValue())
      {
        p.sendMessage(Main.Menssagems + "§7Nenhum Jogador Encontrado");
        p.setCompassTarget(new Location(p.getWorld(), 0.0D, 120.0D, 0.0D));
        if (Main.estados == Estado.INVENCIBILIDADE)
        {
          return;
        }
      }
    }
  }
}
