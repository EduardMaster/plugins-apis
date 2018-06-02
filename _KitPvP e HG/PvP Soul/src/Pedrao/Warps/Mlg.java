package Pedrao.Warps;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Pedrao.Main;

public class Mlg
  implements Listener, CommandExecutor
{
  public static Main plugin;
  
  public Mlg(Main main)
  {
    plugin = main;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("mlg"))
    {
      final Player p = (Player)sender;
      
      World w = Bukkit.getServer().getWorld(plugin.getConfig().getString("mlg.world"));
      double x = plugin.getConfig().getDouble("mlg.x");
      double y = plugin.getConfig().getDouble("mlg.y");
      double z = plugin.getConfig().getDouble("mlg.z");
      final Location lobby = new Location(w, x, y, z);
      lobby.setPitch((float)plugin.getConfig().getDouble("mlg.pitch"));
      lobby.setYaw((float)plugin.getConfig().getDouble("mlg.yaw"));
      p.getInventory().clear();
      p.setHealthScale(1.0D);
      p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
      p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
      p.sendMessage(Main.prefix + "Teleportando em 5 segundos!");
      Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
      {
        public void run()
        {
          p.teleport(lobby);
          p.getInventory().clear();
          p.sendMessage("");
          p.sendMessage("");
          p.sendMessage("");
          p.sendMessage("");
          p.sendMessage("");
          p.sendMessage("");
          p.sendMessage("");
          p.sendMessage("");
          p.sendMessage("");
          p.sendMessage("");
          p.sendMessage("");
          p.sendMessage("");
          p.sendMessage("");
          p.sendMessage("");
          p.sendMessage("");
          p.sendMessage("");
          p.sendMessage("");
          p.sendMessage("");
          p.sendMessage("");
          p.sendMessage("");
          p.sendMessage("");
          p.sendMessage("");
          p.sendMessage("");
          p.sendMessage("");
          p.sendMessage("");
          p.sendMessage("");
          p.sendMessage("");
          p.sendMessage(Main.prefix + "§7Teleportado!");
          p.setHealthScale(20.0D);
          for (PotionEffect effect : p.getActivePotionEffects())
          {
            p.getInventory().setBoots(null);
            p.getInventory().setChestplate(null);
            p.getInventory().setLeggings(null);
            p.getInventory().setHelmet(null);
            p.setHealthScale(20.0D);
            ItemStack mlg = new ItemStack(Material.WATER_BUCKET);
            p.getInventory().setItem(4, mlg);
            p.setFireTicks(0);
            p.removePotionEffect(effect.getType());
          }
        }
      }, 90L);
      
      return false;
    }
    return false;
  }
}
