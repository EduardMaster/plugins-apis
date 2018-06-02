package me.rafael.vinagre.KomboPvP.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffectType;

import Scoreboard.ScoreDoBasic;
import me.rafael.vinagre.KomboPvP.Main;


@SuppressWarnings("deprecation")
public class Events implements Listener {
	public Events(Main main) {
	}

	@EventHandler
	public void Fome(FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void fullJoin(PlayerLoginEvent event) {
		Player p = event.getPlayer();
		if (event.getResult() == PlayerLoginEvent.Result.KICK_FULL) {
			if (p.hasPermission("kitpvp.vip")) {
				event.setResult(PlayerLoginEvent.Result.ALLOWED);
			} else {
				event.setKickMessage("§cServidor Cheio! §aCompre vip > " + Strings.Site);
			}
		} else if (event.getResult() == PlayerLoginEvent.Result.KICK_WHITELIST) {
			event.setKickMessage(ChatColor.GRAY + "Servidor com WhiteList voce nao esta listado!!");
		}
	}
	


	@EventHandler
	public void onReload(PlayerCommandPreprocessEvent event) {
		Player p = event.getPlayer();

		String msg = event.getMessage();
		if (((msg.equalsIgnoreCase("/rl")) || (msg.equalsIgnoreCase("/reload"))) && (p.isOp())
				&& (p.hasPermission("dar.reload"))) {
			event.setCancelled(true);

			Bukkit.reload();
			Bukkit.broadcastMessage( "§5§lServidor Reloading");
		}
	}

	@EventHandler
	public void DisableFireSpread(BlockSpreadEvent e) {
		if (e.getNewState().getType() == Material.FIRE) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		{
			e.setCancelled(false);
		}
		if ((e.getItemDrop().getItemStack().getType() == Material.BOWL)) {
			e.setCancelled(true);
		}
		
		if ((e.getItemDrop().getItemStack().getType() == Material.RED_MUSHROOM)) {
			e.setCancelled(false);
		}
		if ((e.getItemDrop().getItemStack().getType() == Material.BROWN_MUSHROOM)) {
			e.setCancelled(false);
		}
		if ((e.getItemDrop().getItemStack().getType() == Material.COMPASS)) {
			e.setCancelled(false);
		}
		if ((e.getItemDrop().getItemStack().getType() == Material.EXP_BOTTLE)) {
			e.setCancelled(false);
		}

	}

	
	   @EventHandler
	    private void onCommand(PlayerCommandPreprocessEvent e){
	    	Player p = e.getPlayer();
	    	
	    	if(e.getMessage().contains("/kills")){
	    		if(p.hasPermission("kitpvp.darkills")){
	        		e.setCancelled(false);
	        	}else{
	        		p.sendMessage("§4§lErro: §c§lAcesso negado");
	        		e.setCancelled(true);
	        	}
	    		
	    	}
	    	
	    }
	   @EventHandler
	    private void onCommand2(PlayerCommandPreprocessEvent e){
	    	Player p = e.getPlayer();
	    	
	    	if(e.getMessage().contains("/admin")){
	    		if(p.hasPermission("kitpvp.admin")){
	        		e.setCancelled(false);
	        	}else{
	        		p.sendMessage("§4§lErro: §c§lAcesso negado");
	        		e.setCancelled(true);
	        	}
	    		
	    	}
	    	
	    }
	   @EventHandler
	    private void onCommand3(PlayerCommandPreprocessEvent e){
	    	Player p = e.getPlayer();
	    	
	    	if(e.getMessage().contains("/cc")){
	    		if(p.hasPermission("kitpvp.cc")){
	        		e.setCancelled(false);
	        	}else{
	        		p.sendMessage("§4§lErro: §c§lAcesso negado");
	        		e.setCancelled(true);
	        	}
	    		
	    	}
	    	
	    }
	   @EventHandler
	    private void onCommand4(PlayerCommandPreprocessEvent e){
	    	Player p = e.getPlayer();
	    	
	    	if(e.getMessage().contains("/tp")){
	    		if(p.hasPermission("kitpvp.tp")){
	        		e.setCancelled(false);
	        	}else{
	        		p.sendMessage("§4§lErro: §c§lAcesso negado");
	        		e.setCancelled(true);
	        	}
	    		
	    	}
	    	
	    }
	   @EventHandler
	    private void onCommand5(PlayerCommandPreprocessEvent e){
	    	Player p = e.getPlayer();
	    	
	    	if(e.getMessage().contains("/setspawn")){
	    		if(p.hasPermission("set.spawn")){
	        		e.setCancelled(false);
	        	}else{
	        		p.sendMessage("§4§lErro: §c§lAcesso negado");
	        		e.setCancelled(true);
	        	}
	    		
	    	}
	    	
	    }
    @EventHandler
    public void NerfsDanos(final EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            final Player player = (Player)event.getDamager();
            if (event.getDamage() > 1.0) {
                event.setDamage(event.getDamage() - 1.0);
            }
            if (event.getDamager() instanceof Player) {
                if (player.getFallDistance() > 0.0f && !player.isOnGround() && !player.hasPotionEffect(PotionEffectType.BLINDNESS)) {
                    final int NewDamage = (int)(event.getDamage() * 1.5) - (int)event.getDamage();
                    if (event.getDamage() > 1.0) {
                        event.setDamage(event.getDamage() - NewDamage);
                    }
                }
                if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
                    event.setDamage(2.0);
                }
                if (player.getItemInHand().getType() == Material.STONE_SWORD) {
                    event.setDamage(3.0);
                }
                if (player.getItemInHand().getType() == Material.IRON_SWORD) {
                    event.setDamage(4.0);
                }
                if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
                    event.setDamage(5.0);
                }
                if (player.getItemInHand().getType() == Material.WOOD_AXE) {
                    event.setDamage(1.0);
                }
                if (player.getItemInHand().getType() == Material.STONE_AXE) {
                    event.setDamage(3.0);
                }
                if (player.getItemInHand().getType() == Material.IRON_AXE) {
                    event.setDamage(4.0);
                }
                if (player.getItemInHand().getType() == Material.DIAMOND_AXE) {
                    event.setDamage(5.0);
                }
                if (player.getItemInHand().containsEnchantment(Enchantment.DAMAGE_ALL)) {
                    event.setDamage(event.getDamage() + 1.0);
                }
                if (player.getFallDistance() > 0.0f && !player.isOnGround() && !player.hasPotionEffect(PotionEffectType.BLINDNESS)) {
                    if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
                        event.setDamage(event.getDamage() + 1.0);
                    }
                    if (player.getItemInHand().getType() == Material.STONE_SWORD) {
                        event.setDamage(event.getDamage() + 1.0);
                    }
                    if (player.getItemInHand().getType() == Material.IRON_SWORD) {
                        event.setDamage(event.getDamage() + 1.0);
                    }
                    if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
                        event.setDamage(event.getDamage() + 1.0);
                    }
                    if (player.getFallDistance() > 0.0f && player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
                        if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
                            event.setDamage(event.getDamage() + 1.5);
                        }
                        if (player.getItemInHand().getType() == Material.STONE_SWORD) {
                            event.setDamage(event.getDamage() + 1.5);
                        }
                        if (player.getItemInHand().getType() == Material.IRON_SWORD) {
                            event.setDamage(event.getDamage() + 1.5);
                        }
                        if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
                            event.setDamage(event.getDamage() + 1.5);
                        }
                        if (player.getItemInHand().getType() == Material.WOOD_AXE) {
                            event.setDamage(event.getDamage() + 1.5);
                        }
                        if (player.getItemInHand().getType() == Material.STONE_AXE) {
                            event.setDamage(event.getDamage() + 1.5);
                        }
                        if (player.getItemInHand().getType() == Material.IRON_AXE) {
                            event.setDamage(event.getDamage() + 1.5);
                        }
                        if (player.getItemInHand().getType() == Material.DIAMOND_AXE) {
                            event.setDamage(event.getDamage() + 1.5);
                        }
                    }
                    if (player.getFallDistance() > 0.0f && player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE) && !player.isOnGround()) {
                        if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
                            event.setDamage(event.getDamage() + 0.5);
                        }
                        if (player.getItemInHand().getType() == Material.STONE_SWORD) {
                            event.setDamage(event.getDamage() + 0.5);
                        }
                        if (player.getItemInHand().getType() == Material.IRON_SWORD) {
                            event.setDamage(event.getDamage() + 0.5);
                        }
                        if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
                            event.setDamage(event.getDamage() + 0.5);
                        }
                        if (player.getItemInHand().getType() == Material.WOOD_AXE) {
                            event.setDamage(event.getDamage() + 0.5);
                        }
                        if (player.getItemInHand().getType() == Material.STONE_AXE) {
                            event.setDamage(event.getDamage() + 0.5);
                        }
                        if (player.getItemInHand().getType() == Material.IRON_AXE) {
                            event.setDamage(event.getDamage() + 0.5);
                        }
                        if (player.getItemInHand().getType() == Material.DIAMOND_AXE) {
                            event.setDamage(event.getDamage() + 0.5);
                        }
                    }
                }
            }
        }
    }
    
    @EventHandler
    public void Quebrar(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        final ItemStack item1 = p.getItemInHand();
        final Material material1 = Material.getMaterial(item1.getTypeId());
        if (!material1.isBlock() && material1.getMaxDurability() >= 1 && item1.getDurability() != 0) {
            p.getItemInHand().setDurability((short)0);
            p.updateInventory();
        }
        final PlayerInventory item2 = p.getInventory();
        if (p.getInventory().getHelmet() != null) {
            final Material material2 = Material.getMaterial(item2.getHelmet().getTypeId());
            if (!material2.isBlock() && material2.getMaxDurability() >= 1 && item2.getHelmet().getDurability() != 0) {
                p.getInventory().getHelmet().setDurability((short)1);
            }
        }
        if (p.getInventory().getChestplate() != null) {
            final Material material2 = Material.getMaterial(item2.getChestplate().getTypeId());
            if (!material2.isBlock() && material2.getMaxDurability() >= 1 && item2.getChestplate().getDurability() != 0) {
                p.getInventory().getChestplate().setDurability((short)1);
            }
        }
        if (p.getInventory().getLeggings() != null) {
            final Material material2 = Material.getMaterial(item2.getLeggings().getTypeId());
            if (!material2.isBlock() && material2.getMaxDurability() >= 1 && item2.getLeggings().getDurability() != 0) {
                p.getInventory().getLeggings().setDurability((short)1);
            }
        }
        if (p.getInventory().getBoots() != null) {
            final Material material2 = Material.getMaterial(item2.getBoots().getTypeId());
            if (!material2.isBlock() && material2.getMaxDurability() >= 1 && item2.getBoots().getDurability() != 0) {
                p.getInventory().getBoots().setDurability((short)1);
            }
        }
    }

	 public static int getPing(final Player p) {
	        return ((CraftPlayer)p).getHandle().ping;
	        
	    }
	 

	@EventHandler
	public void onChat(PlayerChatEvent e) {
		Player p = e.getPlayer();
		e.setFormat(ScoreDoBasic.Rank(p)  + p.getDisplayName() + " §6» §f " + e.getMessage());
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		e.getPlayer();
		e.setQuitMessage(null);
	}

	@EventHandler
	public void onQuit(PlayerJoinEvent e) {
		e.getPlayer();
		e.setJoinMessage(null);
	}

	@EventHandler
	public void nohunger(FoodLevelChangeEvent event) {
		event.setCancelled(true);
		event.setFoodLevel(20);
	}

	@EventHandler
	public void noRain(WeatherChangeEvent event) {
		event.setCancelled(true);
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onCreeperExplosion(EntityExplodeEvent event) {
		event.setCancelled(true);
	}

@EventHandler
public void onEnderDragonSpawn(CreatureSpawnEvent e)
{
  if ((e.getEntity() instanceof EnderDragon)) {
    e.setCancelled(true);
  }
}

@EventHandler
public void onEnderDragonSpawn1(CreatureSpawnEvent e)
{
  if ((e.getEntity() instanceof Zombie)) {
    e.setCancelled(true);
  }
}

@EventHandler
public void onEnderDragonSpawn2(CreatureSpawnEvent e)
{
  if ((e.getEntity() instanceof Skeleton)) {
    e.setCancelled(true);
  }
}

@EventHandler
public void onEnderDragonSpawn3(CreatureSpawnEvent e)
{
  if ((e.getEntity() instanceof Creeper)) {
    e.setCancelled(true);
  }
}

@EventHandler
public void onEnderDragonSpawn4(CreatureSpawnEvent e)
{
  if ((e.getEntity() instanceof Spider)) {
    e.setCancelled(true);
  }
}

@EventHandler
public void onEnderDragonSpawn5(CreatureSpawnEvent e)
{
  if ((e.getEntity() instanceof Pig)) {
    e.setCancelled(true);
  }
}

@EventHandler
public void onEnderDragonSpawn6(CreatureSpawnEvent e)
{
  if ((e.getEntity() instanceof Cow)) {
    e.setCancelled(true);
  }
}

@EventHandler
public void onEnderDragonSpawn7(CreatureSpawnEvent e)
{
  if ((e.getEntity() instanceof Chicken)) {
    e.setCancelled(true);
  }
}

@EventHandler
public void onEnderDragonSpawn8(CreatureSpawnEvent e)
{
  if ((e.getEntity() instanceof Sheep)) {
    e.setCancelled(true);
  }
}

@EventHandler
public void onEnderDragonSpawn15(CreatureSpawnEvent e)
{
  if ((e.getEntity() instanceof Witch)) {
    e.setCancelled(true);
  }
}

@EventHandler
public void onEnderDragonSpawn9(CreatureSpawnEvent e)
{
  if ((e.getEntity() instanceof Enderman)) {
    e.setCancelled(true);
  }
}
}


	
