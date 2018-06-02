package Warps;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Main.Main;

public class SetSpawn
  implements Listener, CommandExecutor
{
  public Main plugin;
  
  public SetSpawn(Main instance)
  {
    this.plugin = instance;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if ((sender instanceof Player))
    {
      Player p = (Player)sender;
      if (!(sender instanceof Player))
      {
        sender.sendMessage(ChatColor.RED + "Você não pode usa admin!");
        return true;
      }
      if (cmd.getName().equalsIgnoreCase("setspawn"))
      {
        if (!p.hasPermission("ezkits.admin"))
        {
          sender.sendMessage(ChatColor.RED + "Voce nao tem permissao para isso!");
          return true;
        }
        this.plugin.getConfig().set("SpawnWorld", p.getLocation().getWorld().getName());
        this.plugin.getConfig().set("SpawnX", Double.valueOf(p.getLocation().getX()));
        this.plugin.getConfig().set("SpawnY", Double.valueOf(p.getLocation().getY()));
        this.plugin.getConfig().set("SpawnZ", Double.valueOf(p.getLocation().getZ()));
        this.plugin.getConfig().set("SpawnPitch", Float.valueOf(p.getLocation().getPitch()));
        this.plugin.getConfig().set("SpawnYaw", Float.valueOf(p.getLocation().getYaw()));
        this.plugin.saveConfig();
        World world = p.getWorld();
        Location loc = p.getLocation();
        world.setSpawnLocation(loc.getBlockX(), loc.getBlockY() + 1, loc.getBlockZ());
        p.sendMessage("§7Spawn setado!");
        return true;
      }
      if (cmd.getName().equalsIgnoreCase("spawn"))
      {
        final Player p2 = (Player)sender;
        p2.getInventory().clear();
        p2.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 50));
        p2.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100, 50));
        p2.sendMessage("§aTeleportando em 5 segundos! ");
        Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
        {
          public void run()
          {
            World w = Bukkit.getServer().getWorld(SetSpawn.this.plugin.getConfig().getString("SpawnWorld"));
            double x = SetSpawn.this.plugin.getConfig().getDouble("SpawnX");
            double y = SetSpawn.this.plugin.getConfig().getDouble("SpawnY");
            double z = SetSpawn.this.plugin.getConfig().getDouble("SpawnZ");
            Location lobby = new Location(w, x, y, z);
            lobby.setPitch((float)SetSpawn.this.plugin.getConfig().getDouble("SpawnPitch"));
            lobby.setYaw((float)SetSpawn.this.plugin.getConfig().getDouble("SpawnYaw"));
            p2.getInventory().clear();
            p2.teleport(lobby);
            p2.setExp(0.0F);
            p2.setExhaustion(20.0F);
            p2.setFireTicks(0);
            p2.setFoodLevel(20000);
            p2.setHealth(20.0D);
            ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE);
            ItemMeta vidro12 = vidro.getItemMeta();
            vidro12.setDisplayName(" ");
            vidro.setItemMeta(vidro12);
            
            ItemStack vidro2 = new ItemStack(Material.THIN_GLASS);
            ItemMeta vidro22 = vidro2.getItemMeta();
            vidro22.setDisplayName(" ");
            vidro2.setItemMeta(vidro22);
            
            ItemStack kits = new ItemStack(Material.CHEST);
            ItemMeta kits1 = kits.getItemMeta();
            kits1.setDisplayName("§e§lSeus kits");
            kits.setItemMeta(kits1);
            
            ItemStack menu = new ItemStack(Material.EMERALD);
            ItemMeta menu1 = menu.getItemMeta();
            menu1.setDisplayName("§e§lLoja");
            menu.setItemMeta(menu1);
            
            ItemStack warps = new ItemStack(Material.COMPASS);
            ItemMeta warps1 = warps.getItemMeta();
            warps1.setDisplayName("§e§lWarps");
            warps.setItemMeta(warps1);

            ItemStack mg = new ItemStack(Material.JUKEBOX);
            ItemMeta mg1 = warps.getItemMeta();
            mg1.setDisplayName("§e§lMenu");
            mg.setItemMeta(mg1);
            
            ItemStack mga = new ItemStack(Material.LEASH);
            ItemMeta mg2 = warps.getItemMeta();
            mg2.setDisplayName("§e§lMinigames");
            mga.setItemMeta(mg2);
            
            p2.getInventory().setItem(5, mg);
            p2.getInventory().setItem(1, vidro2);
            p2.getInventory().setItem(2, vidro);
            p2.getInventory().setItem(4, kits);
            p2.getInventory().setItem(0, menu);
            p2.getInventory().setItem(8, warps);
            p2.getInventory().setItem(6, vidro);
            p2.getInventory().setItem(7, vidro2);
            p2.getInventory().setItem(3, mga);
          }
        }, 90L);
      }
    }
    return true;
  }
}
