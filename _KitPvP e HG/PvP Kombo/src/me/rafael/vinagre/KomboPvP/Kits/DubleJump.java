package me.rafael.vinagre.KomboPvP.Kits;



	import Vinagre.Habilidade;
import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;

import org.bukkit.Effect;
	import org.bukkit.GameMode;
	import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
	import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
	import org.bukkit.entity.Player;
	import org.bukkit.event.EventHandler;
	import org.bukkit.event.Listener;
	import org.bukkit.event.entity.EntityDamageEvent;
	import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
	import org.bukkit.event.entity.PlayerDeathEvent;
	import org.bukkit.event.player.PlayerMoveEvent;
	import org.bukkit.event.player.PlayerQuitEvent;
	import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

	public class DubleJump
	  implements Listener, CommandExecutor
	{
	  @EventHandler
	  public void onPlayerToggleFly(PlayerToggleFlightEvent e)
	  {
	    Player p = e.getPlayer();
	    if (Habilidade.getAbility(p).equalsIgnoreCase("DubleJump"))
	    {
	      if (p.getGameMode() == GameMode.CREATIVE) {
	        return;
	      }
	      e.setCancelled(true);
	      p.setFlying(false);
	      p.setAllowFlight(false);
	      Location loc = p.getLocation();
	      if (!p.isSneaking())
	      {
	        p.setFallDistance(-3.0F);
	        Vector vector = p.getEyeLocation().getDirection();
	        vector.multiply(0.6F);
	        vector.setY(1.0F);
	        p.setVelocity(vector);
	      }
	      else
	      {
	        p.setFallDistance(-3.0F);
	        Vector vector = p.getEyeLocation().getDirection();
	        vector.multiply(1.35F);
	        vector.setY(0.66D);
	        p.setVelocity(vector);
	      }
	      loc.getWorld().playSound(loc, Sound.FIREWORK_BLAST, 1.0F, 0.2F);
	      p.getWorld().playEffect(p.getLocation(), Effect.COLOURED_DUST, 80);
	    }
	  }
	  
	  @EventHandler
	  public void onDamage(EntityDamageEvent event)
	  {
	    Entity e = event.getEntity();
	    if ((e instanceof Player))
	    {
	      Player player = (Player)e;
	      if ((Habilidade.getAbility(player).equalsIgnoreCase("DubleJump")) && ((event.getEntity() instanceof Player)) && (event.getCause() == EntityDamageEvent.DamageCause.FALL)) {
	        event.setDamage(2.0D);
	      }
	    }
	  }
	  
	  @EventHandler
	  public void onPlayerMove(PlayerMoveEvent e)
	  {
	    Player p = e.getPlayer();
	    if (Habilidade.getAbility(p).equalsIgnoreCase("DubleJump"))
	    {
	      if (p.getGameMode() == GameMode.CREATIVE) {
	        return;
	      }
	      if ((p.isOnGround()) && (!p.getAllowFlight())) {
	        p.setAllowFlight(true);
	      }
	    }
	  }
	  
	  @EventHandler
	  public void aomorrer(PlayerDeathEvent e)
	  {
	    Player p = e.getEntity();
	    if (Habilidade.getAbility(p).equalsIgnoreCase("DubleJump")) {
	      p.setAllowFlight(false);
	    }
	  }
	  
	  @EventHandler
	  public void aomorrer(PlayerQuitEvent e)
	  {
	    Player p = e.getPlayer();
	    if (Habilidade.getAbility(p).equalsIgnoreCase("DubleJump")) {
	      p.setAllowFlight(false);
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
	    
	    if (cmd.equalsIgnoreCase("doublejump")) {
	      if (Array.used.contains(p.getName())) {
	    	  p.sendMessage(" §7» §cVoce ja esta usando um kit!");
	        return true;
	      }
	      if (!p.hasPermission("kitpvp.kit.doublejump")) {
		      p.sendMessage("§cVoce nao tem permissao para usar este kit !");
	        return true;
	      }
	      Array.used.add(p.getName());
	      p.sendMessage(" §7» Voce escolheu o kit §cDoubleJump §7!");
	      p.setGameMode(GameMode.ADVENTURE);
	      p.getInventory().clear();
	      Array.kit.put(p, "DoubleJump");
	      Habilidade.setAbility(p, "DubleJump");
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
	    return false;
	  }
	}
