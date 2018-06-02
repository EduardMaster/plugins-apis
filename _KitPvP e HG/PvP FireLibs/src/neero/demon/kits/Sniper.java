package neero.demon.kits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import neero.demon.Main;
import neero.demon.eventos.KitAPI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

public class Sniper
  implements Listener, CommandExecutor
{
  public static Main plugin;
  public static ArrayList<String> reload = new ArrayList<String>();
  public static HashMap<String, Long> cooldown = new HashMap<String, Long>();
  
  public Sniper(Main main)
  {
    plugin = main;
  }
  
  @EventHandler(priority=EventPriority.NORMAL)
  public void onPlayerInteract(PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    if (KitAPI.getkit(p) == ("Sniper"))
    {
      if (e.getAction() != Action.RIGHT_CLICK_AIR) {
        return;
      }
      if (e.getItem().getType() != Material.IRON_BARDING) {
        return;
      }
      Vector velo1 = p.getLocation().getDirection().normalize().multiply(5);
      velo1.add(new Vector(Math.random() * 0.0D + 0.0D, 0.0D, 0.0D));
      if (reload.contains(p.getName()))
      {
        p.sendMessage(ChatColor.GOLD + "Recarregando!");
      }
      else
      {
        p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
        p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 7);
        p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 7);
        p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 7);
        p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 7);
        p.playEffect(p.getLocation(), Effect.SMOKE, 7);
        p.playEffect(p.getLocation(), Effect.SMOKE, 7);
        p.playEffect(p.getLocation(), Effect.SMOKE, 7);
        p.playEffect(p.getLocation(), Effect.SMOKE, 7);
        ((Arrow)p.launchProjectile(Arrow.class)).setVelocity(velo1);
        reload.add(p.getName());
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
        {
          public void run()
          {
            if (KitAPI.getkit(p) == ("Sniper"))
            {
              p.sendMessage("§4§lKIT: §7Sniper Recarregada!");
              reload.remove(p.getName());
            }
          }
        }, 260L);
      }
    }
  }
  
  @EventHandler
  public void onEntityDamageByEntity(EntityDamageByEntityEvent event)
  {
    if (((event.getDamager() instanceof Arrow)) && 
      ((((Arrow)event.getDamager()).getShooter() instanceof Player)))
    {
      Arrow arrow = (Arrow)event.getDamager();
      Player p = (Player)arrow.getShooter();
      p.getLocation().distance(event.getEntity().getLocation());
      if (((event.getEntity() instanceof Player)) && (KitAPI.getkit(p) == ("Sniper")))
      {
        p.playSound(p.getLocation(), Sound.WITHER_SHOOT, 1.0F, 1.0F);
        event.setDamage(17.0D);
      }
    }
  }
  
  public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args)
  {
    Player p = (Player)sender;
    ItemStack dima = new ItemStack(Material.STONE_SWORD);
    ItemMeta souperaa = dima.getItemMeta();
    souperaa.setDisplayName("§cSword");
    dima.setItemMeta(souperaa);
    ItemStack sopaa = new ItemStack(Material.IRON_BARDING);
    ItemMeta sopasa = sopaa.getItemMeta();
    sopasa.setDisplayName("§6CheyTac M200");
    sopaa.setItemMeta(sopasa);
    ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
    ItemMeta sopas = sopa.getItemMeta();
    sopas.setDisplayName("Sopa");
    sopa.setItemMeta(sopas);
    dima.addEnchantment(Enchantment.DURABILITY, 3);
    if (cmd.equalsIgnoreCase("sniper"))
    {
      if (KitAPI.getkit(p) == ("Sniper"))
      {
        p.sendMessage("§4§lKIT §7§cVoce ja esta usando um kit");
        return true;
      }
      if (!p.hasPermission("kit.sniper"))
      {
        p.sendMessage("§4§lKIT §7§cVoce nao tem esse kit!");
        return true;
      }
      KitAPI.setKit(p, "Sniper");
      p.sendMessage("§4§lKIT §7Voce escolheu §cSniper");
      p.setGameMode(GameMode.SURVIVAL);
      p.getInventory().setArmorContents(null);
      p.getInventory().clear();
      p.getInventory().addItem(new ItemStack[] { dima });
      p.getInventory().addItem(new ItemStack[] { sopaa });
      KitAPI.darsopa(p);
    }
    return false;
  }
}
