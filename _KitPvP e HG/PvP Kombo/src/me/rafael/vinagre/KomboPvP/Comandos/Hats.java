package me.rafael.vinagre.KomboPvP.Comandos;

import java.util.ArrayList;

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

public class Hats implements Listener {
	private static ArrayList<String> comchapeu = new ArrayList<>();
	  public Hats(Main main) {
}
	public static void Inv(Player p) {
		Inventory inv = Bukkit.createInventory(p, 18, "§6§lHats !");
		
		ItemStack ant1 = new ItemStack(Material.THIN_GLASS);
		ItemMeta antv1 = ant1.getItemMeta();
		antv1.setDisplayName("§c[§a§l§k;;§c]");
		ant1.setItemMeta(antv1);
		ItemStack ct = new ItemStack(Material.WORKBENCH);
		ItemMeta ct1 = ct.getItemMeta();
		ct1.setDisplayName("§cCrafting Table !");
		ct.setItemMeta(ct1);
		ItemStack ft = new ItemStack(Material.FURNACE);
		ItemMeta ft1 = ft.getItemMeta();
		ft1.setDisplayName("§cFornalha !");
		ft.setItemMeta(ft1);
		ItemStack vt = new ItemStack(Material.GLASS);
		ItemMeta vt1 = vt.getItemMeta();
		vt1.setDisplayName("§cVidrin !");
		vt.setItemMeta(vt1);
		ItemStack tt = new ItemStack(Material.TNT);
		ItemMeta tt1 = tt.getItemMeta();
		tt1.setDisplayName("§cTnT !");
		tt.setItemMeta(tt1);
		ItemStack dt = new ItemStack(Material.DIAMOND_BLOCK);
		ItemMeta dt1 = dt.getItemMeta();
		dt1.setDisplayName("§cDima !");
		dt.setItemMeta(dt1);
		ItemStack st = new ItemStack(Material.MOB_SPAWNER);
		ItemMeta st1 = st.getItemMeta();
		st1.setDisplayName("§cMobSpawner !");
		st.setItemMeta(st1);
		ItemStack bt = new ItemStack(Material.BOOKSHELF);
		ItemMeta bt1 = bt.getItemMeta();
		bt1.setDisplayName("§cEstante !");
		bt.setItemMeta(bt1);
		ItemStack rt = new ItemStack(Material.SHEARS);
		ItemMeta rt1 = rt.getItemMeta();
		rt1.setDisplayName("§cRetirar chapeu !");
		rt.setItemMeta(rt1);
		inv.setItem(4 , ct);
		inv.setItem(5,	 ft);
		inv.setItem(3, vt);
		inv.setItem(1, bt);
		inv.setItem(6, tt);
		inv.setItem(7, st);
		inv.setItem(2, dt);
		inv.setItem(13, rt);
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
	@EventHandler
	void clicou(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if(p.getOpenInventory().getTitle().equalsIgnoreCase("§6§lHats !")) {
			if(e.getCurrentItem().getType() == Material.WORKBENCH) {
				p.getInventory().setHelmet(new ItemStack(Material.WORKBENCH));
				p.sendMessage("§7§lVoce alterou sua cabeça para : §c§lCrafting Table !");
				comchapeu.remove(p);
				comchapeu.add(p.getName());
				p.closeInventory();
			}
			if(e.getCurrentItem().getType() == Material.FURNACE) {
				p.getInventory().setHelmet(new ItemStack(Material.FURNACE));
				p.sendMessage("§7§lVoce alterou sua cabeça para : §c§lFornalha !");
				comchapeu.remove(p);
				comchapeu.add(p.getName());
				p.closeInventory();
			}
			if(e.getCurrentItem().getType() == Material.SHEARS) {
				if(!comchapeu.contains(p.getName())) {
					p.sendMessage("§cVoce nao esta com chapéu !");
				} else {
                p.getInventory().setHelmet(new ItemStack(Material.AIR));
                p.sendMessage("§7Voce retirou seu chapéu !");
                comchapeu.remove(p.getName());
				}
				p.closeInventory();
			}
			if(e.getCurrentItem().getType() == Material.GLASS) {
				p.getInventory().setHelmet(new ItemStack(Material.GLASS));
				p.sendMessage("§7§lVoce alterou sua cabeça para : §c§lVidrin !");
				comchapeu.remove(p);
				comchapeu.add(p.getName());
				p.closeInventory();
			}
			if(e.getCurrentItem().getType() == Material.TNT) {
				p.getInventory().setHelmet(new ItemStack(Material.TNT));
				p.sendMessage("§7§lVoce alterou sua cabeça para : §c§lTnT !");
				comchapeu.remove(p);
				comchapeu.remove(p);
				comchapeu.add(p.getName());
				p.closeInventory();
			}
			if(e.getCurrentItem().getType() == Material.DIAMOND_BLOCK) {
				p.getInventory().setHelmet(new ItemStack(Material.DIAMOND_BLOCK));
				p.sendMessage("§7§lVoce alterou sua cabeça para : §c§lDima !");
				comchapeu.remove(p);
				comchapeu.add(p.getName());
				p.closeInventory();
			}
			if(e.getCurrentItem().getType() == Material.THIN_GLASS ){
				p.closeInventory();
			}
			if(e.getCurrentItem().getType() == Material.BOOKSHELF) {
				p.getInventory().setHelmet(new ItemStack(Material.BOOKSHELF));
				p.sendMessage("§7§lVoce alterou sua cabeça para : §c§lEstante !");
				comchapeu.remove(p);
				comchapeu.add(p.getName());
				p.closeInventory();
			}
			if(e.getCurrentItem().getType() == Material.MOB_SPAWNER) {
				p.getInventory().setHelmet(new ItemStack(Material.MOB_SPAWNER));
				p.sendMessage("§7§lVoce alterou sua cabeça para : §c§lMobSpawner !");
				comchapeu.remove(p);
				comchapeu.add(p.getName());
				p.closeInventory();
			}
		}
	}
	@EventHandler
	void clicounoblock(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(p.getItemInHand().getType() == Material.JUKEBOX){
			if(e.getAction() == Action.RIGHT_CLICK_AIR){
				Inv(p);
			}
		}
	}

}