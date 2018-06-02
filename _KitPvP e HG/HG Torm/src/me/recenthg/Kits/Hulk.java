package me.recenthg.Kits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import me.recenthg.Main;
import me.recenthg.Manager.Habilidade;
import me.recenthg.Utils.Estado;

public class Hulk
  implements Listener
{
  ArrayList<String> Hulk = new ArrayList<String>();
  ArrayList<String> Cooldown = new ArrayList<String>();
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onHulk(PlayerInteractEntityEvent event)
  {
    final Player p = event.getPlayer();
    if (Main.estados == Estado.ANDAMENTO)
    {
      if ((event.getRightClicked() instanceof Player))
      {
        Player d = (Player)event.getRightClicked();
        if (Habilidade.getAbility(p).equalsIgnoreCase("hulk"))
        if ( (p.getItemInHand().getType().equals(Material.AIR)))
        {
          if (this.Cooldown.contains(p.getName()))
          {
            p.sendMessage("§8\u276e§4§l!§8\u276f §7Você ainda esta no cooldown!");
            event.setCancelled(true);
            return;
          }
          if (p.getPassenger() == null)
          {
            p.setPassenger(d);
            this.Cooldown.add(p.getName());
            d.sendMessage("§8\u276e§4§l!§8\u276f §7Você foi pego por um hulk!");
          }
          else
          {
            p.sendMessage("§8\u276e§4§l!§8\u276f §7Ja existe um jogador na sua cabeça");
          }
        }
      }
      if (this.Cooldown.contains(p.getName())) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
        {
          public void run()
          {
            Hulk.this.Cooldown.remove(p.getName());
            p.sendMessage("§8\u276e§4§l!§8\u276f §7Você ja pode usar seu kit novamente!");
       	 p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 4.0F, 4.0F);
          }
        },120L);
      }
    }
  }
}