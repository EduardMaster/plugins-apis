package me.rafael.vinagre.KomboPvP.Kits;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;

public class Monk 
implements Listener, CommandExecutor
{
	
public static Main plugin;

public Monk(Main main)
{
  plugin = main;
}

	@EventHandler
	  public void monk(PlayerInteractEntityEvent e)
	  {
	    ItemStack item = e.getPlayer().getItemInHand();
	    if ((Array.kit.get(e.getPlayer()) == "Monk") && 
	      ((e.getRightClicked() instanceof Player)) && 
	      (item.getTypeId() == Array.monkItemId)) {
	      long lastUsed = 0L;
	      if (Array.monkStaff.containsKey(item)) {
	        lastUsed = ((Long)Array.monkStaff.get(item)).longValue();
	      }
	      if (lastUsed + 1000 * Array.cooldownmonk > 
	        System.currentTimeMillis()) {
	        e.getPlayer().sendMessage(String.format(Array.monkCooldownMessage, 
	          new Object[] { Long.valueOf(-((System.currentTimeMillis() - (lastUsed + 1000 * Array.cooldownmonk)) / 1000L)) }));
	      } else {
	        PlayerInventory inv = ((Player)e.getRightClicked()).getInventory();
	        int slot = new Random().nextInt(Array.sendThroughInventory ? 36 : 9);
	        ItemStack replaced = inv.getItemInHand();
	        if (replaced == null)
	          replaced = new ItemStack(0);
	        ItemStack replacer = inv.getItem(slot);
	        if (replacer == null)
	          replacer = new ItemStack(0);
	        inv.setItemInHand(replacer);
	        inv.setItem(slot, replaced);
	        Array.monkStaff.put(item, Long.valueOf(System.currentTimeMillis()));
	        e.getPlayer().sendMessage("§6Jogador Monkado !");
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
	    ItemStack monk = new ItemStack(Material.BLAZE_ROD);
	    ItemMeta ims = monk.getItemMeta();
	    ims.setDisplayName("§6Poder-Monk");
	    monk.setItemMeta(ims);
	    
	    ItemStack capacete0 = new ItemStack(Material.AIR);
	    
	    ItemStack peitoral0 = new ItemStack(Material.AIR);
	    
	    ItemStack calca0 = new ItemStack(Material.AIR);
	    
	    ItemStack Bota0 = new ItemStack(Material.AIR);
	    
	    p.getInventory().setHelmet(capacete0);
	    p.getInventory().setChestplate(peitoral0);
	    p.getInventory().setLeggings(calca0);
	    p.getInventory().setBoots(Bota0);
	    
	    if (cmd.equalsIgnoreCase("monk")) {
	      if (Array.used.contains(p.getName())) {
	    	  p.sendMessage("§7» §cVoce ja esta usando um kit!");
	        return true;
	      }
	      if (!p.hasPermission("kitpvp.kit.monk")) {
		      p.sendMessage("§cVoce nao tem permissao para usar este kit !");
	        return true;
	      }
	      Array.used.add(p.getName());
	      p.sendMessage("§7» Voce escolheu o kit §cMonk §7!");
	      p.setGameMode(GameMode.ADVENTURE);
	      p.getInventory().clear();
	      Array.kit.put(p, "Monk");
	      Main.Dj.remove(p.getName());
	      Main.stomper.remove(p.getName());
	      Scoreboard.ScoreDoBasic.iscoriboard(p);
	      
	      p.getInventory().addItem(new ItemStack[] { dima });
	      p.getInventory().addItem(new ItemStack[] { monk });
	      Main.give(p);
	      for (int i = 0; i <= 34; i++) {
	        p.getInventory().addItem(new ItemStack[] { sopa });
	       
	      }
	    }
	    me.rafael.vinagre.KomboPvP.Comandos.SetArena.TeleportArenaRandom(p);
	    return false;
	  }
	}