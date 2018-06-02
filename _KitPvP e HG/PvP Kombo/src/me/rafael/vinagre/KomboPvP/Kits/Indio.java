package me.rafael.vinagre.KomboPvP.Kits;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.bukkit.ChatColor;
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
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;

public class Indio 
implements Listener, CommandExecutor
{
	public Main plugin;
	public Indio(Main instance){
		plugin = instance;
	}

	public static HashMap<String, Long> cooldown = new HashMap();
	  public static HashMap<String, Arrow> tiros = new HashMap();

	  @EventHandler
	  public void disparar(PlayerInteractEvent e)
	  {
	    Player p = e.getPlayer();

	    if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
	      (p.getItemInHand().getType() == Material.PUMPKIN_SEEDS) && 
	      ((Array.kit.get(p) == "Indio")))
	      if ((!cooldown.containsKey(p.getName())) || (((Long)cooldown.get(p.getName())).longValue() <= System.currentTimeMillis())) {
	          e.setCancelled(true);
	          p.updateInventory();
	          Arrow tiro = (Arrow)p.launchProjectile(Arrow.class);
	          Vector vec = p.getLocation().getDirection();
	          tiro.setVelocity(
	            new Vector(vec.getX() * 1.0D * 3.5D, 
	            vec.getY() * 1.0D * 4.0D, 
	            vec.getZ() * 1.0D * 3.5D));
	          tiros.put(p.getName(), tiro);
	          cooldown.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(20L)));
	          p.sendMessage(ChatColor.GOLD + "Dardo disparado!");
	          p.playSound(p.getLocation(), Sound.GLASS, 1.0F, 1.0F);
	          return;
	        }
	      else {
	        p.sendMessage(ChatColor.RED + "Faltam " + TimeUnit.MILLISECONDS.toSeconds(((Long)cooldown.get(p.getName())).longValue() - System.currentTimeMillis()) + " segundos para poder usar novamente.");
	      }
	  }

	  @EventHandler
	  public void aplicar(EntityDamageByEntityEvent e)
	  {
	    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Arrow))) {
	      Player p = (Player)e.getEntity();
	      Arrow tiro = (Arrow)e.getDamager();
	      if ((tiro.getShooter() instanceof Player)) {
	        Player shooter = (Player)tiro.getShooter();
	        if ((tiros.containsKey(shooter.getName())) && 
	          (tiro == tiros.get(shooter.getName()))) {
	          p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 300, 0));
	          p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 300, 0));
	          p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 300, 0));
	          p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 300, 0));
	          p.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 300, 0));
	          p.sendMessage(ChatColor.BLUE + "Voce foi atingido por um dardo do Pataxó " + ChatColor.DARK_PURPLE + shooter.getName());
	          p.playSound(p.getLocation(), Sound.BURP, 1.0F, 1.0F);
	          shooter.sendMessage(ChatColor.YELLOW + "O Sol conspira ao seu favor! " + ChatColor.DARK_PURPLE + p.getName() + ChatColor.YELLOW + " foi acertado pelo seu dardo!");
	          shooter.playSound(shooter.getLocation(), Sound.CAT_PURR, 1.0F, 1.0F);
	          tiros.remove(shooter.getName());
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
	    ItemStack especial = new ItemStack(Material.PUMPKIN_SEEDS);
	    ItemMeta especial1 = especial.getItemMeta();
	    especial1.setDisplayName("§bCapetinha");
	    especial.setItemMeta(especial1);
	    
	    ItemStack capacete0 = new ItemStack(Material.AIR);
	    
	    ItemStack peitoral0 = new ItemStack(Material.AIR);
	    
	    ItemStack calca0 = new ItemStack(Material.AIR);
	    
	    ItemStack Bota0 = new ItemStack(Material.AIR);
	    
	    p.getInventory().setHelmet(capacete0);
	    p.getInventory().setChestplate(peitoral0);
	    p.getInventory().setLeggings(calca0);
	    p.getInventory().setBoots(Bota0);
		    
		    if (cmd.equalsIgnoreCase("indio")) {
		      if (Array.used.contains(p.getName())) {
		    	  p.sendMessage("§7» §cVoce ja esta usando um kit!");
		        return true;
		      }
		      if (!p.hasPermission("kitpvp.kit.indio")) {
			      p.sendMessage("§cVoce nao tem permissao para usar este kit !");
		        return true;
		      }
		      Array.used.add(p.getName());
		      p.sendMessage("§7» Voce escolheu o kit §cIndio §7!");
		      p.setGameMode(GameMode.ADVENTURE);
		      p.getInventory().clear();
		      Array.kit.put(p, "Indio");
		      p.getInventory().addItem(new ItemStack[] { dima });
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