package Efeitos;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitScheduler;

import me.rafael.vinagre.KomboPvP.Main;


@SuppressWarnings("unused")
public class Smoke
  implements Listener, CommandExecutor
{
  public static Main plugin;
  
  public Smoke(Main main)
  {
    plugin = main;
  }
  
  public Smoke() {}
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    final Player p = (Player)sender;
    if ((cmd.getName().equalsIgnoreCase("efeito3")) && (p.hasPermission("kitpvp.efeitos")))
    {
      if (Main.Efeitos.contains(p.getName()))
      {
        p.sendMessage("§4Voce ja esta a utilizar um efeito use /removerefeito para escolher outro!");
        return true;
      }
      Main.Efeitos.add(p.getName());
      Main.Smoke.add(p.getName());
      p.sendMessage("§7Efeito » SMOKE Â« Ativado!");
      p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      
      Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          if (Main.Smoke.contains(p.getName()))
          {
            p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 200, 200);
            p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 0.9D, 0.0D), Effect.SMOKE, 200, 200);
            p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 1.1D, 0.0D), Effect.SMOKE, 200, 200);
            p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 200, 200);
            p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 0.9D, 0.0D), Effect.SMOKE, 200, 200);
            p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 1.1D, 0.0D), Effect.SMOKE, 200, 200);
            p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 200, 200);
            p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 0.9D, 0.0D), Effect.SMOKE, 200, 200);
            p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 1.1D, 0.0D), Effect.SMOKE, 200, 200);
          }
        }
      }, 0L, 20L);
    }
    else
    {
      p.sendMessage("§4§lVoce nao tem permissao para usar efeitos!");
      p.playSound(p.getLocation(), Sound.BLAZE_DEATH, 1.0F, 1.0F);
    }
    return false;
  }
  
  @EventHandler
  public void onDeath(PlayerDeathEvent e)
  {
    if ((e.getEntity() instanceof Player))
    {
      Player p = e.getEntity();
      Main.Smoke.remove(p);
      Main.Efeitos.remove(p);
    }
  }
  
  @EventHandler
  public void QuandoQuitar(PlayerQuitEvent e)
  {
    Player p = e.getPlayer();
    
    Main.Smoke.remove(p);
    Main.Efeitos.remove(p);
  }
}

