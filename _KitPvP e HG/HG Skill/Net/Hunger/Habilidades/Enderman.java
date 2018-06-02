package Net.Hunger.Habilidades;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Net.Hunger.Comandos.CMDKit;
import Net.Hunger.Manager.Habilidade;

public class Enderman implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDeathEnder(PlayerDeathEvent e) {
	Player p = e.getEntity();
    if ((p.getKiller() instanceof Player)) {
    if((Habilidade.getAbility(p).equalsIgnoreCase("enderman"))) {
   	ItemStack kit = new ItemStack(Material.ENDER_PEARL,1);
    ItemMeta rkit = kit.getItemMeta();
   	rkit.setDisplayName("§aEnderman §7Kit!");
    kit.setItemMeta(rkit);
    p.getKiller().getInventory().setItem(8, kit);
    p.getKiller().updateInventory();
    }
  }
 }
}
