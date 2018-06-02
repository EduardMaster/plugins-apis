package me.recenthg.Kits;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.recenthg.Main;
import me.recenthg.Manager.Habilidade;
import me.recenthg.Utils.Estado;

public class Well implements Listener {

	  private ArrayList<String> Cooldown = new ArrayList<String>();
	
	  @SuppressWarnings("deprecation")
	  @EventHandler
	  public void SpawnarPoço(PlayerInteractEvent e) {
	    final Player p = e.getPlayer();
	    if(Main.estados == Estado.ANDAMENTO) {
	    if(Habilidade.getAbility(p).equalsIgnoreCase("well"))  {
	    if(Cooldown.contains(p.getName()) && (p.getItemInHand().getType() == Material.GOLD_NUGGET)) {
	      p.sendMessage("§8\u276e§4§l!§8\u276f §7Você esta no cooldown!");
	      e.setCancelled(true);
	      return;
	    } else if(!Cooldown.contains(p.getName()) && (p.getItemInHand().getType() == Material.GOLD_NUGGET)) {
	        Cooldown.add(p.getName());
	        Location Local = e.getPlayer().getLocation();
	        Local = Local.getWorld().getHighestBlockAt(Local).getLocation().add(0.0D, 0.0D, 0.0D);
	        Player localPlayer = e.getPlayer();
	        for (int x = 0; x <= 0; x++) {
	        for (int z = 0; z <= 0; z++) {
	        
	        final Block a = Local.add(x, 0.0D, z).getBlock();
	        final Block b = Local.add(1.0D, 0.0D, z).getBlock();
	        final Block c = Local.add(1.0D, 0.0D, z).getBlock();
	        
	        a.setType(Material.getMaterial(4));
	        b.setType(Material.getMaterial(4));
	        c.setType(Material.getMaterial(4));
	        
	        final Block d = Local.add(x, 0.0D, 1.0D).getBlock();
	        final Block f = Local.add(x, 0.0D, 1.0D).getBlock();
	        
	        d.setType(Material.getMaterial(4));
	        f.setType(Material.getMaterial(4));
	        
	        final Block g = Local.add(-1.0D, 0.0D, -1.0D).getBlock();
	        
	        g.setType(Material.STATIONARY_WATER);
	        
	        final Block h = Local.add(1.0D, 0.0D, 1.0D).getBlock();

	        h.setType(Material.getMaterial(4));
	        
	        final Block j = Local.add(-1.0D, 0.0D, 0.0D).getBlock();
	        	
	        j.setType(Material.getMaterial(4));
	        
	        final Block k = Local.add(-1.0D, 0.0D, z).getBlock();
        	
	        k.setType(Material.getMaterial(4));
	        
	        final Block l = Local.add(x, 0.0D, -1.0D).getBlock();
	        
	        l.setType(Material.getMaterial(4));
	        
	        final Block m = Local.add(-0.0D, 1.0D, 1.0D).getBlock();
	        
	        m.setType(Material.getMaterial(85));
	        
	        final Block n = Local.add(-0.0D, 1.0D, 0.0D).getBlock();
	        
	        n.setType(Material.getMaterial(85));
	        
	        final Block o = Local.add(-0.0D, 0.0D, -2.0D).getBlock();
	        
	        o.setType(Material.getMaterial(85));
	        
	        final Block q = Local.add(0.0D, -1.0D, -0.0D).getBlock();
	        
	        q.setType(Material.getMaterial(85));
	        
	        final Block r = Local.add(2.0D, 1.0D, -0.0D).getBlock();
	        
	        r.setType(Material.getMaterial(85));
	        
	        final Block s = Local.add(0.0D, -1.0D, -0.0D).getBlock();
	        
	        s.setType(Material.getMaterial(85));
	        
	        final Block t = Local.add(0.0D, 1.0D, 2.0D).getBlock();
	        
	        t.setType(Material.getMaterial(85));
	        
	        final Block u = Local.add(0.0D, -1.0D, 0.0D).getBlock();
	        
	        u.setType(Material.getMaterial(85));
	        
	        final Block ps = Local.add(0.0D, 2.0D, 0.0D).getBlock();
	        
	        ps.setType(Material.getMaterial(4));
	        
	        final Block pss = Local.add(-1.0D, 0.0D, 0.0D).getBlock();
	        
	        pss.setType(Material.getMaterial(4));
	        
	        final Block psr = Local.add(-1.0D, 0.0D, 0.0D).getBlock();
	        
	        psr.setType(Material.getMaterial(4));
	        
	        final Block psx = Local.add(x, 0.0D, -2.0D).getBlock();
	        
	        psx.setType(Material.getMaterial(4));
	        
	        final Block pse = Local.add(x, 0.0D, 1.0D).getBlock();
	        
	        pse.setType(Material.getMaterial(4));
	        
	        final Block pser = Local.add(1.0D, 0.0D, -1.0D).getBlock();
	        
	        pser.setType(Material.getMaterial(4));
	        
	        final Block psers = Local.add(1.0D, 0.0D, 1.0D).getBlock();
	        
	        psers.setType(Material.getMaterial(4));
	        
	        final Block psersu = Local.add(0.0D, 0.0D, -1.0D).getBlock();
	        
	        psersu.setType(Material.getMaterial(4));
	        
	        final Block psersru = Local.add(-1.0D, 0.0D, 1.0D).getBlock();
	        
	        psersru.setType(Material.getMaterial(89));
	        
	        final Block gs = Local.add(x, -4.0D, z).getBlock();
	        
	        gs.setType(Material.BEDROCK);
	        localPlayer.sendMessage("§8\u276e§4§l!§8\u276f §7O Poço esta verificando...");
	        localPlayer.sendMessage("§8\u276e§4§l!§8\u276f §7Você ficara no cooldown por §7 Minutos!");
	        localPlayer.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 10));
	        localPlayer.playSound(localPlayer.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
	        localPlayer.getWorld().playEffect(localPlayer.getLocation(), Effect.SMOKE, 10);
	        e.getPlayer().teleport(Local.add(x, 1.0D, z));
	        Random kit = new Random();
	        int number = kit.nextInt(19);
	        switch (number) {
	        case 0: 
		      localPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2400, 1));
	          p.sendMessage("§8\u276e§4§l!§8\u276f §7O Poço lhe deu §aSpeed II");
	          break;
	        case 1: 
	          p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.DIAMOND, 2));
	          p.sendMessage("§8\u276e§4§l!§8\u276f §7O Poço lhe deu §aII Diamantes");
	          break;
	        case 2: 
		      p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.IRON_INGOT, 7));
		      p.sendMessage("§8\u276e§4§l!§8\u276f §7O Poço lhe deu §a7 Ferros");
	          break;
	        case 3: 
		     World w3 = p.getWorld();
		     Entity tnt3 = w3.spawn(p.getLocation(), TNTPrimed.class);
		     ((TNTPrimed)tnt3).setFuseTicks(2);
		      p.sendMessage("§8\u276e§4§l!§8\u276f §7O Poço lhe deu §aUma Explosão!");
	          break;
	        case 4: 
			  p.sendMessage("§8\u276e§4§l!§8\u276f §7O Poço lhe deu §a2 Zombies!");
	          p.getWorld().spawnCreature(p.getLocation(), EntityType.ZOMBIE);
	          p.getWorld().spawnCreature(p.getLocation(), EntityType.ZOMBIE);
	          break;
	        case 5: 
			  p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.GOLD_INGOT, 10));
			  p.sendMessage("§8\u276e§4§l!§8\u276f §7O Poço lhe deu §a10 Ouros");
	          break;
	        case 6: 
			  p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.COAL, 30));
		      p.sendMessage("§8\u276e§4§l!§8\u276f §7O Poço lhe deu §a30 Carvões");
	          break;
	        case 7: 
		      p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.GOLD_SWORD, 1));
			  p.sendMessage("§8\u276e§4§l!§8\u276f §7O Poço lhe deu §a1 Espada de ouro!");
	          break;
	        case 8: 
			  localPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2400, 2));
		      p.sendMessage("§8\u276e§4§l!§8\u276f §7O Poço lhe deu §aSpeed III");
	          break;
	        case 9: 
			  localPlayer.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 2400, 0));
			  p.sendMessage("§8\u276e§4§l!§8\u276f §7O Poço lhe deu §aForça I");
	          break;
	        case 11: 
			  p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.DIRT, 64));
			  p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.DIRT, 64));
			  p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.DIRT, 64));
			  p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.DIRT, 64));
			  p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.DIRT, 64));
			  p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.DIRT, 64));
			  p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.DIRT, 64));
			  p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.DIRT, 64));
			  p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.DIRT, 64));
			  p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.DIRT, 64));
		      p.sendMessage("§8\u276e§4§l!§8\u276f §7O Poço lhe deu §a10 Pack de 64 terras!");
	          break;
	        case 13: 
			  p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.BOW, 1));
			  p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.ARROW, 30));
		      p.sendMessage("§8\u276e§4§l!§8\u276f §7O Poço lhe deu §a1 Kit Archer");
		      break;
	        case 14:
		      p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.LEATHER_HELMET,1));
		      p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.LEATHER_CHESTPLATE,1));
		      p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.LEATHER_LEGGINGS,1));
		      p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.LEATHER_BOOTS,1));
		      p.sendMessage("§8\u276e§4§l!§8\u276f §7O Poço lhe deu §a1 Full Couro!");
		      break;
	        case 15:
			  p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.IRON_CHESTPLATE,1));
		      p.sendMessage("§8\u276e§4§l!§8\u276f §7O Poço lhe deu §a1 Peitoral de ferro!");
	          break;
	        case 16:
			  p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.GOLD_CHESTPLATE,1));
		      p.sendMessage("§8\u276e§4§l!§8\u276f §7O Poço lhe deu §a1 Peitoral de ouro!");
			  break;
	        case 17:
			  p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.GOLD_LEGGINGS,1));
		      p.sendMessage("§8\u276e§4§l!§8\u276f §7O Poço lhe deu §a1 calça de ouro!");
			  break;
	        case 18:
			  p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.ENDER_PEARL,16));
		      p.sendMessage("§8\u276e§4§l!§8\u276f §7O Poço lhe deu §a16 EnderPearl!");
			  break;
	        case 19:
			  p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.RED_MUSHROOM,16));
			  p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.BROWN_MUSHROOM,16));
			  p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.BOWL,16));
		      p.sendMessage("§8\u276e§4§l!§8\u276f §7O Poço lhe deu §aRecraft!");
			  break;
	        case 20:
			  p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.STONE_SWORD,1));
			  p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.RED_MUSHROOM,16));
			  p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.BROWN_MUSHROOM,16));
			  p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.BOWL,16));
		      p.sendMessage("§8\u276e§4§l!§8\u276f §7O Poço lhe deu §aKit Basico PvP!");
			  break;
	        }
	  	   Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
	  	   public void run() {
		    p.sendMessage("§8\u276e§4§l!§8\u276f §7O Poço foi destruido!");
	  		a.setType(Material.AIR);
	  		b.setType(Material.AIR);
	  		c.setType(Material.AIR);
	  		d.setType(Material.AIR);
	  		f.setType(Material.AIR);
	  		g.setType(Material.AIR);
	  		h.setType(Material.AIR);
	  		j.setType(Material.AIR);
	  		k.setType(Material.AIR);
	  		l.setType(Material.AIR);
	  		m.setType(Material.AIR);
	  		n.setType(Material.AIR);
	  		o.setType(Material.AIR);
	  		q.setType(Material.AIR);
	  		r.setType(Material.AIR);
	  		s.setType(Material.AIR);
	  		t.setType(Material.AIR);
	  		u.setType(Material.AIR);
	  		ps.setType(Material.AIR);
	  		pss.setType(Material.AIR);
	  		psr.setType(Material.AIR);
	  		psx.setType(Material.AIR);
	  		pse.setType(Material.AIR);
	  		pser.setType(Material.AIR);
	  		psers.setType(Material.AIR);
	  		psersu.setType(Material.AIR);
	  		psersru.setType(Material.AIR);
	  		gs.setType(Material.AIR);
	  	   }
	  	   },200L);
	  	   Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
	  	   public void run() {
	  	   Cooldown.remove(p.getName());
	  	 p.sendMessage("§8\u276e§4§l!§8\u276f §7Você ja pode gerar o §apoço§8\u276e§4§l!§8\u276f §7 novamente!");
	 	 p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 4.0F, 4.0F);
	  	   }
	  	   },1200L);
	      }
	     }
	    }
       }
      } else if(p.getItemInHand().getType().equals(Material.GOLD_NUGGET)) {
       p.sendMessage("§8\u276e§4§l!§8\u276f §7Você so pode usar seu kit com a partida §7em §aandamento!");
       return;
      }
     }
    }