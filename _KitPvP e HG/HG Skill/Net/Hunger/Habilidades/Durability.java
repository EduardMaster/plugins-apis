package Net.Hunger.Habilidades;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import Net.Hunger.Comandos.CMDKit;
import Net.Hunger.Manager.Habilidade;

public class Durability implements Listener {
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
	Player player = event.getPlayer();
	if((Habilidade.getAbility(player).equalsIgnoreCase("durability"))) {
    if ((player.getItemInHand().getType() == Material.WOOD_SWORD) || 
    (player.getItemInHand().getType() == Material.STONE_SWORD) || 
    (player.getItemInHand().getType() == Material.IRON_SWORD) || 
    (player.getItemInHand().getType() == Material.GOLD_SWORD) || 
    (player.getItemInHand().getType() == Material.DIAMOND_SWORD) || 
    (player.getItemInHand().getType() == Material.WOOD_AXE) || 
    (player.getItemInHand().getType() == Material.WOOD_PICKAXE) || 
    (player.getItemInHand().getType() == Material.STONE_PICKAXE) || 
    (player.getItemInHand().getType() == Material.STONE_AXE)) {
    player.getItemInHand().setDurability((short)0);
    }
	}
    }
	
	@EventHandler
	public void onDamage(EntityDamageEvent event) {
	if ((event.getEntity() instanceof Player)) {
	Player p = (Player)event.getEntity();
	if((Habilidade.getAbility(p).equalsIgnoreCase("durability"))) {
	ItemStack[] armor = p.getInventory().getArmorContents();
    if (armor.length > 0) {
    for (int i = 0; i < armor.length; i++) {
    armor[i].setDurability((short)-armor[i].getType().getMaxDurability());
     }
    }
   }
  }
 }
}