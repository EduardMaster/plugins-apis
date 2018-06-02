package Kits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
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
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import Main.Main;
import Utils.KitAPI;

public class Deshfire
  implements Listener, CommandExecutor
{
  @SuppressWarnings({ "unchecked", "rawtypes" })
public static ArrayList<Player> Cooldown = new ArrayList();
  @SuppressWarnings({ "unchecked", "rawtypes" })
public static HashMap<String, ItemStack[]> Armadura = new HashMap();
  @SuppressWarnings({ "unchecked", "rawtypes" })
public static ArrayList<Player> cooldownm = new ArrayList();
  
  @EventHandler
  public void interact(PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    if ((KitAPI.getKit(p) == "Deshfire") && (
      (e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))) {
      if (p.getItemInHand().getType() == Material.REDSTONE_BLOCK)
      {
        e.setCancelled(true);
        p.updateInventory();
        if (cooldownm.contains(p))
        {
          p.sendMessage("§7[§c!§7]§cKit em Cooldown!");
          return;
        }
        Armadura.put(p.getName(), p.getInventory().getArmorContents());
        
        ItemStack Peitoral = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta kPeitoral = (LeatherArmorMeta)Peitoral.getItemMeta();
        kPeitoral.setColor(Color.RED);
        Peitoral.setItemMeta(kPeitoral);
        

        p.getInventory().setChestplate(Peitoral);
        
        ItemStack Capacete = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta kCapacete = (LeatherArmorMeta)Capacete.getItemMeta();
        kCapacete.setColor(Color.RED);
        Capacete.setItemMeta(kCapacete);
        


        ItemStack Calca = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta kCalca = (LeatherArmorMeta)Calca.getItemMeta();
        kCalca.setColor(Color.RED);
        Calca.setItemMeta(kCalca);
        
        ItemStack Bota = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta kBota = (LeatherArmorMeta)Bota.getItemMeta();
        kBota.setColor(Color.RED);
        Bota.setItemMeta(kBota);
        

        p.getInventory().setHelmet(Capacete);
        
        p.getInventory().setLeggings(Calca);
        p.getInventory().setBoots(Bota);
        







        p.sendMessage("§6>> §7DeshFire Usado!");
        
        p.playSound(p.getLocation(), Sound.BLAZE_HIT, 1.0F, 1.0F);
        
        p.updateInventory();
        

        final Vector Vector = p.getEyeLocation().getDirection();
        Vector.multiply(5);
        p.setVelocity(Vector);
        
        List<Entity> Local = p.getNearbyEntities(10.0D, 10.0D, 10.0D);
        for (Entity Inimigos : Local)
        {
          Inimigos.setFireTicks(100);
          


          Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
          {
            public void run()
            {
              p.setVelocity(Vector);
              p.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 100, 1);
            }
          }, 20L);
          
          Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
          {
            public void run()
            {
              p.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 100, 1);
            }
          }, 30L);
          
          Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
          {
            public void run()
            {
              p.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 100, 1);
            }
          }, 40L);
          
          Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
          {
            public void run()
            {
              p.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 100, 1);
            }
          }, 50L);
        }
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
        {
          public void run()
          {
            p.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 100, 1);
            p.getInventory().setArmorContents((ItemStack[])Deshfire.Armadura.get(p.getName()));
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 0));
          }
        }, 60L);
        

        cooldownm.add(p);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
        {
          public void run()
          {
            Deshfire.cooldownm.remove(p);
            
            p.sendMessage("§7[§c!§7]§cVoce pode usar novamente!");
          }
        }, 500L);
      }
    }
  }
  
  public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3)
  {
    return false;
  }
}
