package Net.Hunger.Habilidades;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Net.Hunger.Manager.Habilidade;

public class Swords implements Listener {

	@EventHandler
	public void Dropando(PlayerDropItemEvent e) {
	Player p = e.getPlayer();
	ItemStack item = e.getItemDrop().getItemStack();
	if (Habilidade.getAbility(p).equalsIgnoreCase("swords")) {
	if(item.getItemMeta().getDisplayName().contains("Swords")) {
	e.setCancelled(true);
	p.updateInventory();
	p.sendMessage("§cDesculpe, mas você não pode dropar esse item!");
	}
	}
	}
	
	@EventHandler
	public void SwordsAlterner(PlayerInteractEvent e) {
	Player player = (Player)e.getPlayer();
	if(player.getItemInHand() != null && player.getItemInHand().getType() != Material.AIR){
	ItemStack hand = player.getItemInHand();
	if(Habilidade.getAbility(player).equalsIgnoreCase("swords")) {
	if(hand.hasItemMeta() && hand.getItemMeta().hasDisplayName() && (hand.getItemMeta().getDisplayName().equals("§aSwords Wood §7Kit!"))) {
	ItemStack Pedra = new ItemStack(Material.STONE_SWORD);
	ItemMeta MetaPedra = Pedra.getItemMeta();
	MetaPedra.setDisplayName("§aSwords Stone §7Kit!");
	Pedra.setItemMeta(MetaPedra);
	player.setItemInHand(Pedra);
    } else if(hand.hasItemMeta() && hand.getItemMeta().hasDisplayName() && (hand.getItemMeta().getDisplayName().equals("§aSwords Stone §7Kit!"))) {
    ItemStack Gold = new ItemStack(Material.GOLD_SWORD);
    ItemMeta MetaGold = Gold.getItemMeta();
    MetaGold.setDisplayName("§aSwords Gold §7Kit!");
    Gold.setItemMeta(MetaGold);
    player.setItemInHand(Gold);
    } else if(hand.hasItemMeta() && hand.getItemMeta().hasDisplayName() && (hand.getItemMeta().getDisplayName().equals("§aSwords Gold §7Kit!"))) {
    ItemStack Iron = new ItemStack(Material.IRON_SWORD);
    ItemMeta MetaIron = Iron.getItemMeta();
    MetaIron.setDisplayName("§aSwords Iron §7Kit!");
    Iron.setItemMeta(MetaIron);
    player.setItemInHand(Iron);	
    } else if(hand.hasItemMeta() && hand.getItemMeta().hasDisplayName() && (hand.getItemMeta().getDisplayName().equals("§aSwords Iron §7Kit!"))) {
    ItemStack Madeira = new ItemStack(Material.WOOD_SWORD);
   	ItemMeta MetaMadeira = Madeira.getItemMeta();
   	MetaMadeira.setDisplayName("§aSwords Wood §7Kit!");
   	Madeira.setItemMeta(MetaMadeira);
    player.setItemInHand(Madeira);	
    }
   }
  }
 }
}