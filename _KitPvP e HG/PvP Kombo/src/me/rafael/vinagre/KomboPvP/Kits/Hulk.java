package me.rafael.vinagre.KomboPvP.Kits;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;

public class Hulk 
implements Listener, CommandExecutor
{
	{
	
	}
		  public static HashMap<String, Long> cooldown = new HashMap();
		  public static Main plugin;
		  
		  public Hulk(Main main)
		  {
		    plugin = main;
		  }
		  
		  public Hulk() {}
		  
		  @EventHandler
		  public void pegar(PlayerInteractEntityEvent e)
		  {
		    Player p = e.getPlayer();
		    if ((e.getRightClicked() instanceof Player))
		    {
		      Player r = (Player)e.getRightClicked();
		      if ((((Array.kit.get(p) == "Hulk")))) {
		        if ((!cooldown.containsKey(p.getName())) || (((Long)cooldown.get(p.getName())).longValue() <= System.currentTimeMillis()))
		        {
		          if (p.getItemInHand().getType() == Material.SADDLE)
		          {
		            e.setCancelled(true);
		            p.updateInventory();
		            p.setPassenger(r);
		            cooldown.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(15L)));
		            p.sendMessage(ChatColor.GOLD + "Voce pegou o player: " + ChatColor.WHITE + r.getName());
		            r.sendMessage(ChatColor.GOLD + "Voce foi pego pelo Hulk: " + ChatColor.WHITE + p.getName());
		          }
		        }
		        else {
		          p.sendMessage(ChatColor.RED + "Cooldown");
		        }
		      }
		    }
		  }
		  
		  @EventHandler
		  public static void playerInteract(PlayerInteractEvent event)
		  {
		    if (!event.getAction().equals(Action.LEFT_CLICK_AIR)) {
		      return;
		    }
		    Player player = event.getPlayer();
		    if ((player.getPassenger() == null) || (!(player.getPassenger() instanceof Player))) {
		      return;
		    }
		    Player pass = (Player)player.getPassenger();
		    player.eject();
		    pass.damage(0.0D, player);
		    pass.setVelocity(new Vector(pass.getVelocity().getX(), 1.0D, pass.getVelocity().getZ()));
		    pass.sendMessage(ChatColor.RED + "Voce foi jogado por " + ChatColor.DARK_RED + player.getName());
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
	    ItemStack especial = new ItemStack(Material.SADDLE);
	    ItemMeta especial1 = especial.getItemMeta();
	    especial1.setDisplayName("§2Hulk");
	    especial.setItemMeta(especial1);
	    
	    ItemStack capacete0 = new ItemStack(Material.AIR);
	    
	    ItemStack peitoral0 = new ItemStack(Material.AIR);
	    
	    ItemStack calca0 = new ItemStack(Material.AIR);
	    
	    ItemStack Bota0 = new ItemStack(Material.AIR);
	    
	    p.getInventory().setHelmet(capacete0);
	    p.getInventory().setChestplate(peitoral0);
	    p.getInventory().setLeggings(calca0);
	    p.getInventory().setBoots(Bota0);
		    
		    if (cmd.equalsIgnoreCase("hulk")) {
		      if (Array.used.contains(p.getName())) {
		    	  p.sendMessage("§7» §cVoce ja esta usando um kit!");
		        return true;
		      }
		      if (!p.hasPermission("kitpvp.kit.hulk")) {
			      p.sendMessage("§cVoce nao tem permissao para usar este kit !");
		        return true;
		      }
		      Array.used.add(p.getName());
		      p.sendMessage("§7» Voce escolheu o kit §cHulk §7!");
		      p.setGameMode(GameMode.ADVENTURE);
		      p.getInventory().clear();
		      Array.kit.put(p, "Hulk");
		      p.getInventory().addItem(new ItemStack[] { dima });
		      p.getInventory().addItem(new ItemStack [] { especial });
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