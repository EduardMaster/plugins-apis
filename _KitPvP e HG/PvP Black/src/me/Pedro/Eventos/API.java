package me.Pedro.Eventos;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.Pedro.Main;
import me.Pedro.Score.Habilidade;
import me.Pedro.Score.ScoreBoards;
import me.Pedro.XP.XpM;

public class API implements Listener {
	public static String s = "G";
	public static String p = "8";
	  public static String sev = Main.getInstance().getConfig().getString("NomeDoServer").replace("&", "§");

	public API(Main main) {
	}
	public static void setitem(Player p, Material mat, String nome, int lugar, Enchantment enchant, int level,
			boolean trueorfalse) {
		ItemStack item = new ItemStack(mat);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(nome);
		itemmeta.addEnchant(enchant, level, trueorfalse);
		item.setItemMeta(itemmeta);
		p.getInventory().setItem(lugar, item);
	}
	public static void GiveSpawn(Player p) {
		setitem(p, Material.CHEST, "§c§lKITS §7- " + p.getName(), 0, Enchantment.ARROW_DAMAGE, 0,false);
		setitem(p, Material.PAPER, "§c§lWARPS §7- " + p.getName(), 3, Enchantment.ARROW_DAMAGE, 0,false);
		setitem(p, Material.STORAGE_MINECART, "§c§lCAIXA §7- " + p.getName(), 4, Enchantment.ARROW_DAMAGE, 0,false);
		setitem(p, Material.EXP_BOTTLE, "§c§lLOJA §7- " + p.getName(), 5, Enchantment.ARROW_DAMAGE, 0,false);
		setitem(p, Material.COMPASS, "§c§lMINIGAMES §7- " + p.getName(), 8, Enchantment.ARROW_DAMAGE, 0,false);
		Tempo.viado(p);
		Habilidade.removeAbility(p);
		KitAPI.remove(p);
	}
	@EventHandler
	  public void AoTomarSopa(PlayerInteractEvent e)
	  {
	    ItemStack pote = new ItemStack(Material.BOWL, 1);
	    ItemMeta kpote = pote.getItemMeta();
	    kpote.setDisplayName("§8Pote");
	    pote.setItemMeta(kpote);
	    Player p = e.getPlayer();
	    Damageable hp = p;
	    if (hp.getHealth() != 20.0D)
	    {
	      int sopa = 7;
	      if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && (p.getItemInHand().getTypeId() == 282))
	      {
	        p.setHealth(hp.getHealth() + sopa > hp.getMaxHealth() ? hp.getMaxHealth() : hp.getHealth() + sopa);
	        if (!KitAPI.QuickDropper.contains(p.getName()))
	        {
	          p.getItemInHand().setItemMeta(kpote);
	          p.getItemInHand().setType(Material.BOWL);
	        }
	        else
	        {
	          p.getItemInHand().setType(Material.BOWL);
	          p.getPlayer().getInventory().remove(p.getItemInHand());
	          p.getInventory().remove(new ItemStack(Material.BOWL, 1));
	          p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.BOWL));
	          p.updateInventory();
	        }
	      }
	    }
	  }
	  @EventHandler
	  public void onItemDrop(final ItemSpawnEvent e)
	  {
	    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	    {
	      public void run()
	      {
	        e.getEntity().remove();
	        e.getLocation().getWorld().playEffect(e.getEntity().getLocation(), Effect.SMOKE, 10);
	      }
	    }, 10L);
	  }
		@EventHandler
		public void IniciativaAlimenteQuemnaopode(FoodLevelChangeEvent e) {
			e.setCancelled(true);
		}

		@EventHandler
		public void nuncaChover(WeatherChangeEvent evento) {
			evento.setCancelled(true);
		}
		  @EventHandler
		  public void a(PlayerDeathEvent e)
		  {
		    if (((e.getEntity() instanceof Player)) && ((e.getEntity().getKiller() instanceof Player)))
		    {
		      Player killer = e.getEntity().getKiller();
		      Player killed = e.getEntity();
		      killer.sendMessage(ChatColor.GREEN + "Voce Matou: " + killed.getName());
		      killer.sendMessage("§7Você Matou §a" + killed.getName() + "§7 E Ganhou +35 De XP");
		      killer.playSound(killer.getLocation(), Sound.ANVIL_LAND, 5.0F, 1.0F);
		      killed.sendMessage(ChatColor.RED + "Voce foi Morto por: " + killer.getName());
		      killed.sendMessage("§7Você Morreu Para §c" + killer.getName() + "§7 E Perdeu -5 De XP");
		      killed.teleport(killed.getWorld().getSpawnLocation());
		      killed.playSound(killed.getLocation(), Sound.CREEPER_DEATH, 10.0F, 10.0F);
		      e.setDeathMessage(null);
		      XpM.addMoney(killer, 35);
		      XpM.removeMoney(killed, 5);
		    }
		  }
		  public static List<String> Sair = new ArrayList();
		  
		  @EventHandler
		  public void onEntityDamage(EntityDamageByEntityEvent e)
		  {
		    if (((e.getDamager() instanceof Player)) && ((e.getEntity() instanceof Player)))
		    {
		      final Player p = (Player)e.getEntity();
		      final Player hitter = (Player)e.getDamager();
		      if ((!Sair.contains(p.getName())) && (!Sair.contains(hitter.getName())))
		      {
		        Sair.add(p.getName());
		        Sair.add(hitter.getName());
		        hitter.sendMessage(API.sev + "Você Entrou Em Combate Com §7" + p.getDisplayName());
		        p.sendMessage(API.sev + "Você Entrou Em Combate Com §7" + hitter.getDisplayName());
		        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
		        {
		          public void run()
		          {
		            Sair.remove(p.getName());
		            Sair.remove(hitter.getName());
		            hitter.sendMessage(API.sev + "Você Está Fora De Combate!");
		            p.sendMessage(API.sev + "Você Está Fora De Combate!");
		          }
		        }, 100L);
		      }
		    }
		  }
		  @EventHandler
		  public void onCompass(PlayerInteractEvent event)
		  {
		    Player p = event.getPlayer();
		    if ((p.getItemInHand().getType() == Material.COMPASS) && ((event.getAction() == Action.LEFT_CLICK_AIR) || (event.getAction() == Action.LEFT_CLICK_BLOCK) || (event.getAction() == Action.RIGHT_CLICK_BLOCK) || (event.getAction() == Action.RIGHT_CLICK_AIR)))
		    {
		      Boolean found = Boolean.valueOf(false);
		      for (int i = 0; i < 1000; i++)
		      {
		        List entities = p.getNearbyEntities(i, 128.0D, i);
		        for (Object e : entities) {
		          if ((((Entity)e).getType().equals(EntityType.PLAYER)) && (p.getLocation().distance(((Entity)e).getLocation()) > 0.0D))
		          {
		            p.setCompassTarget(((Entity)e).getLocation());
		            p.sendMessage("§f§lBussola §7apontando para -> §a" + ((Player)e).getName());
		            found = Boolean.valueOf(true);
		            break;
		          }
		        }
		        if (found.booleanValue()) {
		          break;
		        }
		      }
		      if (!found.booleanValue())
		      {
		        p.sendMessage("§f§lBussola §7Nenhum jogador encontrado bussola apontando para o spawn!");
		        p.setCompassTarget(new Location(p.getWorld(), 0.0D, 120.0D, 0.0D));
		      }
		    }
		  }
		  @EventHandler
		  public void onColorChat(AsyncPlayerChatEvent e) {
		    Player p = e.getPlayer();  
		    if (!p.hasPermission("system.falarchat"))
		      e.setFormat("§7[§c" + ScoreBoards.Rank(p) + "§7] " + p.getDisplayName() + " §6»§7 " + e.getMessage().replaceAll("%", "").replaceAll("%", ""));
		    else
		      e.setFormat("§7[§c" + ScoreBoards.Rank(p) + "§7] " + p.getDisplayName() + " §6»§f " + e.getMessage().replaceAll("&", "§").replaceAll("%", ""));
		  }
		  @EventHandler
		  public void onPlayerExit(PlayerQuitEvent e)
		  {
		    Player p = e.getPlayer();
		    if (Sair.contains(p.getName()))
		    {
		      p.setHealth(0.0D);
		      p.teleport(p.getWorld().getSpawnLocation());
		      Bukkit.broadcastMessage(API.sev + "§7 " + p.getName() + "§c Deslogou No PvP!");
		    }
		  }
		  
		  @EventHandler
		  public void onMe2(PlayerCommandPreprocessEvent event)
		  {
		    Player p = event.getPlayer();
		    if ((Sair.contains(p.getName())) && 
		      (event.getMessage().toLowerCase().startsWith("/")))
		    {
		      event.setCancelled(true);
		      p.sendMessage(API.sev + "§7Este Comando Foi Bloqueado Em PvP");
		    }
		  }
}
