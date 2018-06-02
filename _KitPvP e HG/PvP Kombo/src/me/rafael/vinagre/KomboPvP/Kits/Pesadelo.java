package me.rafael.vinagre.KomboPvP.Kits;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;

public class Pesadelo
  implements Listener, CommandExecutor
{
  public me.rafael.vinagre.KomboPvP.Main plugin;
  
  public Pesadelo()
  {
    this.plugin = plugin;
  }
  
  public static ArrayList<Player> nightmare = new ArrayList();
  public static ArrayList<Player> cooldown = new ArrayList();
  
  @EventHandler
  public void deathe(PlayerDeathEvent e)
  {
    Player p = e.getEntity();
    
    nightmare.remove(p);
    cooldown.remove(p);
  }
  
  @EventHandler
  public void ent(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();
    
    nightmare.remove(p);
    cooldown.remove(p);
  }
  
  public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args)
  {
    Player p = (Player)sender;
    ItemStack dima = new ItemStack(Material.STONE_SWORD);
    ItemMeta souperaa = dima.getItemMeta();
    souperaa.setDisplayName("§cEspada");
    dima.setItemMeta(souperaa);
    ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
    ItemMeta sopas = sopa.getItemMeta();
    sopas.setDisplayName("§6Sopa");
    sopa.setItemMeta(sopas);
    ItemStack especial = new ItemStack(Material.DRAGON_EGG);
    ItemMeta especial1 = especial.getItemMeta();
    especial1.setDisplayName("§0Pesadelo");
    especial.setItemMeta(especial1);
    
    ItemStack capacete0 = new ItemStack(Material.AIR);
    
    ItemStack peitoral0 = new ItemStack(Material.AIR);
    
    ItemStack calca0 = new ItemStack(Material.AIR);
    
    ItemStack Bota0 = new ItemStack(Material.AIR);
    
    p.getInventory().setHelmet(capacete0);
    p.getInventory().setChestplate(peitoral0);
    p.getInventory().setLeggings(calca0);
    p.getInventory().setBoots(Bota0);
    
    if (cmd.equalsIgnoreCase("pesadelo")) {
      if (Array.used.contains(p.getName())) {
    	  p.sendMessage("§7» §cVoce ja esta usando um kit!");
        return true;
      }
      if (!p.hasPermission("kitpvp.kit.pesadelo")) {
	      p.sendMessage("§cVoce nao tem permissao para usar este kit !");
        return true;
      }
      Array.used.add(p.getName());
      p.sendMessage("§7» Voce escolheu o kit §cRyu §7!");
      p.setGameMode(GameMode.ADVENTURE);
      p.getInventory().clear();
      Array.kit.put(p, "Ryu");
      p.getInventory().addItem(new ItemStack[] { dima });
      p.getInventory().addItem(new ItemStack[] { especial });
      Main.give(p);
      Main.Dj.remove(p.getName());
      Main.stomper.remove(p.getName());
     
      Scoreboard.ScoreDoBasic.iscoriboard(p);
      for (int i = 0; i <= 34; i++) {
        p.getInventory().addItem(new ItemStack[] { sopa });
       
      }
    }
    me.rafael.vinagre.KomboPvP.Comandos.SetArena.TeleportArenaRandom(p);
    return false;
  }

  
  @EventHandler
  public void onTimeFreeze(PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    if (!nightmare.contains(p)) {
      return;
    }
    if (p.getItemInHand().getType() != Material.DRAGON_EGG) {
      return;
    }
    if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
    {
      if (cooldown.contains(p))
      {
        p.sendMessage(ChatColor.RED + "Voce nao pode causar pesadelos ainda , Freddy!");
        return;
      }
      cooldown.add(p);
      p.sendMessage(ChatColor.BLACK + "Freddy , voce causou um pesadelo!");
      for (Entity target : p.getNearbyEntities(15.0D, 15.0D, 15.0D)) {
        if ((target instanceof Player))
        {
          Player pl = (Player)target;
          pl.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 0));
          pl.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 0));
          pl.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 200, 0));
          pl.sendMessage(ChatColor.DARK_RED + "Voce esta tendo um pesadelo!");
        }
      }
      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
      {
        public void run()
        {
          Pesadelo.cooldown.remove(p);
          p.sendMessage(ChatColor.GREEN + "Vai em frente Freddy , cause a desgraça!");
        }
      }, 1200L);
    }
  }
}



