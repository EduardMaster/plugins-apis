package EventosPrincipais;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class ItemQuebrar implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void Quebrar(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		ItemStack item1 = p.getItemInHand();
		Material material1 = Material.getMaterial(item1.getTypeId());
		if (!(material1.isBlock() || material1.getMaxDurability() < 1)) {
			if (!(item1.getDurability() == 0 )) {
				p.getItemInHand().setDurability((short)0);
				p.updateInventory();
			}
		}
		PlayerInventory item2 = p.getInventory();
		//Reparar Capacete
		if (p.getInventory().getHelmet() != null) {
			Material material2 = Material.getMaterial(item2.getHelmet().getTypeId());
			if (!(material2.isBlock() || material2.getMaxDurability() < 1)) {
				if (!(item2.getHelmet().getDurability() == 0)) {
					p.getInventory().getHelmet().setDurability((short)1);
				}
			}
		}
		//Reparar Peitoral
		if (p.getInventory().getChestplate() != null) {
			Material material2 = Material.getMaterial(item2.getChestplate().getTypeId());
			if (!(material2.isBlock() || material2.getMaxDurability() < 1)) {
				if (!(item2.getChestplate().getDurability() == 0)) {
					p.getInventory().getChestplate().setDurability((short)1);
				}
			}
		}
		//Reparar Calça
		if (p.getInventory().getLeggings() != null) {
			Material material2 = Material.getMaterial(item2.getLeggings().getTypeId());
			if (!(material2.isBlock() || material2.getMaxDurability() < 1)) {
				if (!(item2.getLeggings().getDurability() == 0)) {
					p.getInventory().getLeggings().setDurability((short)1);
				}
			}
		}
		//Reparar Bota
		if (p.getInventory().getBoots() != null) {
			Material material2 = Material.getMaterial(item2.getBoots().getTypeId());
			if (!(material2.isBlock() || material2.getMaxDurability() < 1)) {
				if (!(item2.getBoots().getDurability() == 0)) {
					p.getInventory().getBoots().setDurability((short)1);
				}
			}
		}
	}

}
