package me.rafael.vinagre.KomboPvP.Kits;

import java.util.ArrayList;

import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitScheduler;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;

public class Achilles
  implements Listener, CommandExecutor
{
  public Main plugin;
  
  public Achilles(Main plugin)
  {
    this.plugin = plugin;
  }
  
  public static ArrayList<Player> achilles = new ArrayList();
  public static HashMap<Player, Player> hit = new HashMap();
  
  @EventHandler
  public void deathe(PlayerDeathEvent e)
  {
    Player p = e.getEntity();
    
    achilles.remove(p);
    hit.remove(p);
  }
  
  @EventHandler
  public void ent(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();
    
    achilles.remove(p);
    hit.remove(p);
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player jogador = (Player)sender;
    if (label.equalsIgnoreCase("achilles")) {
      if (jogador.hasPermission("kitpvp.kit.achilles"))
      {
        if (Array.used.contains(jogador.getName())) {
          jogador.sendMessage("Voce ja selecionou um kit !");
        } else {
          giveKit(jogador);
        }
      }
      else {
        jogador.sendMessage(ChatColor.RED + "Voce nao possue este kit !");
      }
    }
    return false;
  }
  
  public static void giveKit(Player p)
  {
    p.getInventory().clear();
    p.sendMessage(ChatColor.GREEN + "Voce escolheu Achilles!");
    ItemStack sword = new ItemStack(Material.STONE_SWORD);
    p.getInventory().addItem(new ItemStack[] { sword });
    for (int i = 0; i < 37; i++) {
      p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
    }
    Array.used.add(p.getName());
    achilles.add(p);
  }
  
  @EventHandler
  public void damage(EntityDamageEvent e)
  {
    if ((e.getEntity() instanceof Player))
    {
      if (!achilles.contains(e.getEntity())) {
        return;
      }
      if (e.getCause() != EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
        e.setDamage(e.getDamage() / 2.0D);
      }
    }
  }
  
  @EventHandler
  public void onachillesDamage(EntityDamageByEntityEvent e)
  {
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
    {
      final Player p = (Player)e.getEntity();
      final Player d = (Player)e.getDamager();
      if (achilles.contains(p)) {
        if (d.isSneaking())
        {
          e.setDamage(e.getDamage() * 1.0D);
        }
        else
        {
          e.setDamage(e.getDamage() / 2.0D);
          if ((hit.get(d) == null) || (hit.get(d) != p))
          {
            hit.put(d, p);
            d.sendMessage(ChatColor.RED + "Ele e um achilles , agaiche para dar mais dano nele.");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
            {
              public void run()
              {
                if (Achilles.hit.get(d) == p) {
                  Achilles.hit.remove(d);
                }
              }
            }, 200L);
          }
        }
      }
    }
  }
}