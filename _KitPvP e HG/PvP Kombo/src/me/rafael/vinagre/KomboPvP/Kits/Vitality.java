package me.rafael.vinagre.KomboPvP.Kits;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;

public class Vitality 
implements Listener, CommandExecutor
{

	@EventHandler
	  public void onKill(PlayerDeathEvent e)
	  {
	    if ((e.getEntity().getKiller() instanceof Player)) {
	      Player k = e.getEntity().getKiller();
	      if (Array.kit.get(k) == "Vitality") {
	        k.getInventory().remove(Material.BOWL);
	        try {
	          for (int i = 0; i < 36; i++)
	            k.getInventory().setItem(k.getInventory().firstEmpty(), new ItemStack(Material.MUSHROOM_SOUP));
	        }
	        catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException) {
	        }
	        k.sendMessage("§aSeu inventario está cheio de sopas!");
	        k.playSound(k.getLocation(), Sound.ENDERDRAGON_WINGS, 1.0F, 1.0F);
	        return;
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
	    
	    ItemStack capacete0 = new ItemStack(Material.AIR);
	    
	    ItemStack peitoral0 = new ItemStack(Material.AIR);
	    
	    ItemStack calca0 = new ItemStack(Material.AIR);
	    
	    ItemStack Bota0 = new ItemStack(Material.AIR);
	    
	    p.getInventory().setHelmet(capacete0);
	    p.getInventory().setChestplate(peitoral0);
	    p.getInventory().setLeggings(calca0);
	    p.getInventory().setBoots(Bota0);
		    
		  if(cmd.equalsIgnoreCase("vitality")){
		      if (Array.used.contains(p.getName())) {
		    	  p.sendMessage("§7» §cVoce ja esta usando um kit!");
		          return true;
		        }
			  
		      if (!p.hasPermission("kitpvp.kit.vitality")) {
			      p.sendMessage("§cVoce nao tem permissao para usar este kit !");
		        return true;
		      }
		      Array.used.add(p.getName());
		      p.sendMessage("§7» Voce escolheu o kit §cVitality §7!");
		      p.setGameMode(GameMode.ADVENTURE);
		      p.getInventory().clear();
		      Array.kit.put(p, "Vitality");
		      p.getInventory().addItem(new ItemStack[] { dima });
		      Main.give(p);
		      
		      Main.Dj.remove(p.getName());
		      Main.stomper.remove(p.getName());
		      Scoreboard.ScoreDoBasic.iscoriboard(p);
		      for (int i = 0; i <= 34; i++) {
		        p.getInventory().addItem(new ItemStack[] { sopa });
		       
		      }
		  }
		  me.rafael.vinagre.KomboPvP.Comandos.SetArena.TeleportArenaRandom(p);
		return true;
	  }
	}