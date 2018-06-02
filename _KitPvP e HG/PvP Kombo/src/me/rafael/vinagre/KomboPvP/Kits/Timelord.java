package me.rafael.vinagre.KomboPvP.Kits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.GameMode;
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

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;

public class Timelord
implements Listener, CommandExecutor
{
public static Main plugin;

public Timelord(Main main)
{
  plugin = main;
}

public ArrayList<String> frozenPlayers = new ArrayList();
public static ArrayList<String> cooldownt = new ArrayList();

@EventHandler
public void timelordkit(PlayerInteractEvent e)
{
  final Player p = e.getPlayer();
  if ((e.getAction() == Action.RIGHT_CLICK_AIR) || 
    (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
    if ((p.getItemInHand().getType() == Material.WATCH) && 
    		(Array.kit.get(p) == "Timelord")) {
    	
      if (cooldownt.contains(p.getName())) {
        p.sendMessage("§7Espere para usar novamente!");
      } else {
        for (Entity frozen : p.getNearbyEntities(4.0D, 4.0D, 4.0D)) {
          if ((frozen != null) && ((frozen instanceof Player)))
          {
            Array.freeze.add(((Player)frozen).getName());
            if (!Array.freezing.contains(p.getName()))
            {
              p.getWorld().playEffect(p.getLocation(), Effect.POTION_BREAK, 10);
              p.getWorld().playSound(p.getLocation(), Sound.WITHER_SHOOT, 10.0F, 1.0F);
              Array.freezing.add(p.getName());
              cooldownt.add(p.getName());
              Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
                {
                  public void run()
                  {
                    Array.freezing.remove(p.getName());
                    Timelord.cooldownt.remove(p.getName());
                    p.sendMessage("§7TimeLord recarregado!");
                  }
                }, 600L);
            }
          }
        }
      }
    }
  }
}

@EventHandler
public void onPlayerMove(PlayerMoveEvent e)
{
  final Player p = e.getPlayer();
  if ((Array.freeze.contains(p.getName())) && 
    (!Array.freezing.contains(p.getName())))
  {
    e.setTo(p.getLocation());
    p.sendMessage("§7Voce foi congelado por um TimeLord!!");
    plugin.getServer().getScheduler()
      .scheduleSyncDelayedTask(plugin, new Runnable()
      {
        public void run()
        {
          Array.freeze.remove(p.getName());
        }
      }, 100L);
  }
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
	    ItemStack especial = new ItemStack(Material.WATCH);
	    ItemMeta especial1 = especial.getItemMeta();
	    especial1.setDisplayName("§bTimelord");
	    especial.setItemMeta(especial1);
  
	    ItemStack capacete0 = new ItemStack(Material.AIR);
	    
	    ItemStack peitoral0 = new ItemStack(Material.AIR);
	    
	    ItemStack calca0 = new ItemStack(Material.AIR);
	    
	    ItemStack Bota0 = new ItemStack(Material.AIR);
  
		p.getInventory().setHelmet(capacete0);
		p.getInventory().setChestplate(peitoral0);
		p.getInventory().setLeggings(calca0);
		p.getInventory().setBoots(Bota0);
	    
	    if (cmd.equalsIgnoreCase("timelord")) {
	      if (Array.used.contains(p.getName())) {
	    	  p.sendMessage("§7» §cVoce ja esta usando um kit!");
	        return true;
	      }
	      if (!p.hasPermission("kitpvp.kit.timelord")) {
		      p.sendMessage("§cVoce nao tem permissao para usar este kit !");
	        return true;
	      }
	      Array.used.add(p.getName());
	      p.sendMessage("§7» Voce escolheu o kit §cTimelord §7!");
	      p.setGameMode(GameMode.ADVENTURE);
	      p.getInventory().clear();
	      Array.kit.put(p, "Timelord");
	      Main.Dj.remove(p.getName());
	      Main.stomper.remove(p.getName());
	     
	      Scoreboard.ScoreDoBasic.iscoriboard(p);
	      p.getInventory().addItem(new ItemStack[] { dima });
	      p.getInventory().addItem(new ItemStack[] { especial });
	      Main.give(p);
	      for (int i = 0; i <= 34; i++) {
	        p.getInventory().addItem(new ItemStack[] { sopa });
	        
	      }
	    }
	    me.rafael.vinagre.KomboPvP.Comandos.SetArena.TeleportArenaRandom(p);
	    return false;
	  }
}