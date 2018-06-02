package me.rafael.vinagre.KomboPvP.Kits;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;

public class Barbarian 
implements Listener, CommandExecutor
{

	@EventHandler
	  public void onKill(PlayerDeathEvent e)
	  {
	    if ((e.getEntity().getKiller() instanceof Player)) {
	      Player k = e.getEntity().getKiller();

	      if (Array.kit.get(k) == "Barbarian")
	        if (k.getItemInHand().getType() == Material.WOOD_SWORD) {
	          k.setItemInHand(new ItemStack(Material.STONE_SWORD));
	          k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
	          k.sendMessage(ChatColor.GREEN + "UPGRADE! Level " + ChatColor.WHITE + "1");
	        } else if (k.getItemInHand().getType() == Material.STONE_SWORD) {
	          k.setItemInHand(new ItemStack(Material.IRON_SWORD));
	          k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
	          k.sendMessage(ChatColor.GREEN + "UPGRADE! Level " + ChatColor.WHITE + "2");
	        } else if (k.getItemInHand().getType() == Material.IRON_SWORD) {
	          k.setItemInHand(new ItemStack(Material.DIAMOND_SWORD));
	          k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
	          k.sendMessage(ChatColor.GREEN + "UPGRADE! Level " + ChatColor.WHITE + "3");
	        } else if (k.getItemInHand().getType() == Material.DIAMOND_SWORD) {
	          int max = 5;
	          if (k.getItemInHand().containsEnchantment(Enchantment.DAMAGE_ALL)) {
	            int lvl = k.getItemInHand().getEnchantmentLevel(Enchantment.DAMAGE_ALL);
	            if (lvl + 1 <= max) {
	              k.getItemInHand().removeEnchantment(Enchantment.DAMAGE_ALL);
	              k.getItemInHand().addEnchantment(Enchantment.DAMAGE_ALL, lvl + 1);
	              k.updateInventory();
	              k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
	              if (lvl + 1 == 2)
	                k.sendMessage(ChatColor.GREEN + "UPGRADE! Level " + ChatColor.WHITE + "5");
	              else if (lvl + 1 == 3)
	                k.sendMessage(ChatColor.GREEN + "UPGRADE! Level " + ChatColor.WHITE + "6");
	              else if (lvl + 1 == 4)
	                k.sendMessage(ChatColor.GREEN + "UPGRADE! Level " + ChatColor.WHITE + "7");
	              else if (lvl + 1 == 5)
	                k.sendMessage(ChatColor.GREEN + "UPGRADE! Level " + ChatColor.WHITE + "8");
	            }
	            else {
	              k.sendMessage(ChatColor.GOLD + "Voce esta no level maximo!");
	            }
	          } else {
	            k.getItemInHand().addEnchantment(Enchantment.DAMAGE_ALL, 1);
	            k.playSound(k.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
	            k.sendMessage(ChatColor.GREEN + "UPGRADE! Level " + ChatColor.WHITE + "4");
	          }
	        }
	    }
	  }
	  public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args)
	  {
	    Player p = (Player)sender;
	    ItemStack dima = new ItemStack(Material.WOOD_SWORD);
	    dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
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

	    
	    if (cmd.equalsIgnoreCase("barbarian")) {
	      if (Array.used.contains(p.getName())) {
	    	  p.sendMessage(" §7» §cVoce ja esta usando um kit!");
	        return true;
	      }
	      if (!p.hasPermission("kitpvp.kit.barbarian")) {
		      p.sendMessage("§cVoce nao tem permissao para usar este kit !");
	        return true;
	      }
	      Array.used.add(p.getName());
	      p.sendMessage(" §7» Voce escolheu o kit §cBarbarian §7!");
	      p.setGameMode(GameMode.ADVENTURE);
	      p.getInventory().clear();
	      Array.kit.put(p, "Barbarian");
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