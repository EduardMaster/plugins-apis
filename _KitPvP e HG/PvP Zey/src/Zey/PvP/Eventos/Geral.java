package Zey.PvP.Eventos;

import org.bukkit.craftbukkit.v1_7_R4.entity.*;
import net.minecraft.server.v1_7_R4.*;
import org.bukkit.event.server.*;
import org.bukkit.event.*;
import org.bukkit.*;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.weather.*;
import org.bukkit.event.player.*;
import org.bukkit.event.entity.*;
import org.bukkit.help.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.block.*;
import org.bukkit.inventory.meta.*;

import Zey.PvP.APIs.WarpAPI;
import Zey.PvP.Main.*;
import Zey.PvP.Warps.Parkour;

import org.bukkit.entity.*;
import org.bukkit.entity.Entity;

public class Geral implements Listener {
	
	@EventHandler
	public void Drop(ItemSpawnEvent e) {
		e.getEntity().getWorld().playEffect(e.getEntity().getLocation(), Effect.SMOKE, 1);
	}
	
	  @EventHandler
	  public void onPlayerColor(SignChangeEvent e)
	  {
	    if (e.getLine(0).contains("&")) {
	      e.setLine(0, e.getLine(0).replace("&", "§"));
	    }
	    if (e.getLine(1).contains("&")) {
	      e.setLine(1, e.getLine(1).replace("&", "§"));
	    }
	    if (e.getLine(2).contains("&")) {
	      e.setLine(2, e.getLine(2).replace("&", "§"));
	    }
	    if (e.getLine(3).contains("&")) {
	      e.setLine(3, e.getLine(3).replace("&", "§"));
	    }
	  }
	
    @EventHandler
    public void onMe(final PlayerCommandPreprocessEvent event) {
        final Player p = event.getPlayer();
        if (event.getMessage().toLowerCase().startsWith("/me") 
        		|| event.getMessage().toLowerCase().startsWith("//calc") 
        		|| event.getMessage().toLowerCase().startsWith("/pl")
        		|| event.getMessage().toLowerCase().startsWith("/plugins")
        		|| event.getMessage().toLowerCase().startsWith("/ver")
        		|| event.getMessage().toLowerCase().startsWith("/bukkit")
        		|| event.getMessage().toLowerCase().startsWith("/help")
        		|| event.getMessage().toLowerCase().startsWith("/version")
        		|| event.getMessage().toLowerCase().startsWith("/about")
        		|| event.getMessage().toLowerCase().startsWith("/?")) {
            event.setCancelled(true);
            p.sendMessage(String.valueOf(Main.prefix) + " §7» §cComando não listado");
        }
    }
    
