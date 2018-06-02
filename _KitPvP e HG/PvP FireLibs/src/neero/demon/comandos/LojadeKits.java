package neero.demon.comandos;

import java.util.ArrayList;

import neero.demon.Main;
import neero.demon.eventos.Dinheiro;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class LojadeKits implements Listener, CommandExecutor {
	
	  public void MoneyErro(Player p, String k, int m) {
  	    p.sendMessage(" Você não tem §c" + m + " §7De Coins Para comprar esse Kit");
  	    p.closeInventory();
  	  }

  	  public void Jatem(Player p) {
  	    p.sendMessage(" Você já possui esse Kit !");
  	    p.closeInventory();
  	  }

  	  public void Sucesso(Player p, String k) {
  	    p.sendMessage(" Parabéns você comprou o Kit §c" + k);
  	    Main.getInstance().loja.set(p.getName().toLowerCase() + "." + k, Boolean.valueOf(true));
  	    Main.getInstance().save2();
  	    p.closeInventory();
  	  }
	
	@SuppressWarnings("deprecation")
	/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	/*     */   {
		Player p = (Player) sender;
	/* 184 */     if (!(sender instanceof Player)) {
	/* 185 */       sender.sendMessage("§7[§cErro§7] §cApenas jogadores podem executar esse comando");
	/* 186 */       return true;
	/*     */     }
		Inventory inv = Bukkit.getServer().createInventory(p, 27, "§c§nLoja de Kits");
		
		ItemStack vidro = new ItemStack(Material.getMaterial(160),1,(short) 15);
		ItemMeta zvidro = vidro.getItemMeta();
		zvidro.setDisplayName("§e§lEXTREMEPVP");
		vidro.setItemMeta(zvidro);
		
		ItemStack vidro1 = new ItemStack(Material.getMaterial(160),1,(short) 14);
		ItemMeta zvidro1 = vidro1.getItemMeta();
		zvidro1.setDisplayName("§e§lEXTREMEPVP");
		vidro1.setItemMeta(zvidro1);
		
		ItemStack Reaper = new ItemStack(Material.WOOD_HOE);
	    ItemMeta zReaper = Reaper.getItemMeta();
	    zReaper.setDisplayName("§c§nReaper");
	    ArrayList<String> descpyro = new ArrayList<String>();
		descpyro.add(ChatColor.GRAY + "§7§o§n15.000 MCoins");
		zReaper.setLore(descpyro);
	    Reaper.setItemMeta(zReaper);
	    
	    ItemStack Anchor = new ItemStack(Material.ANVIL);
	    ItemMeta zAnchor = Anchor.getItemMeta();
	    zAnchor.setDisplayName("§c§nAnchor");
	    ArrayList<String> descpyros = new ArrayList<String>();
		descpyros.add(ChatColor.GRAY + "§7§o§n15.000 MCoins");
		zAnchor.setLore(descpyros);
	    Anchor.setItemMeta(zAnchor);
		
	    ItemStack Critical = new ItemStack(Material.GOLDEN_APPLE);
	    ItemMeta zCritical = Critical.getItemMeta();
	    zCritical.setDisplayName("§c§nCritical");
	    ArrayList<String> v = new ArrayList<String>();
		v.add(ChatColor.GRAY + "§7§o§n15.000 MCoins");
		zCritical.setLore(v);
	    Critical.setItemMeta(zCritical);
	    
	    ItemStack Ninja = new ItemStack(Material.NETHER_STAR);
	    ItemMeta zNinja = Ninja.getItemMeta();
	    zNinja.setDisplayName("§c§nAjnin");
	    ArrayList<String> n = new ArrayList<String>();
		n.add(ChatColor.GRAY + "§7§o§n20.000 MCoins");
		zNinja.setLore(n);
	    Ninja.setItemMeta(zNinja);
	    
	    ItemStack Grappler = new ItemStack(Material.LEASH);
	    ItemMeta zGrappler = Grappler.getItemMeta();
	    zGrappler.setDisplayName("§c§nGrappler");
	    ArrayList<String> g = new ArrayList<String>();
		g.add(ChatColor.GRAY + "§7§o§n25.000 MCoins");
		zGrappler.setLore(g);
	    Grappler.setItemMeta(zGrappler);
	    
	    ItemStack Thor = new ItemStack(Material.WOOD_AXE);
	    ItemMeta zThor = Thor.getItemMeta();
	    zThor.setDisplayName("§c§nThor");
	    ArrayList<String> t = new ArrayList<String>();
		t.add(ChatColor.GRAY + "§7§o§n20.000 MCoins");
		zThor.setLore(t);
	    Thor.setItemMeta(zThor);
	    
	    ItemStack Negresco = new ItemStack(Material.COAL_BLOCK);
	    ItemMeta zNegresco = Negresco.getItemMeta();
	    zNegresco.setDisplayName("§c§nNegresco");
	    ArrayList<String> ne = new ArrayList<String>();
		ne.add(ChatColor.GRAY + "§7§o§n15.000 MCoins");
		zNegresco.setLore(ne);
	    Negresco.setItemMeta(zNegresco);
	    
	    inv.setItem(0, vidro1);
	    inv.setItem(1, vidro1);
	    inv.setItem(2, vidro1);
	    inv.setItem(3, vidro1);
	    inv.setItem(4, vidro1);
	    inv.setItem(5, vidro1);
	    inv.setItem(6, vidro);
	    inv.setItem(7, vidro);
	    inv.setItem(8, vidro);
	    inv.setItem(9, vidro1);
	    inv.setItem(10, vidro1);
	    inv.setItem(11, Anchor);
	    inv.setItem(12, Ninja);
	    inv.setItem(13, Grappler);
	    inv.setItem(14, Thor);
	    inv.setItem(15, Negresco);
	    inv.setItem(16, vidro);
	    inv.setItem(17, vidro);
	    inv.setItem(18, vidro1);
	    inv.setItem(19, vidro1);
	    inv.setItem(20, vidro1);
	    inv.setItem(21, vidro1);
	    inv.setItem(22, vidro);
	    inv.setItem(23, vidro);
	    inv.setItem(24, vidro);
	    inv.setItem(25, vidro);
	    inv.setItem(26, vidro);
	
	p.openInventory(inv);
	return false;
	
  }
	@SuppressWarnings("deprecation")
	@EventHandler
	  public void click(InventoryClickEvent e)
	  {
	    Player p = (Player)e.getWhoClicked();
	    if (e.getInventory().getTitle().equals("§c§nLoja de Kits")) {
	      if (e.getCurrentItem().getType() == Material.getMaterial(160)) {
	        e.setCancelled(true);
	        return;
	      }

	      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lEXTREMEPVP")) {
	        e.setCancelled(true);
	        p.closeInventory();
	        return;
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§nAnchor")) {
	    	  e.setCancelled(true);
	  	        p.closeInventory();
	  	        if (!p.hasPermission("kit.Anchor")) {
	  	            if (Dinheiro.getMoney(p) >= 15000) {
	  	                Sucesso(p, "Anchor");
	  	                Dinheiro.removeMoney(p, 15000);
	  	          } else {
	  	        	  MoneyErro(p, "Anchor", 15000);
	  	            return;
	  	          }
	  	        } else {
	  	          Jatem(p);
	          return;
	        }
	        return;
	      }

	      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§nAjnin")) {
	    	  e.setCancelled(true);
	  	        p.closeInventory();
	  	        if (!p.hasPermission("kit2.ajnin")) {
	  	            if (Dinheiro.getMoney(p) >= 20000) {
	  	                Sucesso(p, "Ninja");
	  	                Dinheiro.removeMoney(p, 20000);
	  	          } else {
	  	        	  MoneyErro(p, "Ninja", 20000);
	  	            return;
	  	          }
	  	        } else {
	  	          Jatem(p);
	          return;
	        }
	        return;
	      }

	      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§nReaper")) {
	    	  e.setCancelled(true);
	  	        p.closeInventory();
	  	        if (!p.hasPermission("kit.Reaper")) {
	  	            if (Dinheiro.getMoney(p) >= 15000) {
	  	                Sucesso(p, "Reaper");
	  	                Dinheiro.removeMoney(p, 15000);
	  	          } else {
	  	        	  MoneyErro(p, "Reaper", 15000);
	  	            return;
	  	          }
	  	        } else {
	  	          Jatem(p);
	          return;
	        }
	        return;
	      }

	      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§nGrappler")) {
	    	  e.setCancelled(true);
	  	        p.closeInventory();
	  	        if (!p.hasPermission("kit.Grappler")) {
	  	            if (Dinheiro.getMoney(p) >= 25000) {
	  	                Sucesso(p, "Grappler");
	  	                Dinheiro.removeMoney(p, 25000);
	  	          } else {
	  	        	  MoneyErro(p, "Grappler", 25000);
	  	            return;
	  	          }
	  	        } else {
	  	          Jatem(p);
	          return;
	        }
	        return;
	      }
	      
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§nNegresco")) {
	    	  e.setCancelled(true);
	  	        p.closeInventory();
	  	        if (!p.hasPermission("kit.Negresco")) {
	  	            if (Dinheiro.getMoney(p) >= 15000) {
	  	                Sucesso(p, "Negresco");
	  	                Dinheiro.removeMoney(p, 15000);
	  	          } else {
	  	        	  MoneyErro(p, "Negresco", 15000);
	  	            return;
	  	          }
	  	        } else {
	  	          Jatem(p);
		          return;
		        }
		        return;
		      }
	      
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§nThor")) {
	  	        e.setCancelled(true);
	  	        p.closeInventory();
	  	        if (!p.hasPermission("kit.Thor")) {
	  	            if (Dinheiro.getMoney(p) >= 20000) {
	  	                Sucesso(p, "Thor");
	  	                Dinheiro.removeMoney(p, 20000);
	  	          } else {
	  	        	  MoneyErro(p, "Thor", 20000);
	  	            return;
	  	          }
	  	        } else {
	  	          Jatem(p);
	          return;
	        }
	        return;
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§nCritical")) {
	        e.setCancelled(true);
	        p.closeInventory();
	        if (!p.hasPermission("kit.Critical")) {
	            if (Dinheiro.getMoney(p) >= 15000) {
	                Sucesso(p, "Critical");
	                Dinheiro.removeMoney(p, 15000);
	          } else {
	        	  MoneyErro(p, "Critical", 15000);
	            return;
	          }
	        } else {
	          Jatem(p);
	          return;
	        }
	        return;
	      }
	    }
	  }
}
