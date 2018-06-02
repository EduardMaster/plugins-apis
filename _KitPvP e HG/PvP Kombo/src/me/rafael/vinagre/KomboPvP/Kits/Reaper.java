package me.rafael.vinagre.KomboPvP.Kits;

import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.Array;

public class Reaper 
implements Listener, CommandExecutor
{

	@EventHandler
    public void OnClick(EntityDamageByEntityEvent e)
    {
      if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
      {
        Player damager = (Player)e.getDamager();
        Player victim = (Player)e.getEntity();

        if (Array.kit.get(damager) == "Reaper"){
          if (damager.getInventory().getItemInHand().getType() == Material.WOOD_HOE) {
        	  damager.getLocation().getWorld().playEffect(damager.getLocation(), Effect.GHAST_SHOOT, 8);
        	  damager.getLocation().getWorld().playEffect(damager.getLocation(), Effect.GHAST_SHRIEK, 8);
            victim.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 3));
            return;
          }
          return;
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
	      ItemStack especial = new ItemStack(Material.WOOD_HOE);
	      ItemMeta especial2 = especial.getItemMeta();
	      especial2.setDisplayName("§0Wither_Hoe");
	      especial.setItemMeta(especial2);
	    
		    ItemStack capacete0 = new ItemStack(Material.AIR);
		    
		    ItemStack peitoral0 = new ItemStack(Material.AIR);
		    
		    ItemStack calca0 = new ItemStack(Material.AIR);
		    
		    ItemStack Bota0 = new ItemStack(Material.AIR);
	    
	    p.getInventory().setHelmet(capacete0);
	    p.getInventory().setChestplate(peitoral0);
	    p.getInventory().setLeggings(calca0);
	    p.getInventory().setBoots(Bota0);
      
      if (cmd.equalsIgnoreCase("reaper")) {
        if (Array.used.contains(p.getName())) {
        	p.sendMessage("§7» §cVoce ja esta usando um kit!");
          return true;
        }
	      if (!p.hasPermission("kitpvp.kit.reaper")) {
		      p.sendMessage("§cVoce nao tem permissao para usar este kit !");
	        return true;
	      }
        Array.used.add(p.getName());
        p.sendMessage("§7» Voce escolheu o kit §cReaper §7!");
	    p.setGameMode(GameMode.ADVENTURE);
        p.getInventory().clear();
        Array.kit.put(p, "Reaper");
        Main.Dj.remove(p.getName());
        Main.stomper.remove(p.getName());
        Scoreboard.ScoreDoBasic.iscoriboard(p);
        
        p.getInventory().addItem(new ItemStack[] { dima });
        p.getInventory().addItem(new ItemStack [] { especial });
        Main.give(p);
        
        for (int i = 0; i <= 34; i++) {
          p.getInventory().addItem(new ItemStack[] { sopa });
         
        }
      }
      me.rafael.vinagre.KomboPvP.Comandos.SetArena.TeleportArenaRandom(p);
      return false;
    }
  }