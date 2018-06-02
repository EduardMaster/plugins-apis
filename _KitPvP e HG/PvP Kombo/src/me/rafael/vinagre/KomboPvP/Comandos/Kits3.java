

	package me.rafael.vinagre.KomboPvP.Comandos;
	
	

		
		
	import java.util.ArrayList;

import tk.Killman96.main.Stats;

	import org.bukkit.Bukkit;
	import org.bukkit.Location;
	import org.bukkit.Material;
	import org.bukkit.Sound;
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

import Scoreboard.Genocida;
import XP.XpM;
import me.rafael.vinagre.KomboPvP.Listeners.Eventos;

	public class Kits3
	  implements Listener, CommandExecutor
	{
	  @EventHandler
	  public void warps(InventoryClickEvent e)
	  {
	    if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null))
	    {
	      Inventory inv = e.getInventory();
	      Player p = (Player)e.getWhoClicked();
	      if (inv.getTitle().equals("§cKits [3]"))
	      {
	        p.playSound(p.getLocation(), Sound.DOOR_CLOSE, 5.0F, 5.0F);
	        e.setCancelled(true);
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Pagina anterior")) {
	          Bukkit.dispatchCommand(p, "kits");
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lDeshfire"))
	        {
	          Bukkit.dispatchCommand(p, "deshfire");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lNoFall"))
	        {
	        	 Bukkit.dispatchCommand(p, "nofall");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lSonic"))
	        {
	        	 Bukkit.dispatchCommand(p, "sonic");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lSubzero"))
	        {
	        	 Bukkit.dispatchCommand(p, "subzero");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lAlladin"))
	        {
	        	 Bukkit.dispatchCommand(p, "alladin");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lAvatar"))
	        {
	        	 Bukkit.dispatchCommand(p, "avatar");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lTeleporter"))
	        {
	        	 Bukkit.dispatchCommand(p, "teleporter");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lDoubleJump"))
	        {
	        	 Bukkit.dispatchCommand(p, "doublejump");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lBurstmaster"))
	        {
	          Bukkit.dispatchCommand(p, "burstmaster");
	          p.closeInventory();
	        }
	      
	        
	          if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aSeus Status")){
	        	  p.sendMessage("§cKills: " + Genocida.getKills(p));
		    	  p.sendMessage("§cDeaths: " + Genocida.getDeaths(p));
		    	  p.sendMessage("§cXp: " + XpM.getPlayerMoney(p));
		    	  p.closeInventory();
		    	  if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aLoja")) {
			          Bukkit.dispatchCommand(p, "loja");
		      }
	        
	      
	      
	      }
	    }
	    }
	    }
	  
	  
	  public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args)
	  {
	    if (!(sender instanceof Player)) {
	      return true;
	    }
	    Player p = (Player)sender;
	    if (cmd.getName().equalsIgnoreCase("kits3"))
	    {
	      Inventory kits = Bukkit.createInventory(p, 54, "§cKits [3]");
	      
	      ItemStack vidro = new ItemStack(Material.THIN_GLASS);
	      ItemMeta vidro2 = vidro.getItemMeta();
	      vidro2.setDisplayName("§c[!]");
	      vidro.setItemMeta(vidro2);
	      
	      ItemStack vidrob = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)7);
	      ItemMeta vidrob2 = vidrob.getItemMeta();
	      
	      vidrob2.setDisplayName(" ");
	      vidrob.setItemMeta(vidrob2);
	      
	      ItemStack vidroc = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)4);
			ItemMeta vidroc2 = vidroc.getItemMeta();
			vidroc2.setDisplayName(" ");
			vidroc.setItemMeta(vidroc2);
	      
	      ItemStack loja = new ItemStack(Material.GOLD_INGOT);
	      ItemMeta loja2 = loja.getItemMeta();
	      loja2.setDisplayName("§aLoja");
	      loja.setItemMeta(loja2);
	      
	      ItemStack status = new ItemStack(Material.SKULL_ITEM);
	      ItemMeta status2 = status.getItemMeta();
	      status2.setDisplayName("§aSeus Status");
	      status.setItemMeta(status2);
	      
	      ItemStack voltar = new ItemStack(Material.INK_SACK, 1, (short)8);
	      ItemMeta voltar2 = voltar.getItemMeta();
	      voltar2.setDisplayName("§7Pagina anterior");
	      voltar.setItemMeta(voltar2);
	      
	      kits.setItem(0, voltar);
	      kits.setItem(1, vidrob);
	      kits.setItem(2, loja);
	      kits.setItem(3, vidrob);
	      kits.setItem(4, status);
	      kits.setItem(5, vidrob);
	      kits.setItem(6, loja);
	      kits.setItem(7, vidrob);
	      kits.setItem(8, voltar);
	     
	      if (p.hasPermission("kitpvp.kit.burstmaster"))
	      {
	        ItemStack pyro = new ItemStack(Material.GOLD_HOE);
	        ItemMeta metapyro = pyro.getItemMeta();
	        metapyro.setDisplayName("§7Kit §e§lBurstmaster");
	        ArrayList indiob = new ArrayList();
	        indiob.add("§7Cause explosoes");
	        indiob.add("§7com sua foice");
	        metapyro.setLore(indiob);
	        pyro.setItemMeta(metapyro);
	        
	        kits.addItem(new ItemStack[] { pyro });
	      }
	      if (p.hasPermission("kitpvp.kit.nofall"))
	      {
	        ItemStack pyro = new ItemStack(Material.FEATHER);
	        ItemMeta metapyro = pyro.getItemMeta();
	        metapyro.setDisplayName("§7Kit §e§lNoFall");
	        ArrayList indiob = new ArrayList();
	        indiob.add("§7Nao leve dano de queda");
	        
	        metapyro.setLore(indiob);
	        pyro.setItemMeta(metapyro);
	        
	        kits.addItem(new ItemStack[] { pyro });
	      }
	      if (p.hasPermission("kitpvp.kit.teleporter"))
	      {
	        ItemStack pyro = new ItemStack(Material.BOW);
	        ItemMeta metapyro = pyro.getItemMeta();
	        metapyro.setDisplayName("§7Kit §e§lTeleporter");
	        ArrayList indiob = new ArrayList();
	        indiob.add("§7Aonde a flecha cair");
	        indiob.add("§7Vc sera teleportado");
	        metapyro.setLore(indiob);
	        pyro.setItemMeta(metapyro);
	        
	        kits.addItem(new ItemStack[] { pyro });
	      }
	      if (p.hasPermission("kitpvp.kit.subzero"))
	      {
	        ItemStack pyro = new ItemStack(Material.PACKED_ICE);
	        ItemMeta metapyro = pyro.getItemMeta();
	        metapyro.setDisplayName("§7Kit §e§lSubzero");
	        ArrayList indiob = new ArrayList();
	        indiob.add("§7Seja o subzero");
	        indiob.add("§7E solte um gelo congelante");
	        metapyro.setLore(indiob);
	        pyro.setItemMeta(metapyro);
	        
	        kits.addItem(new ItemStack[] { pyro });
	      }
	      if (p.hasPermission("kitpvp.kit.sonic"))
	      {
	        ItemStack pyro = new ItemStack(Material.LAPIS_BLOCK);
	        ItemMeta metapyro = pyro.getItemMeta();
	        metapyro.setDisplayName("§7Kit §e§lSonic");
	        ArrayList indiob = new ArrayList();
	        indiob.add("§7De um desh");
	        indiob.add("§7E bote veneno");
	        metapyro.setLore(indiob);
	        pyro.setItemMeta(metapyro);
	        
	        kits.addItem(new ItemStack[] { pyro });
	      }
	      if (p.hasPermission("kitpvp.kit.avatar"))
	      {
	        ItemStack pyro = new ItemStack(Material.BEACON);
	        ItemMeta metapyro = pyro.getItemMeta();
	        metapyro.setDisplayName("§7Kit §e§lAvatar");
	        ArrayList indiob = new ArrayList();
	        indiob.add("§7Controle os 4");
	        indiob.add("§7Elementos");
	        metapyro.setLore(indiob);
	        pyro.setItemMeta(metapyro);
	        
	        kits.addItem(new ItemStack[] { pyro });
	      }
	      if (p.hasPermission("kitpvp.kit.doublejump"))
	      {
	        ItemStack pyro = new ItemStack(Material.CHAINMAIL_BOOTS);
	        ItemMeta metapyro = pyro.getItemMeta();
	        metapyro.setDisplayName("§7Kit §e§lDoubleJump");
	        ArrayList indiob = new ArrayList();
	        indiob.add("§7De pulos duplos");
	        indiob.add("§7Apertando espaço");
	        metapyro.setLore(indiob);
	        pyro.setItemMeta(metapyro);
	        
	        kits.addItem(new ItemStack[] { pyro });
	      }
	      if (p.hasPermission("kitpvp.kit.alladin"))
	      {
	        ItemStack pyro = new ItemStack(Material.CARPET);
	        ItemMeta metapyro = pyro.getItemMeta();
	        metapyro.setDisplayName("§7Kit §e§lAlladin");
	        ArrayList indiob = new ArrayList();
	        indiob.add("§7Seja o alladin");
	        indiob.add("§7E voe com seu tapete magico");
	        metapyro.setLore(indiob);
	        pyro.setItemMeta(metapyro);
	        
	        kits.addItem(new ItemStack[] { pyro });
	      }
	      if (p.hasPermission("kitpvp.kit.deshfire"))
	      {
	        ItemStack pyro = new ItemStack(Material.REDSTONE_BLOCK);
	        ItemMeta metapyro = pyro.getItemMeta();
	        metapyro.setDisplayName("§7Kit §e§lDeshfire");
	        ArrayList indiob = new ArrayList();
	        indiob.add("§7De um desh");
	        indiob.add("§7e bote fogo!");
	        metapyro.setLore(indiob);
	        pyro.setItemMeta(metapyro);
	        
	        
	        kits.addItem(new ItemStack[] { pyro });
	        
	      
	     
              
           
           
	    
	          
	  			
	     
	          }
				ItemStack[] arrayOfItemStack;
			    int descpyro1 = (arrayOfItemStack = kits.getContents()).length;
			    for (int metapyro1 = 0; metapyro1 < descpyro1; metapyro1++)
			    {
			      ItemStack item = arrayOfItemStack[metapyro1];
			      if (item == null) {
			        kits.setItem(kits.firstEmpty(), vidro);
			      }
			    }
	      
	        
	      p.openInventory(kits);
	      return false;
	    }
		return false;
	    
	  } {
		
	} {
		
	    } {
		
	  } {
		
		
	  } {
		
	} {

	}
	}

