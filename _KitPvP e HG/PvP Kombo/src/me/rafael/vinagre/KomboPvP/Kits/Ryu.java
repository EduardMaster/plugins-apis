package me.rafael.vinagre.KomboPvP.Kits;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
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
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;

public class Ryu 
implements Listener, CommandExecutor
{
	  public static Main plugin;
	  public static HashMap<String, Long> cooldown = new HashMap();
	  
	  public Ryu(Main main)
	  {
	    plugin = main;
	  }

	@EventHandler
	  public void hadouken(PlayerInteractEvent e)
	  {
	    Player p = e.getPlayer();
	    if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
	      (Array.kit.get(p) == "Ryu") && 
	      (p.getItemInHand().getType() == Material.BEACON))
	    {
	      if ((!cooldown.containsKey(p.getName())) || (((Long)cooldown.get(p.getName())).longValue() <= System.currentTimeMillis()))
	      {
	        e.setCancelled(true);
	        p.updateInventory();
	        
	        Location location = p.getEyeLocation();
	        BlockIterator blocksToAdd = new BlockIterator(location, 0.0D, 40);
	        while (blocksToAdd.hasNext())
	        {
	          Location blockToAdd = blocksToAdd.next().getLocation();
	          p.getWorld().playEffect(blockToAdd, Effect.STEP_SOUND, Material.LAVA, 20);
	          p.playSound(blockToAdd, Sound.IRONGOLEM_THROW, 3.0F, 3.0F);
	        }
	        Snowball h = (Snowball)p.launchProjectile(Snowball.class);
	        Vector velo1 = p.getLocation().getDirection().normalize().multiply(10);
	        h.setVelocity(velo1);
	        h.setMetadata("hadouken", new FixedMetadataValue(plugin, Boolean.valueOf(true)));
	        cooldown.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(25L)));
	        return;
	      }
	      p.sendMessage(ChatColor.RED + "Faltam " + TimeUnit.MILLISECONDS.toSeconds(((Long)cooldown.get(p.getName())).longValue() - System.currentTimeMillis()) + " segundos para poder usar novamente.");
	    }
	  }
	  
	  @EventHandler
	  public void dano(EntityDamageByEntityEvent e)
	  {
	    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Snowball)))
	    {
	      Snowball s = (Snowball)e.getDamager();
	      if (s.hasMetadata("hadouken")) {
	        e.setDamage(e.getDamage() + 10.0D);
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
	    ItemStack especial = new ItemStack(Material.BEACON);
	    ItemMeta especial1 = especial.getItemMeta();
	    especial1.setDisplayName("§bHadouken");
	    especial.setItemMeta(especial1);
	    
	    ItemStack capacete0 = new ItemStack(Material.AIR);
	    
	    ItemStack peitoral0 = new ItemStack(Material.AIR);
	    
	    ItemStack calca0 = new ItemStack(Material.AIR);
	    
	    ItemStack Bota0 = new ItemStack(Material.AIR);
	    
	    p.getInventory().setHelmet(capacete0);
	    p.getInventory().setChestplate(peitoral0);
	    p.getInventory().setLeggings(calca0);
	    p.getInventory().setBoots(Bota0);
	    
	    if (cmd.equalsIgnoreCase("ryu")) {
	      if (Array.used.contains(p.getName())) {
	    	  p.sendMessage("§7» §cVoce ja esta usando um kit!");
	        return true;
	      }
	      if (!p.hasPermission("kitpvp.kit.ryu")) {
		      p.sendMessage("§cVoce nao tem permissao para usar este kit !");
	        return true;
	      }
	      Array.used.add(p.getName());
	      p.sendMessage("§7» Voce escolheu o kit §cRyu §7!");
	      p.setGameMode(GameMode.ADVENTURE);
	      p.getInventory().clear();
	      Array.kit.put(p, "Ryu");
	      p.getInventory().addItem(new ItemStack[] { dima });
	      p.getInventory().addItem(new ItemStack[] { especial });
	      Main.give(p);
	      Main.Dj.remove(p.getName());
	      Main.stomper.remove(p.getName());
	      Main.Avatar.remove(p.getName());
	     
	      Scoreboard.ScoreDoBasic.iscoriboard(p);
	      for (int i = 0; i <= 34; i++) {
	        p.getInventory().addItem(new ItemStack[] { sopa });
	        
	      }
	    }
	    me.rafael.vinagre.KomboPvP.Comandos.SetArena.TeleportArenaRandom(p);
	    return false;
	  }
}