package Zey.PvP.Eventos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlacaDeRecraft implements Listener {
	
    @EventHandler
    public void onSignChange(final SignChangeEvent e) {
        if (e.getLine(0).equalsIgnoreCase("[recraft]")) {
            e.setLine(0, "§7-=-(+)-=-");
            e.setLine(1, "§e§l RECRAFT ");
            e.setLine(2, "§e§l");
            e.setLine(3, "§7-=-(+)-=-");
        }
    }
	
	@EventHandler
	public void Inv(PlayerInteractEvent e) {
		Player p = (Player)e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && (e.getClickedBlock() != null && (e.getClickedBlock().getType() == Material.WALL_SIGN) 
		|| (e.getClickedBlock().getType() == Material.SIGN_POST))) {
			Sign s = (Sign)e.getClickedBlock().getState();
			String[] lines = s.getLines();
			if ((lines.length > 0) && (lines[0].equals("§7-=-(+)-=-")) &&
			     (lines.length > 1) && (lines[1].equals("§e§l RECRAFT ")) &&
                 (lines.length > 2) && (lines[2].equals("§e§l")) &&
                 (lines.length > 3) && (lines[3].equals("§7-=-(+)-=-"))) {
	    	    Inventory inv = Bukkit.createInventory(p, 27, "§e§lRECRAFT");
	    	    ItemStack cogu1 = new ItemStack(Material.RED_MUSHROOM, 64);
	    	    ItemMeta cogu1meta = cogu1.getItemMeta();
	    	    cogu1.setItemMeta(cogu1meta);
	    	    
	    	    ItemStack cogu2 = new ItemStack(Material.BROWN_MUSHROOM, 64);
	    	    ItemMeta cogu2meta = cogu2.getItemMeta();
	    	    cogu2.setItemMeta(cogu2meta);
	    	    
	    	    ItemStack potes = new ItemStack(Material.BOWL, 64);
	    	    ItemMeta potesmeta = potes.getItemMeta();
	    	    potes.setItemMeta(potesmeta);
	    	    
    	    for (int i =0; i != 9; i++) {
    	    	inv.setItem(i, cogu1);
    	    }
    	    for (int i =9; i != 18; i++) {
    	    	inv.setItem(i, cogu2);
    	    }
    	    for (int i =18; i != 27; i++) {
    	    	inv.setItem(i, potes);
    	    }
			p.openInventory(inv);
			}
		}
		
	}

}
