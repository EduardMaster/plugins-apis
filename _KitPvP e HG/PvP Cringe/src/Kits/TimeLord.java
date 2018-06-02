package Kits;

import java.util.ArrayList;
import Main.Main;
import Utils.KitAPI;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
public class TimeLord
  implements Listener
{
  public static ArrayList<String> freeze = new ArrayList<>();
  public static ArrayList<String> freezing = new ArrayList<>();
  public ArrayList<String> frozenPlayers = new ArrayList<>();
  public static ArrayList<String> cooldownt = new ArrayList<>();
  
  @EventHandler
  public void timelordkit(PlayerInteractEvent event)
  {
    final Player player = event.getPlayer();
    if ((event.getAction() == Action.RIGHT_CLICK_AIR) || 
      (event
      .getAction() == Action.RIGHT_CLICK_BLOCK)) {
      if ((player.getItemInHand().getType() == Material.WATCH) && 
        (KitAPI.getKit(player) == "TimeLord")) {
        if (cooldownt.contains(player.getName())) {
          player.sendMessage("§aEspere para usar novamente!");
        } else {
          for (Entity frozen : player.getNearbyEntities(2.0D, 3.0D, 2.0D)) {
            if ((frozen != null) && ((frozen instanceof Player)))
            {
              freeze.add(((Player)frozen).getName());
              if (!freezing.contains(player.getName()))
              {
                player.getWorld().playEffect(player.getLocation(), 
                  Effect.POTION_BREAK, 10);
                player.getWorld().playSound(player.getLocation(), 
                  Sound.WITHER_SHOOT, 10.0F, 1.0F);
                freezing.add(player.getName());
                cooldownt.add(player.getName());
                Bukkit.getServer()
                  .getScheduler()
                  .scheduleSyncDelayedTask(Main.getInstace(), 
                  new Runnable()
                  {
                    public void run()
                    {
                      freezing.remove(player
                        .getName());
                      TimeLord.cooldownt.remove(player.getName());
                      player.sendMessage("§aTimeLord recarregado!");
                    }
                  }, 500L);
              }
            }
          }
        }
      }
    }
  }
  
  @EventHandler
  public void onPlayerMove(PlayerMoveEvent event)
  {
    final Player player = event.getPlayer();
    if ((freeze.contains(player.getName())) && 
      (!freezing.contains(player.getName())))
    {
      event.setTo(player.getLocation());
      player.sendMessage("§aVoce foi congelado por um TimeLord!!");
      Main.getInstace().getServer().getScheduler()
        .scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
        {
          public void run()
          {
            freeze.remove(player
              .getName());
          }
        }, 150L);
    }
  }
}