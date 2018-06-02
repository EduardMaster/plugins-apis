package Punheta;



	import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
	import org.bukkit.Material;
	import org.bukkit.entity.Player;
	import org.bukkit.event.EventHandler;
	import org.bukkit.event.Listener;
	import org.bukkit.event.block.Action;
	import org.bukkit.event.inventory.InventoryClickEvent;
	import org.bukkit.event.player.PlayerInteractEvent;
	import org.bukkit.inventory.Inventory;
	import org.bukkit.inventory.ItemStack;
	import org.bukkit.inventory.meta.ItemMeta;

import me.rafael.vinagre.KomboPvP.Main;;

	public class Ranks implements Listener {
		private static ArrayList<String> comchapeu = new ArrayList<>();
		  public Ranks() {
	}
		public static void Abrir(Player p) {
			
			Inventory inv = Bukkit.createInventory(p, 18, "§dRanks");
			
			
			ItemStack ant1 = new ItemStack(Material.THIN_GLASS);
			ItemMeta antv1 = ant1.getItemMeta();
			antv1.setDisplayName("");
			ant1.setItemMeta(antv1);
			ItemStack ct = new ItemStack(Material.FLINT);
			ItemMeta ct1 = ct.getItemMeta();
			ct1.setDisplayName("§cUnranked");
			List<String> lore1 = new ArrayList();
			lore1.add("§f0 a 20 Kills");
			ct1.setLore(lore1);
			ct.setItemMeta(ct1);
			ItemStack ft = new ItemStack(Material.CLAY_BRICK);
			ItemMeta ft1 = ft.getItemMeta();
			ft1.setDisplayName("§aBronze");
			List<String> lore2 = new ArrayList();
			lore2.add("§f20 a 180 Kills");
			ft1.setLore(lore2);
			ft.setItemMeta(ft1);
			ItemStack vt = new ItemStack(Material.IRON_INGOT);
			ItemMeta vt1 = vt.getItemMeta();
			vt1.setDisplayName("§7Silver");
			List<String> lore3 = new ArrayList();
			lore3.add("§f180 a 280 Kills");
			vt1.setLore(lore3);
			vt.setItemMeta(vt1);
			ItemStack tt = new ItemStack(Material.GOLD_INGOT);
			ItemMeta tt1 = tt.getItemMeta();
			tt1.setDisplayName("§eGold");
			List<String> lore4 = new ArrayList();
			lore4.add("§f280 a 400 Kills");
			tt1.setLore(lore4);
			tt.setItemMeta(tt1);
			ItemStack dt = new ItemStack(Material.DIAMOND);
			ItemMeta dt1 = dt.getItemMeta();
			dt1.setDisplayName("§bDiamond");
			List<String> lore5 = new ArrayList();
			lore5.add("§f400 a 500 Kills");
			dt1.setLore(lore5);
			dt.setItemMeta(dt1);
			ItemStack st = new ItemStack(Material.EMERALD);
			ItemMeta st1 = st.getItemMeta();
			st1.setDisplayName("§2Emerald");
			List<String> lore6 = new ArrayList();
			lore6.add("§f500 a 600 Kills");
			st1.setLore(lore6);
			st.setItemMeta(st1);
			ItemStack bt = new ItemStack(Material.REDSTONE);
			ItemMeta bt1 = bt.getItemMeta();
			bt1.setDisplayName("§cRuby");
			List<String> lore7 = new ArrayList();
			lore7.add("§fUltimo rank");
			bt1.setLore(lore7);
			bt.setItemMeta(bt1);
			
			
			inv.setItem(1 , ct);
			inv.setItem(2,	 ft);
			inv.setItem(3, vt);
			inv.setItem(7, bt);
			inv.setItem(4, tt);
			inv.setItem(6, st);
			inv.setItem(5, dt);
			
			inv.setItem(inv.firstEmpty(), ant1);
			inv.setItem(inv.firstEmpty(), ant1);
			inv.setItem(inv.firstEmpty(), ant1);
			inv.setItem(inv.firstEmpty(), ant1);
			inv.setItem(inv.firstEmpty(), ant1);
			inv.setItem(inv.firstEmpty(), ant1);
			inv.setItem(inv.firstEmpty(), ant1);
			inv.setItem(inv.firstEmpty(), ant1);
			inv.setItem(inv.firstEmpty(), ant1);
			inv.setItem(inv.firstEmpty(), ant1);
			inv.setItem(inv.firstEmpty(), ant1);
			p.openInventory(inv);
		}
}