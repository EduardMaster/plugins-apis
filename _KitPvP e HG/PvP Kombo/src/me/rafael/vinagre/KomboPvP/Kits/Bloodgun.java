package me.rafael.vinagre.KomboPvP.Kits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;

public class Bloodgun implements CommandExecutor, Listener {
	public static ArrayList<Player> cooldown = new ArrayList<>();
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
	    ItemStack especial = new ItemStack(Material.WOOD_HOE);
	    ItemMeta especial1 = sopa.getItemMeta();
	    especial1.setDisplayName("§cAK-47");
	    especial.setItemMeta(especial1);
	    
	    ItemStack capacete0 = new ItemStack(Material.AIR);
	    
	    ItemStack peitoral0 = new ItemStack(Material.AIR);
	    
	    ItemStack calca0 = new ItemStack(Material.AIR);
	    
	    ItemStack Bota0 = new ItemStack(Material.AIR);
	    
	    p.getInventory().setHelmet(capacete0);
	    p.getInventory().setChestplate(peitoral0);
	    p.getInventory().setLeggings(calca0);
	    p.getInventory().setBoots(Bota0);
	    
	    if (cmd.equalsIgnoreCase("bloodgun")) {
	      if (Array.used.contains(p.getName())) {
	    	  p.sendMessage(" §7» §cVoce ja esta usando um kit!");
	        return true;
	      }
	      if (!p.hasPermission("kitpvp.kit.bloodgun")) {
		      p.sendMessage("§cVoce nao tem permissao para usar este kit !");
	        return true;
	      }
	      Array.used.add(p.getName());
	      p.sendMessage(" §7» Voce escolheu o kit §cBloodgun §7!");
	      p.setGameMode(GameMode.ADVENTURE);
	      p.getInventory().clear();
	      Array.kit.put(p, "Bloodgun");
	      Main.stomper.remove(p.getName());
	      p.getInventory().addItem(new ItemStack[] { dima });
	      Main.give(p);
	      Main.Dj.remove(p.getName());
	      
	      p.getInventory().addItem(new ItemStack[] { especial });
	      Scoreboard.ScoreDoBasic.iscoriboard(p);
	      for (int i = 0; i <= 34; i++) {
	        p.getInventory().addItem(new ItemStack[] { sopa });
	        
	      }
	    }
	    me.rafael.vinagre.KomboPvP.Comandos.SetArena.TeleportArenaRandom(p);
	    return false;
	  }
	


@EventHandler
public void BloodClick(PlayerInteractEvent event)
{
  final Player p = event.getPlayer();
  if ((event.getPlayer().getItemInHand().getType() == Material.WOOD_HOE) && 
    (Array.kit.get(p) == "Bloodgun"))
  {
    if ((event.getAction() == Action.RIGHT_CLICK_BLOCK) || 
      (event.getAction() == Action.RIGHT_CLICK_AIR) || 
      (event.getAction() == Action.LEFT_CLICK_AIR) || 
      (event.getAction() == Action.LEFT_CLICK_BLOCK)) {
      event.setCancelled(true);
    }
    if (cooldown.contains(p))
    {
      p.sendMessage("§c§oAguarde o cooldown acabar!");
    }
    else
    {
      Vector velo1 = p.getLocation().getDirection().normalize().multiply(10);
      Fireball boladenve = (Fireball)p.launchProjectile(Fireball.class);
      boladenve.setIsIncendiary(true);
      boladenve.setYield(0.0F);
      boladenve.setVelocity(velo1);
      Location location = p.getEyeLocation();
      BlockIterator blocksToAdd = new BlockIterator(location, 0.0D, 30);
      while (blocksToAdd.hasNext())
      {
        Location blockToAdd = blocksToAdd.next().getLocation();
        Effect a = Effect.STEP_SOUND;
        p.getWorld().playEffect(blockToAdd, a, 152);
        cooldown.add(p);
        
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
        {
          public void run()
          {
            Bloodgun.cooldown.remove(p);
          }
        }, 200L);
      }
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
          p.sendMessage("§a§oVoce pode usar novamente!");
        }
      }, 200L);
    }
  }
}
}
