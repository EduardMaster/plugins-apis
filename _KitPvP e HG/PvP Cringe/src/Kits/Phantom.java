package Kits;

import Main.Main;
import Utils.KitAPI;
import me.confuser.barapi.BarAPI;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Phantom
  implements Listener
{
  @EventHandler
  public void Interagir(PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    if ((KitAPI.getKit(p) == "Phantom") && (e.getMaterial() == Material.FEATHER)) {
      if (!KitAPI.KitDelay.containsKey(p.getName()))
      {
        p.sendMessage("§3Voce usou seu poder de voar");
        
        ItemStack is = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta ism = (LeatherArmorMeta)is.getItemMeta();
        ism.setColor(Color.WHITE);
        is.setItemMeta(ism);
        p.getInventory().setHelmet(is);
        
        ItemStack is1 = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta is1m = (LeatherArmorMeta)is1.getItemMeta();
        is1m.setColor(Color.WHITE);
        is1.setItemMeta(is1m);
        p.getInventory().setChestplate(is1);
        
        ItemStack is2 = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta is2m = (LeatherArmorMeta)is2.getItemMeta();
        is2m.setColor(Color.WHITE);
        is2.setItemMeta(is2m);
        p.getInventory().setLeggings(is2);
        
        ItemStack is3 = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta is3m = (LeatherArmorMeta)is3.getItemMeta();
        is3m.setColor(Color.WHITE);
        is3.setItemMeta(is3m);
        p.getInventory().setBoots(is3);
        p.setAllowFlight(true);
        p.setFlying(true);
        
        KitAPI.KitDelay.put(p.getName(), Integer.valueOf(30));
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
        {
          public void run()
          {
            if ((KitAPI.getKit(p) == "Phantom") && (KitAPI.KitDelay.containsKey(p.getName())) && (((Integer)KitAPI.KitDelay.get(p.getName())).intValue() <= 0))
            {
              KitAPI.KitDelay.remove(p.getName());
              p.sendMessage("§aO delay acabou !");
            }
          }
        }, 600L);
        
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
        {
		public void run()
          {
            p.setLevel(5);
            BarAPI.setMessage(p, "§aPara de voar §2§l5");
          }
        }, 0L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
        {
		public void run()
          {
            p.setLevel(4);
            BarAPI.setMessage(p, "§aPara de voar §2§l4");
          }
        }, 20L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
        {
		public void run()
          {
            p.setLevel(3);
            p.sendMessage("§a3 §7segundos...");
            BarAPI.setMessage(p, "§aPara de voar §a§l3");
          }
        }, 40L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
        {
		public void run()
          {
            p.setLevel(2);
            p.sendMessage("§e§l2 §7segundos...");
            BarAPI.setMessage(p, "§aPara de voar §e§l2");
          }
        }, 60L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
        {
		public void run()
          {
            p.setLevel(1);
            p.sendMessage("§c§l1 §7segundo.");
            BarAPI.setMessage(p, "§aPara de voar §c§l1");
          }
        }, 80L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
        {
		public void run()
          {
            if ((KitAPI.getKit(p) == "Phantom") && (KitAPI.KitDelay.containsKey(p.getName())) && (((Integer)KitAPI.KitDelay.get(p.getName())).intValue() <= 30)) {
              p.setLevel(0);
            }
            p.sendMessage("§cAcabou os segundos !");
            BarAPI.setMessage(p, "§aSeu Phantom acabou", 3);
            
            p.getInventory().setHelmet(new ItemStack(Material.AIR));
            p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
            p.getInventory().setLeggings(new ItemStack(Material.AIR));
            p.getInventory().setBoots(new ItemStack(Material.AIR));
            
            p.setAllowFlight(false);
            p.setFlying(false);
            p.setGameMode(GameMode.SURVIVAL);
          }
        }, 100L);
      }
      else
      {
        p.sendMessage("§7Seu Poder esta carregando. §a" + KitAPI.KitDelay.get(p.getName()) + " segundos");
      }
    }
  }
}
