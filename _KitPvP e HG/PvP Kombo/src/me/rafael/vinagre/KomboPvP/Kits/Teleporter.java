package me.rafael.vinagre.KomboPvP.Kits;
import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;
public class Teleporter implements CommandExecutor, Listener {

	@EventHandler
	  public void onEnderArcher(ProjectileHitEvent e)
	  {
	    if ((e.getEntity() instanceof Arrow))
	    {
	      Arrow a = (Arrow)e.getEntity();
	      if ((a.getShooter() instanceof Player))
	      {
	        Player p = (Player)a.getShooter();
	        if ((Array.kit.get(p) == "Teleporter"))
	        {
	          Location loc = a.getLocation();
	          p.teleport(loc);
	          p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5.0F, 1.0F);
	          p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1);
	          
	          p.sendMessage("§5Teleportado!");
	          a.remove();
	          return;
	        }
	      }
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

  ItemStack especial = new ItemStack(Material.ARROW, 20);
  ItemStack especial2 = new ItemStack(Material.BOW);
  
  
  ItemStack capacete0 = new ItemStack(Material.AIR);
  
  ItemStack peitoral0 = new ItemStack(Material.AIR);
  
  ItemStack calca0 = new ItemStack(Material.AIR);
  
  ItemStack Bota0 = new ItemStack(Material.AIR);
  
  p.getInventory().setHelmet(capacete0);
  p.getInventory().setChestplate(peitoral0);
  p.getInventory().setLeggings(calca0);
  p.getInventory().setBoots(Bota0);
  
  if (cmd.equalsIgnoreCase("teleporter")) {
    if (Array.used.contains(p.getName())) {
  	  p.sendMessage(" §7» §cVoce ja esta usando um kit!");
      return true;
    }
    if (!p.hasPermission("kitpvp.kit.teleporter")) {
	      p.sendMessage("§cVoce nao tem permissao para usar este kit !");
      return true;
    }
    Array.used.add(p.getName());
    p.sendMessage(" §7» Voce escolheu o kit §cTeleporter §7!");
    p.setGameMode(GameMode.ADVENTURE);
    p.getInventory().clear();
    Array.kit.put(p, "Teleporter");
    p.getInventory().addItem(new ItemStack[] { dima });
    p.getInventory().addItem(new ItemStack[] { especial2 });
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
}
