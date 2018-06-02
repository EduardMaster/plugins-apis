package me.rafael.vinagre.KomboPvP.Comandos;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
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

public class Warps 
implements Listener, CommandExecutor
{
	
	@EventHandler
	public void warps(InventoryClickEvent e)
	{
	  if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null))
	  {
	    Inventory inv = e.getInventory();
	    Player p = (Player)e.getWhoClicked();
	    if (inv.getTitle().equals("§nWarps"))
	    {
	      p.playSound(p.getLocation(), Sound.DOOR_CLOSE, 5.0F, 5.0F);
	      e.setCancelled(true);
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aEventos")){
	    	  Bukkit.dispatchCommand(p, "eventos");
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6FPS")){
	    	  Bukkit.dispatchCommand(p, "warp fps");
	    	  p.closeInventory();
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6Lava Challenge")){
	    	  Bukkit.dispatchCommand(p, "warp challenge");
	    	  p.closeInventory();
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6Main")){
	    	  Bukkit.dispatchCommand(p, "warp main");
	    	  p.closeInventory();
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6KNOCK")){
	    	  Bukkit.dispatchCommand(p, "warp knock");
	    	  p.closeInventory();
	      }
	      
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§61v1")){
	    	  Bukkit.dispatchCommand(p, "1v1");
	    	  p.closeInventory();
	      }
	    }
	  }
	}
	    
	    @EventHandler
		public void eventos(InventoryClickEvent e)
		{
		  if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null))
		  {
		    Inventory inv = e.getInventory();
		    Player p = (Player)e.getWhoClicked();
		    if (inv.getTitle().equals("§nEventos"))
		    {
		      p.playSound(p.getLocation(), Sound.DOOR_CLOSE, 5.0F, 5.0F);
		      e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aWarps")){
			Bukkit.dispatchCommand(p, "warps");
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6RDM")){
			Bukkit.dispatchCommand(p, "warp rdm");
			p.closeInventory();
			}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6Sobrevivente")){
			Bukkit.dispatchCommand(p, "sobrevivente");
			p.closeInventory();
			}
			
				
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6MDR")){
			Bukkit.dispatchCommand(p, "warp mdr");
			p.closeInventory();
			}
		}
	}
		  }

	
	public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args) {
		if(!(sender instanceof Player)){
			return true;
		}
		Player p = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("warps")){
			
			Inventory warps = Bukkit.createInventory(p, 27, "§nWarps");
			
			ItemStack passar = new ItemStack(Material.WOOD_BUTTON);
			ItemMeta passar2 = passar.getItemMeta();
			passar2.setDisplayName("§aEventos");
			passar.setItemMeta(passar2);
			
			ItemStack vidrol = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)13);
			ItemMeta vidrol2 = vidrol.getItemMeta();
			vidrol2.setDisplayName(" ");
			vidrol.setItemMeta(vidrol2);
			
			ItemStack vidroa = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)14);
			ItemMeta vidroa2 = vidroa.getItemMeta();
			vidroa2.setDisplayName(" ");
			vidroa.setItemMeta(vidroa2);
			
			ItemStack fps = new ItemStack(Material.GLASS);
			ItemMeta fps2 = fps.getItemMeta();
			fps2.setDisplayName("§6FPS");
			List<String> lore1 = new ArrayList();
			lore1.add("§7Warp para aumentar o FPS do seu mine !");
			fps2.setLore(lore1);
			fps.setItemMeta(fps2);
			
			ItemStack lava = new ItemStack(Material.LAVA_BUCKET);
			ItemMeta lava2 = lava.getItemMeta();
			lava2.setDisplayName("§6Lava Challenge");
			List<String> lore2 = new ArrayList();
			lore2.add("§7Treine seu refil e recraft nesta warp !");
			lava2.setLore(lore2);
			lava.setItemMeta(lava2);
			
			ItemStack kb = new ItemStack(Material.STICK);
			ItemMeta kb1 = kb.getItemMeta();
			kb1.setDisplayName("§6KNOCK");
			List<String> lore71 = new ArrayList();
			lore71.add("§6Treine com kb alto !");
			kb1.setLore(lore71);
			kb.setItemMeta(kb1);
			
			ItemStack mb = new ItemStack(Material.POTION);
			ItemMeta mb1 = mb.getItemMeta();
			mb1.setDisplayName("§6Main");
			List<String> lore72 = new ArrayList();
			lore72.add("§2Treine com efeitos ops nessa warp !");
			mb1.setLore(lore72);
			mb.setItemMeta(mb1);
			
			ItemStack v1 = new ItemStack(Material.BLAZE_ROD);
			ItemMeta v12 = v1.getItemMeta();
			v12.setDisplayName("§61v1");
			List<String> lore3 = new ArrayList();
			lore3.add("§7Tire um x1 com outros jogadores !");
			v12.setLore(lore3);
			v1.setItemMeta(v12);
			
			warps.setItem(0, vidrol);
			warps.setItem(1, vidroa);
			warps.setItem(2, vidrol);
			warps.setItem(3, vidroa);
			warps.setItem(4, vidrol);
			warps.setItem(5, vidroa);
			warps.setItem(6, vidrol);
			warps.setItem(7, vidroa);
			warps.setItem(8, passar);
			warps.setItem(9, vidroa);
			warps.setItem(10, vidrol);
			warps.setItem(11, mb);
			warps.setItem(12, fps);
			warps.setItem(13, lava);
			warps.setItem(14, v1);
			warps.setItem(15, kb);
			warps.setItem(16, vidroa);
			warps.setItem(17, vidrol);
			warps.setItem(18, vidroa);
			warps.setItem(19, vidrol);
			warps.setItem(20, vidroa);
			warps.setItem(21, vidrol);
			warps.setItem(22, vidroa);
			warps.setItem(23, vidrol);
			warps.setItem(24, vidroa);
			warps.setItem(25, vidrol);
			warps.setItem(26, vidroa);
			
			
			p.openInventory(warps);
		}
		if(cmd.getName().equalsIgnoreCase("eventos")){
			
			Inventory eventos = Bukkit.createInventory(p, 27, "§nEventos");
			
			ItemStack voltar = new ItemStack(Material.STONE_BUTTON);
			ItemMeta voltar2 = voltar.getItemMeta();
			voltar2.setDisplayName("§aWarps");
			voltar.setItemMeta(voltar2);
			
			ItemStack vidrol = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)13);
			ItemMeta vidrol2 = vidrol.getItemMeta();
			vidrol2.setDisplayName(" ");
			vidrol.setItemMeta(vidrol2);
			
			ItemStack vidroa = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)14);
			ItemMeta vidroa2 = vidroa.getItemMeta();
			vidroa2.setDisplayName(" ");
			vidroa.setItemMeta(vidroa2);
			
			ItemStack rdm = new ItemStack(Material.WORKBENCH);
			ItemMeta rdm2 = rdm.getItemMeta();
			rdm2.setDisplayName("§6RDM");
			List<String> lore1 = new ArrayList();
			lore1.add("§7Evento RDM");
			rdm2.setLore(lore1);
			rdm.setItemMeta(rdm2);
			
			ItemStack sobrevivente = new ItemStack(Material.TNT);
			ItemMeta sobrevivente2 = sobrevivente.getItemMeta();
			sobrevivente2.setDisplayName("§6Sobrevivente");
			List<String> lore2 = new ArrayList();
			lore2.add("§7Evento Sobrevivente !");
			sobrevivente2.setLore(lore2);
			sobrevivente.setItemMeta(sobrevivente2);
			
			ItemStack mdr = new ItemStack(Material.CAKE);
			ItemMeta mdr2 = mdr.getItemMeta();
			mdr2.setDisplayName("§6MDR");
			List<String> lore3 = new ArrayList();
			lore3.add("§7Evento MDR");
			lore3.add("");
			mdr2.setLore(lore3);
			mdr.setItemMeta(mdr2);
			
			eventos.setItem(0, voltar);
			eventos.setItem(1, vidroa);
			eventos.setItem(2, vidrol);
			eventos.setItem(3, vidroa);
			eventos.setItem(4, vidrol);
			eventos.setItem(5, vidroa);
			eventos.setItem(6, vidrol);
			eventos.setItem(7, vidroa);
			eventos.setItem(8, vidrol);
			eventos.setItem(9, vidroa);
			eventos.setItem(10, vidrol);
			eventos.setItem(11, vidroa);
			eventos.setItem(12, rdm);
			eventos.setItem(13, sobrevivente);
			eventos.setItem(14, mdr);
			eventos.setItem(15, vidroa);
			eventos.setItem(16, vidrol);
			eventos.setItem(17, vidroa);
			eventos.setItem(18, vidrol);
			eventos.setItem(19, vidroa);
			eventos.setItem(20, vidrol);
			eventos.setItem(21, vidroa);
			eventos.setItem(22, vidrol);
			eventos.setItem(23, vidroa);
			eventos.setItem(24, vidrol);
			eventos.setItem(25, vidroa);
			eventos.setItem(26, vidrol);
			
			p.openInventory(eventos);
		}
		return true;
	}
}