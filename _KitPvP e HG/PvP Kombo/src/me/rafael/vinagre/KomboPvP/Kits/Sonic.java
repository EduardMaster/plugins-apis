package me.rafael.vinagre.KomboPvP.Kits;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;
public class Sonic implements Listener, CommandExecutor {
	  public int boost = Integer.valueOf(6).intValue();
	  public static ArrayList<String> Sonic = new ArrayList();
	  public static HashMap<String, ItemStack[]> Armadura = new HashMap();
	  public static Main plugin;
	  public static HashMap<String, ItemStack[]> saveinv = new HashMap();
	  public static HashMap<String, ItemStack[]> armadura = new HashMap();
	  public static HashMap<String, ItemStack[]> Armadura2 = new HashMap();
	  public static List<Player> cooldownm = new ArrayList();
	@EventHandler
	  public void SonicLick(PlayerInteractEvent event)
	  {
	    final Player p = event.getPlayer();
	    if ((event.getPlayer().getItemInHand().getType() == Material.LAPIS_BLOCK) && 
	      (Main.Sonic.contains(event.getPlayer().getName())))
	    {
	      if ((event.getAction() == Action.LEFT_CLICK_AIR) || 
	        (event.getAction() == Action.LEFT_CLICK_BLOCK) || 
	        (event.getAction() == Action.RIGHT_CLICK_BLOCK) || 
	        (event.getAction() == Action.RIGHT_CLICK_AIR)) {
	        event.setCancelled(true);
	      }
	      if (cooldownm.contains(p))
	      {
	        p.sendMessage("§b§lAguarde o cooldown acabar!");
	        return;
	      }
	      cooldownm.add(p);
	      Deshfire.fall.add(p.getName());
	      p.setVelocity(p.getEyeLocation().getDirection().multiply(this.boost).add(new Vector(0, 0, 0)));
	      p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 10, 0);
	      Location loc = p.getLocation();
	      for (Entity pertos : p.getNearbyEntities(8.0D, 8.0D, 8.0D)) {
	        if ((pertos instanceof Player))
	        {
	          Player perto = (Player)pertos;
	          ((Player)pertos).damage(10.0D);
	          pertos.setVelocity(new Vector(0.1D, 0.0D, 0.1D));
	          ((Player)pertos).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 105, 105));
	          p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 105, 105));
	        }
	      }
	      ItemStack Capacete = new ItemStack(Material.LEATHER_HELMET);
	      LeatherArmorMeta kCapacete = (LeatherArmorMeta)Capacete.getItemMeta();
	      kCapacete.setColor(Color.BLUE);
	      Capacete.setItemMeta(kCapacete);
	      
	      ItemStack Peitoral = new ItemStack(Material.LEATHER_CHESTPLATE);
	      LeatherArmorMeta kPeitoral = (LeatherArmorMeta)Peitoral.getItemMeta();
	      kPeitoral.setColor(Color.BLUE);
	      Peitoral.setItemMeta(kPeitoral);
	      
	      ItemStack Calss = new ItemStack(Material.LEATHER_LEGGINGS);
	      LeatherArmorMeta kCalss = (LeatherArmorMeta)Calss.getItemMeta();
	      kCalss.setColor(Color.BLUE);
	      Calss.setItemMeta(kCalss);
	      
	      ItemStack Bota = new ItemStack(Material.LEATHER_BOOTS);
	      LeatherArmorMeta kBota = (LeatherArmorMeta)Capacete.getItemMeta();
	      kBota.setColor(Color.BLUE);
	      Bota.setItemMeta(kBota);
	      
	      Armadura.put(p.getName(), p.getInventory().getArmorContents());
	      
	      p.getInventory().setHelmet(Capacete);
	      p.getInventory().setChestplate(Peitoral);
	      p.getInventory().setLeggings(Calss);
	      p.getInventory().setBoots(Bota);
	      p.updateInventory();
	      
	      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	          p.getInventory().setArmorContents(null);
	          p.updateInventory();
	          Deshfire.fall.remove(p.getName());
	        }
	      }, 50L);
	      

	      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	          cooldownm.remove(p);
	          Main.Sonic.remove(p);
	          p.sendMessage("§3§oVoce pode usar novamente!");
	          p.getWorld().playSound(p.getLocation(), Sound.BURP, 5.0F, 5.0F);
	        }
	      }, 700L);
	    }
	  }
	 @EventHandler
	  public void onDrop(PlayerDropItemEvent event)
	  {
	    if (event.getItemDrop().getItemStack().getType() == Material.LAPIS_BLOCK)
	      event.setCancelled(true);
	  }

public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args)
{
  Player p = (Player)sender;
  ItemStack dima = new ItemStack(Material.STONE_SWORD);
  ItemMeta souperaa = dima.getItemMeta();
  souperaa.setDisplayName("§bEspada");
  dima.setItemMeta(souperaa);
  ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
  ItemMeta sopas = sopa.getItemMeta();
  sopas.setDisplayName("§6Sopa");
  sopa.setItemMeta(sopas);
	  ItemStack especial = new ItemStack(Material.LAPIS_BLOCK);
	    ItemMeta especial1 = especial.getItemMeta();
	    especial1.setDisplayName("§bSonic!");
	    especial.setItemMeta(especial1);
  
  ItemStack capacete0 = new ItemStack(Material.AIR);
  
  ItemStack peitoral0 = new ItemStack(Material.AIR);
  
  ItemStack calca0 = new ItemStack(Material.AIR);
  
  ItemStack Bota0 = new ItemStack(Material.AIR);
  
  p.getInventory().setHelmet(capacete0);
  p.getInventory().setChestplate(peitoral0);
  p.getInventory().setLeggings(calca0);
  p.getInventory().setBoots(Bota0);

if (cmd.equalsIgnoreCase("sonic")) {
  if (Array.used.contains(p.getName())) {
  	p.sendMessage("§7» §cVoce ja esta usando um kit!");
    return true;
  }
  if (!p.hasPermission("kitpvp.kit.sonic")) {
	      p.sendMessage("§cVoce nao tem permissao para usar este kit !");
    return true;
  }


  Array.used.add(p.getName());
  p.sendMessage("§7» Voce escolheu o kit §cSonic §7!");
  p.setGameMode(GameMode.ADVENTURE);
  p.getInventory().clear();
  Array.kit.put(p, "Sonic");
  p.getInventory().addItem(new ItemStack[] { dima });
  p.getInventory().addItem(new ItemStack[] { especial });
  Main.give(p);
  Main.Deshfire.remove(p.getName());
  Main.Dj.remove(p.getName());
  Main.Sonic.add(p.getName());
  Main.stomper.remove(p.getName());
  
  Scoreboard.ScoreDoBasic.iscoriboard(p);
  for (int i = 0; i <= 34; i++) {
    p.getInventory().addItem(new ItemStack[] { sopa });

  }
}
me.rafael.vinagre.KomboPvP.Comandos.SetArena.TeleportArenaRandom(p);
return false;
}
}
