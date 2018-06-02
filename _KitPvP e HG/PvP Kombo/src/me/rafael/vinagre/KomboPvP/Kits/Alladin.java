package me.rafael.vinagre.KomboPvP.Kits;

import java.util.ArrayList;



import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;

public class Alladin 
implements Listener, CommandExecutor
{
	public Main plugin;
	public Alladin(){
		
	}
	
	public static ArrayList<String> cooldown = new ArrayList();
	
	@EventHandler
	public void clicar(PlayerInteractEvent e){
		final Player p = e.getPlayer();
		if((Array.kit.get(p) == "Alladin") && (p.getItemInHand().getType() == Material.CARPET) && (e.getAction() == Action.RIGHT_CLICK_AIR)){
			e.setCancelled(true);
			
			if(cooldown.contains(p.getName())){
				p.sendMessage("§cKit em cooldown !");
				return;
			}
			
			final FallingBlock tapete = p.getWorld().spawnFallingBlock(p.getLocation().clone().add(0.0D, 1.0D, 0.0D), Material.CARPET.getId(), (byte)0);
	        tapete.setDropItem(false);
	        tapete.setVelocity(new Vector(0, 0, 0));
	        tapete.setPassenger(p);
	        Location loc = p.getLocation().clone();
	        loc.setPitch(0.0F);
	        cooldown.add(p.getName());
	        Vector vec = p.getVelocity().clone();
	        int forca = 7;
	        Vector pular = vec.multiply(0.1D).setY(0.17D * forca);
	        Vector olhar = loc.getDirection().normalize().multiply(1.5D);
	        tapete.setVelocity(pular.add(olhar));
	        
	        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
	        {
	          public void run()
	          {
	            tapete.remove();
	            p.sendMessage("§cTapete removido !");
	          }
	        }, 50L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				
				public void run() {
					if(cooldown.contains(p.getName())){
						cooldown.remove(p.getName());
						p.sendMessage("§bVoce ja pode usar o Alladin !");
						p.playSound(p.getLocation(), Sound.BURP, 1.0F, 1.0F);
					}
				}
			}, 40 * 20L);
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
	    ItemStack carpete = new ItemStack(Material.CARPET);
	    ItemMeta carpete2 = carpete.getItemMeta();
	    carpete2.setDisplayName("§bAlladin");
	    carpete.setItemMeta(carpete2);
	    
	    ItemStack capacete0 = new ItemStack(Material.AIR);
	    
	    ItemStack peitoral0 = new ItemStack(Material.AIR);
	    
	    ItemStack calca0 = new ItemStack(Material.AIR);
	    
	    ItemStack Bota0 = new ItemStack(Material.AIR);
	    
	    p.getInventory().setHelmet(capacete0);
	    p.getInventory().setChestplate(peitoral0);
	    p.getInventory().setLeggings(calca0);
	    p.getInventory().setBoots(Bota0);
	    
	    if (cmd.equalsIgnoreCase("alladin")) {
	      if (Array.used.contains(p.getName())) {
	    	  p.sendMessage(" §7» §cVoce ja esta usando um kit !");
	        return true;
	      }
	      if (!p.hasPermission("kitpvp.kit.alladin")) {
		      p.sendMessage("§cVoce nao tem permissao para usar este kit !");
	        return true;
	      }
	      Array.used.add(p.getName());
	      p.sendMessage(" §7» Voce escolheu o kit §cAlladin §7!");
	      p.setGameMode(GameMode.ADVENTURE);
	      p.getInventory().clear();
	      Array.kit.put(p, "Alladin");
	      p.getInventory().addItem(new ItemStack[] { dima });
	      p.getInventory().addItem(carpete);
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