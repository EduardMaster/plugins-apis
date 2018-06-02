package me.rafael.vinagre.KomboPvP.Kits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
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

public class Thresh 
implements Listener, CommandExecutor
{
	public Main plugin;
	public Thresh(Main instance){
		plugin = instance;
	}
	public static HashMap<String, Long> Tempo = new HashMap();
	  public static HashMap<String, Snowball> tiros = new HashMap();
	
	@EventHandler
	public void clicar(PlayerInteractEvent e){
		Player p = e.getPlayer();
	    if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
	  	      (p.getItemInHand().getType() == Material.TRIPWIRE_HOOK) && 
	  	    (Array.kit.get(p) == "Thresh"))
			if ((!Tempo.containsKey(p.getName())) || (((Long)Tempo.get(p.getName())).longValue() <= System.currentTimeMillis())) {
		          e.setCancelled(true);
		          p.updateInventory();
		          Snowball tiro = (Snowball)p.launchProjectile(Snowball.class);
		          Vector vec = p.getLocation().getDirection();
		          tiro.setVelocity(
		            new Vector(vec.getX() * 1.0D * 3.5D, 
		            vec.getY() * 1.0D * 4.0D, 
		            vec.getZ() * 1.0D * 3.5D));
		          tiros.put(p.getName(), tiro);
		          Tempo.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(25L)));
		          p.sendMessage("§aThresh disparado!");
		          p.playSound(p.getLocation(), Sound.GLASS, 1.0F, 1.0F);
		          return;
		        }
		      else {
		        p.sendMessage(ChatColor.RED + "Faltam " + TimeUnit.MILLISECONDS.toSeconds(((Long)Tempo.get(p.getName())).longValue() - System.currentTimeMillis()) + " segundos para poder usar novamente.");
		      }
	}
	  @EventHandler
	  public void aplicar(EntityDamageByEntityEvent e)
	  {
	    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Snowball))) {
	      Player p = (Player)e.getEntity();
	      Snowball tiro = (Snowball)e.getDamager();
	      if ((tiro.getShooter() instanceof Player)) {
	        Player shooter = (Player)tiro.getShooter();
	        if ((tiros.containsKey(shooter.getName())) && 
	          (tiro == tiros.get(shooter.getName()))) {
	          p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 5*20, 0));
	          p.sendMessage("§aVoce foi puxado pelo Thresh §7 " + shooter.getPlayerListName());
	          p.playSound(p.getLocation(), Sound.BURP, 1.0F, 1.0F);
	          shooter.sendMessage("§aVoce acertou o §7" + p.getName());
	          shooter.playSound(shooter.getLocation(), Sound.CAT_PURR, 1.0F, 1.0F);
	          p.teleport(shooter.getLocation());
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
	    ItemStack especial = new ItemStack(Material.TRIPWIRE_HOOK);
	    ItemMeta especial1 = especial.getItemMeta();
	    especial1.setDisplayName("§5Cilada");
	    especial.setItemMeta(especial1);
	    
	    ItemStack capacete0 = new ItemStack(Material.AIR);
	    
	    ItemStack peitoral0 = new ItemStack(Material.AIR);
	    
	    ItemStack calca0 = new ItemStack(Material.AIR);
	    
	    ItemStack Bota0 = new ItemStack(Material.AIR);
	    
	    p.getInventory().setHelmet(capacete0);
	    p.getInventory().setChestplate(peitoral0);
	    p.getInventory().setLeggings(calca0);
	    p.getInventory().setBoots(Bota0);
		    
		    if (cmd.equalsIgnoreCase("thresh")) {
		      if (Array.used.contains(p.getName())) {
		    	  p.sendMessage("§7» §cVoce ja esta usando um kit!");
		        return true;
		      }
		      if (!p.hasPermission("kitpvp.kit.thresh")) {
			      p.sendMessage("§cVoce nao tem permissao para usar este kit !");
		        return true;
		      }
		      Array.used.add(p.getName());
		      p.sendMessage("§7» Voce escolheu o kit §cThresh §7!");
		      p.setGameMode(GameMode.ADVENTURE);
		      p.getInventory().clear();
		      Array.kit.put(p, "Thresh");
		      Main.Dj.remove(p.getName());
		      Main.stomper.remove(p.getName());
		     
		      Scoreboard.ScoreDoBasic.iscoriboard(p);
		      p.getInventory().addItem(new ItemStack[] { dima });
		      p.getInventory().addItem(new ItemStack[] { especial });
		      Main.give(p);
		      for (int i = 0; i <= 34; i++) {
		        p.getInventory().addItem(new ItemStack[] { sopa });
		        
		      }
		    }
		    me.rafael.vinagre.KomboPvP.Comandos.SetArena.TeleportArenaRandom(p);
		    return false;
		  }
}