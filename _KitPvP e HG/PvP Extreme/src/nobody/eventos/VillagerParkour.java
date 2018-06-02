package nobody.eventos;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class VillagerParkour implements Listener,CommandExecutor {
	
	
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    Player p = (Player)sender;
	    if ((label.equalsIgnoreCase("villagerparkour")) &&
	      (p.hasPermission("tk.parkour")))
	    {
	      Villager vill = (Villager)p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
	      vill.setCustomName("§e• §fMestre do Parkour §6•");
	      vill.setCustomNameVisible(true);
	      vill.setProfession(Villager.Profession.BUTCHER);
	    }
	    return false;
	  }
	  
	
	@EventHandler
	public void onPlayer(PlayerMoveEvent e)
	{
	  Player p = e.getPlayer();

	   if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.HAY_BLOCK) {
	  {
		  /* 37 */     if (KitAPI.getkit(p) == "Nenhum") {
		    p.sendMessage("§7[§6§l!§7] §eClique no §Mestre do Parkour Para Iniciar o §cParkour! ");
		    p.playSound(p.getLocation(), Sound.ANVIL_USE, 1.0F, 7.0F);
			  Location l = new Location(p.getWorld(), 193.0, 139.0, 1553.0);
			  p.teleport(l);
	    
	    }else{
	    	/* 37 */     if (KitAPI.getkit(p) == "Parkour") {
		  e.setCancelled(false); 
		  }
	  }
	}
	   }
	}
		@EventHandler
		public void asd(EntityDamageEvent e)
		{
			  Player p = (Player) e.getEntity();
			  /* 37 */     if (KitAPI.getkit(p) == "Parkour") {
				  {
				     if (e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
					      e.setCancelled(true);
					      Location Warp = new Location(p.getWorld(), 5000.0D ,100.0D, 7011.0D);
					      p.teleport(Warp);
					      p.sendMessage("§7[§6§l!§7] §cOpa!, Você Errou!");
					      p.setHealth(20.0D); 
					      Location l = new Location(p.getWorld(), 193.0, 139.0, 1553.0);
			  p.teleport(l);
		    }
		    }
		}
		}
	    @EventHandler
	    public void onQuest(PlayerInteractEntityEvent e)
	    {
	      if ((e.getRightClicked() instanceof Villager))
	      {
	        Player p = e.getPlayer();
	        Villager vill = (Villager)e.getRightClicked();
	        if (vill.getCustomName().equals("§e• §fMestre do Parkour §6•"))
	        {
	        if (KitAPI.getkit(p) == "Nenhum") {
	          e.setCancelled(true);
	          p.getInventory().clear();
	          p.sendMessage("§7[§6§l!§7] §eVocê entrou no modo de §cParkour!");
	          KitAPI.setKit(p, "Parkour");
	          p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0F, 0.8F);
			  Location l = new Location(p.getWorld(), 193.0, 139.0, 1553.0);
			  p.teleport(l);
	          ItemStack Chest = new ItemStack(Material.REDSTONE);
	          ItemMeta Chest1 = Chest.getItemMeta();
	          Chest1.setDisplayName("§aSair do §cParkour");
	          Chest.setItemMeta(Chest1);
	          p.getInventory().setItem(8, Chest);
	        }else{
		    	 e.setCancelled(true);
		    	 p.sendMessage("§7[§6§l!§7] §aVocê saiu do Parkour");
		    	 p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
		 	    p.teleport(p.getWorld().getSpawnLocation());
		    	 Join.entrar(p);
		    	 p.updateInventory();
	        } 
	          {
	        }
	        }
	      
	        }
	      }
	    
		@EventHandler
		
		  public void inte(PlayerInteractEvent e)
		  {
		    Player p = e.getPlayer();
		     if (KitAPI.getkit(p) == "Parkour" &&
		     ((p.getItemInHand().getType() == Material.REDSTONE) && (
		      (e.getAction() == Action.RIGHT_CLICK_AIR) || 
		      (e.getAction() == Action.RIGHT_CLICK_BLOCK) || 
		      (e.getAction() == Action.LEFT_CLICK_AIR) || 
		      (e.getAction() == Action.LEFT_CLICK_BLOCK)))) {
		    	 p.sendMessage("§7[§6§l!§7] §aVocê saiu do Parkour");
		    	 p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
		 	    p.teleport(p.getWorld().getSpawnLocation());
		    	 Join.entrar(p);
		    	 p.updateInventory();
		    	 }
		     
		    }
	    @EventHandler
	    public void SemTomarDano(EntityDamageByEntityEvent e)
	    {
	      if ((e.getEntity() instanceof Villager)) {
	        e.setCancelled(true);
	      }
	    }
	  }