    @EventHandler
    public void onDeath(final PlayerDeathEvent e) {
        e.setDeathMessage((String)null);
        final Player p = e.getEntity();
        if (p.getKiller() instanceof Player) {
            final Player k = p.getKiller();
            final Location l = k.getLocation();
            final Location lp = p.getLocation();
            p.sendMessage(String.valueOf(Main.prefix) + " §7» §cVocê foi morto por " + k.getName());
            k.sendMessage(String.valueOf(Main.prefix) + " §7» §aVocê adquiriu 50 ZeyCoins!");
            p.sendMessage(String.valueOf(Main.prefix) + " §7» §cVocê perdeu 50 ZeyCoins!");
            k.sendMessage(String.valueOf(Main.prefix) + " §7» §aVocê matou o jogador(a): §e" + p.getName());
            k.playSound(l, Sound.ARROW_HIT, 10.0f, 1.0f);
            p.playSound(lp, Sound.ANVIL_USE, 10.0f, 1.0f);
        }
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                e.getEntity().setFlying(false);
                e.getEntity().setAllowFlight(false);
                if (e.getEntity().isOnline()) {
                    final EntityPlayer ep = ((CraftPlayer)e.getEntity()).getHandle();
                    ep.playerConnection.a(new PacketPlayInClientCommand(EnumClientCommand.PERFORM_RESPAWN));
                }
            }
        }, 1L);
    }
    
  // @EventHandler
  //  public void onVoidDeath(final PlayerMoveEvent e) {
  //      final Player p = e.getPlayer();
  //      final Location l = p.getLocation();
  //      if (l.getBlockY() <= 0) {
  //         p.setHealth(0);
  //      }
  //  }
    
	@EventHandler
    public void onVoidTeleport(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        final Location l = p.getLocation();
        
        final World w = Bukkit.getServer().getWorld(Parkour.plugin.getConfig().getString("parkour.world"));
        final double x = Parkour.plugin.getConfig().getDouble("parkour.x");
        final double y = Parkour.plugin.getConfig().getDouble("parkour.y");
        final double z = Parkour.plugin.getConfig().getDouble("parkour.z");
        final Location lobby = new Location(w, x, y, z);
        lobby.setPitch((float)Parkour.plugin.getConfig().getDouble("parkour.pitch"));
        lobby.setYaw((float)Parkour.plugin.getConfig().getDouble("parkour.yaw"));
        if (l.getBlockY() <= 0 &&  	
		WarpAPI.getWarp(p) == "Parkour") {
            p.setHealth(20.0);
            p.teleport(lobby);
        }
    }
    
    @EventHandler
    public void onCreeperSpawn(final CreatureSpawnEvent e) {
        if (e.getEntity() instanceof Creeper) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onSkeletonSpawn(final CreatureSpawnEvent e) {
        if (e.getEntity() instanceof Skeleton) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onSpiderSpawn(final CreatureSpawnEvent e) {
        if (e.getEntity() instanceof Spider) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onWitherSpawn(final CreatureSpawnEvent e) {
        if (e.getEntity() instanceof Wither) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void nuncaChover(WeatherChangeEvent evento)
    {
      evento.setCancelled(true);
    }
    
    @EventHandler
    public void onZombieSpawn(final CreatureSpawnEvent e) {
        if (e.getEntity() instanceof Zombie) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void aoPing(final ServerListPingEvent e) {
        e.setMotd(Main.motd);
        if (Bukkit.hasWhitelist()) {
            e.setMotd(Main.motd2);
        }
    }
    
    @EventHandler
    public void onCheio(final PlayerLoginEvent event) {
        final Player p = event.getPlayer();
        if (event.getResult() == PlayerLoginEvent.Result.KICK_FULL) {
            if (p.hasPermission("zey.pvp.slotvip")) {
                event.setResult(PlayerLoginEvent.Result.ALLOWED);
            }
            else {
                event.setKickMessage("§cDesculpe, o servidor está lotado.");
            }
        }
        else if (event.getResult() == PlayerLoginEvent.Result.KICK_WHITELIST) {
            event.setKickMessage("\n \n §cEstamos em manutenção, para sua melhor jogabilidade, retorne em breve!");
        }
    }
    
    @SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.NORMAL)
    public void banAds(final PlayerChatEvent e) {
        final Player p = e.getPlayer();
        if (!p.hasPermission("zey.pvp.falarsites") 
        				&& (e.getMessage().contains(".net")
        				|| e.getMessage().contains("Entre agora")
        				|| e.getMessage().contains("meu server")
        				|| e.getMessage().contains("(.)")
        				|| e.getMessage().contains(".host")
        				|| e.getMessage().contains(".minesv")
        				|| e.getMessage().contains(".playbr")
        				|| e.getMessage().contains(".cookiehosting")
        				|| e.getMessage().contains(".playmine")
        				|| e.getMessage().contains(".com")
        				|| e.getMessage().contains(".server")
        				|| e.getMessage().contains(".me")
        				|| e.getMessage().contains(".io")
        				|| e.getMessage().contains(".com")
        				|| e.getMessage().contains(".com.br")
        				|| e.getMessage().contains(".pro")
        				|| e.getMessage().contains(".nu")
        				|| e.getMessage().contains(".tk")
        				// Dominios, com virgula.
        				|| e.getMessage().contains("(,)")
        				|| (e.getMessage().contains(",net")
        				|| e.getMessage().contains(",host")
        				|| e.getMessage().contains(",minesv")
        				|| e.getMessage().contains(",playbr")
        				|| e.getMessage().contains(",cookiehosting")
        				|| e.getMessage().contains(",playmine")
        				|| e.getMessage().contains(",com")
        				|| e.getMessage().contains(",server")
        				|| e.getMessage().contains(",me")
        				|| e.getMessage().contains(",io")
        				|| e.getMessage().contains(",com")
        				|| e.getMessage().contains(",com.br")
        				|| e.getMessage().contains(",pro")
        				|| e.getMessage().contains(",nu")
        				|| e.getMessage().contains(",tk")))) {
            e.setCancelled(true);
            p.sendMessage("§cNão divulgue servidores ou sites aqui, você será temporariamente banido.");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + p.getName() + " 5 m [AutoBan] Divulgação de servidores ou links");
        }
    }
    
    @SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.NORMAL)
    public void banofensa(final PlayerChatEvent e) {
        final Player p = e.getPlayer();
        if (!p.hasPermission("zey.pvp.falarmerda") 
        				&& (e.getMessage().contains("filho da puta")
        				|| e.getMessage().contains("vadia")
        				|| e.getMessage().contains("sua mãe")
        				|| e.getMessage().contains("sua mae")
        				|| e.getMessage().contains("aql puta")
        				|| e.getMessage().contains("seu lixo")
        				|| e.getMessage().contains("puta"))) {
            e.setCancelled(true);
            p.sendMessage("§cVocê usou alguns argumentos indevidos, contra jogadores(a) por isso, sera mutado temporariamente.");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempmute " + p.getName() + " 2 m [AutoMute] Uso de argumentos indevidos, contra Player.");
        }
    }
    
    @EventHandler
    public void onSlimeSpawn(final CreatureSpawnEvent e) {
        if (e.getEntity() instanceof Slime) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onGhastSpawn(final CreatureSpawnEvent e) {
        if (e.getEntity() instanceof Ghast) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onPigZombieSpawn(final CreatureSpawnEvent e) {
        if (e.getEntity() instanceof PigZombie) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onEndermanSpawn(final CreatureSpawnEvent e) {
        if (e.getEntity() instanceof Enderman) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onCaveSpiderSpawn(final CreatureSpawnEvent e) {
        if (e.getEntity() instanceof CaveSpider) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onSheepSpawn(final CreatureSpawnEvent e) {
        if (e.getEntity() instanceof Sheep) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onCowSpawn(final CreatureSpawnEvent e) {
        if (e.getEntity() instanceof Cow) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onChickenSpawn(final CreatureSpawnEvent e) {
        if (e.getEntity() instanceof Chicken) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onSquidSpawn(final CreatureSpawnEvent e) {
        if (e.getEntity() instanceof Squid) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void clicarBussola(final PlayerInteractEvent e) {
        boolean parar = false;
        if (e.getPlayer().getItemInHand().getType() == Material.COMPASS) {
            for (final Entity entidades : e.getPlayer().getNearbyEntities(100.0, 150.0, 100.0)) {
                if (entidades instanceof Player && e.getPlayer().getLocation().distance(entidades.getLocation()) >= 9.0) {
                    if (entidades.getLocation().getY() > 170.0) {
                        return;
                    }
                    parar = true;
                    e.getPlayer().setCompassTarget(entidades.getLocation());
                    e.getPlayer().sendMessage(String.valueOf(Main.prefix) + " §7» Bússola apontando para o jogador(a): §e" + ((Player)entidades).getName());
                    return;
                }
            }
            if (!parar) {
                e.getPlayer().sendMessage(String.valueOf(Main.prefix) + " §7» Nenhum jogador(a) foi encontrado!");
                e.getPlayer().setCompassTarget(new Location(e.getPlayer().getWorld(), 0.0, 100.0, 0.0));
            }
        }
    }
    
    @EventHandler
    public void onEntityDamageByEntity1(final EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            final Player d = (Player)e.getDamager();
            if (d.getItemInHand().getType() == Material.DIAMOND_SWORD 
            		|| d.getItemInHand().getType() == Material.WOOD_SWORD 
            		|| d.getItemInHand().getType() == Material.STONE_SWORD 
            		|| d.getItemInHand().getType() == Material.FISHING_ROD 
            		|| d.getItemInHand().getType() == Material.STONE_AXE
            		|| d.getItemInHand().getType() == Material.BOW 
            		|| d.getItemInHand().getType() == Material.IRON_SWORD 
            		|| d.getItemInHand().getType() == Material.DIAMOND_AXE) {
                d.getItemInHand().setDurability((short)0);
            }
        }
    }
    
    @EventHandler
    public void onPickup(final PlayerPickupItemEvent e) {
        e.setCancelled(true);
    }
    
    @EventHandler
    public void onDrop(final PlayerDropItemEvent e) {
        e.setCancelled(true);
        if (e.getItemDrop().getItemStack().getType() == Material.LEATHER_CHESTPLATE) {
            e.setCancelled(false);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.MUSHROOM_SOUP) {
            e.setCancelled(false);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.RED_MUSHROOM) {
            e.setCancelled(false);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.BROWN_MUSHROOM) {
            e.setCancelled(false);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.BOWL) {
            e.setCancelled(false);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.COMPASS) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void dropar(final ItemSpawnEvent e) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                e.getEntity().remove();
            }
        }, 80L);
    }
    
    @EventHandler
    public void entityDamagePedra(final EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player && ((Player)e.getDamager()) instanceof Player) {
            final Player p = (Player)e.getDamager();
            if (e.getEntity() instanceof Player && p.getItemInHand().getType() == Material.STONE_SWORD) {
                e.setDamage(e.getDamage() * 0.6);
                return;
            }
            if (p.getItemInHand().getType() == Material.WOOD_SWORD) {
                e.setDamage(e.getDamage() * 0.5);
                return;
            }
            if (p.getItemInHand().getType() == Material.DIAMOND_SWORD) {
                e.setDamage(e.getDamage() * 0.7);
            }
        }
    }
    
    @EventHandler
    public void achivments(final PlayerAchievementAwardedEvent e) {
        e.setCancelled(true);
    }
    
    @EventHandler
    public void nohunger(final FoodLevelChangeEvent event) {
        event.setCancelled(true);
        event.setFoodLevel(20);
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onCreeperExplosion(final EntityExplodeEvent event) {
        event.setCancelled(true);
    }
    
    @EventHandler
    public void onUnknown(final PlayerCommandPreprocessEvent event) {
        if (event.isCancelled()) {
            return;
        }
        final Player p = event.getPlayer();
        final String msg = event.getMessage().split(" ")[0];
        final HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(msg);
        if (topic == null) {
            event.setCancelled(true);
            p.sendMessage(String.valueOf(Main.prefix) + " §7» §cComando não listado");
        }
    }
    
    @SuppressWarnings("deprecation")
	@EventHandler
    public void onSopa(final PlayerInteractEvent e) {
        final ItemStack pote = new ItemStack(Material.BOWL, 1);
        final ItemMeta kpote = pote.getItemMeta();
        kpote.setDisplayName("§e§lPOTE");
        pote.setItemMeta(kpote);
        final Damageable hp;
        final Player p = (Player)(hp = (Damageable)e.getPlayer());
        if (hp.getHealth() != 20.0) {
            if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getTypeId() == 282) {
                p.setHealth((hp.getHealth() + 7.0 > hp.getMaxHealth()) ? hp.getMaxHealth() : (hp.getHealth() + 7.0));
                if (!Habilidade.getAbility(p).equalsIgnoreCase("QuickDropper")) {
                    p.getItemInHand().setItemMeta(kpote);
                    p.getItemInHand().setType(Material.BOWL);
                }
                else {
                    p.getItemInHand().setType(Material.BOWL);
                    p.getPlayer().getInventory().remove(p.getItemInHand());
                    p.getInventory().remove(new ItemStack(Material.BOWL, 1));
                    p.getLocation().getWorld().dropItem(p.getEyeLocation(), new ItemStack(Material.BOWL));
                    p.updateInventory();
                }
            }
        }
    }
}
