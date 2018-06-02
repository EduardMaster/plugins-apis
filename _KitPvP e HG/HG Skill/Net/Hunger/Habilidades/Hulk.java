package Net.Hunger.Habilidades;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import Net.Hunger.Main;
import Net.Hunger.Manager.Habilidade;

public class Hulk
  implements Listener
{
  ArrayList<String> Hulk = new ArrayList();
  ArrayList<String> Cooldown = new ArrayList();
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onHulk(PlayerInteractEntityEvent event)
  {
    final Player p = event.getPlayer();
    if (Main.Partida)
    {
      if ((event.getRightClicked() instanceof Player))
      {
        Player d = (Player)event.getRightClicked();
        if ((Habilidade.getAbility(p).equalsIgnoreCase("hulk")) && (p.getItemInHand().getType().equals(Material.AIR)))
        {
          if (this.Cooldown.contains(p.getName()))
          {
            p.sendMessage("§7[§a?§7] Você ainda esta no cooldown!");
            event.setCancelled(true);
            return;
          }
          if (p.getPassenger() == null)
          {
            p.setPassenger(d);
            this.Cooldown.add(p.getName());
            d.sendMessage("§7[§a!§7] Você foi pego por um hulk!");
          }
          else
          {
            p.sendMessage("§7[§a?§7] Ja existe um jogador na sua cabeça");
          }
        }
      }
      if (this.Cooldown.contains(p.getName())) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
        {
          public void run()
          {
            Hulk.this.Cooldown.remove(p.getName());
            p.sendMessage("§7[§a!§7] Você ja pode usar seu kit novamente!");
          }
        },120L);
      }
    }
  }
}