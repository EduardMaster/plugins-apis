package me.rafael.vinagre.KomboPvP.Comandos;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.rafael.vinagre.KomboPvP.Main;

public class AutoSoup
  implements CommandExecutor, Listener
{
  public static HashMap<String, ItemStack[]> saveinv = new HashMap<String, ItemStack[]>();
  public static HashMap<String, ItemStack[]> armadura = new HashMap<String, ItemStack[]>();
  ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
  ItemMeta msopa = this.sopa.getItemMeta();
  ItemStack sopa1 = new ItemStack(Material.MUSHROOM_SOUP);
  ItemMeta msopa1 = this.sopa.getItemMeta();
  ItemStack sopa2 = new ItemStack(Material.MUSHROOM_SOUP);
  ItemMeta msopa2 = this.sopa.getItemMeta();
  
  public AutoSoup(me.rafael.vinagre.KomboPvP.Main main) {
}

public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args)
  {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("autosoup"))
    {
      if (!p.hasPermission("kitpvp.admin"))
      {
        p.sendMessage("NAO");
        return true;
      }
      final Player testando = p.getServer().getPlayer(args[0]);
      p.openInventory(testando.getInventory());
      saveinv.put(testando.getName(), testando.getInventory().getContents());
      armadura.put(testando.getName(), testando.getInventory().getArmorContents());
      testando.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 70, 999));
      testando.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 70, 999));
      testando.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 60, 999));
      this.sopa.setItemMeta(this.msopa);
      
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(me.rafael.vinagre.KomboPvP.Main.getPlugin(), new Runnable()
      {
        public void run()
        {
          testando.getInventory().clear();
          testando.setHealth(4.0D);
          testando.getInventory().setItem(10, AutoSoup.this.sopa);
          testando.getInventory().setItem(11, AutoSoup.this.sopa1);
          testando.getInventory().setItem(12, AutoSoup.this.sopa2);
        }
      }, 20L);
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(me.rafael.vinagre.KomboPvP.Main.getPlugin(), new Runnable()
      {
        public void run()
        {
          testando.getInventory().clear();
          testando.getInventory().setContents((ItemStack[])AutoSoup.saveinv.get(testando.getName()));
          testando.getInventory().setArmorContents((ItemStack[])AutoSoup.armadura.get(testando.getName()));
          testando.setHealth(20.0D);
        }
      }, 50L);
    }
    return false;
  }
}
