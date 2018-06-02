package Net.Hunger.Habilidades;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Net.Hunger.Main;
import Net.Hunger.Comandos.CMDKit;
import Net.Hunger.Manager.Habilidade;

public class Cacto implements Listener {
	
	  @EventHandler
	  public void onCamel(PlayerMoveEvent e) {
	  Player p = e.getPlayer();
	  Block b = e.getTo().add(0.0D, -1.0D, 0.0D).getBlock();
	  if(Main.PreGame) {
	  return;
	  } else if(Habilidade.getAbility(p).equalsIgnoreCase("cacto") && (b.getType() == Material.SAND)) {
	  p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 1));
	  }
	  }
	  
	  public static void RecraftCactus(Player p) {
	  if(Habilidade.getAbility(p).equalsIgnoreCase("cacto")) {
	  ItemStack Resultado = new ItemStack(Material.MUSHROOM_SOUP, 1);
	  ItemMeta Cactus = Resultado.getItemMeta();
	  Resultado.setItemMeta(Cactus);
	  ShapelessRecipe CraftCactus = new ShapelessRecipe(Resultado);
	  CraftCactus.addIngredient(1, Material.CACTUS);
	  CraftCactus.addIngredient(1, Material.SAND);
	  Bukkit.getServer().addRecipe(CraftCactus);    
	  } else {
	  return;
	  }
	  }
	  
	 @SuppressWarnings("deprecation")
	 @EventHandler
	  public void onDamage(BlockDamageEvent event) {
	    Player p = event.getPlayer();
	    if ((Habilidade.getAbility(p).equalsIgnoreCase("cacto")) && (event.getBlock().getType() == Material.CACTUS)) {
	      event.getBlock().getLocation().distance(p.getWorld().getSpawnLocation());
	      boolean drop = true;
	      if (((CraftPlayer) p).getHealth() < 20.0D) {
	        double hp = ((CraftPlayer) p).getHealth() + 1.0D;
	        if (hp > 20.0D)
	          hp = 20.0D;
	        p.setHealth((int)hp);
	        drop = false;
	      } else if (p.getFoodLevel() < 20) {
	        p.setFoodLevel(p.getFoodLevel() + 1);
	        drop = false;
	      }
	      event.getBlock().getWorld().playEffect(event.getBlock().getLocation(), Effect.SMOKE, Material.CACTUS.getId());
	      event.getBlock().setType(Material.AIR);
	      if (drop)
	      event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation().add(0.5D, 0.0D, 0.5D), new ItemStack(Material.CACTUS));
	    }
	  }
}