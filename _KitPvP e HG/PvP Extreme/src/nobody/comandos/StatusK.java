package nobody.comandos;

import java.util.ArrayList;

import nobody.main.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class StatusK
  implements Listener
{
  Main a;
  
  public StatusK(Main plugin)
  {
    this.a = plugin;
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
public final ArrayList<Player> b = new ArrayList();
  @SuppressWarnings({ "unchecked", "rawtypes" })
public final ArrayList<Player> c = new ArrayList();
  @SuppressWarnings({ "unchecked", "rawtypes" })
public final ArrayList<Player> d = new ArrayList();
  @SuppressWarnings({ "unchecked", "rawtypes" })
public final ArrayList<Player> e = new ArrayList();
  @SuppressWarnings({ "unchecked", "rawtypes" })
public final ArrayList<Player> f = new ArrayList();
  @SuppressWarnings({ "unchecked", "rawtypes" })
public final ArrayList<Player> g = new ArrayList();
  
  public void a(Player player, Player killer)
  {
    if ((player.getKiller() instanceof Player))
    {
      try
      {
        this.a.getConfig().set("jogador." + killer.getName().toLowerCase() + ".kill-streak", Double.valueOf(this.a.getConfig().getDouble("jogador." + killer.getName().toLowerCase() + ".kill-streak") + 1.0D));
        if (this.a.getConfig().getInt("jogador." + killer.getName().toLowerCase() + ".kill-streak") >= this.a.getConfig().getDouble("jogador." + killer.getName().toLowerCase() + ".max-kill-streak")) {
          this.a.getConfig().set("jogador." + killer.getName().toLowerCase() + ".max-kill-streak", Double.valueOf(this.a.getConfig().getDouble("jogador." + killer.getName().toLowerCase() + ".kill-streak")));
        }
      }
      catch (Exception e)
      {
        this.a.getConfig().set("jogador." + killer.getName().toLowerCase() + ".max-kill-streak", Integer.valueOf(0));
      }
      try
      {
        if (this.a.getConfig().getDouble("jogador." + player.getName().toLowerCase() + ".kill-streak") >= this.a.getConfig().getInt("jogador." + player.getName().toLowerCase() + ".max-kill-streak")) {
          this.a.getConfig().set("jogador." + player.getName().toLowerCase() + ".max-kill-streak", Integer.valueOf(this.a.getConfig().getInt("jogador." + player.getName().toLowerCase() + ".kill-streak")));
        }
      }
      catch (Exception e)
      {
        this.a.getConfig().set("jogador." + player.getName().toLowerCase() + ".max-kill-streak", Integer.valueOf(0));
        this.a.getConfig();
      }
      this.a.getConfig().set("jogador." + player.getName().toLowerCase() + ".kill-streak", Integer.valueOf(0));
      this.a.getConfig();
    }
  }
  
  
  @EventHandler
  public void a(PlayerJoinEvent event)
  {
    Player player = event.getPlayer();
    this.a.getConfig().set("jogador." + player.getName().toLowerCase() + ".name", player.getName());
    this.a.saveConfig();
    if (this.a.getConfig().get("jogador." + player.getName().toLowerCase() + ".kills") == null)
    {
      this.a.getConfig().set("jogador." + player.getName().toLowerCase() + ".kills", Integer.valueOf(0));
      this.a.saveConfig();
    }
    if (this.a.getConfig().get("jogador." + player.getName().toLowerCase() + ".mortes") == null)
    {
      this.a.getConfig().set("jogador." + player.getName().toLowerCase() + ".mortes", Integer.valueOf(0));
      this.a.saveConfig();
    }
    if (this.a.getConfig().get("jogador." + player.getName().toLowerCase() + ".kill-streak") == null)
    {
      this.a.getConfig().set("jogador." + player.getName().toLowerCase() + ".kill-streak", Integer.valueOf(0));
      this.a.saveConfig();
    }
    if (this.a.getConfig().get("jogador." + player.getName().toLowerCase() + ".max-kill-streak") == null)
    {
      this.a.getConfig().set("jogador." + player.getName().toLowerCase() + ".max-kill-streak", Integer.valueOf(0));
      this.a.saveConfig();
    }
  }
  
  @EventHandler
  public void b(PlayerDeathEvent event)
  {
    Player player = event.getEntity();
    if (!this.a.getConfig().contains("jogador." + player.getName().toLowerCase() + ".mortes"))
    {
      double zip = 0.0D;
      this.a.getConfig().set("jogador." + player.getName().toLowerCase() + ".mortes", Double.valueOf(zip));
    }
    else
    {
      double l = this.a.getConfig().getDouble("jogador." + player.getName().toLowerCase() + ".mortes");
      this.a.getConfig().set("jogador." + player.getName().toLowerCase() + ".mortes", Double.valueOf(l + 1.0D));
    }
    Long gg = Long.valueOf(this.a.getConfig().getLong("stats.kills-cooldowns"));
    if ((player.getKiller() instanceof Player))
    {
      final Player killer = player.getKiller();
      if (!this.a.getConfig().contains("jogador." + killer.getName().toLowerCase() + ".kills"))
      {
        this.a.getConfig().set("jogador." + killer.getName().toLowerCase() + ".kills", Integer.valueOf(1));
      }
      else
      {
        double i = this.a.getConfig().getDouble("jogador." + killer.getName().toLowerCase() + ".kills");
        this.a.getConfig().set("jogador." + killer.getName().toLowerCase() + ".kills", Double.valueOf(i + 1.0D));
      }
      if (this.g.contains(killer))
      {
        this.g.remove(killer);
        if (this.a.getConfig().getBoolean("stats.kill-extreme")) {
          Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', this.a.getConfig().getString("messages.kill-6").replace("{PLAYER}", killer.getName())));
        }
        return;
      }
      if (this.e.contains(killer))
      {
        this.e.remove(killer);
        if (this.a.getConfig().getBoolean("stats.kill-quintuple")) {
          Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', this.a.getConfig().getString("messages.kill-5").replace("{PLAYER}", killer.getName())));
        }
        return;
      }
      if (this.d.contains(killer))
      {
        this.d.remove(killer);
        this.e.add(killer);
        if (this.a.getConfig().getBoolean("stats.kill-quadruple")) {
          Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', this.a.getConfig().getString("messages.kill-4").replace("{PLAYER}", killer.getName())));
        }
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.a, new Runnable()
        {
          public void run()
          {
            StatusK.this.e.remove(killer);
          }
        }, gg.longValue() * 20L);
        
        return;
      }
      if (this.c.contains(killer))
      {
        this.c.remove(killer);
        this.d.add(killer);
        if (this.a.getConfig().getBoolean("stats.kill-triple")) {
          Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', this.a.getConfig().getString("messages.kill-3").replace("{PLAYER}", killer.getName())));
        }
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.a, new Runnable()
        {
          public void run()
          {
            StatusK.this.d.remove(killer);
          }
        }, gg.longValue() * 20L);
        
        return;
      }
      if (this.b.contains(killer))
      {
        this.b.remove(killer);
        this.c.add(killer);
        if (this.a.getConfig().getBoolean("stats.kill-double")) {
          Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', this.a.getConfig().getString("messages.kill-2").replace("{PLAYER}", killer.getName())));
        }
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.a, new Runnable()
        {
          public void run()
          {
            StatusK.this.c.remove(killer);
          }
        }, gg.longValue() * 20L);
        
        return;
      }
      if ((!this.b.contains(killer)) || (!this.c.contains(killer)) || (!this.d.contains(killer)) || (!this.e.contains(killer)) || (!this.f.contains(killer)))
      {
        this.b.add(killer);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.a, new Runnable()
        {
          public void run()
          {
            StatusK.this.b.remove(killer);
          }
        }, gg.longValue() * 20L);
      }
    }
  }
}
