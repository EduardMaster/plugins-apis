package Kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import Main.Main;
import Utils.Array;

public class ForceField
  implements CommandExecutor, Listener
{
  public static Main plugin;
  
  public ForceField(Main main)
  {
    plugin = main;
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
public static List<Player> cooldownm = new ArrayList();
  
  @EventHandler
  public void ffClick(PlayerInteractEvent event)
  {
    final Player p = event.getPlayer();
    if ((event.getPlayer().getItemInHand().getType() == Material.IRON_FENCE) && 
      (Array.ForceField.contains(event.getPlayer().getName())))
    {
      if ((event.getAction() == Action.LEFT_CLICK_AIR) || 
        (event.getAction() == Action.LEFT_CLICK_BLOCK) || 
        (event.getAction() == Action.RIGHT_CLICK_BLOCK) || 
        (event.getAction() == Action.RIGHT_CLICK_AIR)) {
        event.setCancelled(true);
      }
      if (cooldownm.contains(p))
      {
        p.sendMessage("§7[§c!§7] §cCooldown §7[§c!§7]");
        return;
      }
      Location loc = p.getLocation();
      p.getWorld().playSound(loc, Sound.MAGMACUBE_WALK2, 0.5F, 0.5F);
      cooldownm.add(p);
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          Array.ForceFielddano.add(p.getName());
          p.sendMessage("§7[§c!§7]§2 Você Ativou o FF §7[§c!§7]");
        }
      }, 0L);
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          Array.ForceFielddano.remove(p.getName());
        }
      }, 50L);
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          ForceField.cooldownm.remove(p);
          p.sendMessage("§7[§c!§7]§a Você pode usar novamente seu FF! §7[§c!§7]");
          p.getWorld().playSound(p.getLocation(), Sound.BURP, 0.5F, 0.5F);
        }
      }, 500L);
    }
  }
  
  @EventHandler
  public void fraqueza(PlayerMoveEvent event)
  {
    Player p = event.getPlayer();
    if (Array.ForceFielddano.contains(p.getName())) {
      for (Entity pertos : p.getNearbyEntities(8.0D, 8.0D, 8.0D)) {
        if ((pertos instanceof Player))
        {
          @SuppressWarnings("unused")
		Player perto = (Player)pertos;
          if (Array.ForceField.contains(p.getName())) {
            ((Player)pertos).damage(3.0D);
          }
          pertos.setVelocity(new Vector(0.1D, 0.0D, 0.1D));
          Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
          {
            public void run() {}
          }, 10L);
        }
      }
    }
  }
  
  public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args)
  {
    Player p = (Player)Sender;
    if (Cmd.getName().equalsIgnoreCase("ForceField"))
    {
      if (!p.hasPermission("kit.ForceField"))
      {
        p.sendMessage("§7[§c!§7]§c Você não tem permissão para este kit! §7[§c!§7]");
        return true;
      }
      if (Array.Usando.contains(p.getName()))
      {
        p.sendMessage("§7[§c!§7]§c Você já esta usando um kit! §7[§c!§7]");
        return true;
      }
      ItemStack kPvP = new ItemStack(Material.IRON_SWORD);
      ItemMeta mPvP = kPvP.getItemMeta();
      mPvP.setDisplayName("§6§oEspada");
      kPvP.setItemMeta(mPvP);
      
      ItemStack kFF = new ItemStack(Material.IRON_FENCE);
      ItemMeta mFF = kFF.getItemMeta();
      mFF.setDisplayName("§a§oForceField");
      kFF.setItemMeta(mFF);
      

      
      p.sendMessage("§7[§c!§7]§2 Você pegou o kit: §6§oForceField §7[§c!§7]");
      p.setGameMode(GameMode.ADVENTURE);
      p.getInventory().clear();
      
       
      p.getInventory().setItem(0, kPvP);
      p.getInventory().setItem(1, kFF);
     
      
      
      p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
      

      
      Array.ForceField.add(p.getName());
      Array.Usando.add(p.getName());
    }
    return false;
  }
}
