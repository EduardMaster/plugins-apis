package me.rafael.vinagre.KomboPvP.Kits;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;

public class Backpacker 
implements Listener, CommandExecutor
{
	
	public static HashMap<String, Long> cooldown = new HashMap();

	  @EventHandler
	  public void disparar(PlayerInteractEvent e)
	  {
	    Player p = e.getPlayer();

	    if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
	      (p.getItemInHand().getType() == Material.LEATHER) && 
	      (Array.kit.get(p) == "Backpacker"))
	      if ((!cooldown.containsKey(p.getName())) || (((Long)cooldown.get(p.getName())).longValue() <= System.currentTimeMillis())) {
	          e.setCancelled(true);
	          p.updateInventory();
	          
	          Inventory sopas = Bukkit.createInventory(p, 36, "§6BackFiller");
	          
	          ItemStack sopas2 = new ItemStack(Material.MUSHROOM_SOUP);
	          ItemMeta sopas3 = sopas2.getItemMeta();
	          sopas3.setDisplayName("§6Sopas gratis");
	          sopas2.setItemMeta(sopas3);
	          
	          sopas.setItem(0, sopas2);
	          sopas.setItem(1, sopas2);
	          sopas.setItem(2, sopas2);
	          sopas.setItem(3, sopas2);
	          sopas.setItem(4, sopas2);
	          sopas.setItem(5, sopas2);
	          sopas.setItem(6, sopas2);
	          sopas.setItem(7, sopas2);
	          sopas.setItem(8, sopas2);
	          sopas.setItem(9, sopas2);
	          sopas.setItem(10, sopas2);
	          sopas.setItem(11, sopas2);
	          sopas.setItem(12, sopas2);
	          sopas.setItem(13, sopas2);
	          sopas.setItem(14, sopas2);
	          sopas.setItem(15, sopas2);
	          sopas.setItem(16, sopas2);
	          sopas.setItem(17, sopas2);
	          sopas.setItem(18, sopas2);
	          sopas.setItem(19, sopas2);
	          sopas.setItem(20, sopas2);
	          sopas.setItem(21, sopas2);
	          sopas.setItem(22, sopas2);
	          sopas.setItem(23, sopas2);
	          sopas.setItem(24, sopas2);
	          sopas.setItem(25, sopas2);
	          sopas.setItem(26, sopas2);
	          sopas.setItem(27, sopas2);
	          sopas.setItem(28, sopas2);
	          sopas.setItem(29, sopas2);
	          sopas.setItem(30, sopas2);
	          sopas.setItem(31, sopas2);
	          sopas.setItem(32, sopas2);
	          sopas.setItem(33, sopas2);
	          sopas.setItem(34, sopas2);
	          sopas.setItem(35, sopas2);
	          
	          
	          cooldown.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(35L)));
	          p.playSound(p.getLocation(), Sound.GLASS, 1.0F, 1.0F);
	          p.openInventory(sopas);
	          return;
	        }
	      else {
	        p.sendMessage(ChatColor.RED + "Faltam " + TimeUnit.MILLISECONDS.toSeconds(((Long)cooldown.get(p.getName())).longValue() - System.currentTimeMillis()) + " segundos para poder usar novamente.");
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
	    ItemStack especial = new ItemStack(Material.LEATHER);
	    ItemMeta especial1 = especial.getItemMeta();
	    especial1.setDisplayName("§6Refil");
	    especial.setItemMeta(especial1);
	    
	    ItemStack capacete0 = new ItemStack(Material.AIR);
	    
	    ItemStack peitoral0 = new ItemStack(Material.AIR);
	    
	    ItemStack calca0 = new ItemStack(Material.AIR);
	    
	    ItemStack Bota0 = new ItemStack(Material.AIR);
	    
	    p.getInventory().setHelmet(capacete0);
	    p.getInventory().setChestplate(peitoral0);
	    p.getInventory().setLeggings(calca0);
	    p.getInventory().setBoots(Bota0);
	    
	    if (cmd.equalsIgnoreCase("backpacker")) {
	      if (Array.used.contains(p.getName())) {
	    	  p.sendMessage("§7» §cVoce ja esta usando um kit!");
	        return true;
	      }
	      if (!p.hasPermission("kitpvp.kit.backpacker")) {
		      p.sendMessage("§cVoce nao tem permissao para usar este kit !");
	        return true;
	      }
	      Array.used.add(p.getName());
	      p.sendMessage(" §7» Voce escolheu o kit §cBackpacker §7!");
	      p.setGameMode(GameMode.ADVENTURE);
	      p.getInventory().clear();
	      Array.kit.put(p, "Backpacker");
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