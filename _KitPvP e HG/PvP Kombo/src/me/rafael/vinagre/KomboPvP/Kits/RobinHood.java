package me.rafael.vinagre.KomboPvP.Kits;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;

public class RobinHood 
implements Listener, CommandExecutor
{

	@EventHandler
	  public void onEntityDamageByEntity(EntityDamageByEntityEvent e)
	  {
	    if (((e.getDamager() instanceof Arrow)) && 
	      ((((Arrow)e.getDamager()).getShooter() instanceof Player)))
	    {
	      Arrow arrow = (Arrow)e.getDamager();
	      Player p = (Player)arrow.getShooter();
	      p.getLocation().distance(e.getEntity().getLocation());
	      if (((e.getEntity() instanceof Player)) && (Array.kit.get(p) == "RobinHood"))
	      {
	        p.playSound(p.getLocation(), Sound.WITHER_SHOOT, 1.0F, 1.0F);
	        e.setDamage(17.0D);
	      }
	    }
	  }

	  @EventHandler
	  public void robinHoodKill(PlayerDeathEvent e) {
	    if (!(e.getEntity().getKiller() instanceof Player)) {
	      return;
	    }
	    if (e.getEntity().getKiller() == null) {
	      return;
	    }
	    if (Array.kit.get(e.getEntity().getKiller()) == "RobinHood")
	      e.getEntity().getKiller().getInventory().addItem(new ItemStack[] { new ItemStack(Material.ARROW) });
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
	      ItemStack especial = new ItemStack(Material.BOW);
	      ItemMeta especial2 = especial.getItemMeta();
	      especial2.setDisplayName("§6Robin-Hood");
	      especial.setItemMeta(especial2);
	      ItemStack especial3 = new ItemStack(Material.ARROW);
	    
		    ItemStack capacete0 = new ItemStack(Material.AIR);
		    
		    ItemStack peitoral0 = new ItemStack(Material.AIR);
		    
		    ItemStack calca0 = new ItemStack(Material.AIR);
		    
		    ItemStack Bota0 = new ItemStack(Material.AIR);
	    
	    p.getInventory().setHelmet(capacete0);
	    p.getInventory().setChestplate(peitoral0);
	    p.getInventory().setLeggings(calca0);
	    p.getInventory().setBoots(Bota0);
		    
		    if (cmd.equalsIgnoreCase("robinhood")) {
		      if (Array.used.contains(p.getName())) {
		    	  p.sendMessage("§7» §cVoce ja esta usando um kit!");
		        return true;
		      }
		      if (!p.hasPermission("kitpvp.kit.robinhood")) {
			      p.sendMessage("§cVoce nao tem permissao para usar este kit !");
		        return true;
		      }
		      Array.used.add(p.getName());
		      p.sendMessage("§7» Voce escolheu o kit §cRobinHood §7!");
		      p.setGameMode(GameMode.ADVENTURE);
		      p.getInventory().clear();
		      Array.kit.put(p, "RobinHood");
		      p.getInventory().addItem(new ItemStack[] { dima });
		      p.getInventory().addItem(new ItemStack[] { especial });
		      p.getInventory().addItem(new ItemStack[] { especial3 });
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