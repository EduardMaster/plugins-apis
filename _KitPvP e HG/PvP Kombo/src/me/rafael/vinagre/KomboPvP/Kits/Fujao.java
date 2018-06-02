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
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;

public class Fujao 
implements Listener, CommandExecutor
{
	
	public static HashMap<String, Long> cooldown = new HashMap();

	@EventHandler
	  public void interact(PlayerInteractEvent e)
	  {
	    Player p = e.getPlayer();
	    if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
	    		(Array.kit.get(p) == "Fujao") && 
	      (p.getItemInHand().getType() == Material.REDSTONE_TORCH_ON))
	    {
	    	if (GladiatorHAB.lutando.containsKey(p.getName()) || InfernorHAB.fighting.containsKey(p.getName())) {
                p.sendMessage(String.valueOf("§cVoc\u00ea n\u00e3o poder usar seu kit no gladiator(infernor) ent\u00e3o vai §aganhar §eum efeito de §aspeed"));
                Main.darEfeito(p, PotionEffectType.INCREASE_DAMAGE, 10, 1);
                Main.darEfeito(p, PotionEffectType.SPEED, 10, 2);
                
            }
	        else {
                e.setCancelled(true);
	      if ((!cooldown.containsKey(p.getName())) || (((Long)cooldown.get(p.getName())).longValue() <= System.currentTimeMillis()))
	      {
	        e.setCancelled(true);
	        p.updateInventory();
	        
	        p.sendMessage(ChatColor.RED + "Ativando modo Zembolt !");
	        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 130, 6));
	        p.playSound(p.getLocation(), Sound.PISTON_EXTEND, 1.0F, 1.0F);
	        cooldown.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(40L)));
	        return;
	      }
	      
	      p.sendMessage(ChatColor.RED + "Faltam " + TimeUnit.MILLISECONDS.toSeconds(((Long)cooldown.get(p.getName())).longValue() - System.currentTimeMillis()) + " segundos para poder usar novamente.");
	    }
	    }
	  } 
	
	  public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args)
	  {
	    Player p = (Player)sender;
	    ItemStack dima = new ItemStack(Material.STONE_SWORD);
	    ItemMeta souperaa = dima.getItemMeta();
	    souperaa.setDisplayName("§bEspada");
	    dima.setItemMeta(souperaa);
	    ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
	    ItemMeta sopas = sopa.getItemMeta();
	    sopas.setDisplayName("§6Sopa");
	    sopa.setItemMeta(sopas);
		  ItemStack especial = new ItemStack(Material.REDSTONE_TORCH_ON);
		    ItemMeta especial1 = especial.getItemMeta();
		    especial1.setDisplayName("§5Speed");
		    especial.setItemMeta(especial1);
	    
	    ItemStack capacete0 = new ItemStack(Material.AIR);
	    
	    ItemStack peitoral0 = new ItemStack(Material.AIR);
	    
	    ItemStack calca0 = new ItemStack(Material.AIR);
	    
	    ItemStack Bota0 = new ItemStack(Material.AIR);
	    
	    p.getInventory().setHelmet(capacete0);
	    p.getInventory().setChestplate(peitoral0);
	    p.getInventory().setLeggings(calca0);
	    p.getInventory().setBoots(Bota0);
	  
	  if (cmd.equalsIgnoreCase("fujao")) {
	    if (Array.used.contains(p.getName())) {
	    	p.sendMessage("§7» §cVoce ja esta usando um kit!");
	      return true;
	    }
	    if (!p.hasPermission("kitpvp.kit.fujao")) {
		      p.sendMessage("§cVoce nao tem permissao para usar este kit !");
	      return true;
	    }
	    Array.used.add(p.getName());
	    p.sendMessage("§7» Voce escolheu o kit §cFujao §7!");
	    p.setGameMode(GameMode.ADVENTURE);
	    p.getInventory().clear();
	    Array.kit.put(p, "Fujao");
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

