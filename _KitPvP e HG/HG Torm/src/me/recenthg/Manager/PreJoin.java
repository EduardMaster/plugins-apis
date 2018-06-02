package me.recenthg.Manager;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.recenthg.Main;
import me.recenthg.Utils.Estado;

@SuppressWarnings("deprecation")
public class PreJoin
  implements Listener
{
  public ArrayList<String> antilog = new ArrayList<String>();
  public ArrayList<String> NoLog = new ArrayList<String>();

  @SuppressWarnings("unused")
@EventHandler(priority=EventPriority.HIGHEST)
  public void onQuitInv(PlayerQuitEvent e)
  {
    final Player p = e.getPlayer();
    String KitName = Habilidade.NomeDoKit(Habilidade.getAbility(p));
    e.setQuitMessage(null);
    if (Main.estados == Estado.INICIANDO) {
      return;
    }
    Main.saiu.add(p.getName());
    if (Main.saiu.contains(p.getName()))
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
      {
        public void run()
        {
          if (p.isOnline()) {
            return;
          }
          Main.Jogadores.remove(p.getName());
          Main.saiu.remove(p.getName());
          Win.verificaWin();
          PreJoin.this.NoLog.add(p.getName());
          Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
          {
            public void run()
            {
              throw new Error("Unresolved compilation problems: \n\tval$p cannot be resolved or is not a field\n\tval$p cannot be resolved or is not a field\n\tval$p cannot be resolved or is not a field\n\tval$p cannot be resolved or is not a field\n\tval$KitName cannot be resolved or is not a field\n");
            }
          }
          , 5L);
        }
      }
      , 5L);
  }

@EventHandler
  public void onCheck(PlayerLoginEvent e)
  {
    Player p = e.getPlayer();
    if (Main.estados == Estado.INICIANDO)
    {
      if (Main.Jogadores.size() <= Bukkit.getMaxPlayers())
      {
        e.allow();
      }
      else if (p.hasPermission("Torm.lotado"))
      {
        e.allow();
      }
      else
      {
        e.setKickMessage("§c§lERRO§c Os Servidores Estao Sobrecarregados");
        e.disallow(PlayerLoginEvent.Result.KICK_OTHER, e.getKickMessage());
      }
    }
    else
    {
      if (Main.Jogadores.contains(p.getName()))
      {
        e.allow();
      }
      else if ((p.hasPermission("Torm.Entrar")) && (Main.estados == Estado.INVENCIBILIDADE))
      {
        e.allow();
        p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.COMPASS) });
        Main.Jogadores.add(p.getName());
      }
      else
      {
        e.setKickMessage("§cPartida Em Andamento \n Adquira vip para conseguir entrar. \nSite: §fhttps://Loja-TormNetwork.buycraft.net/");
        e.disallow(PlayerLoginEvent.Result.KICK_OTHER, e.getKickMessage());
      }
      if ((Main.Watch.contains(p.getName())) && (p.hasPermission("Torm.Espectar")))
      {
        e.allow();
        p.setAllowFlight(true);
        p.setFlying(true);
        p.sendMessage("§aVoce entrou no modo espectador");

        p.getInventory().clear();
        p.setGameMode(GameMode.CREATIVE);
        ItemStack kit = new ItemStack(Material.CHEST);
        ItemMeta rkit = kit.getItemMeta();
        rkit.setDisplayName("§6Teleporte");
        kit.setItemMeta(rkit);
        p.getInventory().setItem(4, kit);

        Location loc = new Location(Bukkit.getWorld("world"), 10.0D, 110.0D, 10.0D, -90.0F, 0.0F);
        p.teleport(loc);
        Player[] arrayOfPlayer;
        int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
        for (int i = 0; i < j; i++)
        {
          Player pl = arrayOfPlayer[i];
          pl.hidePlayer(p);
        }
      }
      if (NoLog.contains(p.getName()))
      {
        e.setKickMessage("§cVoce Foi Desclassificado \n Adquira vip para conseguir entrar. \nSite: §fhttps://Loja-TormNetwork.buycraft.net/");
        e.disallow(PlayerLoginEvent.Result.KICK_OTHER, e.getKickMessage());
      }
      else if (p.hasPermission("Torm.entrar"))
      {
        e.allow();
      }
      if (this.antilog.contains(p.getName()))
      {
        e.setKickMessage("§cVoce Deslogou Em PvP \n Adquira vip para conseguir entrar. \nSite: §fhttps://Loja-TormNetwork.buycraft.net/");
        e.disallow(PlayerLoginEvent.Result.KICK_OTHER, e.getKickMessage());
      }
      else if (p.hasPermission("Torm.entrar"))
      {
        e.allow();
      }
      if (Main.mortos.contains(p.getName()))
      {
        e.setKickMessage("§cVoce Morreu \n Adquira vip para conseguir entrar. \nSite: §fhttps://Loja-TormNetwork.buycraft.net/");
        e.disallow(PlayerLoginEvent.Result.KICK_OTHER, e.getKickMessage());
      }
      else if (p.hasPermission("Torm.entrar"))
      {
        e.allow();
      }
    }
  }

  @EventHandler
  public void onSleep(PlayerBedEnterEvent event)
  {
    event.setCancelled(true);
  }

  @EventHandler
  public void AntiCaps(PlayerChatEvent evt)
  {
    if (!evt.getPlayer().hasPermission("Torm.entrar"))
      evt.setMessage(evt.getMessage().toLowerCase());
  }

  @EventHandler
  public void onAntiLogDmg(EntityDamageByEntityEvent event)
  {
    if (((event.getDamager() instanceof Player)) && ((event.getEntity() instanceof Player)))
    {
      final Player player = (Player)event.getEntity();
      final Player target = (Player)event.getDamager();
      if ((Main.estados == Estado.ANDAMENTO) && 
        (!this.antilog.contains(player.getName())) && (!this.antilog.contains(target.getName())))
      {
        this.antilog.add(player.getName());
        this.antilog.add(target.getName());
        Main.instance.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
        {
          public void run()
          {
            if ((PreJoin.this.antilog.contains(player.getName())) && (PreJoin.this.antilog.contains(target.getName())))
            {
              PreJoin.this.antilog.remove(player.getName());
              PreJoin.this.antilog.remove(target.getName());
            }
          }
        }
        , 450L);
      }
    }
  }
}